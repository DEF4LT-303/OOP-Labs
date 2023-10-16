import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test", "root", "ryan69121");
            Statement statement = con.createStatement();

            while(true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Please enter name");
                        String name = sc.nextLine();
                        System.out.println("Please enter id");
                        String sid = sc.nextLine();
                        System.out.println("Please enter email");
                        String email = sc.nextLine();
                        System.out.println("Please enter password");
                        String password = sc.nextLine();

                        Registration register = new Registration(con, sid, name, email, password);
                        break;

                    case 2:
                        System.out.println("Please enter email");
                        String loginEmail = sc.nextLine();
                        System.out.println("Please enter password");
                        String loginPassword = sc.nextLine();
                        Login login = new Login(con, loginEmail, loginPassword);
                        break;

                    case 3:
                        con.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }

            }



//            printDatabase(con, statement);
//            con.close();
        }
        catch (Exception e) {
            System.err.println(e);
        }

    }

    public static void printDatabase(Connection con, Statement statement) throws Exception {
        ResultSet resultSet = statement.executeQuery("select * from users");
        while(resultSet.next()) {
            System.out.print(resultSet.getInt("SID")+" ");
            System.out.print(resultSet.getString("Name")+" ");
            System.out.print(resultSet.getString("Email")+ " ");
            System.out.println();
        }
    }
}