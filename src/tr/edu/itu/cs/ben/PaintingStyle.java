package tr.edu.itu.cs.ben;

public class PaintingStyle {
    private Integer id = null;
    private String paintname = null;
    private String desc = null;
    private String stylename = null;
    private Integer year = null;

    public PaintingStyle() {
    }

    public PaintingStyle(String aName) {
        this.setPaintname(aName);
    }

    public PaintingStyle(String aName, String aDesc, String aLocation,
            Integer aYear) {
        this.setPaintname(aName);
        this.setDesc(aDesc);
        this.setStylename(aLocation);
        this.setYear(aYear);

    }

    public void setId(Integer aId) {
        this.id = aId;
    }

    public int getId() {
        return this.id;
    }

    public void setYear(Integer aYear) {
        this.year = aYear;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setDesc(String aDesc) {
        this.desc = aDesc;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getPaintname() {
        return paintname;
    }

    public void setPaintname(String paintname) {
        this.paintname = paintname;
    }

    public String getStylename() {
        return stylename;
    }

    public void setStylename(String stylename) {
        this.stylename = stylename;
    }
}
