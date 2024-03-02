package cleaning.services.util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Customer {
	private static final Logger logger = Logger.getLogger(Customer.class.getName());
	  private String firstName;
	    private String lastName;
	    private String phone;
	    private String email;
	    private String address;
	    private List<Product>products=new ArrayList<>();
	    private List<Invoice>invoices=new ArrayList<>();  
		public void print() {
DB.extractedLogger();
	        logger.log(Level.INFO, "First Name: {0}", firstName);
	        logger.log(Level.INFO, "Last Name: {0}", lastName);
	        logger.log(Level.INFO, "Phone: {0}", phone);
	        logger.log(Level.INFO, "Email: {0}", email);
	        logger.log(Level.INFO, "Address: {0}", address);

		}
	     public void setFirstName(String string) {
	        firstName=string;
			
		}

		public void setLastName(String string) {
		      lastName=string;
		}
		
		public void setAddress(String string) {
		    address=string;
		}

		public void setEmail(String string) {
		   email=string;
		}

		public void setPhone(String string) {
			phone=string;
		}

		public String getMail() {
			return email;
		}
		public void addProduct(Product a)
		{
			products.add(a);
			
		}
		public void removeProduct(Product selectedProduct)
		{
			Iterator<Product> iterator = products.iterator();
			while (iterator.hasNext()) {
			    Product p = iterator.next();
			    if (p.getID().equals(selectedProduct.getID())) {
			        iterator.remove();
			    }
			}
			
		}
		public void setProductName(String id,String string) {
			for(Product P: products) {
		    	if( P.getID().equals(id)) {
		    		P.setName(string);
		    	}
		     }
			}
		
		
		public void setProductCategory(String id,String string) {
			for(Product P: products) {
		    	if( P.getID().equals(id)) {
		    		P.setCategory(string);
		    	}
		     }
		}
		public void updateProductStatus(String id, String string) {
			for(Product P: products) {
		    	if( P.getID().equals(id)) {
		    		P.setStatus(string);
		    	}
		     }
			
		}
		public void updateProductDescription(String id, String string) {
			for(Product P: products) {
		    	if( P.getID().equals(id)) {
		    		P.setDescription(string);
		    	}
		     }
			
		}
		public void updateProductWidth(String id, Double double1) {
			for(Product P: products) {
		    	if( P.getID().equals(id)) {
		    		P.setWidth(double1);
		    	}
		     }
			
		}
		public void updateProductWeight(String id, Double double1) {
			for(Product P: products) {
		    	if( P.getID().equals(id)) {
		    		P.setWeight(double1);
		    	}
		     }
			
		}

		public void updateProductLength(String id, Double double1) {
			for(Product P: products) {
		    	if( P.getID().equals(id)) {
		    		P.setLength(double1);
		    	}
		     }
			
		}
		
		
		public void updateProductSpecialTreatment(String id, String string) {
			for(Product P: products) {
		    	if( P.getID().equals(id)) {
		    		P.setSpecialTreatment(string);
		    	}
		     }
		}
	    public void updateProductPicture(String id, String string) {
				for(Product P: products) {
			    	if( P.getID().equals(id)) {
			    		P.setPicture(string);
			    	}
			     }
	    }
	     public void updateProductStartDate(String id, String string) {
						for(Product P: products) {
					    	if( P.getID().equals(id)) {
					    		P.setStartDate(string);
					    	}
					     }
	     }
	    public void updateProductFinishDate(String id, String string) {
						 for(Product P: products) {
							   if( P.getID().equals(id)) {
							    		P.setFinishDate(string);
							        
							     }
						 }
	    }
		
	   public void updateProductMaterial(String id, String string) {
					for(Product P: products) {
					if( P.getID().equals(id)) {
					P.setMaterial(string);
							    	}
				  }	
	}

	 public boolean have(Product product) {
		for(Product P: products) {
			if(P.getID().equals(product.getID()))
				return true;
		}
			 return false;
	}
	   public boolean specialProduct(Product productExist) {
			 for(Product P :products)
			   	 if(P.getID().equals(productExist.getID()))
				      return false;
			  return true;
		   }


	public String getFName() {
		return firstName;
	}
	public String trackOrder(String productID) {
		String state=null;
		for(Product p:products) {
			if(p.getID().equals(productID)) {
				  state=p.getStatus();
			}
		}
		 return state;
	}
	public String getPhone() {
		
		return phone;
	}
	public String getAddress() {
		
		return address;
	}
	public List<Product> getProducts() {
		
			return this.products;
	}
	public List<Invoice> getInvoices() {
		
		return this.invoices;
}
	public void addInvoice(Invoice i)
	{
		this.invoices.add(i);
	}
	public void deleteAllProducts()
	{
		this.products.clear();
	}
}

