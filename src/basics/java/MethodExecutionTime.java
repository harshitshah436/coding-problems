package basics.java;

import java.time.Duration;
import java.time.Instant;

/**
 *
 * @author Harshit
 */
public class MethodExecutionTime {
    public static void main(String[] args) throws InterruptedException {
        
        long startTime = System.nanoTime();
        StringBuilderUsage.getUniqueStringUsingStringBuilder("harshitshah");
        long endTime = System.nanoTime();
        System.out.println("Total execution time in nano seconds: " + (endTime - startTime));
        
        // In java8 using Instant and Duration.
        Instant start = Instant.now();
        Thread.sleep(525);
        Instant end = Instant.now();
        System.out.println("Total execution time in nano seconds: " + Duration.between(start, end).toNanos());
    }
}
