package math.entity;

public class Segment implements Comparable<Segment>{
    private Integer firstDot;
    private Integer secondDot;
    private int line;
    private Integer length;


    public Segment(int firstDot, int secondDot,int line) throws IllegalArgumentException{
        if(firstDot<=secondDot) {
            this.firstDot = firstDot;
            this.secondDot = secondDot;
            this.line = line;
            this.length = secondDot - firstDot;
        }
        else throw new IllegalArgumentException();
    }

    public Integer getLength(){
        return length;
    }

    public int getFirstDot() {
        return firstDot;
    }

    public int getSecondDot() {
        return secondDot;
    }

    public int getLine() {
        return line;
    }

    @Override
    public String toString(){
        return "Segment ("
                //+"Начало: "
                +firstDot
                +","
                // +"Конец: "
                +secondDot
                +","
                +"Линия видимости: "
                +line
                +")";
    }

    public String getName(){
        return "Segment: " + getLength();
    }

    public static Segment getZeroSegment(int line){
        return new Segment(0,0, line);
    }

    @Override
    public int compareTo(Segment segment) {
        return this.secondDot.compareTo(segment.secondDot);
    }
}
