import java.util.*;

/**
 * Builds the MyLinkedList class
 *
 * @param <E> Any specified element
 * @author Timothy Wu
 * @version 10.16.18
 */
public class MyLinkedList<E> {
    private int size;
    private Node<E> head;

    /**
     * Builds the private inner class Node
     *
     * @param <E> Any specified element
     * @author Timothy Wu
     * @version 10.16.18
     */
    @SuppressWarnings("hiding")
    public class Node<E> {
        private Object data;
        private Node<E> next;

        /**
         * Constructs Node with specified data and next
         *
         * @param data The specified data
         * @param next The specified Node to be next
         */
        public Node(Object data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Constructs Node with specified data
         *
         * @param data The specified data
         */
        public Node(Object data) {
            this(data, null);
        }
    }

    /**
     * Constructs MyLinkedList with size equal to 0 and head equal to null
     */
    public MyLinkedList() {
        size = 0;
        head = null;
    }

    /**
     * Constructs MyLinkedList with size equal to the collection's size and
     * all the elements in the collection added to MyLinkedList
     *
     * @param c The collection of data to be added
     */
    public MyLinkedList(Collection<E> c) {
        size = 0;
        addAll(c);
    }

    /**
     * Adds a Node with a specified data into MyLinkedList
     *
     * @param o The specified data
     * @return True if the data was added and false if the data is already in
     * the MyLinkedList
     */
    public boolean add(E o) {
        if (contains((Object) o)) {
            return false;
        }
        @SuppressWarnings({"unchecked", "rawtypes"})
        Node<E> n = new Node((Object) o);
        if (size == 0) {
            head = n;
            size++;
            return true;
        }
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = n;
        size++;
        return true;
    }

    /**
     * Adds a Node with specified data at a specified index
     *
     * @param index The specified index
     * @param o     The specified object
     * @throw IndexOutOfBoundsException if an invalid index is given
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void add(int index, Object o) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = head;
        if (index == 0) {
            head = new Node(o, temp);
            size++;
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = new Node(o, temp.next);
        size++;
    }

    /**
     * Removes the Node with the specified data
     *
     * @param o The specified object
     * @return True if the Node is removed
     */
    public boolean remove(Object o) {
        if (!contains(o)) {
            return false;
        }
        remove(indexOf(o));
        return true;
    }

    /**
     * Removes the Node at the specified index
     *
     * @param index The specified index
     * @return The element of the Node that was in the index originally
     * @throws IndexOutOfBoundsException if an invalid index
     */
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Node<E> temp = head;
            head = head.next;
            size--;
            return (E) temp.data;
        } else if (index == size - 1) {
            Node<E> old = getNode(index);
            Node<E> secondtoLast = getNode(index - 1);
            secondtoLast.next = null;
            size--;
            return (E) old.data;
        }
        Node<E> at = getNode(index);
        Node<E> before = getNode(index - 1);
        before.next = before.next.next;
        size--;
        return (E) at.data;
    }

    /**
     * Helper method which gets the Node at a specified index
     *
     * @param index The specified index
     * @return The node at the index
     * @throws IndexOutOfBoundsException if an invalid index is given
     */
    private Node<E> getNode(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * Gets the data type of the Node at a specified index
     *
     * @param index The specified index
     * @return The data type of the Node
     * @throws IndexOutOfBoundsException if an invalid index is given
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        Node<E> temp = head;
        while (temp != null) {
            if (i == index) {
                return (E) temp.data;
            }
            i++;
            temp = temp.next;
        }
        return null;
    }

    /**
     * Sets the value of the Node at the specified index to a specified object
     *
     * @param index The specified index
     * @param o     The specified object
     * @return The element of the old Node
     * @throws IndexOutOfBoundsException if an invalid index is given
     */
    @SuppressWarnings("unchecked")
    public E set(int index, E o) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> n = getNode(index);
        E old = (E) n.data;
        n.data = (Object) o;
        return old;
    }

    /**
     * Returns the size of MyLinkedList
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Checks to see if a specified object is in MyLinkedList
     *
     * @param o The specified object
     * @return True if the object is in MyLinkedList and false if it is not
     */
    public boolean contains(Object o) {
        Node<E> temp = head;
        while (temp != null) {
            if (temp.data.equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * Checks to see if MyLinkedList is empty
     *
     * @return True if the size is equal to 0 and false if not
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Clears the Nodes from MyLinkedList and sets size equal to 0
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Makes a formatted string version of the MyLinkedList
     *
     * @return The string version of MyLinkedList
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder str = new StringBuilder();
        str.append("[ ");
        Node<E> temp = head;
        while (temp.next != null) {
            str.append(temp.data + ", ");
            temp = temp.next;
        }
        str.append(temp.data + " ]");
        return str.toString();
    }

    /**
     * Adds all elements from the collection into MyLinkedList
     *
     * @param c The collection
     */
    public void addAll(Collection<E> c) {
        for (E e : c) {
            add(e);
        }
    }

    /**
     * Returns the first occurrence of the Node with specified data
     *
     * @param o The specified object
     * @return The index of the Node
     */
    public int indexOf(Object o) {
        Node<E> temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data.equals(o)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    /**
     * Returns the last occurrence of the Node with the specified data
     *
     * @param o The specified object
     * @return The index of the Node
     */
    public int lastIndexOf(Object o) {
        Node<E> temp = head;
        int last = -1;
        for (int i = 0; i < size; i++) {
            if (temp.data.equals(o)) {
                last = i;
            }
            temp = temp.next;
        }
        return last;
    }

    /**
     * Removes Nodes from the beginning index ( inclusive ) to
     * the end index ( exclusive )
     *
     * @param fromIndex The beginning index
     * @param toIndex   The end index
     */
    public void removeRange(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = toIndex - 1; i >= fromIndex; i--) {
            remove(i);
        }
    }

    /**
     * Turns MyLinkedList into the array version
     *
     * @return The array version of MyLinkedList
     */
    public Object[] toArray() {
        Node<E> temp = head;
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = temp.data;
            temp = temp.next;
        }
        return arr;
    }

    /**
     * Tests to see if a given object is equal to MyLinkedList
     *
     * @param o The object to be compared
     * @return True if the object has the same objects in the same order
     * as MyLinkedList
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MyLinkedList)) {
            return false;
        }
        @SuppressWarnings({"rawtypes", "unchecked"})
        MyLinkedList<E> other = (MyLinkedList) o;
        if (size != other.size()) {
            return false;
        }
        Node<E> temp = head;
        Node<E> otherTemp = other.head;
        for (int i = 0; i < size; i++) {
            if (!temp.data.equals(otherTemp.data)) {
                return false;
            }
            temp = temp.next;
            otherTemp = otherTemp.next;
        }
        return true;
    }
}
