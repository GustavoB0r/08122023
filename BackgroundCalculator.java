// Figura 23.24: BackgroundCalculator.java
//subclasse SwingWork para calcular os numeros de Fibonacci em uma thread em segundo plano.

import javax.swing.SwingWorker;
import javax.swing.JLabel;
import java.util.concurrent.ExecutionException;

public class BackgroundCalculator extends SwingWorker<Long, Object> {
    
    private final int n; // Numero de Fibonacci a calcular
    private final JLabel resultJLabel; // JLabel para exibir o resultado

    // construtor

    public BackgroundCalculator(int n, JLabel resultJLabel) {

        this.n = n;
        this.resultJLabel = resultJLabel;
    }

    // codigo de longa duracao para ser executado em um thread trabalhadora
    public Long doInBackground() {
        long nthFib;
        return nthFib = fibonacci(n);
    }

    // codigo a ser executado na thread de despacho de eventos quando doInBackground retorna
    protected void done() {
        try {
            //obtem o resultado de doInBackground e o exibe
            resultJLabel.setText(get().toString());
        }
        catch (InterruptedException ex) {
            resultJLabel.setText("Interrupted while waiting for results.");
        }
        catch (ExecutionException ex) {
            resultJLabel.setText("Error encountered while performing calculation.");
        }
    }

    // metodo fibonacci recursivo; calcula o enesimo numero de Fibonnaci
    public long fibonacci(long number){
        if (number == 0 || number == 1)
        return number;
        else
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
//fim da classe BackgroundCalculator
