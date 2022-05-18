// indicates the package in which the class is in
package ALU;

//imports all JComponent needed for the Registration Page
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

// a class for the RegistrationPage
public class RegistrationPage {
	// declares a JPanel attribute for the registration page
	JPanel registrationForm;
	
	// declares labels attributes for the fields on the sign up page
	JLabel result;
	JLabel nameLabel;
	JLabel emailLabel;
	JLabel phoneNumberLabel;
	JLabel countryOfResidenceLabel;
	JLabel nationalityLabel;
	JLabel campusLabel;
	JLabel IntakeLabel;
	JLabel gradesLabel;

	// declares text field attributes to take in user input for each required information to register for ALU
	JTextField name;
	JTextField email;
	JTextField phoneNumber;
	JTextField countryOfResidence;
	JTextField nationality;
	JTextField grades;
	
	// declares radio button attributes for the user to choose his/her preferred campus and intake
	JRadioButton rwandaRadioBtn;
	JRadioButton mauritiusRadioBtn;
	JRadioButton janIntakeRadioBtn;
	JRadioButton septIntakeRadioBtn;
	
	// declares a button attribute for submitting
	JButton registerBtn;
	
	// declares variables that will store user's inputs from the field
	String studentName;
	String studentEmail;
	String studentPhoneNumber;
	String countryofRes;
	String studentNationality;
	String selectedCampus;
	String selectedIntake;
	String studentGrades;
	String major;
	
	// variables that will be used when determining the roll number to give to the student
	String studentNumber;
	String lastNumber;
	int nextNumber =1;
	
	// constructor for the registration page
	public RegistrationPage() {
		// creates the JPanel for the registration page
		// this will be a container of the registration page
		registrationForm = new JPanel();
		
		// creates a label for the name field
		nameLabel = new JLabel("Full name: "); 
		// positions and set size of the name label
		nameLabel.setBounds(50, 20, 300, 20); 
		// creates the text field for the name
		name = new JTextField();
		// positions and set size of the text field for the name 
		name.setBounds(50, 60, 350, 30); 
		
		//creates a label for the email field
		emailLabel = new JLabel("Email address: "); 
		// positions and set size of the email label
		emailLabel.setBounds(50, 90, 300,30); 
		// creates the text field for the email
		email = new JTextField();
		// positions and set size of the text field for the email
		email.setBounds(50,130, 350, 30); 
		
		// creates a label for the phone number field
		phoneNumberLabel = new JLabel("Phone number: ");  
		// positions and set size of the phone number label
		phoneNumberLabel.setBounds(50,170, 300,30); 
		// creates the text field for the phone number
		phoneNumber = new JTextField();
		// positions and set size of the text field for the phone number
		phoneNumber.setBounds(50,210, 350,30);  
	    
		//creates a label for the country of residence field
		countryOfResidenceLabel = new JLabel("Country of residence: ");  
		// positions and set size of the country of residence label
		countryOfResidenceLabel.setBounds(50,250, 300,30); 
		// creates the text field for the country of residence
		countryOfResidence = new JTextField();
		// positions and set size of the text field for the country of residence
		countryOfResidence.setBounds(50,280, 350,30); 
		
		//creates a label for the nationality field
		nationalityLabel = new JLabel("Nationality: ");  
		// positions and set size of the nationality label
		nationalityLabel.setBounds(50,330, 300,30);
		// creates the text field for the nationality
		nationality = new JTextField();
		// positions and set size of the text field for the nationality
		nationality.setBounds(50,370, 350,30); 
		
		//creates a label for the campus options
		campusLabel = new JLabel("Campus: "); 
		// positions and set size of the campus label
		campusLabel.setBounds(50,410, 100,30); 
		
		//creates a label for the intake options
		IntakeLabel = new JLabel("Intake: ");  
		// positions and set size of the intake label
		IntakeLabel.setBounds(50,450, 100,30); 
		
		// creates a radio button for the Rwanda campus option
		rwandaRadioBtn = new JRadioButton();
		// sets the text of the radio button to Rwanda
		rwandaRadioBtn.setText("Rwanda");
		// positions and set size of the rwandaRadioBtn
		rwandaRadioBtn.setBounds(120, 410, 100,30);
		
		// creates a radio button for the Mauritius campus option
		mauritiusRadioBtn = new JRadioButton();
		// sets the text of the radio button to Mauritius
		mauritiusRadioBtn.setText("Mauritius");
		// positions and set size of the mauritiusRadioBtn
		mauritiusRadioBtn.setBounds(250, 410, 100, 30);
		
		// creates a radio button for the january intake option
		janIntakeRadioBtn = new JRadioButton();
		// sets the text of the radio button to January
		janIntakeRadioBtn.setText("January");
		// positions and set size of the janIntakeRadioBtn
		janIntakeRadioBtn.setBounds(120, 450, 100,30);
		
		// creates a radio button for the september intake option
		septIntakeRadioBtn = new JRadioButton();
		// sets the text of the radio button to September
		septIntakeRadioBtn.setText("September");
		// positions and set size of the septIntakeRadioBtn
		septIntakeRadioBtn.setBounds(250, 450, 100,30);
		
		//creates a label for the grade field
		gradesLabel = new JLabel("Grade out of 20: "); 
		// positions and set size of the grade label
		gradesLabel.setBounds(50,490, 300,30); 
		// creates the text field for the grades
		grades = new JTextField();
		// positions and set size of the text field for the grades
		grades.setBounds(50,530, 350,30); 
		
		//creates a label for the result status
		result = new JLabel(""); 
		// positions and set size of the result label
		result.setBounds(50,0, 350,30); 
		
		// creates a button to submit i.e register	
		registerBtn = new JButton("Register");
		// positions and set size of register button
		registerBtn.setBounds(250,590, 150,30);
		// enables the button
		registerBtn.setEnabled(true);
		
		
		// add all the components to the registration panel
		registrationForm.add(result);	
		registrationForm.add(nameLabel);
		registrationForm.add(name);
		registrationForm.add(emailLabel);
		registrationForm.add(email);
		registrationForm.add(phoneNumberLabel);		
		registrationForm.add(phoneNumber);
		registrationForm.add(countryOfResidenceLabel);
		registrationForm.add(countryOfResidence);
		registrationForm.add(nationalityLabel);
		registrationForm.add(nationality);
		registrationForm.add(campusLabel);
		registrationForm.add(rwandaRadioBtn);
		registrationForm.add(mauritiusRadioBtn);
		registrationForm.add(IntakeLabel);
		registrationForm.add(janIntakeRadioBtn);
		registrationForm.add(septIntakeRadioBtn);
		registrationForm.add(registerBtn);
		registrationForm.add(gradesLabel);
		registrationForm.add(grades);
		
		
		// set size of the panel for the registration page
		registrationForm.setSize(460,720);  
		// sets layout of the registration panel to null because the layout was explicitly defined
		registrationForm.setLayout(null);  
		// sets the panel to be visible when the user navigates to the registration page
		registrationForm.setVisible(true); 
				
	}
	
}
