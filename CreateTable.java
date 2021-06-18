import java.lang.*;
import java.io.*;
import java.sql.*;
class CreateTable
{
    public static void main(String args[])
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        String nm;

        Connection con;
        Statement st;

        try
        {
            System.out.print("Enter Student Name : ");
            nm=br.readLine();

            Class.forName("com.mysql.cj.jdbc.Driver");

            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?user=root&password=shubham");

            st=con.createStatement();
            st.execute("create table "+nm+"(srno int primary key auto_increment,testdt datetime,subject varchar(20),marks int);");

            System.out.println("Table created successfully");
            con.close();
        }
        catch(Exception ex)
        {
            System.out.print("Error : "+ex.getMessage());
        }
    }
}