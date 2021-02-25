package se.lexicon.data;

import se.lexicon.Person;
import se.lexicon.data.db.MySqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class PeopleImpl implements People {
    @Override
    public Person create(Person person) {
        String query = "insert into person (first_name, last_name) values (?,?)";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());

            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "New person added" : "No person added");
            ResultSet rs = preparedStatement.getGeneratedKeys();
            int idKey = 0;
            while (rs.next()) {
                idKey = rs.getInt(1);
            }
            person.setPersonId(idKey);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Collection<Person> findAll() {
        String query = "select * from person";
        Collection<Person> personList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                personList.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    @Override
    public Person findById(int id) {
        String query = "select * from person where person_id = ?";
        Person person = new Person();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                person.setPersonId(resultSet.getInt(1));
                person.setFirstName(resultSet.getString(2));
                person.setLastName(resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public Collection<Person> findByName(String name) {
        String query = "select * from person where first_name = ?";
        Collection<Person> personList = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                personList.add(new Person(
                        resultSet.getInt(1),
                        resultSet.getNString(2),
                        resultSet.getString(3)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personList;
    }

    @Override
    public Person update(Person person) {
        String query = "update person set first_name = ?, last_name = ? where person_id = ?";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getPersonId());

            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Database updated" : "Database not updated");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "delete from person where person_id = ?";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Person deleted" : "Person not deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
