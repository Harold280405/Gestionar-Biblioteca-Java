package biblioteca;

class ListaEnlazadaSimplePrestamo {
    private NodoPrestamo cabeza;

    public ListaEnlazadaSimplePrestamo() {
        this.cabeza = null;
    }

    public void agregarPrestamo(String titulo, String usuario, String fechaPrestamo, String fechaDevolucion) {
        NodoPrestamo nuevo = new NodoPrestamo(titulo, usuario, fechaPrestamo, fechaDevolucion);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoPrestamo actual = cabeza;
            while (actual.getSiguiente() != null) { // Usar el getter
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo); // Usar el setter
        }
    }

    public NodoPrestamo buscarPrestamo(String criterio) {
        NodoPrestamo actual = cabeza;
        while (actual != null) {
            if (actual.getTitulo().equalsIgnoreCase(criterio) || actual.getUsuario().equalsIgnoreCase(criterio)) {
                return actual; 
            }
            actual = actual.getSiguiente();
        }
        return null; 
    }

    public String mostrarPrestamos() {
        if (cabeza == null) return "No hay préstamos activos.";
        StringBuilder sb = new StringBuilder();
        NodoPrestamo actual = cabeza;
        while (actual != null) {
            sb.append("Título: ").append(actual.getTitulo())
              .append(", Usuario: ").append(actual.getUsuario())
              .append(", Fecha de Préstamo: ").append(actual.getFechaPrestamo())
              .append(", Fecha de Devolución: ").append(actual.getFechaDevolucion())
              .append("\n");
            actual = actual.getSiguiente(); 
        }
        return sb.toString();
    }
    
    public void eliminarPrestamo(String titulo) {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        // Caso: el préstamo a eliminar está en la cabeza
        if (cabeza.getTitulo().equals(titulo)) {
            cabeza = cabeza.getSiguiente();
            return;
        }

        // Buscar el nodo a eliminar
        NodoPrestamo actual = cabeza;
        while (actual.getSiguiente() != null && 
               !actual.getSiguiente().getTitulo().equals(titulo)) {
            actual = actual.getSiguiente();
        }

        // Caso: el préstamo no se encuentra
        if (actual.getSiguiente() == null) {
            return;
        }

        // Eliminar el nodo
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
    }
}

