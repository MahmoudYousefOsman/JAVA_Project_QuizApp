/*
 * Import necessary packages for Swing components, graphics, and event handling
 */
package Quize;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Create a class for the login window,
 * implement ActionListener for handling button clicks
 */
public class Login extends Frames implements ActionListener {

  // Declare buttons and text field for login
  JButton Login, cancel;
  JTextField userEmail, userName;
  JLabel errorMessageLabel, heading, emaiLabel, nameLabel, errorMassageEmpty;

  // Constructor for initializing the login window
  public Login() {
    super();
    addGuiComponents();
    System.out.println("Gold You are Connected to the database on your server!");

  }

  // ######################## Methods ############################################

  private void addGuiComponents(){
    iconWorld(true);


    // ####################################################
    // Create and configure heading label
    heading = new JLabel("Quiz App");
    heading.setBounds(900, 60, 300, 45);
    heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
    heading.setForeground(Color.decode("#0099cc"));
    add(heading);

    // ####################################################

    nameLabel = new JLabel("Enter Your Name");
    nameLabel.setBounds(850, 250, 300, 20);
    nameLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
    nameLabel.setForeground(Color.BLACK);
    add(nameLabel);

    userName = new JTextField();
    userName.setBounds(850, 280, 300, 40);
    userName.setFont(new Font("Times New Roman", Font.BOLD, 20));
    add(userName);


    // ####################################################

    emaiLabel = new JLabel("Enter Your Email");
    emaiLabel.setBounds(850, 350, 300, 20);
    emaiLabel.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
    emaiLabel.setForeground(Color.BLACK);
    add(emaiLabel);

    // Create and configure text field for entering password
    userEmail = new JTextField();
    userEmail.setBounds(850, 380, 300, 40);
    userEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
    add(userEmail);

    // ####################################################

    // Create and configure button for displaying rules
    Login = new JButton("Login");
    Login.setBounds(850, 500, 120, 40);
    Login.setBackground(Color.decode("#99e6ff"));
    Login.setForeground(Color.BLACK);
    Login.addActionListener(this);
    add(Login);

    // ###################################################
    // Create and configure button for going back
    cancel = new JButton("cancel");
    cancel.setBounds(1030, 500, 120, 40);
    cancel.setBackground(Color.decode("#99e6ff"));
    cancel.setForeground(Color.BLACK);
    cancel.setVisible(true); // Initially hidden
    cancel.addActionListener(this);
    add(cancel);

    // ####################################################

    // Create and configure error message label (initially hidden)
    errorMessageLabel = new JLabel("Invalid email or name. Please try again.");
    errorMessageLabel.setBounds(850, 450, 400, 20);
    errorMessageLabel.setFont(new Font("Arial", Font.BOLD, 14));
    errorMessageLabel.setForeground(Color.RED);
    errorMessageLabel.setVisible(false); // Initially hidden
    add(errorMessageLabel);

    // ####################################################
    errorMassageEmpty = new JLabel("Please fill all the fields");
    errorMassageEmpty.setBounds(850, 450, 400, 20);
    errorMassageEmpty.setFont(new Font("Arial", Font.BOLD, 14));
    errorMassageEmpty.setForeground(Color.RED);
    errorMassageEmpty.setVisible(false); // Initially hidden
    add(errorMassageEmpty);

    // Ensure all components are laid out and visible
    repaint();
  }

  // ############################################################

  private void iconWorld(boolean status){
    ImageIcon shieldIcon = new ImageIcon(getClass().getResource("/icons/world-creativity-and-innovation-day.gif"));
    JLabel shieldLabel = new JLabel(shieldIcon);
    shieldLabel.setSize(shieldIcon.getIconWidth() , shieldIcon.getIconHeight());
    shieldLabel.setBounds(0, 0, 700, 700);
    add(shieldLabel);
    shieldLabel.setVisible(status);
  }

  // ################################################################

//  // Method to validate email and password
  // ################################################################

  private void isEqualLogin(){
    // Get email and password from text fields
    String email = userEmail.getText();
    String name = userName.getText();

    heading.setText("Quize App");
    heading.setBounds(900, 60, 300, 45);
    userEmail.setText(""); // Clear text fields
    userName.setText("");
    errorMessageLabel.setVisible(false);
    errorMassageEmpty.setVisible(false);
    // Check if email and password are empty
    if (email.isEmpty() || name.isEmpty()) {
      errorMassageEmpty.setVisible(true);
    } else {
      iconWorld(false);
      new Home(name);
      setVisible(false);

      try {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, email);
        statement.executeUpdate();

        System.out.println("User data inserted successfully!");
        statement.close();
      } catch (SQLException e) {
        System.out.println("Database connection error: " + e.getMessage());
      }
    }

  }

  private void isEqaul_cancel(){
    userEmail.setText(""); // Clear text fields
    userName.setText("");
  }

  // ########################## Events ##########################################
  // Method to handle button clicks
  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == Login) {
      isEqualLogin();
    }
    else if(e.getSource() == cancel){
      isEqaul_cancel();
    }
  }

}
