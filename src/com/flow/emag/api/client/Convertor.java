package com.flow.emag.api.client;

import java.util.ArrayList;
import java.util.List;

import com.flow.emag.api.entity.BrandEntity;
import com.flow.emag.api.entity.CategoryCharacteristicEntity;
import com.flow.emag.api.entity.CategoryEntity;
import com.flow.emag.api.entity.ProductEntity;
import com.flow.emag.api.model.Brand;
import com.flow.emag.api.model.Category;
import com.flow.emag.api.model.CategoryCharacteristic;
import com.flow.emag.api.model.Product;
import com.flow.emag.api.model.ProductsCharacteristic;

public class Convertor {
	
	public static BrandEntity brandModelToEntity(Brand model){
		BrandEntity be = new BrandEntity();
		be.setEmagId(model.getEmagId());
		be.setId(model.getId());
		be.setName(model.getName());
		be.setUrl(model.getUrl());		
		return be;
	}
	
	public static Brand brandEntityToModel(BrandEntity entity){
		Brand bm = new Brand();
		bm.setEmagId(entity.getEmagId());
		bm.setId(entity.getId());
		bm.setName(entity.getName());
		bm.setUrl(entity.getUrl());		
		return bm;
	}
	
	public static ProductEntity productModelToEntity(Product model){
		ProductEntity pe = new ProductEntity();
		pe.setName(model.getName());
		pe.setDescription(model.getDescription());
		pe.setEmagId(model.getEmagId());
		pe.setId(model.getId());
		pe.setShortDescription(model.getShortDescription());
		pe.setNumber(model.getNumber());
		pe.setCategory(categoryModelToEntity(model.getCategory()));
		pe.setBrand(brandEntotyModelToEntity(model.getBrand()));
		List<ProductsCharacteristic> pcms = model.getCharacteristics();
		
//		if( pcms != null ){
//			List<ProductsCharacteristicEntity> pces = new ArrayList<ProductsCharacteristicEntity>();
//			
//			for( ProductsCharacteristic pcm : pcms){
//				ProductsCharacteristicEntity pce = new ProductsCharacteristicEntity();
//				pce.setEmagId(pcm.getEmagId());
//				pce.setId(pcm.getId());
//				pce.setName(pcm.getName());				
//				pce.setProduct(pe);
//				pce.setValue(pcm.getValue());												
//				pces.add(pce);
//			}
//			
//			pe.setCharacteristics(pces);
//		}
		
		
		return pe;
	}
	
	public static BrandEntity brandEntotyModelToEntity(Brand model) {
		BrandEntity entity = new BrandEntity();
		entity.setId(model.getId());
		entity.setName(model.getName());
		return entity;				
	}

	public static CategoryEntity categoryModelToEntity(Category model) {
		CategoryEntity entity = new CategoryEntity();
		entity.setEmagId(model.getEmagId());
		entity.setId(model.getId());
		entity.setName(model.getName());		
		
		if( model.getCharacteristics() != null ){
			List<CategoryCharacteristicEntity> cces = new ArrayList<CategoryCharacteristicEntity>();
			
			for( CategoryCharacteristic cc : model.getCharacteristics()){
				CategoryCharacteristicEntity cce = new CategoryCharacteristicEntity();
				cce.setId(cc.getId());
				cce.setName(cc.getName());
				cce.setDisplayOrder(cc.getDisplayOrder());
				cce.setCategory(entity);
				cces.add(cce);
			}
			
			entity.setCharacteristics(cces);
		}
		
		return entity;				
	}

	public static Product productEntityToModel(ProductEntity entity){
		Product p = new Product();
		p.setName(entity.getName());
		p.setDescription(entity.getDescription());
		p.setEmagId(entity.getEmagId());
		p.setId(entity.getId());
		p.setShortDescription(entity.getShortDescription());
		p.setNumber(entity.getNumber());
		p.setCategory(categoryEntityToModel(entity.getCategory()));
		p.setBrand(brandEntotyToModel(entity.getBrand()));
//		List<ProductsCharacteristicEntity> pces = entity.getCharacteristics();
//		
//		if( pces != null ){
//			List<ProductsCharacteristic> pcms = new ArrayList<ProductsCharacteristic>();
//			
//			for( ProductsCharacteristicEntity pce : pces){
//				ProductsCharacteristic pcm = new ProductsCharacteristic();
//				pcm.setEmagId(pce.getEmagId());
//				pcm.setId(pcm.getId());
//				pcm.setName(pcm.getName());
//				pcm.setValue(pce.getValue());
//				pcms.add(pcm);
//			}
//			
//			p.setCharacteristics(pcms);
//		}
				
		return p;
	}
	
	public static Brand brandEntotyToModel(BrandEntity entity) {
		Brand model = new Brand();
		model.setId(entity.getId());
		model.setName(entity.getName());
		return model;
	}

	public static Category categoryEntityToModel(CategoryEntity entity) {
		Category model = new Category();
		model.setEmagId(entity.getEmagId());
		model.setId(entity.getId());
		model.setName(entity.getName());
		
		if( entity.getCharacteristics() != null ){
			List<CategoryCharacteristic> ccs = new ArrayList<CategoryCharacteristic>();
			
			for( CategoryCharacteristicEntity cce : entity.getCharacteristics()){
				CategoryCharacteristic cc = new CategoryCharacteristic();
				cc.setId(cce.getId());
				cc.setName(cce.getName());
				cc.setDisplayOrder(cce.getDisplayOrder());
				ccs.add(cc);
			}
			
			model.setCharacteristics(ccs);
		}
		
		return model;
	}
}
