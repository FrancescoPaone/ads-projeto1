package br.puc.ads.projetoIntegrador1;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String arquivoDados = "dadosPaciente.txt";
    static String nomePaciente = "";
    static int idadeDoPaciente = 0;
    static String dataDeNascimento = "";
    static int idVacina = 0;
    static String[][] vacinas = new String[40][5];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opMenu;
        boolean continuar = true;

        carregarDados();


        do {
            try {

                System.out.println("Escolha uma opção:");
                System.out.println("1 - Cadastro/Informações do Paciente");
                System.out.println("2 - Aplicar vacina");
                System.out.println("3 - Alterar Registros");
                System.out.println("4 - Sair");

                opMenu = sc.nextInt();

                switch (opMenu) {

                    case 1:
                        if (!nomePaciente.isEmpty()) {
                            System.out.println("------------------------------");
                            System.out.println("Nome do paciente: " + nomePaciente);
                            System.out.println("Idade do paciente: " + idadeDoPaciente);
                            System.out.println("Data de nascimento paciente: " + dataDeNascimento);
                            System.out.println();
                            System.out.println("Vacinas tomadas:");
                            System.out.println();

                            for (String[] vacina : vacinas) {
                                if (vacina[0] != null) {

                                    System.out.println("Vacina " + vacina[0] + " : " + vacina[1] + " ---- Lote: " + vacina[3]);
                                    System.out.println("Data de aplicação: " + vacina[2]);
                                    System.out.println("Obs: " + vacina[4]);
                                    System.out.println();
                                }
                            }

                            System.out.println("------------------------------");
                            break;
                        } else {
                            System.out.println("Nenhum paciente cadastrado. Cadastrastre o Paciente.");
                            System.out.println("Digite o nome do paciente:");
                            String nomePacienteAux = sc.next();
                            System.out.println("Digite a idade do paciente:");
                            int idadeDoPacienteAux = sc.nextInt();
                            System.out.println("Digite a data de nascimento (DD/MM/AAAA) do paciente:");
                            String dataDeNascimentoAux = sc.next();

                            nomePaciente = nomePacienteAux;
                            idadeDoPaciente = idadeDoPacienteAux;
                            dataDeNascimento = dataDeNascimentoAux;

                            System.out.println("O paciente: " + nomePaciente + " foi cadastrado com sucesso.");
                            break;
                        }

                    case 2:

                        if (nomePaciente.isEmpty()) {
                            System.out.println("Nenhum paciente cadastrado, por favor, cadastre o paciente primeiro");
                            break;
                        } else {

                            System.out.println("Aplicando vacina para " + nomePaciente);
                            System.out.println("Digite o nome da vacina:");
                            String nomeVacina = sc.next();
                            System.out.println("Digite a data da vacina:");
                            String dataVacina = sc.next();
                            System.out.println("Digite o lote da vacina: ");
                            String loteVacina = sc.next();
                            System.out.println("Alguma observação a ser feita?");
                            sc.nextLine();
                            String obs = sc.nextLine();

                            int posicaoVazia = -1;
                            for (int i = 0; i < vacinas.length; i++) {
                                if (vacinas[i][0] == null) {
                                    posicaoVazia = i;
                                    break;
                                }
                            }

                            if (posicaoVazia != -1) {
                                idVacina++;
                                vacinas[posicaoVazia][0] = String.valueOf(idVacina);
                                vacinas[posicaoVazia][1] = nomeVacina;
                                vacinas[posicaoVazia][2] = dataVacina;
                                vacinas[posicaoVazia][3] = loteVacina;
                                vacinas[posicaoVazia][4] = obs;
                                System.out.println("Vacina " + nomeVacina + " aplicada com sucesso ");
                                break;
                            }
                        }
                    case 3:

                        if (nomePaciente.isEmpty()) {
                            System.out.println("Nenhum paciente cadastrado, por favor, cadastre o paciente primeiro");
                            break;
                        } else {
                            System.out.println("O que deseja alterar?");
                            System.out.println("1 - Nome");
                            System.out.println("2 - Idade");
                            System.out.println("3 - Data de nascimento (dd/mm/aaaa)");
                            System.out.println("4 - Vacinas tomadas");
                            int opMod = sc.nextInt();
                            switch (opMod) {
                                case 1:
                                    System.out.println("Digite o novo nome do paciente:");
                                    nomePaciente = sc.next();
                                    System.out.println("Nome modificado com sucesso.");
                                    break;

                                case 2:
                                    System.out.println("Digite a nova idade do paciente:");
                                    idadeDoPaciente = sc.nextInt();
                                    System.out.println("Idade modificada com sucesso.");
                                    break;

                                case 3:
                                    System.out.println("Digite a nova data de nascimento (DD/MM/AAAA) do paciente:");
                                    dataDeNascimento = sc.next();
                                    System.out.println("Data de nascimento modificada com sucesso.");
                                    break;
                                case 4:
                                    System.out.println("Digite o id da vacina que deseja alterar:");
                                    sc.nextLine();
                                    String idPesquisaVacina = sc.nextLine();

                                    if (encontrarVacina(idPesquisaVacina) == null) {
                                        System.out.println("Id da vacina não encontrado;");
                                        break;
                                    } else {
                                        System.out.println("Qual informação da vacina você deseja alterar?");
                                        System.out.println("1 - Nome da vacina");
                                        System.out.println("2 - Data de aplicação da vacina");
                                        System.out.println("3 - Lote da vacina");
                                        System.out.println("4 - observação");
                                        switch (sc.nextInt()) {
                                            case 1:
                                                sc.nextLine();
                                                System.out.println("Qual será o novo nome da vacina?");
                                                vacinas[encontrarVacina(idPesquisaVacina)][1] = sc.nextLine();
                                                break;
                                            case 2:
                                                sc.nextLine();
                                                System.out.println("Qual será a nova data de aplicação da vacina?");
                                                vacinas[encontrarVacina(idPesquisaVacina)][2] = sc.nextLine();
                                                break;
                                            case 3:
                                                sc.nextLine();
                                                System.out.println("Qual será o novo lote da vacina?");
                                                vacinas[encontrarVacina(idPesquisaVacina)][3] = sc.nextLine();
                                                break;
                                            case 4:
                                                sc.nextLine();
                                                System.out.println("Qual será a nova obervação da vacina?");
                                                vacinas[encontrarVacina(idPesquisaVacina)][4] = sc.nextLine();
                                                break;
                                            default:
                                                System.out.println("Opção invalida.");
                                                break;
                                        }
                                    }

                            }

                        }
                        break;

                    case 4:
                        salvarDados();
                        System.out.println("Até logo.");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Formato inválido, tente novamente.");
                sc.nextLine();

            } catch (Exception e) {
                System.out.println("Opção invalida.");
                sc.nextLine();
            }
        } while (continuar);
    }

    private static void carregarDados() {
        File arquivo = new File(arquivoDados);
        if (!arquivo.exists()) {
            System.out.println("Nenhum dado encotrado. Iniciando novo cadastro...");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            nomePaciente = br.readLine();
            idadeDoPaciente = Integer.parseInt(br.readLine());
            dataDeNascimento = br.readLine();
            String linhaVacina;
            int i = 0;
            while ((linhaVacina = br.readLine()) != null) {
                vacinas[i++] = linhaVacina.split(",");
                idVacina = i;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de dados não encontrado.");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de dados: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Formato de número inválido nos dados carregados.");
        }
    }

    private static void salvarDados() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoDados))) {
            bw.write(nomePaciente + "\n");
            bw.write(idadeDoPaciente + "\n");
            bw.write(dataDeNascimento + "\n");
            for (String[] vacina : vacinas) {
                if (vacina[0] != null) {
                    bw.write(String.join(",", vacina) + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    static Integer encontrarVacina(String id) {

        for (int i = 0; i < vacinas.length; i++) {
            if (id.equals(vacinas[i][0])) {
                return i;
            }
        }
        return null;
    }
}

