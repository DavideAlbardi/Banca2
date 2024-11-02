public class ContoCorrente extends Conto{

    public ContoCorrente(String iban, Persona daAggiungere) {
        this.iban = iban;
        proprietario = daAggiungere;
        this.saldo = 0;
    }

    @Override
    public String getTipo(){
        return "ContoCorrente";
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
