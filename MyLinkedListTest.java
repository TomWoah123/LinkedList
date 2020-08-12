import java.util.*;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * Tests the MyLinkedList class
 *
 * @author Timothy Wu
 * @version 10.16.18
 */
public class MyLinkedListTest {
    private MyLinkedList<Integer> nums;
    private MyLinkedList<String> str;

    /**
     * Sets up the 2 MyLinkedLists
     */
    @Before
    public void setUp() {
        nums = new MyLinkedList<Integer>();
        str = new MyLinkedList<String>();
        nums.add(new Integer(1));
        nums.add(new Integer(2));
        nums.add(new Integer(3));
        nums.add(new Integer(4));
        nums.add(new Integer(5));
        str.add("Timothy Wu");
        str.add("What is this?");
        str.add("hello");
        str.add("pineapple");
        str.add("hashtag");
    }

    /**
     * Sets the 2 MyLinkedLists equal to null
     */
    @After
    public void tearDown() {
        nums = null;
        str = null;
    }

    /**
     * Tests the constructor
     */
    @Test
    public void testConstructor() {
        MyLinkedList<Integer> i = new MyLinkedList<Integer>();
        assertEquals("[]", i.toString());
    }

    /**
     * Tests the constructor
     */
    @Test
    public void testOtherConstructor() {
        Collection<String> st = new ArrayList<String>();
        st.add("h");
        st.add("i");
        MyLinkedList<String> s = new MyLinkedList<String>(st);
        assertEquals("[ h, i ]", s.toString());
    }

    /**
     * Tests the method
     */
    @Test
    public void testAddWithOneParam() {
        assertTrue(nums.add(new Integer(6)));
    }

    /**
     * Tests the method
     */
    @Test
    public void testMoreAddWithOneParam() {
        assertFalse(str.add("pineapple"));
    }

    /**
     * Tests the method
     */
    @Test
    public void testAddWithTwoParam() {
        nums.add(3, new Integer(6));
        assertEquals("[ 1, 2, 3, 6, 4, 5 ]", nums.toString());
    }

    /**
     * Tests the method
     */
    @Test
    public void testMoreAddWithTwoParam() {
        nums.add(0, new Integer(7));
        assertEquals("[ 7, 1, 2, 3, 4, 5 ]", nums.toString());
    }

    /**
     * Tests the method
     */
    @Test
    public void testEvenMoreAddWithTwoParam() {
        str.add(1, "hey");
        assertEquals("[ Timothy Wu, hey, What is this?, hello,"
                + " pineapple, hashtag ]", str.toString());
    }

    /**
     * Tests the method
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddWithTwoParamError() {
        assertEquals(str, str);
        str.add(-1, "applejohnnyseed");
    }

    /**
     * Tests the method
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoreAddWithTwoParamError() {
        assertEquals(nums, nums);
        nums.add(18, new Integer(69));
    }

    /**
     * Tests the method
     */
    @Test
    public void testRemoveWithObj() {
        str.remove("What is this?");
        assertEquals("[ Timothy Wu, hello, "
                + "pineapple, hashtag ]", str.toString());
    }

    /**
     * Tests the method
     */
    @Test
    public void testMoreRemoveWithObj() {
        assertFalse(nums.remove(new Integer(7)));
    }

    /**
     * Tests the method
     */
    @Test
    public void testRemoveWithIndex() {
        str.remove(1);
        assertEquals("[ Timothy Wu, hello, "
                + "pineapple, hashtag ]", str.toString());
    }

    /**
     * Tests the method
     */
    @Test
    public void testMoreRemoveWithIndex() {
        nums.remove(0);
        assertEquals("[ 2, 3, 4, 5 ]", nums.toString());
    }

    /**
     * Tests the method
     */
    @Test
    public void testEvenMoreRemoveWithIndex() {
        str.remove(4);
        assertEquals("[ Timothy Wu, What is this?, hello, pineapple ]",
                str.toString());
    }

    /**
     * Tests the method
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveWithIndexWithError() {
        assertEquals(nums, nums);
        nums.remove(-1);
    }

    /**
     * Tests the method
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoreRemoveWithIndexWithError() {
        assertEquals(str, str);
        str.remove(19);
    }

    /**
     * Tests the method
     */
    @Test
    public void testGet() {
        assertEquals(3, (Object) nums.get(2));
    }

    /**
     * Tests the method
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetWithError() {
        assertEquals(nums, nums);
        nums.get(-1);
    }

    /**
     * Tests the method
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoreGetWithError() {
        assertEquals(str, str);
        str.get(7);
    }

    /**
     * Tests the method
     */
    @Test
    public void testSet() {
        nums.set(2, new Integer(7));
        assertEquals("[ 1, 2, 7, 4, 5 ]", nums.toString());
    }

    /**
     * Tests the method
     */
    @Test
    public void testSetAtBeginning() {
        str.set(0, "h");
        assertEquals("[ h, What is this?, hello, "
                + "pineapple, hashtag ]", str.toString());
    }

    /**
     * Tests the method
     */
    @Test
    public void testSetAtEnd() {
        nums.set(4, new Integer(6));
        assertEquals("[ 1, 2, 3, 4, 6 ]", nums.toString());
    }

    /**
     * Tests the method
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetWithError() {
        assertEquals(str, str);
        str.set(-1, "jk");
    }

    /**
     * Tests the method
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoreSetWithError() {
        nums.set(6, new Integer(8));
        assertEquals(nums, nums);
    }

    /**
     * Tests the method
     */
    @Test
    public void testSize() {
        assertEquals(5, nums.size());
    }

    /**
     * Tests the method
     */
    @Test
    public void testContains() {
        assertTrue(nums.contains(new Integer(4)));
    }

    /**
     * Tests the method
     */
    @Test
    public void testMoreContains() {
        assertFalse(str.contains("yup"));
    }

    /**
     * Tests the method
     */
    @Test
    public void testIsEmpty() {
        MyLinkedList<Integer> i = new MyLinkedList<Integer>();
        assertTrue(i.isEmpty());
    }

    /**
     * Tests the method
     */
    @Test
    public void testMoreIsEmpty() {
        assertFalse(str.isEmpty());
    }

    /**
     * Tests the method
     */
    @Test
    public void testToString() {
        assertEquals("[ Timothy Wu, What is this?, hello,"
                + " pineapple, hashtag ]", str.toString());
    }

    /**
     * Tests the method
     */
    @Test
    public void testMoreToString() {
        MyLinkedList<Integer> n = new MyLinkedList<Integer>();
        assertEquals("[]", n.toString());
    }

    /**
     * Tests the method
     */
    @Test
    public void testClear() {
        nums.clear();
        assertEquals(0, nums.size());
    }

    /**
     * Tests the method
     */
    @Test
    public void testAddAll() {
        Collection<String> c = new ArrayList<String>();
        c.add("tops");
        c.add("hello darkness");
        c.add("12");
        str.addAll(c);
        assertEquals("[ Timothy Wu, What is this?, hello, pineapple,"
                + " hashtag, tops, hello darkness, 12 ]", str.toString());
    }

    /**
     * Tests the method
     */
    @Test
    public void testIndexOf() {
        assertEquals(3, nums.indexOf(new Integer(4)));
    }

    /**
     * Tests the method
     */
    @Test
    public void testMoreIndexOf() {
        assertEquals(0, str.indexOf("Timothy Wu"));
    }

    /**
     * Tests the method
     */
    @Test
    public void testIndexOfWithNegative() {
        assertEquals(-1, nums.indexOf(new Integer(69)));
    }

    /**
     * Tests the method
     */
    @Test
    public void testLastIndexOf() {
        assertEquals(2, str.lastIndexOf("hello"));
    }

    /**
     * Tests the method
     */
    @Test
    public void testMoreLastIndexOf() {
        nums.add(5, new Integer(2));
        assertEquals(5, nums.lastIndexOf(new Integer(2)));
    }

    /**
     * Tests the method
     */
    @Test
    public void testEvenMoreLastIndexOf() {
        nums.add(5, new Integer(4));
        nums.add(6, new Integer(5));
        nums.add(7, new Integer(4));
        assertEquals(7, nums.lastIndexOf(new Integer(4)));
    }

    /**
     * Tests the method
     */
    @Test
    public void testLastIndexOfWithNegative() {
        assertEquals(-1, str.lastIndexOf("gg"));
    }

    /**
     * Tests the method
     */
    @Test
    public void testLastIndexOfWithNothing() {
        MyLinkedList<String> s = new MyLinkedList<String>();
        assertEquals(-1, s.lastIndexOf("hi"));
    }

    /**
     * Tests the method
     */
    @Test
    public void testRemoveRange() {
        nums.removeRange(1, 4);
        assertEquals("[ 1, 5 ]", nums.toString());
    }

    /**
     * Tests the method
     */
    @Test
    public void testRemoveRangeBegin() {
        str.removeRange(0, 2);
        assertEquals("[ hello, pineapple, hashtag ]", str.toString());
    }

    /**
     * Tests the method
     */
    @Test
    public void testRemoveRangeEnd() {
        nums.removeRange(3, 5);
        assertEquals("[ 1, 2, 3 ]", nums.toString());
    }

    /**
     * Tests the method
     */
    @Test
    public void testRemoveRangeEverything() {
        str.removeRange(0, 5);
        assertEquals("[]", str.toString());
    }

    /**
     * Tests the method
     */
    @Test
    public void testRemoveRangeNothing() {
        nums.removeRange(2, 2);
        assertEquals("[ 1, 2, 3, 4, 5 ]", nums.toString());
    }

    /**
     * Tests the method
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveRangeWithError() {
        assertEquals(str, str);
        str.removeRange(-1, 4);
    }

    /**
     * Tests the method
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoreRemoveRangeWithError() {
        assertEquals(nums, nums);
        nums.removeRange(2, 9);
    }

    /**
     * Tests the method
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testEvenMoreRemoveRangeWithError() {
        assertEquals(str, str);
        str.removeRange(4, 2);
    }

    /**
     * Tests the method
     */
    @Test
    public void testToArray() {
        Integer[] arr = {1, 2, 3, 4, 5};
        assertArrayEquals(arr, nums.toArray());
    }

    /**
     * Tests the method
     */
    @Test
    public void testEquals() {
        MyLinkedList<Integer> other = new MyLinkedList<Integer>();
        other.add(new Integer(1));
        other.add(new Integer(2));
        other.add(new Integer(3));
        other.add(new Integer(4));
        other.add(new Integer(5));
        assertTrue(nums.equals(other));
    }

    /**
     * Tests the method
     */
    @Test
    public void testEqualsWithDifferentItems() {
        MyLinkedList<String> other = new MyLinkedList<String>();
        other.add("Timothy Wu");
        other.add("hello");
        other.add("what in the world?");
        other.add("gg");
        other.add("good job!");
        assertFalse(str.equals(other));
    }

    /**
     * Tests the method
     */
    @Test
    public void testEqualsWithDifferentSizes() {
        MyLinkedList<Integer> other = new MyLinkedList<Integer>();
        other.add(new Integer(1));
        other.add(new Integer(2));
        other.add(new Integer(3));
        assertFalse(nums.equals(other));
    }

    /**
     * Tests the method
     */
    @Test
    public void testEqualsNotEvenLinkedList() {
        String other = "not a linkedlist";
        assertFalse(str.equals(other));
    }

    /**
     * Tests the method
     */
    @Test
    public void testEqualsDifferentType() {
        MyLinkedList<String> other = new MyLinkedList<String>();
        other.add("top");
        other.add("youtube");
        other.add("wAck");
        other.add("yeet");
        other.add("smash");
        assertFalse(nums.equals(other));
    }
}
