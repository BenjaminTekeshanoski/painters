package tr.edu.tr.cs.sh;

public class Painting {

    private Integer id = null;
    private String name = null;
    private Integer year = null;

    private String location = null;
    private String desc = null;

    // private String location = null;

    public Painting() {

    }

    public Painting(String aName) {
        this.setName(aName);
    }

    public Painting(String name, Integer year, String location, String desc) {

        this.setName(name);
        this.setLocation(location);
        this.setDesc(desc);
        this.setYear(year);

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

}
