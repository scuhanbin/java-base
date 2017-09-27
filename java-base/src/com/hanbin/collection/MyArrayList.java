package com.hanbin.collection;

import java.util.Arrays;

/**
 * 手写ArrayList
 */
public class MyArrayList {
	private Object[] values;

	private int size;

	public MyArrayList() {
		this(10);
	}

	public MyArrayList(int size) {
		if (size < 0) {
			throw new IllegalArgumentException();
		}

		values = new Object[size];
	}

	public void add(Object obj) {
		values[size++] = obj;

		if (size >= values.length) {
			Object[] newValues = new Object[size * 2];
			System.arraycopy(values, 0, newValues, 0, size);

			values = newValues;
		}
	}

	public Object get(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException();
		}

		return values[index];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(Object obj) {
		return indexOf(obj) > 0;
	}

	public int indexOf(Object obj) {
		if (obj == null) {
			for (int i = 0; i < size; i++) {
				if (values[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = 0; i < size; i++) {
				if (obj.equals(values[i])) {
					return i;
				}
			}
		}

		return -1;
	}

	public int lastIndexOf(Object obj) {
		if (obj == null) {
			for (int i = size - 1; i >= 0; i--) {
				if (values[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = size - 1; i >= 0; i--) {
				if (obj.equals(values[i])) {
					return i;
				}
			}
		}

		return -1;
	}

	public Object[] toArray() {
		return Arrays.copyOf(values, size);
	}
}
