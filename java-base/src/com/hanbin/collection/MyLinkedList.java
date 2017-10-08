package com.hanbin.collection;

public class MyLinkedList<T> {
	private Node<T> header = new Node<T>(null, null, null);
	private int size;

	public MyLinkedList() {
		header.next = header.previous = header;
	}

	public void add(T obj) {
		Node<T> node = new Node<T>();
		node.object = obj;

		node.previous = header.previous;
		header.previous.next = node;

		header.previous = node;
		node.next = header;

		size++;
	}

	public void add(int index, T object) {
		Node<T> node = getNode(index);

		addBefore(object, node);
	}

	private void addBefore(T object, Node<T> node) {
		Node<T> newNode = new Node<T>();
		newNode.object = object;

		newNode.previous = node.previous;
		node.previous.next = newNode;

		node.previous = newNode;
		newNode.next = node;

		size++;
	}

	public void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException();
		}
	}

	public int size() {
		return size;
	}

	public Node<T> getNode(int index) {
		rangeCheck(index);

		Node<T> node = header;

		for (int i = 0; i <= index; i++) {
			node = node.next;
		}

		return node;
	}

	public T get(int index) {
		Node<T> node = getNode(index);

		if (node != null) {
			return node.object;
		}

		return null;
	}

	public T getFirst() {
		return header.next.object;
	}

	public T getLast() {
		return header.previous.object;
	}

	public T removeFirst() {
		Node<T> oldFirst = header.next;

		oldFirst.next.previous = oldFirst.previous;
		oldFirst.previous.next = oldFirst.next;

		T oldFirstObj = oldFirst.object;

		// 删除的节点赋值为空，让GC能回收它
		oldFirst = null;

		size--;
		return oldFirstObj;
	}

	public T removeLast() {
		Node<T> oldLast = header.previous;
		T oldLastObject = oldLast.object;

		oldLast.next.previous = oldLast.previous;
		oldLast.previous.next = oldLast.next;

		oldLast = null;
		size--;

		return oldLastObject;
	}
}

/**
 * LinkedList是一个双向链表，因此其节点出存储元素外，还需要存储上一个节点、下一个节点信息
 */
class Node<T> {
	Node<T> previous;
	T object;
	Node<T> next;

	public Node(Node<T> previous, T object, Node<T> next) {
		this.previous = previous;
		this.object = object;
		this.next = next;
	}

	public Node() {
	}
}