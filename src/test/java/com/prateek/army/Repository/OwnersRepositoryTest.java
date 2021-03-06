package com.prateek.army.Repository;

import com.prateek.army.model.Owners;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

import static org.junit.Assert.*;

public class OwnersRepositoryTest {

    OwnersRepository ownersRepository = new OwnersRepository();

    @Test
    public void findAll() {
        List<Owners> owners = ownersRepository.findAll();
        for(Owners owner : owners)
        {
            System.out.println(owner.getFirstName());
        }
    }

    @Test
    public void countAll() {
        assertEquals(Long.valueOf(4),ownersRepository.countAll());
    }

    @Test
    public void find(){
        assertEquals("Ashutosh",(ownersRepository.find(3)).getFirstName());
    }

    @Test
    public void create() {
            Owners owner = new Owners();
            owner.setFirstName("Prateek");
            owner.setMiddleName("Kumar");
            owner.setLastName("Maurya");
            owner.setRank("Major");
            ownersRepository.create(owner);
    }

    @Test
    public void delete(){
        ownersRepository.delete(4);
    }
}