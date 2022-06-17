package com.s22617.nbpevaluator.controller;

import com.s22617.nbpevaluator.model.NbpRequest;
import com.s22617.nbpevaluator.service.NbpEvaluatorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("nbp-evaluator")
public class NbpEvaluatorController {

    private final NbpEvaluatorService nbpEvaluatorService;

    public NbpEvaluatorController(NbpEvaluatorService nbpEvaluatorService) {
        this.nbpEvaluatorService = nbpEvaluatorService;
    }

    @GetMapping("average-rate/{currency}")
    @ApiOperation(value = "Get an average currency exchange rate", notes = "Need to provide currency code and can provide amount of days")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD_REQUEST"),
            @ApiResponse(code = 404, message = "NOT_FOUND")
    })
    public ResponseEntity<Double> getAverageExchangeRate(
            @ApiParam(value = "Currency code", example = "usd") @PathVariable String currency,
            @ApiParam(value = "Number of days to calculate average exchange rate from", example = "5") @RequestParam(required = false) Optional<Integer> days) {
        return ResponseEntity.ok(nbpEvaluatorService.getAverageExchangeRate(currency, days.orElse(1)));
    }
}
