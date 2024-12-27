package DatabaseHandling;

import EntityClasses.EntityUser;
import javafx.scene.control.Alert;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class DatabaseHandler {
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/e_ticket_for_bus";
    public static final String USER = "root";
    public static final String PASSWORD = "2104069azhr";
    private final Connection connection;

    public DatabaseHandler() {

        try {
// COMMENT ADDED
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean insert(EntityUser user) {
        String first_name = user.getFirst_name();
        String last_name = user.getLast_name();
        String email = user.getEmail();
        String phone = user.getPhone();
        String password = user.getPassword();
        String user_name = user.getUser_name();
        String address = user.getAddress();
        Date date_of_birth = user.getDate_of_birth();
        String gender = user.getGender();

        // Corrected SQL query
        String Query = "INSERT INTO user_table(user_name, first_name, last_name, email, phone, password, address, gender, date_of_birth) VALUES(?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(Query)) {
            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, first_name);
            preparedStatement.setString(3, last_name);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, password);
            preparedStatement.setString(7, address);
            preparedStatement.setString(8, gender);
            preparedStatement.setDate(9, new java.sql.Date(date_of_birth.getTime()));  // Proper conversion from java.util.Date to java.sql.Date

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    public List<EntityUser> userValidation(String user_name) {
        String query = "SELECT * FROM user_table WHERE user_name = ?";
        List<EntityUser> entityUserList = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, user_name);


            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String email = resultSet.getString("email");
                    String phone = resultSet.getString("phone");
                    String password = resultSet.getString("password");
                    String address = resultSet.getString("address");
                    Date dateOfBirth = resultSet.getDate("date_of_birth");
                    String gender = resultSet.getString("gender");

                    EntityUser user = new EntityUser(firstName, lastName, email, phone, password, user_name, address, dateOfBirth, gender);
                    entityUserList.add(user);


                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return entityUserList;
    }


    public String CreateUser_name(String last_name) {
        Random rn = new Random();
        String userName;
        do {
            int randomNumber = rn.nextInt(0, 100000);
            userName = last_name + "_" + String.valueOf(randomNumber);
        } while (!userValidation(userName).isEmpty());
        return userName;
    }

}
