
package bank.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupOne extends JFrame implements ActionListener{
   
    JComboBox occupation,education,income,category,Religion;
    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    String formno;

    SignupOne(String formno)
    {
        this.formno=formno;
        setLayout(null);
        setTitle("New Account Application Form :- PAGE-2");
        
        JLabel additionalDetails=new JLabel("page2:Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,16));
        additionalDetails.setBounds(290,80,300,30);
        add(additionalDetails);
        
        
        JLabel religion =new JLabel("Religion :");
        religion.setFont(new Font("Raleway",Font.BOLD,16));
        religion.setBounds(100,150,100,30);
        add(religion);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        Religion = new JComboBox(valReligion);
        Religion.setBounds(250,150,400,27);
        Religion.setBackground(Color.WHITE);
        add(Religion);
        
        

        JLabel Category=new JLabel("Category :");
        Category.setFont(new Font("Ralway",Font.BOLD,16));
        Category.setBounds(100,200,170,30);
        add(Category);
        
        String valCategory[]={"General","OBC","SC","ST","Other"};
        category = new JComboBox(valCategory);
        category.setBounds(250,200,400,27);
        category.setBackground(Color.WHITE);
        add(category);
        
        

        JLabel Income=new JLabel("Income :");
        Income.setFont(new Font("Ralway",Font.BOLD,16));
        Income.setBounds(100,250,170,30);
        add(Income);
        
        String valIncome[]={"null","< 1,50,000","<2,50,000","5,00,000","Upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(250,250,400,27);
        income.setBackground(Color.WHITE);
        add(income);
        
        



        JLabel Educational=new JLabel("Educational ");
        Educational.setFont(new Font("Ralway",Font.BOLD,16));
        Educational.setBounds(100,300,170,30);
        add(Educational);

        JLabel Qualification=new JLabel("Qualification :");
        Qualification.setFont(new Font("Ralway",Font.BOLD,16));
        Qualification.setBounds(100,318,170,30);
        add(Qualification);
        
        String valEducationValues[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        education = new JComboBox(valEducationValues);
        education.setBounds(250,305,400,40);
        education.setBackground(Color.WHITE);
        add(education);
        
        


        JLabel martial=new JLabel("Occupation :");
        martial.setFont(new Font("Ralway",Font.BOLD,16));
        martial.setBounds(100,360,170,30);
        add(martial);
        
        String valOccupationValues[]={"Saleried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation = new JComboBox(valOccupationValues);
        occupation.setBounds(250,360,400,27);
        occupation.setBackground(Color.WHITE);
        add(occupation);


     


        JLabel Panno=new JLabel("PAN no.:");
        Panno.setFont(new Font("Ralway",Font.BOLD,16));
        Panno.setBounds(100,410,170,30);
        add(Panno);

        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(250,410,400,30);
        add(panTextField);




        JLabel Aadharno=new JLabel("Aadhar no:");
        Aadharno.setFont(new Font("Ralway",Font.BOLD,16));
        Aadharno.setBounds(100,460,170,30);
        add(Aadharno);

        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(250,460,400,30);
        add(aadharTextField);




        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Ralway",Font.BOLD,16));
        state.setBounds(100,510,170,30);
        add(state);

        syes =new JRadioButton("Yes");
        syes.setBounds(250,510,100,30);
        syes.setBackground(Color.BLACK);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno =new JRadioButton("No");
        sno.setBounds(350,510,100,30);
        sno.setBackground(Color.BLACK);
        sno.setBackground(Color.WHITE);
        add(sno);

        
        



        JLabel ExistingAcc=new JLabel("Existing Account:");
        ExistingAcc.setFont(new Font("Ralway",Font.BOLD,16));
        ExistingAcc.setBounds(100,560,170,30);
        add(ExistingAcc);

        eyes =new JRadioButton("Yes");
        eyes.setBounds(250,560,100,30);
        eyes.setBackground(Color.BLACK);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno =new JRadioButton("No");
        eno.setBounds(350,560,100,30);
        eno.setBackground(Color.BLACK);
        eno.setBackground(Color.WHITE);
        add(eno);



        next=new JButton("Next");
        next.setBackground(Color.BLACK);
         next.setForeground(Color.WHITE);
         next.setFont(new Font("Ralway",Font.BOLD,14));
         next.setBounds(550,620,100,30);
         next.addActionListener(this);
         add(next);

        
        
      
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String sreligion=(String) Religion.getSelectedItem();
        String scategory=(String) category.getSelectedItem();
        String sincome=(String) income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        String sseniorcitizen = null;
        if(syes.isSelected()){
            sseniorcitizen="Yes";
        }
        else if(sno.isSelected()){
            sseniorcitizen="No";
        }
        String sexistingaccount=null;
        if(eyes.isSelected()){
            sexistingaccount="Yes";
        }
        else if(eno.isSelected()){
            sexistingaccount="No";
        }
    
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();
        
        try{
                Conn c=new Conn();
                String query="insert into SignupOne values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+sseniorcitizen+"','"+sexistingaccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            //SignupTwo query
        }catch (Exception e){
            System.out.println(e);
        }       
        
        }
     public static void main (String args[])
    {
        new SignupOne("");

    }
}
    

      

