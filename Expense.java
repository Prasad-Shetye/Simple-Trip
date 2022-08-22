package BudgetandPlanning;

public class Expense {
	private String name;
	private double amount;
	private String toString = "";

	public Expense(String name, double amount) {
		this.name = name;
		this.amount =  amount;
	}
	public String toString() {
		toString += name + "\n";
		toString += amount + "\n";
		return toString;
	}
}
