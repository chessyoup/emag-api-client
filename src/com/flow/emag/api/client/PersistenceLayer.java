package com.flow.emag.api.client;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.flow.emag.api.entity.ApiLogEntity;
import com.flow.emag.api.entity.BrandEntity;
import com.flow.emag.api.entity.CategoryCharacteristicEntity;
import com.flow.emag.api.entity.CategoryEntity;
import com.flow.emag.api.entity.CustomerEntity;
import com.flow.emag.api.entity.ImageEntity;
import com.flow.emag.api.entity.InvoiceEntity;
import com.flow.emag.api.entity.InvoiceItemEntity;
import com.flow.emag.api.entity.MessageEntity;
import com.flow.emag.api.entity.OrderDetailEntity;
import com.flow.emag.api.entity.OrderEntity;
import com.flow.emag.api.entity.OrderItemEntity;
import com.flow.emag.api.entity.ProductCharacteristicValueEntity;
import com.flow.emag.api.entity.ProductEntity;
import com.flow.emag.api.entity.ProductOfferEntity;
import com.flow.emag.api.entity.ProformaEntity;
import com.flow.emag.api.entity.ProformaVendorItemEntity;
import com.flow.emag.api.entity.ShipmentEntity;
import com.flow.emag.api.entity.VoucherEntity;
import com.flow.emag.api.model.Product;

public class PersistenceLayer {

	private static final PersistenceLayer instance = new PersistenceLayer();

	private SessionFactory sessionFactory;
	
	private static final Logger LOG = Logger.getLogger("PersistenceLayer");
	
	private PersistenceLayer() {
		Configuration config;
		config = new Configuration()
				.addAnnotatedClass(BrandEntity.class)
				.addAnnotatedClass(CustomerEntity.class)
				.addAnnotatedClass(CategoryCharacteristicEntity.class)
				.addAnnotatedClass(CategoryEntity.class)
				.addAnnotatedClass(InvoiceItemEntity.class)
				.addAnnotatedClass(InvoiceEntity.class)
				.addAnnotatedClass(MessageEntity.class)
				.addAnnotatedClass(OrderDetailEntity.class)
				.addAnnotatedClass(OrderEntity.class)
				.addAnnotatedClass(OrderItemEntity.class)
				.addAnnotatedClass(ProductEntity.class)
				.addAnnotatedClass(ProductOfferEntity.class)				
				.addAnnotatedClass(ProformaEntity.class)
				.addAnnotatedClass(ProformaVendorItemEntity.class)
				.addAnnotatedClass(ShipmentEntity.class)
				.addAnnotatedClass(VoucherEntity.class)
				.addAnnotatedClass(ApiLogEntity.class)
				.addAnnotatedClass(ProductCharacteristicValueEntity.class)
				.addAnnotatedClass(ImageEntity.class)
				.setProperty("hibernate.show_sql", "true")
				.setProperty("hibernate.dialect",
						"org.hibernate.dialect.Oracle10gDialect")
				.setProperty("hibernate.connection.driver_class",
						"oracle.jdbc.OracleDriver")
				.setProperty("hibernate.connection.username", "emag")
				.setProperty("hibernate.connection.password", "emagap1")
				.setProperty("hibernate.connection.url",
						"jdbc:oracle:thin:@ns2.senia.ro:1521:senorg")
				.setProperty("hibernate.connection.pool_size", "5");
//				.setProperty("hibernate.hbm2ddl.auto", "create");

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(config.getProperties()).buildServiceRegistry();
		this.sessionFactory = config.buildSessionFactory(serviceRegistry);
	}

	public static PersistenceLayer getInstance() {
		return PersistenceLayer.instance;
	}
	
	public Product readProduct(String id){
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			return  Convertor.productEntityToModel((ProductEntity)session.get(ProductEntity.class, Long.valueOf(id)));					
		} catch (Exception e) {
			LOG.log(Level.SEVERE,"Error on reading product :"+id,e);
			return null;
		} finally {
			if(session != null){
				session.close();				
			}
		}
	}
	
	public String save(Object entity) {
		LOG.info("save :: "+entity.toString());
		
		Session session = null;
		
		try {
			session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			Serializable id =  session.save( entity );
			LOG.info("entity id  " + id.toString());
			session.flush();
			tx.commit();
			return id.toString();
		} catch (Exception e) {
			LOG.log(Level.SEVERE,"Error on saving :"+entity.toString(),e);
			return null;
		} finally {
			if(session != null){
				session.close();				
			}
		}
	}
	
	

	public static void main(String[] args) {
		BrandEntity be = new BrandEntity();
		be.setName("Yamaha");
		be.setUrl("www.yamaha.com");		
		ProductEntity pe = new ProductEntity();
		
		
		System.out.println(Util.objectToJson(PersistenceLayer.getInstance().readProduct("3")));		
	}
}
