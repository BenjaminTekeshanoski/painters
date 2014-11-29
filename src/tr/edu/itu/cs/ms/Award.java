package tr.edu.itu.cs.ms;

public class Award {
    private Integer id = null;
    private String name = null;
    private String owner = null;
    private Integer year = null;

    public Award() {
    }

    public Award(String aName) {
        this.setName(aName);
    }

    public Award(String aName, String aOwner, Integer aYear) {
        this.setName(aName);
        this.setOwner(aOwner);
        this.setYear(aYear);

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

    public void setYear(Integer aYear) {
        this.year = aYear;
    }

    public Integer getYear() {
        return this.year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
