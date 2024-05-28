package io.github.lsmcodes.stream.desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrdenarNumeros {

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                boolean aguardarInput = true;

                List<Integer> numeros = new ArrayList<>();

                System.out.println("\nDigite um número por vez ou digite \"fim\" para sair:");
                while (aguardarInput) {
                        String opcao = scanner.nextLine();
                        if (opcao.equalsIgnoreCase("fim")) {
                                aguardarInput = false;
                        } else {
                                int numero = Integer.parseInt(opcao);
                                numeros.add(numero);
                        }
                }
                scanner.close();

                List<Integer> numerosOrdenados = numeros.stream()
                                .sorted()
                                .toList();

                System.out.println("Números ordenados: " + numerosOrdenados);
        }

}