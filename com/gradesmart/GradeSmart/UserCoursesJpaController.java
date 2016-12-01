/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gradesmart.GradeSmart;

import com.gradesmart.GradeSmart.exceptions.NonexistentEntityException;
import com.gradesmart.GradeSmart.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Wasfi
 */
public class UserCoursesJpaController implements Serializable {

    public UserCoursesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UserCourses userCourses) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(userCourses);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUserCourses(userCourses.getCrn()) != null) {
                throw new PreexistingEntityException("UserCourses " + userCourses + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UserCourses userCourses) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            userCourses = em.merge(userCourses);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = userCourses.getCrn();
                if (findUserCourses(id) == null) {
                    throw new NonexistentEntityException("The userCourses with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            UserCourses userCourses;
            try {
                userCourses = em.getReference(UserCourses.class, id);
                userCourses.getCrn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The userCourses with id " + id + " no longer exists.", enfe);
            }
            em.remove(userCourses);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UserCourses> findUserCoursesEntities() {
        return findUserCoursesEntities(true, -1, -1);
    }

    public List<UserCourses> findUserCoursesEntities(int maxResults, int firstResult) {
        return findUserCoursesEntities(false, maxResults, firstResult);
    }

    private List<UserCourses> findUserCoursesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UserCourses.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public UserCourses findUserCourses(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UserCourses.class, id);
        } finally {
            em.close();
        }
    }

    public int getUserCoursesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UserCourses> rt = cq.from(UserCourses.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
