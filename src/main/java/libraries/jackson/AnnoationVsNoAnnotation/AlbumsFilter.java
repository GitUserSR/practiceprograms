package libraries.jackson.AnnoationVsNoAnnotation;

// Do not use fields to autodetect. use the public getter methods to autodetect properties
//@JsonAutoDetect(fieldVisibility = Visibility.NONE /*, getterVisibility = Visibility.PUBLIC_ONLY*/ )
public class AlbumsFilter {
 
    private String title;
    //public DatasetFilter[] datasetFilter;
    private Dataset[] dataset;
    public String total_pages;
 
    protected String getTotal_pages() {
        return total_pages;
    }
 
    public String getTitle() {
        return title;
    }
 
    // this getter method is for the 'dataset' property
//    @JsonProperty("dataset")
// 	public DatasetFilter[] getDatasetFilter() { 
    public Dataset[] getDataset() {
        //return datasetFilter;
        return dataset;

    }
    
}
