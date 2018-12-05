package jovanieLawrence;

import java.util.Scanner;

public class Multithread {

	public static void main(String[] args) {
		
		
			JohnLewisScraper object1 = new JohnLewisScraper(); 
			   AmazonScraper object2 = new AmazonScraper();
                           CurrysScraper object3 = new CurrysScraper();
                           VeryScraper object4 = new VeryScraper();
                           AppliancesDirectScraper object5 = new AppliancesDirectScraper();
			
			object1.start(); 
			object2.start(); 
                        object3.start();
                        object4.start();
                        object5.start();
			
		
		//Read input from user until they type 'stop'
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        
        while(!userInput.equals("stop")){
            userInput = sc.nextLine();
        }
        
        
        
        //Stop threads
        object1.stopThread();
        object2.stopThread();
        object3.stopThread();
        object4.stopThread();
        object5.stopThread();
		
        sc.close();
		

	}

}
