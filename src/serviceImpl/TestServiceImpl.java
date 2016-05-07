package serviceImpl;

import service.TestService;

/**
 * Created by sarleon on 16-5-6.
 */
public class TestServiceImpl implements TestService {
    @Override
    public boolean echo() throws RuntimeException{
        System.out.println("test sucssess");
        return false;
    }
}
