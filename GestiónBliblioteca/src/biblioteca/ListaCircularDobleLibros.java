package biblioteca;

public class ListaCircularDobleLibros {
private NodoLibro cabeza;
    
    public ListaCircularDobleLibros() {
        this.cabeza = null;
    }

    // Método para agregar un libro a la lista
    public void agregarLibro(String titulo, String autor) {
    	  NodoLibro nuevoLibro = new NodoLibro(titulo, autor);
    	    
    	    if (cabeza == null) {
    	        cabeza = nuevoLibro;
    	        cabeza.setSiguiente(cabeza);
    	        cabeza.setAnterior(cabeza);
    	    } else {
    	        NodoLibro ultimo = cabeza.getAnterior();
    	        ultimo.setSiguiente(nuevoLibro);
    	        nuevoLibro.setAnterior(ultimo);
    	        nuevoLibro.setSiguiente(cabeza);
    	        cabeza.setAnterior(nuevoLibro);
    	    }
    }
 
    public boolean eliminarLibro(String titulo) {
        if (cabeza == null)  {
        return false;
    }
        NodoLibro actual = cabeza;
        do {
            if (actual.getTitulo().equalsIgnoreCase(titulo)) {
                if (cabeza==cabeza.getSiguiente()) {
                cabeza=null;
            }else {
                actual.getAnterior().setSiguiente(actual.getSiguiente());
                actual.getSiguiente().setAnterior(actual.getAnterior());
                if (actual==cabeza) {
					cabeza = actual.getSiguiente();
				}
            }
            return true;
        }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        
        return false;
    }
    public NodoLibro buscarLibro(String criterio) {
        if (cabeza == null) return null;
        
        NodoLibro actual = cabeza;
        do {
            if (actual.getTitulo().equalsIgnoreCase(criterio)) {
                return actual;
            }
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        
        return null;
    }

    public String mostrarLibros() {
        if (cabeza == null) return "No hay libros registrados.";
        
        StringBuilder sb = new StringBuilder();
        NodoLibro actual = cabeza;
        do {
            sb.append("Título: ").append(actual.getTitulo()).append(", Autor: ").append(actual.getAutor()).append("\n");
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        
        return sb.toString();
    }
}
