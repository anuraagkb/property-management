package com.anuraagkb.propertymanagement.controller;

import com.anuraagkb.propertymanagement.dto.CalculatorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/calculator")
public class CalculatorController {

    @GetMapping("/add")
    public Double add(@RequestParam("n1") Double num1, @RequestParam("n2") Double num2){
        return num1 + num2;
    }

    @PostMapping("/mul")
    public ResponseEntity<Double> mul(@RequestBody CalculatorDTO calculatorDTO){
        Double result = calculatorDTO.getNum1() * calculatorDTO.getNum2();
        return ResponseEntity.ok(result);
    }

}
