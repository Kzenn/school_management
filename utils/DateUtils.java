/**
 * 
 */
package utils;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Calendar;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;

/**
 * 
 * @author CHAABANA Yanis
 */
public final class DateUtils{
	private DateUtils() {
	}
	
	public static int getNombreJourMax(String date){
		Calendar calendar = getCalendarFromDate(date);
		return calendar.getMaximum(Calendar.DAY_OF_MONTH);
	}
        
	public static boolean isDateValid (int jj, int mm, int aaaa){
		boolean valide = true; 
		if ((mm == 2) && ((aaaa % 4) == 0) && jj > 29)
			valide = false;
		else if ((mm == 2) && ((aaaa % 4) != 0) && jj > 28)
			valide = false;
		else if (((mm == 2) || (mm == 4) || (mm == 6) || (mm == 9)  || (mm == 11)) && (jj > 30))
			valide = false;
		else if ((jj > 31) || (jj < 1))
			valide = false;
		
		return valide;
	}
	
	public static String formatDateToMySQL(String date) {
		String dateParts[] = date.split("/");
		if (dateParts.length == 3) {
			date = dateParts[2] + "-" + dateParts[1] + "-" + dateParts[0];
		}

		return uniformizeDate(date);
	}

	public static String formatDateFromMySQL(java.sql.Date date) {
		return formatDateFromMySQL(date.toString());
	}
	
	public static String formatDateFromMySQL(String date) {
		String dateParts[] = date.split("-");
		if (dateParts.length == 3) {
			date = dateParts[2] + "/" + dateParts[1] + "/" + dateParts[0];
		}

		return uniformizeDate(date);
	}

	public static String uniformizeDate(String date) {
		String sep = "-";
		String dateParts[] = date.split(sep);
		
		int indexDay = 2;
		int indexMonth = 1;
		
		if (dateParts.length != 3) {
			sep = "/";
			dateParts = date.split(sep);
			
			indexDay = 0;
		}

		if (dateParts.length == 3) {
			if (dateParts[indexMonth].length() == 1)
				dateParts[indexMonth] = "0" + dateParts[indexMonth];

			if (dateParts[indexDay].length() == 1)
				dateParts[indexDay] = "0" + dateParts[indexDay];

			date = dateParts[0] + sep + dateParts[1] + sep + dateParts[2];
		}
		return date;
	}

	public static int compareDates(String date1, String date2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		String date1Parts[] = date1.split("-");
		String date2Parts[] = date2.split("-");

		try{
			c1.set(Integer.parseInt(date1Parts[0]),
					Integer.parseInt(date1Parts[1]) - 1, Integer
							.parseInt(date1Parts[2]));
			c2.set(Integer.parseInt(date2Parts[0]),
					Integer.parseInt(date2Parts[1]) - 1, Integer
							.parseInt(date2Parts[2]));
			}
		catch (Exception e){
			return -2;
		}
		
		if (c1.before(c2))
			return -1;

		if (c1.after(c2))
			return 1;

		return 0;
	}

	public static boolean isDateBefore(String date1, String date2){
		return isDateBefore(date1, date2, false);
	}
	
	public static boolean isDateBefore(String date1, String date2, boolean inclus){
		int codeCMP = compareDates(date1, date2);
		boolean b = codeCMP == -1;
		if (inclus){
			b = b || codeCMP == 0;
		}
		
		return b;
	}
	
	public static boolean isDateAfter(String date1, String date2){
		return isDateAfter(date1, date2, false);
	}
	
	public static boolean isDateAfter(String date1, String date2, boolean inclus){
		int codeCMP = compareDates(date1, date2);
		boolean b = codeCMP == 1;
		if (inclus){
			b = b || codeCMP == 0;
		}
		
		return b;
	}
	
	public static boolean isDateSame(String date1, String date2){
		return  compareDates(date1, date2) == 0;
	}
	
	public static boolean isDateBetween(String date, String date1, String date2){
		return isDateBetween(date, date1, date2, false);
	}
	
	public static boolean isDateBetween(String date, String date1, String date2, boolean inclus){
		boolean beforDate1 = isDateAfter(date, date1, inclus);
		boolean afterDate2 = isDateBefore(date, date2, inclus);
		
		return beforDate1 && afterDate2;
	}
	
	public boolean isDateSameYear(String date1, String date2){
		return getYear(date1) == getYear(date2);
	}
	
	public boolean isDateSameMonth(String date1, String date2){
		return getMonth(date1) == getMonth(date2);
	}
	
	public boolean isDateSameDay(String date1, String date2){
		return getDay(date1) == getDay(date2);
	}
	
	public static int diffrenceBetweenDates(String date1, String date2) {
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		String date1Parts[] = date1.split("-");
		String date2Parts[] = date2.split("-");

		c1.set(Integer.parseInt(date1Parts[0]),
				Integer.parseInt(date1Parts[1]) - 1, Integer
						.parseInt(date1Parts[2]));
		c2.set(Integer.parseInt(date2Parts[0]),
				Integer.parseInt(date2Parts[1]) - 1, Integer
						.parseInt(date2Parts[2]));

		// c1.compareTo(anotherCalendar) //redouane

		return 0;
	}

	public static String[] getPartsOfDate(String date){
		String parts[] = date.split("-");
		if (parts.length != 3){
			parts = date.split("/");
			if (parts.length != 0){
				parts = null;;
			}
		}
		
		return parts;
	}
	
	public static int getMonth(String date){
		int month = 0;
		
		String parts[] = getPartsOfDate(date);
		if (parts != null){
			try{
				month = Integer.parseInt(parts[1]);
			}
			catch (Exception e){
			}
		}
		
		return month;
	}
	
	public static int getYear(String date){
		int year = 0;
		
		String parts[] = getPartsOfDate(date);
		if (parts != null){
			try{
				year = Integer.parseInt(parts[ date.contains("-") ? 0 : 2]);
			}
			catch (Exception e){
			}
		}
		
		return year;
	}
	
	public static int getDay(String date){
		int day = 0;
		
		String parts[] = getPartsOfDate(date);
		if (parts != null){
			try{
				day = Integer.parseInt(parts[ date.contains("-") ? 2 : 1]);
			}
			catch (Exception e){
			}
		}
		
		return day;
	}
	
	public static int getNumberOfMonths(String startDate, String endDate){
		if (isDateAfter(startDate, endDate)){
			return 0;
		}
		
		int difInMonths = 0;
		
		int sMonth = getMonth(startDate);
		int sYear = getYear(startDate);
		
		int eMonth = getMonth(endDate);
		int eYear = getYear(endDate);
		
		while (sYear < eYear){
			while (sMonth<13){
				sMonth++;
				difInMonths++;
			}
			
			sYear++;
			sMonth=1;
		}
		
		while (sMonth <= eMonth){
			sMonth++;
			difInMonths++;
		}
		
		return difInMonths;
	}
	
	/*
	 * Returns the indices of months between startDate and endDate (0 : january, 1:fibrary ...)
	 */
	public static int[] getMonthsIndices(String startDate, String endDate){
		int numberOfMonths = getNumberOfMonths(startDate, endDate);
		
		if (numberOfMonths == 0){
			return null;
		}
		
		int[] monthsIndex = new int[numberOfMonths];
		
		int startMonth = getMonth(startDate);
		
		startMonth--;
		for (int i=0; i<numberOfMonths; i++){
			monthsIndex[i] = startMonth;
			startMonth = (startMonth+1)%12;
		}
		
		return monthsIndex;
	}
	
	public static int getDaysCountOfMonth(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);

		return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public static Calendar getPreviousDateByDay(String date) {
		return getPreviousDateByDay(getCalendarFromDate(date));
	}

	public static Calendar getPreviousDateByDay(Calendar calendar) {
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);

		Calendar cal = Calendar.getInstance();

		day--;
		if (day == 0) {
			month--;
			if (month < 0) {
				year--;
				month = 11;
			}
			cal.set(year, month, 1);
			day = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		}

		cal.set(year, month, day);

		return cal;
	}

	public static Calendar getNextDateByDay(Calendar calendar) {
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);

		Calendar cal = Calendar.getInstance();
		int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

		day++;
		if (day > numberOfDays) {
			month++;
			if (month > 11) {
				year++;
				month = 0;
			}
			day = 1;
		}

		cal.set(year, month, day);

		return cal;
	}

	public static Calendar getPreviousDateByMonth(Calendar calendar) {
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);

		Calendar cal = Calendar.getInstance();

		month--;
		if (month < 0) {
			year--;
			month = 11;
		}
		if (month == 1) {
			cal.set(year, month, 1);
			int nbJour = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			if (day > nbJour)
				day = nbJour;
		}

		cal.set(year, month, day);

		return cal;
	}

	public static Calendar getNextDateByMonth(Calendar calendar) {
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);

		Calendar cal = Calendar.getInstance();

		month++;
		if (month > 11) {
			year++;
			month = 0;
		}
		if (month == 1) {
			cal.set(year, month, 1);
			int nbJour = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			if (day > nbJour)
				day = nbJour;
		}

		cal.set(year, month, day);

		return cal;
	}

	public static Calendar getPreviousDateByYear(Calendar calendar) {
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);

		Calendar cal = Calendar.getInstance();

		year--;
		if (month == 1) {
			cal.set(year, month, 1);
			int nbJour = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			if (day > nbJour)
				day = nbJour;
		}
		cal.set(year, month, day);

		return cal;
	}

	public static Calendar getNextDateByYear(Calendar calendar) {
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);

		Calendar cal = Calendar.getInstance();
		year++;
		if (month == 1) {
			cal.set(year, month, 1);
			int nbJour = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			if (day > nbJour)
				day = nbJour;
		}

		cal.set(year, month, day);

		return cal;
	}

	public static Calendar dateToCalendar(String date) {
		int[] parts = getPartsDate(date);
		Calendar calendar = Calendar.getInstance();
		calendar.set(parts[0], parts[1] - 1, parts[2]);

		return calendar;
	}

	public static String calendarToDate(Calendar calendar) {
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);

		return normalizeDateMySQL(year + "-" + (month + 1) + "-" + day);
	}

	public static String calendarToMySQLDate(Calendar calendar) {
		return calendarToDate(calendar);
	}

	public static Calendar mySQLDateToCalendar(String date) {
		return dateToCalendar(date);
	}

	public static String getDateFromCalendar(Calendar calendar) {
		return calendarToDate(calendar);
	}

	public static Calendar getCalendarFromDate(String date) {
		return dateToCalendar(date);
	}

	public static String getFrenchDateTime(String dateTime) {
		String dt = "";
		if (dateTime.equals("0000-00-00 00:00:00")) {
			dt = "Pas encore";
		} else {
			String parts[] = dateTime.split(" ");
			dt = formatDateFromMySQL(parts[0]) + " à " + parts[1];
		}
		return dt;
	}
	
	public static int[] getDiffDate(String date1, String date2){
		int[] diffs = new int[3];//years-months-days
		
		int year1 = getYear(date1);
		int month1 = getMonth(date1);
		int day1 = getDay(date1);
		
		int year2 = getYear(date2);
		int month2 = getMonth(date2);
		int day2 = getDay(date2);
		
		diffs[0] = year1 - year2;
		diffs[1] = month1 - month2;
		diffs[2] = day1 - day2;
		
		return diffs;
	}
	
	public static String getAge(String date){
		String age = "";
		
		String currentDate = getCurrentDate();
		
		if (isDateAfter(date, currentDate)){
			age = "ERROR";
		}
		else{
			int[] diffs = getDiffDate(currentDate, date);
			if (diffs[0] > 0){
				if (diffs[0]==1){
					age += "Une année";
				}
				else{
					age += diffs[0]+" ans";
				}
			}
			else if (diffs[1] > 0){
				age += diffs[1]+" mois";
			}
			else{
				age += diffs[2]+" jours";
			}
		}
		
		return age;
	}
	
	public static String getMonthFromDate(String mysqlDate) {
		String parts[] = mysqlDate.split("-");
		if (parts.length != 3)
			return "";
		return parts[1] + "-" + parts[0];
	}

	public static int[] getPartsDate(String mysqlDate) {
		String[] partsDateStr = mysqlDate.split("-");
		int[] partsDate = new int[3];
		for (int i = 0; i < partsDateStr.length; i++)
			partsDate[i] = Integer.parseInt(partsDateStr[i]);
		return partsDate;
	}

	public static int[] getPartsDateForCalendar(String mysqlDate) {
		String[] partsDateStr = mysqlDate.split("-");
		int[] partsDate = new int[3];
		for (int i = 0; i < partsDateStr.length; i++)
			partsDate[i] = Integer.parseInt(partsDateStr[i]);
		if (partsDate.length == 3) {
			partsDate[1]--;
		}
		return partsDate;
	}

	public static String getMySQLDateFromCalendar(Calendar calendar) {
		String date = "";
		date = calendar.get(Calendar.YEAR) + "-"
				+ (calendar.get(Calendar.MONTH) + 1) + "-"
				+ calendar.get(Calendar.DAY_OF_MONTH);
		return date;
	}

	public static Calendar getCalendarFromMySQLDate(String mysqlDate) {
		Calendar calendar = Calendar.getInstance();
		int[] parts = getPartsDateForCalendar(mysqlDate);
		calendar.set(parts[0], parts[1], parts[2]);
		return calendar;
	}

	public static String getNextDateByDay(String mysqlDate) {
		Calendar calendar = getCalendarFromMySQLDate(mysqlDate);
		return getMySQLDateFromCalendar(getNextDateByDay(calendar));
	}

	public static String normalizeDateMySQL(String date) {
		String parts[] = date.split("-");
		if (parts[1].length() == 1) {
			parts[1] = "0" + parts[1];
		}
		if (parts[2].length() == 1) {
			parts[2] = "0" + parts[2];
		}
		return parts[0] + "-" + parts[1] + "-" + parts[2];
	}

	public static boolean isValideMySQLDate(String date) {
		String parts[] = date.split("-");
		if (parts.length == 3) {
			try {
				int jj = Integer.parseInt(parts[2]);
				int mm = Integer.parseInt(parts[1]);
				int aaaa = Integer.parseInt(parts[0]);

				if ((mm == 2) && ((aaaa % 4) == 0) && jj > 29)
					return false;
				else if ((mm == 2) && ((aaaa % 4) != 0) && jj > 28)
					return false;
				else if (((mm == 2) || (mm == 4) || (mm == 6) || (mm == 9) || (mm == 11))
						&& (jj > 30))
					return false;
				else if ((jj > 31) || (jj < 1))
					return false;

				return true;
			} catch (Exception e) {
			}
		}

		return false;
	}

	public static String getDateFromDateTime(String dateTime) {
		String parts[] = dateTime.split(" ");
		if (parts.length == 2) {
			return parts[0];
		}
		return "1900-01-01";
	}

	public static String getTimeFromDateTime(String dateTime) {
		String parts[] = dateTime.split(" ");
		if (parts.length == 2) {
			return parts[1];
		}
		return "00:00:00";
	}
	
	public static String getDateOfThisDay() {
		Calendar calendar = Calendar.getInstance();
		String date = (calendar.get(Calendar.YEAR) + "-"
				+ (calendar.get(Calendar.MONTH) + 1) + "-" + calendar
				.get(Calendar.DAY_OF_MONTH));
		return uniformizeDate(date);
	}
	
	public static String getCurrentDate() {
		Calendar currentDate = Calendar.getInstance();
		String date = currentDate.get(Calendar.YEAR) + "-"
				+ (currentDate.get(Calendar.MONTH) + 1) + "-"
				+ currentDate.get(Calendar.DAY_OF_MONTH);
		return uniformizeDate(date);
	}

	public static String getCurrentMonth() {
		String date = getCurrentDate();
		return date.split("-")[1];
	}

	public static int getCurrentMonthAsInteger() {
		Calendar currentDate = Calendar.getInstance();
		return currentDate.get(Calendar.MONTH) + 1;
	}
	
	public static int getCurrentYearAsInteger() {
		Calendar currentDate = Calendar.getInstance();
		return currentDate.get(Calendar.YEAR);
	}
	
	@SuppressWarnings("deprecation")
	public static java.sql.Date getDateFromString(String mysqlDate) {
		if (mysqlDate == null || mysqlDate.trim().equals("")) {
			return new java.sql.Date(1, 0, 1);
		}

		java.sql.Date date = null;

		String parts[] = mysqlDate.trim().split("-");

		int year = Integer.parseInt(parts[0]) - 1900;
		int month = Integer.parseInt(parts[1]) - 1;
		int day = Integer.parseInt(parts[2]);

		date = new java.sql.Date(year, month, day);
		return date;
	}
	
	@SuppressWarnings("deprecation")
	public static java.sql.Date getDateFromDate(java.util.Date date){
		String strDate = date.getYear()+"-"+date.getMonth()+"-"+date.getDate();
		java.sql.Date date2 = getDateFromString(strDate);
		
		return date2;
	}

	public static String transformDateFromMySQL(String mysqlDate) {
		return formatDateFromMySQL(mysqlDate);
	}
	
	public static String transformDateToMySQL(String date) {
		return formatDateToMySQL(date);
	}
        
        
    /**
     * Une classe interne
     * 
     **/
        
    public static class UIDate {
        public static JTextComponent getDateField() {
		JFormattedTextField tc = getFormatedField("**/**/****");
		tc.setToolTipText("JJ/MM/AAAA");
                
		tc.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent evnt) {
				JFormattedTextField tc = (JFormattedTextField)evnt.getSource();
				
				String strDate = tc.getText();
				if (isValiDate(strDate)) {
					tc.setText(strDate.replaceAll("_", "0"));
				} else {
                                        JOptionPane.showMessageDialog(tc, "Erreur de date ...", "Erreur", JOptionPane.ERROR_MESSAGE);

                                        if (strDate.equals("__/__/____")){
                                            return;
					}
					
					tc.setForeground(Color.red);
					tc.requestFocus();
				}
			}

			public void focusGained(FocusEvent evnt) {
				JFormattedTextField tc = (JFormattedTextField)evnt.getSource();
				tc.setForeground(Color.BLACK);
			}
		});

		return tc;
	}
    
            public static boolean isValiDate(String date) {
		int day = Integer.parseInt(getDay(date));
		int month = Integer.parseInt(getMonth(date));
		int year = Integer.parseInt(getYear(date));

		if (day > 31 || month > 12 || day == 0 || month == 0 || year == 0) {
			return false;
		} else if ((month == 4 || month == 6 || month == 9 || month == 11)
				&& day > 30) {
			return false;
		} else if ((bissextile(year) && month == 2 && day > 29)
				|| (!bissextile(year) && month == 2 && day > 28)) {
			return false;
		} else if (getYear(date).length() <= 3)
			return false;

		return true;
	}
            
            
            public static String getDay(String date) {
		String sday;
		sday = date.substring(0, 2).replace("_", "");
		if (sday.equals(""))
			sday = "00";
		if (sday.length() == 1)
			sday = "0" + sday;

		return sday;
	}

	public static String getMonth(String date) {
		String smonth;
		smonth = date.substring(3, 5).replace("_", "");
		if (smonth.equals(""))// {
			smonth = "00";
		if (smonth.length() == 1)
			smonth = "0" + smonth;
		return smonth;
	}

	public static String getYear(String date) {
		String syear;
		syear = date.substring(6, 10).replace("_", "");
		if (syear.equals(""))
			syear = "0000";
		return syear;
	}
        
        public static boolean bissextile(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			return true;
		}
		return false;
	}
        
        public static JFormattedTextField getFormatedField(String format){
		return getFormatedField(format, '_');
	}
	
	public static JFormattedTextField getFormatedField(String format, char placeholderChar){
		return getFormatedField(format, placeholderChar, "0123456789_");
	}
	
	public static JFormattedTextField getFormatedField(String format, char placeholderChar, String validChars){
		MaskFormatter mask = createFormatter(format);
		mask.setPlaceholderCharacter(placeholderChar);
		mask.setValidCharacters(validChars);
		JFormattedTextField tc = new JFormattedTextField(mask);
		
		return tc;
	}
        
        private static MaskFormatter createFormatter(String s) {
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter(s);
		} catch (java.text.ParseException exc) {
			System.err.println("formatter is bad: " + exc.getMessage());
			System.exit(-1);
		}
		return formatter;
	}
    }
}