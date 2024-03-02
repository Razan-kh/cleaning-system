package cleaning.services.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
  

 
public class Invoice {
	private Customer c;
	private static int counter=0;
	private int id;
	private double totalPriceBeforeDiscount;
	private double totalPriceAfterDiscount;
	private double discountPercent=0.1;
	private boolean paid; //if paid-->true ,if debt-->false
	private List<Product> invoiceProducts;
	private static final Logger logger = Logger.getLogger(Invoice.class.getName());
	public Invoice (Customer x)
	{
		c=x;
		totalPriceBeforeDiscount=totalPriceCalculater();
		totalPriceAfterDiscount=totalPriceBeforeDiscount;
		setDiscount();
		invoiceProducts=new ArrayList<> (x.getProducts());
		counter++;
		id=counter;
	}
	
	public Invoice(Customer x, String i) {
	c=x;
	for(Product p: c.getProducts())
	{
		if (p.getID().equals(i))
		{
			totalPriceBeforeDiscount=p.calculatePrice();
			totalPriceAfterDiscount=totalPriceBeforeDiscount;
			setDiscount();
		invoiceProducts=new ArrayList<> ();
		invoiceProducts.add(p);
		
		}
	}
	counter++;
	id=counter;
	
	}
	
	public Invoice() {
		counter++;
		id=counter;
	}

	private double totalPriceCalculater()
	{
		double total=0;
		for(Product p: c.getProducts())
		{
			total+=p.calculatePrice();
		}
		return total;
	}
	
	public double getDiscount()
	{
		return discountPercent;
	}
	
	public void setDiscount()
	{
		if(this.totalPriceBeforeDiscount>=400) {
		
		 totalPriceAfterDiscount=(1-discountPercent)*totalPriceBeforeDiscount;
		}
	} 
	public void printInvoice()
	{DB.extractedLogger();
	logger.info("************************************************************************"+"\n");
	logger.info("\t\tProducts Invoice"+"\n");
	logger.info("ID\tName\t\tCategory\tSpecial Treatment\t\tprice"+"\n");

	for(Product p:invoiceProducts)
	{
		System.out.printf("%s\t%s\t\t%s\t      %s\t\t       %s%n",p.getID(),p.getName(),p.getCategory(),p.getSpecialTreatment(),p.calculatePrice());
	
	}
	logger.info("\n");
	logger.info("Total price before discount "+this.totalPriceBeforeDiscount+"\n");
	logger.info("Total price After discount  "+this.totalPriceAfterDiscount+"\n");
	logger.info("\n");
	    logger.info("invoice ID is :%s%n");
	    if(paid)  logger.info("Paid");
	    else logger.info("UnPaid");
	LocalDate myObj = LocalDate.now(); 
    logger.info("\t\t\t\t\t\t\t\t%s%n"+myObj); 
    logger.info("************************************************************************");
 
	}
	
	public int getID()
	{
		return id;
	}
 	
	public double getTotalPriceAfterDiscount()
	{
		return totalPriceAfterDiscount;
	}
	public double getTotalPriceBeforeDiscount()
	{
		return totalPriceBeforeDiscount;
	}
	public void setTotalPriceBeforeDiscount(double a)
	{
		 totalPriceBeforeDiscount=a;
	}
	public void setDiscountPercent(double a)
	{
		discountPercent=a;
	}
	public void setPaid(boolean b)
	{
		paid=b;
	}
	public boolean isPaid()
	{
		return paid;
	}


	
}
