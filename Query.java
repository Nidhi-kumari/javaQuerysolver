import java.sql.*;
import java.util.*;
class Query{
	public static void main(String args[]) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		Scanner scan = new Scanner(System.in);
		System.out.println("enter Query");
		String q = scan.nextLine();
		Statement st = cn.createStatement();
		ResultSet rs = st.executeQuery(q);
		ResultSetMetaData rsm = rs.getMetaData();
		int count = rsm.getColumnCount();
		
		while(rs.next()){
			
			for(int index = 1; index <= count; index++){
				
				String type = rsm.getColumnTypeName(index);
				
				if(type.equals("NUMBER"))
					System.out.println(rs.getInt(index));
				if(type.equals("VARCHAR2"))
					System.out.println(rs.getString(index));
				
			}
			System.out.println();
		}
		st.close();
		cn.close();
		}
}