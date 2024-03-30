public class Averages {
    
    private int amountOfStudents;
    private double gradesSum;

    public Averages(int amountOfStudents, double gradesSum) {
        this.amountOfStudents = amountOfStudents;
        this.gradesSum = gradesSum;
    }

    public double calculateClassAverage() {
        return gradesSum / amountOfStudents;
    }
}
