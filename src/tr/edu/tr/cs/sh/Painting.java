package tr.edu.tr.cs.sh;

public class Painting-degis {

    private Integer id = null;
    private String name = null;
    private Integer year = null;
    private String painter = null;

    private String desc = null;
    private String place = null;
    private String idiom = null;

    // private String location = null;

    public Painting() {

    }

    public Painting(String aName) {
        this.setName(aName);
    }

    public Painting(String name, Integer year, String painter, String desc,
            String place, String idiom) {

        this.setName(name);
        this.setYear(year);
        this.setPainter(painter);
        this.setDesc(desc);
        this.setPlace(place);
        this.setIdiom(idiom);

    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getIdiom() {
        return idiom;
    }

    public void setIdiom(String idiom) {
        this.idiom = idiom;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPainter() {
        return painter;
    }

    public void setPainter(String painter) {
        this.painter = painter;
    }

}
