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
        Conto daTrovare = new Conto();
        daTrovare.setIban("STPCFdiG");
        IntesaSaintPaul.dettagliConto(daTrovare);
        //Chiedo di trovare un conto che non esiste
        daTrovare.setIban("STPCF");
        IntesaSaintPaul.dettagliConto(daTrovare);
        //Chiedo di depositare 200
        daTrovare.setIban("STPCFdiG");
        IntesaSaintPaul.operazione(daTrovare, 200);
        //Chiedo di prelevare 200 da un conto deposito, da errore
        IntesaSaintPaul.operazione(daTrovare, -200);
        IntesaSaintPaul.dettagliConto(daTrovare);

        Persona Paolo = new Persona("Paolo", "Jacovitti", "25/5/1970", "CFdiP");
        IntesaSaintPaul.aggiungiConto(Paolo, "Web");
        IntesaSaintPaul.elenco(IntesaSaintPaul);
        //Eseguo un'operazione senza loggarmi
        daTrovare.setIban("STPCFdiP");
        IntesaSaintPaul.operazione(daTrovare, 200);
        //Eseguo un'operazione dopo aver fatto il login
        IntesaSaintPaul.login(daTrovare);
        IntesaSaintPaul.operazione(daTrovare, 200);
        IntesaSaintPaul.dettagliConto(daTrovare);
        //Aggiungo un conto con un iban che già esiste
        Persona Giovanni = new Persona("Giovanni", "Muciaccia", "30/7/2002", "CFdiP");
        IntesaSaintPaul.aggiungiConto(Giovanni, "Corrente");
        IntesaSaintPaul.elenco(IntesaSaintPaul);
        //Aggiungo un conto e provo a prelevare da un conto deposito
        Persona Manuel = new Persona("Manuel", "Liviero", "11/7/2002", "CFdiM");
        IntesaSaintPaul.aggiungiConto(Manuel, "Deposito");
        daTrovare.setIban("STPCFdiM");
        IntesaSaintPaul.operazione(daTrovare, 500);
        IntesaSaintPaul.dettagliConto(daTrovare);
        IntesaSaintPaul.operazione(daTrovare, -200);
        IntesaSaintPaul.dettagliConto(daTrovare);
    }
}