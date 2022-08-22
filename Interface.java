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
	private JButton schedule;
	private JButton budget;
	private JLabel label;
	private JFrame frame;
	private JFrame frame2;
	private JPanel panel;
	JTextField f1;
	JTextField f2;
	
	public Interface() {
		frame = new JFrame();
		schedule = new JButton("Create New Schedule");
		budget = new JButton("Create New Budget");
		
		
		budget.addActionListener(this);
		schedule.addActionListener(this);
		
		label = new JLabel("Please Choose One of the Following");
		panel = new JPanel();
		
		panel.add(budget);
		panel.add(schedule);
		panel.add(label);
		panel.setLayout(new GridLayout(0,2));
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Smart Travel");
		frame.setSize(10, 10);
		frame.pack();
		frame.setVisible(true);
		
	}
	public static void main(String args[]) {
		
		new Interface();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == schedule) {
			
			
			if(Schedule.size()>0) {
				//busy
				//add
				//see
			}
			}
			else {
				f1 = new JTextField();
				f2 = new JTextField();
				
				Object [] fields= {
						"Activity Name:", f1,
						"Activity Day", f2
				};
				
				JOptionPane.showConfirmDialog(null, fields, "Add Your Activity", JOptionPane.OK_CANCEL_OPTION);
			}
		}
		
	}








/*Schedule pcb = new Schedule("PCB", 5);
pcb.addActivity("Jet", 112.43, "14:45", 2, 90);
pcb.addActivity("J", 112.43, "13:45", 2, 90);

pcb.addActivity("Pier Walk", 112.43, "10:00", 2, 60);
pcb.addActivity("Jet-Ski", 112.43, "11:45", 2, 90);

System.out.println(Schedule.isBusy(2, "11:45"));*/