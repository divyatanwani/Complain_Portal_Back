package com.prateek.army.Repository;

import com.prateek.army.Utility.Utility;
import com.prateek.army.model.Owners;

import javax.persistence.*;
import java.util.List;

public class OwnersRepository {

   /* @PersistenceContext(unitName = "ComplaintPortalPU")
    private EntityManager em;*/

   Utility util = new Utility();
   EntityManager em = util.getEm();

    public List<Owners> findAll(){
        TypedQuery<Owners> query = (TypedQuery<Owners>) em.createQuery("Select o from Owners o order by o.id desc");
        return query.getResultList();
    }

    public Long countAll() {
        TypedQuery<Long> query = (TypedQuery<Long>) em.createQuery("Select COUNT(o) from Owners o");
        return query.getSingleResult();
    }

    public Owners find(Integer id){
        return em.find(Owners.class, id);
    }

    public Owners create(Owners owner){
        em.persist(owner);
        return owner;
    }

    public void delete(Integer id){
        em.remove(em.getReference(Owners.class, id));
    }
}
