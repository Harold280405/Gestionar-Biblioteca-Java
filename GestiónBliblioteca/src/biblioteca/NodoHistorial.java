package biblioteca;

class NodoHistorial {
    String titulo;
    String usuario;
    String fechaPrestamo;
    String fechaDevolucion;
    NodoHistorial siguiente, anterior;

    NodoHistorial(String titulo, String usuario, String fechaPrestamo, String fechaDevolucion) {
        this.titulo = titulo;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.siguiente = this.anterior = null;
    }
}

