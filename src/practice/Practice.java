/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Practice extends JFrame implements ActionListener
{
Container cn;
JLabel lbl1,lbl2;
JTextField txt1;
JPasswordField txt2;
JButton b1,b2;
Connection con;
Statement stmt;
@SuppressWarnings("empty-statement")
Practice()
{
cn=getContentPane();
cn.setLayout(null);
lbl1=new JLabel("USER NAME");
lbl1.setBounds(10,0,100,50);
cn.add(lbl1);
lbl2=new JLabel("Password");
lbl2.setBounds(10,70,800,50);
cn.add(lbl2);
txt1=new JTextField();
txt1.setBounds(130,10,120,30);
cn.add(txt1);
txt2=new JPasswordField();
txt2.setBounds(130,80,130,30);
cn.add(txt2);

b1=new JButton("Logn");
b1.setBounds(130,120,80,20);;
b1.setBackground(Color.RED);
cn.add(b1);
b2=new JButton("Cancel");
b2.setBounds(220,120,90,20);
b2.setBackground(Color.RED);
cn.add(b2);

setBounds(300,200,350,200);
cn.setBackground(Color.pink);
setVisible(true);
b1.addActionListener(this);
b2.addActionListener(this);
}
public void actionPerformed(ActionEvent ae)
{
try
{
Class.forName("com.mysql.jdbc.Driver");

con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo"," root", "root"); 
}
catch(Exception ex)
 {}
if(ae.getSource()==b1)
{
try
{
Class.forName("com.mysql.jdbc.Driver");

con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo","root","root"); 

stmt=con.createStatement(); 
//ResultSet rs=stmt.executeQuery("select * from Stu where nm='"+txt1.getText()+"' and pas="+txt2.getText()+" ");

ResultSet rs=stmt.executeQuery("select * from Stu");

if(rs.next())
{
JOptionPane.showMessageDialog(this, "Login Success");
con.close();
stmt.close();
this.dispose();
}
else
{
JOptionPane.showMessageDialog(this, "invalid username or password");
txt1.setText(null);
txt2.setText(null);
}
}
catch(Exception e1)
{
JOptionPane.showMessageDialog(this, "Error: "+e1.getMessage());
}
}
else if(ae.getSource()==b2)
{
System.exit(0);
}
}
public static void main(String r[])
{
Practice tt=new Practice();
}
}


