package se.lexicon.data;

import se.lexicon.Person;
import se.lexicon.Todo;
import se.lexicon.data.db.MySqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class TodoItemsImpl implements TodoItems {

    @Override
    public Todo create(Todo todo) {
        String query = "insert into todo_item (title, description, deadline, done, assignee_id) values (?,?,?,?,?)";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getDescription());
            preparedStatement.setString(3, todo.getDeadline());
            preparedStatement.setBoolean(4, todo.isDone());
            preparedStatement.setInt(5, todo.getAssignee_id());

            int resultSet = preparedStatement.executeUpdate();

            System.out.println((resultSet == 1) ? "Item added to list" : "Item not added to list");
            ResultSet resultSet1 = preparedStatement.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo;
    }

    @Override
    public Collection<Todo> findAll() {
        String query = "select * from todo_item";
        Collection<Todo> todoList = new ArrayList<>();
        try {
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                todoList.add(new Todo(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoList;
    }

    @Override
    public Todo findById(int id) {
        String query = "select * from todo_item where todo_id = ?";
        Todo todo = new Todo();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                todo.setTodoId(resultSet.getInt(1));
                todo.setTitle(resultSet.getString(2));
                todo.setDescription(resultSet.getString(3));
                todo.setDeadline(resultSet.getString(4));
                todo.setDone(resultSet.getBoolean(5));
                todo.setAssignee_id(resultSet.getInt(6));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todo;
    }

    @Override
    public Collection<Todo> findByDoneStatus(boolean done) {
        String query = "select * from todo_item where done = ?";
        Collection<Todo> todoList = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setBoolean(1, done);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                todoList.add(new Todo(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoList;
    }

    @Override
    public Collection<Todo> findByAssignee(int id) {
        String query = "select * from todo_item where assignee_id = ?";
        Collection<Todo> todoList = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                todoList.add(new Todo(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoList;
    }

    @Override
    public Collection<Todo> findByAssignee(Person person) {
        String query = "select * from todo_item where assignee_id = ?";
        Collection<Todo> todoList = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setInt(1, person.getPersonId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                todoList.add(new Todo(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoList;
    }

    @Override
    public Collection<Todo> findByUnassignedTodoItems() {
        String query = "select * from todo_item where assignee_id is null";
        Collection<Todo> todoList = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                todoList.add(new Todo(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getBoolean(5),
                        resultSet.getInt(6)
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todoList;
    }

    @Override
    public Todo update(Todo todo) {
        String query = "update todo_item set title =?, description =?, deadline =?, done =?, assignee_id =? where todo_id =?";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
                ) {
            preparedStatement.setString(1, todo.getTitle());
            preparedStatement.setString(2, todo.getDescription());
            preparedStatement.setString(3, todo.getDeadline());
            preparedStatement.setBoolean(4, todo.isDone());
            preparedStatement.setInt(5, todo.getAssignee_id());
            preparedStatement.setInt(6, todo.getTodoId());

            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Items are updated" : "Items not updated");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return todo;
    }

    @Override
    public boolean deleteById(int id) {
        String query = "delete from todo_item where todo_id = ?";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            int resultSet = preparedStatement.executeUpdate();
            System.out.println((resultSet == 1) ? "Item deleted from list" : "Item not deleted");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
