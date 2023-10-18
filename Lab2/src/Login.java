import java.sql.*;

public class Login {
    private int sid;
    private int section;
    private boolean valid;

    public Login(Connection con, String email, String password) throws Exception {
        String query = "SELECT * FROM users WHERE Email = ? AND Password = ?";

        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1,email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            this.valid = true;
            this.sid = resultSet.getInt("SID");
            this.section = resultSet.getInt("Section");

            System.out.println("Login successful!\n");
            System.out.print(resultSet.getInt("SID") + " ");
            System.out.print(resultSet.getString("Name") + " ");
            System.out.print(resultSet.getString("Email") + " ");
            System.out.println();
        } else {
            this.valid = false;
        }
    }

    public int getSid() {
        return sid;
    }

    public int getSection() {
        return section;
    }

    public boolean isValid() {
        return valid;
    }
}
