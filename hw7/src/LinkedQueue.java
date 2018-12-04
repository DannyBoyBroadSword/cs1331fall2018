import javafx.collections.ModifiableObservableListBase;
import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * @author ahennessy6
 * @version 1.0.1
 * @param <E> is the generic type to be later defined defines the generic types
 *        in nodes
 */
public class LinkedQueue<E> extends ModifiableObservableListBase<E>
        implements Iterable<E>, SimpleQueue<E> {
    private LinkedQueueNode<E> head;
    private LinkedQueueNode<E> tail;
    private int n;


    /**
     * LinkedQueue Constructor.
     */
    public LinkedQueue() {
        this.head = null;
        this.tail = null;
        this.n = 0;
    }

    /**
     * @return an iterator
     */
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    /**
     * @author andrewhennessy
     * QueueIterator Private Inner Class
     */
    private class QueueIterator implements Iterator<E> {
        private LinkedQueueNode<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E e = current.getData();
            current = current.getNext();
            return e;
        }

    }

    /**
     * lets us know if linked list is empty
     * @return if the linked list is empty as boolean
     */
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void enqueue(E element) {
        super.add(element);
    }

    /**
     * @param element that should be passed in.
     */
    public void enqueueTwo(E element) {
        LinkedQueueNode<E> previousLast = tail;
        tail = new LinkedQueueNode<E>((E) element);
        if (isEmpty()) {
            head = tail;
        } else {
            previousLast.setNext(tail);
        }
        n++;

    }

    @Override
    public E dequeue() {
        return super.remove(0);
    }

    /**
     * @return E from dequeueTwo using nodes
     */
    public E dequeueTwo() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("");
        }
        E fromFirst = head.getData();
        head = head.getNext();
        n--;
        if (this.isEmpty()) {
            tail = null;
        }
        return fromFirst;
    }

    @Override
    public E get(int index) {
        Iterator<E> queueIterator = this.iterator();

        int counter = 0;
        E buffer = null;
        E finalBuffer = null;
        if (index > this.size() - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            while (queueIterator.hasNext()) {
                if (counter == index) {
                    finalBuffer = queueIterator.next();
                    return finalBuffer;
                } else {
                    buffer = queueIterator.next();
                    counter++;
                }
            }
            return finalBuffer;
        }
    }

    @Override
    public int size() {
        return n;
    }

    /**
     * clears
     */
    public void clear() {
        n = 0;
        head = null;
        tail = null;
    }

    @Override
    protected void doAdd(int index, E element) {
        // System.out.println(index);
        if (index == 0) {
            this.enqueueTwo(element);
        } else {
            // watch out for -1
            if (index > this.size()) {
                throw new IndexOutOfBoundsException();
            } else {
                for (int i = 0; i < index; i++) {
                    this.enqueueTwo(this.dequeueTwo());
                }
                this.enqueueTwo(element);
                for (int i = index + 1; i < this.size(); i++) {
                    this.enqueueTwo(this.dequeueTwo());
                }
            }
        }
    }

    @Override
    protected E doSet(int index, E element) {
        if (1 == 1) {
            throw new UnsupportedOperationException();
        } else {
            return element;
        }
        /*E buffer = null;
        // watch out for -1
        if (index > this.size() - 1) {
            throw new IndexOutOfBoundsException();
        } else {
            buffer = this.get(index);
            for (int i = 0; i < index; i++) {
                this.enqueueTwo(this.dequeueTwo());
            }
            buffer = this.dequeueTwo();
            this.enqueueTwo(element);
            for (int i = index + 1; i < this.size(); i++) {
                this.enqueueTwo(this.dequeueTwo());
            }

        }
        return buffer;
        */
    }

    @Override
    protected E doRemove(int index) {
        E buffer = null;
        // watch out for -1
        if (index > this.size()) {
            throw new IndexOutOfBoundsException();
        } else {
            if (this.size() == 0 && index == 0) {
                return null;
            }
            buffer = this.get(index);
            for (int i = 0; i < index; i++) {
                this.enqueueTwo(this.dequeueTwo());
            }
            this.dequeueTwo();
            for (int i = index; i < this.size(); i++) {
                this.enqueueTwo(this.dequeueTwo());
            }
        }
        return buffer;
    }

}
