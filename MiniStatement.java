
package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.sql.ResultSet;


public class MiniStatement extends JFrame{
   
MiniStatement(String pnumber){
    
    setTitle("Mini Statement");
    setLayout(null);
    
    JLabel mini=new JLabel();
    add(mini);
        
    JLabel bank=new JLabel("Indian Bank");
    bank.setFont(new Font("System",Font.BOLD,18));
    bank.setBounds(130,20,200,30);
    add(bank);
    
    
    
    JLabel card=new JLabel();
    card.setBounds(20,80,300,20);
    add(card);
    
    JLabel balance=new JLabel();
    balance.setBounds(20,400,300,20);
    add(balance);
                  
    try{
        Conn conn=new Conn();
        ResultSet rs = conn.s.executeQuery("select * from login where pnumber = '"+pnumber+"'");
        while(rs.next()){
            card.setText("Card Number:  "+rs.getString("cardno").substring(0,4)+"xxxxxxxx" +rs.getString("cardno").substring(12));
        }
              
    }catch(Exception e){
        System.out.println(e);
    }
    
        try{
          Conn conn=new Conn();
          int bal = 0;
          ResultSet rs=conn.s.executeQuery("select * from bank where pnumber =  '"+pnumber+"'");
          while(rs.next()){
          mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount") + "<br><br><html>");
            if(rs.getString("type").equals("Deposite"))
               {
               bal+=Integer.parseInt(rs.getString("amount"));
               }
               else
                {
               bal-=Integer.parseInt(rs.getString("amount"));
              }
         }
          balance.setText("Your Current Account Balance is Rs "+bal);
          
        }catch(Exception e){
            System.out.println(e);
        }
        mini.setBounds(20,140,400,200);
            
    setSize(400,600);
    setLocation(20,20);
    getContentPane().setBackground(Color.WHITE);
    setVisible(true);
    
}
  public static void main(String args[]) {
        new MiniStatement("");
    }
}
