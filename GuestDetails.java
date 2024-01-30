import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.Calendar;
import org.jdesktop.swingx.JXDatePicker;
import java.text.SimpleDateFormat;
import java.util.Date;

// New imports for List and ArrayList
import java.util.List;
import java.util.ArrayList;

// Import for regular expressions
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.awt.*;
import java.awt.Color;
import java.util.Scanner;


public class GuestDetails{

	public static String fname, mname, lname, contact, email;
	// wala pa bday

    public static void main (String[]args) {


    	JFrame guestFrame = new JFrame("Guest Details");
    	JLabel guestDetlabel = new JLabel("KARLO DETAILS");
    	JButton progressLabel1 = new JButton("Flights");
    	JLabel progressdot1 = new JLabel(" • • • • • • •");
    	JButton progressLabel2 = new JButton("Details");
    	JLabel progressdot2 = new JLabel(" • • • • • • •");
    	JButton progressLabel3 = new JButton("Payments");
    	JLabel progressdot3 = new JLabel(" • • • • • • •");
    	JButton progressLabel4 = new JButton("Confirmation");


    	JTextField fname_tf = new JTextField();
    	JTextField mname_tf = new JTextField();
    	JTextField lname_tf = new JTextField();
    	JLabel fname_label = new JLabel("First name");
    	JLabel mname_label = new JLabel("Middle name");
    	JLabel lname_label = new JLabel("Last name");

    	JLabel bdate_label = new JLabel("Date of birth");
		JXDatePicker birthdate = new JXDatePicker();
        birthdate.setDate(Calendar.getInstance().getTime());
        birthdate.setFormats(new SimpleDateFormat("MM.dd.yyyy"));

    	String[] userNationality = {"Filipino", "Korean", "Indian", "American", "Japanese", "Chinese", "Australian"};
    	JLabel nationality_label = new JLabel("Nationality");
    	JComboBox nationality_cbox = new JComboBox(userNationality);

    	JLabel contactNum_label = new JLabel("Contact number");
    	JTextField contactNum_tf = new JTextField();
    	JLabel email_label = new JLabel("Email");
    	JTextField email_tf = new JTextField();

    	String agreementPolicy = "<html>I confirm that I have read, understood, and agree to the updated Lakbay Airlines Privacy Policy,<br>which provides additional information on how my on how my Personal Information is used.</html>";
    	JCheckBox policy_chb = new JCheckBox(agreementPolicy);

    	// changed  Jbutton to RoundedButton
		RoundedButton back_btn = new RoundedButton("Back");
    	RoundedButton cont_btn = new RoundedButton("Continue");


    	//action listeners

    	policy_chb.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){

    			if (policy_chb.isSelected()){
    				cont_btn.setEnabled(true);
				} else {
    				cont_btn.setEnabled(false);
				}

    		}
    	});

    	cont_btn.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			fname = fname_tf.getText();
    			mname = mname_tf.getText();
		        lname = lname_tf.getText();
		        contact = contactNum_tf.getText();
		        email = email_tf.getText();

		        // vadidate inputs
		        String validationMessage = validateInputs(fname_tf, mname_tf, lname_tf, contactNum_tf, email_tf);
                if (validationMessage != null) {
                    JOptionPane.showMessageDialog(guestFrame, "Kindly check the following details: \n"+validationMessage, "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(guestFrame, "Success! Thank you. ", "Success", JOptionPane.INFORMATION_MESSAGE);
                }

    		}
    	});




    	// components properties

    	guestDetlabel.setBounds(180,140,200,30);
    	progressLabel1.setBounds(160,50,130,30);
    	progressLabel2.setBounds(340,50,130,30);
    	progressLabel3.setBounds(520,50,130,30);
    	progressLabel4.setBounds(700,50,130,30);

    	progressLabel1.setEnabled(false);
    	progressLabel2.setEnabled(false);
    	progressLabel3.setEnabled(false);
    	progressLabel4.setEnabled(false);

    	progressdot1.setBounds(289,50,100,30);
    	progressdot2.setBounds(469,50,100,30);
    	progressdot3.setBounds(649,50,100,30);


		fname_label.setBounds(180,180,200,30);
    	mname_label.setBounds(390,180,200,30);
    	lname_label.setBounds(600,180,200,30);
    	fname_tf.setBounds(180,210,200,30);
    	mname_tf.setBounds(390,210,200,30);
    	lname_tf.setBounds(600,210,200,30);

		bdate_label.setBounds(180,250,200,30);
    	birthdate.setBounds(180,280,300,30);
    	nationality_label.setBounds(500,250,200,30);
    	nationality_cbox.setBounds(500,280,300,30); //textfield for now muna

		contactNum_label.setBounds(180,320,200,30);
    	contactNum_tf.setBounds(180,350,300,30);
    	email_label.setBounds(500,320,200,30);
    	email_tf.setBounds(500,350,300,30);
    	policy_chb.setBounds(180,400,650,60);
    	back_btn.setBounds(585,475,80,30);
    	cont_btn.setBounds(685,475,110,30);
    	cont_btn.setEnabled(false);
    	//jop_validationmessage.setBounds(0,0,30,30);


    	// colors
    	// colors
    	// colors
    	Container contentPane = guestFrame.getContentPane();
        contentPane.setBackground(Color.WHITE);

    	cont_btn.setBackground(Color.BLACK);
    	cont_btn.setForeground(Color.WHITE);

    	progressLabel1.setBackground(Color.WHITE);
    	progressLabel2.setBackground(Color.decode("#000000"));
    	progressLabel2.setForeground(Color.WHITE);
    	progressLabel3.setBackground(Color.WHITE);
    	progressLabel4.setBackground(Color.WHITE);
    	nationality_cbox.setBackground(Color.WHITE);
    	nationality_cbox.setForeground(Color.BLACK);
    	policy_chb.setBackground(Color.WHITE);

    	//font
      	guestDetlabel.setFont(new Font("Arial", Font.BOLD, 20));
        progressLabel1.setFont(new Font("Arial", Font.BOLD, 14));
        progressLabel2.setFont(new Font("Arial", Font.BOLD, 14));
        progressLabel3.setFont(new Font("Arial", Font.BOLD, 14));
        progressLabel4.setFont(new Font("Arial", Font.BOLD, 14));

        progressdot1.setFont(new Font("Arial", Font.PLAIN, 12));
        progressdot2.setFont(new Font("Arial", Font.PLAIN, 12));
        progressdot3.setFont(new Font("Arial", Font.PLAIN, 12));

        fname_label.setFont(new Font("Arial", Font.BOLD, 14));
        mname_label.setFont(new Font("Arial", Font.BOLD, 14));
        lname_label.setFont(new Font("Arial", Font.BOLD, 14));
        fname_tf.setFont(new Font("Arial", Font.PLAIN, 14));
        mname_tf.setFont(new Font("Arial", Font.PLAIN, 14));
        lname_tf.setFont(new Font("Arial", Font.PLAIN, 14));

        bdate_label.setFont(new Font("Arial", Font.BOLD, 14));
        birthdate.setFont(new Font("Arial", Font.PLAIN, 14));
        nationality_label.setFont(new Font("Arial", Font.BOLD, 14));
        nationality_cbox.setFont(new Font("Arial", Font.PLAIN, 14));

        contactNum_label.setFont(new Font("Arial", Font.BOLD, 14));
        contactNum_tf.setFont(new Font("Arial", Font.PLAIN, 14));
        email_label.setFont(new Font("Arial", Font.BOLD, 14));
        email_tf.setFont(new Font("Arial", Font.PLAIN, 14));

        policy_chb.setFont(new Font("Arial", Font.PLAIN, 14));
        back_btn.setFont(new Font("Arial", Font.BOLD, 14));
        cont_btn.setFont(new Font("Arial", Font.BOLD, 14));


    	back_btn.setBackground(Color.WHITE);


		// guess frame properties


    	guestFrame.setBounds(0,0,1000,600);
    	guestFrame.setVisible(true);
    	guestFrame.setLayout(null);
    	guestFrame.setLocationRelativeTo(null);
    	guestFrame.setBackground(Color.WHITE);



    	guestFrame.add(guestDetlabel);
    	guestFrame.add(progressLabel1);
    	guestFrame.add(progressLabel2);
    	guestFrame.add(progressLabel3);
    	guestFrame.add(progressLabel4);
    	guestFrame.add(progressdot1);
    	guestFrame.add(progressdot2);
    	guestFrame.add(progressdot3);

    	guestFrame.add(fname_tf);
    	guestFrame.add(mname_tf);
    	guestFrame.add(lname_tf);
    	guestFrame.add(fname_label);
    	guestFrame.add(mname_label);
    	guestFrame.add(lname_label);

    	guestFrame.add(bdate_label);
    	guestFrame.add(birthdate);
    	guestFrame.add(nationality_label);
    	guestFrame.add(nationality_cbox);

    	guestFrame.add(contactNum_label);
    	guestFrame.add(contactNum_tf);
    	guestFrame.add(email_label);
    	guestFrame.add(email_tf);
    	guestFrame.add(policy_chb);
    	guestFrame.add(back_btn);
    	guestFrame.add(cont_btn);


    }



// NEW VALIDATION OF GUEST DETAILSSSS
    private static String validateInputs(
    	JTextField fname_tf,
        JTextField mname_tf,
        JTextField lname_tf,
        JTextField contactNum_tf,
        JTextField email_tf
    	) {
    List<String> invalidInputs = new ArrayList<>();


    // Validate fname
    if (!isValidName(fname)) {
        invalidInputs.add("Invalid first name.");
        fname_tf.setText("");
    }

    // Validate mname
    if (!isValidName(mname)) {
        invalidInputs.add("Invalid middle name.");
        mname_tf.setText("");
    }

    // Validate lname
    if (!isValidName(lname)) {
        invalidInputs.add("Invalid last name.");
        lname_tf.setText("");
    }

    // Validate contactNum
    if (!isValidContactNumber(contact)) {
        invalidInputs.add("Invalid contact number.");
        contactNum_tf.setText("");
    }

    // Validate email address
    if (!isValidEmail(email)) {
        invalidInputs.add("Invalid email address.");
        email_tf.setText("");
    }

    // Check if there are any invalid inputs
    if (!invalidInputs.isEmpty()) {
        // merges all the invalid inputs
        return String.join("\n", invalidInputs);
    }

    // No invalid inputs
    return null;
	}

	// Validation func
	private static boolean isValidName(String name) {
	    return name.matches("[a-zA-Z]+");
	}

	private static boolean isValidContactNumber(String contact) {
	    return contact.matches("\\d+");
	}

	private static boolean isValidEmail(String email) {
	    return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
	}



// NEW CODE FOR BORDER RADIUSSSS

	public static class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.white);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
    }
}


}

