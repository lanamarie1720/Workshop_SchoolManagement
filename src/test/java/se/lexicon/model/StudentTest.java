package se.lexicon.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    void testCreatingStudent() {
        // result 1
        int id = 0;
        String name = "Test";
        String email = "<EMAIL>";
        String address = "Test street 1";
        // result 2
        int id2 = 0;
        String name2 = "Test2";
        String email2 = "<EMAIL>";
        String address2 = "Test street 2";
        // Test 1
        Student student1 = new Student(name, email, address);
        Student student2 = new Student(name2, email2, address2);
        Assertions.assertEquals(id, student1.getId());
        Assertions.assertEquals(name, student1.getName());
        Assertions.assertEquals(email, student1.getEmail());
        Assertions.assertEquals(address, student1.getAddress());
        // Test 2
        Assertions.assertEquals(id2, student2.getId());
        Assertions.assertEquals(name2, student2.getName());
        Assertions.assertEquals(email2, student2.getEmail());
        Assertions.assertEquals(address2, student2.getAddress());
    }
}
