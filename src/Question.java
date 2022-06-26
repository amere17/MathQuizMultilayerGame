import java.util.ArrayList;
import java.util.Vector;

public class Question {
    private double result;
    private String ques = "";
    private int quesLevel = 3;
    private char[] operators = {'*', '-', '+'};
    private Vector<Character> operList = new Vector<Character>();
    private Vector<Integer> numList = new Vector<Integer>();

    public Question() {
        makeQuiz();
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    private char rndOperator() {
        return operators[(int) (Math.random()*3)];
    }

    private int rndNumber() {
        return (int) (Math.random() * 15)+1;
    }

    private void makeQuiz() {
        char oper = rndOperator();
        while (quesLevel != 0) {
            int num = rndNumber();
            ques += num + " ";
            numList.add(num);
            if (quesLevel >1) {
                ques += oper + " ";
                operList.add(oper);
            }
            quesLevel--;
        }
        ques+="= ";
        setResult(doMath());
    }

    private double doMath() {
        double res = numList.get(0);
        for (int i=1,j=0;i<numList.size()&&j<operList.size();i++,j++) {
            switch (operList.get(j)) {
                case '*':
                    res*=numList.get(i);
                    break;
                case '+':
                    res+=numList.get(i);
                    break;
                case '-':
                    res-=numList.get(i);
                    break;
            }

        }
        return res;
    }

    public String toString(int i) {
        return "_____________________\nQuestion "+i+") " + ques ;
    }
}


