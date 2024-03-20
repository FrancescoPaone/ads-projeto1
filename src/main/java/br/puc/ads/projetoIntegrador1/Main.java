package br.puc.ads.projetoIntegrador1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Boolean continuar = true;
        String resposta;
        Scanner sc = new Scanner(System.in);
        Integer opMenu;


        List<ArrayList> listaPacientes = new ArrayList<>();

        [id, nome, [nomedavacine, lote, dataAplicação]]
        [[id, nome, vacina], [id, nome, vacina],[id, nome, vacina]]

        //ESTUDAR DO-WHILE E SWITCH CASE.


        do {

            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar novo Paciente");
            System.out.println("2 - Aplicar vacina");
            System.out.println("3 - Listar todos os Pacientes");
            System.out.println("4 - Buscar Paciente pelo Nome");
            System.out.println("5 - Atualizar Paciente");
            System.out.println("6 - Excluir Paciente");
            System.out.println("7 - Sair");

            opMenu = sc.nextInt();

            switch (opMenu) {
                case 1:

                case 7:
                    System.out.println("Até logo.");
                    continuar = false;
            }

        } while (continuar);

    }
}