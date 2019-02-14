 /**
      * @author Pablo Moreno
      * @version 1.0
      */

import java.util.ArrayList;

//Modificación del proyecto para Inma

public class DaVinci {
 
    private String curso;
    private ArrayList <individuo> gestion = new <individuo> ArrayList();
    
    public DaVinci(){
    this.curso="";
    this.gestion = new <individuo> ArrayList();
    }
    
    public DaVinci(String curso, ArrayList <individuo> gestion){
    this.gestion=gestion;
    
    if(alumno.valido(curso)==true){
        this.curso = curso;
       
        }
        else{
            this.curso="invalido";
        }
    
    }
    
    public DaVinci(DaVinci x){
    x.curso=curso;
    x.gestion=gestion;
    }
    
    public void setcurso(String curso){
   
        this.curso = curso;
    
    if(alumno.valido(curso)==true){
        this.curso = curso;
       
        }
        else{
            this.curso="invalido";
        }
    }
    
    public String getcurso(){
    return curso;
    }


    public ArrayList<individuo> getgestion() {
        return gestion;
    }
    
    private boolean valido(String curso) {
        for (int i = 0; i < curso.length(); i++) {
            if (!Character.isAlphabetic(curso.charAt(i)) && !Character.isDigit(curso.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    public void añadir(individuo e){
    gestion.add(e);
    }
    
    public void versaldo(){
 
        for(int i=0;i<=gestion.size();i++){
            if(gestion.get(i).getsaldo()<0)
            System.out.println("Usuario: "+ gestion.get(i).getnombre()+ "tiene " +(-gestion.get(i).getsaldo())+ "días de sanción");           
        
            else System.out.println("Usuario: "+ gestion.get(i).getnombre()+ "tiene " +gestion.get(i).getsaldo()+ "días de trabajo");
        }
        
    } 
    
    public void veracciones(int matricula){
     
        for(int i=0;i<gestion.size();i++){
        
        if(gestion.get(i) instanceof alumno){ 
            
            if(((alumno)gestion.get(i)).getmatricula()==matricula){

            gestion.get(i).mostrar();
          
        }
                
        } 
  
            }
         
        }
        
    public void mostraralumno(){
        
        for(int i=0;i<gestion.size();i++){
    
        if(gestion.get(i) instanceof alumno){
           
            System.out.println("El alumno es" +(gestion.get(i)).getnombre()+ 
                    " y el nombre del curso es " +((alumno)gestion.get(i)).getcurso());
           
           
            
        }
        
    }
            
        }
    
    public int sorteo(){
        int numero=0;
        int i=10;
        int aux=-1;
              
        for(i=0;i<=9;i++){
        
            numero = (int) (Math.random() * gestion.size());
            
        }

        if(gestion.get(numero).getsaldo()>=0){
        i=10;
        
        aux=numero;
       
        }

       return aux;

       }
    

   
public void premiar(){
    
    int ganador;
    
    ganador = sorteo();
    
    if(ganador>=0){
        
        System.out.println("el ganador es : " +gestion.get(ganador).getnombre()
                + " y el premio es "+ (gestion.get(ganador).getsaldo())*10);
               
    
    }
    
    else System.out.println("No hay un ganador");
   
}

public void modificarcurso(String dni, String curso){
    boolean b=false;
    
for(int i=0;i<gestion.size();i++){

    if(((alumno)gestion.get(i)).getdni().equals(dni)  && (gestion.get(i)) instanceof alumno)
        
     ((alumno)gestion.get(i)).setcurso(curso);
    
    b=true;
}

if(b==true) System.out.println("Cambio realizado");
else System.out.println("Cambio no realizado");

}

public void modificarnombre(String dni, String nombre){
 boolean b=false;
    
for(int i=0;i<gestion.size();i++){

    if(((alumno)gestion.get(i)).getdni()==dni && (gestion.get(i)) instanceof alumno)
        
     (gestion.get(i)).setnombre(nombre);
    
    b=true;
}

if(b==true) System.out.println("Cambio realizado");
else System.out.println("Cambio no realizado");

}

}