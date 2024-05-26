package io.github.lsmcodes.stream.functionalinterfaces;

import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * <p>
 * Representa um fornecedor de resultados de tipo <code>T</code>.
 * </p>
 * <p>
 * Não há exigências de que um resultato novo ou distinto seja retornado a cada
 * invocação de <code>Supplier</code>.
 * <p>
 */
public class SupplierExample {

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.println("\nDigite uma frase:");
                String frase = scanner.nextLine();

                System.out.println("Digite a quantidade de vezes que você deseja imprimir a frase:");
                int quantidade = Integer.parseInt(scanner.nextLine());
                scanner.close();

                // Usar o Supplier com expressão lambda para fornecer uma frase
                Supplier<String> fraseParaImprimir = () -> frase;

                // Usar Stream para gerar a frase a quantidade de vezes definida
                // Armazenar as frases geradas em uma lista
                List<String> listaDeFrases = Stream.generate(fraseParaImprimir)
                                .limit(quantidade)
                                .toList();

                // Imprimir as frases geradas
                listaDeFrases.stream()
                                .forEach(System.out::println);
        }

}