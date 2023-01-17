import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class testFrame extends JFrame{
    JFrame frame = new JFrame("UNIVERSITY OF VALORANT");
    JFrame frame2 = new JFrame("Registration");
    JFrame frame3 = new JFrame("Student Information System");
    JPanel home = new JPanel();
    JPanel landingP = new JPanel();
    JPanel registerP = new JPanel();
    JLabel loginLabel = new JLabel("Log In");
    JLabel fnameLabel = new JLabel("First Name:");
    JLabel lnameLabel = new JLabel("Last Name:");
    JComboBox <String> course = new JComboBox<>(new String[] {"Bachelor of Science Information Technology", "Bachelor of Science Hospitality Management", "Bachelor of Science Computer Science", "pogi" });
    JComboBox<Integer> year = new JComboBox<>( new Integer[] { 1, 2, 3, 4});
    JLabel courseLabel = new JLabel("Course:");
    JLabel yearLabel = new JLabel("Year:");
    JTextField fnameField = new JTextField(10);
    JTextField lnameField = new JTextField(10); 
    JLabel StnumLabel = new JLabel("Student Number:");
    JLabel PassLabel = new JLabel("Password:");
    JTextField StnumField = new JTextField(10);
    JPasswordField PassField = new JPasswordField(10);
    Font Big = new Font("Algerian", Font.BOLD, 48);
    Font Small = new Font("Times New Roman", Font.BOLD, 24);
    JButton login = new JButton();
    JButton registerNow = new JButton("Register Now");
    JButton back = new JButton("Back to login");
    JButton register = new JButton();
    JButton Exit = new JButton();
    public static void main(String[] args) {
        new testFrame();
    }
    public testFrame(){
        home.setLayout(new FlowLayout());
        home.setBackground(Color.CYAN);
        StnumField.setFont(Small);
        PassField.setFont(Small);
        StnumLabel.setFont(Small);
        PassLabel.setFont(Small);
        courseLabel.setFont(Small);
        yearLabel.setFont(Small);
        fnameLabel.setFont(Small);
        lnameLabel.setFont(Small);
        fnameField.setFont(Small);
        lnameField.setFont(Small);
        course.setFont(Small);
        year.setFont(Small);
        loginLabel.setFont(Big);
        loginLabel.setBounds(550, 100, 300, 80);
        StnumLabel.setBounds(300, 300, 300, 80);
        PassLabel.setBounds(350, 400, 300, 80);
        StnumField.setBounds(500, 325, 300, 30);
        PassField.setBounds(500, 425, 300, 30);
        login.setBounds(800, 700, 100, 30);
        login.setText("Log In");
        register.setText("Register");
        register.setBounds(400, 700, 100, 30);
        home.setLayout(null);
        home.add(loginLabel);
        home.add(login);
        home.add(register);
        home.add(StnumLabel);
        home.add(PassLabel);
        home.add(StnumField);
        home.add(PassField);
        register.addActionListener(new Register());
        login.addActionListener(new Login());
        this.setTitle("UNIVERSITY OF VALORANT");
        this.add(home);
        this.setSize(1280, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    class Register implements ActionListener{ 
        @Override
        public void actionPerformed(ActionEvent e) {
            registerP.setLayout(new FlowLayout());
            registerP.setBackground(Color.CYAN);
            registerP.setLayout(null);
            StnumField.setText("");
            StnumLabel.setBounds(680, 300, 300, 80);
            PassLabel.setBounds(750, 400, 300, 80);
            StnumField.setBounds(900, 325, 300, 30);
            PassField.setBounds(900, 425, 300, 30);
            PassField.setText("");
            loginLabel.setText("Register");
            loginLabel.setBounds(550, 200, 300, 80);
            fnameLabel.setBounds(150, 300, 300, 80);
            lnameLabel.setBounds(150, 400, 300, 80);
            fnameField.setBounds(300, 325, 300, 30);
            lnameField.setBounds(300, 425, 300, 30);
            courseLabel.setBounds(350, 480, 300, 80);
            yearLabel.setBounds(350, 550, 300, 80);
            course.setBounds(500, 500, 500, 40);
            year.setBounds(500, 580, 100, 30);
            registerNow.setBounds(400, 700, 150, 30);
            back.setBounds(800, 700, 150, 30);
            registerP.add(fnameLabel);
            registerP.add(lnameLabel);
            registerP.add(fnameField);
            registerP.add(lnameField);
            registerP.add(courseLabel);
            registerP.add(yearLabel);
            registerP.add(course);
            registerP.add(year);
            registerP.add(StnumLabel);
            registerP.add(PassLabel);
            registerP.add(StnumField);
            registerP.add(PassField);
            registerP.add(loginLabel);
            registerP.add(registerNow);
            registerP.add(back);
            frame2.add(registerP);
            dispose();
            frame2.setSize(1280, 800);
            registerNow.addActionListener(new RegisterNow());
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setVisible(true);
            frame.setVisible(false);
            frame2.setLocationRelativeTo(null);
        }
    }
    class RegisterNow implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String fname, lname, course, Stnum, pass;
            int year;
            char[] Pass;
            fname = fnameField.getText();
            lname = lnameField.getText();
            course = (String) testFrame.this.course.getSelectedItem();
            year = (int) testFrame.this.year.getSelectedItem();
            Stnum = StnumField.getText();
            Pass = PassField.getPassword();
            pass = new String(Pass);
            try {
                FileWriter fw = new FileWriter("E:\\FinalTP\\StudentLogin.txt", true);
                FileWriter fw2 = new FileWriter("E:\\FinalTP\\StudentCourse.txt", true);
                fw.write("" + Stnum + " " + pass);
                fw2.write("" + Stnum + " " + fname + " " + lname + " " + course + " " + year);
                fw2.write(System.getProperty("line.separator"));
                fw.write(System.getProperty("line.separator"));
                fw.close();
                fw2.close();
                JOptionPane.showMessageDialog(null, "Registered Successfully");
                frame2.dispose();
                home.add(loginLabel);
                loginLabel.setText("Log In");
                StnumLabel.setBounds(300, 300, 300, 80);
                PassLabel.setBounds(300, 400, 300, 80);
                StnumField.setBounds(500, 325, 300, 30);
                PassField.setBounds(500, 425, 300, 30);
                login.setBounds(800, 700, 100, 30);
                PassField.setText("");
                StnumField.setText("");
                home.add(login);
                home.add(register);
                home.add(StnumLabel);
                home.add(PassLabel);
                home.add(StnumField);
                home.add(PassField);
                login.addActionListener(new Login());
                frame.add(home);
                frame.setVisible(true);
                frame.setSize(1280, 800);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }
    class Login implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String Stnum, pass;
            char[] Pass;
            Stnum = StnumField.getText();
            Pass = PassField.getPassword();
            pass = new String(Pass);
            try {
                FileReader fr = new FileReader("E:\\FinalTP\\StudentLogin.txt");
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                while (line != null) {
                    String[] parts = line.split(" ");
                    String Stnum1 = parts[0];
                    String pass1 = parts[1];
                    if (Stnum.equals(Stnum1) && pass.equals(pass1)) {
                        JOptionPane.showMessageDialog(null, "Logged In Successfully");
                        frame.dispose();
                        frame3.add(landingP);
                        landingP.setLayout(null);
                        landingP.add(StnumLabel);
                        landingP.add(PassLabel);

                        landingP.add(Exit);
                        landingP.add(register);
                        landingP.add(loginLabel);
                        loginLabel.setText("Welcome ");
                        loginLabel.setBounds(500, 100, 300, 80);
                        StnumLabel.setBounds(300, 300, 300, 80);
                        PassLabel.setBounds(300, 400, 300, 80);
                        StnumField.setBounds(500, 325, 300, 30);
                        PassField.setBounds(500, 425, 300, 30);
                        login.setBounds(800, 700, 100, 30);
                        PassField.setText("");
                        StnumField.setText("");
                        Exit.setBounds(800, 700, 100, 30);
                        Exit.setText("Exit");
                        Exit.addActionListener(new Exit() );
                        
                        frame3.setSize(1280, 800);
                        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame3.setVisible(true);
                        frame3.setLocationRelativeTo(null);
                        break;
                    } else {
                        JFrame message = new JFrame();
                        JOptionPane.showMessageDialog(message, "Wrong Student Number or Password");
                        break;
                        
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        class Exit implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(ABORT);
    }
        }
    }
}