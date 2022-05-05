package com.br.alura.loja.controllers;

import com.br.alura.loja.dto.ProviderDto;
import com.br.alura.loja.services.StoreService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/store")
public class StoreController {
    private final Logger LOG = LoggerFactory.getLogger(StoreService.class);
    private static final String STORE_SERVICE = "storeService";

    @Autowired
    StoreService storeService;

    @GetMapping("/provider")
    @Bulkhead(name = STORE_SERVICE, type = Bulkhead.Type.THREADPOOL)
//    @TimeLimiter(name = STORE_SERVICE, fallbackMethod = "storeServiceFallback")
    @CircuitBreaker(name = STORE_SERVICE, fallbackMethod = "storeServiceFallback")
    public ResponseEntity<List<ProviderDto>> findAllProvidersByStateCode(@RequestParam String stateCode) {
        LOG.info("Recebendo o Estado do Fornecedor");
        return ResponseEntity.ok(this.storeService.findAllProvidersByStateCode(stateCode));
    }

    public ResponseEntity<List<ProviderDto>> storeServiceFallback(String stateCode, TimeoutException rnp) {
        LOG.info("Fallback findAllProvidersByStateCode");
        return ResponseEntity.ok(new ArrayList<>());
    }
}
