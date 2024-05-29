import java.util.*;

public class Memory_game {
    public static void main(String[] args) {
        // Parte dichiarativa
        Random rand = new Random();
        String temp;

        ArrayList<Card> carteEstratte = new ArrayList<>();
        ArrayList<String[]> mazzo = new ArrayList<>();
        ArrayList<Card> rispostaUtente = new ArrayList<>();
        String[] semi = { "Cuori", "Quadri", "Fiori", "Picche" };
        String[] valori = { "Asso", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Regina", "Re" };
        mazzo.add(semi);
        mazzo.add(valori);

        Scanner tastiera = new Scanner(System.in);
        // Ciclo per far continuare il gioco se si vuole
        do {
            // Pulisco i due oggetti in modo tale che vengono ricreati ogni volta che si

            carteEstratte.clear();
            rispostaUtente.clear();

            System.out.println("Quante carte vuoi memorizzare?");
            int numerocarte = tastiera.nextInt();

            System.out.println("Ricordati le seguenti carte perché tra 10 secondi verranno eliminate");
            // Faccio uscire le carte in modo random
            for (int i = 0; i < numerocarte; i++) {
                String semeRandom = semi[rand.nextInt(semi.length)];
                String numeroRandom = valori[rand.nextInt(valori.length)];
                carteEstratte.add(new Card(semeRandom, numeroRandom));
            }
            // Prendo l'arraylist e memorizzo il contenuto in una variabile che poi stampo
            for (Card carta : carteEstratte) {
                System.out.println("Carte estratte: " + carta);
            }

            try {
                // Attendo per 10 secondi prima di pulire il terminale
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

            // Pulisco il terminale chiamando il metodo della classe ClearTerminal
            Card.clear();

            System.out.println("Quali carte sono state estratte? ");

            // Faccio avanzare lo scanner di una riga
            tastiera.nextLine();
            // Memorizzo l'input dell'utente in un arraylist
            for (int i = 0; i < carteEstratte.size(); i++) {
                String valoreUtente = tastiera.next().toLowerCase();
                String semeUtente = tastiera.nextLine().toLowerCase().trim();
                rispostaUtente.add(new Card(semeUtente, valoreUtente));
            }
            // Controllo che le carte uscite siano uguali a quelle digitate dall'utente
            int indovinate = 0;
            for (int i = 0; i < carteEstratte.size(); i++) {
                if (carteEstratte.get(i).getSeme().toLowerCase().equals(rispostaUtente.get(i).getSeme())
                        && carteEstratte.get(i).getValore().toLowerCase().equals(rispostaUtente.get(i).getValore())) {
                    indovinate++;
                }
            }

            if (indovinate == carteEstratte.size()) {
                System.out.println("Hai vinto!!");
            } else {
                System.out.println("Hai perso!!");
            }

            System.out.println("Vuoi giocare di nuovo?[s/N]");
            temp = tastiera.nextLine();

        } while (temp.toLowerCase().equals("s"));
        tastiera.close();
    }

}
