/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/05/13/09:31
 */
public class ThreadTest implements Runnable{
    int a= 0;
    int b= 0;
    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            synchronized (this){
                a++;
                b++;
            }
        }
    }

    public void com(){
        for (int i = 0; i < 5000; i++) {
            int as = 0;
            int bs = 0;
            synchronized (this){
                 as = a;
                 bs = b;
            }
            if(as < bs){
                System.out.println(Thread.currentThread().getName() + a+" ， "+b);
            }
        }
    }
}
