// indicates the package in which the class is in
package ALU;

// imports all JComponent needed for the Admission Page
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

// imports classes(Color and BorderFactory) that will used to format the admission page components and content
import java.awt.Color;
import javax.swing.BorderFactory;

// a class for admission page
public class AdmissionSlot {
	// declares a JPanel attribute for the admission page
	JPanel admissionPage;
	
	// declares labels attributes for student details to be displayed on the admission page
	JLabel rollNumberLabel;
	JLabel nameLabel;
	JLabel emailLabel;
	JLabel phoneNumberLabel;
	JLabel countryOfResidenceLabel;
	JLabel nationalityLabel;
	JLabel campusLabel;
	JLabel IntakeLabel;
	JLabel gradesLabel;
	JLabel admissionStatusLabel;
	JLabel majorLabel;
	
	// declares text field attributes that will hold each of the student details to displayed
	JTextField rollNumber;
	JTextField name;
	JTextField email;
	JTextField phoneNumber;
	JTextField countryOfResidence;
	JTextField nationality;
	JTextField grades;
	JTextField intake;
	JTextField campus;
	JTextField admissionStatus;
	JTextField major;
	
	// constructor for the admision page
	public AdmissionSlot() {
		// creates the JPanel for the sign up page
		// this will be a container of the sign up page
		admissionPage = new JPanel();	
		// creates a border which has a clear and border width of 1 and rounded edges
		Border fieldBorder = BorderFactory.createLineBorder(new Color(236, 236, 236), 1, true);
			
		// creates a label for the roll number display field
		rollNumberLabel = new JLabel("Roll number: ");  
		// positions and set size of the roll number label
		rollNumberLabel.setBounds(50, 30, 300, 20); 
		// creates the display field for the roll number
		rollNumber = new JTextField();
		// sets the border of the display field to the bolder created at the beginning
		rollNumber.setBorder(fieldBorder);
		// sets the text field to be uneditable 
		rollNumber.setEditable(false);
		// positions and set size of the display field for the roll number 
		rollNumber.setBounds(50, 55, 350, 20); 
		
		// creates a label for the name display field
		nameLabel = new JLabel("Full name: ");  
		// positions and set size of the name label
		nameLabel.setBounds(50, 85, 300,20); 
		// creates the display field for the name
		name = new JTextField();
		// sets the border of the display field to the bolder created at the beginning
		name.setBorder(fieldBorder);
		// sets the text field to be uneditable 
		name.setEditable(false);
		// positions and set size of the display field for the name 
		name.setBounds(50,110, 350, 20); 
		
		//creates a label for the email display field
		emailLabel = new JLabel("Email address: ");
		// positions and set size of the email label
		emailLabel.setBounds(50, 140, 300,20); 
		// creates the display field for the email
		email = new JTextField();
		// sets the border of the display field to the bolder created at the beginning
		email.setBorder(fieldBorder);
		// sets the text field to be uneditable 
		email.setEditable(false);
		// positions and set size of the display field for the email
		email.setBounds(50,165, 350,20);
		
		// creates a label for the phone number display field
		phoneNumberLabel = new JLabel("Phone number: ");  
		// positions and set size of the phone number label
		phoneNumberLabel.setBounds(50,195, 300,20); 
		// creates the display field for the phone number
		phoneNumber = new JTextField();
		// sets the border of the display field to the bolder created at the beginning
		phoneNumber.setBorder(fieldBorder);
		// sets the text field to be uneditable 
		phoneNumber.setEditable(false);
		// positions and set size of the display field for the phone number
		phoneNumber.setBounds(50,220, 350,20); 
	    
		//creates a label for the country of residence display field
		countryOfResidenceLabel = new JLabel("Country of residence: "); 
		// positions and set size of the country of residence label
		countryOfResidenceLabel.setBounds(50,250, 300,20); 
		// creates the display field for the country of residence
		countryOfResidence = new JTextField();
		// sets the border of the display field to the bolder created at the beginning
		countryOfResidence.setBorder(fieldBorder);
		// sets the text field to be uneditable 
		countryOfResidence.setEditable(false);
		// positions and set size of the display field for the country of residence
		countryOfResidence.setBounds(50,275, 350,20); 
		
		//creates a label for the nationality display field
		nationalityLabel = new JLabel("Nationality: ");  
		// positions and set size of the nationality label
		nationalityLabel.setBounds(50,305, 100,20); 
		// creates the display field for the nationality
		nationality = new JTextField();
		// sets the border of the display field to the bolder created at the beginning
		nationality.setBorder(fieldBorder);
		// sets the text field to be uneditable 
		nationality.setEditable(false);
		// positions and set size of the display field for the nationality
		nationality.setBounds(50,330, 350,20); 
		
		//creates a label for the campus display field
		campusLabel = new JLabel("Campus: ");  
		// positions and set size of the campus label
		campusLabel.setBounds(50,360, 100,20); 
		// creates the display field for the campus
		campus = new JTextField();
		// sets the border of the display field to the bolder created at the beginning
		campus.setBorder(fieldBorder);
		// sets the text field to be uneditable 
		campus.setEditable(false);
		// positions and set size of the display field for the campus
		campus.setBounds(50,385, 350,30); 
		
		//creates a label for the intake display field
		IntakeLabel = new JLabel("Intake: ");  
		// positions and set size of the intake label
		IntakeLabel.setBounds(50,415, 300,20); 
		// creates the display field for the intake
		intake = new JTextField();
		// sets the border of the display field to the bolder created at the beginning
		intake.setBorder(fieldBorder);
		// sets the text field to be uneditable 
		intake.setEditable(false);
		// positions and set size of the display field for the intake
		intake.setBounds(50,440, 350,20); 
		
		//creates a label for the grade display field
		gradesLabel = new JLabel("Grade out of 20: ");  
		// positions and set size of the grades label
		gradesLabel.setBounds(50,470, 300,20); 
		// creates the display field for the grade
		grades = new JTextField();
		// sets the border of the display field to the bolder created at the beginning
		grades.setBorder(fieldBorder);
		// sets the text field to be uneditable 
		grades.setEditable(false);
		// positions and set size of the display field for the grade
		grades.setBounds(50,495, 350,20); 
		
		//creates a label for the major display field
		majorLabel = new JLabel("Major: ");  
		// positions and set size of the major label
		majorLabel.setBounds(50,525, 300,20); 
		// creates the display field for the major
		major = new JTextField();
		// sets the border of the display field to the bolder created at the beginning
		major.setBorder(fieldBorder);
		// sets the text field to be uneditable 
		major.setEditable(false);
		// positions and set size of the display field for the major
		major.setBounds(50,550, 350,20); 
		
		//creates a label for the admission status display field
		admissionStatusLabel = new JLabel("Admission status: "); 
		// positions and set size of the admission label
		admissionStatusLabel.setBounds(50,580, 300,20); 
		// creates the display field for the admission
		admissionStatus = new JTextField();
		// sets the border of the display field to the bolder created at the beginning
		admissionStatus.setBorder(fieldBorder);
		// sets the text field to be uneditable 
		admissionStatus.setEditable(false);
		// positions and set size of the display field for the admission
		admissionStatus.setBounds(50,605, 350,20); 
		
		// add all the components to the admission page panel
		admissionPage.add(rollNumberLabel);	
		admissionPage.add(rollNumber);	
		admissionPage.add(nameLabel);
		admissionPage.add(name);
		admissionPage.add(emailLabel);
		admissionPage.add(email);
		admissionPage.add(phoneNumberLabel);		
		admissionPage.add(phoneNumber);
		admissionPage.add(countryOfResidenceLabel);
		admissionPage.add(countryOfResidence);
		admissionPage.add(nationalityLabel);
		admissionPage.add(nationality);
		admissionPage.add(campusLabel);
		admissionPage.add(campus); 
		admissionPage.add(IntakeLabel);
		admissionPage.add(intake);
		admissionPage.add(gradesLabel);
		admissionPage.add(grades);
		admissionPage.add(admissionStatusLabel);
		admissionPage.add(admissionStatus);
		admissionPage.add(majorLabel);
		admissionPage.add(major);
		
		// set size of the panel for the admission page
		admissionPage.setSize(460,720); 
		// sets layout of the admission panel to null because the layout was explicitly defined
		admissionPage.setLayout(null);  
		// sets the panel to be visible when the user navigates to the admission page
		admissionPage.setVisible(true);
	}
	
	
	
}
