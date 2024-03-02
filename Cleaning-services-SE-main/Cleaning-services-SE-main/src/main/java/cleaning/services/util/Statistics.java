package cleaning.services.util;
import java.util.List;
import java.util.logging.Logger;
  
public class Statistics {
	private static final Logger logger = Logger.getLogger(Statistics.class.getName());
	private List<Customer> customers;
	
	public  double calculateTotalPaid()
	{
		double paid=0;
				for (Customer c : customers)
				{
					for (Invoice i:c.getInvoices())
					{
						if(i.isPaid()) paid+=i.getTotalPriceAfterDiscount();
					}
				}

		return paid;
	}
	public  int calculateTotalDebts()
	{
		int debts=0;
		for (Customer c : customers)
		{
			for (Invoice i:c.getInvoices())
			{
				if(!i.isPaid()) debts+=i.getTotalPriceAfterDiscount();
			}
		}
		return debts;
	}
	public  int countOfProducts() {
	int count=0;
	for(Customer c:customers)
	{
		count+=c.getProducts().size();
	}
	return count;
	}
	public  void printStatistics()
	{
		DB.extractedLogger();
		logger.info("**************************************************************\n\\t\\t**General Statistics**\n"
				+ "Total Paid : \t\t "+calculateTotalPaid()+"\n"+"Total Debts :\t\t "+calculateTotalDebts()+"\n"+
				"Total Number of Customers : \t\t "+customers.size()+"\n"+
				"Total Number of Products : \t\t "+countOfProducts()+"\n");
	}

	public List<Customer> getCustomersList()
	{
		return customers;
	}
	public  void setCustomers(List <Customer> c)
	{
		customers=c;
	}
}

