package util.Locale;

import java.util.Locale;

public class ManualIndonesianLocaleTest {

    public static void main(String[] args) {
        Locale iso639Indonesian = new Locale("id");
        testForSpecificationCompliance(iso639Indonesian);
        System.out.println();
        Locale someOtherIndonesian = new Locale("in");
        testForSpecificationCompliance(someOtherIndonesian);
    }
    
    private static void testForSpecificationCompliance(Locale indonesian) {
        System.out.println("Locale " + indonesian + " stands for Indonesian: " + isLocaleDenotedAsIndonesian(indonesian));
        System.out.println("Language representation (" + indonesian.getLanguage() + ") complies with ISO 639: " + isISO639Representation(indonesian.getLanguage()));
        System.out.println("Locale representation (" + indonesian.toString() + ") complies with ISO 639: " + isISO639Representation(indonesian.toString()));
    }
    
    private static boolean isISO639Representation(String languageRepresentation) {
        return ("id".equals(languageRepresentation));
    }
    
    private static boolean isLocaleDenotedAsIndonesian(Locale locale) {
        return ("Indonesian".equals(locale.getDisplayLanguage(Locale.ENGLISH)));
    }
}
