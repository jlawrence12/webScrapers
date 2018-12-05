/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jovanieLawrence;

/**
 *
 * @author jovanielawrence
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create a new instance of the HibernateExample class
        HibernateMapping mapObj = new HibernateMapping();
        
        //Set up the SessionFactory
        mapObj.init();
        
       //Example operations
       mapObj.addMobilephone();//Add data
       // hibernateXmlExample.updateCereal();//Updates data
       //hibernateXmlExample.searchCereals();//Search for data
       //hibernateXmlExample.deleteCerealSafe();//Delete data
        
        //Shut down Hibernate
        mapObj.shutDown();
    }
    
}
