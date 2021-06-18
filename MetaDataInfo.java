import java.sql.*;
import java.io.*;
import javax.xml.transform.Result;

class MetaDataInfo
{
    public static void main(String args[])
    {
        Connection con;
        Statement st;
        ResultSet rs;
        ResultSetMetaData rsmd;
        
        String tbnm;

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try
        {
            System.out.print("Enter Table Name : ");
            tbnm=br.readLine();

            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb?user=root&password=shubham");
            st=con.createStatement();
            rs=st.executeQuery("select * from "+tbnm+";");
            rsmd=rs.getMetaData();

            int cnt=rsmd.getColumnCount();
            System.out.println("Number of colunms : "+cnt);

            for(int i=1;i<=cnt;i++)
            {
                System.out.print(rsmd.getColumnName(i)+"\t");
                System.out.println(rsmd.getColumnTypeName(i));
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
}