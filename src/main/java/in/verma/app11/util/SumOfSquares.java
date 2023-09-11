package in.verma.app11.util;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;


public class SumOfSquares {
    public static void main(String[] args) {
        int N = 100;
        int numThreads = 4;
        AtomicInteger sum = new AtomicInteger(0);

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        for (int i = 1; i <= N; i++) {
            final int num = i;
            executorService.execute(() -> {
                sum.addAndGet(num * num);
            });
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
           
        }

        System.out.println("Сумма квадратов первых " + N + " натуральных чисел: " + sum);
    }
}
