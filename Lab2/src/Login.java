import java.sql.*;

public class Login {

    public Login(Connection con, Statement statement, String email, String password) throws Exception {
        String query = "SELECT * FROM users WHERE Email = ? AND Password = ?";

        ResultSet details = statement.executeQuery("select * from course");

        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            System.out.println("Login Successful!\n");
            System.out.print(resultSet.getInt("SID") + " ");
            System.out.print(resultSet.getString("Name") + " ");
            System.out.print(resultSet.getString("Email") + " ");

            System.out.println("\nCourse details:");

            while (details.next()) {
                System.out.print(details.getString("Section") + " ");
                System.out.print(details.getString("Time") + " ");
                System.out.print(details.getString("Seats") + " ");
                System.out.println();
            }
            System.out.println();

        } else {
            System.out.println("Invalid login credentials...");
        }
    }
}
