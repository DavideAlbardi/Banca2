import java.util.Scanner;

public class Banca {
    private String nome;
    int max = 0;
    Conto[] conti;
    private int attivi;
    private String radiceIban;

    // Nessun problema con questo costruttore
    public Banca(String nome, int max, String iban) {
        this.nome = nome;
        this.max = max;
        this.attivi = 0;
        this.conti = new Conto[max];
        this.radiceIban = iban;
    }

    //In teoria nessun problema anche con questo metodo
    public void elenco(Banca bancaDaElencare){
        int i = 0;
        while(i < conti.length && conti[i] != null){
            System.out.println(conti[i].getIban() +" "+conti[i].getSaldo());
            i++;
        }
    }

    public void aggiungiConto(Persona daAggiungere, String tipo) {
        String iban = radiceIban + daAggiungere.getCf();
        int i = 0;
        //Controllo che il conto non sia già presente
        while (i < conti.length && conti[i] != null) {
            if (conti[i].getIban().equals(iban)) {
                System.out.println("Questo iban è già presente");
                return;
            }
            i++;
        }
        //Controllo se ho spazio prima di aggiungere il conto
        if (attivi < max) {
            switch (tipo) {
                case "Deposito":
                    ContoDeposito contoDeposito = new ContoDeposito(iban, daAggiungere);
                    conti[attivi] = contoDeposito;
                    this.attivi++;
                    break;
                case "Web":
                    ContoWeb contoWeb = new ContoWeb(iban, daAggiungere);
                    conti[attivi] = contoWeb;
                    this.attivi++;
                    break;
                case "Corrente":
                    ContoCorrente contoCorrente = new ContoCorrente(iban, daAggiungere);
                    conti[attivi] = contoCorrente;
                    this.attivi++;
                    break;
                default:
                    System.out.println("Tipo di conto non valido");
                    return;
            }
        }else
            System.out.println("Numero massimo conti raggiunto");
    }

    //In teoria nessun problema anche con questo metodo
    public double totaleSaldi(){
        double tot = 0;
        /*devo controllare i saldi di tutti i conti interessati*/
        for(int i = 0; i < conti.length; i++){
            tot = tot+conti[i].getSaldo();
        }
        return tot;
    }

    public void dettagliConto(String iban){
        Conto contoIban = getConto(iban);
        if(contoIban == null){
            //La funzione getConto dà errore, non serve riscriverlo qua
            return;
        }
        System.out.println("Ecco i dettagli del conto: " + contoIban.getIban() + " " +contoIban.getSaldo() + " "+contoIban.getCF());
    }

    public boolean operazione(String iban, double valoreOperazione){
        Conto contoIban = getConto(iban);
        if(contoIban == null){
            //La funzione getConto dà errore, non serve riscriverlo qua
            return false;
        }

        if(contoIban.getTipo().equals("Deposito") && valoreOperazione < 0){
            System.out.println("Operazione non valida, non puoi prelevare da un conto deposito");
            return false;
        }

        //So che è il metodo errato ma attualmente non ho altre idee
        switch(contoIban.getTipo()){
            case "ContoDeposito":
                ContoDeposito contoDeposito = (ContoDeposito) contoIban;
                contoDeposito.deposita(contoDeposito, valoreOperazione);
                return true;
            case "ContoCorrente":
                ContoCorrente contoCorrente = (ContoCorrente)contoIban;
                contoCorrente.operazione(contoCorrente, valoreOperazione);
                return true;
            case "ContoWeb":
                ContoWeb contoWeb = (ContoWeb)contoIban;
                contoWeb.operazione(contoWeb, valoreOperazione);
                return true;
        }
        System.out.println("Qualcosa è andato storto");
        return false;
    }

    //In teoria nessun problema anche con questo metodo
    public Conto getConto(String daTrovare){
        Conto contoIban;
        int i = 0;
        while(conti[i] != null && i < conti.length && !this.conti[i].getIban().equals(daTrovare)){
            i++;
        }
        contoIban = this.conti[i];

        //Scritto in questo modo altrimenti non funziona
        if(contoIban == null || !contoIban.getIban().equals(daTrovare)) {
            System.out.println("Nessun conto trovato con iban " + daTrovare);
            return null;
        }else{
           return contoIban;
        }
    }

    public boolean login(String iban) {
        ContoWeb  conto = (ContoWeb) getConto(iban);

        if (conto.getPassword().equals("changeme")) {
            cambiaPassword(conto);
        }
        System.out.println("Scrivi la password per il login: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.equals(conto.getPassword())) {
            System.out.println("Password corretta");
            conto.setLoggedIn(true);
            return true;
        } else
            System.out.println("Password errata");
            conto.setLoggedIn(false);
        return false;
    }

    public boolean cambiaPassword(ContoWeb conto) {
        System.out.println("Scrivi la nuova password: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        conto.setPassword(input);

        if(conto.getPassword().equals("changeme")){
            while(conto.getPassword().equals("changeme")){
                System.out.println("Non va bene, scegli un'altra password: ");
                conto.setPassword(scanner.nextLine());
            }
        }
        return true;
    }

    public String getNome() {
        return nome;
    }

    public int getMax() {
        return max;
    }

    public Conto[] getConti() {
        return conti;
    }

    public int getAttivi() {
        return attivi;
    }

    public String getRadiceIban() {
        return radiceIban;
    }
}
