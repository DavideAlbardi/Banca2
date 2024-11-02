public class Banca {
    private String nome;
    int max = 0;
    Conto[] conti;
    private int attivi;
    private String radiceIban;

    public Banca(String nome, int max) {
        this.nome = nome;
        this.max = max;
        this.attivi = 0;
        this.conti = new Conto[max];
    }

    public void elenco(Banca bancaDaElencare){
        for(int i = 0; i < conti.length; i++){
            System.out.println(conti[i].getIban() +" "+conti[i].getSaldo());
        }
    }

    /*public Conto aggiungiConto(String iban, String nome, String cognome, String dataNascita, String cf){
        Conto contoDaAggiungere = new Conto(iban, nome, cognome, dataNascita, cf);
        if(attivi < max) {

            conti[attivi] = contoDaAggiungere;
            this.attivi++;
            return contoDaAggiungere;
        }else
            return contoDaAggiungere;
    }*/

    public double totaleSaldi(){
        double tot = 0;
        /*devo controllare i saldi di tutti i conti interessati*/
        for(int i = 0; i < conti.length; i++){
            tot = tot+conti[i].getSaldo();
        }
        return tot;
    }

    public boolean operazione(Conto contoDaModificare, double valoreOperazione){
        if(valoreOperazione <0){
            valoreOperazione = Math.abs(valoreOperazione);
            return contoDaModificare.preleva(contoDaModificare, valoreOperazione);
        }else{
            return contoDaModificare.deposita(contoDaModificare, valoreOperazione);
        }
    }

    public Conto getConto(String daTrovare){
        Conto contoIban;
        int i = 0;
        while(this.conti[i].getIban() != daTrovare){
            i++;
        }
        contoIban = this.conti[i];
        return contoIban;
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
