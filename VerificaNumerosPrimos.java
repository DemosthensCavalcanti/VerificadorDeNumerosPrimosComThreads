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
            Thread thread = new Thread(new VerificadorPrimo(num,resultados));
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

    static class VerificadorPrimo implements Runnable {
        private final int numero;
        private final List<Boolean> resultados;

        public VerificadorPrimo(int numero, List<Boolean> resultados) {
            this.numero = numero;
            this.resultados = resultados;
        }

        @Override
        public void run() {
            boolean ehPrimo = verificarPrimo(numero);
            resultados.set(resultados.size() - 1, ehPrimo);
        }

        private boolean verificarPrimo(int num) {
                if (num <= 1) {
                    return false;
                }
                if (num <= 3) {
                    return true;
                }
                if (num % 2 == 0 || num % 3 == 0) {
                    return false;
                }
    
                for (int i = 5; i * i <= num; i += 6) {
                    if (num % i == 0 || num % (i + 2) == 0) {
                        return false;
                    }
                }
    
                return true;
            
        }
    }
}
