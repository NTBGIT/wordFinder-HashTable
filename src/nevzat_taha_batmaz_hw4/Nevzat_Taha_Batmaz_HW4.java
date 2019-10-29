/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nevzat_taha_batmaz_hw4;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Taha
 */
public class Nevzat_Taha_Batmaz_HW4 {

    /**
     * @param args the command line arguments
     */
   
        public static void main(String[] args) throws IOException {
         
        String str; 
        String qwe; 
        String trt; 
        Integer hashsize;
            System.out.println("Please enter file location: ");
            Scanner ntb = new Scanner(System.in);
            str = ntb.nextLine(); 
            System.out.println("Please enter hash size: ");
            Scanner ntbb = new Scanner(System.in);
            hashsize=ntbb.nextInt();
            System.out.println("Please enter outputfile location: ");
            Scanner pıp = new Scanner(System.in);
            trt = pıp.nextLine(); 
            System.out.println("Please enter for sort outfile location: ");
            Scanner xyz = new Scanner(System.in);
            qwe = xyz.nextLine(); 
            chash mydb= new chash();
            mydb.BuildHash(str,hashsize);
            mydb.Display(trt);
            System.out.println("\n" + mydb.NumofWord("creed") ) ;
            System.out.println("\n" + mydb.ShowMax());
            System.out.println("\n" + mydb.CheckWord("hayda"));
            System.out.println("\n" + mydb.NumofWord("hayda"));
            mydb.Sort(qwe);
        
        // TODO code application logic here
    }
        // TODO code application logic here
    }
    

