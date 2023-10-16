import java.sql.*;

public class Login {

    public Login(Connection con, String email, String password) throws Exception {
        String query = "SELECT * FROM users WHERE Email = ? AND Password = ?";

        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            do {
                System.out.print(resultSet.getInt("SID") + " ");
                System.out.print(resultSet.getString("Name") + " ");
                System.out.print(resultSet.getString("Email") + " ");
                System.out.println();
            } while (resultSet.next());
        } else {
            System.out.println("Invalid login credentials");
        }
    }
}
