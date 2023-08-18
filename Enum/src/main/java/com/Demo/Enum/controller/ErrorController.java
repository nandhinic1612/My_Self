package com.Demo.Enum.controller;

import com.Demo.Enum.entity.ErrorEntity;
import com.Demo.Enum.entity.ErrorType;
import com.Demo.Enum.repository.ErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ErrorController {
    @Autowired
    private ErrorRepository errorRepository;

    @PostMapping("/create-error")
    public ErrorEntity createError(@RequestBody ErrorEntity errorEntity) {
        return errorRepository.save(errorEntity);
    }

    @GetMapping("/get-error/{id}")
    public String getErrorById(@PathVariable Long id) {
        if (id == 1) {
            return "Item with ID 1";
        }
        return "Item not found";
    }
}