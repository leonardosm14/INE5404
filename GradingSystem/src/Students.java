public class Students {
    private String studentName;
    private double testGrade;
    private int amountOfTests;
    private double average_grade = 0.0;

    public Students(String studentName) {
        this.studentName = studentName;
    }

    public String getName() {
        return studentName;
    }

    public void setTestAmount(int amountOfTests) {
        this.amountOfTests = amountOfTests;
    }

    public void setTestGrade(double testGrade) {
        this.testGrade = testGrade;
    }

    public void calculateParcialAverage() {
        average_grade += testGrade / amountOfTests;
    } 

    public double getAverage() {
        return average_grade;
    }
}