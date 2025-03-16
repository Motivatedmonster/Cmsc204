package assingment3;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedList_STUDENT_Test {
    private BasicDoubleLinkedList<String> list;

    @Before
    public void setUp() throws Exception {
        list = new BasicDoubleLinkedList<>();
        list.addToEnd("ABC");
        list.addToEnd("DEF");
        list.addToEnd("GHK");
    }

    @After
    public void tearDown() throws Exception {
        list = null;
    }

    @Test
    public void testAddToFront() {
        list.addToFront("Dogs");
        assertEquals("Dogs", list.getFirst());
    }

    @Test
    public void testAddToEnd() {
        list.addToEnd("DAGI");
        assertEquals("DAGI", list.getLast());
    }

    @Test
    public void testGetFirst() {
        assertEquals("ABC", list.getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals("GHK", list.getLast());
    }

    @Test
    public void testRemoveElement() {
        list.remove("DEF", String::compareTo);
        ArrayList<String> result = list.toArrayList();
        assertFalse(result.contains("DEF"));
    }

    @Test
    public void testIterator() {
        ListIterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("ABC", iterator.next());
        assertEquals("DEF", iterator.next());
        assertEquals("GHK", iterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNoSuchElementException() {
        ListIterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next(); 
    }
}

