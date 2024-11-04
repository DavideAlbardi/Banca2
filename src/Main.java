//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Persona Giacomo = new Persona("Giacomo", "Lavazzi", "27/2/1922", "CFdiG");
        Banca IntesaSaintPaul = new Banca("Intesa Saint Paul", 12, "STP");
        //Aggiungo un conto di deposito
        IntesaSaintPaul.aggiungiConto(Giacomo, "Deposito");
        //Chiedo di elencarmi tutti i conti della banca
        IntesaSaintPaul.elenco(IntesaSaintPaul);
        //Chiedo di trovare il conto appena creato
        IntesaSaintPaul.dettagliConto("STPCFdiG");
        //Chiedo di trovare un conto che non esiste
        IntesaSaintPaul.dettagliConto("STPC");
        //Chiedo di depositare 200
        IntesaSaintPaul.operazione("STPCFdiG", 200);
        //Chiedo di prelevare 200 da un conto deposito, da errore
        IntesaSaintPaul.operazione("STPCFdiG", -200);
        IntesaSaintPaul.dettagliConto("STPCFdiG");

        Persona Paolo = new Persona("Paolo", "Jacovitti", "25/5/1970", "CFdiP");
        IntesaSaintPaul.aggiungiConto(Paolo, "Web");
        IntesaSaintPaul.elenco(IntesaSaintPaul);
        IntesaSaintPaul.operazione("STPCFdiP", 200);
        IntesaSaintPaul.login("STPCFdiP");
        IntesaSaintPaul.operazione("STPCFdiP", 200);
        IntesaSaintPaul.dettagliConto("STPCFdiP");

        Persona Giovanni = new Persona("Giovanni", "Muciaccia", "30/7/2002", "CFdiP");
        IntesaSaintPaul.aggiungiConto(Giovanni, "Corrente");
        IntesaSaintPaul.elenco(IntesaSaintPaul);

    }
}