package orm.ddl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GeraTabelaInscritosDDL {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("inscritos");
		factory.close();
	}
}
