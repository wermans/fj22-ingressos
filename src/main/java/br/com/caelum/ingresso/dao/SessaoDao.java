package br.com.caelum.ingresso.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import antlr.collections.List;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class SessaoDao {

    @PersistenceContext
    private EntityManager manager;

    public void save(Sessao sessao) {

        manager.persist(sessao);
    }

    public List buscaSessoesDaSala(Sala sala) {
    	return  (List) manager.createQuery("select s from Sessao s where s.sala = :sala",Sessao.class)
    			.setParameter("sata", sala)
    			.getResultList();
        
    }

}