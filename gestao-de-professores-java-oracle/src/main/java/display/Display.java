package display;

import dao.ProfessorDAO;
import model.Professor;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Display {
    Scanner sc= new Scanner(System.in);
    ProfessorDAO DAO= new ProfessorDAO();
    public void cadastrarProfessor(){
        Professor novoProfessor= new Professor();
        String nome;
        int aulas;
        double valor;
        System.out.println("Qual é o nome do professor?");
        nome=sc.nextLine();
        System.out.println("Quantidade de aulas semanais?");
        aulas=sc.nextInt();
        sc.nextLine();
        System.out.println("Qual o valor da hora-aula?");
        valor=sc.nextDouble();
        sc.nextLine();
        novoProfessor.setNome(nome);
        novoProfessor.setAulasSemanais(aulas);
        novoProfessor.setValorHora(valor);
        DAO.inserir(novoProfessor);
        System.out.println("Professor cadastrado!");

    }
    public void listarProfessores(){
        List<Professor> lista = DAO.listar();
        if (lista.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }

        for (Professor p : lista) {
            System.out.printf("ID: %d | Nome: %s | Aulas/semana: %d | Regime: %s | Salário: R$ %.2f%n",
                    p.getIdProfessor(), p.getNome(), p.getAulasSemanais(),
                    p.definirRegime(), p.getSalario());
        }
    }
    public void buscarProfessor(){
        int id;
        System.out.println("Digite o ID do professor:");
        id= sc.nextInt();
        sc.nextLine();
        Optional<Professor> caixa = DAO.buscarPorId(id);
        if (caixa.isPresent()) {
            Professor profEncontrado = caixa.get();
            System.out.println("Encontrado: " + profEncontrado.getNome());
        } else {
            System.out.println("Nenhum professor encontrado com esse ID.");
        }

    }
    public void deletarProfessor() {
        System.out.println("Digite o ID do professor a deletar:");
        int id = sc.nextInt();
        sc.nextLine();

        Optional<Professor> caixa = DAO.buscarPorId(id);
        if (caixa.isEmpty()) {
            System.out.println("Nenhum professor encontrado com esse ID.");
            return;
        }

        Professor p = caixa.get();
        DAO.deletar(p);
        System.out.println("Professor " + p.getNome() + " deletado com sucesso.");
    }
}
