package ec.edu.pucem.facturacion.formulario;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmFacebook extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public FrmFacebook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
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
		contentPane.add(btnConfirmacion);
		
		JButton btnAlerta = new JButton("Alerta");
		contentPane.add(btnAlerta);
		
		
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton);
	}

}
