import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Archive catalogo = new Archive();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Aggiungi libro");
            System.out.println("2. Aggiungi rivista");
            System.out.println("3. Ricerca per ISBN");
            System.out.println("4. Ricerca per anno di pubblicazione");
            System.out.println("5. Ricerca per autore");
            System.out.println("6. Salva catalogo su disco");
            System.out.println("7. Carica catalogo da disco");
            System.out.println("8. Esci");
            System.out.print("Seleziona un'opzione: ");

            int scelta = scanner.nextInt();
            scanner.nextLine();  // Consuma la newline rimasta.

            switch (scelta) {
                case 1:
                    System.out.print("Codice ISBN: ");
                    String isbnLibro = scanner.nextLine();
                    System.out.print("Titolo: ");
                    String titoloLibro = scanner.nextLine();
                    System.out.print("Anno di pubblicazione: ");
                    int annoLibro = scanner.nextInt();
                    System.out.print("Numero di pagine: ");
                    int pagineLibro = scanner.nextInt();
                    scanner.nextLine();  // Consuma la newline rimasta.
                    System.out.print("Autore: ");
                    String autore = scanner.nextLine();
                    System.out.print("Genere: ");
                    String genere = scanner.nextLine();
                    Book book = new Book(isbnLibro, titoloLibro, annoLibro, pagineLibro, autore, genere);
                    catalogo.aggiungiElemento(book);
                    System.out.println("Libro aggiunto con successo!");
                    break;
                case 2:
                    System.out.print("Codice ISBN: ");
                    String isbnRivista = scanner.nextLine();
                    System.out.print("Titolo: ");
                    String titoloRivista = scanner.nextLine();
                    System.out.print("Anno di pubblicazione: ");
                    int annoRivista = scanner.nextInt();
                    System.out.print("Numero di pagine: ");
                    int pagineRivista = scanner.nextInt();
                    scanner.nextLine();  // Consuma la newline rimasta.
                    System.out.print("Periodicità (SETTIMANALE, MENSILE, SEMESTRALE): ");
                    String periodicitaStr = scanner.nextLine();
                    Magazine.Periodicita periodicita = Magazine.Periodicita.valueOf(periodicitaStr.toUpperCase());
                    Magazine magazine = new Magazine(isbnRivista, titoloRivista, annoRivista, pagineRivista, periodicita);
                    catalogo.aggiungiElemento(magazine);
                    System.out.println("Rivista aggiunta con successo!");
                    break;
                case 3:
                    System.out.print("Inserisci ISBN: ");
                    String isbnRicerca = scanner.nextLine();
                    var risultatoISBN = catalogo.ricercaPerISBN(isbnRicerca);
                    System.out.println("Risultato ricerca: " + risultatoISBN.orElse(null));
                    break;
                case 4:
                    System.out.print("Inserisci anno di pubblicazione: ");
                    int annoRicerca = scanner.nextInt();
                    scanner.nextLine();  // Consuma la newline rimasta.
                    var risultatiAnno = catalogo.ricercaPerAnnoPubblicazione(annoRicerca);
                    System.out.println("Risultati ricerca per anno: " + risultatiAnno);
                    break;
                case 5:
                    System.out.print("Inserisci autore: ");
                    String autoreRicerca = scanner.nextLine();
                    var risultatiAutore = catalogo.ricercaPerAutore(autoreRicerca);
                    System.out.println("Risultati ricerca per autore: " + risultatiAutore);
                    break;
                case 6:
                    System.out.print("Inserisci percorso del file: ");
                    String percorsoSalva = scanner.nextLine();
                    try {
                        catalogo.salvaSuDisco(percorsoSalva);
                        System.out.println("Catalogo salvato con successo!");
                    } catch (IOException e) {
                        System.out.println("Errore nel salvataggio del catalogo: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.print("Inserisci percorso del file: ");
                    String percorsoCarica = scanner.nextLine();
                    try {
                        catalogo.caricaDaDisco(percorsoCarica);
                        System.out.println("Catalogo caricato con successo!");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Errore nel caricamento del catalogo: " + e.getMessage());
                    }
                    break;
                case 8:
                    running = false;
                    break;
                default:
                    System.out.println("Opzione non valida!");
                    break;
            }
        }

        scanner.close();
    }
}

