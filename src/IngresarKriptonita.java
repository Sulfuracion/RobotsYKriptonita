public class IngresarKriptonita extends Thread{
    Kriptonita UnidadesKriptonita;
    IngresarKriptonita(Kriptonita UnidadesKriptonita){
        this.UnidadesKriptonita = UnidadesKriptonita;
    }
    public void run(){
        UnidadesKriptonita.ingresarKriptonita(1,1, this );
    }
}
