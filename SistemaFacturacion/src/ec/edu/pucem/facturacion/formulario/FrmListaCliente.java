package ec.edu.pucem.facturacion.formulario;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class FrmListaCliente extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	public FrmListaCliente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 414, 128);
		getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("Agregar Nuevo");
		btnNewButton.setBounds(22, 22, 155, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(253, 239, 155, 21);
		getContentPane().add(btnNewButton_1);

	}

}
