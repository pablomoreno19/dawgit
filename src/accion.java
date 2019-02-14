   /**
      * @author Pablo Moreno
      * @version 1.0
      */

public class accion implements Cloneable{  
    
    private int mes;
    private int dia;
    private int tipo;
    private int cantidad;
    
    public accion(){
    mes=1;
    dia=1;
    tipo=0;
    cantidad=1;
    }
    
    
    
    public accion(int mes, int dia, int tipo, int cantidad){
    if(dia<1 || dia>31){
            System.out.println("error, no puede haber menos de 1 día o más de 31");
        }
        else
    if(mes==2){
        
        if(dia > 28){
            System.out.println("dia incorrecto, mes con 28 días, introduzca un día entre 1 y 28");
        }
        else
              this.dia=dia;  
    } 
    else
        if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){
        if(dia > 31){
            System.out.println("día incorrecto, mes con 31 días, introduzca un día entre 1 y 31");
        }
        else this.dia=dia;
        }
        else 
            if(mes==4 || mes==6 || mes==9 || mes==11){
            if(dia>30){
             System.out.println("día incorrecto, mes con 30 días, introduzca un día entre 1 y 30 ");
            }
            else this.dia=dia;
            }
    
     if(tipo<0||tipo>1)
            System.out.println("tipo incorrecto, sólo puede ser 0 o 1");
    else this.tipo=tipo;
            }
    
    
    public accion(accion x){
    mes=x.mes;
    dia=x.dia;
    tipo=x.tipo;
    cantidad=x.cantidad;
    }
    
    public void setmes(int mes){
    if(mes<1 || mes >12){
        System.out.println("mes incorrecto, debe estar entre 1 y 12");
    }
    else this.mes=mes;
    }
    
    public int getmes(){
    return mes;
    }

    public void setdia(int dia){
        
        if(dia<1 || dia>31){
            System.out.println("error, no puede haber menos de 1 día o más de 31");
        }
        else
    if(mes==2){
        
        if(dia > 28){
            System.out.println("dia incorrecto, mes con 28 días, introduzca un día entre 1 y 28");
        }
        else
              this.dia=dia;  
    } 
    else
        if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12){
        if(dia > 31){
            System.out.println("día incorrecto, mes con 31 días, introduzca un día entre 1 y 31");
        }
        else this.dia=dia;
        }
        else 
            if(mes==4 || mes==6 || mes==9 || mes==11){
            if(dia>30){
             System.out.println("día incorrecto, mes con 30 días, introduzca un día entre 1 y 30 ");
            }
            else this.dia=dia;
            }  
            }
   

    public int getdia(){
    return dia;
    }
    
    public void settipo(int tipo){
    if(tipo<0||tipo>1)
            System.out.println("tipo incorrecto, sólo puede ser 0 o 1");
    else this.tipo=tipo;
    }
    
    public int gettipo(){
    return tipo;
    }
    
    public void setcantidad(int cantidad){
  this.cantidad = cantidad;
    }
    
    public int getcantidad(){
    return cantidad;
    }

    public String toString(){
    return (" El mes es " +mes+ " el día es " +dia+ " la accion es " +tipo+ " y la cantidad de dias es " +cantidad); 
}
    
    public Object clone(){
        Object obj=null;
        try{
            obj=(accion)super.clone();
         }catch(CloneNotSupportedException ex){}       
           return obj;
       }
}
