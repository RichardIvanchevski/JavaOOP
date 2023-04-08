package p04_BubbleSortTest;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BubbleTest {

    @Test
    public void testBubbleSort() {
        int[] arr = {64, 25, 12, 22, 11};
        int[] expected = {11, 12, 22, 25, 64};
        Bubble.sort(arr);
        assertArrayEquals(expected, arr);

    }
}