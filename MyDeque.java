package Lesson7.deque;

import java.util.*;
import java.util.Deque;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;


    public class MyDeque implements Deque {

        static class Node{
            Object data;
            Node prev, next;

            static Node getNode(Object data){
                Node newNode = new Node();
                newNode.data = data;
                newNode.prev = newNode.next =null;
                return newNode;
            }

            public Object getData() {
                return data;
            }

        };

        private LinkedList<Object> list = new java.util.LinkedList<>();


       Node front;
       Node rear;
       int size;




        public MyDeque() {
            front = rear = null;
            size = 0;
        }

        ;
        /**
         * Inserts the specified element at the front of this deque if it is
         * possible to do so immediately without violating capacity restrictions,
         * throwing an {@code IllegalStateException} if no space is currently
         * available.  When using a capacity-restricted deque, it is generally
         * preferable to use method {@link #offerFirst}.
         *
         * @param o the element to add
         * @throws IllegalStateException    if the element cannot be added at this
         *                                  time due to capacity restrictions
         * @throws ClassCastException       if the class of the specified element
         *                                  prevents it from being added to this deque
         * @throws NullPointerException     if the specified element is null and this
         *                                  deque does not permit null elements
         * @throws IllegalArgumentException if some property of the specified
         *                                  element prevents it from being added to this deque
         */
        @Override
        public void addFirst (Object o) {
            Node newNode = Node.getNode(o);
            if (newNode == null ){
                System.out.println("Overflow\n");
            }else {
                if (front == null){
                    rear = front = newNode;
                }else {
                    newNode.next = front;
                    front.prev = newNode;
                    front = newNode;
                }
                size++;
            }
            list.add(0, newNode.getData());
        }

        @Override
        public String toString() {
            return "MyDeque { " +
                    "list = " + list +
                    ", front =" + front.getData() +
                    ", rear =" + rear.getData() +
                    ", size =" + size +
                    " }";
        }

        /**
         * Inserts the specified element at the end of this deque if it is
         * possible to do so immediately without violating capacity restrictions,
         * throwing an {@code IllegalStateException} if no space is currently
         * available.  When using a capacity-restricted deque, it is generally
         * preferable to use method {@link #offerLast}.
         *
         * <p>This method is equivalent to {@link #add}.
         *
         * @param o the element to add
         * @throws IllegalStateException    if the element cannot be added at this
         *                                  time due to capacity restrictions
         * @throws ClassCastException       if the class of the specified element
         *                                  prevents it from being added to this deque
         * @throws NullPointerException     if the specified element is null and this
         *                                  deque does not permit null elements
         * @throws IllegalArgumentException if some property of the specified
         *                                  element prevents it from being added to this deque
         */
        @Override
        public void addLast(Object o) {
            Node newNode = Node.getNode(o);
            if (newNode == null) {
                System.out.println("Overflow\n");
            } else if (rear == null)
                front = rear = newNode;
            else
                newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        size++;
            list.addLast( newNode.getData());

        }

        /**
         * Inserts the specified element at the front of this deque unless it would
         * violate capacity restrictions.  When using a capacity-restricted deque,
         * this method is generally preferable to the {@link #addFirst} method,
         * which can fail to insert an element only by throwing an exception.
         *
         * @param o the element to add
         * @return {@code true} if the element was added to this deque, else
         * {@code false}
         * @throws ClassCastException       if the class of the specified element
         *                                  prevents it from being added to this deque
         * @throws NullPointerException     if the specified element is null and this
         *                                  deque does not permit null elements
         * @throws IllegalArgumentException if some property of the specified
         *                                  element prevents it from being added to this deque
         */
        @Override
        public boolean offerFirst(Object o) {
            if (list.getFirst() != null)
                return true;
            else
            return false;
        }

        /**
         * Inserts the specified element at the end of this deque unless it would
         * violate capacity restrictions.  When using a capacity-restricted deque,
         * this method is generally preferable to the {@link #addLast} method,
         * which can fail to insert an element only by throwing an exception.
         *
         * @param o the element to add
         * @return {@code true} if the element was added to this deque, else
         * {@code false}
         * @throws ClassCastException       if the class of the specified element
         *                                  prevents it from being added to this deque
         * @throws NullPointerException     if the specified element is null and this
         *                                  deque does not permit null elements
         * @throws IllegalArgumentException if some property of the specified
         *                                  element prevents it from being added to this deque
         */
        @Override
        public boolean offerLast(Object o) {
            if (list.getLast() != null)
                return true;
            else return false;
        }

        /**
         * Retrieves and removes the first element of this deque.  This method
         * differs from {@link #pollFirst pollFirst} only in that it throws an
         * exception if this deque is empty.
         *
         * @return the head of this deque
         * @throws NoSuchElementException if this deque is empty
         */
        @Override
        public Object removeFirst() {
       if (isEmpty()){
                System.out.println("Underflow\n");
            }
            else {
                Node temp = front;
                front = front.next;

                if (front == null){
                    rear=null;
                }
                else {
                    front.prev = null;
                    size--;
                }
                list.remove(0);
                return front;
            }
           return front;
        }

        /**
         * Retrieves and removes the last element of this deque.  This method
         * differs from {@link #pollLast pollLast} only in that it throws an
         * exception if this deque is empty.
         *
         * @return the tail of this deque
         * @throws NoSuchElementException if this deque is empty
         */
        @Override
        public Object removeLast() {
            if (isEmpty()){
                System.out.println("Underflow\n");
            }
            else {
                Node temp = rear;
                rear = rear.prev;

                if (rear == null){
                    front=null;
                }
                else {
                    rear.next = null;
                    size--;
                }
                list.removeLast();
                return rear;
            }
            return rear;
        }

        /**
         * Retrieves and removes the first element of this deque,
         * or returns {@code null} if this deque is empty.
         *
         * @return the head of this deque, or {@code null} if this deque is empty
         */
        @Override
        public Object pollFirst() {
            return null;
        }

        /**
         * Retrieves and removes the last element of this deque,
         * or returns {@code null} if this deque is empty.
         *
         * @return the tail of this deque, or {@code null} if this deque is empty
         */
        @Override
        public Object pollLast() {
            return null;
        }

        /**
         * Retrieves, but does not remove, the first element of this deque.
         * <p>
         * This method differs from {@link #peekFirst peekFirst} only in that it
         * throws an exception if this deque is empty.
         *
         * @return the head of this deque
         * @throws NoSuchElementException if this deque is empty
         */
        @Override
        public Object getFirst() {
            if (isEmpty())
                return -1;
            return front.getData();
        }

        /**
         * Retrieves, but does not remove, the last element of this deque.
         * This method differs from {@link #peekLast peekLast} only in that it
         * throws an exception if this deque is empty.
         *
         * @return the tail of this deque
         * @throws NoSuchElementException if this deque is empty
         */
        @Override
        public Object getLast() {
            if (isEmpty())
                return -1;
            return rear.getData();
        }

        /**
         * Retrieves, but does not remove, the first element of this deque,
         * or returns {@code null} if this deque is empty.
         *
         * @return the head of this deque, or {@code null} if this deque is empty
         */
        @Override
        public Object peekFirst() {
            return getFirst();
        }

        /**
         * Retrieves, but does not remove, the last element of this deque,
         * or returns {@code null} if this deque is empty.
         *
         * @return the tail of this deque, or {@code null} if this deque is empty
         */
        @Override
        public Object peekLast() {
            return getLast();
        }

        /**
         * Removes the first occurrence of the specified element from this deque.
         * If the deque does not contain the element, it is unchanged.
         * More formally, removes the first element {@code e} such that
         * {@code Objects.equals(o, e)} (if such an element exists).
         * Returns {@code true} if this deque contained the specified element
         * (or equivalently, if this deque changed as a result of the call).
         *
         * @param o element to be removed from this deque, if present
         * @return {@code true} if an element was removed as a result of this call
         * @throws ClassCastException   if the class of the specified element
         *                              is incompatible with this deque
         *                              (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
         * @throws NullPointerException if the specified element is null and this
         *                              deque does not permit null elements
         *                              (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
         */
        @Override
        public boolean removeFirstOccurrence(Object o) {
            return false;
        }

        /**
         * Removes the last occurrence of the specified element from this deque.
         * If the deque does not contain the element, it is unchanged.
         * More formally, removes the last element {@code e} such that
         * {@code Objects.equals(o, e)} (if such an element exists).
         * Returns {@code true} if this deque contained the specified element
         * (or equivalently, if this deque changed as a result of the call).
         *
         * @param o element to be removed from this deque, if present
         * @return {@code true} if an element was removed as a result of this call
         * @throws ClassCastException   if the class of the specified element
         *                              is incompatible with this deque
         *                              (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
         * @throws NullPointerException if the specified element is null and this
         *                              deque does not permit null elements
         *                              (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
         */
        @Override
        public boolean removeLastOccurrence(Object o) {
            return false;
        }

        /**
         * Inserts the specified element into the queue represented by this deque
         * (in other words, at the tail of this deque) if it is possible to do so
         * immediately without violating capacity restrictions, returning
         * {@code true} upon success and throwing an
         * {@code IllegalStateException} if no space is currently available.
         * When using a capacity-restricted deque, it is generally preferable to
         * use {@link #offer(Object) offer}.
         *
         * <p>This method is equivalent to {@link #addLast}.
         *
         * @param o the element to add
         * @return {@code true} (as specified by {@link Collection#add})
         * @throws IllegalStateException    if the element cannot be added at this
         *                                  time due to capacity restrictions
         * @throws ClassCastException       if the class of the specified element
         *                                  prevents it from being added to this deque
         * @throws NullPointerException     if the specified element is null and this
         *                                  deque does not permit null elements
         * @throws IllegalArgumentException if some property of the specified
         *                                  element prevents it from being added to this deque
         */
        @Override
        public boolean add(Object o) {
            Node newNode = Node.getNode(o);
            if (newNode == null ){
                System.out.println("Overflow\n");
                return false;
            }else {
                if (front == null){
                    rear = front = newNode;
                }else {
                    newNode.next = front;
                    front.prev = newNode;
                    front = newNode;
                }
                size++;
            }
            list.add( newNode.getData());
            return true;
        }

        /**
         * Inserts the specified element into the queue represented by this deque
         * (in other words, at the tail of this deque) if it is possible to do so
         * immediately without violating capacity restrictions, returning
         * {@code true} upon success and {@code false} if no space is currently
         * available.  When using a capacity-restricted deque, this method is
         * generally preferable to the {@link #add} method, which can fail to
         * insert an element only by throwing an exception.
         *
         * <p>This method is equivalent to {@link #offerLast}.
         *
         * @param o the element to add
         * @return {@code true} if the element was added to this deque, else
         * {@code false}
         * @throws ClassCastException       if the class of the specified element
         *                                  prevents it from being added to this deque
         * @throws NullPointerException     if the specified element is null and this
         *                                  deque does not permit null elements
         * @throws IllegalArgumentException if some property of the specified
         *                                  element prevents it from being added to this deque
         */
        @Override
        public boolean offer(Object o) {
            return false;
        }

        /**
         * Retrieves and removes the head of the queue represented by this deque
         * (in other words, the first element of this deque).
         * This method differs from {@link #poll() poll()} only in that it
         * throws an exception if this deque is empty.
         *
         * <p>This method is equivalent to {@link #removeFirst()}.
         *
         * @return the head of the queue represented by this deque
         * @throws NoSuchElementException if this deque is empty
         */
        @Override
        public Object remove() {
            return null;
        }

        /**
         * Retrieves and removes the head of the queue represented by this deque
         * (in other words, the first element of this deque), or returns
         * {@code null} if this deque is empty.
         *
         * <p>This method is equivalent to {@link #pollFirst()}.
         *
         * @return the first element of this deque, or {@code null} if
         * this deque is empty
         */
        @Override
        public Object poll() {
            return null;
        }

        /**
         * Retrieves, but does not remove, the head of the queue represented by
         * this deque (in other words, the first element of this deque).
         * This method differs from {@link #peek peek} only in that it throws an
         * exception if this deque is empty.
         *
         * <p>This method is equivalent to {@link #getFirst()}.
         *
         * @return the head of the queue represented by this deque
         * @throws NoSuchElementException if this deque is empty
         */
        @Override
        public Object element() {
            return null;
        }

        /**
         * Retrieves, but does not remove, the head of the queue represented by
         * this deque (in other words, the first element of this deque), or
         * returns {@code null} if this deque is empty.
         *
         * <p>This method is equivalent to {@link #peekFirst()}.
         *
         * @return the head of the queue represented by this deque, or
         * {@code null} if this deque is empty
         */
        @Override
        public Object peek() {
            return null;
        }

        /**
         * Adds all of the elements in the specified collection at the end
         * of this deque, as if by calling {@link #addLast} on each one,
         * in the order that they are returned by the collection's iterator.
         *
         * <p>When using a capacity-restricted deque, it is generally preferable
         * to call {@link #offer(Object) offer} separately on each element.
         *
         * <p>An exception encountered while trying to add an element may result
         * in only some of the elements having been successfully added when
         * the associated exception is thrown.
         *
         * @param c the elements to be inserted into this deque
         * @return {@code true} if this deque changed as a result of the call
         * @throws IllegalStateException    if not all the elements can be added at
         *                                  this time due to insertion restrictions
         * @throws ClassCastException       if the class of an element of the specified
         *                                  collection prevents it from being added to this deque
         * @throws NullPointerException     if the specified collection contains a
         *                                  null element and this deque does not permit null elements,
         *                                  or if the specified collection is null
         * @throws IllegalArgumentException if some property of an element of the
         *                                  specified collection prevents it from being added to this deque
         */
        @Override
        public boolean addAll(Collection c) {
            return false;
        }

        /**
         * Removes all of the elements of this collection that satisfy the given
         * predicate.  Errors or runtime exceptions thrown during iteration or by
         * the predicate are relayed to the caller.
         *
         * @param filter a predicate which returns {@code true} for elements to be
         *               removed
         * @return {@code true} if any elements were removed
         * @throws NullPointerException          if the specified filter is null
         * @throws UnsupportedOperationException if elements cannot be removed
         *                                       from this collection.  Implementations may throw this exception if a
         *                                       matching element cannot be removed or if, in general, removal is not
         *                                       supported.
         * @implSpec The default implementation traverses all elements of the collection using
         * its {@link #iterator}.  Each matching element is removed using
         * {@link Iterator#remove()}.  If the collection's iterator does not
         * support removal then an {@code UnsupportedOperationException} will be
         * thrown on the first matching element.
         * @since 1.8
         */
        @Override
        public boolean removeIf(Predicate filter) {
            return Deque.super.removeIf(filter);
        }

        /**
         * Removes all of the elements from this collection (optional operation).
         * The collection will be empty after this method returns.
         *
         * @throws UnsupportedOperationException if the {@code clear} operation
         *                                       is not supported by this collection
         */
        @Override
        public void clear() {

        }

        /**
         * Creates a {@link Spliterator} over the elements in this collection.
         * <p>
         * Implementations should document characteristic values reported by the
         * spliterator.  Such characteristic values are not required to be reported
         * if the spliterator reports {@link Spliterator#SIZED} and this collection
         * contains no elements.
         *
         * <p>The default implementation should be overridden by subclasses that
         * can return a more efficient spliterator.  In order to
         * preserve expected laziness behavior for the {@link #stream()} and
         * {@link #parallelStream()} methods, spliterators should either have the
         * characteristic of {@code IMMUTABLE} or {@code CONCURRENT}, or be
         * <em><a href="Spliterator.html#binding">late-binding</a></em>.
         * If none of these is practical, the overriding class should describe the
         * spliterator's documented policy of binding and structural interference,
         * and should override the {@link #stream()} and {@link #parallelStream()}
         * methods to create streams using a {@code Supplier} of the spliterator,
         * as in:
         * <pre>{@code
         *     Stream<E> s = StreamSupport.stream(() -> spliterator(), spliteratorCharacteristics)
         * }</pre>
         * <p>These requirements ensure that streams produced by the
         * {@link #stream()} and {@link #parallelStream()} methods will reflect the
         * contents of the collection as of initiation of the terminal stream
         * operation.
         *
         * @return a {@code Spliterator} over the elements in this collection
         * @implSpec The default implementation creates a
         * <em><a href="Spliterator.html#binding">late-binding</a></em> spliterator
         * from the collection's {@code Iterator}.  The spliterator inherits the
         * <em>fail-fast</em> properties of the collection's iterator.
         * <p>
         * The created {@code Spliterator} reports {@link Spliterator#SIZED}.
         * @implNote The created {@code Spliterator} additionally reports
         * {@link Spliterator#SUBSIZED}.
         *
         * <p>If a spliterator covers no elements then the reporting of additional
         * characteristic values, beyond that of {@code SIZED} and {@code SUBSIZED},
         * does not aid clients to control, specialize or simplify computation.
         * However, this does enable shared use of an immutable and empty
         * spliterator instance (see {@link Spliterators#emptySpliterator()}) for
         * empty collections, and enables clients to determine if such a spliterator
         * covers no elements.
         * @since 1.8
         */
        @Override
        public Spliterator spliterator() {
            return Deque.super.spliterator();
        }

        /**
         * Returns a sequential {@code Stream} with this collection as its source.
         *
         * <p>This method should be overridden when the {@link #spliterator()}
         * method cannot return a spliterator that is {@code IMMUTABLE},
         * {@code CONCURRENT}, or <em>late-binding</em>. (See {@link #spliterator()}
         * for details.)
         *
         * @return a sequential {@code Stream} over the elements in this collection
         * @implSpec The default implementation creates a sequential {@code Stream} from the
         * collection's {@code Spliterator}.
         * @since 1.8
         */
        @Override
        public Stream stream() {
            return Deque.super.stream();
        }

        /**
         * Returns a possibly parallel {@code Stream} with this collection as its
         * source.  It is allowable for this method to return a sequential stream.
         *
         * <p>This method should be overridden when the {@link #spliterator()}
         * method cannot return a spliterator that is {@code IMMUTABLE},
         * {@code CONCURRENT}, or <em>late-binding</em>. (See {@link #spliterator()}
         * for details.)
         *
         * @return a possibly parallel {@code Stream} over the elements in this
         * collection
         * @implSpec The default implementation creates a parallel {@code Stream} from the
         * collection's {@code Spliterator}.
         * @since 1.8
         */
        @Override
        public Stream parallelStream() {
            return Deque.super.parallelStream();
        }

        /**
         * Retains only the elements in this collection that are contained in the
         * specified collection (optional operation).  In other words, removes from
         * this collection all of its elements that are not contained in the
         * specified collection.
         *
         * @param c collection containing elements to be retained in this collection
         * @return {@code true} if this collection changed as a result of the call
         * @throws UnsupportedOperationException if the {@code retainAll} operation
         *                                       is not supported by this collection
         * @throws ClassCastException            if the types of one or more elements
         *                                       in this collection are incompatible with the specified
         *                                       collection
         *                                       (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
         * @throws NullPointerException          if this collection contains one or more
         *                                       null elements and the specified collection does not permit null
         *                                       elements
         *                                       (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>),
         *                                       or if the specified collection is null
         * @see #remove(Object)
         * @see #contains(Object)
         */
        @Override
        public boolean retainAll(Collection c) {
            return false;
        }

        /**
         * Removes all of this collection's elements that are also contained in the
         * specified collection (optional operation).  After this call returns,
         * this collection will contain no elements in common with the specified
         * collection.
         *
         * @param c collection containing elements to be removed from this collection
         * @return {@code true} if this collection changed as a result of the
         * call
         * @throws UnsupportedOperationException if the {@code removeAll} method
         *                                       is not supported by this collection
         * @throws ClassCastException            if the types of one or more elements
         *                                       in this collection are incompatible with the specified
         *                                       collection
         *                                       (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
         * @throws NullPointerException          if this collection contains one or more
         *                                       null elements and the specified collection does not support
         *                                       null elements
         *                                       (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>),
         *                                       or if the specified collection is null
         * @see #remove(Object)
         * @see #contains(Object)
         */
        @Override
        public boolean removeAll(Collection c) {
            return false;
        }

        /**
         * Pushes an element onto the stack represented by this deque (in other
         * words, at the head of this deque) if it is possible to do so
         * immediately without violating capacity restrictions, throwing an
         * {@code IllegalStateException} if no space is currently available.
         *
         * <p>This method is equivalent to {@link #addFirst}.
         *
         * @param o the element to push
         * @throws IllegalStateException    if the element cannot be added at this
         *                                  time due to capacity restrictions
         * @throws ClassCastException       if the class of the specified element
         *                                  prevents it from being added to this deque
         * @throws NullPointerException     if the specified element is null and this
         *                                  deque does not permit null elements
         * @throws IllegalArgumentException if some property of the specified
         *                                  element prevents it from being added to this deque
         */
        @Override
        public void push(Object o) {

        }

        /**
         * Pops an element from the stack represented by this deque.  In other
         * words, removes and returns the first element of this deque.
         *
         * <p>This method is equivalent to {@link #removeFirst()}.
         *
         * @return the element at the front of this deque (which is the top
         * of the stack represented by this deque)
         * @throws NoSuchElementException if this deque is empty
         */
        @Override
        public Object pop() {
            return null;
        }

        /**
         * Removes the first occurrence of the specified element from this deque.
         * If the deque does not contain the element, it is unchanged.
         * More formally, removes the first element {@code e} such that
         * {@code Objects.equals(o, e)} (if such an element exists).
         * Returns {@code true} if this deque contained the specified element
         * (or equivalently, if this deque changed as a result of the call).
         *
         * <p>This method is equivalent to {@link #removeFirstOccurrence(Object)}.
         *
         * @param o element to be removed from this deque, if present
         * @return {@code true} if an element was removed as a result of this call
         * @throws ClassCastException   if the class of the specified element
         *                              is incompatible with this deque
         *                              (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
         * @throws NullPointerException if the specified element is null and this
         *                              deque does not permit null elements
         *                              (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
         */
        @Override
        public boolean remove(Object o) {
            return false;
        }

        /**
         * Returns {@code true} if this collection contains all of the elements
         * in the specified collection.
         *
         * @param c collection to be checked for containment in this collection
         * @return {@code true} if this collection contains all of the elements
         * in the specified collection
         * @throws ClassCastException   if the types of one or more elements
         *                              in the specified collection are incompatible with this
         *                              collection
         *                              (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
         * @throws NullPointerException if the specified collection contains one
         *                              or more null elements and this collection does not permit null
         *                              elements
         *                              (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>),
         *                              or if the specified collection is null.
         * @see #contains(Object)
         */
        @Override
        public boolean containsAll(Collection c) {
            return false;
        }

        /**
         * Returns {@code true} if this deque contains the specified element.
         * More formally, returns {@code true} if and only if this deque contains
         * at least one element {@code e} such that {@code Objects.equals(o, e)}.
         *
         * @param o element whose presence in this deque is to be tested
         * @return {@code true} if this deque contains the specified element
         * @throws ClassCastException   if the class of the specified element
         *                              is incompatible with this deque
         *                              (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
         * @throws NullPointerException if the specified element is null and this
         *                              deque does not permit null elements
         *                              (<a href="{@docRoot}/java.base/java/util/Collection.html#optional-restrictions">optional</a>)
         */
        @Override
        public boolean contains(Object o) {
            return false;
        }

        /**
         * Returns the number of elements in this deque.
         *
         * @return the number of elements in this deque
         */
        @Override
        public int size() {
            return 0;
        }

        /**
         * Returns {@code true} if this collection contains no elements.
         *
         * @return {@code true} if this collection contains no elements
         */
        @Override
        public boolean isEmpty() {
            return false;
        }

        /**
         * Returns an iterator over the elements in this deque in proper sequence.
         * The elements will be returned in order from first (head) to last (tail).
         *
         * @return an iterator over the elements in this deque in proper sequence
         */
        @Override
        public Iterator iterator() {
            return null;
        }

        /**
         * Performs the given action for each element of the {@code Iterable}
         * until all elements have been processed or the action throws an
         * exception.  Actions are performed in the order of iteration, if that
         * order is specified.  Exceptions thrown by the action are relayed to the
         * caller.
         * <p>
         * The behavior of this method is unspecified if the action performs
         * side-effects that modify the underlying source of elements, unless an
         * overriding class has specified a concurrent modification policy.
         *
         * @param action The action to be performed for each element
         * @throws NullPointerException if the specified action is null
         * @implSpec <p>The default implementation behaves as if:
         * <pre>{@code
         *     for (T t : this)
         *         action.accept(t);
         * }</pre>
         * @since 1.8
         */
        @Override
        public void forEach(Consumer action) {
            Deque.super.forEach(action);
        }

        /**
         * Returns an array containing all of the elements in this collection.
         * If this collection makes any guarantees as to what order its elements
         * are returned by its iterator, this method must return the elements in
         * the same order. The returned array's {@linkplain Class#getComponentType
         * runtime component type} is {@code Object}.
         *
         * <p>The returned array will be "safe" in that no references to it are
         * maintained by this collection.  (In other words, this method must
         * allocate a new array even if this collection is backed by an array).
         * The caller is thus free to modify the returned array.
         *
         * @return an array, whose {@linkplain Class#getComponentType runtime component
         * type} is {@code Object}, containing all of the elements in this collection
         * @apiNote This method acts as a bridge between array-based and collection-based APIs.
         * It returns an array whose runtime type is {@code Object[]}.
         * Use {@link #toArray(Object[]) toArray(T[])} to reuse an existing
         * array, or use {@link #toArray(IntFunction)} to control the runtime type
         * of the array.
         */
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        /**
         * Returns an array containing all of the elements in this collection,
         * using the provided {@code generator} function to allocate the returned array.
         *
         * <p>If this collection makes any guarantees as to what order its elements
         * are returned by its iterator, this method must return the elements in
         * the same order.
         *
         * @param generator a function which produces a new array of the desired
         *                  type and the provided length
         * @return an array containing all of the elements in this collection
         * @throws ArrayStoreException  if the runtime type of any element in this
         *                              collection is not assignable to the {@linkplain Class#getComponentType
         *                              runtime component type} of the generated array
         * @throws NullPointerException if the generator function is null
         * @apiNote This method acts as a bridge between array-based and collection-based APIs.
         * It allows creation of an array of a particular runtime type. Use
         * {@link #toArray()} to create an array whose runtime type is {@code Object[]},
         * or use {@link #toArray(Object[]) toArray(T[])} to reuse an existing array.
         *
         * <p>Suppose {@code x} is a collection known to contain only strings.
         * The following code can be used to dump the collection into a newly
         * allocated array of {@code String}:
         *
         * <pre>
         *     String[] y = x.toArray(String[]::new);</pre>
         * @implSpec The default implementation calls the generator function with zero
         * and then passes the resulting array to {@link #toArray(Object[]) toArray(T[])}.
         * @since 11
         */
        @Override
        public Object[] toArray(IntFunction generator) {
            return Deque.super.toArray(generator);
        }

        /**
         * Returns an array containing all of the elements in this collection;
         * the runtime type of the returned array is that of the specified array.
         * If the collection fits in the specified array, it is returned therein.
         * Otherwise, a new array is allocated with the runtime type of the
         * specified array and the size of this collection.
         *
         * <p>If this collection fits in the specified array with room to spare
         * (i.e., the array has more elements than this collection), the element
         * in the array immediately following the end of the collection is set to
         * {@code null}.  (This is useful in determining the length of this
         * collection <i>only</i> if the caller knows that this collection does
         * not contain any {@code null} elements.)
         *
         * <p>If this collection makes any guarantees as to what order its elements
         * are returned by its iterator, this method must return the elements in
         * the same order.
         *
         * @param a the array into which the elements of this collection are to be
         *          stored, if it is big enough; otherwise, a new array of the same
         *          runtime type is allocated for this purpose.
         * @return an array containing all of the elements in this collection
         * @throws ArrayStoreException  if the runtime type of any element in this
         *                              collection is not assignable to the {@linkplain Class#getComponentType
         *                              runtime component type} of the specified array
         * @throws NullPointerException if the specified array is null
         * @apiNote This method acts as a bridge between array-based and collection-based APIs.
         * It allows an existing array to be reused under certain circumstances.
         * Use {@link #toArray()} to create an array whose runtime type is {@code Object[]},
         * or use {@link #toArray(IntFunction)} to control the runtime type of
         * the array.
         *
         * <p>Suppose {@code x} is a collection known to contain only strings.
         * The following code can be used to dump the collection into a previously
         * allocated {@code String} array:
         *
         * <pre>
         *     String[] y = new String[SIZE];
         *     ...
         *     y = x.toArray(y);</pre>
         *
         * <p>The return value is reassigned to the variable {@code y}, because a
         * new array will be allocated and returned if the collection {@code x} has
         * too many elements to fit into the existing array {@code y}.
         *
         * <p>Note that {@code toArray(new Object[0])} is identical in function to
         * {@code toArray()}.
         */
        @Override
        public Object[] toArray(Object[] a) {
            return new Object[0];
        }

        /**
         * Returns an iterator over the elements in this deque in reverse
         * sequential order.  The elements will be returned in order from
         * last (tail) to first (head).
         *
         * @return an iterator over the elements in this deque in reverse
         * sequence
         */
        @Override
        public Iterator descendingIterator() {
            return null;
        }

        public void add(int i, String string) {

        }
    }


