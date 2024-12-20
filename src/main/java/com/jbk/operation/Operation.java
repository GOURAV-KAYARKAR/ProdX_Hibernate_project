package com.jbk.operation;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.jbk.config.HibernateConfig;
import com.jbk.entity.Product;

public class Operation {

	SessionFactory sessionFactory = HibernateConfig.getSessionFactory();

	public String addProduct(Product product) {

		try {
			Session session = sessionFactory.openSession();
			Product dbproduct = session.get(Product.class, product.getProductId());
			if (dbproduct == null) {
				session.save(product);
				session.beginTransaction().commit();
				return " Product Added Succefully ";

			} else {
				return "Product Already Exist";
			}

		} catch (Exception e) {
			return "Something went  wrong";
		}

	}
//------------------------------------------------------------------------	

	public String deleteProduct(int ProductId) {
		Session session = sessionFactory.openSession();
		Product dbProduct = session.get(Product.class, ProductId);
		try {
			if (dbProduct != null) {
				session.delete(dbProduct);
				session.beginTransaction().commit();
				return "Product Deleted";

			} else {
				return "Product Not Found";
			}
		} catch (Exception e) {
			return "Something wents wrong";
		}
	}

	// -----------------------------------------------------------------------

	public Object getProductById(int ProductId) {
		Session Session = sessionFactory.openSession();
		Product dbproduct = Session.get(Product.class, ProductId);

		try {
			if (dbproduct != null) {
				Session.beginTransaction().commit();
				return dbproduct;

			} else {
				return "Product Not Exist";
			}
		} catch (Exception e) {
			return "Something Wents Wrong";

		}

	}
//-----------------------------------------------------------------------------

	public String updateProductById(int ProductId) {
		Session Session = sessionFactory.openSession();
		Product dbProduct = Session.get(Product.class, ProductId);
		try {
			if (dbProduct != null) {
				Session.saveOrUpdate(dbProduct);
				;
				Session.beginTransaction().commit();
				return " Product Updated Succesfully";
			} else {
				return "Product id not correct";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "Something wents wrong" + "";
		}
	}
// -----------------------------------------------------------------------------

	public List<Product> getAllProduct() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			list = criteria.list();
			session.beginTransaction().commit();
			return list;
		} catch (Exception e) {

		}
		return list;

	}

//------------------------------------------------------------------------------
	public List<Product> getAllProductByOrder() {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {

			Criteria criteria = session.createCriteria(Product.class);
			criteria.addOrder(Order.asc("productName"));
			list = criteria.list();

			session.beginTransaction().commit();
			return list;

		} catch (Exception e) {
			System.out.println("Something wents wrong" + e.getMessage());
		}
		return list;
	}

//------------------------------------------------------------------------------------
	public List<Product> getProductByProductname(String Name) {
		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productName", Name));
			list = criteria.list();
			session.beginTransaction().commit();
			return list;
		} catch (Exception e) {
			System.out.println("Something wents wrong" + e.getMessage());
			// TODO: handle exception
		}
		return list;
	}

//------------------------------------------------------------------------------------
	public List<Product> getProductGreaterThanGivenPrice(double price) {
		Session openSession = sessionFactory.openSession();
		List<Product> list = null;

		try {
			Criteria criteria = openSession.createCriteria(Product.class);
			criteria.add(Restrictions.gt("productPrice", price));
			list = criteria.list();
			openSession.beginTransaction().commit();
			return list;
		} catch (Exception e) {
			System.out.println("Something wents wrong" + e.getMessage());
			e.printStackTrace(); // Print stack trace for debugging
			// TODO: handle exception
		}
		return list;
	}

//-------------------------------------------------------------------------------------------
	public List<Product> getProductBymatchingPattern(String pattern) {

		Session session = sessionFactory.openSession();
		List<Product> list = null;
		try {
			Criteria criteria = session.createCriteria(Product.class);

			criteria.add(Restrictions.ilike("productName", "%" + pattern + "%"));
			list = criteria.list();
			session.beginTransaction().commit();
			return list;
		} catch (Exception e) {
			System.out.println("Something wents wrong" + e.getMessage());
			// TODO: handle exception
		}
		return list;
	}

//---------------------------------------------------------------------------------------------------
	public List<Product> getProductBetRange(double low, double high) {
		Session openSession = sessionFactory.openSession();
		List<Product> list = null;

		try {
			Criteria criteria = openSession.createCriteria(Product.class);
			criteria.add(Restrictions.between("productPrice", low, high));
			list = criteria.list();
			openSession.beginTransaction().commit();
			return list;

		} catch (Exception e) {
			System.out.println("Something wents wrong" + e.getMessage());
			// TODO: handle exception
		}
		return list;
	}

}
