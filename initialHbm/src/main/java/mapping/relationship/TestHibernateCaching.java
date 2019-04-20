package mapping.relationship;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;

public class TestHibernateCaching {
		public static void main(String[] args) {
			Product p1 = new Product(101,"AAAAA",3293.3,"A+");
			Product p2 = new Product(102,"BBBB",5293.3,"B+");

			SessionFactory sfactory = new Configuration().addAnnotatedClass(Product.class).configure("mysql-hibernate.cfg.xml").buildSessionFactory();
			Statistics stats = sfactory.getStatistics();
			stats.setStatisticsEnabled(true);
			
			System.out.println("Before session1 " +stats);
			
			Session session1 = sfactory.openSession();
			Transaction tr = session1.beginTransaction();
			session1.save(p1);
			session1.save(p2);
			session1.flush();
			tr.commit();

			System.out.println("after session1 commit " +stats);
			session1.clear();
			Session session2 = sfactory.openSession();
			Product dbp1 = session2.get(Product.class, 103);
			System.out.println(dbp1);
			
			System.out.println("after session2 " +stats);
		}
}

@Entity
@Table(name="product_hbm_info")
@Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
class Product{
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
	public Product(int productId, String productName, double productPrice,
			String category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.category = category;
	}
	public Product() {
		super();
	}
	
	
	
}

/**
session1.evict(p2);
			
			System.out.println("Before session1 get");
			Product dbProduct2 = (Product)session1.get(Product.class, 102);
			System.out.println(dbProduct2);
			
			System.out.println("Before session2 get");
			Session session2 = sfactory.openSession();
			Product dbProduct1 = (Product)session2.get(Product.class, 102);
			
			System.out.println(dbProduct1);
			
			
			
			Product dbProduct11 = (Product)session1.get(Product.class, 204);
			System.out.println("DbProduct" +dbProduct11);
			
			Product dbProduct22 = (Product)session1.get(Product.class, 204);
			System.out.println("DbProduct" +dbProduct22);
			
			
			Session session2 = sfactory.openSession();
			System.out.println("before get");
			Product dbProduct1= (Product) session2.get(Product.class,102);
			System.out.println("before load");
			Product dbProduct2= (Product) session2.load(Product.class,102);
			System.out.println("before print1");
			System.out.println(dbProduct1);
			System.out.println("before print2");
			System.out.println(dbProduct2);

*/