package biblioteca;

class NodoTurno {
    private String nombre;
    private String horario;
    private NodoTurno siguiente, anterior;

    NodoTurno(String nombre, String horario) {
        this.nombre = nombre;
        this.horario = horario;
        this.siguiente = this.anterior = null;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public NodoTurno getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoTurno siguiente) {
		this.siguiente = siguiente;
	}

	public NodoTurno getAnterior() {
		return anterior;
	}

	public void setAnterior(NodoTurno anterior) {
		this.anterior = anterior;
	}
    
}
