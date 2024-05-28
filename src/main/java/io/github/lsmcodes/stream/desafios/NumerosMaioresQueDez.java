package io.github.lsmcodes.stream.desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class NumerosMaioresQueDez {

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

                Predicate<Integer> numeroMaiorQueDez = numero -> numero > 10;

                boolean existemNumerosMaioresQueDez = numeros.stream()
                                .anyMatch(numeroMaiorQueDez);

                if (existemNumerosMaioresQueDez) {
                        System.out.println("Há ao menos um número maior que 10 na lista.");
                } else {
                        System.out.println("Todos os números da lista são menores ou iguais a 10.");
                }
        }
}