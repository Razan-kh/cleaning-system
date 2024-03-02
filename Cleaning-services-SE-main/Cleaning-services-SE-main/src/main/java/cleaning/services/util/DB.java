package cleaning.services.util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DB {
private static final Logger logger = Logger.getLogger(DB.class.getName());
static List<Customer>allCustomers=new ArrayList<>();
static List<Worker>workers=new ArrayList<>();

private DB()
{
	
}
public static void createCustomer(Customer customer,List<Customer>array) {
	               array.add(customer);
}
public static void removeCustomer(String email,List<Customer> arr) {
	Iterator<Customer> iter = arr.iterator();
    while (iter.hasNext()) {
        Customer c = iter.next();
        if (c.getMail().equals(email)) {
            iter.remove();
        }
    } 
	
}
public static boolean haveCustomer(Customer customer, List<Customer> customers) {
	 for(Customer C:customers) {
		if(C.getMail().equals(customer.getMail()))
		    return true;
	 }
	return false;
}
public static boolean sameCustomerEmail(String email,List<Customer> customers) {
	 for(Customer C : customers)
    	 if(C.getMail().equals(email)){
	          return true;
    	 }
    	 return false;
}
public static void updateCustomerFName(String mail, String string, List<Customer> customers) {
	  for(Customer C: customers) {
      	if( C.getMail().equals(mail)) {
      		C.setFirstName(string);
      	}
       }
	
}
public static void updateCustomerLName(String mail, String string,List<Customer> customers) {
	 for(Customer C: customers) {
	      	if( C.getMail().equals(mail)) {
	      		C.setLastName(string);
	      	}
	       }
	
}
public static void updateCustomerPhone(String mail, String string,List<Customer> customers) {
	 for(Customer C: customers) {
	      	if( C.getMail().equals(mail)) {
	      		C.setPhone(string);
	      	}
	       }
	
}
public static void updateCustomerAddress(String mail, String string,List<Customer> customers) {
	 for(Customer C: customers) {
	      	if( C.getMail().equals(mail)) {
	      		C.setAddress(string);
	      	}
	       }
	
}
public static boolean exit(Customer doesnotExist,List<Customer> customers) {
    for(Customer C: customers) {
  	   if(C.getMail().equals(doesnotExist.getMail())){
  		   return true;
  	   }
     }
    return false;
}
public static boolean removed(String mail,List<Customer> customers) {
	for(Customer C:customers) {
		if(C.getMail().equals(mail)) {
			return false;
		}
	}
	return true;
}

public static Customer returnCustomer(String mail, List<Customer> customers) {
	for(Customer C:customers) {
		if(C.getMail().equals(mail)) {
			return C;
		}
	}
	return null;
}
public static void addProductTo(String productOwnerEmail, Product product, List<Customer> customers) {
	
	for(Customer C:customers) {
		if(C.getMail().equals(productOwnerEmail)) {
			C.addProduct(product);
			
		}
	}

}
public static boolean haveProduct(String productOwnerEmail, Product product, List<Customer> customers) {

	for(Customer C:customers) {
		if(C.getMail().equals(productOwnerEmail) &&C.have(product))
				return true;
	}
              return false;
}
public static void updateProductInfo(int updateField,String newValue, String idP, String ownerEmailEdit,
		List<Customer> customers) {

	extractedLogger();
	double newValue1;
	for(Customer C:customers) {
		
		if(C.getMail().equals(ownerEmailEdit)) {
			
		switch(updateField) {
		case 1: C.setProductName(idP, newValue);
		        break;
		
		case 2: C.setProductCategory(idP,newValue);
		        break;
		case 3: C.updateProductDescription(idP,newValue);
		       break;
			
		case 4: C.updateProductPicture(idP, newValue);
		           break;
			
		case 5: C.updateProductMaterial(idP,newValue);
	            break;
		case 6: C.updateProductSpecialTreatment(idP, newValue);
		        break;
		case 7:
			 newValue1=Double.parseDouble(newValue);
			C.updateProductLength(idP,  newValue1);
			
		      break;
		case 8:
			 newValue1=Double.parseDouble(newValue);
			C.updateProductWidth(idP, newValue1);    
		        break;
		case 9:
			newValue1=Double.parseDouble(newValue);
			C.updateProductWeight(idP, newValue1);
		        break;
		        
		case 10:       C.updateProductStartDate(idP,newValue);
		               break;
		case 11:    C.updateProductFinishDate(idP, newValue);  
		           break;
		case 12:     C.updateProductStatus(idP, newValue);  
		             break;
		default:
	
			logger.info("you entered wrong number\n");
			break;
		
				
		
				
				
				
				
				
			}
		}
	}
	
}
public static void extractedLogger() {
	Logger rootLogger = Logger.getLogger("");
	for (Handler handler : rootLogger.getHandlers()) {
	    handler.setFormatter(new SimpleFormatter() {
	        @Override
	        public synchronized String format(LogRecord record) {
	            return "\u001B[30m" + record.getMessage() + "\u001B[0m";
	        }
	    });
	}

}

public static void removeProduct(String idP1, String ownerEmailRemove,List<Customer> customers) {
	extractedLogger();
	Product p=new Product();
	p.setID(idP1);
	DB.removeOrderFromWorker(p,workers);
	for(Customer C:customers) {
		if(C.getMail().equals(ownerEmailRemove)) {
			Product prod=new Product();
			prod.setID(idP1);
			C.removeProduct(prod);
			if(!C.have(prod)) {
				logger.info("product was removed successfully\n");
				
			}
		}
	}
       
	
}
public static void printProduct(String customerEmail,String productId,List<Customer> customers)
{
	extractedLogger();
	for(Customer c :customers)
	{
		if(c.getMail().equals(customerEmail)) {
			for(Product p:c.getProducts())
			{
				if(p.getID().equals(productId))
				{
					logger.info("ID :" +p.getID()+"\n");
					logger.info("Name :" +p.getName()+"\n");
					logger.info("Category :" +p.getCategory()+"\n");
					logger.info("Special treatment :" +p.getSpecialTreatment()+"\n");
					logger.info("Price :" +p.calculatePrice()+"\n");
					logger.info("Status :" +p.getStatus()+"\n");
					logger.info("Picture :" +p.getPicture()+"\n");
					logger.info("Material :" +p.getMaterial()+"\n");
					logger.info("Description :" +p.getDescription()+"\n");
					logger.info("Start date :" +p.getStartDate()+"\n");
					logger.info("Finish Date :" +p.getFinishDate()+"\n");
					logger.info("Length :" +p.getLength()+"\n");
					logger.info("Width :" +p.getWidth()+"\n");
					logger.info("Weight :" +p.getWeight()+"\n");

				}
			}
			
		}
	}
}
public static void printAllProducts(String customerEmail,List<Customer> customers)
{
	extractedLogger();
	for(Customer c :customers)
	{
		if(c.getMail().equals(customerEmail)) {
			 
             for(Product p:c.getProducts())
              {
            	 logger.info("ID :" +p.getID()+"\n");
            	 logger.info("Name :" +p.getName()+"\n");
            	 logger.info("Category :" +p.getCategory()+"\n");
            	 logger.info("Special treatment :" +p.getSpecialTreatment()+"\n");
            	 logger.info("Price :" +p.calculatePrice()+"\n");
            	 logger.info("Status :" +p.getStatus()+"\n");
            	 logger.info("Picture :" +p.getPicture()+"\n");
            	 logger.info("Material :" +p.getMaterial()+"\n");
            	 logger.info("Description :" +p.getDescription()+"\n");
            	 logger.info("Start date :" +p.getStartDate()+"\n");
            	 logger.info("Finish Date :" +p.getFinishDate()+"\n");
            	 logger.info("Length :" +p.getLength()+"\n");
            	 logger.info("Width :" +p.getWidth()+"\n");
            	 logger.info("Weight :" +p.getWeight()+"\n");
            	 
              }
				
			
		}
	}
}
public static Invoice createInvoiceProduct(String customerEmail,String productId,List<Customer> customers)
{
	Invoice i;
	Customer c;

		   Iterator<Customer> it = customers.iterator();
				while (it.hasNext()) {
					 c= it.next();
				
					if(c.getMail().equals(customerEmail))
					{
						i=new Invoice(c, productId);
					    
				    	c.addInvoice(i);
				    	i.printInvoice();///testing
				  
			
	    	Iterator<Product> it1 = c.getProducts().iterator();
			while (it1.hasNext()) {
				Product p = it1.next();
			
				if (p.getID().equals(productId))
				{
					c.getProducts().remove(p);
				return i ;
				}
			}
			}
			}
	    	

	 return null;
}

public static Invoice createInvoiceALLProducts(String customerEmail,List<Customer> customers)
{
	Invoice i;

	 for(Customer C:customers) {
	    	if(C.getMail().equals(customerEmail)){
	    	 i=new Invoice(C);
	  
	    	C.addInvoice(i);
	    	i.printInvoice();
	    	C.deleteAllProducts();
	    	return i;
}
	    	

}
	 return null;
}

public static void payInvoice(List<Customer>customers,int id)
{
	for (Customer c : customers)
	{
		for (Invoice i:c.getInvoices())
		{
			if(i.getID()==id)
				i.setPaid(true);
		}
	}
}
public static void printInvoice(int invoiceId,List<Customer>customers) {
	for(Customer c:customers)
	{
		for(Invoice i:c.getInvoices())
		{
			if(i.getID()==invoiceId)
			{
				i.printInvoice();
			}
		}
	}
	
}
public static void addWorkerToSystem(List<Worker> list) {
    Worker worker1=new Worker("Ali","1234",1000.0);
    Worker worker2=new Worker("Mohammad","1434",1500.0);
    Worker worker3=new Worker("sami","1534",1000.0);
    list.add(worker1);
    list.add(worker2);
    list.add(worker3);
}
public static void assignProductToWorkers(Product product,List<Worker> list) {
	int indexOfLowNumber = -1;   // Initialize to -1 to indicate no worker found
	int number = Integer.MAX_VALUE; // Set to max value initially
	for (int i = 0; i < list.size(); i++) {
	    Worker w = list.get(i);
	    if (w.numberOfOrders() < number) {
	        number = w.numberOfOrders();
	        indexOfLowNumber = i;
	    }
	}
	if (indexOfLowNumber != -1) {
	    list.get(indexOfLowNumber).addProduct(product);
	} else {
	   logger.info("No worker found to assign product.\n");
	}
}

public static String trackCustomer(String customerEmail, String productID, List<Customer> customers) {
	String state=null;
	for(Customer C : customers)
   	 if(C.getMail().equals(customerEmail)){
	      state= C.trackOrder(productID);
	       
   	 }
	return state;
}
public static boolean specialEmail(String mail,List<Customer> customers) {
	for(Customer C:customers) {
		if(C.getMail().equals(mail))
		    return false;
	 }
	return true;
}
public static void removeOrderFromWorker(Product product, List<Worker> list) {
	for(Worker W:list) {
		if(W.contains(product.getID()))
			W.removedFromWorker(product.getID());
		
	}
	
}




















}//class