package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.product.model.Product;

public class ProductDaoImpl implements ProductDao {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Statement stmt = null;

	@Override
	public boolean saveProduct(Product product) {
		con = DBUtils.getConnection();
		int x = 0;
		try {
			String qry = "INSERT INTO product VALUES(?,?,?,?)";
			ps = con.prepareStatement(qry);
			ps.setString(1, product.getId());
			ps.setString(2, product.getName());
			ps.setDouble(3, product.getPrice());
			ps.setString(4, product.getDescription());
			
			x = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean status = false;
		if(x!=0) status = true;
		
		return status;
	}

	@Override
	public List<Product> listAll() {
		con = DBUtils.getConnection();
		List<Product> prod = new ArrayList<>();
		try {
			String qry = "SELECT * FROM product";
			stmt = con.createStatement();
			rs = stmt.executeQuery(qry);
			while(rs.next()){
				Product product = new Product();
				product.setId(rs.getString(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setDescription(rs.getString(4));
				prod.add(product);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prod;
	}

	@Override
	public Product findProduct(String id) {
		con = DBUtils.getConnection();
		String qry = "SELECT * FROM product where id = "+id;
		Product product = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(qry);
			while(rs.next()){
				product = new Product();
				product.setId(rs.getString(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setDescription(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public boolean updateProduct(Product product) {
		con = DBUtils.getConnection();
		String qry = "UPDATE product SET name=?, price=?, description=? WHERE id="+product.getId();
		int x = 0;
		try {
			ps = con.prepareStatement(qry);
			ps.setString(1, product.getName());
			ps.setDouble(2, product.getPrice());
			ps.setString(3, product.getDescription());
			
			x = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean status = false;
		if(x != 0) status = true;
		
		return status;
	}

	@Override
	public boolean deleteProduct(String id) {
		con = DBUtils.getConnection();
		String qry = "DELETE FROM product WHERE id="+id;
		int x = 0;
		try {
			ps = con.prepareStatement(qry);
			x = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		boolean status = false;
		if(x != 0) status = true;
		
		return status;
	}

}
