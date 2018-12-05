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

//Hibernate imports
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateMapping {
    //Creates new Sessions when we need to interact with the database 
    private SessionFactory sessionFactory;
    
    public HibernateMapping() {}
    
    /** Sets up the session factory.
     *  Call this method first.  */
    public void init(){
        try{
            
            //Create a builder for the standard service registry
            StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
            
            //Load configuration from hibernate configuration file.
            //Here we are using a configuration file that specifies Java annotations.
           
            standardServiceRegistryBuilder.configure("resources/hibernate.cfg.xml"); 

            //Create the registry that will be used to build the session factory
            StandardServiceRegistry registry = standardServiceRegistryBuilder.build();
            try {
                //Create the session factory - this is the goal of the init method.
                sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            }
            catch (Exception e) {
                    /* The registry would be destroyed by the SessionFactory, 
                        but we had trouble building the SessionFactory, so destroy it manually */
                    System.err.println("Session Factory build failed.");
                    e.printStackTrace();
                    StandardServiceRegistryBuilder.destroy(registry);
            }

            //Ouput result
            System.out.println("Session factory built.");

        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("SessionFactory creation failed." + ex);
        }
    }
          /** Adds a new cereal to the database */
    public void addMobilephone(){
        
        try{
        //Get a new Session instance from the session factory
        Session session = sessionFactory.getCurrentSession();

        //Create an instance of a Cereal class 
        HibernateMobilePhones mobile = new HibernateMobilePhones();

        //Set values of Cereal class that we want to add
        mobile.setSpecifications_Id(1);
        mobile.setSupplier_Id(1);
        mobile.setModel_Id(1);
        mobile.setManufacturer("Apple");
        mobile.setPrice(299.5d);
        mobile.setReview("Great product!");

        //Start transaction
        session.beginTransaction();

        //Add Cereal to database - will not be stored until we commit the transaction
        session.save(mobile);

        //Commit transaction to save it to database
        session.getTransaction().commit();
        
        //Close the session and release database connection
        session.close();
        System.out.println("Smartphones added to database with ID: " + mobile.getId());
        }catch(HibernateException e){
            System.err.println("Could not find file." + e);
        }
    }
    
    /** Updates the values of an existing cereal in the database */
    public void updateMobilephone(){
        //Get a new Session instance from the session factory
        Session session = sessionFactory.getCurrentSession();

        //Create an instance of a Cereal class 
        HibernateMobilePhones mobile = new HibernateMobilePhones();
        
        //Set ID of cereal class - this controls the row in the table that we want to update
        mobile.setId(16);

        //Set values of mobile class that we want to add
        mobile.setSpecifications_Id(2);
        mobile.setSupplier_Id(2);
        mobile.setModel_Id(2);
        mobile.setManufacturer("Apple");
        mobile.setPrice(399.5d);
        mobile.setReview("Great product! however, was expecting a better camera");
        
        //Start transaction
        session.beginTransaction();

        //Update database to match class 
        session.update(mobile);
        session.getTransaction().commit();
        
        //Close the session and release database connection
        session.close();
        System.out.println("Smartphone updated in database. ID: " + mobile.getId());
    }
         /** Searches for Cereals whose price is 5.5 */
    public void searchMobile(){
        //Get a new Session instance from the session factory
        Session session = sessionFactory.getCurrentSession();

        //Start transaction
        session.beginTransaction();

        List<HibernateMobilePhones> mobileList = session.createQuery("from HibernateMobilePhones where price=399.5").getResultList();
        for(HibernateMobilePhones mobile : mobileList){
            System.out.println(mobile.toString());
        }
        
        //Close the session and release database connection
        session.close();
    }
    
    /** Deletes a cereal in a way that will work with tables with foreign keys */
    public void deleteMobile(){
        //Get a new Session instance from the session factory
        Session session = sessionFactory.getCurrentSession();
        
        //Start transaction
        session.beginTransaction();
        
        //Search for mobile in database that has ID of 6
        Object persistentInstance = session.load(HibernateMobilePhones.class, 1);
        
        //Delete object (and corresponding data) if we have found a match.
        if (persistentInstance != null) 
            session.delete(persistentInstance);

        //Update database
        session.getTransaction().commit();
        
        //Close the session and release database connection
        session.close();
        System.out.println("Cereal updated in database. ID: 6");
    }
    
     /** Closes Hibernate down and stops its threads from running*/
    public void shutDown(){
        sessionFactory.close();
    }
}


    
    

