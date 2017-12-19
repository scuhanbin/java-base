package com.hanbin.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 小米、小明、小华、小猪、小丽约好一起出去玩，在天安门广场集合，因此他们需要所有人到了才能出发
 * 
 * @author scu_h
 *
 */
public class CountDownLatchTest {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(5);

		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 100, 0, TimeUnit.SECONDS,
				new ArrayBlockingQueue<>(5));

		threadPool.execute(new MyThread("小丽", latch));
		threadPool.execute(new MyThread("小米", latch));
		threadPool.execute(new MyThread("小华", latch));
		threadPool.execute(new MyThread("小明", latch));
		threadPool.execute(new MyThread("小猪", latch));

		latch.await();

		System.out.println("都到了，咋们出发吧");

		threadPool.shutdown();
	}
}

class MyThread implements Runnable {
	public static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private CountDownLatch latch;
	private String name;

	public MyThread(String name, CountDownLatch latch) {
		this.name = name;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep((long) (Math.random() * 10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(name + "到了天安门广场，时间是：" + timeFormat.format(new Date()));

		latch.countDown();
	}
}