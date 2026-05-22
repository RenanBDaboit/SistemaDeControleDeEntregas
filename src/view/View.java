package view;

import controller.ClienteController;
import controller.EntregaController;
import controller.EntregadorController;
import model.repository.ClienteRepository;
import model.repository.EntregaRepository;
import model.repository.EntregadorRepository;

import java.util.Scanner;

public class View {

    private Scanner scanner = new Scanner(System.in);

    private final ClienteRepository clienteRepository = new ClienteRepository();
    private final EntregadorRepository entregadorRepository = new EntregadorRepository();
    private final EntregaRepository entregaRepository = new EntregaRepository();

    private final ClienteController clienteController = new ClienteController(clienteRepository);
    private final EntregadorController entregadorController = new EntregadorController(entregadorRepository);
    private final EntregaController entregaController = new EntregaController(entregaRepository, entregadorRepository, clienteRepository);

    private final ClienteView clienteView = new ClienteView(clienteController);
    private final EntregadorView entregadorView = new EntregadorView(entregadorController);
    private final EntregaView entregaView = new EntregaView(entregaController, entregaRepository, clienteRepository, entregadorRepository);

    public void menuPrincipal() {
        int op = 0;

        do {
            System.out.println("+=====================================+");
            System.out.println("|            MENU PRINCIPAL           |");
            System.out.println("+=====================================+");
            System.out.println("| [1] Clientes                        |");
            System.out.println("| [2] Entregas                        |");
            System.out.println("| [3] Entregadores                    |");
            System.out.println("| [0] Sair                            |");
            System.out.println("+=====================================+");
            System.out.print("Escolha uma opção: ");
            try {
                op = Integer.parseInt(scanner.nextLine());

                switch (op) {
                    case 1 -> {
                        clienteView.menuCliente();
                    }
                    case 2 -> {
                        entregaView.menuEntrega();
                    }
                    case 3 -> {
                        entregadorView.menuEntregador();
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
            }
        }while (op != 0) ;
    }
}

