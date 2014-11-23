package tr.edu.itu.cs.hca;

public class Update {
    private String desc = null;

    public Update() {
    }

    public Update(String aDesc) {
        this.setDesc(aDesc);
    }

    public void setDesc(String aDesc) {
        this.desc = aDesc;
    }

    public String getDesc() {
        return this.desc;
    }
}
