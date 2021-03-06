package study.java;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import study.java.model.tipoDeRelacionamentos.Marca;
import study.java.model.tipoDeRelacionamentos.Modelo;
import study.utils.JPAUtil;

public class TstMarcaModelos {

	public static void main(String[] args) {

		EntityManager entityManager = JPAUtil.pegarEntityManager();

		Marca marca = new Marca();
		Modelo modelo = new Modelo();
		
		marca.setMarca("Ferrari");
		modelo.setFkmarca(marca);
		modelo.setModelo("BX14");
		
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(modelo);
		entityTransaction.commit();
		
		entityManager.close();
		

	}

}
