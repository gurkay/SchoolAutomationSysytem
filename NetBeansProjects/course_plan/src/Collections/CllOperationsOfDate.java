/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collections;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author gurkay
 */
public class CllOperationsOfDate {
    
    public static int getDaysCountOfCourses(String dateOne, String dateTwo) {

        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");
        int numberOfDays = 0;

        String inputString1 = dateOne;
        String inputString2 = dateTwo;

        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            long diff = date2.getTime() - date1.getTime();
            System.out.println("Days: " + (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1));

            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTime(date1);
            cal2.setTime(date2);

            while (cal1.before(cal2)) {
                if ((Calendar.SATURDAY != cal1.get(Calendar.DAY_OF_WEEK)) && (Calendar.SUNDAY != cal1.get(Calendar.DAY_OF_WEEK))) {
                    numberOfDays++;
                    cal1.add(Calendar.DATE, 1);
                } else {
                    cal1.add(Calendar.DATE, 1);
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return numberOfDays + 1;
    }    
    
}
