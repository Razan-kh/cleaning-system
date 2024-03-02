package cleaning.services.util;

	public class Product {
		private String category;
		private String picture;
		private String material;
		private String name;
		private String specialTreatment;
		private  String description;
		private String id;
		private String status="waiting";
		private String startDate;
		private String finishDate;
		private double length;
		private double width;
		private double weight;
		private double price;
	public void setName(String string) {
		name=string;
	}  
	public void setCategory(String string) {
		category=string; 
		
	}

	public void setDescription(String string) {
		description=string;
	}

	public void setPicture(String string) {
		picture=string;
		
	}

	public void setSpecialTreatment(String string) {
		specialTreatment=string;
		
	}

	public void setMaterial(String string) {
	  material=string;
		
	}
	public void setStatus(String string) {
		  status=string;
			
  		}
   
	public void setID(String string) {
    	 id=string;
    }
	
	public String getID() {
		return id;
	}

	public void setWeight(Double double1) {
	  weight=double1;
	}

	public void setLength(Double double1) {
		 length=double1;
	}

	public void setWidth(Double double1) {
		width=double1;
		
	}
	public double calculatePrice() {
		 double area = width * length;
		     price = 0;
		    
		    if (category.equalsIgnoreCase("carpet")) {
		        price = area * 6;
		    } else if (category.equalsIgnoreCase("rug")) {
		        price = area * 8;
		    } else if (category.equalsIgnoreCase("mattress")) {
		        price = area * 12;
		    } else if (category.equalsIgnoreCase("blanket")) {
		        price = area * weight * 0.5;
		    } else {
		        // Invalid service type
		        return -1;
		    }
		    
		    if (specialTreatment.equalsIgnoreCase("yes")) {
		        price += 10;
		    }
		    return price;
	}
	

	public void setStartDate(String string) {
	   startDate=string;
		
	}

	public void setFinishDate(String string) {
		finishDate=string;
	}

	public String getStatus() {
		return status;
	}
	public double getPrice() {
		return price;
	}
	public String getCategory() {
		return category;
	}

	public String getStartDate() {
		return startDate;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public double getLength() {
		return length ;
	}
	public double getWidth() {
		return width;
	}
	public double getWeight() {
		return weight;
	}

	public String getName() {

		return name;
	}

	public String getPicture() {

		return picture;
	}

	public String getMaterial() {
	
		return material;
	}

	public String getSpecialTreatment() {
	
		return specialTreatment;
	}

	public String getDescription() {
		
		return description;
	}

}