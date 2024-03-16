package com.march.dbdemo.dao;


import com.march.dbdemo.dto.ProductDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl {

    @Autowired
    private SessionFactory sessionFactory;

    //Post mapping---using param-----------------
    public void addProduct(ProductDTO productDTO) {
        sessionFactory.getCurrentSession().saveOrUpdate(productDTO);
    }


    //Put mapping---------------------
    public void updateProduct(ProductDTO productDTO) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(productDTO);
        transaction.commit();
        session.close();
    }


    //Delete mapping----------------------
    public void deleteProduct(ProductDTO productDTO) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(productDTO);

        //session.saveOrUpdate(productDTO); //after delete and save again---------
        transaction.commit();
        session.close();
    }


    //Get mapping-------------------------------
    public List<ProductDTO> listAllProducts() {
        return sessionFactory.getCurrentSession().createQuery("FROM ProductDTO").getResultList();
    }


    //Get mapping---------
    public ProductDTO findByProductId(String productId) {
        List<ProductDTO> productDTOS
                = sessionFactory.getCurrentSession().createQuery("FROM ProductDTO where productId ='" + productId + "'").getResultList();
        return productDTOS.get(0);
    }
}
