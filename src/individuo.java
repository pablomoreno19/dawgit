public class individuo implements Cloneable {
    
     /**
      * @author Pablo Moreno
      * @version 1.0
      */
 
    private String nombre;
    private accion acciones[] = new accion[30];
    private int total;
    private String dni;
    
    public individuo(){
    this.nombre="";
    this.total=0;
    this.dni="";
    this.acciones=null;
    
    }
    
    public individuo(String dni, String nombre, int total, accion [] acciones){
    this.nombre = nombre;
    this.total = total;
    this.acciones = acciones;
    this.dni = dni;
    }
    
    public individuo (individuo x){
    this.nombre = x.nombre;
    this.total = x.total;
    this.acciones = x.acciones;
    this.dni = x.dni;
    }
    
    public void setnombre(String nombre){
    this.nombre = nombre;
    }
    
    public String getnombre(){
    return nombre;
    }
    
    public void setdni(String dni){
    this.dni=dni;
    }
    
    public String getdni(){
    return dni;
    }
    
    public void settotal(int total){
        
        this.total = total;

    }
    
    public int gettotal(){
        int a=0;
        for(int i=0;i<acciones.length;i++){
        if(acciones[i]!=null){
        a++;
        }
        }
    return a;
    }
    
    public void registraraccion(accion x){
        int z =acciones.length-1;
    for(int i=0;i<z;i++){
    if(acciones[i] == null){ 
        this.acciones[i]=x;
        z=i; 
        if(this.acciones[i].gettipo()==0){
        this.settotal(total-x.getcantidad());
        }
    
        else{
        this.settotal(total+x.getcantidad());
        }    }
    }
    }

    public void mostrar(){
    for(int i=0; i<acciones.length-1;i++)
        if(acciones[i]!=null){
            System.out.println(acciones[i].toString());
    }
    }
    
    public accion[] getacciones(){
    return acciones;
    }
    
    public String toString(){
    return (" El nombre es " +nombre+ " su dni es " +dni+ " y el total es " +total); 
    }
    
   
    
    public int getsaldo(){
    
        int diassancion=0;
        int diasdetrabajo=0;
        
        for(int i=0;i<acciones.length;i++){
            if(acciones[i]!=null){
        if(acciones[i].gettipo()==0)
            diassancion = diassancion + acciones[i].getcantidad();
          
          if(acciones[i].gettipo()==1)
             diasdetrabajo = diasdetrabajo + acciones[i].getcantidad();
            }
        
       
        
        }
         return diasdetrabajo-diassancion;
    }
    
    public void cumplirsancion(int dia, int mes){
        int a=0;
        for(int i=0;i<acciones.length;i++){
        if(acciones[i]!=null){
            if(acciones[i].getdia()== dia && acciones[i].getmes()== mes && acciones[i].gettipo()==0){
          
                a = acciones[i].getcantidad();
                registraraccion(new accion(dia+a,mes,1,a));
               acciones[i].setcantidad(0);
              
            
        }
        }
                }
    }
    
    public int cuentasanciones(){
    int total=0;
    
    for(int i=0;i<acciones.length;i++){
        if(acciones[i].gettipo()==0)
        total++;
    }
        return total;
    }
}
    
/*public Object clone(){
        individuo obj=null;
        try{
            obj=(individuo)super.clone();
         }catch(CloneNotSupportedException ex){}
        
       ((individuo)obj).accion = (accion)accion.clone();
        return obj;
       
       }
}*/