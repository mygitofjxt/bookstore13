package com.bookStore.admin.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookStore.admin.product.dao.IAdminProductDao;
import com.bookStore.admin.product.service.IAdminProductService;
import com.bookStore.commons.beans.Product;
import com.bookStore.commons.beans.ProductList;

@Service
public class AdminProductServiceImpl implements IAdminProductService {

	@Autowired
	private IAdminProductDao adminProductDao;
	
	@Override
	public List<Product> findProduct() {
		return adminProductDao.selectProduct();
	}

	@Override
	public List<Product> findProductByManyCondition(Product product, String minprice, String maxprice) {
		Map map = new HashMap<>();
		map.put("product", product);
		map.put("minprice", minprice);
		map.put("maxprice", maxprice);
		
		return adminProductDao.selectProductByManyCondition(map);
	}

	@Override
	public void addProduct(Product product) {
		adminProductDao.insertProduct(product);
	}

	@Override
	public Product findProductById(String id) {
		return adminProductDao.selectProductById(id);
	}

	@Override
	public void editProduct(Product product) {
		adminProductDao.updatePrdouct(product);
	}

	@Override
	public void removeProduct(String id) {
		adminProductDao.deleteProduct(id);
	}

	@Override
	public List<ProductList> findProductList(String year, String month) {
		Map map = new HashMap<>();
		map.put("year", year);
		map.put("month", month);
		return adminProductDao.selectProductList(map);
	}
	@Override
	public int findProductCount(){
		return adminProductDao.selectProductCount();
	}

}
