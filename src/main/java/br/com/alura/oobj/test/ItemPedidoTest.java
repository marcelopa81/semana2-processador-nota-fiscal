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

       itemPedido.setQuantidade(1);
       itemPedido.setValorUnitario(BigDecimal.valueOf(21.9).setScale(2, RoundingMode.HALF_UP));

       BigDecimal valor = itemPedido.getSubtotal();

       assertEquals(new BigDecimal("21.9").setScale(2, RoundingMode.HALF_UP) , valor);

        }

    @Test
    void valorDoCalculoDoItemComMaisDeUmaUnidadeDeveSerOValorUnitarioMultiplicadoPelaQuantidade() {

        itemPedido.setQuantidade(2);
        itemPedido.setValorUnitario(BigDecimal.valueOf(9.9).setScale(2, RoundingMode.HALF_UP));

        BigDecimal valor = itemPedido.getSubtotal();

        assertEquals(new BigDecimal("19.8").setScale(2, RoundingMode.HALF_UP) , valor);
    }
}