package math.entity;

import java.util.ArrayList;
import java.util.Collections;

public class StackSegments {
    private ArrayList<Segment> segmentsList;
    private final int numberOfLine;

    public StackSegments(int numberOfLine){
        this.numberOfLine = numberOfLine;
        segmentsList = new ArrayList<>();
    }

    public void add(Segment segment){
        if(isLineEquals(segment)) {
            if (segmentsList.isEmpty()) {
                segmentsList.add(segment);
            } else {
                if (isSegmentCanBeInList(segment)) {
                    segmentsList.add(segment);
                    Collections.sort(segmentsList);
                    Collections.reverse(segmentsList);
                }
            }
        }
    }
    public void addWithoutLineEquals(Segment segment){
        if(segmentsList.isEmpty()){
            segmentsList.add(segment);
        }
        else{
            if(isSegmentCanBeInList(segment)){
                segmentsList.add(segment);
                Collections.sort(segmentsList);
                Collections.reverse(segmentsList);
            }
        }
    }

    public void addZeroSegments(Segment segment) {
        segmentsList.add(segment);
    }

    private boolean isLineEquals(Segment segment){
        return segment.getLine() == numberOfLine;
    }

    public Segment get(int index){
        return segmentsList.get(index);
    }

    public int getNumberOfLine(){
        return numberOfLine;
    }

    public boolean isSegmentCanBeInList(Segment segment){
        for (Segment segmentInList : segmentsList) {
            if((segment.getFirstDot()<segmentInList.getSecondDot()
                    && segment.getSecondDot()>segmentInList.getFirstDot())){
                return false;
            }
        }
        return true;
    }

    public void removeAll(){
        segmentsList.clear();
    }

    @Override
    public String toString(){
        return "Линия видимости "
                + numberOfLine
                + segmentsList.toString() ;
    }

    public int getSize(){
        return segmentsList.size();
    }

    public void sortLineSegments(){
        Collections.sort(this.segmentsList);
        Collections.reverse(this.segmentsList);
    }
    public boolean isEmpty(){
        return this.segmentsList.isEmpty();
    }
}
