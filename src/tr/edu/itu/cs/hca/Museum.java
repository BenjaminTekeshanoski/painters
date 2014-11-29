package tr.edu.itu.cs.hca;

import java.util.LinkedList;
import java.util.List;

import tr.edu.tr.cs.sh.Painting;


public class Museum {
    private Integer id = null;
    private String name = null;
    private String desc = null;
    private String location = null;
    private Integer year = null;
    private List<Painting> paintings = null;

    public Museum() {
        this.paintings = new LinkedList<Painting>();
    }

    public Museum(String aName) {
        this.setName(aName);
        this.paintings = new LinkedList<Painting>();
    }

    public Museum(String aName, String aDesc, String aLocation, Integer aYear) {
        this.setName(aName);
        this.setDesc(aDesc);
        this.setLocation(aLocation);
        this.setYear(aYear);
        this.paintings = new LinkedList<Painting>();

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

    public void setLocation(String aLocation) {
        this.location = aLocation;
    }

    public String getLocation() {
        return this.location;
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

    public void setPaintins(List<Painting> somePaintings) {
        this.paintings = somePaintings;
    }

    public List<Painting> getPaintings() {
        return this.paintings;
    }

    public void addPainting(Painting aPainting) {
        this.paintings.add(aPainting);
    }
}
