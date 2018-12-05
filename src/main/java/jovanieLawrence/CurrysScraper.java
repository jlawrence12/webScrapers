/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jovanieLawrence;

import java.io.IOException;
import static java.lang.Thread.sleep;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author jovanielawrence
 */
public class CurrysScraper extends Thread {
    	  //Specifies the interval between HTTP requests to the server in seconds.
    private int crawlDelay = 2;
    Document doc;
    String product = "mobile";
    
    //Allows us to shut down our application cleanly
    volatile private boolean runThread = false;
    
    @Override 
    public void run(){
        runThread = true;
       
        //While loop will keep running until runThread is set to false;
        while(runThread){
            
            System.out.println("The Curry's thread is currently scraping data.");
            try{
            doc = Jsoup.connect("https://www.currys.co.uk/gbuk/phones-broadband-and-sat-nav/mobile-phones-and-accessories/mobile-phones/362_3412_32041_xx_xx/xx-criteria.html").get();
             } catch(IOException ex){
                System.err.print(ex.getMessage());           
             }
            Elements content = doc.select(".product-card");
            
            for(int i=0; i<content.size(); i++){
                
                //Get description
                Elements description = content.get(i).select(".product-card_info");
                
                //Get title
                Elements title = content.get(i).select(".product-card_title");
                
                //Get price
                Elements price = content.get(i).select(".product-card_price");
                
                //Get reviews
                Elements reviews = content.get(i).select(".product-card_reviews");
                
                
                //Output the data that we have downloaded 
                System.out.println("Description: " + description.text() + "; Title: " + 
                        title.text() + "; Price: " + price.text() + "; Reviews: " + reviews.text());
                
            	}
            }
        
            //Sleep for the crawl delay, which is in seconds 
            try{
                sleep(1000 * crawlDelay);//Sleep is in milliseconds, so we need to multiply the crawl delay by 1000
            }
            catch(InterruptedException ex){
                System.err.println(ex.getMessage());
            }
        }
        
    //Other classes can use this method to terminate the thread.
    public void stopThread(){
        runThread = false;
    }
}

    

