package com.github.bobedyshmit.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database implements AutoCloseable {

    private static final String PEOPLE_TABLE        = "people";
    private static final String CREATE_PEOPLE_TABLE = "create table if not exists " + PEOPLE_TABLE + " (personId integer not null unique, firstname text, lastname text, age integer check (age >= 0))";
    private static final String INSERT_PERSON       = "insert into " + PEOPLE_TABLE + " values (?, ?, ?, ?)";
    private static final String DELETE_PERSON       = "delete from " + PEOPLE_TABLE + " where (? = personId)";
    private static final String SELECT_PERSON       = "select personId from " + PEOPLE_TABLE;

    private final int           PERSON_ID           = 1;
    private final int           FIRST_NAME          = 2;
    private final int           LAST_NAME           = 3;
    private final int           AGE                 = 4;

    private final Connection    connection;

    public Database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:/home/martin/sqlite/database.db");
        init();
    }

    private void init() throws SQLException {
        try (final PreparedStatement stmt = connection.prepareStatement(CREATE_PEOPLE_TABLE)) {
            stmt.execute();
        }
    }

    public void insertPerson(final Person person) throws SQLException {
        try (final PreparedStatement stmt = connection.prepareStatement(INSERT_PERSON)) {

            stmt.setInt(PERSON_ID, person.getPersonId());
            stmt.setString(FIRST_NAME, person.getFirstName());
            stmt.setString(LAST_NAME, person.getLastName());
            stmt.setInt(AGE, person.getAge());
            stmt.execute();

        }
        catch (final SQLException e) {
            System.out.println("Person Already Exists");
        }
    }

    public void deletePerson(final Person person) throws SQLException {
        try (final PreparedStatement stmt = connection.prepareStatement(DELETE_PERSON)) {
            stmt.setInt(1, person.getPersonId());
            stmt.execute();
        }
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

}
