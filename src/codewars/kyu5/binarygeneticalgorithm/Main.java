package codewars.kyu5.binarygeneticalgorithm;

public class Main {
    public static void main(String[] args) {

        GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm();
        String seq1 = geneticAlgorithm.generate(10);
        System.out.println(seq1);
        String seq2 = geneticAlgorithm.generate(10);
        System.out.println(seq2);

        String[] cross = geneticAlgorithm.crossover(seq1, seq2);
        for (String s : cross) {
            System.out.println(s);
        }
    }
}
