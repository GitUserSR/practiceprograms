package javax.jws.whichStyleOfWSDLShouldIUse.document.literal;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by srapolu on 3/13/17.
 */

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public class DocumentLiteral {
    @WebMethod
    public int myMethod(int x, float y){
        return (int) (x+y);
    }
}
