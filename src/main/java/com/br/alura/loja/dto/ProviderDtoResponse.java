package com.br.alura.loja.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ProviderDtoResponse implements Serializable {
    private List<ProviderDto> providerDtos;

    public ProviderDtoResponse() {
        this.providerDtos = new ArrayList<>();
    }
}
