public class ContoDeposito extends Conto{

    public ContoDeposito(String iban, Persona daAggiungere) {
        this.iban = iban;
        proprietario = daAggiungere;
        this.saldo = 0;
    }

    public boolean deposita(ContoDeposito conto, Double quantita){
        if(quantita < 0){
            System.out.println("Operazione non valida, non puoi prelevare da un conto deposito");
            return false;
        }
        conto.saldo += quantita;
        return true;
    }

    @Override
    public String getTipo(){
        return "ContoDeposito";
    }
}
