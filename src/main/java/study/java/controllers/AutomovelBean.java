package study.java.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import study.java.model.Automovel;
import study.utils.JPAUtil;

@ManagedBean
public class AutomovelBean {

	public AutomovelBean() {
		listarAutomoveis();
	}
	
	private Automovel automovel = new Automovel();
	private List<Automovel> automovels;

	public String salva() {
		EntityManager entityManager = JPAUtil.pegarEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(this.getAutomovel());
		entityManager.getTransaction().commit();
		this.setAutomovel(new Automovel());
		listarAutomoveis();
		return "listarAutomoveis?faces-redirect?true";
	}

	public List<Automovel> listarAutomoveis() {
		EntityManager entityManager = JPAUtil.pegarEntityManager();
		Query q = entityManager.createQuery("select a from Automovel a", Automovel.class);
		this.automovels = q.getResultList();
		entityManager.close();
		return automovels;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}

	public List<Automovel> getAutomovels() {
		return automovels;
	}

	public void setAutomovels(List<Automovel> automovels) {
		this.automovels = automovels;
	}

}
