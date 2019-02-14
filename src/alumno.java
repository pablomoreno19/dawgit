public class alumno extends individuo implements Cloneable{
    
     /**
      * @author Pablo Moreno
      * @version 1.0
      */
    
    //cambio para comprobar funcionamiento pablo moreno cantos
    
    private int matricula;
    private String curso;
    
    public alumno(){
    super();
    matricula=1;
    curso="";
    }
    
    public alumno(String dni, String nombre, int total, accion [] acciones, int matricula, String curso){
    super(dni,nombre, total, acciones);
    if(matricula<=0)
            System.out.println("No se pueden meter números negativos");
        else this.matricula = matricula;
    
      if(valido(curso)==true){
        this.curso = curso;
       
        }
        else{
            this.curso="invalido";
        }
  
      
    }
    
      public static boolean valido(String curso) {
        for (int i = 0; i < curso.length(); i++) {
            if (!Character.isAlphabetic(curso.charAt(i)) && !Character.isDigit(curso.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public alumno(alumno x){
    super(x.getdni(),x.getnombre(),x.gettotal(),x.getacciones());
    this.matricula = x.matricula;
    this.curso = x.curso;
    }
    
    public void setmatricula(int matricula){
        if(matricula<=0)
            System.out.println("No se pueden meter números negativos");
        else this.matricula = matricula;
    }
    
    public int getmatricula(){
    return matricula;
    }
    
    public void setcurso(String curso){
        if(valido(curso)==true){
        this.curso = curso;
       
        }
        else{
            this.curso="invalido";
        }

    }
    
    public String getcurso(){
    return curso;
    }
    
    public String toString(){
return(super.toString() + " número de matrícula " +matricula+ " y nombre del curso: "+curso);
}
}

