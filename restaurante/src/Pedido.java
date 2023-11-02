import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class Pedido extends JFrame implements ActionListener, ItemListener {

    Container contenedor;
    JLabel menu, et1, et2, et3 ,et4, et5, et6;
    JTextField campo;
    JTextArea area; 
    JScrollPane scroll;
    JButton pedir, comprar, pagar, carrito;
    ArrayList <Platos> listP = Platos.getListP();
    static ArrayList <Platos> carritoCompras = new ArrayList<>();
    JComboBox <String> selecPla; 
    JPanel p1, p2, w1, w2;
    JFrame with1;

    int costoTotal = 0;
    byte tiempoTotal = 0;
    int contBebidas = 0;
    
    public Pedido(){

        contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout(15,15));

        p1 = new JPanel();
        contenedor.add(p1,BorderLayout.NORTH);

        menu = new JLabel("M E N Ú");
        menu.setFont(new Font("Serif", Font.ITALIC, 50));
        p1.add(menu);

        p2 = new JPanel();
        getContentPane().add(p2, BorderLayout.CENTER);

        String[] elementosP = {"Elegir Plato", "SANCOCHO DE GALLINA", "AREPAS RELLENAS", "LULADA", "BANDEJA PAISA",
        "GASEOSA COLOMBIANA","SOBREBARRIGA EN SALSA","JUGO DE MARACUYÁ","EMPANADAS COLOMBIANAS"};

        selecPla =  new JComboBox<String>(elementosP);
        selecPla.addItemListener(this);
        p2.add(selecPla); 

        System.out.println(listP.toString());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 350); 
        setVisible(true); 

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if(e.getStateChange() == 1){

            with1 = new JFrame(e.paramString());
            with1.setLayout(new BorderLayout());

            for(Platos p0: listP ){

                if(selecPla.getSelectedItem() == p0.getNombre()){

                    w1 = new JPanel();
                    w1.setLayout(new GridLayout(6,1));
                    with1.add(w1, BorderLayout.NORTH);

                    et1 = new JLabel(p0.getNombre());
                    et1.setFont(new Font("Serif", Font.ITALIC, 20));

                    et2 = new JLabel(p0.getDescripcion());
                    et2.setFont(new Font("Serif", Font.ITALIC, 15));

                    et3 = new JLabel("TIPO PLATO: " + p0.getTipo().toString());
                    et3.setFont(new Font("Serif", Font.ITALIC, 20));

                    et4 = new JLabel(String.valueOf("PRECIO: $ " + p0.getCosto()));
                    et4.setFont(new Font("Serif", Font.ITALIC, 20));

                    et5 = new JLabel(String.valueOf("TIEMPO DE PREPARACIÓN: " + p0.getTiempo() + " min"));
                    et5.setFont(new Font("Serif", Font.ITALIC, 20));

                    et6 = new JLabel("    ");
                    et6.setFont(new Font("Serif", Font.ITALIC, 20));
                    
                    w1.add(et1);
                    w1.add(et2);
                    w1.add(et3);
                    w1.add(et4);
                    w1.add(et5);
                    w1.add(et6);

                    w2 = new JPanel();
                    w2.setLayout(new GridLayout(3,4, 50,40));
                    with1.add(w2, BorderLayout.CENTER);

                    p1 = new JPanel();
                    p1.setLayout(new FlowLayout());
                    w2.add(p1); 

                    et1 = new JLabel("PEDIR ");
                    p1.add(et1);

                    campo = new JTextField(10);
                    p1.add(campo);

                    et3 = new JLabel("  UNIDADES");
                    p1.add(et3);

                    comprar = new JButton("COMPRAR");
                    comprar.addActionListener(this);
                    w2.add(comprar);

                    pagar = new JButton("PAGAR");
                    pagar.addActionListener(this);
                    w2.add(pagar);

                    carrito = new JButton("CARRITO DE COMPRAS");
                    carrito.addActionListener(this);
                    w2.add(carrito);
                }
                with1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                with1.setSize(600, 500);
                with1.setVisible(true);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{

            if(e.getSource() == comprar){

                for(Platos p0: listP){

                    if(selecPla.getSelectedItem() == p0.getNombre()){

                        int valor1 = Integer.parseInt(campo.getText());
                        int con = 0;

                        while(con < valor1){

                            carritoCompras.add(p0);
                            con++;
                            costoTotal+=p0.getCosto();
                            tiempoTotal+=p0.getTiempo();
                        }
                    }
                }

            }for(Platos pl: carritoCompras){

                if(pl.getTipo().equals(TipoP.BEBIDA)){
                    contBebidas++;
                }

            }if(costoTotal > 200000){

                carritoCompras.clear();
                costoTotal = 0;
                tiempoTotal = 0;

                throw new ComprasDeMasException("error");

            }else if(carritoCompras.size() >= 5){

                carritoCompras.clear();
                costoTotal = 0;
                tiempoTotal = 0;

                throw new MasdeCincoUniException("error");
            }
                        
        }catch(ComprasDeMasException ex){

            JOptionPane.showMessageDialog(w2, "Compra Superior a $ 200.000 Pesos.\nIngrese la cantidad de nuevo.", "ERROR", JOptionPane.ERROR_MESSAGE);  
            System.out.println(carritoCompras.toString());
            return;

        }catch(MasdeCincoUniException ex){

            JOptionPane.showMessageDialog(w2, "Compra Superior a 5 Unidades.\nIngrese la cantidad de nuevo.", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(carritoCompras.toString());
            return;

        }catch(Exception ex){

            ex.printStackTrace();
        }

        if(e.getSource() == pagar){//factura

            try{

                if (contBebidas == 0){

                    throw new NoPedirBebidaException("error");
                }

                with1 = new JFrame("Factura");
                with1.setLayout(new BorderLayout());

                area = new JTextArea(100,10);

                for(Platos cm: carritoCompras){

                    area.append(cm.toString());
                    area.append("- - - - - - - - - - - - - - - - - - - - ");
                    
                }

                area.setEditable(false);
                scroll = new JScrollPane(area);
                with1.add(scroll, BorderLayout.CENTER);
                area.append("- - - - - - - - - - - - - - - - - - - - ");
                area.append("\n\nCosto Total: $ " + String.valueOf(costoTotal) + "\n");
                area.append("Tiempo Total: " + String.valueOf(tiempoTotal) + " min");


                with1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                with1.setSize(600, 600);
                with1.setVisible(true);

                
            }catch(NoPedirBebidaException ex){

                JOptionPane.showMessageDialog(w2, "No Compro Bebida", "ERROR", JOptionPane.ERROR_MESSAGE);
                return;

            }catch(Exception ex){

                ex.printStackTrace();
            }

        }else if(e.getSource() == carrito){

            with1 = new JFrame("Carrito de Compras");
            with1.setLayout(new BorderLayout(15,15));

            System.out.println(carritoCompras.toString());

            area = new JTextArea(150,20);

            for(Platos cm: carritoCompras){
                
                area.append(cm.toString());
            }

            area.setEditable(false);
            scroll = new JScrollPane(area);
            with1.add(scroll, BorderLayout.CENTER);

            with1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            with1.setSize(600, 600);
            with1.setVisible(true);
        }
    }
}


