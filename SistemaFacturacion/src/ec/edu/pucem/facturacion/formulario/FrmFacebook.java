package ec.edu.pucem.facturacion.formulario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FrmFacebook extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private static JLabel lblMensajeRecibido;

	public FrmFacebook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnConfirmacion = new JButton("Confirmacion");
		btnConfirmacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int dialogResult = JOptionPane.showConfirmDialog(null, "¿Estás seguro?", "Confirma", JOptionPane.YES_NO_OPTION);
			
			if (dialogResult == JOptionPane.YES_NO_OPTION) {
				System.out.println("Pulso en SI");
			} else {
				System.out.println("Pulsado en NO");
			}
			}
		});
		contentPane.setLayout(null);
		btnConfirmacion.setBounds(151, 29, 144, 21);
		contentPane.add(btnConfirmacion);
		
		JButton btnAlerta = new JButton("Alerta");
		btnAlerta.setBounds(151, 61, 144, 21);
		contentPane.add(btnAlerta);
		
		
		JButton btnNewButton = new JButton("Agregar Objeto");
		btnNewButton.setBounds(151, 136, 144, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviarObjeto();
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Recibir Objeto");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recibirObjeto();
			}
		});
		btnNewButton_1.setBounds(151, 98, 144, 21);
		contentPane.add(btnNewButton_1);
		
		lblMensajeRecibido = new JLabel("New label");
		lblMensajeRecibido.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajeRecibido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMensajeRecibido.setBounds(139, 185, 171, 21);
		contentPane.add(lblMensajeRecibido);
	}
	private void enviarObjeto() {
		Cliente cliente = new Cliente();
		cliente.setNombre("Andrea");
		cliente.setApellido("Campaña");
		cliente.setCedula("1315424");
		
		FrmDemo frmDemo = new FrmDemo(cliente);
		frmDemo.setVisible(true);
	}
	
	private void recibirObjeto() {
		FrmDialogo frmDialogo = new FrmDialogo(new JDialog(), true);
		frmDialogo.setVisible(true);
		
	}
	
	public static void llenarFormulario(String nombre, String valor) {
		lblMensajeRecibido.setText(nombre + "-" + valor);
	}
}
