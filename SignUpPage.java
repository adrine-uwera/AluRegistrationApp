// indicates the package in which the class is in
package ALU;

//import all sql and event classes need for the sign up Page
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// imports all the JComponent classes needed for the sign up Page
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

// class for sign up page
public class SignUpPage {
	// declares a JPanel attribute for the sign up page
	JPanel signUpPanel;
	
	// declares labels attributes for the fields on the sign up page
	JLabel result;
	JLabel nameLabel;
	JLabel emailLabel;
	JLabel passwordLabel;
	JLabel confirmPasswordLabel;
	
	// declares text field attributes to take in user input for each required information to sign up
	JTextField name;
	JTextField email;
	JPasswordField password;
	JPasswordField confirmPassword;

	// declares a button attribute for submitting
	JButton signupBtn;
	
	// declares variables that will store user's inputs from the fields
	String studentName;
	String studentEmail;
	String studentPassword;
	String confPassword;
	
	// constructor for the sign up page
	public SignUpPage() {
		// creates the JPanel for the sign up page
		// this will be a container of the sign up page
		signUpPanel = new JPanel();
		
		// creates a label for the name field
		nameLabel = new JLabel("Full name: ");  
		// positions and set size of the name label
		nameLabel.setBounds(50, 50, 350, 20); 
		// creates the text field for the name
		name = new JTextField();
		// positions and set size of the text field for the name 
		name.setBounds(50, 80, 350, 30); 
		
		//creates a label for the email field
		emailLabel = new JLabel("Email: "); 
		// positions and set size of the email label
		emailLabel.setBounds(50, 120, 300,30); 
		// creates the text field for the email
		email = new JTextField();
		// positions and set size of the text field for the email
		email.setBounds(50,160, 350, 30); 
		
		//creates a label for the password field
		passwordLabel = new JLabel("Password (4+ characters): ");  
		// positions and set size of the password label
	    passwordLabel.setBounds(50,200, 300,30);
	    // creates the text field for the password
		password = new JPasswordField();
		// positions and set size of the text field for the password
		password.setBounds(50,240, 350,30);  
	    
		//creates a label for the confirm password field
		confirmPasswordLabel = new JLabel("Confirm Password: ");  
		// positions and set size of the confirm password label
		confirmPasswordLabel.setBounds(50,280, 300,30); 
		// creates the text field for the confirm password
		confirmPassword = new JPasswordField();
		// positions and set size of the text field for the confirm password
		confirmPassword.setBounds(50,320, 350,30); 
		
		//creates a label that will inform the user what's missing or if the sign up was successful
		result = new JLabel("");  
		// positions and set size of result label
		result.setBounds(50,20, 300,30); 
		
	    // creates a button to submit i.e sign up		    
		signupBtn =  new JButton("Sign Up");
		// positions and set size of sign up button
		signupBtn.setBounds(50,380,100,30); 
		// enables the button
		signupBtn.setEnabled(true);
	   
		// add all the components to the sign up panel
		signUpPanel.add(result);
		signUpPanel.add(name);
	    signUpPanel.add(email);
	    signUpPanel.add(password);
	    signUpPanel.add(confirmPassword);
	    signUpPanel.add(nameLabel);
	    signUpPanel.add(emailLabel);
	    signUpPanel.add(passwordLabel);
	    signUpPanel.add(confirmPasswordLabel);
	    signUpPanel.add(signupBtn); 
		
		// set size of the panel for the sign up page
		signUpPanel.setSize(460,500);  
		// sets layout of the sign up panel to null because the layout was explicitly defined
		signUpPanel.setLayout(null);  	
		// sets the panel to be visible when the user navigates to the sign up page
		signUpPanel.setVisible(true); 
		
		// adds action listener to the sign up button to listen for when the user clicks the button to 
	    // submit his/her information to sign up
		signupBtn.addActionListener(new ActionListener() {
	
			// overrides the actionPerformed method from ActionListener class
			@Override
			public void actionPerformed(ActionEvent e) {
				// gets user inputs for all field and store them into the variables
				studentName = name.getText();
				studentEmail = email.getText();
				studentPassword = password.getText();
				confPassword = confirmPassword.getText();
				
				// variable that store characters that should be in an email
				String atEmail = "@";
				String dot = ".";
				
				// checks if the name field is not empty, email contain "@" and ".", and if the passwords
				// match. Check if all requirements to sign up are fulfilled.
				if (studentName.length() > 0 & studentEmail.indexOf(atEmail) > -1 & 
					studentEmail.indexOf(dot) > -1 & studentPassword.length() >= 4 &
					studentPassword.equals(confPassword)) {				
					// adds a try and catch to handle errors and exceptions
					try { 
												
						// Create database connection
						Connection myConn = DriverManager.getConnection(
					            "jdbc:mysql://localhost:3306/alu_registration_database","root", "");
						
						// Create a statement of the connection
						Statement mySt = myConn.createStatement();

						// creates and store the sql query to be executed
						String insertQuery = "insert into login_credentials_table (studentName, email, password) values"
								+ "(\"" + studentName + "\",\"" + studentEmail + "\",\"" + studentPassword + "\");";
						
						// executes the insert query to add data into the database
						mySt.executeUpdate(insertQuery);
						
						// Displays to tell  the user that he/she was signed up successfully
						result.setText("Signed Up successfully");
						name.setText("");
						email.setText("");
						password.setText("");
						confirmPassword.setText("");
											
					}
					// handles the errors and exceptions
					catch(SQLException exception) {
						// checks if the error was due to failed database connection
						if(exception.getErrorCode() == 0 ){
							// notification to indicate database connection failure
							System.out.println("Database connection failed. Please check if your database is connected."); 
						}
						
						// checks if the error was because of double entries for the email which is the
						// primary key
						else if(exception.getErrorCode() == 1062 ){
							// tells the user that the email already has a registered account 
							result.setText("The provided email already has an account.");
						}
						
						else {
							// prints exception details in the console
							exception.printStackTrace();
						}
					}
					
				}
				
				// otherwise if the requirements aren't fulfilled, the application will tells the user 
				// what to correct
				else { 
					// checks if the name field is empty
					if (studentName.length() == 0) {
						// displays to tell the user that the name field is empty
						result.setText("Full name field is empty.");
					}
					
					// checks if the email contains the "@: and "." as it should
					else if (studentEmail.indexOf(atEmail) < 0 & studentEmail.indexOf(dot) < 0) {
						// displays to tell the user that the email is not valid
						result.setText("Invalid email.");
					}
					
					// checks if the password has at least 4 characters
					else if (studentPassword.length() < 4) {
						// displays to tell the user that the password should be of 4+ characters
						result.setText("Password must be at least 4 characters");
					}
					
					// checks if the provided passwords match
					else if (studentPassword != confPassword) {
						// displays to tell the user that the passwords provided don't match
						result.setText("Passwords don't match");
					}
					else {
						// otherwise if any other thing is wrong, it tells the user to check all the entries
						result.setText("verify your entries");
					}
				}
				
			}
			
		});
	}
	
	// a method to check if the user is signed in successfully
	public boolean isSignedUp() {
		// a boolean variable to define the status of the sign up
		boolean isOkay = false;
		// checks if the result message was "Signed Up successfully" hence meaning that user is signed in
		if (result.getText() == "Signed Up successfully") {
			// sets the isOkay to true since the user is signed up
			isOkay = true;
		}
		// returns the value of isOkay
		return isOkay;
	}
	
	
}
