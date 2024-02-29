package validating;

public class Calculator {

    public int factorial(int num) {

        int answer = 1;
        for (int i = 1; i <= num; i++) {
            answer *= i;
        }
        
        if(num < 0){
            throw new IllegalArgumentException("Invalid number");
        }

        return answer;
    }

    public int binomialCoefficent(int setSize, int subsetSize) {

        int numerator = factorial(setSize);
        int denominator = factorial(subsetSize) * factorial(setSize - subsetSize);

        if(setSize < 0 || subsetSize < 0){
            throw new IllegalArgumentException("Invalid Number(s)");                        
        }
            
        if (subsetSize > setSize){
            throw new IllegalArgumentException("Values not possible");
        }
        return numerator / denominator;
    }
}
