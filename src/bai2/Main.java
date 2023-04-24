package bai2;
import java.util.Scanner;

class student {
    private String id;
    private String name;
    private float ltScore;
    private float thScore;


    public student() {
        id = "";
        name = "";
        ltScore = 0.0f;
        thScore = 0.0f;
    }

    public student(String id, String name, float ltScore, float thScore) {
        this.id = id;
        this.name = name;
        this.ltScore = ltScore;
        this.thScore = thScore;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLtScore() {
        return ltScore;
    }

    public void setLtScore(float ltScore) {
        this.ltScore = ltScore;
    }

    public float getThScore() {
        return thScore;
    }

    public void setThScore(float thScore) {
        this.thScore = thScore;
    }

    public float calculateAverage() {
        return (this.ltScore + this.thScore) / 2;
    }

    public String toString() {
        return "ID: " + id + "\nName: " + name
                + "\nLT Score: " + ltScore + "\nTH Score: " + thScore;
    }

}
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            student sv1 = new student();
            sv1.setId("21111062080");
            sv1.setName("Trinh Minh Duc");
            sv1.setThScore(8.5f);
            sv1.setLtScore(9.5f);

            student sv2 = new student("21111062000","nguyen van a", 1.2f,3.2f);

            student sv3 = new student();
            System.out.print("Enter information for sv3: \n");
            System.out.print("Student ID: ");
            String id = scanner.nextLine();
            sv3.setId(id);
            System.out.print("Name: ");
            String name = scanner.nextLine();
            sv3.setName(name);
            System.out.print("LT score: ");
            float ltScore = scanner.nextFloat();
            sv3.setLtScore(ltScore);
            System.out.print("TH score: ");
            float thScore = scanner.nextFloat();
            sv3.setThScore(thScore);

            float sv1Avg = sv1.calculateAverage();
            float sv2Avg = sv2.calculateAverage();
            float sv3Avg = sv3.calculateAverage();

            System.out.println("MSSV\t\t\tFull Name\t\tLT Score\tTH Score\tAverage Score");
            System.out.printf("%s\t\t%s\t\t%.2f\t\t%.2f\t\t%.2f\n", sv1.getId(), sv1.getName(), sv1.getLtScore(), sv1.getThScore(), sv1Avg);
            System.out.printf("%s\t\t%s\t\t%.2f\t\t%.2f\t\t%.2f\n", sv2.getId(), sv2.getName(), sv2.getLtScore(), sv2.getThScore(), sv2Avg);
            System.out.printf("%s\t\t%s\t\t%.2f\t\t%.2f\t\t%.2f\n", sv3.getId(), sv3.getName(), sv3.getLtScore(), sv3.getThScore(), sv3Avg);

        }
    }


