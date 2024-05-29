import java.util.*;

public class Card {

    // Attributi
    private String seme;
    private String valore;

    // Costruttore
    public Card(String seme, String valore) {
        this.seme = seme;
        this.valore = valore;
    }

    // Metodo getter
    public String getSeme() {
        return seme;
    }

    public String getValore() {
        return valore;
    }

    // Metodo per stampare le carte uscite
    @Override
    public String toString() {
        return valore + " di " + seme;
    }

    // Metodo per pulire il terminale
    public static void clear() {
        try {
            // Creo un processo
            String os = System.getProperty("os.name").toLowerCase();
            ProcessBuilder processBuilder = new ProcessBuilder();
            // Verifico il sistema operativo
            if (os.contains("win")) {
                processBuilder.command("cmd", "/c", "cls"); // Comando per Windows
            } else {
                processBuilder.command("clear"); // Comando per Linux/Unix/Mac OS
            }

            processBuilder.inheritIO().start().waitFor();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
