package se.lexicon.data.jdbc;

import se.lexicon.data.interfaces.ContactInfoDAO;
import se.lexicon.model.ContactInformation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactInfoDAOJdbcImpl implements ContactInfoDAO {

    private static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DatabaseCredentials.getInstance().getURL(),
        DatabaseCredentials.getInstance().getUSER(),
                DatabaseCredentials.getInstance().getPASSWORD());
    }

    public static ContactInformation mapToContactInformation(ResultSet resultSet) throws SQLException{
        return new ContactInformation(
                resultSet.getString("id"),
                resultSet.getString("email"),
                resultSet.getString("phone"),
                resultSet.getString("address"));
    }

    @Override
    public Optional<ContactInformation> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public ContactInformation create(ContactInformation contactInformation) {

        int rowsAffected = Integer.MIN_VALUE;
        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO contact_info (id, email, phone, address) VALUES (?,?,?,?)");

            preparedStatement.setString(1, contactInformation.getId());
            preparedStatement.setString(2, contactInformation.getEmail());
            preparedStatement.setString(3, contactInformation.getPhone());
            preparedStatement.setString(4, contactInformation.getAddress());

            rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (rowsAffected == 1) {
            return contactInformation;
        }else {
            return null;
        }
    }

    @Override
    public List<ContactInformation> findAll() {

        List<ContactInformation> allInfo = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM contact_info");
             ResultSet resultSet = preparedStatement.executeQuery()
        ) {
            while (resultSet.next()) {
                allInfo.add(mapToContactInformation(resultSet));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    return allInfo;
    }

    @Override
    public Optional<ContactInformation> findById(String id) {
        Optional<ContactInformation> found = Optional.empty();

        try{
            Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contact_info WHERE id = ?");
        preparedStatement.setString(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            found = Optional.of(mapToContactInformation(resultSet));
        }
    }catch (SQLException e){
        e.printStackTrace();
    }
    return found;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }
}
