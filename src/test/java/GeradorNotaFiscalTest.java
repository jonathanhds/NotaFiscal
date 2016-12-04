import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GeradorNotaFiscalTest {

    @Test
    public void deveGerarNFComImpostoDescontado() {
        // Given
        Pedido pedido = new Pedido("Jonathan", 1000.0, 1);

        // When
        NotaFiscal nf = new GeradorNotaFiscal(new RepositorioNFMock(), new SAPMock()).gerar(pedido);

        // Then
        assertEquals(940.0, nf.getValor(), 0.00001);
    }

    @Test
    public void devePersistirNotaFiscalNoBancoDeDados() {
        // Given
        Pedido pedido = new Pedido("Jonathan", 1000.0, 1);
        RepositorioNFMock repositorioNF = new RepositorioNFMock();

        // When
        new GeradorNotaFiscal(repositorioNF, new SAPMock()).gerar(pedido);

        // Then
        assertTrue(repositorioNF.salvouNotaFiscal());
    }

    @Test
    public void deveEnviarNotaFiscalParaSistemaSAP() {
        // Given
        Pedido pedido = new Pedido("Jonathan", 1000.0, 1);
        SAPMock sap = new SAPMock();

        // When
        new GeradorNotaFiscal(new RepositorioNFMock(), sap).gerar(pedido);

        // Then
        assertTrue(sap.enviouNotaFiscal());
    }

}
