package io.github.lsmcodes.stream.desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumerosDistintos {

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

                List<Integer> numerosDistintos = numeros.stream()
                                .distinct()
                                .toList();

                boolean todosOsNumerosSaoDistintos = numeros.equals(numerosDistintos) ? true : false;

                if (todosOsNumerosSaoDistintos) {
                        System.out.println("Todos os números da lista são distintos.");
                } else {
                        System.out.println("Existem números repetidos na lista.");
                }
        }

}