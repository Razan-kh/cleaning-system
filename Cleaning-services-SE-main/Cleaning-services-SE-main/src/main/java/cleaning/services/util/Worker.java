package cleaning.services.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class Worker {
	private String name;
	private String id;
	private double salary;
    private ArrayList <Product>myProduct=new ArrayList<>();
  
	 public Worker(String name,String id,double salary){
		 this.name=name;
		 this.id=id;
		 this.salary=salary;
	 }
	public int numberOfOrders() {	
		return myProduct.size();
	}
	public void addProduct(Product product) {
	 myProduct.add(product);	
	}
	public boolean contains(String id2) {
		for(Product P:myProduct) {
			if(P.getID().equals(id2))
				return true;
		}
		return false;
	}
	public void removedFromWorker(String id2) {
		
		  Iterator<Product> iterator = myProduct.iterator();
		    while (iterator.hasNext()) {
		        Product p = iterator.next();
		        if (p.getID().equals(id2)) {
		            iterator.remove();
		        }
		    }
	}
	public String getName() {

		return name;
	}
	public String getId() {
	
		return id;
	}
	public double getSalary() {
		return salary;
	}
	public List<Product> getProduct() {
		return myProduct;
	}
	
	
	
  

}
