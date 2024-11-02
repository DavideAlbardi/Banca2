public class ContoCorrente extends Conto{

    public ContoCorrente(String iban, String nome, String cognome, String dataNascita, String cf) {
        this.iban = iban;
        Persona nuovaPersona = new Persona(nome, cognome, dataNascita, cf);
        this.saldo = 0;
    }

    public boolean operazione(Conto conto, double quantita){
        double cambiamento = conto.getSaldo() + quantita;
        if(cambiamento < 0){
            return false;
        }else{
            conto.saldo = cambiamento;
            return true;
        }
    }
}
