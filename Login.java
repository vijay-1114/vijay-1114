package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{
     JButton login,Signup,Clear;
     JTextField cardTextField;
     JPasswordField pinTextField;
    Login()
        {
            setTitle("AUTOMATED TELLER MASHINE");
            setLayout(null);
            ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons//logo.jpg"));
            Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            ImageIcon i3 = new ImageIcon(i2);
            JLabel label=new JLabel(i3);
            label.setBounds(70,10,100,100);
            add(label);

            JLabel text=new JLabel("Welcome To ATM");
            text.setFont(new Font("Osward",Font.BOLD,40));
            text.setBounds(200,40,400,40);
            add(text);

            JLabel cardno=new JLabel("Card No:- ");
            cardno.setFont(new Font("Raieway",Font.BOLD,25));
            cardno.setBounds(120,150,400,30);
            add(cardno);

            cardTextField = new JTextField();
            cardTextField.setBounds(300,150,250,30);
            cardTextField.setFont(new Font("Arial",Font.BOLD,14));
            add(cardTextField);


              JLabel pin=new JLabel("Pin:-");
              pin.setFont(new Font("Raieway",Font.BOLD,25));
              pin.setBounds(120,220,250,30);
              add(pin);

                pinTextField = new  JPasswordField  ();
                pinTextField.setBounds(300,220,250,30);
                pinTextField.setFont(new Font("Arial",Font.BOLD,14));
                add(pinTextField);


             login = new JButton("SIGN IN");
             login.setBounds(300,300,100,30);
             login.setBackground(Color.BLACK);
             login.setForeground(Color.WHITE);
             login.addActionListener(this);
             add(login);

                        
            Clear = new JButton("CLEAR");
            Clear.setBounds(430,300,100,30);
            Clear.setBackground(Color.BLACK);
            Clear.setForeground(Color.WHITE);
             Clear.addActionListener(this);
            add(Clear);

             Signup = new JButton("SIGN UP");
             Signup.setBounds(300,350,230,30);
             Signup.setBackground(Color.BLACK);
             Signup.setForeground(Color.WHITE);
             Signup.addActionListener(this);
             add(Signup);



            getContentPane().setBackground(Color.WHITE);
            setSize(800,480);
            setVisible(true);
            setLocation(350,200);
        }
        public void actionPerformed(ActionEvent ae)
        {
          if (ae.getSource() == Clear)
           {
               cardTextField.setText("");
                pinTextField.setText("");
                                

            }
            else if (ae.getSource() == login)
            {
                Conn conn = new Conn();
                String cardno=cardTextField.getText();
                String pnumber=pinTextField.getText();
                String query="select * from login where cardno= '"+cardno+"' and pnumber= '"+pnumber+"'" ;     
                try{
                    ResultSet rs =  conn.s.executeQuery(query);
                    if(rs.next()){
                        setVisible(false);
                        new Transaction(pnumber).setVisible(true);
                        }
                    else{
                        JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                    }
                }catch(Exception e)
                {
                    System.out.println(e);
                    
                }
            }
            else if (ae.getSource() == Signup)
            {
                setVisible(false);
                new Signup().setVisible(true);
            }

        }
        public static void main(String[] args)
        {
          new Login();
          
        

        }
    
}



    



