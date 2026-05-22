package view;

import controller.EntregadorController;

import java.util.Scanner;

public class EntregadorView {

    private EntregadorController entregadorController;

    public EntregadorView(EntregadorController entregadorController){
        this.entregadorController = entregadorController;
    }
    public void setController(EntregadorController entregadorController){
        this.entregadorController = entregadorController;
    }
    private final Scanner scanner = new Scanner(System.in);

    public void menuEntregador(){

        int op;

        do{
            System.out.println("+==============================+");
            System.out.println("|          MENU ENTREGADOR     |");
            System.out.println("+==============================+");
            System.out.println("| [1] Cadastrar um entregador  |");
            System.out.println("| [0] Sair                     |");
            System.out.println("+==============================+");
            System.out.print("Escolha uma opção: ");
            try{
                op = Integer.parseInt(scanner.nextLine());

                switch (op) {
                    case 1 -> {
                        cadastrar();
                    }
                    case 0 -> {
                        System.out.println("Saindo...");
                    }
                    default -> {
                        System.out.println("Opção incorreta!");
                    }
                }
                }catch (NumberFormatException n) {
                System.out.println("Apenas números!");
                op = -1;
            }
            }while(op != 0);
        }

        public void cadastrar(){
        int id = 0;
        try {
            System.out.print("Digite o ID: ");
            id = Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException n){
            System.out.println("Apenas números!");
        }
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o veículo: ");
            String veiculo = scanner.nextLine();

            boolean sucesso = entregadorController.cadastrar(id, nome, veiculo);

            if(sucesso){
                System.out.println("Sucesso ao cadastrar entregador");
            }else{
                System.out.println("Erro ao cadastrar entregador");
            }
    }

}
