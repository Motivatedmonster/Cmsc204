package assingment3;
import static org.junit.Assert.*;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedList_STUDENT_Test {
    private SortedDoubleLinkedList<Integer> sortedList;
    private IntegerComparator comparator;

    private static class IntegerComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }
    }

    @Before
    public void setUp() throws Exception {
        comparator = new IntegerComparator();
        sortedList = new SortedDoubleLinkedList<>(comparator);
        sortedList.add(20);
        sortedList.add(10);
        sortedList.add(30);
    }

    @After
    public void tearDown() throws Exception {
        sortedList = null;
    }

    
    @Test
    public void testIterator() {
        ListIterator<Integer> iterator = sortedList.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(10), iterator.next());
        assertEquals(Integer.valueOf(20), iterator.next());
        assertEquals(Integer.valueOf(30), iterator.next());
    }

    @Test
    public void testRemoveElement() {
        sortedList.remove(20, comparator);
        ListIterator<Integer> iterator = sortedList.iterator();
        assertEquals(Integer.valueOf(10), iterator.next());
        assertEquals(Integer.valueOf(30), iterator.next());
    }

    @Test
    public void testAdd() {
        sortedList.add(16);
        ListIterator<Integer> iterator = sortedList.iterator();
        assertEquals(Integer.valueOf(10), iterator.next());
        assertEquals(Integer.valueOf(16), iterator.next());
        assertEquals(Integer.valueOf(20), iterator.next());
        assertEquals(Integer.valueOf(30), iterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNoSuchElementException() {
        ListIterator<Integer> iterator = sortedList.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next(); 
    }
}
