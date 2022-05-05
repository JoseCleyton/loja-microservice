package com.br.alura.loja.services;

import com.br.alura.loja.clients.ProviderClient;
import com.br.alura.loja.dto.ProviderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

   private final Logger LOG = LoggerFactory.getLogger(StoreService.class);

    @Autowired
    private ProviderClient providerClient;

    public List<ProviderDto> findAllProvidersByStateCode(String stateCode) {
        LOG.info("Buscando todos os fornecedores pelo Estado");
//        ProviderDto[] response = this.restTemplate.getForObject("http://provider/provider/" + stateCode, ProviderDto[].class);
//        return Arrays.asList(response);
        List<ProviderDto> list = this.providerClient.findAll(stateCode);
        System.out.println(list);
        return list;
    }
}
