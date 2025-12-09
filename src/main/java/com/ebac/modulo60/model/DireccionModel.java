package com.ebac.modulo60.model;

import com.ebac.modulo60.dto.DireccionDTO;
import jakarta.persistence.*;
import java.util.List;

public class DireccionModel {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("MySQLPU");

    public DireccionDTO guardar(DireccionDTO d) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        em.close();
        return d;
    }

    public DireccionDTO actualizar(DireccionDTO d) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        DireccionDTO out = em.merge(d);
        em.getTransaction().commit();
        em.close();
        return out;
    }

    public boolean eliminar(Integer id) {
        EntityManager em = emf.createEntityManager();
        DireccionDTO found = em.find(DireccionDTO.class, id);
        if (found == null) {
            em.close();
            return false;
        }
        em.getTransaction().begin();
        em.remove(found);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    public DireccionDTO obtener(Integer id) {
        EntityManager em = emf.createEntityManager();
        DireccionDTO d = em.find(DireccionDTO.class, id);
        em.close();
        return d;
    }

    public List<DireccionDTO> obtenerTodos() {
        EntityManager em = emf.createEntityManager();
        List<DireccionDTO> list =
            em.createQuery("SELECT d FROM DireccionDTO d", DireccionDTO.class).getResultList();
        em.close();
        return list;
    }
}
