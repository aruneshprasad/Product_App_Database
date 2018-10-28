package com.product.service;

import java.util.List;

import com.product.dao.ProductDao;
import com.product.dao.ProductDaoImpl;
import com.product.model.Product;

public class ProductServiceImpl implements ProductService{
	
	ProductDao prodDao = new ProductDaoImpl();

	@Override
	public boolean saveProduct(Product product) {
		return prodDao.saveProduct(product);
	}

	@Override
	public List<Product> listAll() {
		return prodDao.listAll();
	}

	@Override
	public Product findProduct(String id) {
		return prodDao.findProduct(id);
	}

	@Override
	public boolean updateProduct(Product product) {
		return prodDao.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(String id) {
		return prodDao.deleteProduct(id);
	}

}
