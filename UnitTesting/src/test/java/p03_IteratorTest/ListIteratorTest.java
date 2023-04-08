package p03_IteratorTest;


import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.*;

public class ListIteratorTest{

    private ListIterator listIterator;
    private static final String WORD1 = "word1";
    private static final String WORD2 = "word2";
    private static final String WORD3 = "word3";


    @Before
    public void prepare() throws OperationNotSupportedException {
        listIterator = new ListIterator(WORD1,WORD2,WORD3);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testCreateConstructorWithNULLThrowsException() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

//    @Test
//    public void testCreateObjectWithGivenWords() throws OperationNotSupportedException {
//        String WORD1 = "apple";
//        String WORD2 = "banana";
//
//        ListIterator listIterator = new ListIterator(WORD1, WORD2);
//
//        List<String> expectedElements = Arrays.asList(WORD1, WORD2);
//        int expectedCurrentIndex = 0;
//
//        assertEquals(expectedElements, listIterator.getElements());
//
//        assertEquals(expectedCurrentIndex, listIterator.getCurrentIndex());
//    }

    @Test
    public void testIndexShouldIncrement(){
        listIterator.move();
        String secondWord = listIterator.print();
        boolean areEquals = secondWord.equals(WORD2);
        assertTrue(areEquals);

    }

    @Test()
    public void testIndexShouldNotIncrementBecauseNoNextWord() throws OperationNotSupportedException {
        listIterator = new ListIterator(WORD1);
        String word = listIterator.print();
        listIterator.move();
        boolean areEquals = word.equals(WORD1);
        assertTrue(areEquals);

    }

    @Test
    public void testHasNext() {

        Assert.assertTrue(listIterator.hasNext());
        listIterator.move(); //Gosho
        Assert.assertTrue(listIterator.hasNext());
        listIterator.move(); //Toshko
        Assert.assertFalse(listIterator.hasNext());
    }
    @Test
    public void testPrintOperationShouldReturnCorrectWord(){
        String currentWord = listIterator.print();
        assertEquals(WORD1,currentWord);

        listIterator.move();

        currentWord = listIterator.print();
        assertEquals(WORD2,currentWord);
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintShouldThrowExceptionWhenIsEmpty() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }
}
