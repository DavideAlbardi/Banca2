import java.util.Scanner;

public class ContoWeb extends ContoCorrente {
    private String password;
    private boolean loggedIn;

    public ContoWeb(String iban, String nome, String cognome, String dataNascita, String cf) {
        super(iban, nome, cognome, dataNascita, cf);
        this.password = "changeme";
    }

    public boolean login(ContoWeb conto) {
        if (conto.password.equals("changeme")) {
            conto.cambiaPassword(conto);
        }
        System.out.println("Scrivi la password per il login: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (password == conto.password) {
            loggedIn = true;
            return true;
        } else
            loggedIn = false;
        return false;

    }

    public boolean cambiaPassword(ContoWeb conto) {
        System.out.println("Scrivi la nuova password: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        conto.password = password;
        if (conto.password == password) {
            return true;
        } else
            return false;
    }


    public boolean operazione(ContoWeb conto, double quantita) {

        if (conto.loggedIn) {
            double cambiamento = conto.getSaldo() + quantita;
            if (cambiamento < 0) {
                return false;
            } else {
                conto.saldo = cambiamento;
                return true;
            }

        } else
            System.out.println("Non hai effettuato il login");
            return false;
    }

}