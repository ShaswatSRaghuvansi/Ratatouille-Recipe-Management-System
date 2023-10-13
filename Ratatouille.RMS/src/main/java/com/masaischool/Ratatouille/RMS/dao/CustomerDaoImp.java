package com.masaischool.Ratatouille.RMS.dao;

import java.util.List;

import com.masaischool.Ratatouille.RMS.Utility.EMUtils;
import com.masaischool.Ratatouille.RMS.entity.LoggedInUserId;
import com.masaischool.Ratatouille.RMS.entity.User;
import com.masaischool.Ratatouille.RMS.exception.NoRecordFoundException;
import com.masaischool.Ratatouille.RMS.exception.SomeThingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CustomerDaoImp implements CustomerDao {

    @Override
    public void addCustomer(User user) throws SomeThingWentWrongException {
        EntityManager em = null;
        try {
            em = EMUtils.getEntityManager();

            // Check if User with the same name exists
            Query query = em.createQuery("SELECT count(c) FROM User c WHERE username = :userName");
            query.setParameter("userName", user.getUsername());
            List<User> list = query.getResultList();
            if (list.size() > 0) {
                // You are here means a User with the given name exists, so throw an exception
                throw new SomeThingWentWrongException("Username already exists with name " + user.getUsername());
            }

            // You are here means no user with the given name
            EntityTransaction et = em.getTransaction();
            et.begin();
            em.persist(user);
            et.commit();
        } catch (PersistenceException ex) {
            throw new SomeThingWentWrongException("Unable to process the request, please try again later");
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void login(String username, String password) throws SomeThingWentWrongException, NoRecordFoundException {
        EntityManager em = null;
        try {
            em = EMUtils.getEntityManager();

            Query query = em.createQuery("SELECT c.id FROM User c WHERE username = :username AND password = :password AND isdeleted = 0");
            query.setParameter("username", username);
            query.setParameter("password", password);
            List<Integer> listInt = (List<Integer>) query.getResultList();
            if (listInt.size() == 0) {
                // You are here means no user with the given username and password combination is found
                throw new NoRecordFoundException("The username or password is incorrect");
            }
            LoggedInUserId.loggedInUserId = listInt.get(0);
        } catch (PersistenceException ex) {
            throw new SomeThingWentWrongException("Unable to process request, try again later");
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public User findCustomerWithID(int id) throws SomeThingWentWrongException, NoRecordFoundException {
        EntityManager em = null;
        User user = null;
        try {
            em = EMUtils.getEntityManager();
            Query query = em.createQuery("SELECT c FROM User c WHERE id = :userId AND isdeleted = 0");
            query.setParameter("userId", id);
            user = (User) query.getSingleResult();
            if (user == null) {
                throw new NoRecordFoundException("The user with the given ID does not exist");
            }
        } catch (PersistenceException ex) {
            throw new SomeThingWentWrongException("Unable to process request, try again later");
        } finally {
            em.close();
        }
        return user;
    }
}
