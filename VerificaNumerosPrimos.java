import java.util.ArrayList;
import java.util.List;

public class VerificaNumerosPrimos {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        List<Integer> numeros = new ArrayList<>();
        List<Boolean> resultados = new ArrayList<>();

        for (String arg : args) {
            int num = Integer.parseInt(arg);
            numeros.add(num);
            resultados.add(null);
            int index = resultados.size() - 1;
            Thread thread = new Thread(new VerificadorPrimo(num, resultados, index));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < numeros.size(); i++) {
            int num = numeros.get(i);
            boolean ehPrimo = resultados.get(i);
            System.out.println(num + (ehPrimo ? " é primo" : " não é primo"));
        }
    }
}
