abstract class Conto {
    protected String iban;
    protected double saldo;
    protected Persona proprietario;
    protected String tipo;

    public abstract String getTipo();

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getCF(){
        return proprietario.getCf();
    }
}
