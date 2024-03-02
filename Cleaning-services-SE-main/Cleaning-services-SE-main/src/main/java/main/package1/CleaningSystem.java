package main.package1;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import cleaning.services.util.SendEmaill;
import cleaning.services.util.Admin; 
import cleaning.services.util.Customer;
import cleaning.services.util.DB;
import cleaning.services.util.Product;
import cleaning.services.util.Statistics;
import cleaning.services.util.Worker;
import cleaning.services.util.Invoice;
import java.util.logging.*;

public class CleaningSystem {
	
	private static final String DASH="---------------------------------------------";
	private static final String PRICE="Price: ";
	private static final String EMAILNOTFOUND="email doesnt exist!"+"\n";
	private static final String EQUALITYSIGNS="============================================="+"\n";
	private static final Logger logger = Logger.getLogger(CleaningSystem.class.getName());
	private static final String ENTEREMAIL="Enter Customer email ";
	private static final String NAME="NAME";
	private static final String CATEGORY="Category: ";
	private static final String PICTURE="Picture: ";
	private static final String SPECIAL_TREATMENT ="Special Treatment: ";
	private static final String MATERIAL="Material: ";
	private static final String STATUS="STATUS: ";
	private static final String DESCRIPTION="DEscription: ";
	public static void main(String[] args) throws NoSuchAlgorithmException {
	
		Logger rootLogger = Logger.getLogger("");
		for (Handler handler : rootLogger.getHandlers()) {
		    handler.setFormatter(new SimpleFormatter() {
		        @Override
		        public synchronized String format(LogRecord record1) {
		            return "\u001B[30m" + record1.getMessage() + "\u001B[0m";
		        }
		    });
		}


        
		Admin admin=new Admin();
		List<Customer>customers=new ArrayList<>();
		List<Worker>workers=new ArrayList<>();
		List<Statistics>statistics=new ArrayList<>();
		
		 Worker worker1=new Worker("Ali","1234",1000.0);
		    Worker worker2=new Worker("Mohammad","1434",1500.0);
		    Worker worker3=new Worker("sami","1534",1000.0);
		    workers.add(worker1);
		    workers.add(worker2);
		    workers.add(worker3);
		Customer razan=new Customer();
		
		razan.setFirstName("razan"); /////testing
		razan.setLastName("khammash");
		razan.setEmail("email");
		razan.setAddress("nablus");
		razan.setPhone("0599");
		customers.add(razan);
		
		Customer razan1=new Customer();////testing
		razan1.setFirstName("razan1");
		razan1.setLastName("khammash1");
		razan1.setEmail("email1");
		razan1.setAddress("nablus1");
		razan1.setPhone("05991");
		customers.add(razan1);
		
		Product p=new Product();
		p.setWeight(5.0);
		p.setFinishDate("5/6/2020");
		p.setStartDate("2/3/2019");
		p.setCategory("carpet");
		p.setDescription("descrip");
		p.setID("1");
		p.setLength(100.0);		
		p.setWidth(2.0);
		p.setWeight(3.0);
		p.setMaterial("material");
		p.setName(" name");
		p.setPicture("pro pic");
		p.setSpecialTreatment("special");
		p.setStatus("status");
		
		razan.addProduct(p);
		
		Product p1=new Product();
		p1.setWeight(2.0);
		p1.setFinishDate("5/7/2020");
		p1.setStartDate("2/7/2019");
		p1.setCategory("rug");
		p1.setDescription("descrip1");
		p1.setID("2");
		p1.setLength(200.0);		
		p1.setWidth(2.0);
		p1.setWeight(4.0);
		p1.setMaterial("material1");
		p1.setName(" name11");
		p1.setPicture("pro pic11");
		p1.setSpecialTreatment("special11");
		p1.setStatus("status11");
		razan.addProduct(p1);
		
		Product p2=new Product();
		p2.setWeight(2.0);
		p2.setFinishDate("5/7/2020");
		p2.setStartDate("2/7/2019");
		p2.setCategory("rug");
		p2.setDescription("descrip1");
		p2.setID("3");
		p2.setLength(1750.0);		
		p2.setWidth(2.0);
		p2.setWeight(4.0);
		p2.setMaterial("material2");
		p2.setName(" name22");
		p2.setPicture("pro pic22");
		p2.setSpecialTreatment("special22");
		p2.setStatus("status22");
		razan1.addProduct(p2);
		
		logger.info("\t\tAdmin Login Page\t\t\n");
	
		
		
	    	Scanner scanner=new Scanner(System.in);
		while(true) {
			logger.info("UserName ");
		String userName=scanner.nextLine();
		logger.info("Password ");
		String password=scanner.nextLine();
		if(admin.checkpass(password)&&admin.checkUser(userName))  
			break;
		logger.info("\n Your information is not valid try again !\n ");
		}
	    admin.setLoggedIn(true);
	     boolean exit=false;
	    int k=0;
	    while(!exit) {
	    	if(k==300)
	    		exit=true;
	    	logger.info("");
	    	logger.info("Enter the number of the serves you want!\n ");
	    	logger.info("*******************************************\n ");
	    	logger.info("**Add new Customer                press #1 **\n ");
	    	logger.info("**Edit Customer                   press #2 **\n ");
	    	logger.info("**Remove Customer                 press #3 **\n ");
	    	logger.info("**Print Customer full information press #4 **\n ");
	    
	    	logger.info("**Add new Product                 press #5**\n ");
	    	logger.info("**Edit product                    press #6 **\n ");
	    	logger.info("**Remove product                  press #7 **\n ");
	    	logger.info("**Print Product full information press  #8 **\n ");
	    	logger.info("**Print all Products for a Customer press #9 **\n ");
	    	logger.info("**Create a new Invoice for a specified product press #10 **\n ");
	    	logger.info("**Create a new Invoice for all products for a customer press #11 **\n ");
	    	logger.info("**Notify a Customer press #12 **\n ");
	    	logger.info("**Generate statistics press #13 **\n ");
	    	logger.info("**Pay an invoice press #14 **\n ");
	    	logger.info("**Print an invoice press #15 **\n ");
	    
	    	logger.info("**Track product                   press #16**\n ");
	    	logger.info("**Print Product report press #17 **\n ");
	    	logger.info("**Print worker report press #18 **\n ");
	    	logger.info("**Print system report press #19 **\n ");
	    int number=0;
	    int j=0;
	    
	    while(true) {
	    	j++;
	    	 if (j  == 300) {  // true at Integer.MAX_VALUE +1
	 	        break;
	 	      }
	    	
	    try {

	    number=scanner.nextInt();
	   
	    break;
	       }
	    catch (Exception e) {
	    	logger.info("Error! Invalid integer. Try again."+"\n");
	                        
	       }
	    }
	    scanner.nextLine();
	    
	    
	    switch(number) {
	    case 1: 	 
	    Customer owner=new Customer();
	    logger.info("Enter Customer First"+ NAME +"\n");
	    String name=scanner.nextLine();
	    owner.setFirstName(name);
	    logger.info("Enter Customer Last"+ NAME +"\n");
	    String lName=scanner.nextLine();
	    owner.setLastName(lName);
	    logger.info(ENTEREMAIL);
	    String email=scanner.nextLine();
	    owner.setEmail(email);
	    logger.info("Enter Customer phone "+"\n");
	    String phone=scanner.nextLine();
	    owner.setPhone(phone);
	    logger.info("Enter Customer address "+"\n");
	    String address=scanner.nextLine();
	    owner.setAddress(address);
	    if(!DB.haveCustomer(owner, customers)){
	    customers.add(owner);
	        if(DB.haveCustomer(owner, customers)) {
	        	logger.info("Customer was added successfully!"+"\n");
	        }
	    }
	    else {
	    	logger.info("the customer already exists!"+"\n");
	    }
	    break;  	
	   
	    case 2:
	    	logger.info(ENTEREMAIL);
	    String selectedEmail=scanner.nextLine();
	    if(!DB.sameCustomerEmail(selectedEmail, customers)) {
	    	logger.info("there is no customer with this email"+"\n");
	    	break;
	    }
	    
	    logger.info("Enter what you want to edit"+"\n");
	    String field=scanner.nextLine();
	    logger.info("Enter new value edit"+"\n");
	    String value=scanner.nextLine();
	    if(field.equals("name")) {
	    	DB.updateCustomerFName(selectedEmail, value, customers);
	    }
	    if(field.equals("phone")) {
	    	DB.updateCustomerPhone(selectedEmail, value, customers);
	    }
	    if(field.equals("address")) {
	        DB.updateCustomerAddress(selectedEmail, value, customers);
	    }
	     
	    logger.info("Customer was updated successfully!"+"\n");
	    	
	             break;
	    case 3:
	    	logger.info(ENTEREMAIL);
		String removeEmail=scanner.nextLine();
		if(!DB.sameCustomerEmail(removeEmail, customers)) {
			logger.info(EMAILNOTFOUND);
			break;
		}
		
		//confirm deletion 
		
		
	       DB.removeCustomer(removeEmail, customers);  
	       if(DB.removed(removeEmail, customers)) {
	    	   logger.info("customer was removed successfully!"+"\n");
	       }
		break;
		
	    case 4:
	    	logger.info(ENTEREMAIL);
	 	   	String customerEmail=scanner.nextLine();
	 	   if(!DB.sameCustomerEmail(customerEmail, customers)) {
	 		  logger.info(EMAILNOTFOUND);
				break;
				}
	 	   	Customer x=DB.returnCustomer(customerEmail, customers);
	 	   	x.print();
	 	   	break;
	  
	    case 5:
	    	logger.info("Please enter the email of the customer you want to a add product to!"+"\n");
	    	String productOwnerEmail=scanner.nextLine();
	    	Product product=new Product();
	    	
	    	logger.info("Please enter the product id"+"\n");
	    	String proID=scanner.nextLine();
	    	product.setID(proID);
	    	if(DB.haveProduct(productOwnerEmail,product,customers)) {
	    		logger.info("product already exists"+"\n");
	    		break;
	    	}
	    	
	    	
	    	logger.info("Please enter the product category"+"\n");
	    	String proCat=scanner.nextLine();
	    	product.setCategory(proCat);
	    	
	    	logger.info("Please enter the product description"+"\n");
	    	String proDesc=scanner.nextLine();
	    	product.setDescription(proDesc);
	    	
	    	logger.info("Please enter the product Material "+"\n");
	    	String proMat=scanner.nextLine();
	    	product.setMaterial(proMat);
	    	
	    	logger.info("Please enter the product"+ NAME +"\n");
	    	String proName=scanner.nextLine();
	    	product.setName(proName);
	    	
	    	logger.info("Please enter the product special treatment"+"\n");
	    	String proTreat=scanner.nextLine();
	    	product.setSpecialTreatment(proTreat);
	    	
	    	logger.info("Please enter the product status"+"\n");
	    	String proStatus=scanner.nextLine();
	    	product.setStatus(proStatus);
	    	
	    	logger.info("Please enter the product start date"+"\n");
	    	String date1=scanner.nextLine();
	    	product.setStartDate(date1);
	    	
	    	logger.info("Please enter the product expected finish date"+"\n");
	    	String date2=scanner.nextLine();
	    	product.setFinishDate(date2);
	    	
	    	logger.info("Please enter the product picture"+"\n");
	    	String pic=scanner.nextLine();
	    	product.setPicture(pic);
	    	
	    	logger.info("Please enter the product length"+"\n");
	    	double proLen=scanner.nextDouble();
	    	product.setLength(proLen);
	    	
	    	logger.info("Please enter the product width"+"\n");
	    	double proWidth=scanner.nextDouble();
	    	product.setWidth(proWidth);
	    	
	    	logger.info("Please enter the product weight"+"\n");
	    	double proWeight=scanner.nextDouble();
	    	product.setWeight(proWeight);
	    	product.calculatePrice(); ////to set the price
	    
	    	
	    	DB.addProductTo(productOwnerEmail,product,customers);
	    	if(DB.haveProduct(productOwnerEmail,product,customers)) {
	    		logger.info("product was added succesfully"+"\n");
	    		DB.assignProductToWorkers(product, workers);
	    		
	    	}else {
	    		logger.info("product was not added"+"\n");
	    	}
	    	break;
	  
	    case 6:	logger.info("Please enter the email of the customer you want to a edit product!"+"\n");
    	        String ownerEmailEdit=scanner.nextLine();
    	        logger.info("Please enter the id of product you want to edit!"+"\n");
    	        String idP=scanner.nextLine();
    	        Product product1=new Product();
                product1.setID(idP);
 		 	    if(!DB.haveProduct(ownerEmailEdit, product1, customers))
 		 	    {
 		 	    	logger.info("This ID is not exist"+"\n");
 		 	    	 break;
 		 	    }
 		 	  logger.info("if you want to update name press 1\nif you want to update category press 2\nif you want to update description press"
 		    	 		+ " 3\nif you want to update picture press 4\nif you want to update material press 5\nif you want to update the special treatment case press 6\n"
 		    	 		+ "if you want to update the length press 7\n if you want to update the width case press 8\n if you want to update the weight case press 9\nif you want to update the start date case press 10\nif you want to update the finish date case press 11\nif you want to update the status case press 12\n");
 		    	 int updateField=scanner.nextInt();
 		    	 scanner.nextLine();
 		    	logger.info("please enter the new value");
 		    	 String  newValue=scanner.nextLine();
 		    	 DB.updateProductInfo(updateField,newValue,idP,ownerEmailEdit,customers);
 		    	logger.info("the product was updated successfully"+"\n");
 		    	 break;
 		 	    
	          case 7: logger.info("Please enter the email of the customer you want to a remove product!"+"\n");
  	        String ownerEmailRemove=scanner.nextLine();
  	      logger.info("Please enter the id of product you want to remove!"+"\n");
  	        String idP1=scanner.nextLine();
  	        DB.removeProduct(idP1,ownerEmailRemove,customers);
  	        break;
	          case 8:
	        	  logger.info("Please enter the email of the customer you want to print product!"+"\n");
	    	        String ownerEmailPrint=scanner.nextLine();
	    	        logger.info("Please enter the id of product you want to print!"+"\n");
	    	        String idProdctPrint=scanner.nextLine();
	        	  DB.printProduct(ownerEmailPrint,idProdctPrint,customers);
	        	  ///add "product does not exist" and "customer does not exist"
  	        break;
	          case 9:
	        	  logger.info("Please enter the email of the customer you want to print product!"+"\n");
	    	        String email1=scanner.nextLine();
	        	  DB.printAllProducts(email1, customers);
  	        break;
	          case 10:
	        	  logger.info(ENTEREMAIL);
	  	 	   	String email2=scanner.nextLine();
	  	 	   if(!DB.sameCustomerEmail(email2, customers)) {
	  	 		logger.info(EMAILNOTFOUND);
	  				break;
	  				} 
	  	 	logger.info("Enter The product ID");
	  	    String id=scanner.nextLine();
	  	 Invoice i1=  DB.createInvoiceProduct(email2, id, customers);
	  	 logger.info("if this invoice is paid press 1 "+"\n");
          int answer1=scanner.nextInt();
           if(answer1==1) {
        	   i1.setPaid(true);
           i1.printInvoice();
           }
	         break;
	          case 11:
	        	 
	        	  logger.info(ENTEREMAIL);
		  	 	   	String email3=scanner.nextLine();
		  	 	     if(!DB.sameCustomerEmail(email3, customers)) {
		  	 	    	 logger.info(EMAILNOTFOUND);
		  				break;
		  				} 
	                Invoice i= DB.createInvoiceALLProducts(email3, customers);
	                    
	                    //we should delete all products here
	                logger.info("if this invoice is paid press 1 ");
	                    int answer=scanner.nextInt();
	                     if(answer==1)
	    {i.setPaid(true); i.printInvoice();}
	        	  
	    
	                    break;
	          case 12:
	        	 SendEmaill s1=new SendEmaill();
	        	  s1.email("razanmohamad262@gmail.com", "Your order is ready");
	        	  
	        	  break;
	        	  
	          case 13:
	        	  Statistics s=new Statistics();
	        	  s.setCustomers(customers);
	        	  s.printStatistics();
	        	  statistics.add(s);
	        	  break;
	        	  
	          case 14:
	        	  logger.info("Enter Invoice ID");
		  	 	   	int invoiceId=scanner.nextInt();	
                   DB.payInvoice(customers, invoiceId);
	        	  break;
	          case 15:
	        	  logger.info("Enter Invoice ID");
		  	 	   	int invoiceId1=scanner.nextInt();	
		  	 	  DB.printInvoice(invoiceId1,customers);
	        	  break;
	          case 16: 
	        	  logger.info("enter the email of customer you want to track"+"\n");
	  	        String trackEmail=scanner.nextLine();
	  	      logger.info("Enter Product ID ");
	  	        String trackProduct=scanner.nextLine();
	  	      logger.info("the product "+trackProduct+"is "+ DB.trackCustomer(trackEmail,trackProduct,customers)+"\n");
	    	     break;   
	  	        case 17:
	  	        	CleaningSystem.productReport(customers);
	  	        	break;
	  	        case 18:
	  	        	CleaningSystem.workerReport(workers);
	  	        	break;
	  	        case 19:
	  	        	CleaningSystem.report(customers);
	    	        break;
	  	      
	    	        default :

	    }//switch
	    
	    }//while
	    	
	
	}//main method
	public static void customerReport(List<Customer> customers) {
logger.info("Customer Report:");
	
		    for (Customer customer : customers) {
		    	 logger.info(NAME+":"+ customer.getFName() +"\n");
		    	 logger.info("Phone: " + customer.getPhone()+"\n");
		    	 logger.info("Email: " + customer.getMail()+"\n");
		    	 logger.info("Address: " + customer.getAddress()+"\n");
		    	 logger.info(EQUALITYSIGNS);
		
	}
		    
		    

	
}
	
	public static void productReport(List<Customer> customers) {
		for (Customer customer : customers) {
			 logger.info("Customer: " + customer.getFName()+"\n");
			 logger.info(EQUALITYSIGNS);
			 logger.info("Products:"+"\n");

        List<Product> products = customer.getProducts();
        if (products.isEmpty()) {
        	 logger.info("No products found."+"\n");
        } else {
        
            for (Product product : products) {
            	 logger.info("ID: " + product.getID()+"\n");
            	 logger.info(CATEGORY+ product.getCategory()+"\n");
            	 logger.info(NAME+" :" + product.getName()+"\n");
            	 logger.info(PICTURE + product.getPicture()+"\n");
            	 logger.info(MATERIAL + product.getMaterial()+"\n");
            	 logger.info(SPECIAL_TREATMENT+ product.getSpecialTreatment()+"\n");
            	 logger.info(DESCRIPTION+ product.getDescription()+"\n");
            	 logger.info(STATUS + product.getStatus()+"\n");
            	 logger.info(PRICE+ product.getPrice()+"\n");
            	 logger.info(DASH+"\n");
            }
        }

        logger.info(EQUALITYSIGNS);
    }
		
	}
	public static void workerReport(List<Worker> workers) {
		logger.info("Worker Report:"+"\n\n");
        logger.info("===============\n\n");
  
    for (Worker worker : workers) {
    	 logger.info(NAME+": "+ worker.getName()+"\n");
    	 logger.info("ID: " + worker.getId()+"\n");
    	 logger.info("Salary: $" + worker.getSalary()+"\n");
    	 logger.info("products working on :"+"\n");
        List<Product> products = worker.getProduct();
        for (Product product : products) {
        	 logger.info("ID: " + product.getID()+"\n");
        	 logger.info(CATEGORY+ product.getCategory()+"\n");
        	 logger.info(NAME+ product.getName()+"\n");
        	 logger.info(PICTURE+ product.getPicture()+"\n");
        	 logger.info(MATERIAL + product.getMaterial()+"\n");
        	 logger.info(SPECIAL_TREATMENT + product.getSpecialTreatment()+"\n");
        	 logger.info(DESCRIPTION + product.getDescription()+"\n");
        	 logger.info(STATUS + product.getStatus()+"\n");
        	 logger.info(PRICE+ product.getPrice()+"\n");
        	 logger.info(DASH+"\n");
        	 logger.info("--------------------"+"\n");
        }
        }	
	}
	
public static void report(List<Customer> customers) {
		
		for (Customer customer : customers) {
			 logger.info(NAME+": " + customer.getFName()+"\n" );
			 logger.info("Phone: " + customer.getPhone()+"\n");
			 logger.info("Email: " + customer.getMail()+"\n");
			 logger.info("Address: " + customer.getAddress()+"\n");
			 logger.info("Products:"+"\n");

	        List<Product> products = customer.getProducts();
	        if (products.isEmpty()) {
	        	 logger.info("No products found."+"\n");
	        } else {
	            for (Product product : products) {
	            	 logger.info("ID: " + product.getID()+"\n");
	            	 logger.info(CATEGORY+": " + product.getCategory()+"\n");
	            	 logger.info(NAME+": "+ product.getName()+"\n");
	            	 logger.info(PICTURE+ product.getPicture()+"\n");
	            	 logger.info(MATERIAL+ product.getMaterial()+"\n");
	            	 logger.info(SPECIAL_TREATMENT + product.getSpecialTreatment()+"\n");
	            	 logger.info(DESCRIPTION+ product.getDescription()+"\n");
	            	 logger.info(STATUS + product.getStatus()+"\n");
	            	 logger.info(PRICE+ product.calculatePrice()+"\n");
	            	 logger.info(DASH+"\n");
	            }
	        }
	          
	}
		
		
}            

	

}//class
