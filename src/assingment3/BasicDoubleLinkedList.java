package assingment3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> {
    protected Node<T> head;
    protected Node<T> tail;
    protected int size;
    public class Node<T> {
        T data;
        Node next;
        Node previous;
        public Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public BasicDoubleLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addToFront(T data) {
        Node<T> newNode = new Node<>(data);
        if (head != null) {
            head.previous = newNode;
            newNode.next = head;
            head = newNode;
        } else {
            head = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addToEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void remove(T targetData, Comparator<T> comparator) {
    	if (head == null) {
    		return;
    	}
        Node<T> current = head;
      while(current != null) {
    	  if (comparator.compare(current.data, targetData) == 0) {
    		  if (current == head) {
    			  head = head.next;
    			  head.previous = null;
    		  } else if (current == tail) {
    			  tail = tail.previous;
    			  tail.next = null;
    		  } else {
    			  current.previous.next = current.next;
    			  current.next.previous = current.previous;

    		  }
    		  size--;
    		  return;
    	  }
    	  current = current.next;
      }
    }


    public T getFirst() {
        if (head == null) {
        	return null;
        } else { 
        	return head.data;
        }
    }

    public T getLast() {
        if (tail == null) { 
        	return null;
       } 
        else {
        	return tail.data;}
    }

    public int getSize() {
        return size;
    }

    public T retrieveFirstElement() {
        if (head == null) {
            return null;
        }
        T data = head.data;
        head = head.next;
        if (head != null) {
            head.previous = null;
        } else {
            tail = null;
        }
        size--;
        return data;
    }

    public T retrieveLastElement() {
        if (tail == null) {
            return null;
        }
        T data = tail.data;
        tail = tail.previous;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        size--;
        return data;
    }

    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> arraylist = new ArrayList<>();
        Node<T> current = head;
        while (current != null) {
            arraylist.add(current.data);
            current = current.next;
        }
        return arraylist;
    }

    protected class DoubleLinkedListIterator implements ListIterator<T> {
        private Node<T> current = null;
        private boolean prevMoveWasNext = false;


        @Override
        public boolean hasNext() {
        	if (current == null && head != null) {
        		return true;
        	} else if (current != null && current.next != null) {
        		return true;
        	} else {
        		return false;
        	}
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (current == null) {
                current = head; 
            } else {
                current = current.next;
            }
            prevMoveWasNext = true;
            return current.data;
        }

        @Override
        public boolean hasPrevious() {
            if (current == null && tail != null) {
            	return true;
            } else if (current != null && current.previous != null) {
            	return true;
            } else {
            	return false;
            }
        }

        @Override
        public T previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
           if (prevMoveWasNext) {
                prevMoveWasNext = false;
            } else {
                current = current.previous; 
            }
            return current.data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T e) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }
    }

}


