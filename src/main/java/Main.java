import java.util.Arrays;

public class Main {

    public static double[] sort(double[] input) {
        var maxOpt = Arrays.stream(input).max();
        if (maxOpt.isEmpty()) {
            return input;
        }

        var maximum = maxOpt.getAsDouble();
        var n = input.length; //Calcul taille
        var buckets1 = new double[10][n]; //Bucket
        var buckets2 = new int[10];
        Arrays.fill(buckets2, 0); //Remplissage du bucket avec des 0

        for (int i = 0; i < input.length; i++) {
            var j = (Integer) Math.round((float) (input[i] / ((maximum + 1) / n)));
            buckets1[j][buckets2[j]] = input[i];
            buckets2[j] += 1;
        }

        return input;
    }


}

