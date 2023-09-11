import static java.lang.math.tanh;

protected class NewNeuron {
    double outputConf = 0; //confidence output

    double weights[] = new double[inputs.length];
    double weightedInputs[] = new double[inputs.length]; //declaring our variables for weighting

    double summedInputs;
    double activatedInputs; //the final steps

    /**
     * @param inputs 1d double array of inputs
     * @return the inputs after being weighted, added, and activated
     */
    protected NewNeuron(double[] inputs) {
        weightedInputs = multiplyIntArrays(inputs, weights);
        summedInputs = summationFunction(weightedInputs);
        activatedInputs = activationFunction(summedInputs); // puts everything together, sums weighted inputs, then activates
        outputConf = activatedInputs;
    }

    private double activationFunction(double toActivate) {
        return tanh(toActivate);
    }

    /**
     * @return the arrays in the inputs multiplied together
     */
    private int[] multiplyIntArrays(arr1[], arr2[]) {
        double mult[ arr1.length];
        for (int i = 0; i < arr1.length - 1; i++) {
            mult = (arr1[i] * arr2[i]);
        }
        return mult;
    }

    private double summationFunction(arr1[]) {
        double output = 0;
        for (int i = 0; i < arr1.length - 1; i++) {
            output += arr1[i];
        }
        return output;
    }

    protected double[] getWeights() {
        return weights;
    }

    protected void setWeights(double[] newWeights) {
        weights = newWeights;
    }
}