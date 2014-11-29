package tr.edu.itu.cs.hca;



public class Location {
    private Integer id = null;
    private String name = null;
    private String desc = null;
    private String city = null;

    // private List<Painting> paintings = null;

    public Location() {
        // this.paintings = new LinkedList<Painting>();
    }

    public Location(String aName) {
        this.setName(aName);
        // this.paintings = new LinkedList<Painting>();
    }

    public Location(String aName, String aDesc, String aCity) {
        this.setName(aName);
        this.setDesc(aDesc);
        this.setCity(aCity);
        // this.paintings = new LinkedList<Painting>();
    }

    public void setId(Integer aId) {
        this.id = aId;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String aName) {
        this.name = aName;
    }

    public String getName() {
        return this.name;
    }

    public void setCity(String aCity) {
        this.city = aCity;
    }

    public String getCity() {
        return this.city;
    }

    public void setDesc(String aDesc) {
        this.desc = aDesc;
    }

    public String getDesc() {
        return this.desc;
    }

    /*
     * public void setPaintins(List<Painting> somePaintings) { this.paintings =
     * somePaintings; }
     * 
     * public List<Painting> getPaintings() { return this.paintings; }
     * 
     * public void addPainting(Painting aPainting) {
     * this.paintings.add(aPainting); }
     */
}
