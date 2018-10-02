import java.time.*;
public class daysSinceBorn {
	int year;
	Month month;
	int date;
	int hour;
	int minute;
	LocalDateTime localDateTime;
	ZonedDateTime zonedDateTime;
	daysSinceBorn(int year,Month month,int date,int hour, int minute)
	{
		this.year = year;
		this.month = month;
		this.date = date;
		this.hour = hour;
		this.minute = minute;
		ZoneId zoneId = ZoneId.of("America/Phoenix");
		zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
		localDateTime = LocalDateTime.of(year, month, date, hour, minute);
		zonedDateTime.getMonth();
		
	}
	public int calculateTime() {
		int numdays = 0;
		int yeartrack=0;
		while(zonedDateTime.getYear()-year>0)
		{
			yeartrack+=1;
			if(yeartrack%4==0)
				numdays+=1;
			numdays += 365;
			year+=1;
		}
		while(zonedDateTime.getMonth()!=month)
		{
			month = month.plus(1);
			numdays+=month.length(false);			
		}
		if(date>zonedDateTime.getDayOfMonth())
			numdays+=date-zonedDateTime.getDayOfMonth();
		else
			numdays+=month.length(false)+zonedDateTime.getDayOfMonth()-date;
		return numdays;
	}
	public static void main(String[]args) {
		daysSinceBorn birthday = new daysSinceBorn(1999, Month.JANUARY, 20, 1,1);
		System.out.println(birthday.calculateTime());
	}
}
