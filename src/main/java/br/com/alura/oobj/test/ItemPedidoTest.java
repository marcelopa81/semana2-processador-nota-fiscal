package br.com.alura.oobj.test;
import br.com.alura.oobj.application.*;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class ItemPedidoTest {

    ItemPedido itemPedido = new ItemPedido();

    @Test
    void valorDoCalculoDoItemComUmaUnidadeDeveSerIgualValorUnitario() {

       itemPedido.setCodigo(7L);
       itemPedido.setDescricao("Yakimeshi");
       itemPedido.setQuantidade(1);
       itemPedido.setValorUnitario(BigDecimal.valueOf(21.9).setScale(2, RoundingMode.HALF_UP));
       itemPedido.getValorUnitario("2202.10.00");

       BigDecimal valor = itemPedido.getSubtotal();

       assertEquals(new BigDecimal("21.9").setScale(2, RoundingMode.HALF_UP) , valor);

        }

    @Test
    void valorDoCalculoDoItemComMaisDeUmaUnidadeDeveSerOValorUnitarioMultiplicadoPelaQuantidade() {

        itemPedido.setCodigo(6L);
        itemPedido.setDescricao("Rolinho Primavera");
        itemPedido.setQuantidade(2);
        itemPedido.setValorUnitario(BigDecimal.valueOf(9.9).setScale(2, RoundingMode.HALF_UP));
        itemPedido.getValorUnitario("2106.90.90");

        BigDecimal valor = itemPedido.getSubtotal();

        assertEquals(new BigDecimal("19.8").setScale(2, RoundingMode.HALF_UP) , valor);
    }
}