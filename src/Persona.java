public class Persona {
    private String nome, cognome, dataNascita, cf;

    public Persona(String nome, String cognome, String dataNascita, String cf) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.cf = cf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getDataNascitao() {
        return dataNascita;
    }

    public String getCf() {
        return cf;
    }
}
