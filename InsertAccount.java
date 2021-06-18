import java.io.*;
import java.sql.*;

class InsertAccount
{
	public static void main(String args[])
	{
		Connection con;
		PreparedStatement pst;
		
		int ano;
		String anm,typ;
		double bal;

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

			
		try
		{
			System.out.print("Account Number : ");
			ano=Integer.parseInt(br.readLine());
			System.out.print("Account Name : ");
			anm=br.readLine();
			System.out.print("Account Type : ");
			typ=br.readLine();
			System.out.print("Balance : ");
			bal=Double.parseDouble(br.readLine());	
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?user=root&password=shubham");

			pst=con.prepareStatement("insert into accounts values(?,?,?,?);");
			pst.setInt(1,ano);
			pst.setString(2,anm);
			pst.setString(3,typ);
			pst.setDouble(4,bal);
			int cnt=pst.executeUpdate();
			if(cnt>0)
			{
				System.out.println("Account Created Successfully");
			}
                        else
			{
				System.out.println("Account Insertion Failed");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e.getMessage());
		}
	}
}