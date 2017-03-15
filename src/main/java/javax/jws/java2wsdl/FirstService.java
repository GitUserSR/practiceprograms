package javax.jws.java2wsdl;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by srapolu on 3/13/17.
 */
@WebService
public class FirstService {
    @WebMethod
    public int myMethod(int x, float y){
        return (int) (x+y);
    }
}
