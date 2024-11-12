
public class ContoWeb extends ContoCorrente {
    private String password;
    private boolean loggedIn;

    public ContoWeb(String iban, Persona daAggiungere) {
        super(iban, daAggiungere);
        this.password = "changeme";
    }

    public boolean operazione(ContoWeb conto, double quantita) {

        if (conto.loggedIn) {
            double cambiamento = conto.getSaldo() + quantita;
            if (cambiamento < 0) {
                System.out.println("Non hai abbastanza credito da prelevare");
                return false;
            } else {
                conto.saldo = cambiamento;
                return true;
            }

        } else
            System.out.println("Non hai effettuato il login");
            return false;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    @Override
    public String getTipo(){
        return "ContoWeb";
    }
}