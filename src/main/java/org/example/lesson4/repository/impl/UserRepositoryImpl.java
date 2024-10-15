package org.example.lesson4.repository.impl;

import org.example.lesson4.exception.DataProcessingException;
import org.example.lesson4.model.User;
import org.example.lesson4.repository.UserRepository;
import org.example.lesson4.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private static final int MIN_AFFECTED_ROWS_COUNT = 1;
    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String PASSWORD = "password";
    private static final String REPEAT_PASSWORD = "repeatPassword";

    @Override
    public User save(User user) {
        String sqlRequest = "INSERT INTO users (email, phoneNumber, password, repeatPassword) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest, Statement.RETURN_GENERATED_KEYS)) {

            int i = 1;
            preparedStatement.setString(i++, user.getEmail());
            preparedStatement.setString(i++, user.getPhoneNumber());
            preparedStatement.setString(i++, user.getPassword());
            preparedStatement.setString(i, user.getRepeatPassword());

            int affectedRows = preparedStatement.executeUpdate();
            checkAffectedRowsNumber(affectedRows);
            ResultSet generatedKeys = connection.createStatement().executeQuery("SELECT last_insert_rowid()");

            if (generatedKeys.next()) {
                Long id = generatedKeys.getLong(1);
                user.setId(id);
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't create instance of users:"
                    + user.toString()
                    + " and add it to DB", e);
        }

        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        String sqlRequest = "SELECT * FROM users WHERE id = ?";

        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(parseUser(resultSet));
            }
        } catch (SQLException e) {
            throw new DataProcessingException("Can't find user by id. ID=" + id, e);
        }
        return Optional.empty();
    }

    private void checkAffectedRowsNumber(int number) {
        if (number < MIN_AFFECTED_ROWS_COUNT) {
            throw new DataProcessingException("Excepted to change at least 1 row. "
                    + "But changed 0 rows.");
        }
    }

    private User parseUser(ResultSet requestResult) {
        try {
            Long id = requestResult.getLong(ID);
            String email = requestResult.getString(EMAIL);
            String phoneNumber = requestResult.getString(PHONE_NUMBER);
            String password = requestResult.getString(PASSWORD);
            String repeatPassword = requestResult.getString(REPEAT_PASSWORD);

            return new User(id, email, phoneNumber, password, repeatPassword);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't parse User "
                    + "data from resultSet", e);
        }
    }
}
