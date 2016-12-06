package libraries.jackson.AnnoationVsNoAnnotation;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/*
Jackson provides an effective an efficient way to bind json to POJOs. However, at times, certain properties may need to be ignored while converting a json to java ojbect and a java object to json string. Jackson provides three ways to filter properties.
@JsonIgnoreProperties- This annotation can be used at the type level to ignore json properties. In the example below we ignore the 'tags' property from the albums dataset.
@JsonIgnore - This annotation can be set at property level to ignore certain properties.
Using Custom filters
The example below shows method 1 and 2. Also note the use of the @JsonAutoDetepct annotation.
Data Binding Filters Example
Example from http://www.studytrails.com/java/json/java-jackson-data-binding-filters.jsp
 */
public class DataBindingFilter {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, MalformedURLException, IOException {
        String url = "http://freemusicarchive.org/api/get/albums.json?api_key=60BLHNQCAOUFPIBZ&limit=2";
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(MapperFeature.USE_ANNOTATIONS);

        AlbumsFilter albums = mapper.readValue(new URL(url), AlbumsFilter.class);
        System.out.println(albums.getTotal_pages());
        System.out.println(albums.getTitle());
//        for (DatasetFilter dataset : albums.getDatasetFilter()) {
        for (Dataset dataset : albums.getDataset()) {
            System.out.println(dataset.getAlbum_id());
            System.out.println(dataset.getAlbum_comments());
            System.out.println(dataset.get("album_images"));
            System.out.println(dataset.get("tags"));
            System.out.println(dataset.get("album_listens"));
            break;
        }
    }
 
}