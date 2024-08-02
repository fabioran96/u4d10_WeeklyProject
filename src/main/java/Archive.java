import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Archive {
    private List<GenericElement> catalogo;

    public Archive() {
        this.catalogo = new ArrayList<>();
    }

    public void aggiungiElemento(GenericElement elemento) {
        catalogo.add(elemento);
    }

    public void rimuoviElemento(String codiceISBN) {
        catalogo.removeIf(elemento -> elemento.getCodiceISBN().equals(codiceISBN));
    }

    public Optional<GenericElement> ricercaPerISBN(String codiceISBN) {
        return catalogo.stream()
                .filter(elemento -> elemento.getCodiceISBN().equals(codiceISBN))
                .findFirst();
    }

    public List<GenericElement> ricercaPerAnnoPubblicazione(int anno) {
        return catalogo.stream()
                .filter(elemento -> elemento.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());
    }

    public List<Book> ricercaPerAutore(String autore) {
        return catalogo.stream()
                .filter(elemento -> elemento instanceof Book)
                .map(elemento -> (Book) elemento)
                .filter(book -> book.getAutore().equalsIgnoreCase(autore))
                .collect(Collectors.toList());
    }

    public void salvaSuDisco(String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(catalogo);
        }
    }

    public void caricaDaDisco(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            catalogo = (List<GenericElement>) ois.readObject();
        }
    }
}

