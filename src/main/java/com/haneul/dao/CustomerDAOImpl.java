package com.haneul.dao;

import com.haneul.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers() {
        Query<Customer> theQuery = null;
        List<Customer> customerList=null;

        Session currentSession = sessionFactory.getCurrentSession();

        theQuery = currentSession.createQuery("from Customer",Customer.class);

        customerList = theQuery.getResultList();

        return customerList;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(theCustomer);
    }
}
