package se.lexicon;

import se.lexicon.data.interfaces.ContactInfoDAO;
import se.lexicon.data.jdbc.ContactInfoDAOJdbcImpl;
import se.lexicon.data.jdbc.DatabaseCredentials;

public class Main {
    public static void main(String[] args) {
        DatabaseCredentials.initialize("database/mysql.properties");

        ContactInfoDAO infoDAO = new ContactInfoDAOJdbcImpl();

        infoDAO.findAll().forEach(System.out::println);
        System.out.println(infoDAO.findById("info1").isPresent());

    }
}