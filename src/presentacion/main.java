package presentacion;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import logica.Manejador;
import logica.Orientacion;
import logica.TipoUsuario;
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

import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.WindowConstants;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class main extends JFrame {

	private JPanel contentPane;
	private JTextField TextApellido;
	private JTextField TextMail;
	private JTextField TextPass;
	private JTextField TextNombre;
	private JTextField TextCedula;

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
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		
		
		JMenuItem mntmBuscarUsuario = new JMenuItem("Buscar Usuario");
		mnUsuario.add(mntmBuscarUsuario);
		
		JMenuItem mntmModificarDatos = new JMenuItem("Modificar Datos");
		mnUsuario.add(mntmModificarDatos);
		
		JMenuItem mntmListaDeUsuarios = new JMenuItem("Lista de Usuarios");
		mnUsuario.add(mntmListaDeUsuarios);
		
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
						
								
								JPanel ConsultaUsuario = new JPanel();
								ConsultaUsuario.setBounds(0, 0, 434, 240);
								contentPane.add(ConsultaUsuario);
								ConsultaUsuario.setLayout(null);
								
								 
								JComboBox comboBox_2 = new JComboBox();
								comboBox_2.setBounds(138, 79, 146, 20);
								ConsultaUsuario.add(comboBox_2);
								
								JLabel lblConsultaUsuario = new JLabel("Consulta Usuario");
								lblConsultaUsuario.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
								lblConsultaUsuario.setBounds(138, 25, 212, 28);
								ConsultaUsuario.add(lblConsultaUsuario);
						
						JPanel AltaUsuario = new JPanel();
						AltaUsuario.setBounds(0, 0, 434, 240);
						contentPane.add(AltaUsuario);
						AltaUsuario.setLayout(null);
						
						JComboBox comboBox_1 = 	new JComboBox(TipoUsuario.values());
						comboBox_1.setBounds(92, 143, 121, 20);
						AltaUsuario.add(comboBox_1);
						
						
						JLabel lblAltaUsuario = new JLabel("Alta Usuario");
						lblAltaUsuario.setBounds(151, 11, 121, 28);
						AltaUsuario.add(lblAltaUsuario);
						lblAltaUsuario.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 21));
						
						TextApellido = new JTextField();
						TextApellido.setBounds(277, 50, 86, 20);
						AltaUsuario.add(TextApellido);
						TextApellido.setColumns(10);
						
						TextMail = new JTextField();
						TextMail.setBounds(92, 81, 86, 20);
						AltaUsuario.add(TextMail);
						TextMail.setColumns(10);
						
						TextPass = new JTextField();
						TextPass.setBounds(277, 81, 86, 20);
						AltaUsuario.add(TextPass);
						TextPass.setColumns(10);
						
						TextNombre = new JTextField();
						TextNombre.setBounds(92, 50, 86, 20);
						AltaUsuario.add(TextNombre);
						TextNombre.setColumns(10);
						
						
						JLabel lblNombre = new JLabel("Nombre");
						lblNombre.setBounds(37, 53, 45, 14);
						AltaUsuario.add(lblNombre);
						
						JLabel lblApellido = new JLabel("Apellido");
						lblApellido.setBounds(216, 53, 56, 14);
						AltaUsuario.add(lblApellido);
						
						JLabel lblMail = new JLabel("Mail");
						lblMail.setBounds(55, 84, 27, 14);
						AltaUsuario.add(lblMail);
						
						JLabel lblContrasea = new JLabel("Contrase\u00F1a");
						lblContrasea.setBounds(203, 84, 69, 14);
						AltaUsuario.add(lblContrasea);		
						
							        		
							    		TextCedula = new JTextField();
							    		TextCedula.setBounds(186, 112, 86, 20);
							    		AltaUsuario.add(TextCedula);
							    		TextCedula.setColumns(10);
							    		
							    		JComboBox comboBox = 	new JComboBox(Orientacion.values());
							    		comboBox.setBounds(242, 143, 121, 20);
							    		AltaUsuario.add(comboBox);
							    		
							    		
							    		JLabel lblCedula = new JLabel("Cedula");
							    		lblCedula.setBounds(127, 112, 46, 14);
							    		AltaUsuario.add(lblCedula);
							    		
							    		JButton btnAceptar = new JButton("ACEPTAR");
							    		btnAceptar.addActionListener(new ActionListener() {
							    			public void actionPerformed(ActionEvent e) {
							    				
							    				  try {
							man.altaUsuario(TextApellido.getText(),TextNombre.getText(),Integer.parseInt(TextCedula.getText()),TextMail.getText(),TextPass.getText(),(TipoUsuario) comboBox_1.getSelectedItem(),(Orientacion) comboBox.getSelectedItem());
						} catch (NumberFormatException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

							    			}
							    		});
							    		
							    		
							    		
							    		btnAceptar.setBounds(241, 190, 115, 23);
							    		AltaUsuario.add(btnAceptar);
							    		
							    		JButton btnCancelar = new JButton("CANCELAR");
							    		btnCancelar.setBounds(92, 190, 115, 23);
							    		AltaUsuario.add(btnCancelar);
							    		
	    	
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
	
	    		Manejador man = new Manejador();
				
				JMenuItem mntmAltaUsuario = new JMenuItem("Alta Usuario");
				mntmAltaUsuario.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AltaUsuario.setVisible(true);
						ConsultaUsuario.setVisible(false);
					}
				});
				mnUsuario.add(mntmAltaUsuario);
		
		JMenuItem mntmConsultaUsuario = new JMenuItem("Consulta Usuario");
		mntmConsultaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaUsuario.setVisible(false);
				ConsultaUsuario.setVisible(true);
				
			}
		});
		mnUsuario.add(mntmConsultaUsuario);
		
		class ComboBoxSelectionChange extends JFrame {
		    public ComboBoxSelectionChange() {
		        initialize();
		    }

		    private void initialize() {
		        setSize(300, 300);
		        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		        setLayout(new FlowLayout(FlowLayout.LEFT));

		        //String[] items = new String[] {"A", "B", "C", "D", "E", "F"};
		        //JComboBox<String> comboBox = new JComboBox<>(items);

		        final JTextArea textArea = new JTextArea(5, 15);
		        textArea.setBorder(new BevelBorder(BevelBorder.LOWERED));

		        // For listening to the changes of the selected items in the combo box
		        // we need to add an ItemListener to the combo box component as shown
		        // below.
		        comboBox_2.addItemListener(new ItemListener() {
		            // Listening if a new items of the combo box has been selected.
		            public void itemStateChanged(ItemEvent event) {
		                //JComboBox comboBox = (JComboBox) event.getSource();

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