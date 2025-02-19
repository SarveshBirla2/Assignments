package com;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AssignmentTest {
   
    @Test
    void testSort() {
        int[] arr = {5, 3, 8, 1, 2};
        int[] expected = {1, 2, 3, 5, 8}; // Expected sorted output

        A a1 =  new Assignment();
        		a1.Sort(arr); // Call sorting method

        assertArrayEquals(expected, arr); // Verify output
    }

}
