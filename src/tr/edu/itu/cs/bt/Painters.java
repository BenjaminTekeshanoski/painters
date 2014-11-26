package tr.edu.itu.cs.bt;

public class Painters {
    private Integer id = null;
    private String name = null;
    private String country = null;
    private Integer year = null;

    public Painters() {

    }

    public Painters(String aName) {
        this.setName(aName);
    }

    public Painters(String bName, String bCountry, Integer bYear) {
        this.setName(bName);
        this.setCountry(bCountry);
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

}
