import java.util.logging.Level;
import java.util.logging.Logger;

public class Kriptonita extends Thread {
    private static int UnidadesKriptonita;
    private static int BateriasDescargadas=0;

    Kriptonita(int CantidadInicial){
        UnidadesKriptonita = CantidadInicial;
    }

    public void ingresarKriptonita(int CantidadKriptonita, int bateriaDescargada, Thread hilo){
        synchronized(Kriptonita.class){
            int saldito = UnidadesKriptonita;
            this.BateriasDescargadas++;
            System.out.println("El ingresador " + hilo.getName() + " va a meter 1 de Kriptonita. "+
                    "La cantidad es "+ UnidadesKriptonita);
            UnidadesKriptonita = saldito + CantidadKriptonita;
            System.out.println("El ingresador " + hilo.getName() + " metió 1 de Kriptonita. "+
                    "La cantidad es "+ UnidadesKriptonita);
            notifyAll();
            try {
                sleep(10000);//tardan 10 segundos en recolectar las piedras
            } catch (InterruptedException ex) {
                Logger.getLogger(Kriptonita.class.getName()).log(Level.SEVERE, null, ex);
            }


        }

    }

    public void extraerKriptonita(int CantidadKriptonita, Thread hilo){
        synchronized(Kriptonita.class){

            while(UnidadesKriptonita <CantidadKriptonita){
                try {
                    hilo.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Kriptonita.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            int saldito = UnidadesKriptonita;
            System.out.println("El extractor " + hilo.getName() +
                    " va a sacar 1 de Kriptonita."+
                    "La cantidad es de  "+ UnidadesKriptonita);
            UnidadesKriptonita = saldito - CantidadKriptonita;
            System.out.println("El extractor " + hilo.getName() +
                    " sacó 1 de Kriptonita. "+
                    "La cantidad es de "+ UnidadesKriptonita);

        }


    }

    public  void cargarBaterias(Thread hilo){
        synchronized(Kriptonita.class){
            while (BateriasDescargadas>0){
                try {
                    sleep(15000);//tardan 15 segundos cargar las baterias
                } catch (InterruptedException ex) {
                    Logger.getLogger(Kriptonita.class.getName()).log(Level.SEVERE, null, ex);
                }
                BateriasDescargadas--;
                UnidadesKriptonita++;

            }

        }
    }


}
