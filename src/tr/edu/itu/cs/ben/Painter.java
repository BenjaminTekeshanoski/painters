package tr.edu.itu.cs.ben;

public class Painter {

    private Integer id = null;
    private String name = null;
    private String desc = null;
    private String location = null;
    private Integer year = null;

    public Painter() {
    }

    public Painter(String bName) {
        this.setName(bName);
    }

    public Painter(String bName, String bDesc, String bLocation, Integer bYear) {
        this.setName(bName);
        this.setDesc(bDesc);
        this.setLocation(bLocation);
        this.setYear(bYear);
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
