package dao;

import dao.implementation.jdbc.BookDAOJDBC;
import db.ConnectionFactory;

public class DAOFactory {

    public static EntitieDAO createBookDAO() {
        return new BookDAOJDBC(ConnectionFactory.getConnection("medias"));
    }
}
