import java.util.PriorityQueue;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

public class PriorityQueueTest {
    static Stream<Arguments> stringIntAndListProvider() {
        // TODO return Stream
        return Stream.of(
                Arguments.of(new int[]{5, 4, 2, 3}, new int[]{2, 3, 4, 5}),
                Arguments.of(new int[]{3, 0, 9, 5, 5, 1, 0, 4, 6}, new int[]{0, 0, 1, 3, 4, 5, 5, 6, 9}),
                Arguments.of(new int[]{30, 95, 510, 46}, new int[]{30, 46, 95, 510}),
                Arguments.of(new int[]{-309, 55, -10, 46}, new int[]{-309, -10, 46, 55}),
                Arguments.of(new int[]{3095, -51, 0, -46}, new int[]{-51, -46, 0, 3095})
        );
    }
    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("stringIntAndListProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array) {
        PriorityQueue<Integer> test = new PriorityQueue<Integer>();
//        int index=0;
//        Integer s;
        int[] result=new int[random_array.length];
        // TODO random_array add to PriorityQueue
        for (int i=0; i<random_array.length; i++){
            test.add(random_array[i]);
        }
        // TODO get PriorityQueue result
        int testSize = test.size();
        for (int i=0; i<testSize; i++){
            result[i]=test.poll();
        }
        assertArrayEquals(correct_array, result);
    }
    // TODO 3 unique Exceptions
    @Test
    public void whenExceptionThrown_NullPointer() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> test = new PriorityQueue<Integer>();
            test.add(null);
        });
        String expectedMessage = "java.lang.NullPointerException";
        String actualMessage = exception.toString();
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void whenExceptionThrown_InitialCapacityLessThanOne() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PriorityQueue<Integer> test = new PriorityQueue<Integer>(0);
        });
        String expectedMessage = "java.lang.IllegalArgumentException";
        String actualMessage = exception.toString();
        assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void whenExceptionThrown_InitialPriorityQueueIsNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            PriorityQueue<Integer> n = null;
            PriorityQueue<Integer> test = new PriorityQueue<Integer>(n);
        });
        String expectedMessage = "java.lang.NullPointerException";
        String actualMessage = exception.toString();
        assertEquals(expectedMessage, actualMessage);
    }
}
