/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nevzat_taha_batmaz_hw4;

import java.io.IOException;

/**
 *
 * @author Taha
 */
public interface HW4_Interface {

 void BuildHash (String filename, int size)throws IOException;
 long ConvertInt(String mystring);
 int FindHash(long myvalue);
 void InsertHash(String mystring);
 void Display(String Outputfile)throws IOException;
 int NumofWord(String myword);
 String ShowMax ();
 int CheckWord(String myword);
 void Sort(String Outfile)throws IOException;

    
}
