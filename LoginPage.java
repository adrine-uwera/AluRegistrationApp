// indicates the package in which the class is in
package ALU;

// imports all the java swing components classes
import javax.swing.*;

// class for the login page
public class LoginPage {
	// declares a JPanel attribute for the login page
	JPanel loginPanel;
	
	// declares labels attributes for the fields on the login page
	JLabel result;
	JLabel emailLabel;
	JLabel passwordLabel;
	JTextField email;
	JPasswordField password;
	
	// declares a login button attribute
	JButton loginBtn;
	
	// declares a logout button attribute
	JButton logoutBtn;
	
	// declares variables that will store user's inputs from the fields
	String studentEmail;
	String studentPassword;
	
	
	// constructor for the login page
	public LoginPage() {
		// creates the JPanel for the login page
		// this will be a container of the login page
		loginPanel = new JPanel();
		
		// creates a label for the email field
		emailLabel = new JLabel("Email: ");  
		// positions and set size of the email label
		emailLabel.setBounds(50, 50, 350, 20); 
		// creates the text field for the email
		email = new JTextField();
		// positions and set size of the text field for the email 
		email.setBounds(50, 80, 350, 30); 
		
		// creates a label for the password field
		passwordLabel = new JLabel("Password: ");  
		// positions and set size of the password label
	    passwordLabel.setBounds(50, 120, 300,30); 
	    // creates the text field for the password
		password = new JPasswordField();
		// positions and set size of the text field for the password 
		password.setBounds(50,160, 350, 30);  
	    
		//creates a label that will inform the user what's missing or if the login was successful
		result = new JLabel("");  
		// positions and set size of result label
		result.setBounds(50,20, 300,30); 
		
		// creates a button to submit i.e login	
		loginBtn =  new JButton("Login");
		// positions and set size of login button
		loginBtn.setBounds(50,220,100,30);  
		// enables the button
		loginBtn.setEnabled(true);
		
		
		// add all the components to the login panel
		loginPanel.add(result);
	    loginPanel.add(email);
	    loginPanel.add(password);
	    loginPanel.add(emailLabel);
	    loginPanel.add(passwordLabel);
		loginPanel.add(loginBtn); 
		
		// set size of the panel for the login page
		loginPanel.setSize(460,320);  
		// sets layout of the login panel to null because the layout was explicitly defined
		loginPanel.setLayout(null);  
		// sets the panel to be visible when the user navigates to the login page
		loginPanel.setVisible(true); 
	}
	
	// a method to check if the user is logged in successfully
	public boolean isLoggedIn() {
		// a boolean variable to define the status of the login
		boolean isOkay = false;
		// checks if the result message was "Logged in successfully" hence meaning that user is logged in
		if (result.getText() == "Logged in successfully") {
			// sets the isOkay to true since the user is logged in
			isOkay = true;
		}
		// returns the value of isOkay
		return isOkay;
	}
	
	
}
