import java.util.Arrays;

public class Main {

    public static double[] sort(double[] input) {
        var maxOpt = Arrays.stream(input).max();
        if (maxOpt.isEmpty()) {
            return input; //Si l'entree est vide on retourne l'entree.
        }

        var maximum = maxOpt.getAsDouble();
        var n = input.length; //Calcule taille
        var buckets1 = new double[10][n]; //Bucket
        var resultatFinal = new double[n];
        var Marker = new int[10];
        Arrays.fill(Marker, 0); //Remplissage du bucket avec des 0.

        //
        for (int i = 0; i < input.length; i++) {
            var j = (Integer) Math.round((float) (input[i] / ((maximum + 1) / n)));
            buckets1[j][Marker[j]] = input[i];
            Marker[j] += 1;
        }

        var resultCounter = 0;
        for (int i = 0; i < buckets1.length; i++) {
            Sort2(buckets1[i], Marker[i]);
            for (int j = 0; j < Marker[i]; j++) {
                if (resultCounter < resultatFinal.length) {
                    resultatFinal[resultCounter++] = buckets1[i][j];
                }
            }
        }
        return resultatFinal; //Retourne le resultat final.
    }
    //Tri des buckets
    private static void Sort2(double[] array, int nbItems) {
        var Trifini = false;
        while (Trifini == false) {
            Trifini = true;
            for (int i = 0; i < nbItems - 1; i++) {
                if (array[i] > array[i + 1]) {
                    var tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                    Trifini = false;
                }
            }
        }
    }

}

