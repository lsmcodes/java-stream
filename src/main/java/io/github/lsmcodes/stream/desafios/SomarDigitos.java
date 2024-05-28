package io.github.lsmcodes.stream.desafios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SomarDigitos {

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

                int somaTotal = numeros.stream()
                                .mapToInt(numero -> {
                                        int soma = 0;
                                        for (char digito : numero.toString().toCharArray()) {
                                                soma += Character.getNumericValue(digito);
                                        }
                                        return soma;
                                })
                                .sum();

                System.out.println(somaTotal);
        }

}