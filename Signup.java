package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class Signup extends JFrame implements ActionListener{
    long random;
    JTextField usernameTextField,fnameTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male,female,other,maried,Unmaried;
    JDateChooser dateChooser;
    Signup()
    {
        setLayout(null);
        Random ran=new Random();
        random=Math.abs((ran.nextLong()%5000L));


        JLabel formno=new JLabel("Application form no:-"+random);
        formno.setFont(new Font("Raleway",Font.BOLD,36));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel PersonalDetails=new JLabel("page1:Personal Details");
        PersonalDetails.setFont(new Font("Raleway",Font.BOLD,16));
        PersonalDetails.setBounds(290,80,300,30);
        add(PersonalDetails);
        
          JLabel username =new JLabel("Name:");
        username.setFont(new Font("Raleway",Font.BOLD,16));
        username.setBounds(100,140,100,30);
        add(username);
        
        
        usernameTextField=new JTextField();
        usernameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        usernameTextField.setBounds(250,140,400,30);
        add(usernameTextField);




        JLabel Fname=new JLabel("Father N. :");
       Fname.setFont(new Font("Ralway",Font.BOLD,16));
       Fname.setBounds(100,170,170,30);
        add(Fname);

        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(250,170,400,30);
        add(fnameTextField);




        JLabel dob=new JLabel("Date Of Birth:");
        dob.setFont(new Font("Ralway",Font.BOLD,16));
        dob.setBounds(100,200,170,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(250,200,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        



        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Ralway",Font.BOLD,16));
        gender.setBounds(100,230,170,30);
        add(gender);

        

        male= new JRadioButton("Male");
        male.setBounds(250,230,70,30);
        male.setBackground(Color.WHITE);
        add(male);

       
        female= new JRadioButton("Female");
        female.setBounds(500,230,70,30);
        female.setBackground(Color.WHITE);
        add(female);


        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);


        JLabel email=new JLabel("Email:");
        email.setFont(new Font("Ralway",Font.BOLD,16));
        email.setBounds(100,260,170,30);
        add(email);


        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(250,260,400,30);
        add(emailTextField);





        JLabel martial=new JLabel("Marital Status:");
        martial.setFont(new Font("Ralway",Font.BOLD,16));
        martial.setBounds(100,290,170,30);
        add(martial);


        maried= new JRadioButton("Maried");
        maried.setBounds(250,290,70,30);
        maried.setBackground(Color.WHITE);
        add(maried);

       
        Unmaried= new JRadioButton("Unmaried");
        Unmaried.setBounds(420,290,100,30);
        Unmaried.setBackground(Color.WHITE);
        add(Unmaried);

        other= new JRadioButton("Other");
        other.setBounds(580,290,70,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup martialGroup=new ButtonGroup();
        martialGroup.add(maried);
        martialGroup.add(Unmaried);
        martialGroup.add(other);




        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Ralway",Font.BOLD,16));
        address.setBounds(100,320,170,30);
        add(address);

        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(250,320,400,30);
        add(addressTextField);




        JLabel city=new JLabel(" City:");
        city.setFont(new Font("Ralway",Font.BOLD,16));
        city.setBounds(100,350,170,30);
        add(city);

        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(250,350,400,30);
        add(cityTextField);




        JLabel state=new JLabel("State:");
        state.setFont(new Font("Ralway",Font.BOLD,16));
        state.setBounds(100,380,170,30);
        add(state);

        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(250,380,400,30);
        add(stateTextField);




        JLabel pincode=new JLabel("Pin Code:");
        pincode.setFont(new Font("Ralway",Font.BOLD,16));
        pincode.setBounds(100,410,170,30);
        add(pincode);

        pincodeTextField=new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pincodeTextField.setBounds(250,410,400,30);
        add(pincodeTextField);


        next=new JButton("Next");
        next.setBackground(Color.BLACK);
         next.setForeground(Color.WHITE);
         next.setFont(new Font("Ralway",Font.BOLD,14));
         next.setBounds(550,470,100,30);
         next.addActionListener(this);
         add(next);

        
        
      
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String formno= "" +random;  //long convert into string
        String name=usernameTextField.getText();
        String fname=fnameTextField.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }
        else if(female.isSelected()){
            gender="female";
            
        }
        String email=emailTextField.getText();
        String marital=null;
        if(maried.isSelected()){
            marital="maried";
        }
        else if(Unmaried.isSelected()){
            marital="Unmaried";
        }
        else if(other.isSelected()){
            marital="other";
        }
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pincode=pincodeTextField.getText();
        try{
            
      
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }  
            else{
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupOne(formno).setVisible(true);
            }
        }catch (Exception e){
            System.out.println(e);
        }       
        
            
            
        }
     public static void main (String args[])
    {
        new Signup();

    }
}
    

      
