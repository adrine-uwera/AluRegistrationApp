// indicates the package in which the class is in
package ALU;

//imports all the classes needed for the sign up Page (JComponents, sql connection, and event listeners
//and actionEvent)
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import javax.swing.*;

//class for the ALU registration application
public class AluRegistrationApp {
	// declares a JFrame attribute that will be like the window of the application
	JFrame registrationPortal;
	
	// declares a JTabbedPane attribute that will have tabs that navigates to different pages
	JTabbedPane mainPane; 
	
	// declare JPanel attributes that will be used to create different pages
	JPanel frontPage;
	
	// declare JButtton attributes to be used for navigating to specific pages
	JButton signupBtn;
	JButton loginBtn;
	
	// declares a JButton attribute that will allow user to logout
	JButton logoutBtn;
	
	// declares a JLabel attribute to add a title to the landing page of the application
	JLabel landingPageTitle;
	
	//declares a JTextArea attribute that will display landing page content
	JTextArea landingPageContent;
	
	// declares a JLabel attribute for a 'or' label that will separate the sign up and login button on the
	// landing page
	JLabel orLabel;
	
	// declare objects of the LoginPage, SignUpPage, RegistrationPage, AdmissionSlot, and DegreeProgram
	LoginPage login;
	SignUpPage signUp;
	RegistrationPage register;
	AdmissionSlot admissionDetails;
	DegreeProgram computerScienceProgram;
	DegreeProgram globalChallengesProgram;
	DegreeProgram businessStudiesProgram;
	
	
	// constructor for the registration app (AluRegistrationApp class)
	public AluRegistrationApp() {
		// creates the frame that will be like the window of the application
		registrationPortal = new JFrame();
		
		// creates the JTabbedPane that have tabs that navigates to different pages
		mainPane = new JTabbedPane();  
		
		// created a panel for the landing page
		frontPage = new JPanel();
		
		// creates a Font that has font style, font weight, and font size
		Font myFont = new Font("Dialog",Font.BOLD,20);
		
		// creates a label with the title that will be added to the landing page
		landingPageTitle = new JLabel("ALU REGISTRATION PORTAL", JLabel.CENTER);
		// set size and position of the landing page title
		landingPageTitle.setBounds(50, 50, 350, 50);
		// sets the font of the landing page title to the font created earlier
		landingPageTitle.setFont(myFont);
		
		// creates a text area with the front page content.
		landingPageContent = new JTextArea("        Welcome to ALU registration portal.\nLog into "
				+ "your account or create an account \n   to be able to register for the next cohort");
		// sets size and position of the landing page content
		landingPageContent.setBounds(110, 120, 300, 50);
		// sets the background to a light grey color to make it dissolve into the panel
		landingPageContent.setBackground(new Color(236, 236, 236));
		// sets the landing page to be uneditable
		landingPageContent.setEditable(false);
		
		// creates a button that will help the user to navigate to the sign up page while on the landing page
		signupBtn =  new JButton("Sign Up");  
		// positions and set size of sign up button
		signupBtn.setBounds(120, 300, 200, 30);
		// enables the button
		signupBtn.setEnabled(true);		
		
		// creates the 'or' label that will show the user that there two options to choose from
		orLabel = new JLabel("Or");
		//  positions and set size of orLabel
		orLabel.setBounds(210, 250, 50, 30);
		
		// creates a button that will help the user to navigate to the login page while on the landing page
		loginBtn =  new JButton("Login");  
		// positions and set size of login button
		loginBtn.setBounds(120, 200, 200, 30);
		// enables the button
		loginBtn.setEnabled(true);
		
		
		// add all the components of the landing page to the frontPage panel
		frontPage.add(landingPageTitle);
		frontPage.add(landingPageContent);
		frontPage.add(signupBtn);
		frontPage.add(orLabel);
		frontPage.add(loginBtn);
		
		// creates objects of all pages that will be in the application
		login = new LoginPage();
		signUp = new SignUpPage();
		register = new RegistrationPage();
		admissionDetails = new AdmissionSlot();
		// there are 3 degree program so the application will have 3 tabs of the degreePrograms
		computerScienceProgram = new DegreeProgram("Computer science");
		globalChallengesProgram = new DegreeProgram("Global challenges");
		businessStudiesProgram = new DegreeProgram("Business studies");
		
		// sets the size and position of the tabbed pane on the frame
		mainPane.setBounds(0,0,490,730);
		
		// adds all the tabs and corresponding pages to the main pane (tabbed pane)
		mainPane.add("Home", frontPage);
		mainPane.add("Login", login.loginPanel);
		mainPane.add("Sign Up", signUp.signUpPanel);
		mainPane.add("Registration", register.registrationForm);
		mainPane.add("Admission", admissionDetails.admissionPage);
		mainPane.add("Computer science", computerScienceProgram.degreeProgPage);
		mainPane.add("Global challenges", globalChallengesProgram.degreeProgPage);
		mainPane.add("Business studies", businessStudiesProgram.degreeProgPage);
		
		
		// adds an action listener to the sign up button on the front page
		signupBtn.addActionListener((ActionListener) new ActionListener(){
			// overrides the actionPerformed method of the ActionListener class
			@Override
			public void actionPerformed(ActionEvent e) {
				// checks if the sign up page is enabled
				if (mainPane.isEnabledAt(2)) {
					// navigates to the sign up page when the button is clicked
					mainPane.setSelectedComponent(signUp.signUpPanel);
				}
			}  
		});
		
		// adds an action listener to the login button on the front page
		loginBtn.addActionListener((ActionListener) new ActionListener(){
			// overrides the actionPerformed method of the ActionListener class
			@Override
			public void actionPerformed(ActionEvent e) {
				// navigates to the login page when the button is clicked
				mainPane.setSelectedComponent(login.loginPanel);
				
			}  
		});
		
		// limits the user from navigating to the registration page, admission page, and the degree programs
		// pages
		mainPane.setEnabledAt(3, false);
		mainPane.setEnabledAt(4, false);
		mainPane.setEnabledAt(5, false);
		mainPane.setEnabledAt(6, false);
		mainPane.setEnabledAt(7, false);
		
		
		// adds an action listener to the login button of the login page
		login.loginBtn.addActionListener(new ActionListener(){
			// overrides the actionPerformed method of the ActionListener class
			@Override
			public void actionPerformed(ActionEvent e) {
				// gets the user inputs for the email
				login.studentEmail = login.email.getText();
				// gets the user inputs for the password
				login.studentPassword = login.password.getText();
				
				// variable that store characters that should be in an email
				String atEmail = "@";
				String dot = ".";
				
				// checks if the email contain "@" and ".", and if the password has 4 characters as required
				// for the sign up too. Check if all requirements to login are fulfilled.
				if (login.studentEmail.indexOf(atEmail) > -1 & login.studentEmail.indexOf(dot) > -1 &
						login.studentPassword.length() >= 4) {				
					// adds a try and catch to handle errors and exceptions
					try {
						
						// Create database connection
						Connection myConn = DriverManager.getConnection(
					            "jdbc:mysql://localhost:3306/alu_registration_database","root", "");
						
						// Create a statement of the connection
						Statement mySt = myConn.createStatement();
								
						// creates and store the sql query to be executed
						String selectQuery = "select * from login_credentials_table;";
						
						// executes the select query to retrieve data from the database
						ResultSet matchingData = mySt.executeQuery(selectQuery);
						
						// counter to keep track of the number of accounts with details matching the ones 
						// entered by the user
						int counter = 0;
						
						// iterates to get the number of accounts with details matching the ones 
						// entered by the user
						while(matchingData.next()) {
							// checks is the details match the ones provided by the user
							if (matchingData.getString("email").equals(login.studentEmail) &
									matchingData.getString("password").equals(login.studentPassword)){
								// if so the counter will be incremented 
								counter ++;
							}
						}
						
						// checks if the number of records with matching data is at least 1, and there should 
						// be one because the sign up restricted the user from having duplicate accounts
						if (counter >= 1) {
							// sets the results label to "Logged in successfully" to indicate a successful
							// login
							login.result.setText("Logged in successfully");
							
							// disables the sign up page since the user is logged in i.e already has an 
							// account							
							mainPane.setEnabledAt(2, false);
							
						} else {
							//if there no matching record, the user will be told to check the entries
							login.result.setText("Check your login details and try again");
														
						}
							
						// on a successful login
						if (login.isLoggedIn()) {
							// the registration page and the degree programs pages will be activated
							mainPane.setEnabledAt(3, true);
							mainPane.setEnabledAt(5, true);	
							mainPane.setEnabledAt(6, true);	
							mainPane.setEnabledAt(7, true);	
							
							// disables login field because the user is logged in
							login.loginBtn.setEnabled(false);
							login.email.setEditable(false);
							login.password.setEditable(false);
							
							// clears the fields
							login.email.setText("");
							login.password.setText(""); 
							
							// creates a logout button that will log the user out when clicked
							logoutBtn =  new JButton("Log out");
							// sets the size and the position of the logout button
							logoutBtn.setBounds(120, 420,200,30);  
							// enables the button
							logoutBtn.setEnabled(true);
							// adds the button to the login page
							login.loginPanel.add(logoutBtn);
							
							// adds an action listener to the logout button of the login page
							logoutBtn.addActionListener(new ActionListener(){
								// overrides the actionPerformed method of the ActionListener class
								@Override
								public void actionPerformed(ActionEvent e) {
									// deactivates the registration page, degree programs pages,  and 
									//admission page
									mainPane.setEnabledAt(3, false);	
									mainPane.setEnabledAt(4, false);
									mainPane.setEnabledAt(5, false);	
									mainPane.setEnabledAt(6, false);
									mainPane.setEnabledAt(7, false); 
									
									//activates the sign up page
									mainPane.setEnabledAt(2, true);
									
									// hides the logout button because the user is not logged in anymore
									login.loginPanel.remove(logoutBtn);
									// clears the result label
									login.result.setText("");
									
									// enables the login functionality because the user logged out
									// and allow him/her to login again.
									login.loginBtn.setEnabled(true);
									login.email.setEditable(true);
									login.password.setEditable(true);
									
								}
							});
							
							// creates another statement of the connection
							Statement mySt1 = myConn.createStatement();
							
							// creates and store the sql query to be executed
							String selectQuery1 = "select * from applicants_table";
							
							// executes the select query to retrieve data from the database
							ResultSet registeredMatchingData = mySt1.executeQuery(selectQuery1);
							
							// counter variable to keep track of the records that are already registered
							int counter2 = 0;
							
							// iterates to get the number of registered users with email details matching the
							// one entered by the user
							while(registeredMatchingData.next()) {
								// checks is the email details match the one provided by the user
								if (registeredMatchingData.getString("email").equals(login.studentEmail)) {
									// if so the counter will be incremented 
									counter2 ++;
								}
							}
							
							// checks if the number of records with matching data is at least 1, and there 
							// should be one because the registration did accept duplicate registration with 
							// one email
							if (counter2 >= 1) {
								// will display student details on the admission page
								displayStudentDetails();
								// activates the admission page and deactivates the registration page
								mainPane.setEnabledAt(4, true);
								mainPane.setEnabledAt(3, false);
								
							}
						}
						
											
					}
					// handles the errors and exceptions
					catch(SQLException exception) {
						// checks if the error was due to failed database connection
						if(exception.getErrorCode() == 0 ){
							// notification to indicate database connection failure
							System.out.println("Database connection failed. Please check if your database is"
									+ " connected."); 
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
					// checks if the password has at least 4 characters
					if (login.studentPassword.length() < 4) {
						// displays to tell the user that the password should be of 4+ characters
						login.result.setText("Password must be at least 4 characters");
					} else {
						// displays to tell the user that the email is not valid
						login.result.setText("Invalid email.");
					}
				}
				
			}  
		});
		
				
		// adds an action listener to the register button of the registration page
		register.registerBtn.addActionListener(new ActionListener() {
			// overrides the actionPerformed method of the ActionListener class
			@Override
			public void actionPerformed(ActionEvent e) {
				// gets applicant inputs for all field and store them into the variables
				register.studentName = register.name.getText();
				register.studentEmail = register.email.getText();
				register.studentPhoneNumber = register.phoneNumber.getText();
				register.countryofRes = register.countryOfResidence.getText();
				register.studentNationality = register.nationality.getText();
				register.studentGrades = register.grades.getText();
				
				// checks which campus the applicant selected
				if (register.rwandaRadioBtn.isSelected()) {
					// sets the selected campus variable to "Rwanda"
					register.selectedCampus = "Rwanda";
				} else if (register.mauritiusRadioBtn.isSelected()){
					// sets the selected campus variable to "Mauritius"
					register.selectedCampus = "Mauritius";
				} 
				// checks which intake the applicant selected
				if (register.janIntakeRadioBtn.isSelected()) {
					// sets the selected intake variable to january intake
					register.selectedIntake = register.janIntakeRadioBtn.getText();
				} else if (register.septIntakeRadioBtn.isSelected()){
					// sets the selected intake variable to september intake
					register.selectedIntake = register.septIntakeRadioBtn.getText();
				}
				
				// variable that store characters that should be in an email
				String atEmail = "@";
				String dot = ".";
				
				//Check if all requirements for registration are fulfilled.	        				
				if (register.studentName.length() > 0 & (register.studentEmail.indexOf(atEmail) > -1 & 
						register.studentEmail.indexOf(dot) > -1 )&
						(String.valueOf(register.studentPhoneNumber).length() >= 10 |
								String.valueOf(register.studentPhoneNumber).length() <= 20)
						& register.countryofRes.length() > 0 & register.studentNationality.length() > 0 
						& (register.rwandaRadioBtn.isSelected() | register.mauritiusRadioBtn.isSelected() ) 
						&(register.janIntakeRadioBtn.isSelected() | register.septIntakeRadioBtn.isSelected())
						& register.studentGrades.length() > 0 )
				{ 
					
					// created instance of the LocalDate class to get what date it is when the applicant
					// registered
					LocalDate currentdate = LocalDate.now();
					// gets the current year from the date
			        int year= currentdate.getYear(); 
			        
			        // adds a try and catch to handle errors and exceptions
					try { 
						// checks the grade of the applicant and match it with the degree programs available
						// If the student’s mark is between 18 and 20 out of 20, the student will be put under computer Science
						if (Double.parseDouble(register.studentGrades) >= 18 & Double.parseDouble(register.studentGrades) <= 20 ) {
							register.major = "Computer science";
						}	
						
						//If the applicant's mark is between 15 and 17 out of 20, the applicant will be put under global challenges.
						else if (Double.parseDouble(register.studentGrades) >= 15 & Double.parseDouble(register.studentGrades) <= 17 ) {
							register.major = "Global challenges";
						} 
						
						//If the student’s mark is between 12 and 14 out of 20, the student will be put under business studies. 
						else if (Double.parseDouble(register.studentGrades) >= 12 & Double.parseDouble(register.studentGrades) <= 14 ) {
							register.major = "Business studies";
						} 
						
						// otherwise the student will be unqualified for any degree program
						else { 
							register.major = "Unqualified";
						}
						
						// Create database connection
						Connection myConn = DriverManager.getConnection(
					            "jdbc:mysql://localhost:3306/alu_registration_database","root", "");
						
						// Create a statement of the connection
						Statement mySt = myConn.createStatement();
						
						// executes the select query to retrieve data from the database
						ResultSet myRe = mySt.executeQuery("select * from applicants_table");
						
						// TO DETERMINE THE ROLL NUMBER TO GIVE TO THE STUDENT
						// a variable that will be used to compare student numbers
						int previousStNum = 0;
						
						// Processes the result
						// iterates to get the last roll number so as to determine which roll number to give 
						// to the student applying
						while(myRe.next()) { 
							//gets the current record's roll number number and store it in the lastNumber variable
							register.lastNumber = myRe.getString("studentRegistrationNumber");
							// splits the number because a roll number is composed of current year and unique number
							// for the student separated by a slash
							String[] splitStudentNbr = register.lastNumber.split("/");
							
							// gets the year from the split roll number array
							int currentYear = Integer.parseInt(splitStudentNbr[0]);
							// gets the unique number from the split roll number array
							int currentNum = Integer.parseInt(splitStudentNbr[1]);
							
							// checks if the year in the roll number equals the year currently in
							if (currentYear == year) {
								// if so then the unique number will be compared with the previous unique number
								// which is initially set as 0 and updated as the program iterates through the roll
								// numbers in the database
								if (currentNum >= previousStNum) {
									// if greater then the previous number will be updated to the current number
									previousStNum = currentNum; 
									// and the next unique number will be incremented to form the new roll number.
									// the new unique number will be updated along the getting larger number than the 
									// previous number
									register.nextNumber = (currentNum + 1); 
								}
								
								// otherwise the loop with continue to the roll number
								else { 
									continue;
								}
							
							}
						} 
						// adds a zero if the unique number is less than 10
						if (register.nextNumber <10 ) {
							// creates a new roll number for the student which is current year and the unique number of the student
							register.studentNumber = String.valueOf(year).concat("/0" + String.valueOf(register.nextNumber));
						} else {
							// creates a new roll number for the student which is current year and the unique number of the student
							register.studentNumber = String.valueOf(year).concat("/" + String.valueOf(register.nextNumber));
						}
						// if student is unqualified then he/she will not be enrolled hence not added to the database
						if (register.major.equals("Unqualified")){
							// the student will get a message to notify him/her that he/she was not qualified
							JOptionPane.showMessageDialog(register.registrationForm,
									"You don't have enough grades to be qualified for admission.", "Message", 1);
						}
						
						// otherwise the student will be added to the database
						else {
							// creates and store the sql query to be executed
							String insertQuery = "insert into applicants_table(studentRegistrationNumber, fullName,"
									+ " email, phoneNumber, countryOfResidence, nationality, campus, intake, grades, major) values"
									+ "(\"" + register.studentNumber + "\",\"" + register.studentName + "\",\"" + register.studentEmail + "\",\"" 
									+ register.studentPhoneNumber + "\",\"" + register.countryofRes + "\",\""  + register.studentNationality +
									 "\",\"" + register.selectedCampus +  "\",\"" + register.selectedIntake +  "\",\"" + 
									 Double.parseDouble(register.studentGrades) + "\",\"" + register.major +  "\");";
							
							// executes the insert query to add the data into the database
							mySt.executeUpdate(insertQuery);
							
							// displays the student's details to the admission page
							displayStudentDetails();
								
							// tells the user that the registration was successful
							register.result.setText("Registered successfully");
							
							//clears the fields
							register.name.setText("");
							register.email.setText("");
							register.phoneNumber.setText("");
							register.countryOfResidence.setText("");
							register.nationality.setText("");
							register.grades.setText("");
							register.rwandaRadioBtn.setSelected(false);
							register.mauritiusRadioBtn.setSelected(false);
							register.janIntakeRadioBtn.setSelected(false);
							register.septIntakeRadioBtn.setSelected(false);
							
							// activates the admission slot
							mainPane.setSelectedIndex(4);
							// disables the registration page because the applicant can't register more than once
							mainPane.setEnabledAt(3, false);
							register.result.setText("");
							
							// creates an array with the student's details (roll number and student name)
							String[] row = {register.studentNumber, register.studentName};
							
							// adds the student into the respective degree program after a successful registration
							if (register.major == "Computer science") {
								computerScienceProgram.model.addRow(row);
							}
							
							else if (register.major == "Global challenges") {
								globalChallengesProgram.model.addRow(row);
							}
							
							else if (register.major == "Business studies") {
								businessStudiesProgram.model.addRow(row);
							}

							// activates the admission page
							mainPane.setEnabledAt(4, true);
						
						}
						
											
					}
					// handles the errors and exceptions
					catch(SQLException exception ) { 
						// checks if the error was due to failed database connection
						if(exception.getErrorCode() == 0 ){
							System.out.println("Database connection failed. Please check if your database is connected."); 
						}
						// checks if the error was due to a duplicate registration
						else if(exception.getErrorCode() == 1062 ){
							register.result.setText("Already registered.");
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
					if (register.studentName.length() == 0) { 
						// displays to tell the user that the name field is empty
						register.result.setText("Full name field is empty");
					}
					// checks if the email contains the "@: and "." as it should
					else if (register.studentEmail.indexOf(atEmail) <= 0 & 
							register.studentEmail.indexOf(dot) <= 0) {
						// displays to tell the user that the email is not valid
						register.result.setText("Invalid email.");
					} 
					// checks if the phone number is at least 10 digits long
					else if (String.valueOf(register.studentPhoneNumber).length() < 10 ) {   
						// displays to tell the user that the phone number is not complete
						register.result.setText("Verify the provided phone number");
					}
					
					// checks if the country of residence field is empty
					else if (register.countryofRes.length() == 0) {  
						// displays to tell the user that the country of residence field is empty
						register.result.setText("Please specify your country of residence");
					}
					// checks if the nationality field is empty
					else if (register.studentNationality.length() == 0) { 
						// displays to tell the user that the nationality field is empty
						register.result.setText("Please specify your nationality");
					}
					
					// checks if the student didn't selected a campus
					else if (!register.rwandaRadioBtn.isSelected() & !register.mauritiusRadioBtn.isSelected()) { // red color
						// displays to tell the user that he/she didn't choose a campus
						register.result.setText("Please select a campus");
					}
					
					// checks if the student didn't selected an intake
					else if (!register.janIntakeRadioBtn.isSelected() & !register.septIntakeRadioBtn.isSelected()) { // red color
						// displays to tell the user that he/she didn't choose an intake
						register.result.setText("Please select an intake");
					}
					// checks if the grade field is empty
					else if (register.studentGrades.length() == 0 ) { 
						// displays to tell the user that the grade field is empty
						register.result.setText("Please provide your grade");
					}
					else {
						// otherwise if any other thing is wrong, it tells the user to check all the entries
						register.result.setText("verify your entries");
					}
				}
			 }
		  });
		
			
		// sets size of the front/landing page 
		frontPage.setSize(460,500); 
		// sets layout of the front page panel to null because the layout was explicitly defined
		frontPage.setLayout(null);  	
		// sets the front page to be visible when the application is run
		frontPage.setVisible(true); 
		
		// adds the main pane(tabbed pane) to the registration portal frame	
		registrationPortal.add(mainPane);
		// sets size of the registration portal frame	
		registrationPortal.setSize(495,730);
		// sets resizable to false so as to keep the application's layout symmetric
		registrationPortal.setResizable(false);
		// sets layout of the registration portal frame null because the layout was explicitly defined
		registrationPortal.setLayout(null);  
		// sets the registration portal frame to be visible when the application is run
		registrationPortal.setVisible(true);
		
	}
	
	// a method to display student details in the admission page
	public void displayStudentDetails() {
		try { 
			// Create database connection
			Connection myConn = DriverManager.getConnection(
		            "jdbc:mysql://localhost:3306/alu_registration_database","root", "");
			
			// Create a statement of the connection
			Statement mySt = myConn.createStatement();
			
			// executes the select query to retrieve data from the database
			ResultSet myRe = mySt.executeQuery("select * from applicants_table;");
			
			// iterates to get the specific student's details from the database
			while(myRe.next()) {
				// checks if the student's email matches the one of the logged in student
				if (myRe.getString("email").equals(login.studentEmail)) {
					// adds all details of the specific student to the admission page
					admissionDetails.rollNumber.setText(myRe.getString("studentRegistrationNumber"));
					admissionDetails.name.setText(myRe.getString("fullName"));
					admissionDetails.email.setText(myRe.getString("email"));
					admissionDetails.phoneNumber.setText(myRe.getString("phoneNumber"));
					admissionDetails.countryOfResidence.setText(myRe.getString("countryOfResidence"));
					admissionDetails.nationality.setText(myRe.getString("nationality"));
					admissionDetails.campus.setText(myRe.getString("campus"));
					admissionDetails.intake.setText(myRe.getString("intake"));
					admissionDetails.grades.setText(myRe.getString("grades"));
					admissionDetails.major.setText(myRe.getString("major"));
					admissionDetails.admissionStatus.setText(myRe.getString("admissionStatus"));
					
				}
			}		
			
		} 

		// handles the errors and exceptions
		catch(SQLException exception) {
			// checks if the error was due to failed database connection
			if(exception.getErrorCode() == 0 ){
				System.out.println("Database connection failed. Please check if your database is connected."); 
			}
			else {
				// prints exception details in the console
				exception.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		// creates an object of the registrationPortal class
		AluRegistrationApp registrationPortal = new AluRegistrationApp();
	}
}

