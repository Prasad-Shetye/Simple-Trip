package BudgetandPlanning;
import java.util.ArrayList;

public class Activity {
	private static String sname;
	private static int numDays;
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
	private static boolean busy;
	private static int isBusyNumber;
	
	private static ArrayList <Activity> schedule = new ArrayList<Activity>();
	
	public Activity(String name, double cost, String time, int day, int length) {
		this.name = name;
		this.cost = cost;
		this.time = time;
		this.day = day;
		this.length = length;
		schedule.add(this);
	}
	
	public static Activity scheduleGet(int i) {
		return schedule.get(i);
	}
	
	public static String tCost() {
		double cost = 0;
		for(Activity x: schedule) {
			cost += x.getCost();
		}
		
		String y = "" + cost;
	      while((y.length() - y.indexOf('.')) != 3){
	          y = y + "0";
	      }
	      return "$" + y;		
	}
	
	public static void sort() {
		for(int i = 1; i < schedule.size(); i++) {
			int minTime = schedule.get(i).getBDDateTime();
			int ind = i-1;
			Activity x;
			while(ind >= 0 && minTime < schedule.get(ind).getBDDateTime()) {
				x = schedule.get(ind);
				schedule.set(ind,schedule.get(ind+1));
				schedule.set(ind+1, x);
				ind--;
			}
		}
		
	}
	
	public static boolean isBusy(int day, String time) {
		sort();
		int busyTime = day * 60 * 24;
		busyTime += Activity.getBDTime(time);
		isBusyNumber = -2;
		if(schedule.size()<2) {
			if(schedule.get(0).getBDDateTime() > busyTime) {
				busy = false;
			}
			else {
				if(schedule.get(0).getEndTime() > busyTime) {
					busy = true;
					isBusyNumber = 0;
				}
				else
					busy = false;
			}
		}
		else {
		for(int i = 0; i < schedule.size(); i++) {
			if(schedule.get(i).getBDDateTime() > busyTime) {
				if(schedule.size() < 2) {
					busy = false;
				}
				else if(i>0) {
				if(schedule.get(i-1).getEndTime() > busyTime) {
					isBusyNumber = i-1;
						busy = true;
					}
				else {
					busy = false;
				}
				}
				break;
				}
			
		}
		}
		return busy;
	}
	
	public static int getBusyNumber() {
		return isBusyNumber;
	}
	
	public static void makeSchedule(String name, int numberDays) {
		sname = name;
		numDays = numberDays;
	}
	
	public static String schedule() {
		sort();
		String list = "";
		list += "Activities planned so far: \n";
		for(Activity x: schedule) {
			list += x + "\n";
		}
		return list;
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
		toString += "Time: " + time + "\n";
		toString += "End Time: " + getEndTime();
		return toString;
	}
	
}
