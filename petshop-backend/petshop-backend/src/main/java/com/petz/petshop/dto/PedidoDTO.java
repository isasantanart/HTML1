package com.petz.petshop.dto;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDTO {

    private BigDecimal total;

    private List<PedidoItemDTO> itens;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<PedidoItemDTO> getItens() {
        return itens;
    }

    public void setItens(List<PedidoItemDTO> itens) {
        this.itens = itens;
    }
}