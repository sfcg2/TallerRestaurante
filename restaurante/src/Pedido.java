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
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Pedido extends JFrame implements ActionListener, ItemListener {

    Container contenedor;
    FlowLayout flow;
    BorderLayout border;
    GridLayout grid;
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

        border = new BorderLayout(15,15);
        contenedor.setLayout(border);

        p1 = new JPanel();
        //p1.setBackground(Color.GREEN);
        contenedor.add(p1,BorderLayout.NORTH);

        menu = new JLabel("M E N Ú");
        menu.setFont(new Font("Serif", Font.ITALIC, 50));
        p1.add(menu);

        /*Platos sancochoG = new Platos("SANCOCHO DE GALLINA","Sopa colombiana abundante hecha con gallina, yuca,\n plátano, maíz y otros ingredientes.", 
        TipoP.ENTRADA, 8000, (byte)30); 
        listP.add(sancochoG);

        Platos arepas = new Platos("AREPAS RELLENAS","Panqueques de maíz que se rellenan con una variedad de ingredientes,\n como queso, chicharrón, carne desmechada o guacamole.", 
        TipoP.ENTRADA, 2000, (byte)15);
        listP.add(arepas);

        Platos lulada = new Platos("LULADA", "Bebida refrescante originaria de la región de Valle del Cauca en Colombia.\n Se prepara con lulo (una fruta cítrica),azúcar y agua, y se sirve con hielo. Es agridulce y muy refrescante.", 
        TipoP.BEBIDA, 2000, (byte)10);
        listP.add(lulada);

        Platos bandejaPaisa = new Platos("BANDEJA PAISA", "Plato colombiano típico de la región de Antioquia. Incluye carne molida, chicharrón,\n arroz, frijoles,huevo frito, plátano maduro y aguacate. Es un plato abundante y delicioso.", 
        TipoP.PLATOFUERTE, 12000, (byte)30);
        listP.add(bandejaPaisa);

        Platos gaseosaCol = new Platos("GASEOSA COLOMBIANA", "Bebida gaseosa de sabor a cola muy popular en Colombia.\n Es dulce y refrescante, similar a otras colas carbonatadas.", 
        TipoP.BEBIDA, 1000, (byte)5);
        listP.add(gaseosaCol);*/

        
        p2 = new JPanel();
        //p2.setBackground(Color.BLUE);
        getContentPane().add(p2, BorderLayout.CENTER);

        String[] elementosP = {"Elegir Plato", "SANCOCHO DE GALLINA", "AREPAS RELLENAS", "LULADA", "BANDEJA PAISA"};

        selecPla =  new JComboBox<String>(elementosP);
        selecPla.addItemListener(this);
        p2.add(selecPla); 

        System.out.println(listP.toString());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300); 
        setVisible(true); 

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if(e.getStateChange() == 1){

            with1 = new JFrame(e.paramString());
            with1.setLayout(border);

            for(Platos p0: listP ){

                if(selecPla.getSelectedItem() == p0.getNombre()){

                    w1 = new JPanel();
                    //w1.setBackground(Color.ORANGE);
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

                    et5 = new JLabel(String.valueOf("TIEMPO DE PREPARACION: " + p0.getTiempo() + " min"));
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
                    //w2.setBackground(Color.PINK);
                    w2.setLayout(new GridLayout(3,4, 50,40));
                    //w2.setLayout(new FlowLayout());
                    with1.add(w2, BorderLayout.CENTER);

                    p1 = new JPanel();
                    //p1.setLayout(new GridLayout(2,2,50,30));
                    p1.setLayout(new FlowLayout());
                    //p1.setBackground(Color.GRAY);
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
            System.out.println("contador bebidas" + contBebidas);

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

            }
            for(Platos pl: carritoCompras){

                System.out.println("entra al for");
                if(pl.getTipo().equals(TipoP.BEBIDA)){
                    contBebidas++;
                }
            }

            if(costoTotal > 200000){

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
            
            //System.out.println("contador 2 bebidas" + contBebidas);
            
        }catch(ComprasDeMasException ex){
            JOptionPane.showMessageDialog(w2, "Error:\nCompra Superior a $ 200.000 Pesos.");   
            System.out.println(carritoCompras.toString());
            return;

        }catch(MasdeCincoUniException ex){
            JOptionPane.showMessageDialog(w2, "Error:\nCompra Superior a 5 Unidades.");
            System.out.println(carritoCompras.toString());
            return;

        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        //System.out.println("no ha entrado a pagar");

        if(e.getSource() == pagar){//factura

            try{
                if (contBebidas == 0){

                    throw new NoPedirBebidaException("error");
                }

                System.out.println("pago");
                //int costoTotal = 0;
                //byte tiempoTotal = 0;

                //grid = new GridLayout(5,2);

                with1 = new JFrame("Factura");
                with1.setLayout(new BorderLayout());

                area = new JTextArea(100,10);
                

                //System.out.println(carritoCompras.toString());

                for(Platos cm: carritoCompras){

                    //et1 = new JLabel(cm.toString());
                    area.append(cm.toString());
                    area.append("- - - - - - - - - - - - - - - - - - - - ");
                    //costoTotal+=cm.getCosto();
                    //tiempoTotal+=cm.getTiempo();
                }

                area.setEditable(false);
                scroll = new JScrollPane(area);
                with1.add(scroll, BorderLayout.CENTER);
                area.append("- - - - - - - - - - - - - - - - - - - - ");
                area.append("\n\nCosto Total: $ " + String.valueOf(costoTotal) + "\n");
                DecimalFormat df = new DecimalFormat("#.00");

                if(tiempoTotal >= 60){

                    Float hora = (Float.valueOf(tiempoTotal)/60);
                    area.append("Tiempo Total: " + df.format(hora) + " hora/s");

                }else if(tiempoTotal < 60){

                    area.append("Tiempo Total: " + String.valueOf(tiempoTotal) + " min");
                }

                with1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                with1.setSize(600, 600);
                with1.setVisible(true);

                
            }catch(NoPedirBebidaException ex){
                JOptionPane.showMessageDialog(w2, "Error:\n No Compro Bebida");
                //System.out.println(carritoCompras.toString());
                return;

            }catch(Exception ex){

                ex.printStackTrace();
            }

        }else if(e.getSource() == carrito){

            border = new BorderLayout(15,15);

            with1 = new JFrame("Carrito de Compras");
            with1.setLayout(border);

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


