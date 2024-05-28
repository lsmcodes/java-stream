package io.github.lsmcodes.stream.desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class NumerosPositivos {

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

                Predicate<Integer> numeroPositivo = numero -> numero > 0;

                boolean todosNumerosPositivos = numeros.stream()
                                .allMatch(numeroPositivo);

                if (todosNumerosPositivos) {
                        System.out.println("Todos os números na lista são positivos.");
                } else {
                        System.out.println("Há ao menos um número negativo na lista.");
                }
        }

}