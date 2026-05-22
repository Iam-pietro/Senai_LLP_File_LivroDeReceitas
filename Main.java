import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nome da receita
        System.out.print("Nome da receita: ");
        String nomeReceita = sc.nextLine().trim();

        if (nomeReceita.isEmpty()) {
            System.out.println("Nome da receita não pode ser vazio.");
            return;
        }

        // Ingredientes
        ArrayList<String> ingredientes = new ArrayList<>();
        System.out.println("\n--- Ingredientes ---");
        System.out.println("(Deixe a descrição em branco para parar)");

        int numIngrediente = 1;
        while (true) {
            System.out.print("Descrição do ingrediente " + numIngrediente + ": ");
            String descricao = sc.nextLine().trim();

            if (descricao.isEmpty()) break;

            System.out.print("Quantidade: ");
            String quantidade = sc.nextLine().trim();

            ingredientes.add(numIngrediente + ". " + descricao + " - " + quantidade);
            numIngrediente++;
        }

        // Instruções
        ArrayList<String> instrucoes = new ArrayList<>();
        System.out.println("\n--- Instruções ---");
        System.out.println("(Deixe o passo em branco para parar)");

        int numPasso = 1;
        while (true) {
            System.out.print("Passo " + numPasso + ": ");
            String passo = sc.nextLine().trim();

            if (passo.isEmpty()) break;

            instrucoes.add("Passo " + numPasso + ": " + passo);
            numPasso++;
        }

        sc.close();

        // Salvar arquivo
        String nomeArquivo = nomeReceita + ".txt";

        try (FileWriter fw = new FileWriter(nomeArquivo)) {
            fw.write(nomeReceita + "\n");
            fw.write("\n");

            fw.write("Ingredientes:\n");
            for (String ingrediente : ingredientes) {
                fw.write(ingrediente + "\n");
            }
            fw.write("\n");

            fw.write("Instruções:\n");
            for (String instrucao : instrucoes) {
                fw.write(instrucao + "\n");
            }

            System.out.println("\n✅ Receita salva em: " + nomeArquivo);

        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }
}