package by.htp.krozov.sample.javabasics;

import java.util.Random;

/**
 * Created by Виталий on 25.11.2014.
 */
public class UhenikMetod {

    int student;
    int less;
    int[][] studentsPoints;
    double[] meanPointFoLess;
    double[] meanPointFoStudent;

    UhenikMetod(int minStudent, int maxStudent, int minLess, int maxLess) {
        student = students(minStudent, maxStudent);
        less = lessons(minLess, maxLess);
        studentsPoints = new int[student][less];
        studentsPoints = massPoints(student, less);
        meanPointFoStudent = new double[student];
        meanPointFoStudent = meanRowInt(studentsPoints);
        meanPointFoLess = new double[less];
        meanPointFoLess = meanCollInt(studentsPoints);
    }

    //Метод возвращает количество студентов
    int students(int minStudent, int maxStudent) {
        return new Random().nextInt(maxStudent - minStudent) + minStudent + 1;
    }

    //Метод возвращает количество студентов
    int lessons(int minLess, int maxLess) {
        return new Random().nextInt(maxLess - minLess) + minLess + 1;
    }

    //Метод возвращает двухмерный массив заполненный случайными интами в диапазоне от 1 до 10
    int[][] massPoints(int student, int less) {
        int[][] rezult = new int[student][less];
        for (int i = 0; i < student; i++) {
            for (int i1 = 0; i1 < less; i1++) {
                rezult[i][i1] = new Random().nextInt(10) + 1;
            }
        }
        return rezult;
    }

    //Метод возвращает массив средних арифмитических по сторке из двухмерного массива интов
    double[] meanRowInt(int[][] gridPoints) {
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

    //Метод возвращает массив средних арифмитических по столбцу из двухмерного массива интов
    double[] meanCollInt(int[][] gridPoints) {
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

    //Метод возвращает из массива наименьшее значение при известном максимальном
    double returnSmollPoint(double[] massiv, double maxPoint) {
        for (double rez : massiv) {
            if (maxPoint > rez) {
                maxPoint = rez;
            }
        }
        return maxPoint;
    }

    //Метод возвращает из массива наибольшее значение при известном минимальном
    double returnBigPoint(double[] massiv, double minPoint) {
        for (double rez : massiv) {
            if (minPoint < rez) {
                minPoint = rez;
            }
        }
        return minPoint;
    }

    //Метод возвращает отсортированный одномерный массив
    double[] sortMassive(double[] massiv) {
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

        UhenikMetod studentsCheck = new UhenikMetod(15, 25, 8, 12);

        // Выводим данные из массива
        System.out.println("Журнал оценок:");
        for (int i = 0; i < studentsCheck.student; i++) {
            System.out.print("Number of students: " + (i + 1) + " ,");
            for (int ii = 0; ii < studentsCheck.less; ii++) {
                System.out.print("Rating # " + (ii + 1) + " = " + studentsCheck.studentsPoints[i][ii] + " ,");
            }
            System.out.println();
        }
        System.out.println();

        //Выводим среднюю оценку по предметам
        System.out.println("Средняя оценка по предметам:");
        for (int i = 0; i < studentsCheck.less; i++) {
            System.out.print("Средняя оценка по предмету " + (i + 1) + " = ");
            System.out.printf("%6.2f %n", studentsCheck.meanPointFoLess[i]);
        }
        System.out.println();

        //Выводим средний балл по студенту
        System.out.println("Средняя оценка по студенту:");
        for (int i = 0; i < studentsCheck.student; i++) {
            System.out.print("Средняя оценка по студенту " + (i + 1) + " = ");
            System.out.printf("%6.2f %n", studentsCheck.meanPointFoStudent[i]);
        }
        System.out.println();

        // Выводим минимальную и максимальную среднюю оценку студента
        System.out.print("Самый плохой ученик со средней оценкой:");
        System.out.printf("%6.2f %n", studentsCheck.returnSmollPoint(studentsCheck.meanPointFoStudent, 10));
        System.out.print("Самый лучший ученик со средней оценкой:");
        System.out.printf("%6.2f %n", studentsCheck.returnBigPoint(studentsCheck.meanPointFoStudent, 0));

        // Выводим минимальную и максимальную среднюю оценку студента
        System.out.print("Самый плохой ученик со средней оценкой (Вариант 2):");
        System.out.printf("%6.2f %n", studentsCheck.sortMassive(studentsCheck.meanPointFoStudent)[0]);
        System.out.print("Самый лучший ученик со средней оценкой (Вариант 2):");
        System.out.printf("%6.2f %n", studentsCheck.sortMassive(studentsCheck.meanPointFoStudent)[studentsCheck.meanPointFoStudent.length - 1]);
    }
}
