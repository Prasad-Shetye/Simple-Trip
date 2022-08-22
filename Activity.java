package BudgetandPlanning;

public class Activity {
	private String name;
	private double cost;
	private String time;
	private int day;
	private String toString = "";
	private int bDDateTime;
	private int length;
	private static int colon;
	private static String hour = "";
	private static String minute = "";
	private static int endTime;

	public Activity(String name, double cost, String time, int day, int length) {
		this.name = name;
		this.cost = cost;
		this.time = time;
		this.day = day;
		this.length = length;
	}
	
	public static int getBDTime(String time){
		colon = time.indexOf(':');
		hour = time.substring(0,colon);
		minute = time.substring(colon+1,time.length());
		return Integer.parseInt(hour)*60 + Integer.parseInt(minute);
	}
	
	private int getLength() {
		return length;
	}
	
	public int getBDDateTime() {
		bDDateTime = 0;
		bDDateTime += day * 24 * 60;
		bDDateTime += getBDTime(time);
		return bDDateTime;
	}
	
	public int getEndTime() {
		endTime = getBDDateTime()+ length;
		return endTime;
	}
	
	public void changeTime(String time) {
		this.time = time;
	}
	
	public void changeDay(int day) {
		this.day = day;
	}
	public String getName() {
		return name;
	}
	public double getCost() {
		return cost;
	}
	
	public String getTime() {
		return time;
	}
	public int getDay() {
		return day;
	}
	
	public String toString() {
		toString += "\n" + name + "\n";
		toString += "Day: " + day + "\n";
		toString += "Time: " + time ;
		return toString;
	}
	
}
