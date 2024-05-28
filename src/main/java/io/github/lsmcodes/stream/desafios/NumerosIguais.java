package io.github.lsmcodes.stream.desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class NumerosIguais {

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

                Integer primeiroNumero = numeros.get(0);

                Predicate<Integer> numerosIguais = numero -> numero.equals(primeiroNumero);

                boolean todosNumerosIguais = numeros.stream()
                                .allMatch(numerosIguais);

                if (todosNumerosIguais) {
                        System.out.println("Todos os números da lista são iguais.");
                } else {
                        System.out.println("Há números distintos na lista.");
                }
        }

}