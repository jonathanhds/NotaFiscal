import java.util.Calendar;

public class GeradorNotaFiscal {

    private RepositorioNF repositorioNF;

    private SAP sap;

    public GeradorNotaFiscal(RepositorioNF repositorioNF, SAP sap) {
        this.repositorioNF = repositorioNF;
        this.sap = sap;
    }

    public NotaFiscal gerar(Pedido pedido) {
        NotaFiscal nf = new NotaFiscal(
                pedido.getCliente(),
                pedido.getValorTotal() * 0.94,
                Calendar.getInstance()
        );

        this.repositorioNF.persistir(nf);

        this.sap.enviar(nf);

        return nf;
    }

}
