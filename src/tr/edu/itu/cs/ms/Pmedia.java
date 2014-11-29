package tr.edu.itu.cs.ms;

public class Pmedia {
    private Integer id = null;
    private String name = null;
    private String desc = null;

    public Pmedia() {
    }

    public Pmedia(String aName) {
        this.setName(aName);
    }

    public Pmedia(String aName, String aDesc) {
        this.setName(aName);
        this.setDesc(aDesc);

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

    public void setDesc(String aDesc) {
        this.desc = aDesc;
    }

    public String getDesc() {
        return this.desc;
    }
}
