package it.bootcamp.ejerciciotesters.controller;

import it.bootcamp.ejerciciotesters.dto.TestCaseDTO;
import it.bootcamp.ejerciciotesters.dto.request.CreateTestCaseDTO;
import it.bootcamp.ejerciciotesters.dto.request.UpdateTestCaseDTO;
import it.bootcamp.ejerciciotesters.dto.response.MessageDTO;
import it.bootcamp.ejerciciotesters.service.ITestCaseService;
import it.bootcamp.ejerciciotesters.service.TestCaseServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {
    private final ITestCaseService testCaseService;

    public TestCaseController(TestCaseServiceImpl testCaseService) {
        this.testCaseService = testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseDTO> create(
            @RequestBody CreateTestCaseDTO request
    ) {
        return new ResponseEntity<>(testCaseService.create(request), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseDTO>> getAll(
            @RequestParam(required = false) String last_update
    ) {
        if (last_update != null) {
            return new ResponseEntity<>(testCaseService.getByLastUpdate(last_update), HttpStatus.OK);
        }

        return new ResponseEntity<>(testCaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> getById(
            @PathVariable Long id
    ) {
        return new ResponseEntity<>(testCaseService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> update(
            @PathVariable Long id,
            @RequestBody UpdateTestCaseDTO request
    ) {
        return new ResponseEntity<>(testCaseService.updateById(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> delete(
            @PathVariable Long id
    ) {
        return new ResponseEntity<>(testCaseService.delete(id), HttpStatus.OK);
    }
}
