package orm.actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Aluno;

public class RemoveAluno {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("inscritos");
        EntityManager manager = factory.createEntityManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual o id deseja remover: ");
        Long id = sc.nextLong();
        
        Aluno aluno1 = manager.find(Aluno.class, id);


        manager.getTransaction().begin();
        manager.remove(aluno1);
        manager.getTransaction().commit();

        System.out.println();
        manager.close();
        factory.close();
        sc.close();
    }
}
