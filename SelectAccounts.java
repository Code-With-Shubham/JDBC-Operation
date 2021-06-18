import java.io.*;
import java.sql.*;

class SelectAccounts
{
	public static void main(String args[])
	{
		try
		{
			Connection con;
			PreparedStatement pst;
			ResultSet rs;

			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?user=root&password=shubham");
			pst=con.prepareStatement("select * from accounts;");
			rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.print(rs.getInt("accno")+" | ");
         			 // System.out.print(rs.getString("accnm")+" | ");
				//System.out.print(rs.getString("acctype")+" | ");
         			  System.out.println(rs.getDouble("balance")+" | ");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e.getMessage());
		}
	}
}