/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package spacecadetemailchallenge;
import java.util.*;
import java.io.*;
import java.net.URL;

public class SpaceCadetEmailChallenge {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String emailID = null;
        String webCatch = null;
        URL url = null;
        String webPageAddition = "https://www.ecs.soton.ac.uk/people/";
        try{
            System.out.println("Please enter the email of the person you are trying to find:");
            BufferedReader x = new BufferedReader( new InputStreamReader(System.in));
            emailID = x.readLine();
            url = new URL(webPageAddition.concat(emailID));
            BufferedReader urlCatch = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            while((inputLine = urlCatch.readLine()) != null){
                
                if (inputLine.contains("\"name\"")){
                    int index = inputLine.indexOf("property=\"name\">");
                    webCatch = inputLine.substring(index);
                    index = webCatch.indexOf(">")+1;
                    //index now holds the position of the first letter of the name of 
                    //the person that the email id belongs to
                    int end = webCatch.indexOf("<");
                    webCatch = webCatch.substring(index, end);
                    System.out.println(webCatch);
                    
                }
                
                
            }
            urlCatch.close();
        }catch(Exception e){
            
        }
        
        
    }
    
}
