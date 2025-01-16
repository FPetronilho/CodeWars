package codewars.kyu5.binarygeneticalgorithm;

import java.util.stream.IntStream;

public class GeneticAlgorithm {

    public String generate(int length) {
        StringBuilder chromosome = new StringBuilder();
        for (int i=0; i<length; i++) {
            chromosome.append(Math.random() < 0.5 ? 0 : 1);
        }

        return chromosome.toString();
    }

//    private String[] select(List<String> population, List<Double> fitnesses) {
//        // TODO: Implement the select method
//    }
//
//    private String mutate(String chromosome, double p) {
//        // TODO: Implement the mutate method
//    }
//
    public String[] crossover(String chromosome1, String chromosome2) {
        int chromosomeLength = chromosome1.length();
        StringBuilder cross1 = new StringBuilder();
        StringBuilder cross2 = new StringBuilder();

        cross1.append(chromosome1.substring(0, chromosomeLength/2+1));
        cross1.append(chromosome2.substring(chromosomeLength/2+1));
        cross2.append(chromosome2.substring(0, chromosomeLength/2+1));
        cross2.append(chromosome1.substring(chromosomeLength/2+1));

        return new String[] {cross1.toString(), cross2.toString()};
    }
//
//    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m) {
//        // TODO: Implement the run method
//    }
//
//    public String run(ToDoubleFunction<String> fitness, int length, double p_c, double p_m, int iterations) {
//        // TODO: Implement the run method
//    }
}