/**
 * @author ahennessy6
 * @version 1.0.1
 * @param <E> is the generic type to be later defined defines the List interface
 *        to be used in HW5
 */
public class MyList<E> implements List<E> {

    private E[] elements;
    private int size;
    /**
     * Instantiates list with size INITIAL_CAPACITY
     */
    public MyList() {
        this(INITIAL_CAPACITY);
    }
    /**
     * Instantiates list with size capacity and size 0
     * @param capacity is the size of the list that should be Instantiated
     */
    @SuppressWarnings("unchecked")
    public MyList(int capacity) {
        this.elements = (E[]) new Object[capacity];
        this.size = 0;

    }

    @SuppressWarnings("unchecked")
    @Override
    /**
     * Insert element to the back of the list. If the list is is at capacity,
     * double the capacity
     *
     * @param e the element to be added to the list
     * @throws IllegalArgumentException if invalid `E` is given
     */
    public void add(E e) throws IllegalArgumentException {
        if (e == null) {
            throw new IllegalArgumentException();
        } else {
            if (this.elements.length - 1 == size) {
                E[] buffer = (E[]) new Object[(size + 1) * 2];
                for (int i = 0; i < this.elements.length; i++) {
                    buffer[i] = this.elements[i];
                }
                this.elements = buffer;
                this.elements[this.size()] = e;
                this.size++;
            } else {
                this.elements[this.size()] = e;
                this.size++;
            }
        }

    }

    @Override
    /**
     * Get an element from the list.
     * @return E is returning an element of type E for the given index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     *
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (index > this.elements.length || index < 0
                || this.elements.length == 0) {
            throw new IndexOutOfBoundsException();
        } else {
            if (this.elements[index] == null) {
                throw new IndexOutOfBoundsException();
            } else {

                return this.elements[index];
            }

        }

    }

    @Override
    /**
     * Replace all instances of e with replaceWith.
     *
     * @param e           to be replaced in the list
     * @param replaceWith to replace e in the list
     * @throws IllegalArgumentException if one or both invalid `E`'s are passed
     *                                  in the method
     */
    public void replace(E e, E replaceWith) throws IllegalArgumentException {
        if (e == null || replaceWith == null) {
            throw new IllegalArgumentException();
        } else {
            for (int i = 0; i < this.elements.length; i++) {
                if (this.elements[i] == null) {
                    assert true;
                } else {
                    if (((Object) this.elements[i]).equals((Object) e)) {
                        this.elements[i] = replaceWith;
                    } else {
                        assert true;
                    }
                }

            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    /**
     * Removes all instances of element e in the list and returns the count
     *
     * @param e the element to be removed from the list
     * @return int representing the count
     */
    public int remove(E e) throws IllegalArgumentException {
        if (e == null) {
            throw new IllegalArgumentException();
        } else {
            E[] buffer = (E[]) new Object[this.elements.length];
            int counter = 0;
            int oldSize = this.size();
            for (int i = 0; i < this.elements.length; ++i) {
                if (this.elements[i] == null) {
                    assert true;
                } else {
                    if (((Object) this.elements[i]).equals((Object) e)) {
                        this.elements[i] = null;
                        this.size--;
                    } else {
                        assert true;
                    }
                }

            }
            for (int i = 0; i < this.elements.length; ++i) {
                if (this.elements[i] != null) {
                    buffer[counter] = this.elements[i];
                    counter++;
                } else {
                    assert true;
                }
            }
            this.elements = buffer;
            return oldSize - this.size();
        }
    }

    @Override
    /**
     * Counts the number of times element e occurs in the list
     *
     * @param e the element to be counted in the list
     * @return int representation of the count
     */
    public int contains(E e) throws IllegalArgumentException {
        if (e == null) {
            throw new IllegalArgumentException();
        } else {
            int counter = 0;
            for (int i = 0; i < this.elements.length; i++) {
                if (this.elements[i] == null) {
                    assert true;
                } else {
                    if (((Object) this.elements[i]).equals((Object) e)) {
                        counter++;
                    } else {
                        assert true;
                    }
                }
            }
            return counter;
        }
    }

    @Override
    /**
     * Returns if the list is empty or not
     * @return boolean (true or false) if list is empty or not
     *
     */
    public boolean isEmpty() {
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i] == null) {
                assert true;
            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    /**
     * Clears all elements in the list
     *
     */
    public void clear() {
        for (int i = 0; i < this.elements.length; i++) {
            this.elements[i] = null;
        }
        this.size = 0;
    }

    @Override
    /**
     * Counts the number of elements in the list
     * @return int representing the number of elements in the list
     */
    public int size() {
        // TODO Auto-generated method stub
        return this.size;
    }

    @SuppressWarnings("unchecked")
    @Override
    /**
     * Returns the E[] parameter containing as many non-null elements in the
     * list as it can fit
     * @param e the array to store all of the non null elements in
     * @return E[] an array that contains the non null elements
     *
     */
    public E[] toArray(E[] e) {
        int counter = 0;
        E[] buffer = (E[]) new Object[e.length];
        for (int i = 0; i < this.size(); i++) {
            if (counter == e.length) {
                return e;
            } else {
                e[i] = this.elements[i];
                counter++;
            }
        }

        return e;

    }
}
