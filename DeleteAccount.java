import java.io.*;
import java.lang.*;
import java.sql.*;
class DeleteAccount
{
	public static void main(String args[])
	{
		int ano;
		Connection con;
		PreparedStatement pst;

		try
		{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.print("Account Number : ");
			ano=Integer.parseInt(br.readLine());
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?user=root&password=shubham");
			pst=con.prepareStatement("delete from accounts where accno=?;");
			pst.setInt(1,ano);
			int status=pst.executeUpdate();
			if(status>0)
			{
				System.out.println("Account Deleted Successfully");
			}
			else
			{
				System.out.println("Deletion failed");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e.getMessage());
		}
	}
}