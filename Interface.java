package BudgetandPlanning;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Interface implements ActionListener{
	
	private JButton fschedule;
	private JButton fbudget;
	private JButton activities;
	private JButton isBusy;
	private JButton totalCost;
	private JButton addActivity;
	private JButton seeAllBudgets;
	private JButton addExpense;
	private JButton seeRemaining;
	private JButton getTotalSpending;
	private JButton getTotalBudget;
	private JButton addToBudget;
	private JButton reduceBudget;
	
	
	
	
	private JLabel label = new JLabel("Please Choose One of the Following");

	private JFrame frame1;
	private JFrame frame2;
	private JFrame frame3;
	private JFrame frame4;
	
	private JPanel panel;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	
	JTextField f1;
	JTextField f2;
	JTextField f3;
	JTextField f4; 
	JTextField f5;
	JTextField f6;
	JTextField f7;
	JTextField f8;
	JTextField f9;
	JTextField f10;
	JTextField f11;

	
	Budget first;
	public Interface() {
		frame1 = new JFrame();
		
		fschedule = new JButton("Create New Schedule");
		fbudget = new JButton("Create New Budget");
		
		fbudget.addActionListener(this);
		fschedule.addActionListener(this);
		
		panel = new JPanel();
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 10, 30));		
		
		panel.add(fbudget);
		panel.add(fschedule);
		panel.add(label);
		panel.setLayout(new GridLayout(0,2));
		
		frame1.add(panel,BorderLayout.CENTER);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setTitle("Smart Travel Opening Page");
		frame1.setSize(10, 10);
		frame1.pack();
		frame1.setVisible(true);
	}
	
	public Interface(String schedule) {
		frame2 = new JFrame();	
		
		activities = new JButton("See All Activities");
		isBusy = new JButton("See If You Are Busy at a Certain Time");
		totalCost = new JButton("See the Total Cost of Activities");
		addActivity = new JButton("Add an Activity");
		
		
		activities.addActionListener(this);
		isBusy.addActionListener(this);
		totalCost.addActionListener(this);
		addActivity.addActionListener(this);
		
		panel2 = new JPanel();
		panel2.setBorder(BorderFactory.createEmptyBorder(30, 40, 10, 30));

		panel2.add(activities);
		panel2.add(isBusy);
		panel2.add(totalCost);
		panel2.add(addActivity);
		panel2.add(label);
		panel2.setLayout(new GridLayout(0,2));

		frame2.add(panel2,BorderLayout.CENTER);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setTitle("Smart Travel: Scheduler ");
		frame2.setSize(10, 10);
		frame2.pack();
		frame2.setVisible(true);
	}
	
	public Interface(int budget) {
		frame3 = new JFrame();
		
		seeAllBudgets.addActionListener(this);
		addExpense.addActionListener(this);
		seeRemaining.addActionListener(this);
		addExpense.addActionListener(this);
		seeRemaining.addActionListener(this);
		getTotalSpending.addActionListener(this);
		getTotalBudget.addActionListener(this);
		addToBudget.addActionListener(this);
		reduceBudget.addActionListener(this);
		
		panel3 = new JPanel();
		panel3.setBorder(BorderFactory.createEmptyBorder(30, 40, 10, 30));
		
		panel3.add(seeAllBudgets);
		panel3.add(addExpense);
		panel3.add(seeRemaining);
		panel3.add(addExpense);
		panel3.add(seeRemaining);
		panel3.add(getTotalSpending);
		panel3.add(getTotalBudget);
		panel3.add(addToBudget);
		panel3.add(reduceBudget);


		panel3.add(label);

		frame3.add(panel3,BorderLayout.CENTER);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setTitle("Smart Travel: Budgeter");
		frame3.setSize(10, 10);
		frame3.pack();
		frame3.setVisible(true);
	}	
	
	public static void main(String args[]) {
		
		new Interface();
	}
	public void addNewActivity() {
		f3 = new JTextField();
		f4 = new JTextField();
		f5 = new JTextField();
		f6 = new JTextField();
		f7 = new JTextField();
						
		Object [] fields= {
				"Activity Name: ", f3,
				"Activity Cost: ", f4,
				"Activity Time: (Hour:Minutes)(Military Time)", f5,
				"Activity Day: (numerical day since the first day)", f6,
				"Activity Length: (in minutes)", f7
		};
		
		JOptionPane.showConfirmDialog(null, fields, "Add First Activity", JOptionPane.OK_CANCEL_OPTION);
		new Activity(f3.getText(), Double.parseDouble(f4.getText()), f5.getText(), 
				Integer.parseInt(f6.getText()), Integer.parseInt(f7.getText()));
		//frame1.dispose();
		
		new Interface("");
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == fschedule) {
			f1 = new JTextField();
			f2 = new JTextField();
			
			Object [] scheduleText = {
					"Name for Schedule: ", f1,
					"Number of Days on Schedule: ", f2	
			};
			JOptionPane.showConfirmDialog(null, scheduleText, "Create New Schedule", JOptionPane.OK_CANCEL_OPTION);
			Activity.makeSchedule(f1.getText(),Integer.parseInt(f2.getText()));
			
				addNewActivity();
				
		}
		if(obj == fbudget) {
			f1 = new JTextField();
			f2 = new JTextField();
			
			Object [] field = {
					"Budget Name: ", f1,
					"Budget Amount: ", f2
			};
			
			JOptionPane.showConfirmDialog(null, field, "Creating New Budget...", JOptionPane.OK_CANCEL_OPTION);
			new Budget(f1.getText(), Double.parseDouble(f2.getText()));
			//frame1.dispose();
			new Interface(1);
			}
		if(obj == activities) {
			JOptionPane.showMessageDialog(null, Activity.schedule());
		}
		if(obj == addActivity) {
			addNewActivity();
		}
		if(obj == isBusy) {
			f8 = new JTextField();
			f9 = new JTextField();
							
			Object [] fields= {
					"Day: ", f8,
					"Time: ", f9
			};
			
			JOptionPane.showConfirmDialog(null, fields, "Enter the Time You Wish to See The Availibility For", JOptionPane.OK_CANCEL_OPTION);
			
			if(Activity.isBusy(Integer.parseInt(f8.getText()), f9.getText())) {
				JOptionPane.showMessageDialog(null, "You are busy with the following: \n" + Activity.scheduleGet(Activity.getBusyNumber()));
			}
			else
				JOptionPane.showMessageDialog(null, "You Are Free!");
			
			new Interface("");
		}
		if(obj == totalCost) {
			JOptionPane.showMessageDialog(null, Activity.tCost());
		}
		if(obj == seeAllBudgets) {
			JOptionPane.showMessageDialog(null, Budget.returnAllBudgets());
		}
		if(obj == addExpense) {
			String budgetName = JOptionPane.showInputDialog(null, "Which of the following budget would you like to enter the expense into:" + "\n" + Budget.returnNames());
			
			
			
			f10 = new JTextField();
			f11 = new JTextField();
							
			Object [] fields= {
					"Expense Name: ", f3,
					"Expense Cost: ", f4
			};
			
			JOptionPane.showConfirmDialog(null, fields, "Add Expense", JOptionPane.OK_CANCEL_OPTION);
			Budget.findBudget(budgetName).addExpense(f3.getText(), Double.parseDouble(f4.getText()));
			
		}
		}
		}

		
		






