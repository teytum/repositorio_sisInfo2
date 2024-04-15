
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Producto;
import modelo.ProductoDAO;
import vista.Vista;


public class Controlador implements ActionListener{
    
    ProductoDAO dao = new ProductoDAO();
    Producto p = new Producto();
    Vista vista = new Vista();
    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador(Vista v){
        this.vista = v;
        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnListar.addActionListener(this);;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==vista.btnListar) {
            listar(vista.tabla);  
        }
        if (e.getSource()==vista.btnGuardar) {
            agregar();
        }
      
    }
    
    public void agregar(){
        String mar = vista.txtMarca.getText();
        int pre = Integer.parseInt(vista.txtPrecio.getText());
        int comp = (int)Math.ceil(pre/490);
        p.setMarca(mar);
        p.setPrecio(pre);
        p.setComparador(comp);
        int r = dao.agregar(p);
        if(r==1){
            JOptionPane.showMessageDialog(vista,"Marca agregada con exito");
        }else{
            JOptionPane.showMessageDialog(vista,"Error" );
        }
    }

    public void listar(JTable tabla){
        modelo =(DefaultTableModel)tabla.getModel();
        //@SuppressWarnings("unchecked")
        List<Producto>lista = dao.listar();
        Object[] object=new Object[4];
        for(int i = 0; i < lista.size() ; i++ ){
            object[0]=lista.get(i).getPosicion();
            object[1]=lista.get(i).getMarca();
            object[2]=lista.get(i).getPrecio();
            object[3]=lista.get(i).getComparador();
            modelo.addRow(object);
        }
        vista.tabla.setModel(modelo);

    }
}
