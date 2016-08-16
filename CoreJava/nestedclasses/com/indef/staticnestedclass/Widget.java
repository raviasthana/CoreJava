package com.indef.staticnestedclass;

/**
 * Demo of static nested class usage 
 * 
 * This class uses a static inner class to create a flavour of Builder Pattern.
 * 
 * This builder pattern can solve the problem of too many constructors, too many
 * constructor parameters, and over use of setters to create an object.
 * 
 * The basic idea behind the pattern is to limit the number of constructor 
 * parameters and avoid the use of setter methods. Constructors with too many
 * parameters, specially optional ones, are ugly and hard to use. Multiple
 * constructors for different modes are confusing. Setter methods add clutter
 * and force an object to be mutable.
 * 
 * Widget class has no public constructors and no setters, and the only way to create
 * a Widget is using the static inner class Widget.Builder. Widget.Builder has a 
 * constructor that takes the required properties of Widget. Widget's optional 
 * properties can be set using optional property methods on the Widget.Builder.
 * The property methods of Widget.Builder return a reference to the builder itself
 * so method calls can be chained.
 * 
 * A really nice feature of this pattern is the ability to do pre-creation validation
 * of an object state. When setters are used to set object state during creation, it
 * is virtually impossible to guarantee that object has been properly created.
 * 
 * @author RAsthana
 *
 */
public class Widget {

	private String name;
	private String model;
	private String serialNumber;
	private double price;
	private String manufacturer;

	/**
	 * Creates an immutable widget instance.
	 */
	private Widget(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getModel() {
		return model;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public String toString() {
		return super.toString() + " {" 
				+ "name=" + getName() 
				+ " model="	+ getModel() 
				+ " serialNumber=" + getSerialNumber() 
				+ " price="	+ getPrice() 
				+ " manufacturer=" + getManufacturer() 
				+ "}";
	}

	public static class Builder {
		private String name;
		private String model;
		private String serialNumber;
		private double price;
		private String manufacturer;

		public Builder(String name, double price) {
			this.name = name;
			this.price = price;
		}

		public Widget build() {
			// any pre-creation validation here
			Widget result = new Widget(name, price);
			result.model = model;
			result.serialNumber = serialNumber;
			result.manufacturer = manufacturer;
			return result;
		}

		public Builder manufacturer(String value) {
			this.manufacturer = value;
			return this;
		}

		public Builder serialNumber(String value) {
			this.serialNumber = value;
			return this;
		}

		public Builder model(String value) {
			this.model = value;
			return this;
		}
	}
	
	public static void main(String[] args) {
		
		Widget x = new Widget.Builder("1", 1.0).model("1").build();
		
		System.out.println("X:\n" + x.toString());
		
		Widget y = new Widget.Builder("2", 2.0).model("2").
					manufacturer("22").serialNumber("222").build();
		
		System.out.println("Y:\n" + y.toString());
	}
}
