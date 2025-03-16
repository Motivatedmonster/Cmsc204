package assingment3;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import assingment3.BasicDoubleLinkedList.Node;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
    private Comparator<T> comparator;

    public SortedDoubleLinkedList(Comparator<T> comparator) {
        this.comparator = comparator;
    }

   
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (head == null) { 
            head = newNode;
            tail = newNode;
        } else if (comparator.compare(data, head.data) <= 0) { 
        	head.previous = newNode;
            newNode.next = head;
            head = newNode;
        } else if (comparator.compare(data, tail.data) >= 0) { 
        	 newNode.previous = tail;
             tail.next = newNode;
             tail = newNode;
        } else { 
            Node<T> current = head;
            while (comparator.compare(current.data, data) < 0) {
                current = current.next;
            }
            newNode.previous = current.previous;
            newNode.next = current;
            current.previous.next = newNode;
            current.previous = newNode;
        }
        size++;
    }

    @Override
    public ListIterator<T> iterator() {
        return new DoubleLinkedListIterator();
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
    @Override
    public void addToFront(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    @Override
    public void addToEnd(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
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
