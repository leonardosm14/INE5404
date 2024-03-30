import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        double gradesSum = 0.0;
        int amountOfStudents;

        Scanner sc = new Scanner(System.in);

        //String[] names = {"Anna", "Dani", "Ella", "Gabriel", "Nick"};
        String[] names = {"Anna", "Dani"};
        amountOfStudents = names.length;

        for (int t = 0; t < amountOfStudents; t++) {
            Students name = new Students(names[t]);

            System.out.printf("Type the amount of grades: \n");
            int qnt = sc.nextInt();
            name.setTestAmount(qnt);

            // consider the maximum for qnt is three;
            while (qnt != 0) {

                String tst = "third";
                switch (qnt) {
                    case 1:
                        tst = "first";
                        break;
                    case 2:
                        tst = "second";
                        break;
                }
                System.out.printf("Type %s's %s grade: \n", name.getName(), tst);
                double grade = sc.nextDouble();

                name.setTestGrade(grade);
                name.calculateParcialAverage();

                qnt--;
            }

            // final Average;
            double finalAverage = name.getAverage();
            gradesSum += finalAverage;
            System.out.printf("%s's final average is: %.2f\n", name.getName(), finalAverage);
        }
    
        Averages cls = new Averages(amountOfStudents, gradesSum);
        System.out.printf("The class average is: %.2f", cls.calculateClassAverage());

    }
}