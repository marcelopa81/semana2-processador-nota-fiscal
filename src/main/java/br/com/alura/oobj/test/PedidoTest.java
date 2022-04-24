package br.com.alura.oobj.test;

import br.com.alura.oobj.application.ItemPedido;
import br.com.alura.oobj.application.Pedido;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;


class PedidoTest {

    private List<ItemPedido> itens = new ArrayList<>();
    Pedido pedido = new Pedido();

    @Test
    void totalDoPedidoComApenasUmItemDeveSerTotalDoProduto() {

        CriaListaComUmItem();
        pedido.getTotal();
        assertEquals(new BigDecimal(43.8).setScale(2, RoundingMode.HALF_UP), pedido.getTotal());

    }

    @Test
    void totalDoPedidoComDoisItensDeveSerASomaDosSubtotaisDeCadaProduto() {

        CriaListaComDoistens();
        pedido.getTotal();
        assertEquals(new BigDecimal(41.7).setScale(2, RoundingMode.HALF_UP), pedido.getTotal());

    }

    @Test
     void lancarExcecaoParaListaVazia(){
            CriaListaNulla();
            assertThrows(IllegalStateException.class, ()-> pedido.getTotal());
    }


    public void CriaListaComUmItem() {

        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setCodigo(7L);
        itemPedido.setDescricao("Yakimeshi");
        itemPedido.setQuantidade(2);
        itemPedido.setValorUnitario(BigDecimal.valueOf(21.9).setScale(2, RoundingMode.HALF_UP));
        itemPedido.setClasseFiscal("2202.10.00");

        itens.add(itemPedido);
        pedido.setItens(itens);

    }
    public void CriaListaComDoistens() {

        ItemPedido itemPedido1 = new ItemPedido();
        itemPedido1.setCodigo(2L);
        itemPedido1.setDescricao("Rolinho Primavera");
        itemPedido1.setQuantidade(2);
        itemPedido1.setValorUnitario(BigDecimal.valueOf(9.9).setScale(2, RoundingMode.HALF_UP));
        itemPedido1.setClasseFiscal("2106.90.90");

        ItemPedido itemPedido2 = new ItemPedido();
        itemPedido2.setCodigo(7L);
        itemPedido2.setDescricao("Yakimeshi");
        itemPedido2.setQuantidade(1);
        itemPedido2.setValorUnitario(BigDecimal.valueOf(21.9).setScale(2, RoundingMode.HALF_UP));
        itemPedido2.setClasseFiscal("2202.10.00");

        itens.add(itemPedido1);
        itens.add(itemPedido2);
        pedido.setItens(itens);

    }

    public void CriaListaNulla(){
        itens.add(null);
        pedido.setItens(null);
    }

}