import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.flow.emag.api.client.ApiCountResponse;
import com.flow.emag.api.client.ApiResponse;
import com.flow.emag.api.client.Convertor;
import com.flow.emag.api.client.EmagAPIClient;
import com.flow.emag.api.client.EmagAction;
import com.flow.emag.api.client.PersistenceLayer;
import com.flow.emag.api.client.ResourceFilter;
import com.flow.emag.api.client.Util;
import com.flow.emag.api.entity.ApiLogEntity;
import com.flow.emag.api.model.Brand;
import com.flow.emag.api.model.Category;
import com.flow.emag.api.model.Product;

public class EmagClient {

	private static final Logger LOG = Logger.getLogger("EmagClient");

	private static final EmagAPIClient emagApiClient = EmagAPIClient
			.getClient();

	private static final PersistenceLayer persistenceLayer = PersistenceLayer
			.getInstance();
	
	public static void updateBrands(){
		ApiLogEntity apiLog = Util.createApiLog("brand",EmagAction.COUNT.toString(), "{count:brand}");
		
		try {
			ApiCountResponse countBrands = emagApiClient.countResource(Brand.class);
			LOG.info("countBrands :: "+countBrands.toString());
			
			for( int i = 1 ; i<countBrands.getResults().getNoOfPages(); i++ ){
				ApiResponse<Brand> brands =  emagApiClient.readResources(Brand.class,new ResourceFilter(i, countBrands.getResults().getItemsPerPage()));
				
				if(brands.getResults() != null && brands.getResults().size() > 0 ){
					for(Brand brand :brands.getResults()){
						persistenceLayer.save(Convertor.brandModelToEntity(brand));	
					}										
				}
			}
			
		} catch (Exception e) {			
			LOG.log(Level.SEVERE, "Error on counting brands!");
			apiLog.setException(Util.exceptionToString(e));
		}
		
		saveLog(apiLog);
	}
	
	public static void updateCategories(){
		ApiLogEntity apiLog = Util.createApiLog("category",EmagAction.COUNT.toString(), "{count:category}");
		
		try {
			ApiCountResponse countCategories = emagApiClient.countResource(Category.class);
			LOG.info("countCategories :: "+countCategories.toString());
			
			for( int i = 1 ; i<countCategories.getResults().getNoOfPages(); i++ ){
				ApiResponse<Category> categories =  emagApiClient.readResources(Category.class,new ResourceFilter(i, countCategories.getResults().getItemsPerPage()));
												
				if(categories.getResults() != null && categories.getResults().size() > 0 ){
					LOG.info("size ..... :: "+categories.getResults().size());
					
					for(Category category :categories.getResults()){
						persistenceLayer.save(Convertor.categoryModelToEntity(category));	
					}										
				}
			}
			
		} catch (Exception e) {			
			LOG.log(Level.SEVERE, "Error on counting brands!");
			apiLog.setException(Util.exceptionToString(e));
		}
		
		saveLog(apiLog);
	}
	
//	public static void updateProduct(String seniaProductId) {
//		Product product = persistenceLayer.readProduct(seniaProductId);
//		
//		LOG.info("Updating product ::"+product.toString() );
//		
//		ApiLogEntity apiLog = Util.createApiLog("product",
//				EmagAction.SAVE.toString(), Util.objectToJson(product));
//
//		try {
//			String reponseJson = emagApiClient.updateProduct(product);
//			apiLog.setResponseJson(reponseJson);
//			saveLog(apiLog);
//		} catch (Exception e) {
//			LOG.log(Level.SEVERE, "Error on updating product id :"
//					+ seniaProductId, e);
//			apiLog.setException(Util.exceptionToString(e));
//		}
//	}

	public static String readProduct(String emagProductId) {
		String seniaProductId = "";
		Product p = new Product();
		p.setEmagId(emagProductId);
		ApiLogEntity apiLog = Util.createApiLog("product",
				EmagAction.READ.toString(), Util.objectToJson(p));

		try {
			ApiResponse<Product> response = emagApiClient.readResourceByEmagId(Product.class, emagProductId);

			if (response.getResults() != null
					&& response.getResults().size() > 0) {
				Product product = response.getResults().get(0);
				seniaProductId = persistenceLayer.save(Convertor
						.productModelToEntity(product));
				apiLog.setResponseJson(Util.objectToJson(response));
			}
		} catch (Exception e) {
			LOG.log(Level.SEVERE, "Error on read product by emag id :"
					+ emagProductId, e);
			apiLog.setException(Util.exceptionToString(e));
		}

		saveLog(apiLog);
		return seniaProductId;
	}

	private static void saveLog(ApiLogEntity apiLog) {
		apiLog.setEndTime(new Date());
		persistenceLayer.save(apiLog);
	}

	public static void main(String[] args) {
//		 System.out.println(EmagClient.readProduct("425770"));
//		EmagClient.updateProduct("3");
//		EmagClient.updateBrands();
		EmagClient.updateCategories();
	}
}
