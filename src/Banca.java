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
        radiceIban = radiceIban + daAggiungere.getCf();
        //Controllo che il conto non sia già presente
        if(conti == null) {
            for (int i = 0; i < conti.length; i++) {
                if (conti[i].getIban().equals(radiceIban)) {
                    System.out.println("Conto già presente");
                    return;
                }
            }
        }
        //Controllo se ho spazio prima di aggiungere il conto
        if (attivi < max) {
            switch (tipo) {
                case "Deposito":
                    ContoDeposito contoDeposito = new ContoDeposito(radiceIban, daAggiungere);
                    conti[attivi] = contoDeposito;
                    this.attivi++;
                    break;
                case "Web":
                    ContoWeb contoWeb = new ContoWeb(radiceIban, daAggiungere);
                    conti[attivi] = contoWeb;
                    this.attivi++;
                    break;
                case "Corrente":
                    ContoCorrente contoCorrente = new ContoCorrente(radiceIban, daAggiungere);
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
