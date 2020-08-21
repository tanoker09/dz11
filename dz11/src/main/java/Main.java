import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

//Перевести одну из предыдущих работ
//на использование стримов и лямбда-выражений там, где это уместно (возможно, жертвуя производительностью)

public class Main {
    public static BigInteger factorial(Integer number) {
        BigInteger result = BigInteger.ONE;
        if (number == 0 || number == 1) {
            System.out.println("Факториал числа " + number + "-" + result);
            return result;
        }
        for (int i = 2; i <= number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        System.out.println("Факториал числа " + number + "-" + result);
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> numbs = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            numbs.add(random.nextInt(100));
        }
        numbs.stream().forEach(System.out::println);
        List<BigInteger> result = numbs.stream().map(Main::factorial).collect(Collectors.toList());
        result.stream().forEach(System.out::println);
    }
}
