
package javax.jws.java2wsdl.javax.jws.java2wsdl.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "myMethodResponse", namespace = "http://java2wsdl.jws.javax/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "myMethodResponse", namespace = "http://java2wsdl.jws.javax/")
public class MyMethodResponse {

    @XmlElement(name = "return", namespace = "")
    private int _return;

    /**
     * 
     * @return
     *     returns int
     */
    public int getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(int _return) {
        this._return = _return;
    }

}
