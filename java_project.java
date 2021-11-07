import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class project{
	public static void main(String args[]) {
		 log l=new log();
	}
}

class log extends JFrame implements ActionListener{
	
	JButton b1,b2,b3;
	
	public log(){
		b1=new JButton("     Login     ");
		b2=new JButton("Register_Customer");
		b3=new JButton("Register_Dealer");
		
		add(b1);
		add(b2);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b1){
			new login();
			dispose();
		}else if(ae.getSource()==b2){
			new Register_Customer();
			dispose();
		}else{
			new Register_Dealer();	
			dispose();	
		}
	}
	
}

class login extends JFrame implements ActionListener{
		public static String gmail;
		JTextField t1,t2;
		JLabel l1,l2,l3;
		JRadioButton r1,r2;
		JButton b1,b2;
		
	public login(){
		
		t1=new JTextField(20);
		t2=new JTextField(20);
		l1=new JLabel("Enter Username");
		l2=new JLabel("Enter Password");
		l3=new JLabel("Choose type");
		r1=new JRadioButton("Customer");
		r2=new JRadioButton("Dealer");
		b1=new JButton("Login");
		b2=new JButton("Forget Password");
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(r1);
		add(r2);
		add(b1);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b1){
			if(r1.isSelected()){
			try{
				String query = "Select name,password,Email from Customer";
				Class.forName("com.mysql.cj.jdbc.Driver");
		 		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 		Statement st=con.createStatement();
		 		ResultSet rs=st.executeQuery(query);
		 		int temp=0;
		 		while(rs.next()){
		 			String username=rs.getString("name");
		 			String password=rs.getString("password");
		 			String name=t1.getText();
		 			String pass=t2.getText();
		 			if(username.equals(name) && password.equals(pass)){
		 				temp=1;
		 				System.out.println("logged in");
		 				gmail=rs.getString("Email");
		 				new Customers_Dashboard();
		 				dispose();
		 				break;
		 			}
		 		}
		 		if(temp==0){
				System.out.println("Invalid login credentials");
				new login();
				dispose();
				}
				}catch(Exception e){
					System.out.println(e);
				}
				
			}else if(r2.isSelected()){
				try{
				String query = "Select name,password,Email from Dealer";
				Class.forName("com.mysql.cj.jdbc.Driver");
		 		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 		Statement st=con.createStatement();
		 		ResultSet rs=st.executeQuery(query);
		 		int temp=0;
		 		while(rs.next()){
		 			temp=1;
		 			String username=rs.getString("name");
		 			String password=rs.getString("password");
		 			String name=t1.getText();
		 			String pass=t2.getText();
		 			if(username.equals(name) && password.equals(pass)){
		 				System.out.println("logged in");
		 				gmail=rs.getString("Email");
		 				new Dealers_Dashboard();
		 				dispose();
		 			}
		 		}
		 		if(temp==0){
				System.out.println("Invalid login credentials");
				new login();
				dispose();
				}
				}catch(Exception e){
					System.out.println(e);
				}
			}
		}else{
			new forget_pass();
			dispose();		
		}
	}
	
}

class Register_Customer extends JFrame implements ActionListener{

	JTextField t1,t2,t3,t4,t5;
	JLabel l1,l2,l3,l4,l5;
	JButton b1;
	
	public Register_Customer(){
		l1=new JLabel("Enter Username");
		l2=new JLabel("Enter Email");
		l3=new JLabel("Enter Address");
		l4=new JLabel("Enter Phone");
		l5=new JLabel("Create Password");
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		b1=new JButton("Register");
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(l5);
		add(t5);
		add(b1);
		
		b1.addActionListener(this);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}	
	public void actionPerformed(ActionEvent ae){
		Customer c=new Customer(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText());
		System.out.println("Registered Succesfully");
		new login();
		dispose();
	}
		

}

class Register_Dealer extends JFrame implements ActionListener{
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JButton b1;
	
	public Register_Dealer(){
		l1=new JLabel("Enter ShopName");
		l2=new JLabel("Enter Description");
		l3=new JLabel("Enter Username");
		l4=new JLabel("Enter Email");
		l5=new JLabel("Enter Address");
		l6=new JLabel("Enter Phone");
		l7=new JLabel("Create Password");
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		t5=new JTextField(20);
		t6=new JTextField(20);
		t7=new JTextField(20);
		b1=new JButton("Register");
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(l5);
		add(t5);
		add(l6);
		add(t6);
		add(l7);
		add(t7);
		add(b1);
		
		b1.addActionListener(this);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}	
	
	public void actionPerformed(ActionEvent ae){
		Dealer d=new Dealer(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText(),t6.getText(),t7.getText());
		System.out.println("Registered Succesfully");
		new login();
		dispose();
	}
	
}

class Customer{
	int Customer_id;
	String name,Email,Address,contact,password;
	static int c_id=0;
	
	public Customer(String name,String Email,String Address,String contact,String password){
		try{
			String query="INSERT into Customer VALUES(?,?,?,?,?,?)";
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 	PreparedStatement st=con.prepareStatement(query);
		 	c_id++;
		 	st.setInt(1,c_id);
		 	st.setString(2,name);
		 	st.setString(3,Email);
		 	st.setString(4,Address);
		 	st.setString(5,contact);
		 	st.setString(6,password);
		 	int count=st.executeUpdate();
		 }catch(Exception e){
		 	System.out.println(e);
		 }
	}
	/*
	public String get_name(){
		return name;
	}
	
	public String get_Email(){
		return Email;
	}
	
	public String get_Address(){
		return Address;
	}
	
	public String get_contact(){
		return contact;
	}
	
	public String get_password(){
		return password;
	}
	
	public void set_name(string n){
		name=n;
	}
	
	public void set_Email(String n){
		Email=n;
	}
	
	public void set_Address(String n){
		Address=n;
	}
	
	public void gset_contact(String n){
		contact=n;
	}
	
	public void get_password(String n){
		password=n;
	}
	*/
	
	

}

class Dealer{
	static int Dealer_id=0;
	String name,Shopname,Description,Email,Address,contact,password;
	
	public Dealer(String Shopname,String Description,String name,String Email,String Address,String contact,String password){
		try{
			String query="INSERT into Dealer VALUES(?,?,?,?,?,?,?,?)";
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 	PreparedStatement st=con.prepareStatement(query);
		 	Dealer_id++;
		 	st.setInt(1,Dealer_id);
		 	st.setString(2,Shopname);
		 	st.setString(3,Description);
		 	st.setString(4,name);
		 	st.setString(5,Email);
		 	st.setString(6,Address);
		 	st.setString(7,contact);
		 	st.setString(8,password);
		 	int count=st.executeUpdate();
		 }catch(Exception e){
		 	System.out.println(e);
		 }
	}
	/*
	public String get_name(){
		return name;
	}
	
	public String get_Email(){
		return Email;
	}
	
	public String get_Address(){
		return Address;
	}
	
	public String get_contact(){
		return contact;
	}
	
	public String get_password(){
		return password;
	}
	
	public void set_name(string n){
		name=n;
	}
	
	public void set_Email(String n){
		Email=n;
	}
	
	public void set_Address(String n){
		Address=n;
	}
	
	public void gset_contact(String n){
		contact=n;
	}
	
	public void get_password(String n){
		password=n;
	}
	
	*/

}

class forget_pass extends JFrame implements ActionListener{

	JButton b;
	JLabel l1,l2,l3;
	JRadioButton r1,r2;
	JTextField t1,t2,t3;
	
	public forget_pass(){
		l1=new JLabel("Enter Email");
		l2=new JLabel("Enter Phone");
		l3=new JLabel("Enter new password");
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		r1=new JRadioButton("Customer");
		r2=new JRadioButton("Dealer");
		b=new JButton("	OK	");
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(r1);
		add(r2);
		add(b);
		
		b.addActionListener(this);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae){
			if(r1.isSelected()){
				try{
				String query = "Select Email,contact from Customer";
				Class.forName("com.mysql.cj.jdbc.Driver");
		 		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 		Statement st=con.createStatement();
		 		ResultSet rs=st.executeQuery(query);
		 		int temp=0;
		 		while(rs.next()){
		 			String Email=rs.getString("Email");
		 			String contact=rs.getString("contact");
		 			String em=t1.getText();
		 			String co=t2.getText();
		 			if(Email.equals(em) && contact.equals(co)){
		 				temp=1;
		 				query="UPDATE Customer SET password='"  + t3.getText() + "' WHERE Email= '" + Email + "'";
		 				Class.forName("com.mysql.cj.jdbc.Driver");
		 				Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 				PreparedStatement st1=con1.prepareStatement(query);
		 				int count=st1.executeUpdate();
		 				System.out.println(count + " rows affected\nsuccessfully changed password");
		 				
		 				new login();
		 				dispose();
		 			}
		 		}
		 		if(temp==0){
		 		System.out.println("Invalid credentials....TRY AGAIN");
		 		new forget_pass();
		 		dispose();
		 		}
		 		}catch(Exception e){
		 			System.out.println(e);
		 		}
		 		
		 	}else{
		 		try{
		 		String query = "Select Email,contact from Dealer";
				Class.forName("com.mysql.cj.jdbc.Driver");
		 		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 		Statement st=con.createStatement();
		 		ResultSet rs=st.executeQuery(query);
		 		int temp=0;
		 		while(rs.next()){
		 			String Email=rs.getString("Email");
		 			String contact=rs.getString("contact");
		 			String em=t1.getText();
		 			String co=t2.getText();
		 			if(Email.equals(em) && contact.equals(co)){
		 				temp=1;
		 				query="UPDATE Dealer SET password='"  + t3.getText() + "' WHERE Email='" + Email + "'";
		 				Class.forName("com.mysql.cj.jdbc.Driver");
		 				Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 				PreparedStatement st1=con1.prepareStatement(query);
		 				int count=st1.executeUpdate();
		 				System.out.println(count + " rows affected\nsuccessfully changed password");
		 				
		 				new login();
		 				dispose();
		 			}
		 		}
		 		if(temp==0){
		 		System.out.println("Invalid credentials....TRY AGAIN");
		 		new forget_pass();
		 		dispose();
		 		}
		 		}catch(Exception e){
		 			System.out.println(e);
		 		}
		 	}
	}

}



class Customers_Dashboard extends JFrame implements ActionListener{
	JButton b1,b2,b3,b4,b5;
	public Customers_Dashboard(){
		b1=new JButton("View Item");
		b2=new JButton("View Cart");
		b3=new JButton("order_history");
		b4=new JButton("logout");
		b5=new JButton("Delete Account");
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b1){
			new view_item();
			dispose();
		}else if(ae.getSource()==b2){
			new view_cart();	
			dispose();	
		}else if(ae.getSource()==b3){
			new order_history();
		}else if(ae.getSource()==b4){
			new log();
			dispose();
		}else{
			new delete_account_Customer();
			dispose();
		}
	}
}

class Dealers_Dashboard extends JFrame implements ActionListener{
	JButton b1,b2,b3,b4,b5,b6;
	public Dealers_Dashboard(){
		b1=new JButton("add Item");
		b2=new JButton("View added Item");
		b3=new JButton("Remove Item");
		b4=new JButton("View order list");
		b5=new JButton("logout");
		b6=new JButton("Delete Account");
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==b1){
			new add_item();
			dispose();
		}else if(ae.getSource()==b2){
			new view_added_item();		
		}else if(ae.getSource()==b3){
			new Delete_item();
			dispose();
		}else if(ae.getSource()==b4){
			new view_order_list();	
		}else if(ae.getSource()==b5){
			new log();
			dispose();
		}else{
			new delete_account_Dealer();	
			dispose();
		}
	}
}

class view_item extends JFrame implements ActionListener{

	JLabel l1,l2;
	JTextField t1,t2;
	JButton b;
	
	public view_item(){
		try{
			String query="Select * from Items";
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 	Statement st=con.createStatement();
		 	ResultSet rs=st.executeQuery(query);
		 	System.out.println("product name    price    quantity    discount");
		 	while(rs.next()){
		 		System.out.println(rs.getString("name")+"        " + rs.getString("price") + "        " +  rs.getString("quantity") + "        " +  rs.getString("discount"));
		 	}
		 }catch(Exception e){
		 	System.out.println(e);
		 }
		 
		 l1=new JLabel("Enter name");
		 l2=new JLabel("Enter quantity");
		 t1=new JTextField(20);
		 t2=new JTextField(20);
		 b=new JButton("ok");
		 
		 add(l1);
		 add(t1);
		 add(l2);
		 add(t2);
		 add(b);
		 
		 b.addActionListener(this);
		 
		 setLayout(new FlowLayout());
		 setVisible(true);
		 setSize(400,400);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae){
		int q=Integer.parseInt(t2.getText());
		try{
			String query="Select * from Items";
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 	Statement st=con.createStatement();
		 	ResultSet rs=st.executeQuery(query);
		 	while(rs.next()){
		 		if(t1.getText().equals(rs.getString("name"))){
		 			if(q<=Integer.parseInt(rs.getString("quantity"))){
		 				try{
		 				query="INSERT into Cart VALUES(?,?,?,?,?)";
		 				Class.forName("com.mysql.cj.jdbc.Driver");
		 				Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 				PreparedStatement st1=con1.prepareStatement(query);
		 			 	st1.setString(1,rs.getString("name"));
		 			 	st1.setString(3,t2.getText());
		 			 	st1.setString(2,rs.getString("price"));
		 				st1.setString(4, rs.getString("discount"));
		 				st1.setString(5,rs.getString("Email"));
		 				int count=st1.executeUpdate();
		 				
		 				q=Integer.parseInt(rs.getString("quantity"))-q;
		 				query="UPDATE Items SET quantity= '" + q + "' WHERE Email= '" + rs.getString("Email") + "' AND name= '" + rs.getString("name")+ "'";
		 				Class.forName("com.mysql.cj.jdbc.Driver");
		 				Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 				PreparedStatement st2=con2.prepareStatement(query);
		 				count=st2.executeUpdate();
		 				}catch(Exception e){
		 					System.out.println(e);
		 				}
		 				
		 				break;
		 			}
		 			else{
		 				System.out.println("Quantity NOt Available");
		 				break;
		 			}
		 		}
		 	}
		 	new Customers_Dashboard();
		 	dispose();
		 }catch(Exception e){
		 	System.out.println(e);
		 }
	}

}

class view_cart extends JFrame implements ActionListener{
	public static Double gtotal=0.00;
	JLabel l1;
	JTextField t1;
	JRadioButton r1,r2;
	JButton b;
	
	public view_cart(){
		try{
		String query="SELECT * FROM Cart";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		System.out.println("product name\tquantity\tunit price\tdiscount\ttotal");
		while(rs.next()){
			double p=Double.parseDouble(rs.getString("price")) ;
			double q=Double.parseDouble(rs.getString("quantity"));
			double d=Double.parseDouble(rs.getString("discount"));
			double total=(p*q)-(p*q*d)/100; 
			System.out.println(rs.getString("name")+"\t\t" +rs.getString("quantity") + "\t\t\t" + rs.getString("price") + "\t\t" +  rs.getString("discount") + "\t\t" +  total);
			gtotal=total+gtotal;
		}
		System.out.println("\t\t\t\t\t\t\t\t\t"+gtotal);
		}catch(Exception e){
			System.out.println(e);
		}
		
		l1=new JLabel("Enter shipping Details");
		t1=new JTextField(20);
		r1=new JRadioButton("Cash on Delivery(COD)");
		r2=new JRadioButton("online mode");
		b=new JButton("Confirm Order");
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		add(l1);
		add(t1);
		add(r1);
		add(r2);
		add(b);
		
		b.addActionListener(this);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent ae){
		
			if(r1.isSelected()){
				new place_order(t1.getText());
				dispose();
		 		
		 	}else{
		 		new make_payment(t1.getText());
		 		dispose();
		 	}
	}
	
}

class order_history extends JFrame{

	public order_history(){
	try{
		String query="SELECT * FROM Invoice Where Customer_email='"+ login.gmail + "'";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		System.out.println("purchased from\tDelivered to\tname\tprice\tquantity\tdiscount");
		while(rs.next()){
			System.out.println(rs.getString("Dealer_email")+"\t\t" +rs.getString("Customers_Address") + "\t" +rs.getString("name")+"\t" + rs.getString("price") + "\t" +  rs.getString("quantity") + "\t\t" +  rs.getString("discount"));
		}
		}catch(Exception e){
			System.out.println(e);
		}
	
	}

}

class delete_account_Customer{

	public delete_account_Customer(){
		try{
			String query="DELETE FROM Customer WHERE Email= '" + login.gmail + "'";
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 	PreparedStatement st=con.prepareStatement(query);
		 	int count=st.executeUpdate();
		 	System.out.println("Succefully deleted account");
		 	System.exit(0);
		 }catch(Exception e){
		 	System.out.println(e);
		 }
		 
		
	}
}

class add_item extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4;
	JTextField t1,t2,t3,t4;
	JButton b;
	
	public add_item(){
		l1=new JLabel("Enter name");
		l2=new JLabel("Enter quantity");
		l3=new JLabel("Enter price");
		l4=new JLabel("Enter discount");
		t1=new JTextField(20);
		t2=new JTextField(20);
		t3=new JTextField(20);
		t4=new JTextField(20);
		b=new JButton("ok");
		
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(l4);
		add(t4);
		add(b);
	
		b.addActionListener(this);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}
	
	public void actionPerformed(ActionEvent ae){
		
		String name=t1.getText();
		String Quantity=t2.getText();
		String price=t3.getText();
		String discount=t4.getText();
		
		try{
			String query="INSERT into Items VALUES(?,?,?,?,?)";
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 	PreparedStatement st=con.prepareStatement(query);
		 	st.setString(1,login.gmail);
		 	st.setString(2,name);
		 	st.setString(3,Quantity);
		 	st.setString(4,price);
		 	st.setString(5,discount);
		 	int count=st.executeUpdate();
		 	new Dealers_Dashboard();
		 	dispose();
		 }catch(Exception e){
		 	System.out.println(e);
		 }
	}
}

class view_added_item{

	public view_added_item(){
		try{
			String query="Select * from Items Where Email= '" + login.gmail + "'";
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 	Statement st=con.createStatement();
		 	ResultSet rs=st.executeQuery(query);
		 	System.out.println("product name\tprice\tquantity\tdiscount");
		 	while(rs.next()){
		 		System.out.println(rs.getString("name")+"\t\t" + rs.getString("price") + "\t" +  rs.getString("quantity") + "\t\t" +  rs.getString("discount"));
		 	}
		 }catch(Exception e){
		 	System.out.println(e);
		 }
	
	}
}

class Delete_item extends JFrame implements ActionListener{
	
	JLabel l1,l2;
	JTextField t1,t2;
	JButton b;
	
	public Delete_item(){
		
		 l1=new JLabel("Enter name");
		 t1=new JTextField(20);
		 l2=new JLabel("Enter Quantity to be removed");
		 t2=new JTextField(20);
		 b=new JButton("ok");
		 
		 add(l1);
		 add(t1);
		 add(l2);
		 add(t2);
		 add(b);
		 
		 b.addActionListener(this);
		 
		 setLayout(new FlowLayout());
		 setVisible(true);
		 setSize(400,400);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae){
		try{
			String name=t1.getText();
			String quan=t2.getText();
			
			String query="SELECT * FROM Items WHERE name='"+ name +  "'"; 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			int q=(Integer.parseInt(rs.getString("quantity")))-Integer.parseInt(quan);
			if(q==0){
				query="DELETE FROM Items WHERE Email= '" + login.gmail  + "' AND name= '" + name + "'";
		 		Class.forName("com.mysql.cj.jdbc.Driver");
		 		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 		PreparedStatement st1=con1.prepareStatement(query);
		 		int count=st1.executeUpdate();
		 		System.out.println("Succefully deleted item");
		 		new Dealers_Dashboard();
		 		dispose();
		 	}
		 	else if(q>0){
		 		query="UPDATE Items SET quantity='" + q + "' WHERE Email= '"+ login.gmail + "' AND name= '" + name + "'";
		 		Class.forName("com.mysql.cj.jdbc.Driver");
		 		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 		PreparedStatement st1=con1.prepareStatement(query);
		 		int count=st1.executeUpdate();
		 		System.out.println("Succefully removed " +  Integer.parseInt(quan) +" item");
		 		new Dealers_Dashboard();
		 		dispose();
		 	}
		 	else{
		 		System.out.println("Quantity unavailable");
		 		new Dealers_Dashboard();
		 		dispose();
		 	}
		 }catch(Exception e){
		 	System.out.println(e);
		 }
	}

}

//CREATE TABLE Invoice (Customer_email varchar(40),Dealer_email varchar(40),name varchar(20),Customers_Address varchar(40),price varchar(20),quantity varchar(20),discount varchar(20));

class view_order_list{

	public view_order_list(){
	try{
		String query="SELECT * FROM Invoice Where Dealer_email= '"+ login.gmail + "'";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		System.out.println("purchased by\tShipping address\tprice\tquantity\tdiscount");
		while(rs.next()){
			System.out.println(rs.getString("Customer_email")+"\t\t" +rs.getString("Customers_Address") + "\t" + rs.getString("price") + "\t" +  rs.getString("quantity") + "\t\t" +  rs.getString("discount"));
		}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}

class delete_account_Dealer{

	public delete_account_Dealer(){
		try{
			String query="DELETE FROM Dealer WHERE Email= '" + login.gmail + "'";
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 	PreparedStatement st=con.prepareStatement(query);
		 	int count=st.executeUpdate();
		 	System.out.println("Succefully deleted account");
		 	System.exit(0);
		 }catch(Exception e){
		 	System.out.println(e);
		 }
		 
		
	}
}

class place_order extends JFrame implements ActionListener{
	JLabel l;
	JButton b1,b2;
	
	public place_order(String add){
		try{
			String query="Select * from Cart";
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 	Statement st=con.createStatement();
		 	ResultSet rs=st.executeQuery(query);
		 	while(rs.next()){
		 				query="INSERT into Invoice VALUES(?,?,?,?,?,?,?)";
		 				Class.forName("com.mysql.cj.jdbc.Driver");
		 				Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 				PreparedStatement st2=con2.prepareStatement(query);
		 			 	st2.setString(1,login.gmail);
		 				st2.setString(2,rs.getString("Dealer_email"));
		 				st2.setString(3,rs.getString("name"));
		 				st2.setString(4, add);
		 				st2.setString(5,rs.getString("quantity"));
		 				st2.setString(6,rs.getString("price"));
		 				st2.setString(7, rs.getString("discount"));
		 				int count=st2.executeUpdate();
		 	}
			query="DELETE FROM Cart";
		 	Class.forName("com.mysql.cj.jdbc.Driver");
		 	Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/sys" ,"root" , "Srey@123");
		 	PreparedStatement st1=con1.prepareStatement(query);
		 	int count=st1.executeUpdate();
		 	
		 }catch(Exception e){
		 	System.out.println(e);
		 }
	
		l=new JLabel("Order Placed");
		b1=new JButton("Continue Shopping");
		b2=new JButton("Logout");
		
		add(l);
		add(b1);
		add(b2);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae){
			if(ae.getSource()==b1){
				new Customers_Dashboard();
				dispose();
		 		
		 	}else{
		 		new log();
		 		dispose();
		 	}
	}
}

class make_payment extends JFrame implements ActionListener{
	JButton b;
	String addr;
	
	public make_payment(String addr){
		this.addr=addr;
		b=new JButton("Pay");
		
		add(b);
		
		b.addActionListener(this);
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent ae){
			new place_order(addr);
			dispose();
	}
	
	
}