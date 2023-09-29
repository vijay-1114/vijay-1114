package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdrawl,back;
    String pnumber;
    
    
    Withdrawl(String pnumber){
        
        this.pnumber=pnumber; 
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel Image=new JLabel(i3);
        Image.setBounds(0,0,900,900);
        add(Image);
        
        JLabel text =new JLabel("Enter the Amount you want to Withdrawl");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBackground(Color.WHITE);
        text.setForeground(Color.WHITE);
        text.setBounds(170,300,400,20);
        Image.add(text);
        
        amount=new JTextField("");
        amount.setFont(new Font("Raleway",Font.BOLD,16));
        amount.setBounds(170,350,320,25);
        Image.add(amount);
        
        withdrawl=new JButton("Withdrawl");
        withdrawl.setBounds(355,485,150,30);
        withdrawl.addActionListener(this);
        Image.add(withdrawl);
        
        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        Image.add(back);
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
                                      
     
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdrawl){
            String number = amount.getText();
            Date date= new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the amount you want to Withdrawl");
            }
            else{
                try{
                Conn conn= new Conn();
                String query="insert into bank values('"+pnumber+"','"+date+"','withdrawl','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+number+" Withdrawl Sucessfully");
                setVisible(false);
                new Transaction(pnumber).setVisible(true);
            }
            
                catch(Exception e){
                    System.out.println(e);
                }
            }
                    
        }else if(ae.getSource()==back){
            setVisible(false);
           new Transaction(pnumber).setVisible(true); 
        }
    }
    

    public static void main(String args[]) {
        new Withdrawl("");
    }
}
