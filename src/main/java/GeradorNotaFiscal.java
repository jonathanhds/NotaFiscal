import java.util.Calendar;

public class GeradorNotaFiscal {

    public NotaFiscal gerar(Pedido pedido) {
        return new NotaFiscal(
                pedido.getCliente(),
                pedido.getValorTotal() * 0.94,
                Calendar.getInstance()
        );
    }

}
