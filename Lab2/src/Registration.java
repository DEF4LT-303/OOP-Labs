import java.sql.*;

public class Registration {

    public Registration(Connection con, String sid, String name, String email, String password) {

        try {
            String query = "Insert into users (SID, Name, Email, Password) values(?, ?, ?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1,sid);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4, password);

            preparedStatement.executeUpdate();

            System.out.println("Registration successful!");
        }
        catch (Exception e) {
            System.err.println(e);
        }

    }

}
