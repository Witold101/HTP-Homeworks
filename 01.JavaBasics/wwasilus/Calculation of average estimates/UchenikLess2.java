import java.util.Random;

/**
 * Created by user on 28.11.2014.
 */
public class UchenikLess2 {

    /**
     * The method returns a random number in a given period
     *
     * @param min - minimum value
     * @param max -maximum value
     */
    public static int generationPeriod(int min, int max) {
        return new Random().nextInt(max - min) + min + 1;
    }

    /**
     * This method returns an array of filled dimensional random number INT ranging from 1 to 10
     *
     * @param coll
     * @param row
     * @return
     */
    public static int[][] massPoints(int coll, int row) {
        int[][] rezult = new int[coll][row];
        for (int i = 0; i < coll; i++) {
            for (int i1 = 0; i1 < row; i1++) {
                rezult[i][i1] = new Random().nextInt(10) + 1;
            }
        }
        return rezult;
    }

    /**
     * The method returns an array of the arithmetic mean of the number in the line of the two-dimensional array
     *
     * @param gridPoints
     * @return array int
     */

    public static double[] meanRowInt(int[][] gridPoints) {
        double[] rezult = new double[gridPoints.length];
        for (int ii = 0; ii < gridPoints.length; ii++) {
            int summPoints = 0;
            for (int i = 0; i < gridPoints[0].length; i++) {
                summPoints = summPoints + gridPoints[ii][i];
            }
            rezult[ii] = (double) summPoints / gridPoints[0].length;
        }
        return rezult;
    }

    /**
     * The method returns an array of the arithmetic mean of the number in the row of the two-dimensional array
     *
     * @param gridPoints
     * @return array int
     */
    public static double[] meanCollInt(int[][] gridPoints) {
        double[] rezult = new double[gridPoints.length];
        for (int ii = 0; ii < gridPoints[0].length; ii++) {
            int summPoints = 0;
            for (int i = 0; i < gridPoints.length; i++) {
                summPoints = summPoints + gridPoints[i][ii];
            }
            rezult[ii] = (double) summPoints / gridPoints.length;
        }
        return rezult;
    }

    /**
     * The method returns an array of the smallest value at a certain maximum
     *
     * @param massiv
     * @param maxPoint
     * @return
     */
    public static double returnSmollPoint(double[] massiv, double maxPoint) {
        for (double rez : massiv) {
            if (maxPoint > rez) {
                maxPoint = rez;
            }
        }
        return maxPoint;
    }

    /**
     * The method returns an array of the highest value at a known minimum
     *
     * @param massiv
     * @param minPoint
     * @return
     */
    public static double returnBigPoint(double[] massiv, double minPoint) {
        for (double rez : massiv) {
            if (minPoint < rez) {
                minPoint = rez;
            }
        }
        return minPoint;
    }

    /**
     * The method returns a sorted one-dimensional array
     *
     * @param massiv
     * @return
     */
    public static double[] sortMassive(double[] massiv) {
        double point;
        for (int i = 0; i < massiv.length - 1; i++) {
            for (int ii = 0; ii < massiv.length - 1; ) {
                ii++;
                point = massiv[ii - 1];
                if (point > massiv[ii]) {
                    massiv[ii - 1] = massiv[ii];
                    massiv[ii] = point;
                }
            }
        }
        return massiv;
    }


    public static void main(String[] args) {

        int student = generationPeriod(15, 25);
        int less = generationPeriod(8, 12);

        int[][] studentsPoints = new int[student][less];
        studentsPoints = massPoints(student, less);
        double[] meanPointFoStudent = new double[student];
        meanPointFoStudent = meanRowInt(studentsPoints);
        double[] meanPointFoLess = new double[less];
        meanPointFoLess = meanCollInt(studentsPoints);


        // Выводим данные из массива
        System.out.println("Журнал оценок:");
        for (int i = 0; i < student; i++) {
            System.out.print("Number of students: " + (i + 1) + " ,");
            for (int ii = 0; ii < less; ii++) {
                System.out.print("Rating # " + (ii + 1) + " = " + studentsPoints[i][ii] + " ,");
            }
            System.out.println();
        }
        System.out.println();

        //Выводим среднюю оценку по предметам
        System.out.println("Средняя оценка по предметам:");
        for (int i = 0; i < less; i++) {
            System.out.print("Средняя оценка по предмету " + (i + 1) + " = ");
            System.out.printf("%6.2f %n", meanPointFoLess[i]);
        }
        System.out.println();

        //Выводим средний балл по студенту
        System.out.println("Средняя оценка по студенту:");
        for (int i = 0; i < student; i++) {
            System.out.print("Средняя оценка по студенту " + (i + 1) + " = ");
            System.out.printf("%6.2f %n", meanPointFoStudent[i]);
        }
        System.out.println();

        // Выводим минимальную и максимальную среднюю оценку студента
        System.out.print("Самый плохой ученик со средней оценкой:");
        System.out.printf("%6.2f %n", returnSmollPoint(meanPointFoStudent, 10));
        System.out.print("Самый лучший ученик со средней оценкой:");
        System.out.printf("%6.2f %n", returnBigPoint(meanPointFoStudent, 0));

        // Выводим минимальную и максимальную среднюю оценку студента
        System.out.print("Самый плохой ученик со средней оценкой (Вариант 2):");
        System.out.printf("%6.2f %n", sortMassive(meanPointFoStudent)[0]);
        System.out.print("Самый лучший ученик со средней оценкой (Вариант 2):");
        System.out.printf("%6.2f %n", sortMassive(meanPointFoStudent)[meanPointFoStudent.length - 1]);
    }

}

