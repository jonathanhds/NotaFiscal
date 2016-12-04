import java.util.Calendar;

public class GeradorNotaFiscal {

    private RepositorioNF repositorioNF;

    private SAP sap;

    private Relogio relogio;

    public GeradorNotaFiscal(RepositorioNF repositorioNF, SAP sap) {
        this(repositorioNF, sap, new RelogioSistema());
    }

    public GeradorNotaFiscal(RepositorioNF repositorioNF, SAP sap, Relogio relogio) {
        this.repositorioNF = repositorioNF;
        this.sap = sap;
        this.relogio = relogio;
    }

    public NotaFiscal gerar(Pedido pedido) {
        NotaFiscal nf = new NotaFiscal(
                pedido.getCliente(),
                pedido.getValorTotal() * 0.94,
                diaUtil()
        );

        this.repositorioNF.persistir(nf);

        this.sap.enviar(nf);

        return nf;
    }

    private Calendar diaUtil() {
        Calendar agora = this.relogio.atual();
        int diaSemana = agora.get(Calendar.DAY_OF_WEEK);

        if (diaSemana == Calendar.SATURDAY || diaSemana == Calendar.SUNDAY) {
            agora.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        }

        return agora;
    }


}
