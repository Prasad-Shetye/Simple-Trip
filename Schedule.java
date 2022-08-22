package BudgetandPlanning;
import java.util.ArrayList;
public class Schedule {
	private static ArrayList <Activity> schedule = new ArrayList<Activity>();
	private String name;
	private static int numDays;
	private static int minDay;
	private static int index;
	private String toString = "";
	private static boolean busy;
	private static boolean lessTime;
	
	public Schedule(String name, int numDays) {
		this.name = name;
		this.numDays = numDays;
	}
	
	public void addActivity(String name, double cost, String time, int day, int length) {
		schedule.add(new Activity(name, cost, time, day, length));
	}
	
	public Activity get(int i) {
		return schedule.get(i);
	}
	
	public static boolean isBusy(int day, String time) {
		sort();
		int busyTime = day * 60 * 24;
		busyTime += Activity.getBDTime(time);
		for(int i = 0; i < schedule.size(); i++) {
			if(schedule.get(i).getBDDateTime() > busyTime) {
				if(schedule.size() < 2) {
					busy = false;
				}
				else if(i>0) {
				if(schedule.get(i-1).getEndTime() > busyTime) {
						busy = true;
					}
				else {
					busy = false;
				}
				}
				break;
				}
			
		}
		return busy;
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
	
	public static int size() {
		return schedule.size();
	}
	
	public String toString() {
		sort();
		toString += "Activities planned so far: \n";
		for(Activity x: schedule) {
			toString += x + "\n";
		}
		return toString;
	}
	
}
