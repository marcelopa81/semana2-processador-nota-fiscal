package br.com.alura.oobj.test;

import br.com.alura.oobj.application.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

class ProcessadorFonteDadosTest {

    @Test
    void deveRetornarTotalDaListaDePedidos() {

        LeitorFonteDados leitoFonteDados = Mockito.mock(LeitorFonteDados.class);
        ProcessadorFonteDados processadorFonteDados = new ProcessadorFonteDados(leitoFonteDados);

        Mockito.when(leitoFonteDados.recupera(Mockito.anyString())).thenReturn(pedido());

        ResultadoProcessamento resultado = processadorFonteDados.processa(Mockito.anyString());

        Assertions.assertEquals(new BigDecimal("41.7").setScale(2, RoundingMode.HALF_UP), resultado.getTotalPedido());


    }

    public Pedido pedido(){
        Pedido pedido = new Pedido();

        ItemPedido itemPedido1 = new ItemPedido();
        ItemPedido itemPedido2 = new ItemPedido();

        List<ItemPedido> itens = new ArrayList<>();

        itemPedido1.setCodigo(2L);
        itemPedido1.setDescricao("Rolinho Primavera");
        itemPedido1.setQuantidade(2);
        itemPedido1.setValorUnitario(BigDecimal.valueOf(9.9).setScale(2, RoundingMode.HALF_UP));
        itemPedido1.setClasseFiscal("2106.90.90");


        itemPedido2.setCodigo(7L);
        itemPedido2.setDescricao("Yakimeshi");
        itemPedido2.setQuantidade(1);
        itemPedido2.setValorUnitario(BigDecimal.valueOf(21.9).setScale(2, RoundingMode.HALF_UP));
        itemPedido2.setClasseFiscal("2202.10.00");

        itens.add(itemPedido1);
        itens.add(itemPedido2);
        pedido.setItens(itens);

        return pedido;
    }
}