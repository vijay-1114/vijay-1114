
package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposite,withdrawl,miniStatement,balanceEnquiry,fastCash,exit,pinChange;
    String pnumber;
   Transaction(String pnumber){
       this.pnumber=pnumber;
       setLayout(null);
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
       ImageIcon i3=new ImageIcon(i2);
       JLabel Image=new JLabel(i3);
       Image.setBounds(0,0,900,900);
       add(Image);
                                     
       JLabel text =new JLabel("Please select Your Transaction");
       text.setBounds(210,300,700,35);
       text.setBackground(Color.WHITE);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,16));
       Image.add(text);
       
      deposite=new JButton("Deposite");
       deposite.setBounds(170,415,150,30);
      deposite.addActionListener(this);
       Image.add(deposite);
       
       withdrawl=new JButton("Cash Withdrawl");
       withdrawl.setBounds(355,415,150,30);
       withdrawl.addActionListener(this);
       Image.add(withdrawl);
       
       
       fastCash=new JButton("Fast Cash");
       fastCash.setBounds(170,450,150,30);
      fastCash.addActionListener(this);
         Image.add(fastCash);
       
       miniStatement=new JButton("Mini Statement");
       miniStatement.setBounds(355,450,150,30);
       miniStatement.addActionListener(this);
       Image.add(miniStatement);
       
       pinChange=new JButton("Pin Change");
       pinChange.setBounds(170,485,150,30);
       pinChange.addActionListener(this);
      Image.add(pinChange);
       
       balanceEnquiry=new JButton("Balance Enquiry");
       balanceEnquiry.setBounds(355,485,150,30);
       balanceEnquiry.addActionListener(this);
       Image.add(balanceEnquiry);
       
       exit=new JButton("Exit");
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
               System.exit(0);
           }else if(ae.getSource()==deposite){
               setVisible(false);
               new Deposite(pnumber).setVisible(true);
           }else if(ae.getSource()==withdrawl){
               setVisible(false);
               new Withdrawl(pnumber).setVisible(true);}
           else if(ae.getSource()==fastCash){
              setVisible(false);
              new Fastcash(pnumber).setVisible(true);
           }
            else if(ae.getSource()==pinChange){
                setVisible(false);
                new Pinchange(pnumber).setVisible(true);
            }
           else if(ae.getSource()==balanceEnquiry){
                setVisible(false);
                new BalanceEnquiry(pnumber).setVisible(true);
           }else if(ae.getSource()==miniStatement){
             
             new MiniStatement(pnumber).setVisible(true);
                                            
     
        }
                                                    
       }
        
    
    public static void main(String args[]) {
        new Transaction("");
         }
}
