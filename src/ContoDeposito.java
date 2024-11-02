public class ContoDeposito extends Conto{

    public ContoDeposito(String iban, String nome, String cognome, String dataNascita, String cf) {
        this.iban = iban;
        Persona nuovaPersona = new Persona(nome, cognome, dataNascita, cf);
        this.saldo = 0;
    }

    public boolean deposita(ContoDeposito conto, Double quantita){
        if(quantita < 0){
            return false;
        }
        conto.saldo += quantita;
        return true;
    }

}
