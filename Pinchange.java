package bank.managment.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener {
    
JPasswordField pin,repin;

JButton change,back;
String pnumber;

Pinchange(String pnumber){
    this.pnumber=pnumber;
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);

JLabel text=new JLabel("Change Your PIN");
text.setForeground(Color.WHITE);
text.setBackground(Color.WHITE);
text.setFont(new Font("System",Font.BOLD,16));
text.setBounds(250,280,500,35);
image.add(text);


JLabel pintext =  new JLabel("New PIN :");
pintext.setForeground(Color.WHITE);
pintext.setBackground(Color.WHITE);
pintext.setFont(new Font("System",Font.BOLD,16));
pintext.setBounds(165,320,180,25);
image.add(pintext);

 pin=new JPasswordField();
pin.setFont(new Font("Raleway",Font.BOLD,16));
pin.setBounds(330,320,180,25);
image.add(pin);


 JLabel repintext=new JLabel("Re-Enter PIN :");
repintext.setForeground(Color.WHITE);
repintext.setBackground(Color.WHITE);
repintext.setFont(new Font("System",Font.BOLD,16));
repintext.setBounds(165,350,180,25);
image.add(repintext);

 repin=new JPasswordField();
repin.setFont(new Font("Raleway",Font.BOLD,16));
repin.setBounds(330,350,180,25);
image.add(repin);

 change=new JButton("Change");
change.setBackground(Color.WHITE);
change.setForeground(Color.BLACK);
change.setBounds(360,450,120,25);
change.addActionListener(this);
image.add(change);

back=new JButton("Back");
back.setBackground(Color.WHITE);
back.setForeground(Color.BLACK);
back.setBounds(360,490,120,25);
back.addActionListener(this);
image.add(back);




setSize(900,900);
setLocation(300,0);
setUndecorated(true);
setVisible(true);
}   
public  void actionPerformed(ActionEvent ae){
    if(ae.getSource()==change){
try{
    String npin=pin.getText();
    String rpin=repin.getText();
    
    if(!npin.equals(rpin)){
        JOptionPane.showMessageDialog(null,"Entered PIN does not Match");
        return;
    }
    if(npin.equals("")){
        JOptionPane.showMessageDialog(null,"Please Enter PIN");
        return;
        
    }
    if(rpin.equals("")){
        
        JOptionPane.showMessageDialog(null,"Please Re-Entered PIN");
        return;
    }
    Conn conn=new Conn();
    String query1="update bank set pnumber='"+rpin+"' where pnumber='"+pnumber+"'";
    String query2="update login set pnumber='"+rpin+"' where pnumber='"+pnumber+"'";
    String query3="update SignupTwo set pnumber='"+rpin+"' where pnumber='"+pnumber+"'";
    conn.s.executeUpdate(query1);
     conn.s.executeUpdate(query2);
    conn.s.executeUpdate(query3);
    JOptionPane.showMessageDialog(null,"PIN Changed succesfully");
    setVisible(false);
    new Transaction(rpin).setVisible(true);

}catch(Exception e){
    
    System.out.println(e);
  } 
    }else{
        setVisible(false);
        new Transaction(pnumber).setVisible(true);
    }
    
}
    public static void main(String args[]) {
        new Pinchange("").setVisible(true);
   
    }
}
