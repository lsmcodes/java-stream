package io.github.lsmcodes.stream.desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class SomaDosQuadrados {

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

                Function<Integer, Integer> quadrado = numero -> numero * numero;

                Integer somaDosQuadrados = numeros.stream()
                                .map(quadrado)
                                .reduce(0, Integer::sum);

                System.out.println("A soma dos quadrados de todos os números da lista é: " + somaDosQuadrados);
        }

}