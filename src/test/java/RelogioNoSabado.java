import java.util.Calendar;

public class RelogioNoSabado implements Relogio {

    public Calendar atual() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        return c;
    }

}
