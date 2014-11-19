package tr.edu.itu.cs.ms;

public class Comment {
    private String comment = null;
    private String owner = null;
    private String target = null;

    public Comment(String aComment, String aOwner, String aTarget) {
        this.setCom(aComment);
        this.setOwner(aOwner);
        this.setTarget(aTarget);
    }

    public void setCom(String aComment) {
        this.comment = aComment;
    }

    public String getCom() {
        return this.comment;
    }

    public void setOwner(String aOwner) {
        this.owner = aOwner;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setTarget(String aTarget) {
        this.target = aTarget;
    }

    public String getTarget() {
        return this.target;
    }

}
