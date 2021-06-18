import java.lang.*;
import java.io.*;
import java.sql.*;

class SearchAccount
{
	public static void main(String args[])
	{
		int ano;
		Connection con;	
		PreparedStatement pst;
		ResultSet rs;
	
		try
		{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			System.out.print("Account Number : ");
			ano=Integer.parseInt(br.readLine());

			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?user=root&password=shubham");
			pst=con.prepareStatement("select * from accounts where accno=?;");
			pst.setInt(1,ano);
           		 rs=pst.executeQuery();
           		 if(rs.next())
            		{
              			  System.out.print(rs.getString("accnm")+" | ");
               			 System.out.print(rs.getString("balance"));
         		   }
			else
			{
				System.out.println("Account Not Found ");
			}

			
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e.getMessage());	
		}
	}
}