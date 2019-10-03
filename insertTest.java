package sql;
 
import java.sql.*;
 
public class insertTest {
 
    public static void main(String[] args) throws SQLException {
         
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db?useSSL=false", "myuser", "xxxx");
                 Statement stmt = conn.createStatement();   
            ){
             
            String sqlDelete = "delete from books where ID > 8000";
            System.out.println("The SQL query is: "+ sqlDelete);
            int countDeleted = stmt.executeUpdate(sqlDelete);
            System.out.println(countDeleted + " records deleted.\n");
             
             
            String sqlInsert = "insert into books values"
                    + " (8001, 'Java ABC', 'Kevin Jones', 3),"
                    + " (8002, 'Java XYZ', 'Kevin Jones', 5)";
            int countInserted = stmt.executeUpdate(sqlInsert);
            System.out.println(countInserted + " records inserted.\n");
             
             
            String strSelect = "select* from books";
            System.out.println("The SQL query is: "+ strSelect);
            ResultSet rset = stmt.executeQuery(strSelect);
             
            while(rset.next()){
                System.out.println(rset.getInt("ID")+", "
                        +rset.getString("AUTHOR")+", "
                        +rset.getString("TITLE")+", "
                        +rset.getInt("QTY"));
             
                     
             
             
            }
 
    }
 
}
}
