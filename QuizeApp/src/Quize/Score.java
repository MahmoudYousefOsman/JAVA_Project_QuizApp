package Quize;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Score extends Frames implements ActionListener {

  String name;

  Score(String name, int score) {
    super();

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png"));
    Image i2 = i1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0, 200, 300, 250);
    add(image);

    JLabel heading = new JLabel("Thank you " + name + " for Submiting Simple Minds");
    heading.setBounds(45, 30, 700, 30);
    heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
    add(heading);

    JLabel lblscore = new JLabel("Your score is " + score);
    lblscore.setBounds(350, 200, 300, 30);
    lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
    add(lblscore);

    JButton EXIT = new JButton("EXIT");
    EXIT.setBounds(380, 270, 120, 30);
    EXIT.setBackground(new Color(30, 144, 255));
    EXIT.setForeground(Color.blue);
    EXIT.addActionListener(this);
    add(EXIT);

    updateScoreInDatabase(name, score);
  }

  public void updateScoreInDatabase(String name, int score) {

    try{
      String updateScoreQuery = "UPDATE users SET score = ? WHERE name = ?";
      try (PreparedStatement statement = connection.prepareStatement(updateScoreQuery)) {
        statement.setInt(1, score);
        statement.setString(2, name);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
          System.out.println("Score updated successfully for user: " + name);
        } else {
          System.out.println("User not found or score not updated.");
        }
      }
    } catch (SQLException e) {
      System.out.println("Error updating score: " + e.getMessage());
    }
  }
  @Override
  public void actionPerformed(ActionEvent ae) {
    System.exit(0);

  }




}
