import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SILab2Test {

    @Test
    public void everyBranch() {
        SILab2 siLab2 = new SILab2();

        List<String> userList = new ArrayList<>();

        //Tests from reverse order
        //Test 1
        User test1 =new User(null, null, null);
        //Test4
        User test2 =new User(null,"1234567","trajche@gmail.com");
        //Test4
        User test3 =new User("Trajche","1234567",null);
        //Test4
        User test4 =new User("Trajche","1234567","trajchegmail.com");
        //Test4
        User test5 =new User("Trajche","1234567","trajche@gmailcom");
        //Test4
        User test6 =new User("Trajche","1234567","trajchegmailcom");
        //Test4
        User test7 =new User("Trajche","1234567","trajche@gmail.com");


        try {
            assertThrows(RuntimeException.class, () -> siLab2.function(test1, userList));
        }catch (RuntimeException ex){
            System.err.println(ex.getMessage().toString());
        }
        try{
            assertThrows(RuntimeException.class, () -> siLab2.function(test2,userList));
        }catch (RuntimeException ex){
            System.err.println(ex.getMessage().toString());
        }
        assertFalse(siLab2.function(test3,userList));
        assertFalse(siLab2.function(test4,userList));
        assertFalse(siLab2.function(test5,userList));
        assertFalse(siLab2.function(test6,userList));
        assertTrue(siLab2.function(test7,userList));


    }

    @Test
    public void MultipleCoverage() {
        SILab2 siLab2 = new SILab2();

        List<String> userList = new ArrayList<>();

        //Test 1 if all are null 2 outcomes
        User test1 =new User(null, null, null);
        try {
            assertThrows(RuntimeException.class, () -> siLab2.function(test1, userList));
        }catch (RuntimeException ex){
            System.err.println(ex.getMessage().toString());
        }


        //Test2 username is null or it exists
            User test2 =new User(null,"1234567","trajche@gmail.com");
            try{
                assertThrows(RuntimeException.class, () -> siLab2.function(test2,userList));
            }catch (RuntimeException ex){
                System.err.println(ex.getMessage().toString());
            }
            User test2P2 =new User("Trajche","1234567","trajche@gmail.com");
            userList.add("Trajche");
            assertFalse(siLab2.function(test2P2,userList));
            userList.remove(1);


        //Test3 null or not 2 outcomes
        User test3 =new User("Trajche","1234567",null);
        assertFalse(siLab2.function(test3,userList));


        //Test4 no @
        User test4 =new User("Trajche","1234567","trajchegmail.com");
        //Test5 no .
        User test5 =new User("Trajche","1234567","trajche@gmailcom");
        //Test6 both
        User test6 =new User("Trajche","1234567","trajchegmailcom");
        assertFalse(siLab2.function(test4,userList));
        assertFalse(siLab2.function(test5,userList));
        assertFalse(siLab2.function(test6,userList));

        //Test7 Everything compiles follow up on 1rst if this is if else runs perfectly
        User test7 =new User("Trajche","1234567","trajche@gmail.com");
        assertTrue(siLab2.function(test7,userList));

    }
}

