import java.io.*;
import java.sql.*;
import java.lang.*;

class UpdateAccount
{
	public static void main(String args[])
	{
		int fano,tano;
		double amt;

		try
		{
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			Connection con;
			PreparedStatement pst;
			
			System.out.print("From Account Number : ");
			fano=Integer.parseInt(br.readLine());
			System.out.print("To Account Number : ");
			tano=Integer.parseInt(br.readLine());
			System.out.print("Amount : ");
			amt=Double.parseDouble(br.readLine());

			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?user=root&password=shubham");
			pst=con.prepareStatement("update accounts set balance=balance-? where accno=?;");
			pst.setDouble(1,amt);
			pst.setInt(2,fano);
			int status=pst.executeUpdate();
			if(status>0)
			{
				pst=con.prepareStatement("update accounts set balance=balance+? where accno=?;");
				pst.setDouble(1,amt);
				pst.setInt(2,tano);
				int status1=pst.executeUpdate();
				if(status1>0)
				{
					System.out.println("Transaction Successful");
				}
				else
				{
					System.out.println("Transaction Failed");
				}
			}
			else
			{
				System.out.println(amt+"Rs Debited Successfully but not Credited in destination account...Contact to bank....dont worry.");
				System.out.println("Your amount will cridited in your bank after 2 or 3 working days");
			}
		}
		catch(Exception e)
		{
			System.out.println("Error : "+e.getMessage());
			System.out.println("Transation failed...Please enter valid information");
		}

	}
}