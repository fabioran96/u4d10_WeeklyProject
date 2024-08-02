public class Book extends GenericElement {
    private String author;
    private String genre;

    public Book(String codiceISBN, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(codiceISBN, titolo, annoPubblicazione, numeroPagine);
        this.author = autore;
        this.genre = genere;
    }

    public String getAutore() {
        return author;
    }

    public String getGenere() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "codiceISBN='" + codiceISBN + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", autore='" + author + '\'' +
                ", genere='" + genre + '\'' +
                '}';
    }
}

