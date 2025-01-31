package biblioteca;

class ListaDobleHistorial {
    private NodoHistorial inicio;

    public ListaDobleHistorial() {
        this.inicio = null;
    }

    public void agregarHistorial(String titulo, String usuario, String fechaPrestamo, String fechaDevolucion) {
        NodoHistorial nuevo = new NodoHistorial(titulo, usuario, fechaPrestamo, fechaDevolucion);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            NodoHistorial actual = inicio;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
        }
    }

    public String mostrarHistorial() {
        if (inicio == null) return "No hay historial de préstamos.";
        StringBuilder sb = new StringBuilder();
        NodoHistorial actual = inicio;
        while (actual != null) {
            sb.append("Título: ").append(actual.titulo).append(", Usuario: ").append(actual.usuario).append(", Fecha de Préstamo: ").append(actual.fechaPrestamo).append(", Fecha de Devolución: ").append(actual.fechaDevolucion).append("\n");
            actual = actual.siguiente;
        }
        return sb.toString();
    }
}
