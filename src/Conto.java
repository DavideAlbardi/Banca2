class Conto {
    protected String iban;
    protected double saldo;
    protected Persona proprietario;
    protected String tipo;

    public String getTipo() {
        return null;
    }

    public String getIban() {
        return iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCF(){
        return proprietario.getCf();
    }
}
