import java.util.List;

public class VerificadorPrimo implements Runnable {
    private final int numero;
    private final List<Boolean> resultados;
    private final int index;

    public VerificadorPrimo(int numero, List<Boolean> resultados, int index) {
        this.numero = numero;
        this.resultados = resultados;
        this.index = index;
    }

    @Override
    public void run() {
        boolean ehPrimo = verificarPrimo(numero);
        synchronized (resultados) {
            resultados.set(index, ehPrimo);
        }
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
