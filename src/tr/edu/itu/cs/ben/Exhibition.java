package tr.edu.itu.cs.ben;

public class Exhibition {
    private Integer id = null;
    private String name = null;
    private String location = null;
    private Integer year = null;

    public Exhibition() {
    }

    public Exhibition(String bName) {
        this.setName(bName);
    }

    public Exhibition(String bName, String bLocation, Integer bYear) {
        this.setName(bName);
        this.setLocation(bLocation);
        this.setYear(bYear);

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

    public void setLocation(String aLocation) {
        this.location = aLocation;
    }

    public String getLocation() {
        return this.location;
    }

    public void setYear(Integer aYear) {
        this.year = aYear;
    }

    public Integer getYear() {
        return this.year;
    }

}
