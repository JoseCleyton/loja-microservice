package com.br.alura.loja.clients;

import com.br.alura.loja.dto.ProviderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("provider")
public interface ProviderClient {

    @GetMapping("/provider/{stateCode}")
    List<ProviderDto> findAll(@PathVariable String stateCode);
}
