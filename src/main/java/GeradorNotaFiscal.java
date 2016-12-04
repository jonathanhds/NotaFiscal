import java.util.Calendar;

public class GeradorNotaFiscal {

    private RepositorioNF repositorioNF;

    public GeradorNotaFiscal(RepositorioNF repositorioNF) {
        this.repositorioNF = repositorioNF;
    }

    public NotaFiscal gerar(Pedido pedido) {
        NotaFiscal nf = new NotaFiscal(
                pedido.getCliente(),
                pedido.getValorTotal() * 0.94,
                Calendar.getInstance()
        );

        this.repositorioNF.persistir(nf);

        return nf;
    }

}
