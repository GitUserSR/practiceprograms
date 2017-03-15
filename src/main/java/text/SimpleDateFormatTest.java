package text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by srapolu on 12/15/16.
 */
public class SimpleDateFormatTest {
    public static void main(String[] args) throws ParseException {
        //pattern exmaples are dd/MM/yyyy, dd-MM-yyyy, MM/dd/yyyy, yyyy-MM-dd
        String pattern = "MM/dd/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse("12/15/2016");
        System.out.println("SimpleDateFormatTest.main" + simpleDateFormat.format(date));
    }
}
