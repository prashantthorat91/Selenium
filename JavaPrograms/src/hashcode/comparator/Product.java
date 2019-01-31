package hashcode.comparator;

public class Product implements Comparable<Product>{

	private int productid;
	private String productName;
	private double price;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Product(int productid, String productName, double price) {
		super();
		this.productid = productid;
		this.productName = productName;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productName=" + productName + ", price=" + price + "]";
	}
	@Override
	public int compareTo(Product o) {		
	 int temp= this.productid-o.productid;	 
		if(temp==0) {
			int temp2=-(this.productName.compareTo(productName));
			if(temp2==0) {
				{
					return (int) (this.price-o.price);
				}
			}
			return temp2;
		}
		return temp;		
	}
	
	
	
}

