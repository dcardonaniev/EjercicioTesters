package it.bootcamp.ejerciciotesters.service;

import it.bootcamp.ejerciciotesters.dto.TestCaseDTO;
import it.bootcamp.ejerciciotesters.dto.request.CreateTestCaseDTO;
import it.bootcamp.ejerciciotesters.dto.request.UpdateTestCaseDTO;
import it.bootcamp.ejerciciotesters.dto.response.MessageDTO;
import it.bootcamp.ejerciciotesters.entity.TestCase;
import it.bootcamp.ejerciciotesters.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TestCaseServiceImpl implements ITestCaseService {
    private final TestCaseRepository testCaseRepository;
    private final ModelMapper modelMapper;

    public TestCaseServiceImpl(
            TestCaseRepository testCaseRepository,
            ModelMapper modelMapper
    ) {
        this.testCaseRepository = testCaseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TestCaseDTO create(CreateTestCaseDTO request) {
        TestCase testCase = modelMapper.map(request, TestCase.class);

        return modelMapper.map(
                testCaseRepository.save(testCase),
                TestCaseDTO.class
        );
    }

    @Override
    public List<TestCaseDTO> getAll() {
        return testCaseRepository.findAll()
                .stream()
                .map(t -> modelMapper.map(t, TestCaseDTO.class))
                .toList();
    }

    @Override
    public TestCaseDTO getById(Long id) {
        return modelMapper.map(testCaseRepository.findById(id), TestCaseDTO.class);
    }

    @Override
    public List<TestCaseDTO> getByLastUpdate(String lastUpdate) {
        LocalDate lastUpdateSearch = LocalDate.parse(lastUpdate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return testCaseRepository.findByLastUpdate(lastUpdateSearch)
                .stream()
                .map(t -> modelMapper.map(t, TestCaseDTO.class))
                .toList();
    }

    @Override
    public TestCaseDTO updateById(Long id, UpdateTestCaseDTO request) {
        TestCase testCase = modelMapper.map(request, TestCase.class);
        testCase.setIdCase(id);

        return modelMapper.map(
                testCaseRepository.save(testCase),
                TestCaseDTO.class
        );
    }

    @Override
    public MessageDTO delete(Long id) {
        testCaseRepository.deleteById(id);

        return new MessageDTO("Test case borrado correctamente");
    }
}
