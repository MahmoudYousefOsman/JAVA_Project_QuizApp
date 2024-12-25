package Quize;

import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.*;

// Parent class for setting common properties of frames
public class Frames extends JFrame {
  
  // Constructor to initialize common frame properties

    protected Connection connection;

    public Frames() {
      String url = "jdbc:mysql://localhost/pro_java";
      String user = "root";
      String password = "";
      try {
        connection = DriverManager.getConnection(url, user, password);
      } catch (SQLException e) {
        System.out.println("Database connection error: " + e.getMessage());
      }

    setTitle("Quize App"); 
    setLocation(20,20);
    setSize(1300, 700);
    setVisible(true);
    setResizable(true);
    Image i2 = new ImageIcon(this.getClass().getResource("../icons/quiz.png")).getImage();
    this.setIconImage(i2);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Set default close operation

    // Set background color and layout to null for manual component positioning
    getContentPane().setBackground(Color.decode("#ffffff"));
    setLayout(null);
  }
}
