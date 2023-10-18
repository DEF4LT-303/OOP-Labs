import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Connection con = DatabaseConnection.getConnection();

            while(true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Faculty Login");
                System.out.println("4. Exit");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        register(con);
                        break;

                    case 2:
                        studentLogin(con);
                        break;

                    case 3:
                        facultyLogin(con);
                        break;

                    case 4:
                        con.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    private static void register(Connection con) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("#############################");
        System.out.println("    Enter Student Details  ");
        System.out.println("#############################");

        System.out.println("Please enter name:");
        String name = sc.nextLine();
        System.out.println("Please enter id:");
        String sid = sc.nextLine();
        System.out.println("Please enter email:");
        String email = sc.nextLine();
        System.out.println("Please enter password:");
        String password = sc.nextLine();

        Registration register = new Registration(con, sid, name, email, password);
    }

    private static void facultyLogin(Connection con) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("#############################");
        System.out.println("        Faculty Login        ");
        System.out.println("#############################");
        System.out.println();
        printCourse(con);

        System.out.println("Please enter section number:");
        int secNum = sc.nextInt();

        Section details = new Section();
        details.sectionDetails(con, secNum);
    }

    private static void studentLogin(Connection con) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("#############################");
        System.out.println("        Student Login        ");
        System.out.println("#############################");

        System.out.println("Please enter email:");
        String loginEmail = sc.nextLine();
        System.out.println("Please enter password:");
        String loginPassword = sc.nextLine();

        Login login = new Login(con, loginEmail, loginPassword);
        if (login.isValid()) {
            sectionHandler(con, login.getSid(), login.getSection());
        } else {
            System.out.println("Invalid login credentials");
        }
    }

    private static void sectionHandler(Connection con, int sid, int currentSection) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("#############################");
        System.out.println("        Choose Section        ");
        System.out.println("#############################");

        printCourse(con);

        System.out.println("\nPlease enter section no.");
        int section = sc.nextInt();

        Section s = new Section(con, sid, section, currentSection);
    }

    public static void printCourse(Connection con) throws Exception {
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from course");
        while(resultSet.next()) {
            System.out.print("Section No: " + resultSet.getString("Section")+" ");
            System.out.print("| Time:" + resultSet.getString("Time")+" ");
            System.out.print("| Seats:" + resultSet.getInt("Seats")+ " ");
            System.out.println();
        }
    }
}