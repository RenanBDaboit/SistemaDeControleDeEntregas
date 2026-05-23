package view;

import controller.EntregaController;
import model.entity.Cliente;
import model.entity.Entrega;
import model.entity.Entregador;
import model.repository.ClienteRepository;
import model.repository.EntregaRepository;
import model.repository.EntregadorRepository;

import java.util.Map;
import java.util.Scanner;

public class EntregaView {

    private final Scanner scanner = new Scanner(System.in);

    private EntregaController entregaController;
    private EntregaRepository entregaRepository;
    private ClienteRepository clienteRepository;
    private EntregadorRepository entregadorRepository;

    public EntregaView(EntregaController entregaController, EntregaRepository entregaRepository, ClienteRepository clienteRepository, EntregadorRepository entregadorRepository) {
        this.entregaController = entregaController;
        this.entregaRepository = entregaRepository;
        this.clienteRepository = clienteRepository;
        this.entregadorRepository = entregadorRepository;
    }

    public void setController(EntregaController entregaController, EntregaRepository entregaRepository, ClienteRepository clienteRepository, EntregadorRepository entregadorRepository) {
        this.entregaController = entregaController;
        this.entregaRepository = entregaRepository;
        this.clienteRepository = clienteRepository;
        this.entregadorRepository = entregadorRepository;
    }

    public void menuEntrega() {

        int op;

        do {
            System.out.println("+===================================+");
            System.out.println("|            MENU ENTREGA           |");
            System.out.println("+===================================+");
            System.out.println("| [1] Realizar uma entrega          |");
            System.out.println("| [2] Listar entrega                |");
            System.out.println("| [3] Atualizar status              |");
            System.out.println("| [4] Finalizar entrega             |");
            System.out.println("| [0] Sair                          |");
            System.out.println("+===================================+");
            System.out.print("Escolha uma opção: ");
            try {
                op = Integer.parseInt(scanner.nextLine());

                switch (op) {
                    case 1 -> {
                        cadastrar();
                    }
                    case 2 -> {
                        listarEntregas();
                    }
                    case 3 -> {
                        atualizarStatusEntrega();
                    }
                    case 4 -> {
                        removerEntrega();
                    }
                    case 0 -> {
                        System.out.println("Saindo...");
                    }
                    default -> {
                        System.out.println("Opção incorreta!");
                    }
                }
            } catch (NumberFormatException n) {
                System.out.println("Apenas números!");
                op = -1;
            }
        } while (op != 0);
    }

    public void cadastrar() {
        int id = 0;
        int idCliente = 0;
        int idEntregador = 0;

        try {
            System.out.print("Digite o ID: ");
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Apenas números!");
        }

        listarClientes();
        try {
            System.out.print("Digite o ID do cliente: ");
            idCliente = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Apenas números!");
        }

        listarEntregadores();
        try {
            System.out.print("Digite o ID do entregador: ");
            idEntregador = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Apenas números!");
        }

        System.out.print("Digite a descrição da entrega: ");
        String descricao = scanner.nextLine();

        Entrega.Status status = Entrega.Status.PENDENTE;

        boolean sucesso = entregaController.cadastrar(id, idCliente, idEntregador, descricao, status);

        if (sucesso) {
            System.out.println("Sucesso ao cadastrar entrega");
        } else {
            System.out.println("Erro ao cadastrar entrega");
        }
    }

    public void listarClientes() {
        for (Map.Entry<Integer, Cliente> entry : entregaController.listarClientes().entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void listarEntregadores() {
        for (Map.Entry<Integer, Entregador> entry : entregaController.listarEntregadores().entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void listarEntregas() {
        for (Entrega entrega : entregaRepository.listar().values()) {
            System.out.println(entrega);
        }
    }

    private void atualizarStatusEntrega() {

        listarEntregas();

        System.out.print("Digite o ID da entrega: ");
        int id = 0;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Apenas números");
        }

        Entrega entrega = entregaRepository.buscarPorId(id);

        if (entrega == null) {
            System.out.println("Entrega não encontrada!");
            return;
        }

        if (entrega.getStatus() == Entrega.Status.PENDENTE) {

            entrega.setStatus(Entrega.Status.EM_ANDAMENTO);

            System.out.println("Agora entrega está EM_ANDAMENTO");

        } else if (entrega.getStatus() == Entrega.Status.EM_ANDAMENTO) {

            entrega.setStatus(Entrega.Status.FINALIZADA);

            System.out.println("Agora entrega está FINALIZADA");

        } else {

            System.out.println("Entrega já foi finalizada!");
        }

        entregaRepository.salvar(entrega);
    }

    public void removerEntrega() {

        listarEntregas();

        System.out.print("Digite o ID da entrega que deseja remover: ");
        int id = 0;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException n) {
            System.out.println("Apenas números");
        }

        Entrega entrega = entregaRepository.buscarPorId(id);

        if (entrega == null) {
            System.out.println("Entrega não encontrada");
            return;
        }

        if (entrega.getStatus() == Entrega.Status.EM_ANDAMENTO) {
            System.out.println("Não é possível remover entrega em andamento");
            return;
        }

        entregaRepository.remover(id);

        System.out.println("Entrega removida com sucesso");
    }
}
