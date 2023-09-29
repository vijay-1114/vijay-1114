
package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{
        
    JButton back;
    String pnumber;
BalanceEnquiry(String pinchnage){
    this.pnumber= pnumber;
                                 
    setLayout(null);
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);
    
    
     back=new JButton("BACK");
     back.setBounds(355,520,100,30);
     back.setBackground(Color.WHITE);
     back.setForeground(Color.BLACK);
     back.addActionListener(this);
     image.add(back);
    
     Conn c=new Conn();
     int balance=0;
      try{
        ResultSet rs=c.s.executeQuery("select * from bank where pnumber = '"+pnumber+"'");
        while(rs.next()){
            if(rs.getString("type").equals("Deposite"))
            {
            balance+=Integer.parseInt(rs.getString("amount"));
            }
            else
             {
            balance-=Integer.parseInt(rs.getString("amount"));
           }
        }
      }catch(Exception e){
          System.out.println(e);
      }
      JLabel text=new JLabel(("Your Current Account Balance is Rs. "+balance+" "));
      text.setFont(new Font("System",Font.BOLD,14));
      text.setForeground(Color.WHITE);
      text.setBounds(170,300,400,30);
      image.add(text);
    
setSize(900,900);
setLocation(300,0);
setUndecorated(true);
setVisible(true);    
}
public void actionPerformed(ActionEvent ae){
    setVisible(false);
    new Transaction(pnumber).setVisible(true);
}

    public static void main(String args[]) {
       new BalanceEnquiry("");
    }
}
