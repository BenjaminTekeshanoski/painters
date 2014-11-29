package tr.edu.itu.cs.hca;

public class Location {
    private Integer id = null;
    private String name = null;
    private String desc = null;
    private String city = null;

    public Location() {
    }

    public Location(String aName) {
        this.setName(aName);
    }

    public Location(String aName, String aDesc, String aCity) {
        this.setName(aName);
        this.setDesc(aDesc);
        this.setCity(aCity);
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
}
