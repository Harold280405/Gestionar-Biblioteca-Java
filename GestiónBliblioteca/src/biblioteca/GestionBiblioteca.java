package biblioteca;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.swing.ImageIcon;

public class GestionBiblioteca extends JFrame {
	private ListaCircularDobleTurnos turnos;
	private ListaEnlazadaSimplePrestamo prestamos;
	private JLabel Fecha;
	private ListaDobleHistorial historial;
	private ListaCircularDobleLibros libros;


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static void abrirVentana() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionBiblioteca frame = new GestionBiblioteca();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public GestionBiblioteca() {
		turnos = new ListaCircularDobleTurnos();
		prestamos = new ListaEnlazadaSimplePrestamo();
		historial = new ListaDobleHistorial();
		libros = new ListaCircularDobleLibros();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);

		setContentPane(contentPane);

		JPanel encabezado = new JPanel();
		encabezado.setBounds(10, 0, 1096, 94);
		encabezado.setBackground(new Color(125, 0, 26));
		encabezado.setLayout(null);

		JLabel lblTitulo = new JLabel("Sistema Gestión Biblioteca");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Perpetua Titling MT", Font.BOLD, 24));
		lblTitulo.setBounds(325, 10, 446, 45);
		encabezado.add(lblTitulo);
		contentPane.setLayout(null);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(new Color(155, 0, 31));
		panel_8.setBounds(800, 93, 276, 370);
		contentPane.add(panel_8);

		JLabel lblGestionDeDevoluviones = new JLabel("ADMINISTRAR LIBROS");
		lblGestionDeDevoluviones.setBounds(10, 33, 260, 41);
		panel_8.add(lblGestionDeDevoluviones);
		lblGestionDeDevoluviones.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDeDevoluviones.setForeground(new Color(255, 255, 255));
		lblGestionDeDevoluviones.setFont(new Font("Roboto", Font.BOLD, 15));

		JPanel panel_5_1_1 = new JPanel();
		panel_5_1_1.setBounds(10, 236, 249, 52);
		panel_8.add(panel_5_1_1);
		panel_5_1_1.setLayout(null);
		panel_5_1_1.setBackground(new Color(255, 128, 128));

		JLabel lblEliminarLibros = new JLabel("Eliminar Libros");
		lblEliminarLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminarLibro();
			}
		});
		lblEliminarLibros.setIcon(new ImageIcon(GestionBiblioteca.class.getResource("/imagenes2/eliminar (1).png")));
		lblEliminarLibros.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarLibros.setForeground(Color.WHITE);
		lblEliminarLibros.setFont(new Font("Roboto", Font.BOLD, 15));
		lblEliminarLibros.setBackground(Color.WHITE);
		lblEliminarLibros.setBounds(0, 0, 249, 52);
		panel_5_1_1.add(lblEliminarLibros);

		JPanel panel_5_1 = new JPanel();
		panel_5_1.setBounds(10, 160, 249, 52);
		panel_8.add(panel_5_1);
		panel_5_1.setLayout(null);
		panel_5_1.setBackground(new Color(255, 128, 128));

		JLabel lblAgregarLibros = new JLabel("Mostrar Libros");
		lblAgregarLibros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarLibros();
			}
		});
		lblAgregarLibros.setIcon(new ImageIcon(GestionBiblioteca.class.getResource("/imagenes2/file-chart.png")));
		lblAgregarLibros.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarLibros.setForeground(Color.WHITE);
		lblAgregarLibros.setFont(new Font("Roboto", Font.BOLD, 15));
		lblAgregarLibros.setBackground(Color.WHITE);
		lblAgregarLibros.setBounds(0, 0, 249, 52);
		panel_5_1.add(lblAgregarLibros);

		JPanel panel_5_2 = new JPanel();
		panel_5_2.setBounds(10, 84, 249, 52);
		panel_8.add(panel_5_2);
		panel_5_2.setLayout(null);
		panel_5_2.setBackground(new Color(255, 128, 128));

		JLabel lblDevolverLibro_1 = new JLabel("Agregar Nuevo Libro");
		lblDevolverLibro_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				agregarLibro();
			}
		});
		lblDevolverLibro_1.setIcon(new ImageIcon(GestionBiblioteca.class.getResource("/imagenes2/book. (1).png")));
		lblDevolverLibro_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevolverLibro_1.setForeground(Color.WHITE);
		lblDevolverLibro_1.setFont(new Font("Roboto", Font.BOLD, 15));
		lblDevolverLibro_1.setBackground(Color.WHITE);
		lblDevolverLibro_1.setBounds(0, 0, 249, 52);
		panel_5_2.add(lblDevolverLibro_1);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(new Color(155, 0, 31));
		panel_7.setBounds(420, 93, 276, 400);
		contentPane.add(panel_7);

		JLabel lblGestionPrestamo = new JLabel("GESTIÓN DE PRESTAMOS");
		lblGestionPrestamo.setBackground(new Color(255, 255, 255));
		lblGestionPrestamo.setBounds(10, 33, 260, 41);
		panel_7.add(lblGestionPrestamo);
		lblGestionPrestamo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionPrestamo.setForeground(new Color(255, 255, 255));
		lblGestionPrestamo.setFont(new Font("Roboto", Font.BOLD, 15));

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 84, 256, 52);
		panel_7.add(panel_3);
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(255, 128, 128));

		JLabel lblReguistrarPrestamo = new JLabel("Registrar Prestamo");
		lblReguistrarPrestamo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registrarPrestamo();
			}
		});
		lblReguistrarPrestamo.setIcon(new ImageIcon(GestionBiblioteca.class.getResource("/imagenes2/agregar (1).png")));
		lblReguistrarPrestamo.setHorizontalAlignment(SwingConstants.CENTER);
		lblReguistrarPrestamo.setForeground(Color.WHITE);
		lblReguistrarPrestamo.setFont(new Font("Roboto", Font.BOLD, 15));
		lblReguistrarPrestamo.setBackground(Color.WHITE);
		lblReguistrarPrestamo.setBounds(0, 0, 256, 52);
		panel_3.add(lblReguistrarPrestamo);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 160, 256, 52);
		panel_7.add(panel_4);
		panel_4.setLayout(null);
		panel_4.setBackground(new Color(255, 128, 128));

		JLabel lblMostrarPrestamo = new JLabel("Buscar Prestamo");
		lblMostrarPrestamo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				buscarPrestamos();
			}
		});
		lblMostrarPrestamo.setIcon(new ImageIcon(GestionBiblioteca.class.getResource("/imagenes2/lupa(1).png")));
		lblMostrarPrestamo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarPrestamo.setForeground(Color.WHITE);
		lblMostrarPrestamo.setFont(new Font("Roboto", Font.BOLD, 15));
		lblMostrarPrestamo.setBackground(Color.WHITE);
		lblMostrarPrestamo.setBounds(0, 0, 256, 52);
		panel_4.add(lblMostrarPrestamo);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 236, 256, 52);
		panel_7.add(panel_5);
		panel_5.setLayout(null);
		panel_5.setBackground(new Color(255, 128, 128));

		JLabel lblDevolverLibro = new JLabel("Devolver Prestamo");
		lblDevolverLibro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				devolverLibro();
			}
		});
		lblDevolverLibro.setBounds(0, 0, 256, 52);
		panel_5.add(lblDevolverLibro);
		lblDevolverLibro.setIcon(new ImageIcon(GestionBiblioteca.class.getResource("/imagenes2/calendar-multiple-check.png")));
		lblDevolverLibro.setHorizontalAlignment(SwingConstants.CENTER);
		lblDevolverLibro.setForeground(Color.WHITE);
		lblDevolverLibro.setFont(new Font("Roboto", Font.BOLD, 15));
		lblDevolverLibro.setBackground(Color.WHITE);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(10, 312, 256, 52);
		panel_7.add(panel_3_1);
		panel_3_1.setLayout(null);
		panel_3_1.setBackground(new Color(255, 128, 128));

		JLabel lblMostarPrestamos = new JLabel("Mostar Prestamos Activos");
		lblMostarPrestamos.setIcon(new ImageIcon(GestionBiblioteca.class.getResource("/imagenes2/documentos.png")));
		lblMostarPrestamos.setBounds(0, 0, 256, 52);
		panel_3_1.add(lblMostarPrestamos);
		lblMostarPrestamos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarPrestamos();
			}
		});
		lblMostarPrestamos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostarPrestamos.setForeground(new Color(255, 255, 255));
		lblMostarPrestamos.setFont(new Font("Roboto", Font.BOLD, 15));
		lblMostarPrestamos.setBackground(Color.RED);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(155, 0, 31));
		panel.setBounds(41, 93, 276, 370);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblReguistroTurnos = new JLabel("GESTIONAR TURNOS\r\n");
		lblReguistroTurnos.setBounds(57, 33, 162, 41);
		panel.add(lblReguistroTurnos);
		lblReguistroTurnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblReguistroTurnos.setForeground(new Color(255, 255, 255));
		lblReguistroTurnos.setFont(new Font("Roboto", Font.BOLD, 15));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 84, 256, 52);
		panel.add(panel_1);
		panel_1.setBackground(new Color(255, 128, 128));
		panel_1.setLayout(null);

		JLabel lblRegistrarTurno = new JLabel("Registrar Nuevo Turno");
		lblRegistrarTurno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				registrarTurno();
			}
		});
		lblRegistrarTurno.setBounds(0, 0, 256, 52);
		panel_1.add(lblRegistrarTurno);
		lblRegistrarTurno.setIcon(new ImageIcon(GestionBiblioteca.class.getResource("/imagenes2/account-multiple.png")));
		lblRegistrarTurno.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistrarTurno.setFont(new Font("Roboto", Font.BOLD, 15));
		lblRegistrarTurno.setForeground(new Color(255, 255, 255));
		lblRegistrarTurno.setBackground(new Color(255, 255, 255));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 160, 256, 52);
		panel.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 128, 128));

		JLabel lblMostrarTurnos = new JLabel("Mostrar Turnos");
		lblMostrarTurnos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarTurnos();
			}
		});
		lblMostrarTurnos.setIcon(new ImageIcon(GestionBiblioteca.class.getResource("/imagenes2/calendar-plus.png")));
		lblMostrarTurnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarTurnos.setForeground(Color.WHITE);
		lblMostrarTurnos.setFont(new Font("Roboto", Font.BOLD, 15));
		lblMostrarTurnos.setBackground(Color.WHITE);
		lblMostrarTurnos.setBounds(0, 0, 256, 52);
		panel_2.add(lblMostrarTurnos);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(10, 236, 256, 52);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(255, 128, 128));

		JLabel lblEliminarTurnos = new JLabel("Eliminar Turnos");
		lblEliminarTurnos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eliminarTurno();
			}
		});
		
		lblEliminarTurnos.setIcon(new ImageIcon(GestionBiblioteca.class.getResource("/imagenes2/eliminar (1).png")));
		lblEliminarTurnos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarTurnos.setForeground(Color.WHITE);
		lblEliminarTurnos.setFont(new Font("Roboto", Font.BOLD, 15));
		lblEliminarTurnos.setBackground(Color.WHITE);
		lblEliminarTurnos.setBounds(0, 0, 256, 52);
		panel_2_1.add(lblEliminarTurnos);
		
		contentPane.add(encabezado);

		Fecha = new JLabel("Fecha");
		Fecha.setHorizontalAlignment(SwingConstants.CENTER);
		Fecha.setForeground(Color.WHITE);
		Fecha.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 16));
		Fecha.setBounds(402, 52, 291, 32);
		encabezado.add(Fecha);

		SetDate();

		JPanel panel_6 = new JPanel();
		panel_6.setForeground(new Color(0, 0, 0));
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(64, 0, 0));
		panel_6.setBounds(496, 535, 124, 52);
		contentPane.add(panel_6);

		JLabel lblMostrarHistorial = new JLabel("HISTORIAL");
		lblMostrarHistorial.setBounds(0, 0, 124, 52);
		panel_6.add(lblMostrarHistorial);
		lblMostrarHistorial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mostrarHistorial();
			}
		});
		lblMostrarHistorial.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrarHistorial.setForeground(new Color(255, 255, 255));
		lblMostrarHistorial.setFont(new Font("Roboto", Font.BOLD, 15));
		lblMostrarHistorial.setBackground(new Color(255, 0, 0));

		JLabel lblImagen = new JLabel("New label");
		lblImagen.setIcon(new ImageIcon(GestionBiblioteca.class.getResource("/imagenes/Fondo2.jpg")));
		lblImagen.setBounds(0, 0, 1116, 613);
		contentPane.add(lblImagen);
	}


	private void registrarTurno() {
		String nombre = JOptionPane.showInputDialog(this, "Nombre del bibliotecario:");
		if (esEntradaValida(nombre)) {
			String horario = JOptionPane.showInputDialog(this, "Horario (ejemplo: 9:00 AM - 1:00 PM):");
			//Veridica si los datos del horario son correctos
			if (horario != null && horario.matches("\\d{1,2}:\\d{2} (AM|PM) - \\d{1,2}:\\d{2} (AM|PM)")) {
				turnos.agregarTurno(nombre, horario);
				JOptionPane.showMessageDialog(this, "Turno registrado correctamente.");
			} else {
				mostrarError("Formato de horario inválido. Ejemplo: 9:00 AM - 1:00 PM");
			}
		} else if (nombre != null) {
			mostrarError("Error. Datos incompletos.");
		}
	}

	private void mostrarTurnos() {
		JOptionPane.showMessageDialog(this, turnos.mostrarTurnos());
	}
	private void eliminarTurno() {
		String nombre = JOptionPane.showInputDialog(this, "Nombre del bibliotecario a eliminar:");
		if (nombre == null || nombre.trim().isEmpty()) {
			mostrarError("El nombre ingresado es inválido.");
			return; 
		}
		if (esEntradaValida(nombre)) { 
			boolean eliminado = turnos.eliminarTurno(nombre);
			if (eliminado) {
				JOptionPane.showMessageDialog(this, "Turno eliminado correctamente.");
			} else {
				mostrarError("No se encontró un turno con ese nombre.");
			}
		} else {
			mostrarError("El nombre ingresado es inválido.");
		}
	}
	private void registrarPrestamo() {
		String tituloLibro = JOptionPane.showInputDialog(this, "Título del libro:");
		if (tituloLibro == null) {
			return; 
		}
		if (esEntradaValida(tituloLibro)) {

			tituloLibro = tituloLibro.trim().toLowerCase();
			NodoLibro libroEncontrado = libros.buscarLibro(tituloLibro);
			if (libroEncontrado == null) {
				JOptionPane.showMessageDialog(this, "Error: El libro '" + tituloLibro + "' no está disponible en la biblioteca.");
				return; 
			}

			String usuario = JOptionPane.showInputDialog(this, "Nombre del usuario:");
			if (usuario == null || !esEntradaValida(usuario)) {
				mostrarError("El nombre del usuario es inválido.");
				return;
			}
			String fechaPrestamo = JOptionPane.showInputDialog(this, "Fecha de préstamo (ejemplo: 01/01/2025):");
			String fechaDevolucion = JOptionPane.showInputDialog(this, "Fecha de devolución (ejemplo: 15/01/2025):");
			if (fechaPrestamo == null || fechaDevolucion == null || !esEntradaValida(fechaPrestamo) || !esEntradaValida(fechaDevolucion)) {
				mostrarError("Las fechas ingresadas son inválidas.");
				return; 
			}
			try {

				prestamos.agregarPrestamo(tituloLibro, usuario, fechaPrestamo, fechaDevolucion);
				JOptionPane.showMessageDialog(this, "Préstamo registrado correctamente.");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Error al registrar el préstamo: " + e.getMessage());
				e.printStackTrace();
			}
		} else {
			mostrarError("El título del libro es inválido.");
		}
	}
	
	private void buscarPrestamos() {
		String criterio = JOptionPane.showInputDialog(this, "Ingrese el título o usuario del préstamo a buscar:");
		if (esEntradaValida(criterio)) {
			NodoPrestamo resultado = prestamos.buscarPrestamo(criterio);
			if (resultado != null) {
				JOptionPane.showMessageDialog(this, resultado.toString());
			} else {
				mostrarError("No se encontró un préstamo activo con ese criterio.");
			}
		} else {
			mostrarError("El criterio ingresado es inválido.");
		}
	}
	private void devolverLibro() {
		String tituloLibro = JOptionPane.showInputDialog(this, "Título del libro a devolver:");
		if (esEntradaValida(tituloLibro)) {
			NodoPrestamo prestamo = prestamos.buscarPrestamo(tituloLibro);
			if (prestamo != null) {
				prestamos.eliminarPrestamo(tituloLibro);
				historial.agregarHistorial(prestamo.getTitulo(), prestamo.getUsuario(),
						prestamo.getFechaPrestamo(), prestamo.getFechaDevolucion());
				JOptionPane.showMessageDialog(this, "Libro devuelto correctamente.");
			} else {
				mostrarError("No se encontró un préstamo activo con ese título.");
			}
		} else if (tituloLibro != null) {
			mostrarError("El título ingresado es inválido.");
		}
	}
	private void mostrarPrestamos() {
		JOptionPane.showMessageDialog(this, prestamos.mostrarPrestamos());
	}



	private void agregarLibro() {
		String titulo = JOptionPane.showInputDialog(this, "Título del libro:");

		if (esEntradaValida(titulo)) {
			String autor = JOptionPane.showInputDialog(this, "Autor del libro:");
			if (esEntradaValida(autor)) {

				libros.agregarLibro(titulo, autor);
				JOptionPane.showMessageDialog(this, "Libro agregado correctamente.");
			}else {
				mostrarError("Los datos ingresados son inválidos.");
			}
		}else if (titulo!=null) {
			mostrarError("Error. Datos incompletos.");
		}
	}
	private void mostrarLibros() {
		JOptionPane.showMessageDialog(this, libros.mostrarLibros());
	}
	private void eliminarLibro() {
		String titulo = JOptionPane.showInputDialog(this, "Título del libro a eliminar:");

		if (titulo == null || titulo.trim().isEmpty()) {
			mostrarError("El nombre ingresado es inválido.");
			return;
		}
		if (esEntradaValida(titulo)) {
			boolean eliminado = libros.eliminarLibro(titulo);
			if (eliminado) {
				JOptionPane.showMessageDialog(this, "Libro eliminado correctamente.");
			} else {
				mostrarError("No se encontró un libro con ese título.");
			}
		} else {
			mostrarError("El título ingresado es inválido.");
		}
	}

	private void mostrarHistorial() {
		JOptionPane.showMessageDialog(this, historial.mostrarHistorial());
	}
	private boolean esEntradaValida(String entrada) {
		return entrada != null && !entrada.trim().isEmpty();
	}
	private void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}
	private void SetDate() {
		LocalDate now = LocalDate.now();
		Locale spanishLocale = new Locale("es", "ES");
		Fecha.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es 'EEEE dd 'de' MMMM 'del' yyyy", spanishLocale)));
	}
}
