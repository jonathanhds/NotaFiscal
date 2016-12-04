public class RepositorioNFMock extends RepositorioNF {

    private boolean salvouNotaFiscal;

    @Override
    public void persistir(NotaFiscal notaFiscal) {
        // Fazer nada!
        this.salvouNotaFiscal = true;
    }

    public boolean salvouNotaFiscal() {
        return this.salvouNotaFiscal;
    }
}
