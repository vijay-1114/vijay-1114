package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupTwo extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6,c7;
    JButton submite,cancel;
    String formno;

    SignupTwo(String formno) {
        this.formno=formno;
        setLayout(null);
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel accountType = new JLabel(" Account Type :");
        accountType.setFont(new Font("Raleway", Font.BOLD, 18));
        accountType.setBounds(100, 140, 200, 30);
        add(accountType);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
//r1.setForeground(Color.WHITE);
        r1.setBounds(100, 180, 150, 30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 150, 30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 30);
        add(r4);

        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        JLabel card = new JLabel(" Card No:");
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        card.setBounds(100, 300, 200, 22);
        add(card);

        JLabel number = new JLabel(" XXXX-XXXX-XXXX-4184 ");
        number.setFont(new Font("Raleway", Font.BOLD, 18));
        number.setBounds(320, 300, 250, 22);
        add(number);

        JLabel carddetails = new JLabel(" Your 16-digit Card Number ");
        carddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetails.setBounds(100, 320, 250, 22);
        add(carddetails);

        JLabel pin = new JLabel(" Pin No:");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(100, 360, 200, 22);
        add(pin);

        JLabel pnumber = new JLabel(" XXXX ");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 18));
        pnumber.setBounds(320, 360, 250, 22);
        add(pnumber);

        JLabel pindetails = new JLabel(" Your 4-digit Pin Number ");
        pindetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetails.setBounds(100, 380, 250, 22);
        add(pindetails);

        JLabel services = new JLabel(" Service Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(100, 440, 200, 22);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 12));
        c1.setBounds(100, 470, 130, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 12));
        c2.setBounds(290, 470, 130, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 12));
        c3.setBounds(480, 470, 130, 30);
        add(c3);

        c4 = new JCheckBox("Email/SMS Alerts.!");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 12));
        c4.setBounds(100, 500, 130, 30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 12));
        c5.setBounds(290, 500, 130, 30);
        add(c5);

        c6 = new JCheckBox("E Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 12));
        c6.setBounds(480, 500, 130, 30);
        add(c6);
        
        c7 = new JCheckBox("I Hereby declares that the above entered details are correct to the best of my knowledge.... ");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 10));
        c7.setBounds(100, 550, 510, 25);
        add(c7);

        submite = new JButton("Submite");
        submite.setBackground(Color.BLACK);
        submite.setForeground(Color.WHITE);
        submite.setFont(new Font("Raleway",Font.BOLD,14));
        submite.setBounds(200,660,100,30);
        submite.addActionListener(this);
        add(submite);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(400,660,100,30);
       cancel.addActionListener(this);
        add(cancel);
       
     
                                      
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submite){
            
        String accountType = null;
        if(r1.isSelected()){
            accountType="Saving Account";
        }
        else if(r2.isSelected()){
            accountType="Fixed Deposite Account";
        }
        else if(r3.isSelected()){
            accountType="Current Account";
        }
        else if(r4.isSelected()){
            accountType="Recurring Deposite Account";
        }
           
        Random random=new Random();
        String cardno="" + Math.abs((random.nextLong() % 900000L) + 5040936000000000L);
        String pnumber="" + Math.abs((random.nextLong()%+9000L)+1000L);
        String facility="";
        if (c1.isSelected()){
            facility = facility + "ATM Card";
            }
        else if(c2.isSelected()){
            facility=facility+"Internet Banking";
        }
        else if(c3.isSelected()){
            facility=facility+"Mobile Banking";
        }
        else if(c4.isSelected()){
            facility=facility+"Email/SMS Alert!";
        }
        else if(c5.isSelected()){
            facility=facility+"Cheque Book";
        }
        else if(c6.isSelected()){
            facility=facility+"E-Statement";
        }
         try{
            
            if(accountType.equals("")){
                JOptionPane.showMessageDialog(null,"Account Type is Required");
            }
            else{              
                Conn conn=new Conn();
                String query1="insert into SignupTwo values('"+formno+"','"+accountType+"','"+cardno+"','"+pnumber+"','"+facility+"')";
                String query2="insert into login values('"+formno+"','"+cardno+"','"+pnumber+"')";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Card No:"+cardno + "\n Pin No:" +pnumber);
                setVisible(false);
                new Deposite(pnumber).setVisible(false);
            }
            
         }
            catch (Exception e){
            System.out.println(e);
        }       

        
        } else if(ae.getSource()==cancel){
         setVisible(false);
         new Login().setVisible(true);
    
        }  
     }
    public static void main(String args[]) {
        new SignupTwo("");
    }

}
