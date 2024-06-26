package ec.edu.pucem.facturacion.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ec.edu.pucem.facturacion.models.Cliente;

import java.awt.BorderLayout;
import javax.swing.JButton;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FrmListaCliente extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private JTable table;
    private DefaultTableModel model;
    private FrmFactura frmFactura;

    public FrmListaCliente(FrmFactura frmFactura) { 
        this.frmFactura = frmFactura;

        setTitle("Lista de clientes");
        setClosable(true); // Ventana que se cierra
        setBounds(100, 100, 600, 400);
        getContentPane().setLayout(new BorderLayout());

        JScrollPane scrollPane = new JScrollPane();
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Tabla con objetos que tenga los datos del cliente
        table = new JTable();
        model = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Cédula", "Nombres", "Apellidos", "Teléfono", "Dirección", "Email"}
        );
        table.setModel(model);
        scrollPane.setViewportView(table);

        // Llenar la tabla con los clientes existentes
        llenarTabla();

        // Evento para seleccionar cliente
        table.addMouseListener(new MouseAdapter() { // Evento en la tabla de tipo MouseListener
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) { // si se hace click una vez
                    int selectedRow = table.getSelectedRow(); // la tabla seleccionada se almacena en un entero
                    if (selectedRow != -1) {
                        Cliente cliente = FrmCrearCliente.clientes.get(selectedRow); 
                        frmFactura.setCliente(cliente);
                        dispose(); // cerrar formulario 
                    }
                }
            }
        });
    }

    // Método para llenar 
    private void llenarTabla() { 
        // Limpiar la tabla
        model.setRowCount(0);

        // Llenar la tabla con los clientes existentes
        for (Cliente cliente : FrmCrearCliente.clientes) { // for que recorre la lista de clientes en Crear Cliente
            model.addRow(new Object[]{ // y almacena los datos de cada objeto en la tabla
                    cliente.getCedula(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getTelefono(),
                    cliente.getEmail(),
                    cliente.getDireccion()
            });
        }
    }
}

