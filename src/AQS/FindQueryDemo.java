package src.AQS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class FindQueryDemo {
    private static List<String> company = Arrays.asList("东方航空", "南方航空", "海南航空");
    private static List<String> fighrlist = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        String origin = "BJ";
        String dest = "SH";
// 根据list长度确定线程数量
        Thread[] threads = new Thread[company.size()];
        CountDownLatch latch = new CountDownLatch(company.size());

        for (int i = 0; i < threads.length; i++) {
            String name = company.get(i);
            threads[i] = new Thread(() -> {
                System.out.printf("%s   查询%s到%s的机票\n", name, origin, dest);
                int val = new Random().nextInt(10);

                try {
                    TimeUnit.SECONDS.sleep(val);
                    fighrlist.add(name + "__" + val);
                    System.out.printf("%s 查询成功\n", name);
                    latch.countDown();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });

            threads[i].start();
        }

        latch.await();

        System.out.println("===================查询结果如下========================");
        fighrlist.forEach(System.out::println);
    }

}
