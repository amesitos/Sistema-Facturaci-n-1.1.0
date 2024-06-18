package ec.edu.pucem.facturacion.formulario;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmCrearCliente extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtCedula;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JTextField txtDireccion;
    private static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    private JButton btnGuardar;
    private JTable table;
    private DefaultTableModel model;

    public FrmCrearCliente() {
        setTitle("Clientes");
        setBounds(100, 100, 450, 500);
        getContentPane().setLayout(null);

        JLabel lblCedula = new JLabel("Cédula");
        lblCedula.setBounds(21, 20, 69, 13);
        getContentPane().add(lblCedula);

        JLabel lblNombres = new JLabel("Nombres");
        lblNombres.setBounds(21, 43, 69, 13);
        getContentPane().add(lblNombres);

        JLabel lblApellidos = new JLabel("Apellidos");
        lblApellidos.setBounds(21, 66, 69, 13);
        getContentPane().add(lblApellidos);

        JLabel lblDireccion = new JLabel("Dirección");
        lblDireccion.setBounds(21, 89, 69, 13);
        getContentPane().add(lblDireccion);

        JLabel lblTelefono = new JLabel("Teléfono");
        lblTelefono.setBounds(21, 112, 69, 13);
        getContentPane().add(lblTelefono);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(21, 135, 69, 13);
        getContentPane().add(lblEmail);

        txtCedula = new JTextField();
        txtCedula.setBounds(100, 17, 198, 19);
        getContentPane().add(txtCedula);
        txtCedula.setColumns(10);

        txtNombres = new JTextField();
        txtNombres.setColumns(10);
        txtNombres.setBounds(100, 40, 198, 19);
        getContentPane().add(txtNombres);

        txtApellidos = new JTextField();
        txtApellidos.setColumns(10);
        txtApellidos.setBounds(100, 63, 198, 19);
        getContentPane().add(txtApellidos);

        txtDireccion = new JTextField();
        txtDireccion.setColumns(10);
        txtDireccion.setBounds(100, 132, 198, 19);
        getContentPane().add(txtDireccion);

        txtTelefono = new JTextField();
        txtTelefono.setColumns(10);
        txtTelefono.setBounds(100, 109, 198, 19);
        getContentPane().add(txtTelefono);

        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        txtEmail.setBounds(100, 86, 198, 19);
        getContentPane().add(txtEmail);

        JButton btnNuevo = new JButton("Nuevo");
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Limpiar();
            }
        });
        btnNuevo.setBounds(318, 30, 90, 30);
        getContentPane().add(btnNuevo);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuardarCliente();
            }
        });
        btnGuardar.setBounds(318, 65, 90, 30);
        getContentPane().add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                table.clearSelection();
            }
        });
        btnCancelar.setBounds(318, 100, 90, 30);
        getContentPane().add(btnCancelar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(21, 173, 387, 273);
        getContentPane().add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Cédula", "Nombres", "Apellidos", "Teléfono", "Email", "Dirección"}
        );
        table.setModel(model);
        scrollPane.setViewportView(table);
    }

    private void Limpiar() {
        this.txtCedula.setText("");
        this.txtNombres.setText("");
        this.txtApellidos.setText("");
        this.txtTelefono.setText("");
        this.txtEmail.setText("");
        this.txtDireccion.setText("");
    }

    private void GuardarCliente() {
        Cliente cliente = new Cliente();
        cliente.setCedula(txtCedula.getText());
        cliente.setNombre(txtNombres.getText());
        cliente.setApellido(txtApellidos.getText());
        cliente.setTelefono(txtTelefono.getText());
        cliente.setEmail(txtEmail.getText());
        cliente.setDireccion(txtDireccion.getText());

        clientes.add(cliente);

        model.addRow(new Object[]{
                cliente.getCedula(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono(),
                cliente.getEmail(),
                cliente.getDireccion()
        });

    }
}