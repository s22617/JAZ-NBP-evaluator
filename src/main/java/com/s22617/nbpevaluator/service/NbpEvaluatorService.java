package com.s22617.nbpevaluator.service;

import com.s22617.nbpevaluator.model.FetchedNbpResponse;
import com.s22617.nbpevaluator.model.NbpRequest;
import com.s22617.nbpevaluator.model.Rate;
import com.s22617.nbpevaluator.repository.NbpEvaluatorRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class NbpEvaluatorService {

    private final NbpEvaluatorRepository nbpEvaluatorRepository;

    private final RestTemplate restTemplate;

    private final static String url = "http://api.nbp.pl/api/exchangerates/rates/a/";

    public NbpEvaluatorService(NbpEvaluatorRepository nbpEvaluatorRepository, RestTemplate restTemplate) {
        this.nbpEvaluatorRepository = nbpEvaluatorRepository;
        this.restTemplate = restTemplate;
    }

    private Double getAverage(FetchedNbpResponse response) {
        double summedRates = 0d;
        for (Rate rate : response.getRates()) {
            summedRates += rate.getMid();
        }
        return summedRates / response.getRates().size();
    }

    public Double getAverageExchangeRate(String currency, Integer days) {

        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(days);
        Date date = Date.valueOf(LocalDate.now());

        String finalUrl = url + currency + "/" + startDate.toString() + "/" + endDate.toString();

        ResponseEntity<FetchedNbpResponse> response = restTemplate.exchange(finalUrl, HttpMethod.GET, null, FetchedNbpResponse.class);
        FetchedNbpResponse fetchedNbpResponse = response.getBody();

        LocalDateTime currentDate = LocalDateTime.now();

        double averageExchangeRate = getAverage(fetchedNbpResponse);

        NbpRequest nbpRequest = new NbpRequest(null, fetchedNbpResponse.getCurrency(), days, getAverage(fetchedNbpResponse), currentDate);
        nbpEvaluatorRepository.save(nbpRequest);

        return averageExchangeRate;
    }
}
