package ec.edu.pucem.facturacion.formulario;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrmDemo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private Cliente cliente;
	
	
	public FrmDemo(Cliente clienteIngreso) {
		this.cliente = clienteIngreso;
		
		setTitle("Sistema de Facturacion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(67, 46, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(108, 167, 89, 23);
		contentPane.add(btnCancelar);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(145, 44, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidos.setBounds(65, 84, 46, 14);
		contentPane.add(lblApellidos);
	
		txtApellidos = new JTextField();
		txtApellidos.setBounds(145, 81, 86, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtNombre.setText(cliente.getNombre());
		txtApellidos.setText(cliente.getApellido());
	}
}
