/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/05/13/09:30
 */
public class test {
    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        new Thread(threadTest).start();
        threadTest.com();
    }
}
