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

        Platos sancochoG = new Platos("SANCOCHO DE GALLINA","Sopa hecha con gallina, yuca, plátano, maíz y otros ingredientes.", 
        TipoP.ENTRADA, 8000, (byte)30); 
        listP.add(sancochoG);

        Platos arepas = new Platos("AREPAS RELLENAS","Panqueques de maíz rellenos de queso, chicharrón, carne desmechada o guacamole.", 
        TipoP.ENTRADA, 2000, (byte)15);
        listP.add(arepas);

        Platos lulada = new Platos("LULADA", "Bebida refrescante, se prepara con lulo, azúcar, agua y hielo. Es agridulce y refrescante.", 
        TipoP.BEBIDA, 2000, (byte)10);
        listP.add(lulada);

        Platos bandejaPaisa = new Platos("BANDEJA PAISA", "Incluye carne molida, chicharrón, arroz, frijoles, huevo frito, plátano maduro y aguacate.", 
        TipoP.PLATOFUERTE, 12000, (byte)30);
        listP.add(bandejaPaisa);

        Platos gaseosaCol = new Platos("GASEOSA COLOMBIANA", "Bebida gaseosa dulce y refrescante.", 
        TipoP.BEBIDA, 1000, (byte)5);
        listP.add(gaseosaCol);

        Platos sobrebarriga = new Platos("SOBREBARRIGA EN SALSA", "Plato de carne, cocinado en salsa de tomate, cebolla y especias. Se sirve con arroz y papa.", 
        TipoP.PLATOFUERTE, 10000, (byte)15);
        listP.add(sobrebarriga);

        Platos jugoMaracuya = new Platos("JUGO DE MARACUYÁ", "Bebida refrescante y deliciosa elaborada a partir de la pulpa del maracuyá.", 
        TipoP.BEBIDA, 6000, (byte)10);
        listP.add(jugoMaracuya);

        Platos empanadas = new Platos("EMPANADAS COLOMBIANAS", "Pequeñas empanadas fritas rellenas de carne molida, papa y especias.", 
        TipoP.ENTRADA, 1000, (byte)15);
        listP.add(empanadas);

        return listP;
    }

    @Override
    public String toString() {
        return "\nNOMBRE: " + nombre + "\nDESCRIPCIÓN: " + descripcion + "\nTIPO DE PLATO: " + tipo + "\nCOSTO: $ " + costo
                + "\nTIEMPO DE PREPARACIÓN: " + tiempo + " min\n";
    }
}
