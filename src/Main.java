import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int cantidadInicial = 0;
        Kriptonita kriptonita = new Kriptonita(cantidadInicial);
        ArrayList<ExtraenKriptonita> extractores = new ArrayList<>();
        ArrayList<IngresarKriptonita> introductores = new ArrayList<>();

        int cantKrip=2;
        // Crear y agregar 5 extractores
        for (int i = 1; i <= 5; i++) {

            Kriptonita kript= new Kriptonita(cantKrip);
            kript.ingresarKriptonita(cantKrip, 0, kript);
            kript.extraerKriptonita(cantKrip, kript);

        }



        // Iniciar los hilos de extractores e introductores
        for (int i = 0; i < 5; i++) {
            extractores.get(i).start();
            introductores.get(0).start();
        }
    }
}
