package dao.implementation.jdbc;

import dao.EntitieDAO;
import db.ConnectionFactory;
import db.DBException;
import model.entities.Book;

import java.sql.*;
import java.util.List;

public class BookDAOJDBC implements EntitieDAO<Book> {
    private Connection connection;

    public BookDAOJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Book book) {
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(
                    "INSERT INTO books "
                            + "(`title`, `subTitle`, `releaseDate`, `readStatus`, `aquisitionStatus`, `isbn`, `publishingCompany`, `edition`)"
                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getSubTitle());
            ps.setDate(3, new Date(book.getReleaseDate().getTimeInMillis()));
            ps.setBoolean(4, book.isReadStatus());
            ps.setBoolean(5, book.isAcquisitionStatus());
            ps.setString(6, book.getIsbn());
            ps.setString(7, book.getPublishingCompany());
            ps.setInt(8, book.getEdition());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet resultSet = ps.getGeneratedKeys();
                if (resultSet.next()) {
                    Long id = resultSet.getLong(1);
                    book.setId(id);
                }

                ConnectionFactory.closeResultSet(resultSet);
            }
        } catch (SQLException throwables) {
            throw new DBException(throwables.getMessage());
        } finally {
            ConnectionFactory.closeStatement(ps);
        }
    }

    @Override
    public void update(Book book) {
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement(
            "UPDATE `books`"
                + "SET "
                + "`title` = ?, `subTitle` = ?, `releaseDate` = ?, `readStatus` = ?, `aquisitionStatus` = ?, `isbn` = ?, `publishingCompany` = ?, `edition` = ? "
            + "WHERE `id` = ?"
            );

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getSubTitle());
            ps.setDate(3, new Date(book.getReleaseDate().getTimeInMillis()));
            ps.setBoolean(4, book.isReadStatus());
            ps.setBoolean(5, book.isAcquisitionStatus());
            ps.setString(6, book.getIsbn());
            ps.setString(7, book.getPublishingCompany());
            ps.setInt(8, book.getEdition());
            ps.setLong(9, book.getId());

            ps.executeLargeUpdate();

        } catch (SQLException throwables) {
            throw new DBException(throwables.getMessage());
        } finally {
            ConnectionFactory.closeStatement(ps);
        }
    }

    @Override
    public void deletById(Long id) {
        PreparedStatement ps = null;

        try {
            ps = connection.prepareStatement("DELETE FROM `books` WHERE id = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throw new DBException(throwables.getMessage());
        } finally {
            ConnectionFactory.closeStatement(ps);
        }
    }

    @Override
    public Book findById(Long id) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }
}
