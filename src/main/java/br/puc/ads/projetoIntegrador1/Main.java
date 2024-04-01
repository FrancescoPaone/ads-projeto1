package br.puc.ads.projetoIntegrador1;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Integer opMenu;
        Boolean continuar = true;

        String nomePaciente = "";
        int idadeDoPaciente = 0;
        String dataDeNascimento = "";

        String[][] vacinas = new String[40][3];
        vacinas[0][0] = "1";

        do {

            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastro/Informações do Paciente");
            System.out.println("2 - Aplicar vacina");
            System.out.println("3 - Atualizar Paciente");
            System.out.println("4 - Sair");

            opMenu = sc.nextInt();

            switch (opMenu) {

                case 1:
                    if (nomePaciente != "") {
                        System.out.println("------");
                        System.out.println("Nome do paciente: " + nomePaciente);
                        System.out.println("Idade do paciente: " + idadeDoPaciente);
                        System.out.println("Data de nascimento paciente: " + dataDeNascimento);
                        System.out.println("Vacinas tomadas:");

                        for (int i = 0; i < vacinas.length; i++ )  {
                            if (vacinas[i][0] != null && vacinas[i][1] != null && vacinas[i][2] != null) {
                                System.out.println("Nome da vacina: " + vacinas[i][0]);
                                System.out.println("Data da vacina: " + vacinas[i][1]);
                                System.out.println("Lote da vacina: " + vacinas[i][2]);
                            }
                        }

                        System.out.println("------");
                        break;
                    } else {
                        System.out.println("Nenhum paciente cadastrado. Cadastrastre o Paciente.");
                        System.out.println("Digite o nome do paciente:");
                        nomePaciente = sc.next();
                        System.out.println("Digite a idade do paciente:");
                        idadeDoPaciente = sc.nextInt();
                        System.out.println("Digite a data de nascimento(dd/mm/aaaa) do paciente:");
                        dataDeNascimento = sc.next();
                        System.out.println("O paciente: " + nomePaciente + " foi cadastrado com sucesso.");
                        break;
                    }

                case 2:

                    if (nomePaciente == ""){
                        System.out.println("Nenhum paciente cadastrado, por favor, cadastre o paciente primeiro");
                        break;
                    }else{

                    System.out.println("Aplicando vacina para " + nomePaciente);
                    System.out.println("Digite o nome da vacina:");
                    String nomeVacina = sc.next();
                    System.out.println("Digite a data da vacina:");
                    String dataVacina = sc.next();
                    System.out.println("Digite o lote da vacina:");
                    String loteVacina = sc.next();

                    int posicaoVazia = -1;
                    for (int i = 0; i < vacinas.length; i++) {
                        if (vacinas[i][0] == null) {
                            posicaoVazia = i;
                            break;
                        }
                    }

                    if (posicaoVazia != -1) {
                        vacinas[posicaoVazia][0] = nomeVacina;
                        vacinas[posicaoVazia][1] = dataVacina;
                        vacinas[posicaoVazia][2] = loteVacina;
                        System.out.println("Vacina " + nomeVacina + " aplicada com sucesso ");
                        break;
                    }
                        }
                case 3:

                    if (nomePaciente == ""){
                        System.out.println("Nenhum paciente cadastrado, por favor, cadastre o paciente primeiro");
                        break;
                    }else{
                        System.out.println("O que deseja alterar?");
                        System.out.println("1 - Nome");
                        System.out.println("2 - Idade");
                        System.out.println("3 - Data de nascimento (dd/mm/aaaa)");
                        int opMod = sc.nextInt();
                        switch (opMod) {
                            case 1:
                                System.out.println("Digite o novo nome do paciente:");
                                nomePaciente = sc.next();
                                System.out.println("Nome modificada com sucesso.");
                                break;

                            case 2:
                                System.out.println("Digite a nova idade do paciente:");
                                idadeDoPaciente = sc.nextInt();
                                System.out.println("Idade modificada com sucesso.");
                                break;

                            case 3:
                                System.out.println("Digite a nova data de nascimento(dd/mm/aaaa) do paciente:");
                                dataDeNascimento = sc.next();
                                System.out.println("Data de nascimento modificada com sucesso.");
                                break;
                        }

                    }

                case 4:
                    System.out.println("Até logo.");
                    continuar = false;
            }

        } while (continuar);
    }
}