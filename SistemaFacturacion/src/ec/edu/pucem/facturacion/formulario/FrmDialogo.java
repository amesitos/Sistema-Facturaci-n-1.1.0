package ec.edu.pucem.facturacion.formulario;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FrmDialogo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtValor;

	public FrmDialogo(Dialog owner, boolean modal) {
		super(owner, modal);
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 436, 232);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel txtNombre = new JLabel("Texto");
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtNombre.setBounds(35, 35, 45, 13);
			contentPanel.add(txtNombre);
		}
		{
			JLabel txtValor = new JLabel("Valor");
			txtValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtValor.setBounds(35, 73, 45, 13);
			contentPanel.add(txtValor);
		}
		
		txtNombre = new JTextField();
		txtNombre.setBounds(91, 33, 96, 19);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtValor = new JTextField();
		txtValor.setBounds(91, 71, 96, 19);
		contentPanel.add(txtValor);
		txtValor.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 232, 436, 31);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						enviarDatos();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void enviarDatos() {
		FrmFacebook.llenarFormulario(txtNombre.getText(), txtValor.getText());
		dispose();
	}
}
