import java.util.Scanner;

public class ContoWeb extends ContoCorrente {
    private String password;
    private boolean loggedIn;

    public ContoWeb(String iban, Persona daAggiungere) {
        super(iban, daAggiungere);
        this.password = "changeme";
    }

    public boolean login(ContoWeb conto) {
        if (conto.password.equals("changeme")) {
            conto.cambiaPassword(conto);
        }
        System.out.println("Scrivi la password per il login: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (password.equals(conto.password)) {
            System.out.println("Password corretta");
            loggedIn = true;
            return true;
        } else
            System.out.println("Password errata");
            loggedIn = false;
            return false;
    }

    public boolean cambiaPassword(ContoWeb conto) {
        System.out.println("Scrivi la nuova password: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        conto.password = password;
        if(conto.password.equals("changeme")){
            while(conto.password.equals("changeme")){
                System.out.println("Non va bene, scegli un'altra password: ");
                password = scanner.nextLine();
            }
        }
        return true;
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

    @Override
    public String getTipo(){
        return "ContoWeb";
    }
}