package math;

import math.entity.Segment;
import math.entity.StackSegments;
import math.entity.ZeroSegment;
import java.util.ArrayList;

public class GeneratorRandom {

    private static ArrayList<StackSegments> checkList = new ArrayList<>();
    private static ArrayList<StackSegments> matrixList;

    public static Segment generateRandomSegment(int amountOfTime, int lineNumber){
        int firstDot = getRandomNumber(0,amountOfTime);
        int secondDot = getRandomNumber((firstDot+1),(amountOfTime-firstDot));

        return new Segment(firstDot, secondDot, lineNumber);
    }

    private static void generateStackFromZeroToChannelAmount(int channelAmount, int amountOfTime, int maxSegmentsAmount) {
        matrixList = new ArrayList<>();

        for (int channel = 0; channel < channelAmount; channel++) {
            StackSegments stackSegments = new StackSegments(channel);

            for (int segmentCount = 0; segmentCount <= maxSegmentsAmount; segmentCount++) {
                stackSegments.add(generateRandomSegment(amountOfTime, stackSegments.getNumberOfLine()));
            }
            while (isStackNotFull(stackSegments,maxSegmentsAmount)){
                stackSegments.addZeroSegments(ZeroSegment.getInstance());
            }
            stackSegments.sortLineSegments();
            matrixList.add(stackSegments);

        }
    }

    public static Segment[][] generateSegmentMatrix(int channelAmount, int amountOfTime, int segmentsAmount){
        Segment[][] matrix = new Segment[channelAmount][segmentsAmount];
        generateStackFromZeroToChannelAmount(channelAmount, amountOfTime, segmentsAmount);
        for (int i = 0; i < channelAmount ; i++) {
            for (int j = 0; j < segmentsAmount; j++) {
                if(matrixList.size()>i && matrixList.get(i).getSize()>j) {
                    matrix[i][j] = matrixList.get(i).get(j);
                }
            }
        }
        return matrix;
    }

    private static boolean isStackAlreadyExist(StackSegments stackSegments){
        if(checkList != null) {
            for (StackSegments lineNumber : checkList) {
                if (lineNumber.getNumberOfLine() == stackSegments.getNumberOfLine()) {
                    return false;
                }
            }
        }
        return true;
    }
    private static int getRandomNumber(int from, int to){
        return (from + (int) (Math.random() * to));
    }
    public static StackSegments generatorRandomStackSegments(int amountOfChannel, int amountOfTime){
        int randomChannel = (int) (Math.random() * amountOfChannel);
        int segmentsAmount = (int) (Math.random() * amountOfChannel);
        StackSegments stackSegments = new StackSegments(randomChannel);
        if(isStackAlreadyExist(stackSegments)){
            for (int i = 0; i < segmentsAmount; i++){
                stackSegments.add(generatorRandomSegment(amountOfTime,stackSegments.getNumberOfLine()));
            }
            checkList.add(stackSegments);
            return stackSegments;
        }
        else return null;
    }
    public static Segment generatorRandomSegment(int amountOfChannel, int amountOfTime){
        int firstDot = getRandomNumber(0,amountOfTime);
        int secondDot = getRandomNumber((firstDot+1),(amountOfTime-firstDot));
        int channel = getRandomNumber(0,amountOfChannel);

        return new Segment(firstDot, secondDot, channel);
    }
    private static boolean isStackNotFull(StackSegments stackSegments, int maxSegmentsAmount){
        return stackSegments.getSize() < maxSegmentsAmount;
    }
}
