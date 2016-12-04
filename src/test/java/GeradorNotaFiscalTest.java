import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GeradorNotaFiscalTest {

    @Test
    public void deveGerarNFComImpostoDescontado() {
        // Given
        Pedido pedido = new Pedido("Jonathan", 1000.0, 1);

        // When
        NotaFiscal nf = new GeradorNotaFiscal().gerar(pedido);

        // Then
        assertEquals(1000 * 0.94, nf.getValor(), 0.00001);
    }

}
