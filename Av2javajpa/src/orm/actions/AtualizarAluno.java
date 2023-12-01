package orm.actions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import orm.modelo.Aluno;


public class AtualizarAluno {
    public static void main(String[] args) throws ParseException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("inscritos");
        EntityManager manager = factory.createEntityManager();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digitar o ID que deseja atualizar: ");
        Long id = sc.nextLong();
        sc.nextLine();
        Aluno aluno1 = manager.find(Aluno.class, id);

        System.out.println("Nome: ");
        aluno1.setNome(sc.nextLine());
		
		System.out.println("E-mail: ");
		aluno1.setEmail(sc.nextLine());
		
		System.out.println("CPF: ");
		aluno1.setCpf(sc.nextLine());
		
		System.out.println("Endereço: ");
		aluno1.setEndereco(sc.nextLine());
		
		System.out.println("Naturalidade: ");
		aluno1.setNaturalidade(sc.nextLine());
		
		System.out.println("Data de nascimento do aluno (dd/MM/yyyy): ");
		DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		try {
			aluno1.setDataNascimento(formatador.parse(sc.nextLine()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        manager.getTransaction().begin();
        manager.merge(aluno1);
        manager.getTransaction().commit();

        System.out.println("A tarefa foi atualizada! ");

        sc.close();
        manager.close();
        factory.close();
    }
}