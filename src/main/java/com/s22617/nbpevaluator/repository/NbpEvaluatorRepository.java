package com.s22617.nbpevaluator.repository;

import com.s22617.nbpevaluator.model.NbpRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NbpEvaluatorRepository extends JpaRepository<NbpRequest, Integer> {
}
