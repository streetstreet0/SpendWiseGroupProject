package backend;

public class Date implements Comparable<Date> {
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public int compareTo(Date date) {
		int yearDiff = this.year - date.getYear();
		if (yearDiff != 0) {
			return yearDiff;
		}
		int monthDiff = this.month - date.getMonth();
		if (monthDiff !=0) {
			return monthDiff;
		}
		int dayDiff = this.day - date.getDay();
		return dayDiff;
	}

}
