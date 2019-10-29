/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nevzat_taha_batmaz_hw4;

import java.io.*;
import java.util.Scanner;


/**
 *
 * @author Taha
 */
public class chash implements HW4_Interface {
  
    public int pos = 0;
   
    public class LinkedHashEntry 
{
    String key;
    int value;
    LinkedHashEntry next;
    int count;
    int pos;
    LinkedHashEntry(String key, int value,int count,int pos) 
    {
        this.pos = pos;
        this.count = count ;
        this.key = key;
        this.value = value;
        this.next = null;
    }
    
}
   
    public int tablesıze;
    public int sıze; 
    public LinkedHashEntry[] table;

   
    public void BuildHash(String filename, int size) throws IOException {
        sıze = 0;
        tablesıze = size;
        table = new LinkedHashEntry[tablesıze];
        
        
        for (int i = 0; i < tablesıze; i++){
            table[i] = null;
        }
      
          int lineCount = 0;
          int wordCount = 0;
          FileReader myReader = null;
          myReader = new FileReader(filename);
          BufferedReader br = new BufferedReader(myReader);
          String str;
           while ((str = br.readLine()) != null)
        {
             lineCount++;
              for (int i = 0; i < str.length(); i++)
            {
                char c = str.charAt(i);

                str = str.toLowerCase();

              
                if (c == ' ')
                {
                    wordCount++;
                }
            }
        }
           myReader.close();
           wordCount += lineCount;
              
           File file =new File(filename);
           Scanner f =new Scanner(new FileReader(file));
           
           for (int i=1;i<wordCount;i++){
           String abc = f.next();
           
           InsertHash(abc);
           }
          
       
      
      
           
                
        
    }

   
    public long ConvertInt(String mystring) {
        long hashVal = hashCode(mystring);
        return  FindHash(hashVal);
        
    }

    
    public int FindHash(long myvalue) {
        myvalue %= tablesıze;
        if (myvalue < 0)
        myvalue += tablesıze;
        long x = myvalue;
        return (int) x;
    }

   
    public void InsertHash(String mystring) {
       int hash = (int)(ConvertInt( mystring ) % tablesıze);
       pos++;
      // while (entry != null && !entry.key.equals(mystring))
        int say=1;
        
        if (table[hash] == null)
            table[hash] = new LinkedHashEntry(mystring, hash,say,pos);
        else 
        {
           LinkedHashEntry entry = table[hash];
            while (entry.next != null && !entry.key.equals(mystring))
                entry = entry.next;
               
                
            if (entry.key.equals(mystring)){
                entry.value = hash;
                entry.count++;
                
            }
            else
                
                entry.next = new LinkedHashEntry(mystring, hash,say,pos);
        }
        sıze++;
    }
//String Outputfile
    
    public void Display(String Outputfile)throws IOException {
        
        FileWriter file =new FileWriter(Outputfile);
       BufferedWriter yaz=new BufferedWriter(file);
        
         int z = 0;
         int[] deneme = new int[10000];
         String[] isimler = new String[10000];
        
         int cnt = 0 ;
        for (int i = 0; i < tablesıze; i++)
        {
           
            
            LinkedHashEntry entry = table[i];
           
            
                
            while(entry!=null){
               cnt++;
               isimler[z] = entry.key;
               deneme[z] = entry.count;
               z++;
               entry=entry.next;
              
         }
        }
             String dönüs[] = new String[10000];
             for(int u = 0; u<cnt;u++){
                 
                  dönüs[u] = Integer.toString(deneme[u]); 
             }
            
      
          String tre = null;
          String oye = null;
         for(int o = 0; o<cnt;o++) {
             tre=isimler[o];
             oye=dönüs[o];
             yaz.write(tre);
             yaz.write(" "+oye);
             yaz.newLine();
              
         }  
              if (yaz != null)
	      yaz.close();
	      if (file != null)
	      file.close();
        
        
           
        
    }
    
    

    
    public int NumofWord(String myword) {
        int nummm = 0;
        for (int i = 0; i < tablesıze; i++)
        {
           
            LinkedHashEntry entry = table[i];
            while(entry!=null){
            if(entry.key.equals (myword)) {
             nummm= entry.count; 
           }
           entry=entry.next;
         }
        }
        
                
       return nummm;
  }

    
    public String ShowMax() {
         String maxim =null;
         int max = 0;
        for (int i = 0; i < tablesıze; i++)
        {
           
            
            LinkedHashEntry entry = table[i];
           
            
                
            while(entry!=null){
                if(entry.count > max){
                    max = entry.count;
                    maxim=entry.key;
                }
               
               entry=entry.next;
         }
           
        
    }
        
        return maxim;
    }

    
    public int CheckWord(String myword) {
        int nummm=0;
        int numx = 0 ;
         for (int i = 0; i < tablesıze; i++)
        {
           
            LinkedHashEntry entry = table[i];
            while(entry!=null){
            if(entry.key.equals (myword)) {
             nummm= entry.pos; 
             numx = entry.count;
           }
           entry=entry.next;
         }
        }
       return nummm;
    }
//
    
  
    public void Sort(String Outfile) {
       try{
        FileWriter file =new FileWriter(Outfile);
       BufferedWriter yaz=new BufferedWriter(file);
        
         int z = 0;
         int[] deneme = new int[10000];
         String[] isimler = new String[10000];
        
         int cnt = 0 ;
        for (int i = 0; i < tablesıze; i++)
        {
           
            
            LinkedHashEntry entry = table[i];
           
            
                
            while(entry!=null){
               cnt++;
               isimler[z] = entry.key;
               deneme[z] = entry.count;
               z++;
               entry=entry.next;
              
         }
         
          
           
        
    }
            int temp = 0;
            String tempx = null;
             for(int k=0; k < cnt; k++){  
                 for(int j=1; j < (cnt-k); j++){  
                          if(deneme[j-1] < deneme[j]){  
                                 //swap elements  
                                 temp = deneme[j-1];  
                                deneme[j-1] = deneme[j];  
                                 deneme[j] = temp; 
                                 tempx = isimler[j-1];  
                                isimler[j-1] = isimler[j];  
                                 isimler[j] = tempx; 
                         }  
                          
                 }  
         } 
             String dönüs[] = new String[10000];
             for(int u = 0; u<cnt;u++){
                 
                  dönüs[u] = Integer.toString(deneme[u]); 
             }
            
      
          String tre = null;
          String oye = null;
         for(int o = 0; o<cnt;o++) {
             tre=isimler[o];
             oye=dönüs[o];
             yaz.write(tre);
             yaz.write(" "+oye);
             yaz.newLine();
            
         }  
        
        if (yaz != null)
        yaz.close();
        if (file != null)
	file.close();
       }
        catch (IOException e) {     	
          e.printStackTrace();
       }
                    
            
        
    }
    public long hashCode(String mystring){
        long toplam = 0;
        int extra;
          char[] convert=new char[mystring.length()];
          convert=mystring.toCharArray();
          for(int i=0;i<mystring.length();i++){
              extra = i * i * i;
              char x=convert[i];
              int ascii =x;              
              toplam += extra * ascii;
    }
          return toplam;
        
    }
    
}
 //C:\Users\Taha\Desktop\deneme.txt