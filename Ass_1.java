import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.PreparedStatement;
public class Ass_1
{
	public static void main(String[] args)
	{		
		Scanner sc=new Scanner(System.in);
		int selection;
		do
		{
			System.out.println("Enter 1 to create new emloyee");
			System.out.println("Enter 2 to view all emloyee");
			System.out.println("Enter 3 to updtae an emloyee");
			System.out.println("Enter 4 to delete an emloyee");
			System.out.println("Enter 5 to exit");
			System.out.println("Enter Your Choice : ");
		
			selection = sc.nextInt();
			
			switch(selection)
			{
				case 1:			
					try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC", "root","7382353516@Dp"))
					{						
						String sql = "INSERT INTO employee234 (eid, ename, eemid, emob) VALUES (?, ?, ?, ?)";
						PreparedStatement statement = conn.prepareStatement(sql);
						statement.setInt(1, 4222);
						statement.setString(2, "USS");
						statement.setString(3, "uss@pp");
						statement.setLong(4, 833245);
						
						int rowsInserted = statement.executeUpdate();
						if (rowsInserted > 0) 
						{
							System.out.println("A new employee was created successfully!");
						}
					}
					catch (SQLException ex)
					{
						ex.printStackTrace();
					}		
					break;
				case 2:				
					try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC", "root","7382353516@Dp"))
					{
						String sql = "SELECT * FROM employee234";						
						Statement statement = conn.createStatement();
						ResultSet result = statement.executeQuery(sql);						
						int count = 0;						
						while (result.next())
						{
							int id = result.getInt("eid");
							String name = result.getString("ename");
							String email = result.getString("eemid");
							float mob = result.getFloat("emob");
							
							String output = "User #%d: %s - %s - %s - %s";
							System.out.println(String.format(output, ++count, id, name, email, mob));
						}
					}
					catch (SQLException ex) 
					{
						ex.printStackTrace();
					}	
					break;
				case 3:
					try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC", "root","7382353516@Dp"))
					{
						String sql = "UPDATE employee234 SET ename=?, eemid=?, emob=? WHERE eid=?";
						PreparedStatement statement = conn.prepareStatement(sql);
						statement.setString(1, "pop");
						statement.setString(2, "pp@dp");
						statement.setFloat(3, 124563);
						statement.setInt(4, 4222);
						int rowsUpdated = statement.executeUpdate();
						if (rowsUpdated > 0)
						{
							System.out.println("An existing employee was updated successfully!");
						}
					}
					catch (SQLException ex)
					{
						ex.printStackTrace();
					}		
					break;
				case 4:
					try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC", "root","7382353516@Dp"))
					{
						String sql = "DELETE FROM employee234 WHERE eid=?";
						PreparedStatement statement = conn.prepareStatement(sql);
						statement.setInt(1, 4222);						
						int rowsDeleted = statement.executeUpdate();
						if (rowsDeleted > 0)
						{
							System.out.println("An employee was deleted successfully!");
						}
					}
					catch (SQLException ex)
					{
						ex.printStackTrace();
					}		
					break;
				case 5:
					System.out.print("--THANK YOU--");
					break;
			}
		}
		while(selection!=5);
	}
	
}