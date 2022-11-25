package se1.dibsefilesystem;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class FileFactoryTest {

    private static FileFactory fileFactory;

    @BeforeAll
    static void setUpAll() {
        fileFactory = new FileFactory();
    }

    @BeforeEach
    void setUp() {
    }



    @Test
    @DisplayName("Teste Erzeugung einer Textdatei")
    void testCreateFile3() {
        AFile file = fileFactory.createFile("text", "test.txt");
        Assertions.assertEquals(file.getClass(), TextFile.class);
    }

    @Test
    @DisplayName("Teste Erzeugung einer Bilddatei")
    void testCreateFile5() {
        AFile file = fileFactory.createFile("image", "test.jpg");
        Assertions.assertEquals(file.getClass(), ImageFile.class);
    }

    @Test
    void testCreateFile4() {
        FileFactory fileFactory = new FileFactory();
        assertThrows(IllegalArgumentException.class, () -> fileFactory.createFile("image2", "test"));
    }

    @Test
    @DisplayName("Testen ob eine IllegalArgumentException geworfen wird")
    public void throwsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> fileFactory.createFile("image2", "test"));
    }

    @Test
    void nameLength() {
        FileFactory fileFactory = new FileFactory();
        AFile file = fileFactory.createFile("text", "test");
        assertTrue(file.getName().length() > 0);
    }

    @Test
    void emptyParameter() {
        FileFactory fileFactory = new FileFactory();
        assertThrows(IllegalArgumentException.class, () -> fileFactory.createFile("", ""));
    }


    @AfterEach
    void tearDown() {

    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Tests finished");
    }
}  // end of FileFactoryTest.java

