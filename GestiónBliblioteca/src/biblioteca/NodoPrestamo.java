package biblioteca;


class NodoPrestamo {
    private String titulo;
    private String usuario;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private NodoPrestamo siguiente;

    NodoPrestamo(String titulo, String usuario, String fechaPrestamo, String fechaDevolucion) {
        this.titulo = titulo;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.siguiente = null;
    }

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public String getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public NodoPrestamo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoPrestamo siguiente) {
		this.siguiente = siguiente;
	}
	@Override
	public String toString() {
	    return "Título: " + titulo + ", Usuario: " + usuario +
	           ", Fecha de Préstamo: " + fechaPrestamo +
	           ", Fecha de Devolución: " + fechaDevolucion;
	}
}