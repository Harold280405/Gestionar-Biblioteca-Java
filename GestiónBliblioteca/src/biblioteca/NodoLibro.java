package biblioteca;

public class NodoLibro {
	private String titulo;
    private String autor;
    private NodoLibro siguiente, anterior;

    NodoLibro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.siguiente = this.anterior = null;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public NodoLibro getSiguiente() {
        return siguiente;
    }

    public NodoLibro getAnterior() {
        return anterior;
    }

    public void setSiguiente(NodoLibro siguiente) {
        this.siguiente = siguiente;
    }

    public void setAnterior(NodoLibro anterior) {
        this.anterior = anterior;
    }
}
