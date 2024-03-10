package it.bootcamp.ejerciciotesters.service;

import it.bootcamp.ejerciciotesters.dto.TestCaseDTO;
import it.bootcamp.ejerciciotesters.dto.request.CreateTestCaseDTO;
import it.bootcamp.ejerciciotesters.dto.request.UpdateTestCaseDTO;
import it.bootcamp.ejerciciotesters.dto.response.MessageDTO;

import java.util.List;

public interface ITestCaseService {
    TestCaseDTO create(CreateTestCaseDTO request);
    List<TestCaseDTO> getAll();
    TestCaseDTO getById(Long id);
    List<TestCaseDTO> getByLastUpdate(String lastUpdate);
    TestCaseDTO updateById(Long id, UpdateTestCaseDTO request);
    MessageDTO delete(Long id);
}
