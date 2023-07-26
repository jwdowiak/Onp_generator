package zad5;

import java.util.EmptyStackException;

public class TArrayStack<E> implements InterArrayStack<E> {
    private int end;
    private int maxSize;
    private final int defaultMaxSize = 256;
    private int size;
    private E[] memoryStack;

    public TArrayStack(int maxSize) {
        if (maxSize > 0) {
            this.maxSize = maxSize;
        } else {
            this.maxSize = defaultMaxSize;
        }
        end = 0;
        size = 0;
        memoryStack = (E[]) new Object[maxSize];
    }

    @Override
    public boolean isFull() {
        return maxSize == size;
    }

    @Override
        public String printStack () {
        if (size == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                System.out.println(String.format("[%s]", memoryStack[size - 1 - i].toString()));
                if (i == 0) {
                    sb.append("<--");
                    sb.append("\n");
                }
            }
        return sb.toString();
        }
    }
        @Override
        public E top () {
            if (isEmpty()) {
                throw new EmptyStackException();
            } else {
                return memoryStack[end];
            }
        }
        @Override
        public E pop () {
            if (isFull()) {
                throw new EmptyStackException();
            } else {
                E item = memoryStack[end];
                memoryStack[end] = null;
                if (end != 0)
                    end--;
                    size--;
                    return item;

            }
        }
        @Override
        public void push (E item) {
            if (isFull()) {
                throw new EmptyStackException();
            } else {
                if (size != 0)
                    end++;
                memoryStack[end] = item;
                size++;

            }
        }
        @Override
        public boolean isEmpty () {
            return size==0;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public int deepLevel(E item){
            return 0;
        }

    @Override
    public String toString() {
        return printStack();
    }
}
