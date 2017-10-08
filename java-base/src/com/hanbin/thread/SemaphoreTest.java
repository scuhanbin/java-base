package com.hanbin.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore(3);

		new Thread(new MyThread1("小丽", semaphore)).start();
		new Thread(new MyThread1("小米", semaphore)).start();
		new Thread(new MyThread1("小华", semaphore)).start();
		new Thread(new MyThread1("小明", semaphore)).start();
		new Thread(new MyThread1("小猪", semaphore)).start();
	}
}

class MyThread1 implements Runnable {
	public static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private Semaphore semaphore;
	private String name;

	public MyThread1(String name, Semaphore semaphore) {
		this.name = name;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire();
			Thread.sleep((long) (Math.random() * 10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(name + "到了天安门广场，时间是：" + timeFormat.format(new Date()));
		semaphore.release();
	}
}