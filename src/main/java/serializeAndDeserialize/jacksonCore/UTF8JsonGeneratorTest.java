package serializeAndDeserialize.jacksonCore;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Person;
import model.Student;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by srapolu on 6/13/17.
 */
public class UTF8JsonGeneratorTest {
    public static void main(String[] args) throws IOException {

        //Map<String, String> object = new HashMap<>();
        //object.put("text", "ف ف ف ف");
        //Object object = new String("ف ف ف ف");
        Person object = new Person();
        object.setName("Swathi");

        //2.Convert object to JSON
        OutputStream outputStream = new ByteArrayOutputStream();
        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator generator = jsonFactory.createGenerator(outputStream, JsonEncoding.UTF8);
        jsonFactory.setCodec(new ObjectMapper());
        //generator.writeStartObject();
        //generator.writeObject(object);
        generator.writeString("ف ف ف ف");
        //generator.writeEndObject();

        generator.flush();
        generator.close();

        System.out.println(outputStream);
        //outputStream.write(strInArabic.toString().getBytes());

    }
}
/*

    JsonFactory jsonFactory = new JsonFactory();
    FileOutputStream file = new FileOutputStream(new File("D:/cp/infoOne.json"));
    JsonGenerator jsonGen = jsonFactory.createJsonGenerator(file, JsonEncoding.UTF8);
    Address address = new Address("Dhananjaypur", "Varanasi", "UP");
    Person person = new Person(1, "Arvind", address);
		jsonGen.setCodec(new ObjectMapper());
                jsonGen.writeObject(person);
                System.out.println("Done");
*/