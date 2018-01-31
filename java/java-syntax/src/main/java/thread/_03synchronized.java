package thread;

/**
 * Created by dell on 2017/8/13.
 */
public class _03synchronized {
    /**
     * 这里就使用sychronized同步机制获取互斥锁的情况，进行几点说明：
     * 1. 如果同一个方法内同时有两个或更多线程，则每个线程有自己的局部变量拷贝。（JVM主存到线程工作内存的拷贝）
     * 2. 类的每个实例都有自己的对象级别锁。当一个线程访问实例对象中的 synchronized 同步代码块或同步方法时，该线程便获取了该实例的对象级别锁，其他线程这时如果要访问 synchronized 同步代码块或同步方法，便需要阻塞等待，直到前面的线程从同步代码块或方法中退出，释放掉了该对象级别锁。
     * 3. 访问同一个类的不同实例对象中的同步代码块，不存在阻塞等待获取对象锁的问题，因为它们获取的是各自实例的对象级别锁，相互之间没有影响。
     * 4. 持有一个对象级别锁不会阻止该线程被交换出来，也不会阻塞其他线程访问同一实例对象中的非 synchronized 代码。当一个线程 A 持有一个对象级别锁（即进入了 synchronized 修饰的代码块或方法中）时，线程也有可能被交换出去，此时线程 B 有可能获取执行该对象中代码的时间，但它只能执行非同步代码（没有用 synchronized 修饰），当执行到同步代码时，便会被阻塞，此时可能线程规划器又让 A 线程运行，A 线程继续持有对象级别锁，当 A 线程退出同步代码时（即释放了对象级别锁），如果 B 线程此时再运行，便会获得该对象级别锁，从而执行 synchronized 中的代码。
     * 5. 持有对象级别锁的线程会让其他线程阻塞在所有的 synchronized 代码外。例如，在一个类中有三个synchronized 方法 a，b，c，当线程 A 正在执行一个实例对象 M 中的方法 a 时，它便获得了该对象级别锁，那么其他的线程在执行同一实例对象（即对象 M）中的代码时，便会在所有的 synchronized 方法处阻塞，即在方法 a，b，c 处都要被阻塞，等线程 A 释放掉对象级别锁时，其他的线程才可以去执行方法 a，b 或者 c 中的代码，从而获得该对象级别锁。
     * 6. 使用 synchronized（obj）同步语句块，可以获取指定对象上的对象级别锁。obj 为对象的引用，如果获取了 obj 对象上的对象级别锁，在并发访问 obj 对象时时，便会在其 synchronized 代码处阻塞等待，直到获取到该 obj对象的对象级别锁。当 obj 为 this 时，便是获取当前对象的对象级别锁。
     * 7. 类级别锁被特定类的所有示例共享，它用于控制对 static 成员变量以及 static 方法的并发访问。具体用法与对象级别锁相似。
     * 8. 互斥是实现同步的一种手段，临界区、互斥量和信号量都是主要的互斥实现方式。synchronized 关键字经过编译后，会在同步块的前后分别形成 monitorenter 和 monitorexit 这两个字节码指令。根据虚拟机规范的要求，在执行 monitorenter 指令时，首先要尝试获取对象的锁，如果获得了锁，把锁的计数器加 1，相应地，在执行 monitorexit 指令时会将锁计数器减 1，当计数器为 0 时，锁便被释放了。由于 synchronized 同步块对同一个线程是可重入的，因此一个线程可以多次获得同一个对象的互斥锁，同样，要释放相应次数的该互斥锁，才能最终释放掉该锁。
     */
    static int a = 1000;  // 如果对类变量进行多线程访问，需要使用类级别锁
    int b = 100;  // 每个实例对象都会有自己的实例锁和成员变量b，如果想多线程访问自己的b，可以使用对象级别锁（对象锁）



    // static声明一个使用类级别锁的安全方法。只能一个线程访问
    static synchronized  void clSyn() {
        //多线程访问该synchronized同步块时，类级别锁被占，其他线程只能访问非同步块，如果是访问任何类级别同步块，都会被阻塞，等待类级别锁的释放
        System.out.println("clSyn() a: " + a++);
    }


    static void print() {
        //这是一个简单的类方法，不属于synchronized同步块，不会进行线程加锁操作
        System.out.println("print() a: " + a++);
    }

    public void get() {
        //这是一个简单的对象方法，非同步代码块，不会对类级别锁、对象级别锁进行加锁，多线程存在安全问题
        System.out.println("get() b: " + b++);
    }

    public synchronized void getSyn() {
        // 这是一个对象的同步方法，属于同步块，自动使对象锁加锁数+1，其他线程只能访问该对象的非同步块（不要求对象级锁引用数为0的方法都行）
        System.out.println("getSyn b: " + b++);
    }

    public void put() {
        System.out.println("put() b: " +b++);  // 多线程不安全
        synchronized (this) {  // 获取自身实例对象的对象级别锁，多线程只能访问不使用该对象的对象级别锁的代码，否则只能阻塞等待该对象的对象级别锁被释放
            System.out.println("put() syn(this) b: "+b++);
        }
        Object obj = new Object();
        synchronized (obj){
            System.out.println();  // 当然，可以指定syn锁定的对象，可以锁定任何实例对象、类中的变量对象等等，按需求而定，但是注意对象是不是同一个的问题。
        }
    }

    public static void main(String[] args) {
        System.out.println("synchronized 同步代码块包括 synchronized 的方法和 synchronized 代码块");
        System.out.println("写多个线程，访问类的static synchronized 方法，属于=============================");
        Thread t1 = new Thread(()->{
            _03synchronized.clSyn();});
        Thread t2 = new Thread(()->{
            _03synchronized.clSyn();});
        Thread t3 = new Thread(()->{
            _03synchronized.clSyn();});
        t1.start();t2.start();t3.start();
    }


}
