package domain;

// UnsynchronizedBuffer represents a single shared integer.
//import static domain.Thread1.getVeeces;
//import static domain.Thread1.getVelo;
//import static domain.Thread2.getCantidad;
//import static domain.Thread2.getVelocidad;
//import static domain.Thread3.getCantidad1;
//import static domain.Thread3.getVelocidad1;

public class UnsynchronizedBuffer implements Buffer {
    // shared by producer and consumer threads

    private int buffer = -1;

    // place value into buffer
    public void set(int value) {
       // System.err.println("Name: "+Thread.currentThread().getName()
             //  +"  " +"Velocidad del thread: "+getVelocidad() + "   "+"Cantidad de veces que se ejecuta : " + getCantidad());

        //contains a new value at current buffer
       // buffer = value;
    }

    // return value from buffer
    public int get() {
        //System.err.println("Name: " + Thread.currentThread().getName()
              //  + "  Velocidad del thread: " + getVelo() + " " + " Cantidad de veces que se ejecuta: " + getVeeces());//+ //buffer);

        //return current value from current buffer
        return buffer;
    }
    
    public int get2(){
    
        //System.err.println("Name: " + Thread.currentThread().getName()  +"Velocidad de thread: "+ getVelocidad1() + " "+"Cantidad de veces que se ejecuta "+getCantidad1());
        return buffer;
    }
    
} // end class UnsynchronizedBuffer

