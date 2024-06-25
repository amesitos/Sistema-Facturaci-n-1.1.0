package ec.edu.pucem.facturacion.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ec.edu.pucem.facturacion.models.Producto;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmCrearProducto extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JTextField txtIva;
    static ArrayList<Producto> productos = new ArrayList<Producto>();
    private JButton btnGuardar;
    private JTable table;
    private DefaultTableModel model;
    private static int codigoProducto = 1; // Contador estático para el código de producto
    private JLabel lblCodigoValue; // Variable de instancia para el código

    public FrmCrearProducto() {
        setTitle("Crear nuevo producto");
        setBounds(100, 100, 520, 500);
        getContentPane().setLayout(null);

        JLabel lblCodigo = new JLabel("Código");
        lblCodigo.setBounds(21, 20, 69, 13);
        getContentPane().add(lblCodigo);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(21, 43, 69, 13);
        getContentPane().add(lblNombre);

        JLabel lblPrecio = new JLabel("Precio ($)");
        lblPrecio.setBounds(21, 66, 69, 13);
        getContentPane().add(lblPrecio);

        JLabel lblCantidad = new JLabel("Cantidad");
        lblCantidad.setBounds(21, 89, 69, 13);
        getContentPane().add(lblCantidad);

        JLabel lblIva = new JLabel("IVA (%)");
        lblIva.setBounds(21, 112, 69, 13);
        getContentPane().add(lblIva);

        lblCodigoValue = new JLabel(String.valueOf(codigoProducto));
        lblCodigoValue.setBounds(100, 20, 198, 19);
        getContentPane().add(lblCodigoValue);

        txtNombre = new JTextField();
        txtNombre.setColumns(10);
        txtNombre.setBounds(100, 40, 198, 19);
        getContentPane().add(txtNombre);

        txtPrecio = new JTextField();
        txtPrecio.setColumns(10);
        txtPrecio.setBounds(100, 63, 198, 19);
        getContentPane().add(txtPrecio);

        txtCantidad = new JTextField();
        txtCantidad.setColumns(10);
        txtCantidad.setBounds(100, 86, 198, 19);
        getContentPane().add(txtCantidad);

        txtIva = new JTextField();
        txtIva.setColumns(10);
        txtIva.setBounds(100, 109, 198, 19);
        getContentPane().add(txtIva);

        JButton btnNuevo = new JButton("Nuevo");
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Limpiar();
            }
        });
        btnNuevo.setBounds(318, 30, 154, 30);
        getContentPane().add(btnNuevo);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GuardarProducto();
            }
        });
        btnGuardar.setBounds(318, 65, 154, 30);
        getContentPane().add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancelar.setBounds(318, 100, 154, 30);
        getContentPane().add(btnCancelar);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(21, 173, 487, 273);
        getContentPane().add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Código", "Nombre", "Precio", "Cantidad", "IVA", "Total IVA", "Total"}
        );
        table.setModel(model);
        scrollPane.setViewportView(table);
    }

    private void Limpiar() {
        this.txtNombre.setText("");
        this.txtPrecio.setText("");
        this.txtCantidad.setText("");
        this.txtIva.setText("");
    }

    private void GuardarProducto() {
        // Validar que todos los campos estén llenos
        if (txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty() || 
        		txtCantidad.getText().isEmpty() || txtIva.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Producto producto = new Producto();
        producto.setCodigo(codigoProducto); // Asignar el código del producto
        producto.setNombre(txtNombre.getText());
        producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
        producto.setCantidad(Integer.parseInt(txtCantidad.getText()));
        producto.setIva(Double.parseDouble(txtIva.getText())); // Set IVA and calculate total IVA

        productos.add(producto);

        model.addRow(new Object[]{
                producto.getCodigo(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getCantidad(),
                producto.getIva(),
                producto.getTotalIva(),
                producto.getTotal()
        });

        codigoProducto++; // Incrementar el código del producto para el siguiente producto

        Limpiar(); // Limpiar los campos después de guardar

        // Actualizar el código en la etiqueta
        lblCodigoValue.setText(String.valueOf(codigoProducto));
    }
}



