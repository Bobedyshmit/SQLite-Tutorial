package com.github.bobedyshmit.sqlitetutorial;

import java.sql.SQLException;

public class App {

    public static void main(final String[] args) throws SQLException, Exception {
        try (Database db = new Database()) {
            final Person person = new Person(1, "Martin", "Knoetze", 26);
            final Person person2 = new Person(2, "Henri", "Knoetze", 24);
            
            db.insertPerson(person);
            //db.insertPerson(person2);
            //db.insertPerson(person);
            //db.deletePerson(person);
            //db.deletePerson(person2);
        }
    }

}
