package com.hanbin.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author scu_h
 *
 */
public class SemaphoreTest {
	public static void main(String[] args) {

		Semaphore semaphore = new Semaphore(3);

		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 100, 0, TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(5));

		threadPool.execute(new MyThread1("小丽", semaphore));
		threadPool.execute(new MyThread1("小米", semaphore));
		threadPool.execute(new MyThread1("小华", semaphore));
		threadPool.execute(new MyThread1("小明", semaphore));
		threadPool.execute(new MyThread1("小猪", semaphore));

		threadPool.shutdown();
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