package Quize;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Home extends Frames implements ActionListener{
  // Declare variables for player name, start button, and back button
  String name;
  JButton startButton, exitButton, BackButton;
  JLabel heading;

  // Constructor for initializing the Rules window with the player's name
  Home(String name) {
    super();
    this.name = name;
    addGuiComponents();
  }

  //################################### Mehtods ############################################
  private void addGuiComponents(){

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/Home.png"));
    Image image = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
    ImageIcon resizedIcon = new ImageIcon(image);
    JLabel imageLabel = new JLabel(resizedIcon);
    imageLabel.setBounds(870, 50, 400, 400);
    add(imageLabel);

    // title label
    heading = new JLabel("Welcome " + name + " to Simple Minds");
    heading.setBounds(500, 20, 700, 30);
    heading.setFont(new Font("Cascadia Code Light", Font.BOLD, 28));
    heading.setForeground(new Color(30, 144, 254));
    add(heading);

    JLabel rule = new JLabel("Rules you should follow before start quiz :-");
    rule.setFont(new Font("Arial", Font.BOLD, 16));
    rule.setForeground(Color.red);
    rule.setBounds(5, 70, 700, 30);
    add(rule);

    JLabel text = new JLabel("1-This Quiz contains ten question in java.");
    text.setFont(new Font("Arial", Font.BOLD, 16));
    text.setBounds(5, 120, 700, 30);
    add(text);

    JLabel text1 = new JLabel("2-The Quiz is to find the best answer for multiple choice questions.");
    text1.setFont(new Font("Arial", Font.BOLD, 16));
    text1.setBounds(5, 170, 700, 30);
    add(text1);
    JLabel text2 = new JLabel("3-You must choose an answer in the quiz.");
    text2.setFont(new Font("Arial", Font.BOLD, 16));
    text2.setBounds(5, 220, 700, 30);
    add(text2);

    JLabel text3 = new JLabel("4-The Quiz contains a timer if the timer runs out,the score will be displayed.");
    text3.setFont(new Font("Arial", Font.BOLD, 16));
    text3.setBounds(5, 270, 700, 30);
    add(text3);

    JLabel text4 = new JLabel("5-If you press the start,the quiz will start.");
    text4.setFont(new Font("Arial", Font.BOLD, 16));
    text4.setBounds(5, 320, 700, 30);
    add(text4);

    JLabel text5 = new JLabel("6-If you press the go back,you will go to login page.");
    text5.setFont(new Font("Arial", Font.BOLD, 16));
    text5.setBounds(5, 370, 700, 30);
    add(text5);

    JLabel text6 = new JLabel("7-If you press the exit,you will exit the quiz.");
    text6.setFont(new Font("Arial", Font.BOLD, 16));
    text6.setBounds(5, 420, 700, 30);
    add(text6);




    // start button
    startButton = new JButton("Start");
    startButton.setFont(new Font("Arial", Font.BOLD, 16));
    startButton.setBounds(100, 500, 200, 40);
    startButton.setBackground(Color.decode("#99e6ff"));
    startButton.addActionListener(this);
    add(startButton);


    // exit button
    exitButton = new JButton("Exit");
    exitButton.setFont(new Font("Arial", Font.BOLD, 16));
    exitButton.setBounds(890, 500, 200, 40);
    exitButton.setBackground(Color.decode("#99e6ff"));
    exitButton.addActionListener(this);
    add(exitButton);


    BackButton = new JButton("Go Back");
    BackButton.setFont(new Font("Arial", Font.BOLD, 16));
    BackButton.setBounds(500, 500, 200, 40);
    BackButton.setHorizontalAlignment(SwingConstants.CENTER);
    BackButton.setBackground(Color.decode("#99e6ff"));

    BackButton.addActionListener(this);
    add(BackButton);
  }

  // ###################################################################


  // ###################################################################



  // ####################################### Events ##############################################

  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() == startButton) {
      new Quiz(name);
      Home.this.dispose();
    }
    else if (e.getSource() == exitButton) {
      // dispose of this screen
System.exit(0);
    }

    else if (e.getSource() == BackButton) {
      new Login();
      Home.this.dispose();
    }
  }



}






