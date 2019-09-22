package math.entity;

public class ZeroSegment extends Segment {
    private static ZeroSegment zeroSegment;
    private ZeroSegment(int firstDot, int secondDot, int line) throws IllegalArgumentException {
        super(firstDot, secondDot, line);
    }
    public static synchronized ZeroSegment getInstance() {
        if (zeroSegment == null) {
            zeroSegment = new ZeroSegment(0,0,0);
        }
        return zeroSegment;
    }

}
