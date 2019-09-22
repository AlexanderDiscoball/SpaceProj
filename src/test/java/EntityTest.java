
import math.entity.Segment;
import math.entity.StackSegments;
import org.junit.Test;

import static org.junit.Assert.*;

public class EntityTest {
    private Segment segmentBefore = new Segment(0,1,0);
    private Segment segmentOnBefore = new Segment(0,2,0);

    private Segment segmentAfter = new Segment(5,6,0);
    private Segment segmentOnAfter = new Segment(4,6,0);

    private Segment mainSegment = new Segment(2,4,0);
    private Segment equalsSegment = new Segment(2,4,0);

    private Segment segmentInsideBefore = new Segment(1,3,0);
    private Segment segmentInsideAfter = new Segment(3,5,0);

    private StackSegments stack = new StackSegments(0);

    @Test
    public void before() {
        int size = 2;
        stack.add(mainSegment);
        stack.add(segmentBefore);
        int realSize = stack.getSize();
        assertEquals(size,realSize);
    }
    @Test
    public void after() {
        int size = 2;
        stack.add(mainSegment);
        stack.add(segmentAfter);
        int realSize = stack.getSize();
        assertEquals(size,realSize);
    }
    @Test
    public void afterAndOn() {
        int size = 2;
        stack.add(mainSegment);
        stack.add(segmentOnAfter);
        int realSize = stack.getSize();
        assertEquals(size,realSize);
    }
    @Test
    public void beforeAndOn() {
        int size = 2;
        stack.add(mainSegment);
        stack.add(segmentOnBefore);
        int realSize = stack.getSize();
        assertEquals(size,realSize);
    }
    @Test
    public void equalsSegments() {
        int size = 1;
        stack.add(mainSegment);
        stack.add(equalsSegment);
        int realSize = stack.getSize();
        assertEquals(size,realSize);
    }
    @Test
    public void insideBefore() {
        int size = 1;
        stack.add(mainSegment);
        stack.add(segmentInsideBefore);
        int realSize = stack.getSize();
        assertEquals(size,realSize);
    }
    @Test
    public void insideAfter() {
        int size = 1;
        stack.add(mainSegment);
        stack.add(segmentInsideAfter);
        int realSize = stack.getSize();
        assertEquals(size,realSize);
    }

}
