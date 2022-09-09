package BudgetandPlanning;
import java.util.ArrayList;

public class Budget {
	private String budgetName;
	private double budgetAmount;
	private double currentSpending;
	private static double totalBudgetAmount;
	private static double totalCurrentSpending;
	private  ArrayList <Expense> budgetExpenses = new ArrayList<Expense>();
	private static ArrayList <Budget> allBudgets = new ArrayList<Budget>();
	public static double numWeeksLeft;
	private double singleBudgetWeeks;
	private static double totalBudgetWeeks;
	private String toString = "";
	private String all = "";
	public Budget(String name, double amount) {
		budgetName = name;
		budgetAmount = amount;
		totalBudgetAmount += amount;
		allBudgets.add(this);
	}
	
	public String getName() {
		return budgetName;
	}
	public void addExpense(String name, double amnt) {
		budgetExpenses.add(new Expense(name, amnt));
		currentSpending += amnt;
		totalCurrentSpending += amnt;
	}
	
	public String seeAllBudgets(){
		for(Budget x: allBudgets) {
			all += x + "\n";
		}
		return all;
	}
	
	public String seeAllExpenses() {
		String ex = "";
		for(Expense x : budgetExpenses) {
			ex += x + "\n";
			}
		return ex;
	}
	public double getRemainingBudget() {
		return budgetAmount - currentSpending;
	}
	public static double getTotalRemainingBudget() {
		return totalBudgetAmount - totalCurrentSpending;
	}
	
	public void addToBudget(double add) {
		budgetAmount += add;
	}
	
	public void reduceBudget(double reduce) {
		budgetAmount -= reduce;
	}
	
	public void setBudget(double set) {
		budgetAmount = set;
	}
	public static double getTotalBudget() {
		return totalBudgetAmount;
	}
	public static double getTotalCurrentSpending() {
		return totalCurrentSpending;
	}
	
	public double singleBudgetAllocate(int day) { //input should be day of the month
		singleBudgetWeeks = (30-day)/7.0;
		return getRemainingBudget()/singleBudgetWeeks;
	}
	public static double totalBudgetAllocate(int day) {
		totalBudgetWeeks = (30-day)/7.0;
		return getTotalRemainingBudget()/totalBudgetWeeks;
	}
	
	public String simplified() {
		String output = "Total Budget Amount: $" + budgetAmount + "\n";
		output += "Total Amount Spent From Budget: $" + currentSpending + "\n";
		output += "Total Amount Remaining: $" + getRemainingBudget();
		
		return output;
	}
	
	public static String returnAllBudgets() {
		String output = "";
		for(Budget x: allBudgets) {
			output += x.simplified() + "\n";
		}
		return output;
	}
	
	public static Budget findBudget(String budgetName) {
		int tracker = -1;
		Budget returned;
		for(int i = 0; i < allBudgets.size(); i++) {
			if(allBudgets.get(i).getName().equals(budgetName)) {
				tracker = i;
				break;
			}
		}
		if(tracker > -1) {
			returned = allBudgets.get(tracker); 
		}
		else {
			returned = null;
		}
		return returned;
	}
	
	public static String returnNames() {
		String output = "";
		for(Budget x: allBudgets) {
			output += x.getName() + "\n";
		}
		return output;
	}
	
	public String toString() {
		toString += budgetName + "Budget: ";
		for(Expense x: budgetExpenses) {
			toString += x + "\n";
		}
		return toString;
		
	}
	
}
