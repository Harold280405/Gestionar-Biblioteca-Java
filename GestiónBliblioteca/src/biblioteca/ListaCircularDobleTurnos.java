package biblioteca;

class ListaCircularDobleTurnos {
	 private NodoTurno inicio;

	    // Constructor
	    public ListaCircularDobleTurnos() {
	        inicio = null;
	    }

	    // Método para agregar un turno
	    public void agregarTurno(String nombre, String horario) {
	        NodoTurno nuevo = new NodoTurno(nombre, horario);
	        if (inicio == null) {
	            // Lista vacía
	            inicio = nuevo;
	            inicio.setSiguiente(inicio);
	            inicio.setAnterior(inicio);
	        } else {
	            // Insertar al final de la lista
	            NodoTurno ultimo = inicio.getAnterior();
	            nuevo.setSiguiente(inicio);
	            nuevo.setAnterior(ultimo);
	            ultimo.setSiguiente(nuevo);
	            inicio.setAnterior(nuevo);
	        }
	    }

	    // Método para eliminar un turno por nombre
	    public boolean eliminarTurno(String nombre) {
	        if (inicio == null) { // Lista vacía
	            return false;
	        }

	        NodoTurno actual = inicio;
	        do {
	            if (actual.getNombre().equalsIgnoreCase(nombre)) { // Encontramos el nodo a eliminar
	                if (inicio == inicio.getSiguiente()) { // Solo un elemento en la lista
	                    inicio = null;
	                } else { // Más de un elemento
	                    actual.getAnterior().setSiguiente(actual.getSiguiente());
	                    actual.getSiguiente().setAnterior(actual.getAnterior());
	                    if (actual == inicio) { // Si eliminamos el primer nodo, actualizamos `inicio`
	                        inicio = actual.getSiguiente();
	                    }
	                }
	                return true; // Nodo eliminado
	            }
	            actual = actual.getSiguiente();
	        } while (actual != inicio);

	        return false; // Nodo no encontrado
	    }

	    // Método para mostrar todos los turnos
	    public String mostrarTurnos() {
	        if (inicio == null) {
	            return "No hay turnos programados.";
	        }

	        StringBuilder turnos = new StringBuilder("Turnos programados:\n");
	        NodoTurno actual = inicio;
	        do {
	            turnos.append("Bibliotecario: ").append(actual.getNombre())
	                  .append(", Horario: ").append(actual.getHorario()).append("\n");
	            actual = actual.getSiguiente();
	        } while (actual != inicio);

	        return turnos.toString();
	    }

	    // Método para buscar un turno por nombre
	    public NodoTurno buscarTurno(String nombre) {
	        if (inicio == null) {
	            return null;
	        }

	        NodoTurno actual = inicio;
	        do {
	            if (actual.getNombre().equalsIgnoreCase(nombre)) {
	                return actual;
	            }
	            actual = actual.getSiguiente();
	        } while (actual != inicio);

	        return null;
	    }
	}