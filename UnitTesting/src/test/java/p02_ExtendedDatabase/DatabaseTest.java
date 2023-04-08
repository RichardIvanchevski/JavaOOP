package p02_ExtendedDatabase;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class DatabaseTest {

    private static final Person richi = new Person(1, "richi");
    private static final Person teri = new Person(2, "teri");
    private static final Person sisi = new Person(3, "sisi");
    private Person person;
    private Database database;

    @Before
    public void prepare() throws OperationNotSupportedException {
        database = new Database(richi, teri, sisi);
    }

    @Test
    public void testConstructor() throws OperationNotSupportedException {
        // create sample Persons
        Person person1 = new Person(1, "John");
        Person person2 = new Person(2, "Jane");

        // create database with sample Persons
        Database database = new Database(person1, person2);

        // check if the database contains the correct Persons
        Person[] expectedPersons = { person1, person2 };
        Person[] actualPersons = database.getElements();
        assertArrayEquals(expectedPersons, actualPersons);
    }


    @Test
    public void testAddPersonToDatabase() throws OperationNotSupportedException {
        Person gosho = new Person(4, "gosho");
        List<Person> personBeforeAddList = Arrays.asList(database.getElements());
        database.add(gosho);
        List<Person> personAfterAddList = Arrays.asList(database.getElements());
        Assert.assertEquals(personBeforeAddList.size() + 1, personAfterAddList.size());
    }

    @Test
    public void testRemovePersonFromDatabase() throws OperationNotSupportedException {
        List<Person> personListBeforeRemove = Arrays.asList(database.getElements());
        database.remove();
        List<Person> personListAfterRemove = Arrays.asList(database.getElements());
        Assert.assertEquals(personListBeforeRemove.size() - 1, personListAfterRemove.size());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDublicateIdThrowsException() throws OperationNotSupportedException {
        Person dublicateIdPerson = new Person(3, "toshko");
        database.add(dublicateIdPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testNegativeIdThrowsException() throws OperationNotSupportedException {
        Person negativePerson = new Person(-1, "sashko");
        database.add(negativePerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonByIdDoesNotExistThrowsException() throws OperationNotSupportedException {
        person = database.findById(4);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonByUsernameDoesNotExistThrowsException() throws OperationNotSupportedException {
        person = database.findByUsername("petkan");
    }

    @Test
    public void testFindPersonInDatabaseById() throws OperationNotSupportedException {
        person = database.findById(3);
        Assert.assertEquals(3, person.getId());
    }

    @Test
    public void testFindPersonInDatabaseByName() throws OperationNotSupportedException {
        person = database.findByUsername("richi");
        Assert.assertEquals("richi", person.getUsername());
    }
}