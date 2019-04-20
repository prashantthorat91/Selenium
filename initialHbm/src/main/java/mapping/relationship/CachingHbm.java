package mapping.relationship;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CachingHbm {
	public static void main(String[] args) {
		Product1 p1 = new Product1(101,"AAAAA",3293.3,"A+");
		Product1 p2 = new Product1(102,"BBBB",5293.3,"B+");

		Configuration conf = new Configuration().configure("mysql-hibernate.cfg.xml");
		conf.addAnnotatedClass(Product1.class);
		
		SessionFactory factory = conf.buildSessionFactory();
		Session session1 = factory.openSession();
		Transaction tr = session1.beginTransaction();
		
		session1.save(p1);
		session1.save(p2);
		

		session1.flush();
		tr.commit();
	}

}
@Entity
@Table(name="prod_info")
class Product1{
	@Id
	private int productId;
	private String productName;
	private double productPrice;
	private String category;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "\n [productId=" + productId + ", productName="
				+ productName + ", productPrice=" + productPrice
				+ ", category=" + category + "]";
	}
	public Product1(int productId, String productName, double productPrice,
			String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.category = category;
	}
	public Product1() {
		super();
	}
	
	
	
	
}
