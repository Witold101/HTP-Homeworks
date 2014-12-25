package by.minsk.wasilus;

import java.util.Iterator;

/**
 * Created by Witold on 25.12.2014.
 */
public class ArrayStringIterable implements Iterable<String> {
    private String[] arrayString;

    public ArrayStringIterable(String[] arrayString) {
        this.arrayString = new String[arrayString.length];
        this.arrayString = arrayString;
    }

    @Override
    public Iterator<String> iterator() {
        return new ArrayStringIterator();
    }

    private class ArrayStringIterator implements Iterator<String> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < arrayString.length;
        }

        @Override
        public String next() {
            return arrayString[position++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

