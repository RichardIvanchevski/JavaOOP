package p01_Database;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private Database database;
    private static final Integer[] ELEMENTS = {1,3,4,10,20,30};
    @Before
    public void prepare() throws OperationNotSupportedException {
        database = new Database(ELEMENTS);
    }
    @Test
    public void testConstructorCreatesValidDB() throws OperationNotSupportedException {
        Integer[] dbElements = database.getElements();
        Assert.assertArrayEquals(ELEMENTS, dbElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCapacityOfArrMustBeMax16() throws OperationNotSupportedException {
        Integer[] arrCheck = new Integer[17];
        database = new Database(arrCheck);

    }
    @Test(expected = OperationNotSupportedException.class)
    public void testCapacityNegativeOfArray() throws OperationNotSupportedException{
        Integer[] arrCheck = new Integer[0];
        database = new Database(arrCheck);
    }
    @Test
    public void testAddNumberInTheLastIndex() throws OperationNotSupportedException {
        Integer[] dbBeforeAdd = database.getElements();
        database.add(100);
        Integer[] dbAddedLastNumber = database.getElements();
        Assert.assertEquals(Integer.valueOf(100),dbAddedLastNumber[dbAddedLastNumber.length - 1]);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testAddNullElementThrowsException() throws OperationNotSupportedException {
        database.add(null);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementWhenArrIsEmpty() throws OperationNotSupportedException {
        Integer[] empty = new Integer[0];
        database = new Database(empty);
        database.remove();
    }
    @Test
    public void testRemoveLastArrElement() throws OperationNotSupportedException {
        Integer[] dbCopyBeforeRemove = database.getElements();
        database.remove();
        Integer[] dbCopyAfterRemove = database.getElements();
        Assert.assertEquals(dbCopyAfterRemove.length - 1, dbCopyBeforeRemove.length - 2);
        int numBeforeRemove = dbCopyBeforeRemove[dbCopyBeforeRemove.length - 2];
        int numAfterRemove = dbCopyAfterRemove[dbCopyAfterRemove.length - 1];
        Assert.assertEquals(numAfterRemove,numBeforeRemove);
    }
}