package serviceImpl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import service.ExecuteService;

/**
 * Created by sarleon on 16-7-1.
 */
public class ExecuteServiceImplTest extends TestCase {
    public void testExecute() throws Exception {

    }
    private ExecuteService executor;

    @Before
    public void setUp() throws Exception {
        executor = new ExecuteServiceImpl();
    }

    @Test
    public void test_single_char_echo() throws Exception{
        String code = ",.";
        assertEquals("A", executor.execute(code, "A"));
    }

    @Test
    public void test_add_to_char() throws Exception{
        String code = ",+++++.";
        assertEquals("F", executor.execute(code, "A"));
    }

    @Test
    public void test_add() throws Exception{
        String code = ",>++++++[<-------->-],,[<+>-]<.";
        assertEquals("7", executor.execute(code, "4+3"));
    }

    @Test
    public void test_hi_nju() throws Exception{
        String code = "++++++++[>+++++++++[>+>+>+>+>+>+<<<<<<-]<-]++++++[>++++++[>>+>-<<<-]<-]>>>--->---->++++++>++>+++++++++++++<<<<<.>.>.>.>.>.";
        assertEquals("Hi NJU", executor.execute(code, ""));
    }

    @Test
    public void test_multiplication() throws Exception{
        String code = ",>,,>++++++++[<------<------>>-]<<[>[>+>+<<-]>>[<<+>>-]<<<-]>>>++++++[<++++++++>-]<.";
        assertEquals("8", executor.execute(code, "2*4"));
    }

}