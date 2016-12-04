public class SAPMock extends SAP {

    private boolean notaFiscaEnviada;

    @Override
    public void enviar(NotaFiscal notaFiscal) {
        // Fazer nada!
        this.notaFiscaEnviada = true;
    }

    public boolean enviouNotaFiscal() {
        return this.notaFiscaEnviada;
    }

}
