package ru.vsu.cs.shepliakovvladislavvyacheslavovich;

import ru.vsu.cs.util.SwingUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    public static void main(String[] args) throws Exception {
        //SwingUtils.setLookAndFeelByName("Windows");
        Locale.setDefault(Locale.ROOT);
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtils.setDefaultFont("Microsoft Sans Serif", 18);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formMain().setVisible(true);
            }
        });
    }

}
class PolishTester {

    @BeforeEach
    public void setup() {

    }

    @Test
    void getAnswerValueMyStack1() throws MyStack.MyStackException, SimpleLinkedListDouble.SimpleLinkedListException {
        assertEquals(180d, MyStack.getAnswerValue("2.5 5.5 + 3.6 6.4 + + 10 *", "My"));
    }
    @Test
    void getAnswerValueMyStack2() throws MyStack.MyStackException, SimpleLinkedListDouble.SimpleLinkedListException {
        assertEquals(0.1, MyStack.getAnswerValue("2 5 / 0.6 + 0.1 / 100 /", "My"));
    }
    @Test
    void getAnswerValueMyStack3() throws MyStack.MyStackException, SimpleLinkedListDouble.SimpleLinkedListException {
        assertEquals(4, MyStack.getAnswerValue("10 100 - 45 / 0 2 - *", "My"));
    }
    @Test
    void getAnswerValueMyStack4() throws MyStack.MyStackException, SimpleLinkedListDouble.SimpleLinkedListException {
        assertEquals(1, MyStack.getAnswerValue("34 45 + 1 + 60 / 1 3 / -", "My"));
    }


    @Test
    void getAnswerValueJavaStack1() throws MyStack.MyStackException, SimpleLinkedListDouble.SimpleLinkedListException {
        assertEquals(180d, MyStack.getAnswerValue("2.5 5.5 + 3.6 6.4 + + 10 *", "NotMy"));
    }
    @Test
    void getAnswerValueJavaStack2() throws MyStack.MyStackException, SimpleLinkedListDouble.SimpleLinkedListException {
        assertEquals(0.1, MyStack.getAnswerValue("2 5 / 0.6 + 0.1 / 100 /", "NotMy"));
    }
    @Test
    void getAnswerValueJavaStack3() throws MyStack.MyStackException, SimpleLinkedListDouble.SimpleLinkedListException {
        assertEquals(4, MyStack.getAnswerValue("10 100 - 45 / 0 2 - *", "NotMy"));
    }
    @Test
    void getAnswerValueJavaStack4() throws MyStack.MyStackException, SimpleLinkedListDouble.SimpleLinkedListException {
        assertEquals(1, MyStack.getAnswerValue("34 45 + 1 + 60 / 1 3 / -", "NotMy"));
    }


}