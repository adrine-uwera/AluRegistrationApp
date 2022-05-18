// indicates the package in which the class is in
package ALU;

//imports all the classes needed for the degree programs Page (JComponents, sql connection)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// a class for degree program page
public class DegreeProgram {
	// declares a JPanel attribute for the degree program page
	JPanel degreeProgPage;
	// declares a scroll pane attribute for the degree program page
	JScrollPane scrollablePane;
	// declares a JTable attribute that will contain the student in the specific degree program 
	JTable dataTable;
	// declares a variable attribute that defines the degree program name
	String programName;
	
	DefaultTableModel model;
	
	// constructor for the degree program page
	public DegreeProgram(String program) {
		// sets the degree program name to the passed in program name
		programName = program;
		
		// creates the JPanel for the degree program page
		// this will be a container of the degree program page
		degreeProgPage = new JPanel();
		// set size of the panel of the degree program page
		degreeProgPage.setSize(380,720);
		// sets the position of the panel to be at the beginning of the frame
		degreeProgPage.setLocation(0,0);
		
		// creates the table that will display the students enrolled in that degree program
		dataTable= new JTable(); 	
		// sets the position of the table to be at the beginning of the scrollable Pane
		dataTable.setLocation(0, 0);
		// sets the size of the table
		dataTable.setSize(380, 520);
		
		// creates a scrollable pane which holds the table of students
		scrollablePane = new JScrollPane(dataTable, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		// sets the size of the scrollable pane
		scrollablePane.setSize(380, 550);
		// adds the scrollable pane to the main panel(degreeProgPage)
		degreeProgPage.add(scrollablePane);
		
		
		// sets the panel to be visible when the user navigates to the degree program page	
		degreeProgPage.setVisible(true);
		
		getStudents();
		
	}
	
	// a method that gets student data from the database
	public void getStudents() {
		// adds a try and catch to handle errors and exceptions
		try {
			
			// Create database connection
			Connection myConn = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/alu_registration_database","root", "");
			
			// Create a statement of the connection
			Statement mySt = myConn.createStatement();
			
			// creates and store the sql query to be executed
			String selectQuery = "select * from applicants_table;";
			
			// executes the select query to retrieve data from the database
			ResultSet myResult = mySt.executeQuery(selectQuery); 
			
			// formats data from the database into displayable data in the table and store the data into
			// a variable studentData
			ResultSetMetaData studentData = myResult.getMetaData();
			
			// creates table model
			model = (DefaultTableModel) dataTable.getModel();
			
			// counts the number of columns in the database
			int columns = studentData.getColumnCount();
			
			//creates an array to store the column headings
			String[] columnNames = new String[2];
			
			// a variable to keep track of the number of columns added to the columnNames array
			int x = 0;
			
			// iterates to add the get the studentRegistrationNumber and fullName columns only
			for(int i = 0; i<columns; i++) {
				// checks if the column heading matches studentRegistrationNumber or fullName
				if (studentData.getColumnName(i+1).equals("studentRegistrationNumber") | 
					studentData.getColumnName(i+1).equals("fullName")) {
					// adds the column heading to the columnNames array
					columnNames[x] = studentData.getColumnName(i+1);
					// increments the number of columns stored in the columnNames array
					x++;
				}
				// otherwise the loop will move to the next column
				else {
					continue;
				}
			}
			
			// set the column headings of the table to the column names in the columnNames array
			model.setColumnIdentifiers(columnNames);
			
			// variables to store the student's roll number and full name
			String rollNum, stName;
			
			// iterates to get the student roll number and full name from the data retrieved from the database
			while(myResult.next()) {
				// checks if the major the student is enrolled in matches the program name
				if (myResult.getString("major").equals(programName)) {
					// gets the student's roll number and store it into the variable rollNum
					rollNum = myResult.getString("studentRegistrationNumber");
					// gets the student's name and store it into the variable stName
					stName = myResult.getString("fullName");
					// creates an array with the student's details (roll number and student name)
					String[] rows = {rollNum, stName};
					// added the student's details as a record into the table
					model.addRow(rows);
				}
			}
			
		}
		// handles the errors and exceptions
		catch(SQLException exception) {
			// checks if the error was due to failed database connection
			if(exception.getErrorCode() == 0 ){
				System.out.println("Database connection failed. Please check if your database is connected."); 
			}else {
				// prints exception details in the console
				exception.printStackTrace();
			}
		}
				
	}
	
}
