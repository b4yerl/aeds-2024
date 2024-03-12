// Quicksort, algoritmo de ordenação presente no capítulo 4, mas aqui implementado em Java
// A ideia é dividir um array maior, em vários problemas menores até que cada um desses probleminhas esteja ordenado
// Dessa maneira garantimos de maneira eficiente que o problema maior, o array como em si, vai estar ordenado no final.

// Apesar de ser um pouco mais complexo, já fiz direto pegando o elemento do meio de cada "probleminha" como pivô
// Isso significa que iremos verificar os elementos de ambos os lados do pivô para que
// todos os menores esteja a sua esquerda e todos os maiores à direita.

// :)
public class Quicksort {
    public static Integer[] sort(Integer[] arr) {
        // Esse método apenas garante que não tomaremos erro acessando um array vazio
        // E retorna o array ordenado ao final
        if(arr == null || arr.length == 0) return new Integer[0];
        quicksort(arr, 0, arr.length - 1);
        return arr;
    }

    // Nesse método ocorre a recursividade para organizar os sub-arrays
    private static void quicksort(Integer[] arr, int menor, int maior) {
        if(menor < maior) {
            // Repare que inicialmente é feita uma primeira ordenação utilizando o meio do array como pivô
            int pivo = reorganizacao(arr, menor, maior);
            // Então começamos a organizar os sub-arrays, inicialmente pelo lado esquerdo (repare no index maior)
            quicksort(arr, menor, pivo - 1);
            // Para então olhar o lado direito
            quicksort(arr, pivo + 1, maior);
            // Como isso ocorre recursivamente, iremos ordenar todos os sub-arrays possíveis à esquerda
            // E na sequência começamos a ordenar o outro lado, vindo do menor nível para o maior
        }
    }

    private static int reorganizacao(Integer[] arr, int menor, int maior) {
        int pivo = arr[(menor + maior)/2];
        int i = menor;
        int j = maior;

        while (i < j) {
            // Enquanto os elementos à esquerda forem menores que o pivô, seguimos para o próximo
            while(arr[i] < pivo) {
                i++;
            }
            // Enquanto os elementos à direita forem menores que o pivô, seguimos para o anterior
            while(arr[j] > pivo) {
                j--;
            }
            if(i <= j) {
                // Troca os valores selecionados de cada lado para reorganizar o array em torno do pivô
                int temporario = arr[i];
                arr[i] = arr[j];
                arr[j] = temporario;
            }
        }
       // Retornamos "i", isso porque ele delimita que todos elementos a sua esquerda são menores que o pivô
        return i;
    }
}
