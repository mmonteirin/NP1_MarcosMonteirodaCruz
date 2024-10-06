import java.util.Scanner;

public class MarcacaoPoltrona {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[][] assentos = new boolean[10][6]; // 10 fileiras, 6 assentos por fileira
        boolean continuar = true;

        while (continuar) {
            System.out.println("Selecione o tipo de passagem (E - Econômica, X - Executivo):");
            char tipoPassagem = scanner.next().charAt(0);

            System.out.println("Digite a fileira (1 a 10) e o assento (A a F) para marcar (ou 0 para sair):");
            int fileira = scanner.nextInt();
            if (fileira == 0) break;
            char assentoChar = scanner.next().charAt(0);
            int assento = assentoChar - 'A'; // Converte a letra para índice de 0 a 5

            if (fileira >= 1 && fileira <= 10 && assento >= 0 && assento < 6) {
                if (!assentos[fileira - 1][assento]) {
                    if ((tipoPassagem == 'X' && (assento == 0 || assento == 5)) || (tipoPassagem == 'E' && assento > 0 && assento < 5)) {
                        assentos[fileira - 1][assento] = true; // Ajusta o índice da fileira
                        System.out.println("Assento " + assentoChar + " na fileira " + fileira + " marcado com sucesso!");
                    } else {
                        System.out.println("Tipo de passagem e assento incompatíveis. Tente novamente.");
                    }
                } else {
                    System.out.println("Assento já está ocupado. Por favor, escolha outro.");
                }
            } else {
                System.out.println("Assento inválido. Tente novamente.");
            }

            System.out.println("Deseja marcar outro assento? (s/n)");
            continuar = scanner.next().equalsIgnoreCase("s");
        }

        scanner.close();
    }
}