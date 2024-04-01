package br.puc.ads.projetoIntegrador1;

import java.io.*;
import java.util.Scanner;

public class Main {
    static String arquivoDados = "dadosPaciente.txt";
    static String nomePaciente = "";
    static int idadeDoPaciente = 0;
    static String dataDeNascimento = "";
    static String[][] vacinas = new String[40][4];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opMenu;
        boolean continuar = true;

        carregarDados();

        do {

            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastro/Informações do Paciente");
            System.out.println("2 - Aplicar vacina");
            System.out.println("3 - Atualizar Paciente");
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

                                System.out.println("Vacina: " + vacina[0] + " ---- Lote: " + vacina[2]);
                                System.out.println("Data de aplicação: " + vacina[1]);
                                System.out.println("Obs: " + vacina[3]);
                                System.out.println();
                            }
                        }

                        System.out.println("------------------------------");
                        break;
                    } else {
                        System.out.println("Nenhum paciente cadastrado. Cadastrastre o Paciente.");
                        System.out.println("Digite o nome do paciente:");
                        nomePaciente = sc.next();
                        System.out.println("Digite a idade do paciente:");
                        idadeDoPaciente = sc.nextInt();
                        System.out.println("Digite a data de nascimento (DD/MM/AAAA) do paciente:");
                        dataDeNascimento = sc.next();
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
                            vacinas[posicaoVazia][0] = nomeVacina;
                            vacinas[posicaoVazia][1] = dataVacina;
                            vacinas[posicaoVazia][2] = loteVacina;
                            vacinas[posicaoVazia][3] = obs;
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
                if (vacina[0] != null ) {
                    bw.write(String.join(",", vacina) + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }
}
