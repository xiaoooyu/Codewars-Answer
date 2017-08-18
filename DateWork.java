
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.lang.System.out;

public class DateWork {
    public static void main(String[] args) {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);

		DateFormat timeFormat = DateFormat.getTimeInstance();
		out.println(timeFormat.format(new Date()));

		DateFormat shortFormat = DateFormat.getTimeInstance(DateFormat.SHORT);
		out.println(shortFormat.format(new Date()));

		DateFormat chinaFormat = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.CHINA);
		out.println(chinaFormat.format(new Date()));

		Calendar calendar = Calendar.getInstance();

		out.println(calendar.getMinimum(Calendar.YEAR));
		out.println(calendar.getMinimum(Calendar.HOUR_OF_DAY));
		out.println(calendar.getMinimum(Calendar.MINUTE));
		out.println(calendar.getMinimum(Calendar.SECOND));
		out.println(calendar.getMinimum(Calendar.MILLISECOND));

		out.println(calendar.getMaximum(Calendar.YEAR));
		out.println(calendar.getMaximum(Calendar.HOUR_OF_DAY));
		out.println(calendar.getMaximum(Calendar.MINUTE));
		out.println(calendar.getMaximum(Calendar.SECOND));
		out.println(calendar.getMaximum(Calendar.MILLISECOND));

		out.println(dateFormat.format(calendar.getTime()));
		calendar.add(Calendar.WEEK_OF_MONTH, -1);
		out.println(dateFormat.format(calendar.getTime()));

		out.println(dateFormat.format(new Date(0)));
    }
}
