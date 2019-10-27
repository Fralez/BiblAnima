package presentacion;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import logica.Estudiante;
import logica.Libro;
import logica.Manejador;
import logica.Orientacion;
import logica.Prestamo;
import logica.TipoUsuario;
import logica.Usuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;

import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField loginInCedula;
	private JPasswordField loginInPassword;
	private JTextField TextApellido;
	private JTextField TextMail;
	private JTextField TextPass;
	private JTextField TextNombre;
	private JTextField TextCedula;
	private JTextField modificarUsuarioInNombre;
	private JTextField modificarUsuarioInApellido;
	private JTextField modificarUsuarioInMail;
	private JTextField modificarUsuarioInPassword;
	private Manejador man = Manejador.getInstance();
	private JTextField buscarUsuarioInCedula;
	private JTextField altaLibroTitulo;
	private JTextField altaLibroAniCode;
	private JTextField altaLibroCodigoISBN;
	private JTextField altaLibroAutor;
	private JTextField altaLibroEditorial;
	private JTextField altaLibroDescripcion;
	private JTextField altaLibroYearPubl;
	private JTextField altaLibroCantEjemplares;
	private JTextField altaLibroGenero;
	private JTextField altaLibroImagURL;
	private JTextField altaLibroNroEdicion;
	private JLabel listarLibrosTitulo;
	private JTextField altaPrestamoInFechaDev;

	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private LocalDateTime now = LocalDateTime.now();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public main() {
		setTitle("Bibl\u00C1nima");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setVisible(false);

		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);

		JMenu mnPrestamo = new JMenu("Pr\u00E9stamo");
		menuBar.add(mnPrestamo);

		JMenuItem mntmAltaPrestamo = new JMenuItem("Alta Prestamo");
		mnPrestamo.add(mntmAltaPrestamo);

		JMenuItem mntmConsultaPrestamo = new JMenuItem("Administrar Pr\u00E9stamos");
		mnPrestamo.add(mntmConsultaPrestamo);

		JMenu mnLibro = new JMenu("Libro");
		menuBar.add(mnLibro);

		JMenuItem mntmAltaLibro = new JMenuItem("Alta Libro");
		mnLibro.add(mntmAltaLibro);

		JMenuItem mntmListarLibro = new JMenuItem("Listar Libro");
		mnLibro.add(mntmListarLibro);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ArrayList<Usuario> usuarios = man.listarUsuariosExistentes();

		JPanel consultaPrestamo = new JPanel();
		consultaPrestamo.setBounds(0, 0, 434, 239);
		contentPane.add(consultaPrestamo);
		consultaPrestamo.setLayout(null);
		consultaPrestamo.setVisible(false);

		JLabel lblConsultaPrstamo = new JLabel("Administrar Pr\u00E9stamos");
		lblConsultaPrstamo.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
		lblConsultaPrstamo.setBounds(104, 11, 252, 28);
		consultaPrestamo.add(lblConsultaPrstamo);

		JComboBox consultaPrestamoComboCi = new JComboBox();
		consultaPrestamoComboCi.setBounds(104, 70, 230, 22);
		consultaPrestamo.add(consultaPrestamoComboCi);

		JLabel lblCiDelUsuario = new JLabel("CI del Usuario");
		lblCiDelUsuario.setBounds(183, 50, 97, 14);
		consultaPrestamo.add(lblCiDelUsuario);

		JLabel consultaPrestamoLblActivos = new JLabel("Activos:");
		consultaPrestamoLblActivos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		consultaPrestamoLblActivos.setBounds(57, 91, 74, 28);
		consultaPrestamo.add(consultaPrestamoLblActivos);

		JLabel consultaPrestamoLblHistorial = new JLabel("Historial:");
		consultaPrestamoLblHistorial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		consultaPrestamoLblHistorial.setBounds(320, 98, 74, 14);
		consultaPrestamo.add(consultaPrestamoLblHistorial);

		JComboBox consultaPrestamoComboActivos = new JComboBox();
		consultaPrestamoComboActivos.setBounds(10, 116, 145, 22);
		consultaPrestamo.add(consultaPrestamoComboActivos);

		JComboBox consultaPrestamoComboHistorial = new JComboBox();
		consultaPrestamoComboHistorial.setBounds(279, 116, 145, 22);
		consultaPrestamo.add(consultaPrestamoComboHistorial);

		JLabel lblAnicodeLibro_1 = new JLabel("AniCode Libro");
		lblAnicodeLibro_1.setBounds(10, 149, 82, 14);
		consultaPrestamo.add(lblAnicodeLibro_1);

		JLabel consultaPrestamoLblFechaSol = new JLabel("Fecha solicitado");
		consultaPrestamoLblFechaSol.setBounds(10, 167, 97, 14);
		consultaPrestamo.add(consultaPrestamoLblFechaSol);

		JLabel consultaPrestamoLblFechaDev = new JLabel("Fecha devoluci\u00F3n");
		consultaPrestamoLblFechaDev.setBounds(10, 188, 121, 14);
		consultaPrestamo.add(consultaPrestamoLblFechaDev);

		JLabel consultaPrestamoActivoFechaDev = new JLabel("...");
		consultaPrestamoActivoFechaDev.setBounds(114, 188, 97, 14);
		consultaPrestamo.add(consultaPrestamoActivoFechaDev);

		JLabel consultaPrestamoActivoFechaSol = new JLabel("...");
		consultaPrestamoActivoFechaSol.setBounds(104, 167, 82, 14);
		consultaPrestamo.add(consultaPrestamoActivoFechaSol);

		JLabel consultaPrestamoActivoAniCode = new JLabel("...");
		consultaPrestamoActivoAniCode.setBounds(104, 149, 82, 14);
		consultaPrestamo.add(consultaPrestamoActivoAniCode);

		JLabel consultaPrestamoHistorialFechaDev = new JLabel("...");
		consultaPrestamoHistorialFechaDev.setBounds(337, 188, 97, 14);
		consultaPrestamo.add(consultaPrestamoHistorialFechaDev);

		JLabel consultaPrestamoHistorialFechaSol = new JLabel("...");
		consultaPrestamoHistorialFechaSol.setBounds(327, 167, 82, 14);
		consultaPrestamo.add(consultaPrestamoHistorialFechaSol);

		JLabel consultaPrestamoHistorialAniCode = new JLabel("...");
		consultaPrestamoHistorialAniCode.setBounds(327, 149, 82, 14);
		consultaPrestamo.add(consultaPrestamoHistorialAniCode);

		JLabel label_8 = new JLabel("Fecha devoluci\u00F3n");
		label_8.setBounds(224, 188, 110, 14);
		consultaPrestamo.add(label_8);

		JLabel label_9 = new JLabel("Fecha solicitado");
		label_9.setBounds(224, 167, 93, 14);
		consultaPrestamo.add(label_9);

		JLabel label_10 = new JLabel("AniCode Libro");
		label_10.setBounds(224, 149, 82, 14);
		consultaPrestamo.add(label_10);
		
		JButton consultaPrestamoDarDeBaja = new JButton("Dar de baja");
		consultaPrestamoDarDeBaja.setBounds(10, 213, 145, 23);
		consultaPrestamo.add(consultaPrestamoDarDeBaja);

		JPanel altaPrestamo = new JPanel();
		altaPrestamo.setBounds(0, 0, 434, 239);
		contentPane.add(altaPrestamo);
		altaPrestamo.setLayout(null);
		altaPrestamo.setVisible(false);

		JLabel lblAltaPrestamo = new JLabel("Alta Pr\u00E9stamo");
		lblAltaPrestamo.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
		lblAltaPrestamo.setBounds(142, 11, 172, 28);
		altaPrestamo.add(lblAltaPrestamo);

		JComboBox altaPrestamoComboCi = new JComboBox();
		altaPrestamoComboCi.setBounds(244, 60, 155, 22);
		altaPrestamo.add(altaPrestamoComboCi);

		JComboBox altaPrestamoComboAniCode = new JComboBox();
		altaPrestamoComboAniCode.setBounds(244, 93, 155, 22);
		altaPrestamo.add(altaPrestamoComboAniCode);

		JLabel altaPrestamoLblUsuario = new JLabel("C\u00E9dula Usuario:");
		altaPrestamoLblUsuario.setBounds(29, 65, 191, 14);
		altaPrestamo.add(altaPrestamoLblUsuario);

		JLabel lblAnicodeLibro = new JLabel("AniCode Libro:");
		lblAnicodeLibro.setBounds(29, 97, 191, 14);
		altaPrestamo.add(lblAnicodeLibro);

		JButton btnCrear = new JButton("Crear");
		btnCrear.setBounds(169, 190, 89, 23);
		altaPrestamo.add(btnCrear);

		JLabel altaPrestamoLblFechaDev = new JLabel("Fecha devoluci\u00F3n:");
		altaPrestamoLblFechaDev.setBounds(29, 131, 191, 14);
		altaPrestamo.add(altaPrestamoLblFechaDev);

		altaPrestamoInFechaDev = new JTextField();
		altaPrestamoInFechaDev.setBounds(244, 128, 155, 20);
		altaPrestamo.add(altaPrestamoInFechaDev);
		altaPrestamoInFechaDev.setColumns(10);
		altaPrestamoInFechaDev.setText(dtf.format(now));

		JLabel lblFormatoDiamesao = new JLabel("Formato mes/d\u00EDa/a\u00F1o");
		lblFormatoDiamesao.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFormatoDiamesao.setBounds(244, 154, 191, 14);
		altaPrestamo.add(lblFormatoDiamesao);

		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String aniCode = altaPrestamoComboAniCode.getSelectedItem().toString();
					int ci = Integer.parseInt(altaPrestamoComboCi.getSelectedItem().toString());
					String sFechaDev = altaPrestamoInFechaDev.getText();

					Usuario usuario = man.consultaUsuario(ci);
					Libro libro = man.consultaLibro(aniCode);

					man.altaPrestamo(sFechaDev, usuario, libro);
					JOptionPane.showMessageDialog(null, "Has creado un préstamo correctamente :D!", "Creación exitosa",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					if (e1.getMessage().equals("No hay ejemplares disponibles")) {
						JOptionPane.showMessageDialog(null, "No hay ejemplares disponibles del libro seleccionado",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		JPanel altaUsuario = new JPanel();
		altaUsuario.setBounds(0, 0, 434, 240);
		contentPane.add(altaUsuario);
		altaUsuario.setLayout(null);

		JComboBox comboBox_1 = new JComboBox(TipoUsuario.values());
		comboBox_1.setBounds(92, 143, 121, 20);
		altaUsuario.add(comboBox_1);

		JLabel lblAltaUsuario = new JLabel("Alta Usuario");
		lblAltaUsuario.setBounds(151, 11, 121, 28);
		altaUsuario.add(lblAltaUsuario);
		lblAltaUsuario.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));

		TextApellido = new JTextField();
		TextApellido.setBounds(277, 50, 86, 20);
		altaUsuario.add(TextApellido);
		TextApellido.setColumns(10);

		TextMail = new JTextField();
		TextMail.setBounds(92, 81, 86, 20);
		altaUsuario.add(TextMail);
		TextMail.setColumns(10);

		TextPass = new JTextField();
		TextPass.setBounds(277, 81, 86, 20);
		altaUsuario.add(TextPass);
		TextPass.setColumns(10);

		TextNombre = new JTextField();
		TextNombre.setBounds(92, 50, 86, 20);
		altaUsuario.add(TextNombre);
		TextNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(37, 53, 45, 14);
		altaUsuario.add(lblNombre);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(216, 53, 56, 14);
		altaUsuario.add(lblApellido);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(55, 84, 27, 14);
		altaUsuario.add(lblMail);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(203, 84, 69, 14);
		altaUsuario.add(lblContrasea);

		TextCedula = new JTextField();
		TextCedula.setBounds(186, 112, 86, 20);
		altaUsuario.add(TextCedula);
		TextCedula.setColumns(10);

		JComboBox comboBox = new JComboBox(Orientacion.values());
		comboBox.setBounds(242, 143, 121, 20);
		altaUsuario.add(comboBox);

		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(127, 112, 46, 14);
		altaUsuario.add(lblCedula);

		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					man.altaUsuario(Integer.parseInt(TextCedula.getText()), TextNombre.getText(),
							TextApellido.getText(), TextMail.getText(), TextPass.getText(),
							(TipoUsuario) comboBox_1.getSelectedItem(), (Orientacion) comboBox.getSelectedItem());
					JOptionPane.showMessageDialog(null, "Has creado el usuario correctamente!", "Creación exitosa",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Has fallado en crear el usuario", "Creación fallida",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		btnAceptar.setBounds(241, 190, 115, 23);
		altaUsuario.add(btnAceptar);

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(92, 190, 115, 23);
		altaUsuario.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TextApellido.setText(null);
				TextMail.setText("");
				TextPass.setText(null);
				TextNombre.setText("");
				TextCedula.setText(null);
				comboBox_1.setSelectedIndex(0);

			}
		});

		// Set panels invisible except for first view panel
		altaUsuario.setVisible(false);

		JPanel modificarDatosUsuario = new JPanel();
		modificarDatosUsuario.setBounds(0, 0, 434, 240);
		contentPane.add(modificarDatosUsuario);
		modificarDatosUsuario.setLayout(null);

		JComboBox<Integer> modificarUsuarioCombo = new JComboBox<Integer>();

		modificarUsuarioCombo.setBounds(107, 66, 216, 20);
		modificarDatosUsuario.add(modificarUsuarioCombo);

		JLabel lblModificarDatosUsuario = new JLabel("Modificar Datos Usuario");
		lblModificarDatosUsuario.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
		lblModificarDatosUsuario.setBounds(97, 11, 261, 28);
		modificarDatosUsuario.add(lblModificarDatosUsuario);

		modificarUsuarioInNombre = new JTextField();
		modificarUsuarioInNombre.setColumns(10);
		modificarUsuarioInNombre.setBounds(97, 116, 86, 20);
		modificarDatosUsuario.add(modificarUsuarioInNombre);

		modificarUsuarioInApellido = new JTextField();
		modificarUsuarioInApellido.setColumns(10);
		modificarUsuarioInApellido.setBounds(97, 147, 86, 20);
		modificarDatosUsuario.add(modificarUsuarioInApellido);

		modificarUsuarioInMail = new JTextField();
		modificarUsuarioInMail.setColumns(10);
		modificarUsuarioInMail.setBounds(316, 116, 86, 20);
		modificarDatosUsuario.add(modificarUsuarioInMail);

		modificarUsuarioInPassword = new JTextField();
		modificarUsuarioInPassword.setColumns(10);
		modificarUsuarioInPassword.setBounds(316, 147, 86, 20);
		modificarDatosUsuario.add(modificarUsuarioInPassword);

		JLabel modificarUsuarioLblNombre = new JLabel("Nombre\r\n");
		modificarUsuarioLblNombre.setBounds(10, 119, 46, 14);
		modificarDatosUsuario.add(modificarUsuarioLblNombre);

		JLabel modificarUsuarioLblApellido = new JLabel("Apellido");
		modificarUsuarioLblApellido.setBounds(10, 150, 46, 14);
		modificarDatosUsuario.add(modificarUsuarioLblApellido);

		JLabel modificarUsuarioLblMail = new JLabel("Mail");
		modificarUsuarioLblMail.setBounds(232, 119, 46, 14);
		modificarDatosUsuario.add(modificarUsuarioLblMail);

		JLabel modificarUsuarioLblPassword = new JLabel("Password");
		modificarUsuarioLblPassword.setBounds(232, 147, 77, 14);
		modificarDatosUsuario.add(modificarUsuarioLblPassword);

		JLabel modificarUsuarioLblCedula = new JLabel("CEDULA");
		modificarUsuarioLblCedula.setBounds(195, 50, 46, 14);
		modificarDatosUsuario.add(modificarUsuarioLblCedula);

		JButton btnModificar = new JButton("Modificar");

		btnModificar.setBounds(117, 195, 201, 23);
		modificarDatosUsuario.add(btnModificar);
		modificarDatosUsuario.setVisible(false);

		modificarUsuarioCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String ci = modificarUsuarioCombo.getSelectedItem().toString();
					Usuario usuario = man.consultaUsuario(Integer.parseInt(ci));
					modificarUsuarioInNombre.setText(usuario.getNombre());
					modificarUsuarioInApellido.setText(usuario.getApellido());
					modificarUsuarioInMail.setText(usuario.getMail());
					modificarUsuarioInPassword.setText(usuario.getPassword());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado", "Error inesperado",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					man.modificarDatosUsuario(Integer.parseInt(modificarUsuarioCombo.getSelectedItem().toString()),
							modificarUsuarioInNombre.getText(), modificarUsuarioInApellido.getText(),
							modificarUsuarioInMail.getText(), modificarUsuarioInPassword.getText());
					JOptionPane.showMessageDialog(null, "Has modificado el usuario correctamente :D!",
							"Modificación exitosa", JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado", "Error inesperado",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JPanel consultaUsuario = new JPanel();
		consultaUsuario.setBounds(0, 0, 434, 240);
		contentPane.add(consultaUsuario);
		consultaUsuario.setLayout(null);

		JComboBox ConsultaUsuarioCombo = new JComboBox();
		ConsultaUsuarioCombo.setBounds(138, 72, 146, 20);
		consultaUsuario.add(ConsultaUsuarioCombo);

		JLabel lblConsultaUsuario = new JLabel("Consulta Usuario");
		lblConsultaUsuario.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
		lblConsultaUsuario.setBounds(138, 25, 212, 28);
		consultaUsuario.add(lblConsultaUsuario);

		JLabel consultaUsuarioLblNombre = new JLabel("Nombre\r\n:");
		consultaUsuarioLblNombre.setBounds(12, 113, 56, 14);
		consultaUsuario.add(consultaUsuarioLblNombre);

		JLabel consultaUsuarioLblApellido = new JLabel("Apellido:");
		consultaUsuarioLblApellido.setBounds(12, 138, 56, 14);
		consultaUsuario.add(consultaUsuarioLblApellido);

		JLabel consultaUsuarioLblMail = new JLabel("Mail");
		consultaUsuarioLblMail.setBounds(12, 163, 46, 14);
		consultaUsuario.add(consultaUsuarioLblMail);

		JLabel consultaUsuarioLblPassword = new JLabel("Password:");
		consultaUsuarioLblPassword.setBounds(12, 188, 77, 14);
		consultaUsuario.add(consultaUsuarioLblPassword);

		JLabel ConsultaUsuarioLblCedula = new JLabel("CEDULA");
		ConsultaUsuarioLblCedula.setBounds(201, 57, 46, 14);
		consultaUsuario.add(ConsultaUsuarioLblCedula);

		JLabel consultaUsuarioNombre = new JLabel("...");
		consultaUsuarioNombre.setBounds(95, 113, 189, 14);
		consultaUsuario.add(consultaUsuarioNombre);

		JLabel consultaUsuarioApellido = new JLabel("...");
		consultaUsuarioApellido.setBounds(95, 138, 189, 14);
		consultaUsuario.add(consultaUsuarioApellido);

		JLabel consultaUsuarioMail = new JLabel("...");
		consultaUsuarioMail.setBounds(95, 163, 189, 14);
		consultaUsuario.add(consultaUsuarioMail);

		JLabel consultaUsuarioPassword = new JLabel("...");
		consultaUsuarioPassword.setBounds(95, 188, 189, 14);
		consultaUsuario.add(consultaUsuarioPassword);
		consultaUsuario.setVisible(false);

		ConsultaUsuarioCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ci = ConsultaUsuarioCombo.getSelectedItem().toString();
				Usuario usuario = man.consultaUsuario(Integer.parseInt(ci));
				consultaUsuarioNombre.setText(usuario.getNombre());
				consultaUsuarioApellido.setText(usuario.getApellido());
				consultaUsuarioMail.setText(usuario.getMail());
				consultaUsuarioPassword.setText(usuario.getPassword());
			}
		});

		JPanel listarUsuariosExistentes = new JPanel();
		listarUsuariosExistentes.setBounds(0, 0, 434, 240);
		contentPane.add(listarUsuariosExistentes);
		listarUsuariosExistentes.setLayout(null);

		JLabel lblListarUsuarios = new JLabel("Listar Usuarios\r\n");
		lblListarUsuarios.setBounds(132, 11, 167, 28);
		lblListarUsuarios.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
		listarUsuariosExistentes.add(lblListarUsuarios);

		JList<Object> list = new JList<Object>();
		list.setBounds(409, 220, -382, -139);
		listarUsuariosExistentes.add(list);

		JComboBox<String> listarUsuariosCombo = new JComboBox<String>();
		listarUsuariosCombo.setBounds(38, 64, 354, 28);
		listarUsuariosExistentes.add(listarUsuariosCombo);
		listarUsuariosExistentes.setVisible(false);

		JPanel buscarUsuario = new JPanel();
		buscarUsuario.setBounds(0, 0, 434, 240);
		contentPane.add(buscarUsuario);
		buscarUsuario.setLayout(null);
		buscarUsuario.setVisible(false);

		JLabel lblBuscarUsuario = new JLabel("Buscar Usuario");
		lblBuscarUsuario.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
		lblBuscarUsuario.setBounds(141, 11, 212, 28);
		buscarUsuario.add(lblBuscarUsuario);

		JLabel buscarUsuarioLblNombre = new JLabel("Nombre\r\n:");
		buscarUsuarioLblNombre.setBounds(10, 131, 56, 14);
		buscarUsuario.add(buscarUsuarioLblNombre);

		JLabel buscarUsuarioLblApellido = new JLabel("Apellido:");
		buscarUsuarioLblApellido.setBounds(10, 152, 56, 14);
		buscarUsuario.add(buscarUsuarioLblApellido);

		JLabel buscarUsuarioLblMail = new JLabel("Mail");
		buscarUsuarioLblMail.setBounds(10, 173, 46, 14);
		buscarUsuario.add(buscarUsuarioLblMail);

		JLabel buscarUsuarioLblPasword = new JLabel("Password:");
		buscarUsuarioLblPasword.setBounds(10, 191, 77, 14);
		buscarUsuario.add(buscarUsuarioLblPasword);

		JLabel buscarUsuarioLblCedula = new JLabel("CEDULA");
		buscarUsuarioLblCedula.setBounds(90, 56, 46, 14);
		buscarUsuario.add(buscarUsuarioLblCedula);

		JLabel buscarUsuarioNombre = new JLabel("...");
		buscarUsuarioNombre.setBounds(85, 130, 189, 14);
		buscarUsuario.add(buscarUsuarioNombre);

		JLabel buscarUsuarioApellido = new JLabel("...");
		buscarUsuarioApellido.setBounds(85, 151, 189, 14);
		buscarUsuario.add(buscarUsuarioApellido);

		JLabel buscarUsuarioMail = new JLabel("...");
		buscarUsuarioMail.setBounds(86, 171, 189, 14);
		buscarUsuario.add(buscarUsuarioMail);

		JLabel buscarUsuarioPassword = new JLabel("...");
		buscarUsuarioPassword.setBounds(88, 190, 189, 14);
		buscarUsuario.add(buscarUsuarioPassword);

		buscarUsuarioInCedula = new JTextField();
		buscarUsuarioInCedula.setBounds(146, 54, 131, 20);
		buscarUsuario.add(buscarUsuarioInCedula);
		buscarUsuarioInCedula.setColumns(10);

		JButton buscarUsuarioBtnBuscar = new JButton("Buscar");
		buscarUsuarioBtnBuscar.setBounds(287, 53, 89, 23);
		buscarUsuario.add(buscarUsuarioBtnBuscar);

		buscarUsuarioBtnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int ci = Integer.parseInt(buscarUsuarioInCedula.getText());
					Usuario usuario = man.consultaUsuario(ci);
					buscarUsuarioNombre.setText(usuario.getNombre());
					buscarUsuarioApellido.setText(usuario.getApellido());
					buscarUsuarioMail.setText(usuario.getMail());
					buscarUsuarioPassword.setText(usuario.getPassword());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,
							"Ha ocurrido un error inesperado. Verifique la cedula ingresada.", "Error inesperado",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JPanel listarLibros = new JPanel();
		listarLibros.setBounds(0, 0, 434, 240);
		contentPane.add(listarLibros);
		listarLibros.setLayout(null);
		listarLibros.setVisible(false);

		JLabel lblListarLibros = new JLabel("Listar Libros");
		lblListarLibros.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
		lblListarLibros.setBounds(156, 11, 121, 28);
		listarLibros.add(lblListarLibros);

		JLabel listarLibrosLblTitulo = new JLabel("Titulo");
		listarLibrosLblTitulo.setBounds(42, 97, 46, 14);
		listarLibros.add(listarLibrosLblTitulo);

		JLabel listarLibrosLblCodigoISBN = new JLabel("codigoISBN");
		listarLibrosLblCodigoISBN.setBounds(42, 122, 70, 14);
		listarLibros.add(listarLibrosLblCodigoISBN);

		JLabel listarLibrosLblAutor = new JLabel("Autor");
		listarLibrosLblAutor.setBounds(42, 147, 46, 14);
		listarLibros.add(listarLibrosLblAutor);

		JLabel listarLibrosLblEditorial = new JLabel("Editorial");
		listarLibrosLblEditorial.setBounds(42, 169, 46, 14);
		listarLibros.add(listarLibrosLblEditorial);

		JLabel listarLibrosLblDescripcion = new JLabel("Descripci\u00F3n");
		listarLibrosLblDescripcion.setBounds(42, 190, 61, 14);
		listarLibros.add(listarLibrosLblDescripcion);

		JLabel listarLibrosLblYearPubl = new JLabel("A\u00F1o de publ.");
		listarLibrosLblYearPubl.setBounds(224, 97, 86, 14);
		listarLibros.add(listarLibrosLblYearPubl);

		JLabel listarLibrosLblCantEjemplares = new JLabel("N\u00B0 de ejemplares");
		listarLibrosLblCantEjemplares.setBounds(224, 122, 86, 14);
		listarLibros.add(listarLibrosLblCantEjemplares);

		JLabel listarLibrosLblGenero = new JLabel("G\u00E9nero");
		listarLibrosLblGenero.setBounds(224, 147, 46, 14);
		listarLibros.add(listarLibrosLblGenero);

		JLabel listarLibrosLblImagURL = new JLabel("Imagen URL");
		listarLibrosLblImagURL.setBounds(224, 172, 86, 14);
		listarLibros.add(listarLibrosLblImagURL);

		JLabel listarLibrosLblNroEdicion = new JLabel("N\u00B0 de edici\u00F3n");
		listarLibrosLblNroEdicion.setBounds(224, 197, 86, 14);
		listarLibros.add(listarLibrosLblNroEdicion);

		listarLibrosTitulo = new JLabel("...");
		listarLibrosTitulo.setBounds(135, 97, 46, 14);
		listarLibros.add(listarLibrosTitulo);

		JLabel listarLibrosCodigoISBN = new JLabel("...");
		listarLibrosCodigoISBN.setBounds(135, 122, 70, 14);
		listarLibros.add(listarLibrosCodigoISBN);

		JLabel listarLibrosAutor = new JLabel("...");
		listarLibrosAutor.setBounds(135, 147, 46, 14);
		listarLibros.add(listarLibrosAutor);

		JLabel listarLibrosEditorial = new JLabel("...");
		listarLibrosEditorial.setBounds(135, 169, 46, 14);
		listarLibros.add(listarLibrosEditorial);

		JLabel listarLibrosDescripcion = new JLabel("...");
		listarLibrosDescripcion.setBounds(135, 190, 61, 14);
		listarLibros.add(listarLibrosDescripcion);

		JLabel listarLibrosYearPubl = new JLabel("...");
		listarLibrosYearPubl.setBounds(317, 97, 86, 14);
		listarLibros.add(listarLibrosYearPubl);

		JLabel listarLibrosCantEjemplares = new JLabel("...");
		listarLibrosCantEjemplares.setBounds(317, 122, 86, 14);
		listarLibros.add(listarLibrosCantEjemplares);

		JLabel listarLibrosGenero = new JLabel("...");
		listarLibrosGenero.setBounds(317, 147, 46, 14);
		listarLibros.add(listarLibrosGenero);

		JLabel listarLibrosImagURL = new JLabel("...");
		listarLibrosImagURL.setBounds(317, 172, 86, 14);
		listarLibros.add(listarLibrosImagURL);

		JLabel listarLibrosNroEdicion = new JLabel("...");
		listarLibrosNroEdicion.setBounds(317, 197, 86, 14);
		listarLibros.add(listarLibrosNroEdicion);

		JComboBox listarLibrosCombo = new JComboBox();
		listarLibrosCombo.setBounds(135, 50, 163, 22);
		listarLibros.add(listarLibrosCombo);

		JLabel lblAnicode_1 = new JLabel("AniCode:");
		lblAnicode_1.setBounds(66, 54, 46, 14);
		listarLibros.add(lblAnicode_1);

		listarLibrosCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Libro libro = man.consultaLibro(listarLibrosCombo.getSelectedItem().toString());
					listarLibrosTitulo.setText(libro.getTitulo());
					listarLibrosAutor.setText(libro.getAniCode());
					listarLibrosCantEjemplares.setText(Integer.toString(libro.getCantEjemplares()));
					listarLibrosCodigoISBN.setText(libro.getCodigoISBN());
					listarLibrosDescripcion.setText(libro.getDescripcion());
					listarLibrosEditorial.setText(libro.getEditorial());
					listarLibrosGenero.setText(libro.getGenero());
					listarLibrosImagURL.setText(libro.getImagURL());
					listarLibrosNroEdicion.setText(Integer.toString(libro.getNroEdicion()));
					listarLibrosYearPubl.setText(Integer.toString(libro.getYearPubl()));

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado", "Error inesperado",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JPanel altaLibro = new JPanel();
		altaLibro.setBounds(0, 0, 434, 240);
		contentPane.add(altaLibro);
		altaLibro.setLayout(null);
		altaLibro.setVisible(false);

		JLabel altaLibroLblAlta = new JLabel("Alta Libro");
		altaLibroLblAlta.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
		altaLibroLblAlta.setBounds(153, 0, 121, 28);
		altaLibro.add(altaLibroLblAlta);

		altaLibroTitulo = new JTextField();
		altaLibroTitulo.setBounds(81, 40, 86, 20);
		altaLibro.add(altaLibroTitulo);
		altaLibroTitulo.setColumns(10);

		altaLibroAniCode = new JTextField();
		altaLibroAniCode.setBounds(81, 71, 86, 20);
		altaLibro.add(altaLibroAniCode);
		altaLibroAniCode.setColumns(10);

		altaLibroCodigoISBN = new JTextField();
		altaLibroCodigoISBN.setBounds(81, 102, 86, 20);
		altaLibro.add(altaLibroCodigoISBN);
		altaLibroCodigoISBN.setColumns(10);

		altaLibroAutor = new JTextField();
		altaLibroAutor.setBounds(81, 133, 86, 20);
		altaLibro.add(altaLibroAutor);
		altaLibroAutor.setColumns(10);

		altaLibroEditorial = new JTextField();
		altaLibroEditorial.setBounds(81, 164, 86, 20);
		altaLibro.add(altaLibroEditorial);
		altaLibroEditorial.setColumns(10);

		altaLibroDescripcion = new JTextField();
		altaLibroDescripcion.setBounds(81, 195, 86, 20);
		altaLibro.add(altaLibroDescripcion);
		altaLibroDescripcion.setColumns(10);

		altaLibroYearPubl = new JTextField();
		altaLibroYearPubl.setBounds(288, 40, 86, 20);
		altaLibro.add(altaLibroYearPubl);
		altaLibroYearPubl.setColumns(10);

		altaLibroCantEjemplares = new JTextField();
		altaLibroCantEjemplares.setBounds(288, 71, 86, 20);
		altaLibro.add(altaLibroCantEjemplares);
		altaLibroCantEjemplares.setColumns(10);

		altaLibroGenero = new JTextField();
		altaLibroGenero.setBounds(288, 102, 86, 20);
		altaLibro.add(altaLibroGenero);
		altaLibroGenero.setColumns(10);

		altaLibroImagURL = new JTextField();
		altaLibroImagURL.setBounds(288, 133, 86, 20);
		altaLibro.add(altaLibroImagURL);
		altaLibroImagURL.setColumns(10);

		altaLibroNroEdicion = new JTextField();
		altaLibroNroEdicion.setBounds(288, 164, 86, 20);
		altaLibro.add(altaLibroNroEdicion);
		altaLibroNroEdicion.setColumns(10);

		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(17, 36, 54, 28);
		altaLibro.add(lblTitulo);

		JLabel lblAnicode = new JLabel("aniCode");
		lblAnicode.setBounds(17, 74, 46, 14);
		altaLibro.add(lblAnicode);

		JLabel lblCodigoisbn = new JLabel("codigoISBN");
		lblCodigoisbn.setBounds(10, 105, 70, 14);
		altaLibro.add(lblCodigoisbn);

		JButton altaLibroBtnCrear = new JButton("Crear");
		altaLibroBtnCrear.setBounds(285, 194, 89, 23);
		altaLibro.add(altaLibroBtnCrear);

		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(10, 136, 46, 14);
		altaLibro.add(lblAutor);

		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(10, 167, 46, 14);
		altaLibro.add(lblEditorial);

		JLabel lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(10, 198, 61, 14);
		altaLibro.add(lblDescripcion);

		JLabel lblAoDePubl = new JLabel("A\u00F1o de publ.");
		lblAoDePubl.setBounds(192, 43, 86, 14);
		altaLibro.add(lblAoDePubl);

		JLabel lblNDeEjemplares = new JLabel("N\u00B0 de ejemplares");
		lblNDeEjemplares.setBounds(192, 74, 86, 14);
		altaLibro.add(lblNDeEjemplares);

		JLabel lblGnero = new JLabel("G\u00E9nero");
		lblGnero.setBounds(192, 105, 46, 14);
		altaLibro.add(lblGnero);

		JLabel lblImagenUrl = new JLabel("Imagen URL");
		lblImagenUrl.setBounds(192, 136, 86, 14);
		altaLibro.add(lblImagenUrl);

		JLabel lblNDeEdicin = new JLabel("N\u00B0 de edici\u00F3n");
		lblNDeEdicin.setBounds(192, 170, 86, 14);
		altaLibro.add(lblNDeEdicin);

		altaLibroBtnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					man.altaLibro(altaLibroAniCode.getText(), altaLibroAutor.getText(),
							Integer.parseInt(altaLibroYearPubl.getText()),
							Integer.parseInt(altaLibroNroEdicion.getText()), altaLibroEditorial.getText(),
							altaLibroDescripcion.getText(), Integer.parseInt(altaLibroCantEjemplares.getText()), true,
							altaLibroCodigoISBN.getText(), altaLibroGenero.getText(), altaLibroImagURL.getText(),
							altaLibroTitulo.getText());

					JOptionPane.showMessageDialog(null, "Has creado el libro correctamente!", "Creación exitosa",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Has fallado en crear el libro", "Creación fallida",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JPanel login = new JPanel();
		login.setBounds(0, 0, 434, 240);
		contentPane.add(login);
		login.setLayout(null);

		JLabel lblBiblnima = new JLabel("Bibl\u00C1nima\r\n");
		lblBiblnima.setBounds(173, 11, 121, 28);
		lblBiblnima.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
		login.add(lblBiblnima);

		JButton loginBtnIngresar = new JButton("Ingresar");
		loginBtnIngresar.setBounds(173, 183, 89, 23);
		login.add(loginBtnIngresar);
		loginBtnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String ci = loginInCedula.getText();
				char clave[] = loginInPassword.getPassword();
				String claveString = new String(clave);
				try {
					if (man.login(Integer.parseInt(ci), claveString)) {

						this.dispose();

						JOptionPane.showMessageDialog(null,
								"Bienvenido\n Has ingresado " + "satisfactoriamente al sistema",
								"Mensaje de bienvenida", JOptionPane.INFORMATION_MESSAGE);

						menuBar.setVisible(true);
						login.setVisible(false);

					} else {
						JOptionPane.showMessageDialog(null,
								"Acceso denegado:\n" + "Por favor ingrese un usuario y/o contraseña correctos",
								"Acceso denegado", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,
							"Acceso denegado:\n" + "Por favor ingrese un usuario y/o contraseña correctos",
							"Acceso denegado", JOptionPane.ERROR_MESSAGE);
				}

			}

			private void dispose() {
			}

		});

		loginInCedula = new JTextField();
		loginInCedula.setBounds(175, 72, 145, 20);
		login.add(loginInCedula);
		loginInCedula.setColumns(10);

		loginInPassword = new JPasswordField();
		loginInPassword.setBounds(175, 115, 145, 23);
		login.add(loginInPassword);

		JLabel loginLblCedula = new JLabel("Cedula");
		loginLblCedula.setBounds(63, 75, 102, 14);
		login.add(loginLblCedula);

		JLabel loginLblPassword = new JLabel("Password");
		loginLblPassword.setBounds(63, 119, 106, 14);
		login.add(loginLblPassword);
		login.setVisible(true);

		// Listar usuarios en todos lados
		for (int i = 0; i < man.listarUsuariosExistentes().size(); i++) {
			listarUsuariosCombo.addItem(man.listarUsuariosExistentes().get(i).getMail());
			modificarUsuarioCombo.addItem(man.listarUsuariosExistentes().get(i).getCi());
			ConsultaUsuarioCombo.addItem(man.listarUsuariosExistentes().get(i).getCi());
			altaPrestamoComboCi.addItem(man.listarUsuariosExistentes().get(i).getCi());
			consultaPrestamoComboCi.addItem(man.listarUsuariosExistentes().get(i).getCi());
		}

		for (int i = 0; i < man.listarLibrosExistentes().size(); i++) {
			listarLibrosCombo.addItem(man.listarLibrosExistentes().get(i).getAniCode());
			altaPrestamoComboAniCode.addItem(man.listarLibrosExistentes().get(i).getAniCode());
		}

		JMenuItem mntmConsultaUsuario = new JMenuItem("Consulta Usuario");
		mntmConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(false);
				consultaUsuario.setVisible(true);
				modificarDatosUsuario.setVisible(false);
				buscarUsuario.setVisible(false);
				listarUsuariosExistentes.setVisible(false);
				login.setVisible(false);
				altaLibro.setVisible(false);
				listarLibros.setVisible(false);
				altaPrestamo.setVisible(false);
				consultaPrestamo.setVisible(false);
			}
		});

		JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");
		mntmAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(true);
				consultaUsuario.setVisible(false);
				modificarDatosUsuario.setVisible(false);
				buscarUsuario.setVisible(false);
				listarUsuariosExistentes.setVisible(false);
				login.setVisible(false);
				altaLibro.setVisible(false);
				listarLibros.setVisible(false);
				altaPrestamo.setVisible(false);
				consultaPrestamo.setVisible(false);
			}
		});
		mnUsuario.add(mntmAltaUsuario);
		mnUsuario.add(mntmConsultaUsuario);

		JMenuItem mntmBuscarUsuario = new JMenuItem("Buscar Usuario");
		mntmBuscarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(false);
				consultaUsuario.setVisible(false);
				modificarDatosUsuario.setVisible(false);
				buscarUsuario.setVisible(true);
				listarUsuariosExistentes.setVisible(false);
				login.setVisible(false);
				altaLibro.setVisible(false);
				listarLibros.setVisible(false);
				altaPrestamo.setVisible(false);
				consultaPrestamo.setVisible(false);
			}
		});
		mnUsuario.add(mntmBuscarUsuario);

		JMenuItem mntmModificarDatos = new JMenuItem("Modificar Datos");
		mntmModificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(false);
				consultaUsuario.setVisible(false);
				modificarDatosUsuario.setVisible(true);
				buscarUsuario.setVisible(false);
				listarUsuariosExistentes.setVisible(false);
				login.setVisible(false);
				altaLibro.setVisible(false);
				listarLibros.setVisible(false);
				altaPrestamo.setVisible(false);
				consultaPrestamo.setVisible(false);
			}
		});
		mnUsuario.add(mntmModificarDatos);
		
		consultaPrestamoComboCi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultaPrestamoComboHistorial.removeAllItems();
				consultaPrestamoComboActivos.removeAllItems();
				consultaPrestamoActivoAniCode.setText("...");
				consultaPrestamoActivoFechaSol.setText("...");
				consultaPrestamoActivoFechaDev.setText("...");
				consultaPrestamoHistorialAniCode.setText("...");
				consultaPrestamoHistorialFechaSol.setText("...");
				consultaPrestamoHistorialFechaDev.setText("...");
				int ci = Integer.parseInt(consultaPrestamoComboCi.getSelectedItem().toString());
				Usuario usuario = man.consultaUsuario(ci);
				for (int i = 0; i < usuario.getPrestamos().size(); i++) {
					if (usuario.getPrestamos().get(i).getDevuelto()) {
						consultaPrestamoComboHistorial.addItem(usuario.getPrestamos().get(i).getId());
					} else {
						consultaPrestamoComboActivos.addItem(usuario.getPrestamos().get(i).getId());
					}
				}
			}
		});

		consultaPrestamoComboActivos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					int id = Integer.parseInt(consultaPrestamoComboActivos.getSelectedItem().toString());
					Prestamo pres = man.consultaPrestamo(id);
					consultaPrestamoActivoAniCode.setText(pres.getLibro().getAniCode());
					consultaPrestamoActivoFechaSol.setText(formatter.format(pres.getFechaSolicitado()));
					consultaPrestamoActivoFechaDev.setText(formatter.format(pres.getFechaDevolucion()));
				} catch (Exception e2) {

				}
			}
		});

		consultaPrestamoComboHistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
					int id = Integer.parseInt(consultaPrestamoComboHistorial.getSelectedItem().toString());
					Prestamo pres = man.consultaPrestamo(id);
					consultaPrestamoHistorialAniCode.setText(pres.getLibro().getAniCode());
					consultaPrestamoHistorialFechaSol.setText(formatter.format(pres.getFechaSolicitado()));
					consultaPrestamoHistorialFechaDev.setText(formatter.format(pres.getFechaDevolucion()));
				} catch (Exception e2) {

				}
			}
		});
		
		consultaPrestamoDarDeBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(consultaPrestamoComboActivos.getSelectedItem().toString());
				Prestamo pres = man.consultaPrestamo(id);
				man.darDeBajaUnPrestamo(pres);
			}
		});

		JMenuItem mntmListaDeUsuarios = new JMenuItem("Lista de Usuarios");
		mntmListaDeUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(false);
				consultaUsuario.setVisible(false);
				modificarDatosUsuario.setVisible(false);
				buscarUsuario.setVisible(false);
				listarUsuariosExistentes.setVisible(true);
				login.setVisible(false);
				altaLibro.setVisible(false);
				listarLibros.setVisible(false);
				altaPrestamo.setVisible(false);
				consultaPrestamo.setVisible(false);
			}
		});
		mnUsuario.add(mntmListaDeUsuarios);

		mntmAltaLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(false);
				consultaUsuario.setVisible(false);
				modificarDatosUsuario.setVisible(false);
				buscarUsuario.setVisible(false);
				listarUsuariosExistentes.setVisible(false);
				login.setVisible(false);
				altaLibro.setVisible(true);
				listarLibros.setVisible(false);
				altaPrestamo.setVisible(false);
				consultaPrestamo.setVisible(false);
			}
		});

		mntmListarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(false);
				consultaUsuario.setVisible(false);
				modificarDatosUsuario.setVisible(false);
				buscarUsuario.setVisible(false);
				listarUsuariosExistentes.setVisible(false);
				login.setVisible(false);
				altaLibro.setVisible(false);
				listarLibros.setVisible(true);
				altaPrestamo.setVisible(false);
				consultaPrestamo.setVisible(false);
			}
		});

		mntmAltaPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(false);
				consultaUsuario.setVisible(false);
				modificarDatosUsuario.setVisible(false);
				buscarUsuario.setVisible(false);
				listarUsuariosExistentes.setVisible(false);
				login.setVisible(false);
				altaLibro.setVisible(false);
				listarLibros.setVisible(false);
				altaPrestamo.setVisible(true);
				consultaPrestamo.setVisible(false);
			}
		});

		mntmConsultaPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(false);
				consultaUsuario.setVisible(false);
				modificarDatosUsuario.setVisible(false);
				buscarUsuario.setVisible(false);
				listarUsuariosExistentes.setVisible(false);
				login.setVisible(false);
				altaLibro.setVisible(false);
				listarLibros.setVisible(false);
				altaPrestamo.setVisible(false);
				consultaPrestamo.setVisible(true);
			}
		});

		class ComboBoxSelectionChange extends JFrame {
			public ComboBoxSelectionChange() {
				initialize();
			}

			private void initialize() {
				setSize(300, 300);
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				setLayout(new FlowLayout(FlowLayout.LEFT));

				for (int i = 0; i < usuarios.size(); i++) {
					ConsultaUsuarioCombo.addItem(usuarios.get(i).getCi());
				}

				final JTextArea textArea = new JTextArea(5, 15);
				textArea.setBorder(new BevelBorder(BevelBorder.LOWERED));

				// For listening to the changes of the selected items in the combo box
				// we need to add an ItemListener to the combo box component as shown
				// below.
				ConsultaUsuarioCombo.addItemListener(new ItemListener() {
					// Listening if a new items of the combo box has been selected.
					public void itemStateChanged(ItemEvent event) {
						// JComboBox comboBox = (JComboBox) event.getSource();

						// The item affected by the event.
						Object item = event.getItem();

						textArea.setText("Affected items: " + item.toString());

						if (event.getStateChange() == ItemEvent.SELECTED) {
							textArea.setText(item.toString() + " selected.");
						}

						if (event.getStateChange() == ItemEvent.DESELECTED) {
							textArea.setText(item.toString() + " deselected.");
						}
					}
				});
				getContentPane().add(ConsultaUsuarioCombo);
				getContentPane().add(textArea);

			}
		}

	}
}
