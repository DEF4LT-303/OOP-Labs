import java.sql.*;

public class Section {

    public Section(Connection con, int sid, int section, Integer currentSection) {
        try {
            String sectionCheckQuery = "SELECT COUNT(*) FROM course WHERE ID = ?";
            PreparedStatement sectionCheckStatement = con.prepareStatement(sectionCheckQuery);
            sectionCheckStatement.setInt(1, section);
            ResultSet sectionCheckResult = sectionCheckStatement.executeQuery();

            if(sectionCheckResult.next() && sectionCheckResult.getInt(1) > 0) {
                if (currentSection != null) {
                    String currentSectionUpdateQuery = "UPDATE course SET Seats = Seats + 1 WHERE ID = ?";
                    PreparedStatement currentSectionUpdateStatement = con.prepareStatement(currentSectionUpdateQuery);
                    currentSectionUpdateStatement.setInt(1, currentSection);
                    currentSectionUpdateStatement.executeUpdate();
                }

                String query = "UPDATE users SET Section = ? WHERE SID = ?";
                PreparedStatement preparedStatement = con.prepareStatement(query);

                preparedStatement.setInt(1, section);
                preparedStatement.setInt(2, sid);

                preparedStatement.executeUpdate();

                String sectionUpdateQuery = "UPDATE course SET Seats = Seats - 1 WHERE ID = ?";

                PreparedStatement preparedSectionStatement = con.prepareStatement(sectionUpdateQuery);
                preparedSectionStatement.setInt(1, section);

                preparedSectionStatement.executeUpdate();

                System.out.println("Section Updated!");
            }
            else {
                System.out.println("Invalid section...");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public Section() {}

    public void sectionDetails(Connection con, int section) throws SQLException {
        String details = "SELECT Name, SID FROM users WHERE Section = ?";
        PreparedStatement sectionCheckStatement = con.prepareStatement(details);
        sectionCheckStatement.setInt(1, section);
        ResultSet sectionDetails = sectionCheckStatement.executeQuery();

        System.out.println("\nSection " + section + " Students:\n");
        while(sectionDetails.next()) {
            System.out.print(sectionDetails.getString("Name")+" ");
            System.out.print(sectionDetails.getInt("SID")+" ");
            System.out.println();
        }
    }
}
