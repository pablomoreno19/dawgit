 /**
      * @author Pablo Moreno
      * @version 1.0
      */

import java.util.Scanner;
import java.util.ArrayList;

public class prueba {
    
     public static boolean comprobardni(String dni, ArrayList <individuo> gestion){
         
         boolean correcto=false;
         //esto es la prueba del soso de pablo moreno cantos rodados
         //2 prueba
     
     for(int i=0;i<gestion.size();i++){
        
            if(dni.equals(gestion.get(i).getdni())){
            
                 correcto=true;
                 i=gestion.size()+1;
            }
           
    }
     
     return correcto;
     }
     
     public static boolean comprobarmatricula(int matricula, ArrayList <individuo> gestion){
     
         boolean correcto = false;
         
         for(int i=0; i<gestion.size();i++){
         
             if(gestion.get(i)instanceof alumno)
             if(((alumno)gestion.get(i)).getmatricula()==matricula){
                 
                 correcto=true;
             i=gestion.size()+1;
             
             
         }
   
     }
     
     return correcto;
}
     
    
     public static int devolverposicion(String dni, ArrayList <individuo> gestion){
     
         int a=-1;
     
     for (int i=0;i<gestion.size();i++){
     
         if(dni.equals(gestion.get(i).getdni()))
 
             a=i;
             
         i=gestion.size()+1;      
             
     }
     
   return a;
     }
   
    public static void main(String[] args) {
        
         int x,y=0,dia,mes,matricula, posicion,tipo, diastotal;
         String n, nom, curso, dni;
         ArrayList <individuo> gestion = new <individuo> ArrayList();
         Scanner tecla = new Scanner(System.in);
         DaVinci d = new DaVinci("davinci",gestion);
         
         
        System.out.println("*****************************************************************");
        System.out.println("*Hola, bienvenido al sistema de gestión de comunidades Hulio 2.0*");
        System.out.println("*****************************************************************");
             
        System.out.println("¿Qué quieres crear?");
        
          do{
        System.out.println("Menú de creación");
        
        System.out.println("0. Añadir Individuo  1. Añadir Alumno  2. Registrar acción   3. Cumplir sanción  4. Ver saldo");
              System.out.println("5. Premiar   6. Mostrar alumnos   7. Modificar nombre   8. Modificar curso");
        System.out.println("9. Total de acciones   10. Ver saldo de todos los usuarios   11. Mostrar ToString   12. Salir");
        
        x=tecla.nextInt();
        
             switch (x) {
                 case 0:
                     System.out.println("Elegiste añadir un Individuo");
                     System.out.println("Introduce su DNI");
                     dni = tecla.next();
                     if(comprobardni(dni, d.getgestion())==false){
                         System.out.println("Introduce un nombre");
                         nom=tecla.next();
                         d.añadir(new individuo(dni,nom,0,new accion[30]));
                     }
                     else
                         System.out.println("DNI ya registrado");
                     break;
                 case 1:
                     System.out.println("Elegiste añadir un alumno");
                     System.out.println("Introduce su DNI");
                     dni = tecla.next();
                     System.out.println("Introduce su matrícula");
                     matricula= tecla.nextInt();
                     if(comprobardni(dni, d.getgestion())==false && comprobarmatricula(matricula,d.getgestion())==false){
                         System.out.println("Introduce un nombre para el alumno");
                         nom = tecla.next();
                         System.out.println("Introduce nombre del curso");
                         curso = tecla.next();
                         
                         d.añadir(new alumno(dni,nom,0,new accion[30],matricula,curso));
                         
                     }
                     else
                         System.out.println("alumno ya registrado");
                     break;
                 case 2:
                     System.out.println("Elegiste registrar acción");
                     System.out.println("Introduce el DNI del usuario al que quieres registrarle una acción");
                     dni=tecla.next();
                     posicion=devolverposicion(dni, d.getgestion());
                     if(posicion>=0){
                         
                         System.out.println("Introduce el día: ");
                         dia=tecla.nextInt();
                         System.out.println("Introduce el mes: ");
                         mes=tecla.nextInt();
                         System.out.println("Introduce el tipo: 0 para sanción, 1 para servicio ");
                         tipo=tecla.nextInt();
                         System.out.println("Introduce el nº de días ");
                         diastotal=tecla.nextInt();
                         
                         d.getgestion().get(posicion).registraraccion(new accion(dia,mes,tipo,diastotal));
                         
                     }
                     
                     else
                         
                         System.out.println("DNI no encontrado");
                     break;
                 case 3:
                     System.out.println("Elegiste cumplir sanción");
                     System.out.println("Introduce el DNI del usuario al que quieres registrarle una acción");
                     dni=tecla.next();
                     posicion=devolverposicion(dni, d.getgestion());
                     if(posicion>=0){
                         
                         System.out.println("Introduce el día: ");
                         dia=tecla.nextInt();
                         System.out.println("Introduce el mes: ");
                         mes=tecla.nextInt();
                         
                         d.getgestion().get(posicion).cumplirsancion(dia, mes);
                         
                     }
                     
                     else
                         
                         System.out.println("DNI no encontrado");
                     break;
                 case 4:
                     System.out.println("Elegiste ver saldo");
                     System.out.println("Introduce el DNI del usuario del que quieres consultar su saldo");
                     dni=tecla.next();
                     posicion=devolverposicion(dni, d.getgestion());
                     if(posicion>=0){
                         
                         int c= d.getgestion().get(posicion).getsaldo();
                         
                         if(c>=0){
                             
                             System.out.println("tiene " +c+ " días de trabajo");
                         }
                         
                         else System.out.println("Tiene " +c+ " días de sanción");
                         
                     }         break;
            
             
        
             case 5:
            System.out.println("Elegiste premiar");
            
            d.premiar();
            
        break;
        
             case 6:
            System.out.println("Elegiste mostrar alumnos");
            
            d.mostraralumno();
            
        break;
        
             case 7:
            System.out.println("Elegiste modificar nombre");
            
         System.out.println("Introduce el DNI del usuario del que quieres modificar su nombre");
            dni=tecla.next();
         System.out.println("Introduce el nuevo nombre");
            nom=tecla.next();
           
           d.modificarnombre(dni, nom);
           
        break;
        
             case 8:
            System.out.println("Elegiste modificar curso");
            System.out.println("Introduce el DNI del alumno del que quieres modificar su curso");
            dni=tecla.next();
            System.out.println("Introduce el nuevo curso");
            curso=tecla.next();
            
            d.modificarcurso(dni, curso);
         break;
        
             case 9:
            System.out.println("Elegiste mostrar todas las acciones");
            System.out.println("Introduce el número de matrícula del alumno del que quieras ver sus acciones");
            matricula=tecla.nextInt();

            d.veracciones(matricula);

        break;
            
        
             case 10:
            System.out.println("Elegiste ver el saldo de todos los usuarios"); 
            
            d.versaldo();
            
       break;
        
             case 11:
            System.out.println("Seleccionaste Mostrar ToString");
            System.out.println("Introduce el DNI del que quieras ver su ToString");
            dni=tecla.next();

           posicion=devolverposicion(dni, d.getgestion());
           
           if(posicion>=0){
             
               System.out.println(d.getgestion().get(posicion).toString());
             
           }
      
            else
            
                System.out.println("DNI no encontrado");
           break;
        }
          
          }
          while (x!=12);
          }
                 
          }
