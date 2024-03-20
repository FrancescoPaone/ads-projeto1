package br.puc.ads.projetoIntegrador1;

import br.puc.ads.projetoIntegrador1.model.Paciente;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Boolean continuar = true;
        String resposta;
        Scanner sc = new Scanner(System.in);

        Paciente paciente1 = new Paciente("Fran", 18);

        //ESTUDAR DO-WHILE E SWITCH CASE.


        do {
            System.out.println(paciente1);

            System.out.println("Deseja sair?(sim ou não)");
            resposta = sc.nextLine();

            if (resposta.equals("sim")) {
                continuar = false;
            } else {
            }

        } while (continuar);

    }
}