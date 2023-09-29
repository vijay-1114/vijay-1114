
package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class Fastcash extends JFrame implements ActionListener{
    
    JButton deposite,withdrawl,miniStatement,balanceEnquiry,fastCash,exit,pinChange;
    String pnumber;
   Fastcash(String pnumber){
       this.pnumber=pnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel Image=new JLabel(i3);
       Image.setBounds(0,0,900,900);
       add(Image);
                                     
       JLabel text =new JLabel("Select Withdrawl Amount");
       text.setBounds(210,300,700,35);
       text.setBackground(Color.WHITE);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,16));
       Image.add(text);
       
      deposite=new JButton("Rs 100");
       deposite.setBounds(170,415,150,30);
      deposite.addActionListener(this);
       Image.add(deposite);
       
       withdrawl=new JButton("Rs 500");
       withdrawl.setBounds(355,415,150,30);
       withdrawl.addActionListener(this);
       Image.add(withdrawl);
       
       
       fastCash=new JButton("Rs 1000");
       fastCash.setBounds(170,450,150,30);
      fastCash.addActionListener(this);
         Image.add(fastCash);
       
       miniStatement=new JButton("Rs 2000");
       miniStatement.setBounds(355,450,150,30);
       miniStatement.addActionListener(this);
       Image.add(miniStatement);
       
       pinChange=new JButton("Rs 5000");
       pinChange.setBounds(170,485,150,30);
       pinChange.addActionListener(this);
      Image.add(pinChange);
       
       balanceEnquiry=new JButton("Rs 10000");
       balanceEnquiry.setBounds(355,485,150,30);
       balanceEnquiry.addActionListener(this);
       Image.add(balanceEnquiry);
       
       exit=new JButton("BACK");
       exit.setBounds(355,520,150,30);
       exit.addActionListener(this);
       Image.add(exit);
       
      
       
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
       
   }
       public void actionPerformed(ActionEvent ae){
           if (ae.getSource() == exit){
               setVisible(false);
               new Transaction(pnumber).setVisible(true);
           }else {
               String amount=((JButton)ae.getSource()).getText().substring(3);
               Conn c=new Conn();
           
               try{
                   ResultSet rs=c.s.executeQuery("select * from bank where pnumber = '"+pnumber+"'");
                   int balance=0;
                   while(rs.next()){
                       if(rs.getString("type").equals("Deposite"))
                       {
                       balance+=Integer.parseInt(rs.getString("amount"));
                       }
                       else
                     {
                   balance -= Integer.parseInt(rs.getString("amount"));
                   }
                   }
                   if(ae.getSource()!= exit && balance < Integer.parseInt(amount)){
                     JOptionPane.showMessageDialog(null,"Insufficent Balance");
                     return;
                 }
                   
                 Date date=new Date();
                 String query="insert into bank values('"+pnumber+"','"+date+"','withdrawl','"+amount+"')";
                 c.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited Sucessfully");
                 
                 setVisible(false);
                 new Transaction(pnumber).setVisible(true);
               }catch(Exception e){
                   System.out.println(e);
               }
           }
                                                    
       }
    public static void main(String args[]) {
        new Fastcash("");
         }
}
