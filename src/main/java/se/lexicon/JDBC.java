package se.lexicon;


import se.lexicon.data.People;
import se.lexicon.data.PeopleImpl;
import se.lexicon.data.TodoItems;
import se.lexicon.data.TodoItemsImpl;

import java.util.Collection;

public class JDBC {

    public static void main(String[] args) {
        People peopleDao = new PeopleImpl();
        TodoItems todoItemsDao = new TodoItemsImpl();

        //Person createPerson = peopleDao.create(new Person("",""));
        //System.out.println(createPerson);

        //Collection<Person> findAll = peopleDao.findAll();
        //findAll.forEach(System.out::println);

        //Person findById = peopleDao.findById(3);
        //System.out.println("Result: " + findById);

        //Collection<Person> findByName = peopleDao.findByName("Adelina");
        //findByName.forEach(System.out::println);

        //Person update = new Person(23, "Filip", "Holgersson");
        //Person updated = peopleDao.update(update);
        //System.out.println("Person updated");

        //boolean delete = peopleDao.deleteById(8);
        //System.out.println("Person deleted = " + delete);


        //Todo createTodo = new Todo("Car workshop task","Change brakes on a car", "2021-04-01",true, 2);
        //Todo createdTodo = todoItemsDao.create(createTodo);
        //System.out.println("Task added: " + createTodo);

        //Collection<Todo> findAll = todoItemsDao.findAll();
        //findAll.forEach(System.out::println);

        //Todo findById = todoItemsDao.findById(5);
        //System.out.println("Result: " + findById);

        //Collection<Todo> findByDoneStatus = todoItemsDao.findByDoneStatus(true);
        //System.out.println("Status = " + findByDoneStatus);

        //Collection<Todo> findByAssignee = todoItemsDao.findByAssignee(2);
        //System.out.println("Item : " + findByAssignee);

        //Collection<Todo> findByAssignee = todoItemsDao.findByAssignee(new Person(10,"Mehrdad", "Javan"));
        //findByAssignee.forEach(System.out::println);

        //Collection<Todo> findByUnassigneeTodoItems = todoItemsDao.findByUnassignedTodoItems();
        //findByUnassigneeTodoItems.forEach(System.out::println);

        Todo update = new Todo(5,"Repairman", "Service cars", "2026-11-16", true, 2);
        Todo updated = todoItemsDao.update(update);
        System.out.println(updated);

        //boolean delete = todoItemsDao.deleteById(9);
        //System.out.println("Item deleted = " + delete);
    }
}