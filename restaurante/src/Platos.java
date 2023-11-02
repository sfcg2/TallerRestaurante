import java.util.ArrayList;

public class Platos {
    
    static ArrayList <Platos> listP = new ArrayList<Platos>();

    private String nombre, descripcion;
    private TipoP tipo;
    private int costo;
    private byte tiempo;

    public Platos (String nombre, String descripcion, TipoP tipo, int costo, byte tiempo){

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.costo = costo;
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoP getTipo() {
        return tipo;
    }

    public void setTipo(TipoP tipo) {
        this.tipo = tipo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public byte getTiempo() {
        return tiempo;
    }

    public void setTiempo(byte tiempo) {
        this.tiempo = tiempo;
    }

    public static ArrayList<Platos> getListP(){

        Platos sancochoG = new Platos("SANCOCHO DE GALLINA","Sopa colombiana abundante hecha con gallina, yuca,\n plátano, maíz y otros ingredientes.", 
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
        listP.add(gaseosaCol);

        System.out.println(listP.toString());

        return listP;
    }

    @Override
    public String toString() {
        return "\nNOMBRE: " + nombre + "\nDESCRIPCION: " + descripcion + "\nTIPO DE PLATO: " + tipo + "\nCOSTO: $ " + costo
                + "\nTIEMPO DE PREPARACION: " + tiempo + " min\n";
    }
}
