package math;

import math.entity.Segment;
import math.entity.StackSegments;
import math.entity.ZeroSegment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    private static final int channelAmount = 1000;
    private static final int segmentsAmount = 1000;
    private static final int timeAmount = 10000000;
    private static StackSegments bestWay = new StackSegments(-1);
    private static ArrayList<StackSegments> allWays = new ArrayList<>();
    private static int sum = 0;

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();


        Segment[][] matrix = GeneratorRandom.generateSegmentMatrix(channelAmount, timeAmount, segmentsAmount);

        //getLengthMatrix(matrix);
        System.out.println();
        //getStartEndDotMatrix(matrix);
        greedyAlgoritm(matrix);

        System.out.println();
        System.out.println(sum);
        System.out.println(allWays.size());
        System.out.println(bestWay.toString());

        long stopTime = System.currentTimeMillis();
        System.out.println("Время выполнения программы: " + (stopTime - startTime) + " миллисекунды");
    }

    private static void greedyAlgoritm(Segment[][] matrix) {

        ArrayList<Segment> list = new ArrayList<>();
        boolean containSegments = true;
        while (containSegments) {
            for (int i = 0; i < segmentsAmount; i++) {
                for (int j = 0; j < channelAmount; j++) {

                    list.add(matrix[j][i]);

                    if ((j + 1) == channelAmount) {

                        sortSegmentByLength(list);

                        for (Segment segment : list) {

                            int lessThanTimeAmount = sum + segment.getLength();
                            if (lessThanTimeAmount <= timeAmount && bestWay.isSegmentCanBeInList(segment)) {
                                bestWay.addWithoutLineEquals(segment);
                                sum += segment.getLength();
                                matrix[i][segment.getLine()] = ZeroSegment.getInstance();
                                break;
                            }
                        }
                    }
                }
                list = new ArrayList<>();
            }
            allWays.add(bestWay);
            bestWay.removeAll();
            if (isOnlyZeroSegments(sum)) {
                containSegments = false;
            }
            else {
                sum=0;
            }

        }
    }

    private static void sortSegmentByLength(ArrayList<Segment> listik) {
        Comparator<Segment> comparator = Comparator.comparing(Segment::getLength);
        listik.sort(comparator);
        Collections.reverse(listik);
    }

    private static void getLengthMatrix(Segment[][] matrix) {
        for (int i = 0; i < channelAmount; i++) {
            for (int j = 0; j < segmentsAmount; j++) {
                System.out.printf("%3d", matrix[i][j].getLength());
            }
            System.out.println();
        }
    }

    private static void getStartEndDotMatrix(Segment[][] matrix) {
        for (int i = 0; i < channelAmount; i++) {
            for (int j = 0; j < segmentsAmount; j++) {
                String b = (matrix[i][j]).getSecondDot() + "," + (matrix[i][j]).getFirstDot() + "  ";
                System.out.print(b);
            }
            System.out.println();
        }
    }

    private static boolean isOnlyZeroSegments(int sum) {
        return sum == 0;
    }
}
