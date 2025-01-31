package biblioteca;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passTxt = new JPasswordField();
	private JTextField userTxt = new JTextField();
	// private JTextField userTxt;
	// private JPasswordField passTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				VentanaPrincipal frame = new VentanaPrincipal();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBiblioteca = new JLabel("BIBLIOTECA");
		lblBiblioteca.setBounds(223, 10, 340, 45);
		contentPane.add(lblBiblioteca);
		lblBiblioteca.setBackground(new Color(0, 255, 0));
		lblBiblioteca.setForeground(new Color(255, 255, 255));
		lblBiblioteca.setHorizontalAlignment(SwingConstants.CENTER);
		lblBiblioteca.setFont(new Font("Engravers MT", Font.BOLD, 33));

		JLabel Iniciarsesion = new JLabel("INICIAR SESIÓN");
		Iniciarsesion.setForeground(new Color(86, 171, 171));
		Iniciarsesion.setHorizontalAlignment(SwingConstants.CENTER);
		Iniciarsesion.setFont(new Font("Roboto SemiCondensed Black", Font.BOLD | Font.ITALIC, 24));
		Iniciarsesion.setBounds(308, 102, 183, 31);
		contentPane.add(Iniciarsesion);

		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Roboto Medium", Font.BOLD | Font.ITALIC, 18));
		lblUsuario.setBounds(219, 143, 348, 25);
		contentPane.add(lblUsuario);

	
		userTxt.setBackground(new Color(255, 255, 255));
		userTxt.setFont(new Font("Microsoft Tai Le", Font.BOLD, 16));
		userTxt.setForeground(new Color(62, 62, 62));
		userTxt.setBounds(219, 178, 348, 39);
		contentPane.add(userTxt);
		userTxt.setColumns(10);

		JLabel lblContraseña = new JLabel("CONTRASEÑA");
		lblContraseña.setForeground(new Color(255, 255, 255));
		lblContraseña.setFont(new Font("Roboto Medium", Font.BOLD | Font.ITALIC, 18));
		lblContraseña.setBounds(219, 227, 348, 25);
		contentPane.add(lblContraseña);

		
		passTxt.setFont(new Font("Roboto SemiBold", Font.BOLD, 15));
		passTxt.setForeground(new Color(62, 62, 62));
		passTxt.setBackground(new Color(255, 255, 255));
		passTxt.setBounds(219, 262, 348, 39);
		contentPane.add(passTxt);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(336, 324, 113, 44);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblIngresar = new JLabel("INGRESAR");
		  lblIngresar.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseClicked(MouseEvent e) {
		            verificarCredenciales();
		        }
		    });

		lblIngresar.setForeground(new Color(255, 255, 255));
		lblIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngresar.setFont(new Font("Eras Bold ITC", Font.PLAIN, 18));
		lblIngresar.setBounds(0, 0, 113, 44);
		panel.add(lblIngresar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/imagenes/Fondo.jpg")));
		lblNewLabel.setBounds(0, 0, 786, 463);
		contentPane.add(lblNewLabel);
		
	}
	  private void verificarCredenciales() {
	        String usuario = userTxt.getText();
	        String contraseña = String.valueOf(passTxt.getPassword());
	        if (usuario.equals("admin") && contraseña.equals("1234")) {
	            dispose();
	            // Llamar al nuevo método en lugar de main
	            GestionBiblioteca.abrirVentana();
	        } else {
	            JOptionPane.showMessageDialog(VentanaPrincipal.this, 
	                "Usuario o contraseña incorrectos, intente de nuevo", 
	                "Error", 
	                JOptionPane.ERROR_MESSAGE);
	        }
	    }
}


