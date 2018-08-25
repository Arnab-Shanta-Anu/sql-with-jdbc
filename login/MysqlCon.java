import java.sql.*;  
public class MysqlCon{  
	
	private String name,passd;
	
	public MysqlCon(String uname, String pass){
		System.out.println(uname+" "+pass);
		name = new String(uname);
		passd = new String(pass);
	}
	
	public void connect(){  
		
		try{  
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo",name,passd);
		//here sonoo is database name, root is username and password
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from emp");
		while(rs.next())
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		con.close();
		}catch(Exception e){ System.out.println(e);}  
	}  
}