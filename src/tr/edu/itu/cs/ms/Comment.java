package tr.edu.itu.cs.ms;

public class Comment {
    private Integer id = null;
    private String name = null;
    private Integer owner = null;
    private String target = null;

    public Comment() {
    }

    public Comment(String aName) {
        this.setName(aName);
    }

    public Comment(String aName, Integer aOwner, String aTarget) {
        this.setName(aName);
        this.setOwner(aOwner);
        this.setTarget(aTarget);

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

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
