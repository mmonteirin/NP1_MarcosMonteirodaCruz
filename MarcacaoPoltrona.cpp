#include <stdio.h>
#include <stdbool.h>
#include <ctype.h>

int main() {
    bool assentos[10][6] = {false}; // 10 fileiras, 6 assentos por fileira
    char continuar = 's';

    while (tolower(continuar) == 's') {
        char tipoPassagem;
        int fileira;
        char assentoChar;
        int assento;

        printf("Selecione o tipo de passagem (E - Econômica, X - Executivo): ");
        scanf(" %c", &tipoPassagem);
        printf("Digite a fileira (1 a 10) e o assento (A a F) para marcar (ou 0 para sair): ");
        scanf("%d", &fileira);

        if (fileira == 0) break;

        scanf(" %c", &assentoChar);
        assento = assentoChar - 'A'; // Converte a letra para índice de 0 a 5

        if (fileira >= 1 && fileira <= 10 && assento >= 0 && assento < 6) {
            if (!assentos[fileira - 1][assento]) {
                if ((tolower(tipoPassagem) == 'x' && (assento == 0 || assento == 5)) || (tolower(tipoPassagem) == 'e' && assento > 0 && assento < 5)) {
                    assentos[fileira - 1][assento] = true; // Ajusta o índice da fileira
                    printf("Assento %c na fileira %d marcado com sucesso!\n", assentoChar, fileira);
                } else {
                    printf("Tipo de passagem e assento incompatíveis. Tente novamente.\n");
                }
            } else {
                printf("Assento já está ocupado. Por favor, escolha outro.\n");
            }
        } else {
            printf("Assento inválido. Tente novamente.\n");
        }

        printf("Deseja marcar outro assento? (s/n): ");
        scanf(" %c", &continuar);
    }

    return 0;
}
