import java.util.Calendar;

public class RelogioNaQuarta implements Relogio {

    public Calendar atual() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
        return c;
    }

}
