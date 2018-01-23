package java_thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock和synchronized的区别
 * 1. Lock是一个接口，而synchronized是Java中的关键字，
 * synchronized是内置的语言实现，Lock是代码层面的实现。
 * 2. Lock可以选择性的获取锁，如果一段时间获取不到，可以放弃。
 * synchronized会一直获取下去。
 * 借助Lock的这个特性，就能够规避死锁，synchronized必须通过谨慎和良好的设计，才能减少死锁的发生。
 * 3. synchronized在发生异常和同步块结束的时候，会自动释放锁。
 * 而Lock必须手动释放， 所以如果忘记了释放锁，一样会造成死锁。
 *
 * @author 唐龙
 *
 */
public class ThreadLock {
	//This is a test
	public static void main(String[] args) {
		//锁对象
		Lock lock=new ReentrantLock();

		ThreadLockTest th1 = new ThreadLockTest(lock);
		ThreadLockTest th2 = new ThreadLockTest(lock);
		th1.setName("线程-1");
		th2.setName("线程-2");
		th1.start();
		th2.start();
	}
}

/**加锁进程*/
class ThreadLockTest extends Thread{
	//创建锁
	private Lock lock;

	public ThreadLockTest(Lock lock){
		this.lock=lock;
	}
	@Override
	public void run() {
		try {
			PrintLog.log("线程启动");
			PrintLog.log("试图占有对象：lock");
			lock.lock();
			PrintLog.log("占有对象：lock");
			PrintLog.log("进行5秒的业务操作");
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			PrintLog.log("释放对象：lock");
			lock.unlock();
		}
		PrintLog.log("线程结束");
	}
}