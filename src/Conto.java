abstract class Conto {
    protected String iban;
    protected double saldo;
    protected Persona proprietario;

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }
}
