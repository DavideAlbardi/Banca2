//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Persona Giacomo = new Persona("Giacomo", "Lavazzi", "27/2/1922", "CF di Giacomo");
        Banca IntesaSaintPaul = new Banca("Intesa Saint Paul", 12, "STP");
        IntesaSaintPaul.aggiungiConto(Giacomo, "Deposito");

        IntesaSaintPaul.elenco(IntesaSaintPaul);
        IntesaSaintPaul.dettagliConto("STPCF di Giacomo");
        IntesaSaintPaul.dettagliConto("STPC");
        IntesaSaintPaul.operazione("STPCF di Giacomo", 200);
        IntesaSaintPaul.dettagliConto("STPCF di Giacomo");
    }
}