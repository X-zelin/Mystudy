package Array;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class DynamicArrayTest {

    @Test
    public void foreach() {
        DynamicArray array = new DynamicArray();
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);
        array.addLast(6);
        array.addLast(7);
        array.addLast(8);
        array.addLast(9);
        assertIterableEquals(List.of(1,2,3,4,5,6,7,8,9),array);
    }
}