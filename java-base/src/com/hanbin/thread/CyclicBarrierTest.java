package com.hanbin.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 小米、小明、小华、小猪、小丽约好一起出去玩，在天安门广场集合，因此他们需要所有人到了才能出发
 */
public class CyclicBarrierTest {
	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("都到齐了，出发啦"));

		new Thread(new MyThread2("小丽", cyclicBarrier)).start();
		new Thread(new MyThread2("小米", cyclicBarrier)).start();
		new Thread(new MyThread2("小华", cyclicBarrier)).start();
		new Thread(new MyThread2("小明", cyclicBarrier)).start();
		new Thread(new MyThread2("小猪", cyclicBarrier)).start();
	}
}

class MyThread2 implements Runnable {
	public static SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private CyclicBarrier cyclicBarrier;
	private String name;

	public MyThread2(String name, CyclicBarrier cyclicBarrier) {
		this.name = name;
		this.cyclicBarrier = cyclicBarrier;
	}

	@Override
	public void run() {
		try {
			Thread.sleep((long) (Math.random() * 10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(name + "到了天安门广场，时间是：" + timeFormat.format(new Date()));

		try {
			cyclicBarrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}