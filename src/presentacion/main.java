package presentacion;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import persistencia.Conn;
import logica.Manejador;
import logica.Orientacion;
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
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField TextApellido;
	private JTextField TextMail;
	private JTextField TextPass;
	private JTextField TextNombre;
	private JTextField TextCedula;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private Manejador man = Manejador.getInstance();
	private JTextField userField;
	private JPasswordField passField;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setVisible(false);

		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);

		JMenu mnPrestamo = new JMenu("Prestamo");
		menuBar.add(mnPrestamo);

		JMenuItem mntmAltaPrestamo = new JMenuItem("Alta Prestamo");
		mnPrestamo.add(mntmAltaPrestamo);

		JMenuItem mntmConsultaPrestamo = new JMenuItem("Consulta Prestamo");
		mnPrestamo.add(mntmConsultaPrestamo);

		JMenuItem mntmListarPrestamo = new JMenuItem("Listar Prestamo");
		mnPrestamo.add(mntmListarPrestamo);

		JMenuItem mntmBajaPrestamo = new JMenuItem("Baja Prestamo");
		mnPrestamo.add(mntmBajaPrestamo);

		JMenu mnNotificaciones = new JMenu("Notificaciones");
		menuBar.add(mnNotificaciones);

		JMenuItem mntmAltaNotificaciones = new JMenuItem("Alta Notificaciones");
		mnNotificaciones.add(mntmAltaNotificaciones);

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

		JPanel consultaUsuario = new JPanel();
		consultaUsuario.setBounds(0, 0, 434, 240);
		contentPane.add(consultaUsuario);
		consultaUsuario.setLayout(null);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(138, 72, 146, 20);
		consultaUsuario.add(comboBox_2);
		ArrayList<Usuario> usuarios = man.listarUsuariosExistentes();
		for (int i = 0; i < usuarios.size(); i++) {
			System.out.println(usuarios.get(i).getCi());
			comboBox_2.addItem(usuarios.get(i).getCi());
		}

		comboBox_2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				actionPerformed(evt);

			}
		});

		JLabel lblConsultaUsuario = new JLabel("Consulta Usuario");
		lblConsultaUsuario.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
		lblConsultaUsuario.setBounds(138, 25, 212, 28);
		consultaUsuario.add(lblConsultaUsuario);

		textField = new JTextField();
		textField.setBounds(68, 124, 86, 20);
		consultaUsuario.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(264, 124, 86, 20);
		consultaUsuario.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(68, 155, 86, 20);
		consultaUsuario.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(68, 186, 86, 20);
		consultaUsuario.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(264, 155, 86, 20);
		consultaUsuario.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(264, 186, 86, 20);
		consultaUsuario.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblNombre_1 = new JLabel("Nombre\r\n");
		lblNombre_1.setBounds(10, 127, 46, 14);
		consultaUsuario.add(lblNombre_1);

		JLabel lblApellido_1 = new JLabel("Apellido");
		lblApellido_1.setBounds(12, 158, 46, 14);
		consultaUsuario.add(lblApellido_1);

		JLabel lblMail_1 = new JLabel("Mail");
		lblMail_1.setBounds(22, 189, 46, 14);
		consultaUsuario.add(lblMail_1);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(209, 127, 46, 14);
		consultaUsuario.add(lblPassword);

		JLabel lblTipousuario = new JLabel("TipoUsuario");
		lblTipousuario.setBounds(201, 158, 65, 14);
		consultaUsuario.add(lblTipousuario);

		JLabel lblOrientacion = new JLabel("Orientacion");
		lblOrientacion.setBounds(201, 189, 65, 14);
		consultaUsuario.add(lblOrientacion);

		JLabel lblCedula_1 = new JLabel("CEDULA");
		lblCedula_1.setBounds(186, 57, 46, 14);
		consultaUsuario.add(lblCedula_1);
		consultaUsuario.setVisible(false);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 240);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblBiblnima = new JLabel("Bibl\u00C1nima\r\n");
		lblBiblnima.setBounds(151, 11, 121, 28);
		lblBiblnima.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
		panel.add(lblBiblnima);

		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				char clave[] = passField.getPassword();

				String clavedef = new String(clave);

				if (userField.getText().equals("Pablo") && clavedef.equals("12345")) {

					this.dispose();

					JOptionPane.showMessageDialog(null, "Bienvenido\n Has ingresado " + "satisfactoriamente al sistema",
							"Mensaje de bienvenida", JOptionPane.INFORMATION_MESSAGE);

					menuBar.setVisible(true);

				} else {
					JOptionPane.showMessageDialog(null,
							"Acceso denegado:\n" + "Por favor ingrese un usuario y/o contraseña correctos",
							"Acceso denegado", JOptionPane.ERROR_MESSAGE);

				}

			}

			private void dispose() {
				// TODO Auto-generated method stub

			}

		});
		btnIngresar.setBounds(74, 185, 89, 23);
		panel.add(btnIngresar);

		JButton btnCanselar = new JButton("Cancelar");
		btnCanselar.setBounds(237, 185, 89, 23);
		panel.add(btnCanselar);

		userField = new JTextField();
		userField.setBounds(74, 72, 86, 20);
		panel.add(userField);
		userField.setColumns(10);

		passField = new JPasswordField();
		passField.setBounds(237, 71, 89, 23);
		panel.add(passField);

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
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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

		JPanel buscarUsuario = new JPanel();
		buscarUsuario.setBounds(0, 0, 434, 240);
		contentPane.add(buscarUsuario);
		buscarUsuario.setLayout(null);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(138, 72, 146, 20);
		buscarUsuario.add(comboBox_3);

		JLabel lblBuscarUsuario = new JLabel("Buscar Usuario\r\n");
		lblBuscarUsuario.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
		lblBuscarUsuario.setBounds(138, 25, 212, 28);
		buscarUsuario.add(lblBuscarUsuario);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(68, 124, 86, 20);
		buscarUsuario.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(264, 124, 86, 20);
		buscarUsuario.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(68, 155, 86, 20);
		buscarUsuario.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(68, 186, 86, 20);
		buscarUsuario.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(264, 155, 86, 20);
		buscarUsuario.add(textField_10);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(264, 186, 86, 20);
		buscarUsuario.add(textField_11);

		JLabel label_1 = new JLabel("Nombre\r\n");
		label_1.setBounds(10, 127, 46, 14);
		buscarUsuario.add(label_1);

		JLabel label_2 = new JLabel("Apellido");
		label_2.setBounds(12, 158, 46, 14);
		buscarUsuario.add(label_2);

		JLabel label_3 = new JLabel("Mail");
		label_3.setBounds(22, 189, 46, 14);
		buscarUsuario.add(label_3);

		JLabel label_4 = new JLabel("Password");
		label_4.setBounds(209, 127, 46, 14);
		buscarUsuario.add(label_4);

		JLabel label_5 = new JLabel("TipoUsuario");
		label_5.setBounds(201, 158, 65, 14);
		buscarUsuario.add(label_5);

		JLabel label_6 = new JLabel("Orientacion");
		label_6.setBounds(201, 189, 65, 14);
		buscarUsuario.add(label_6);

		JLabel label_7 = new JLabel("CEDULA");
		label_7.setBounds(186, 57, 46, 14);
		buscarUsuario.add(label_7);

		JPanel listarUsuariosExistentes = new JPanel();
		listarUsuariosExistentes.setBounds(0, 0, 434, 240);
		contentPane.add(listarUsuariosExistentes);
		listarUsuariosExistentes.setLayout(null);

		JLabel lblListarUsuarios = new JLabel("Listar Usuarios\r\n");
		lblListarUsuarios.setBounds(132, 11, 167, 28);
		lblListarUsuarios.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
		listarUsuariosExistentes.add(lblListarUsuarios);

		JLabel lblMailsDeUsuarios = new JLabel("MAILS DE USUARIOS ");
		lblMailsDeUsuarios.setBounds(154, 48, 167, 14);
		listarUsuariosExistentes.add(lblMailsDeUsuarios);

		JList list = new JList();
		list.setBounds(409, 220, -382, -139);
		listarUsuariosExistentes.add(list);

		JPanel modificarDatosUsuario = new JPanel();
		modificarDatosUsuario.setBounds(0, 0, 434, 240);
		contentPane.add(modificarDatosUsuario);
		modificarDatosUsuario.setLayout(null);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(138, 72, 146, 20);
		modificarDatosUsuario.add(comboBox_4);

		JLabel lblModificarDatosUsuario = new JLabel("Modificar Datos Usuario");
		lblModificarDatosUsuario.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
		lblModificarDatosUsuario.setBounds(97, 25, 261, 28);
		modificarDatosUsuario.add(lblModificarDatosUsuario);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(68, 124, 86, 20);
		modificarDatosUsuario.add(textField_12);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(264, 124, 86, 20);
		modificarDatosUsuario.add(textField_13);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(68, 155, 86, 20);
		modificarDatosUsuario.add(textField_14);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(68, 186, 86, 20);
		modificarDatosUsuario.add(textField_15);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(264, 155, 86, 20);
		modificarDatosUsuario.add(textField_16);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(264, 186, 86, 20);
		modificarDatosUsuario.add(textField_17);

		JLabel label_9 = new JLabel("Nombre\r\n");
		label_9.setBounds(10, 127, 46, 14);
		modificarDatosUsuario.add(label_9);

		JLabel label_10 = new JLabel("Apellido");
		label_10.setBounds(12, 158, 46, 14);
		modificarDatosUsuario.add(label_10);

		JLabel label_11 = new JLabel("Mail");
		label_11.setBounds(22, 189, 46, 14);
		modificarDatosUsuario.add(label_11);

		JLabel label_12 = new JLabel("Password");
		label_12.setBounds(209, 127, 46, 14);
		modificarDatosUsuario.add(label_12);

		JLabel label_13 = new JLabel("TipoUsuario");
		label_13.setBounds(201, 158, 65, 14);
		modificarDatosUsuario.add(label_13);

		JLabel label_14 = new JLabel("Orientacion");
		label_14.setBounds(201, 189, 65, 14);
		modificarDatosUsuario.add(label_14);

		JLabel label_15 = new JLabel("CEDULA");
		label_15.setBounds(186, 57, 46, 14);
		modificarDatosUsuario.add(label_15);

		JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");
		mntmAltaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(true);
				consultaUsuario.setVisible(false);
				modificarDatosUsuario.setVisible(false);
				buscarUsuario.setVisible(false);
				listarUsuariosExistentes.setVisible(false);
				panel.setVisible(false);
			}
		});
		mnUsuario.add(mntmAltaUsuario);

		JMenuItem mntmConsultaUsuario = new JMenuItem("Consulta Usuario");
		mntmConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(false);
				consultaUsuario.setVisible(true);
				modificarDatosUsuario.setVisible(false);
				buscarUsuario.setVisible(false);
				listarUsuariosExistentes.setVisible(false);
				panel.setVisible(false);
			}
		});
		mnUsuario.add(mntmConsultaUsuario);

		JMenuItem mntmBuscarUsuario = new JMenuItem("Buscar Usuario");
		mntmBuscarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(false);
				consultaUsuario.setVisible(false);
				modificarDatosUsuario.setVisible(false);
				buscarUsuario.setVisible(true);
				listarUsuariosExistentes.setVisible(false);
				panel.setVisible(false);
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
				panel.setVisible(false);
			}
		});
		mnUsuario.add(mntmModificarDatos);

		JMenuItem mntmListaDeUsuarios = new JMenuItem("Lista de Usuarios");
		mntmListaDeUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUsuario.setVisible(false);
				consultaUsuario.setVisible(false);
				modificarDatosUsuario.setVisible(false);
				buscarUsuario.setVisible(false);
				listarUsuariosExistentes.setVisible(true);
				panel.setVisible(false);
			}
		});
		mnUsuario.add(mntmListaDeUsuarios);

		// Set panels invisible except for first view panel
		altaUsuario.setVisible(false);
		modificarDatosUsuario.setVisible(false);
		buscarUsuario.setVisible(false);
		listarUsuariosExistentes.setVisible(false);
		panel.setVisible(true);

		class ComboBoxSelectionChange extends JFrame {
			public ComboBoxSelectionChange() {
				initialize();
			}

			private void initialize() {
				setSize(300, 300);
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				setLayout(new FlowLayout(FlowLayout.LEFT));

				// String[] items = new String[] {"A", "B", "C", "D", "E", "F"};
				// JComboBox<String> comboBox = new JComboBox<>(items);

				final JTextArea textArea = new JTextArea(5, 15);
				textArea.setBorder(new BevelBorder(BevelBorder.LOWERED));

				// For listening to the changes of the selected items in the combo box
				// we need to add an ItemListener to the combo box component as shown
				// below.
				comboBox_2.addItemListener(new ItemListener() {
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
				getContentPane().add(comboBox_2);
				getContentPane().add(textArea);

			}
		}
	}
}
