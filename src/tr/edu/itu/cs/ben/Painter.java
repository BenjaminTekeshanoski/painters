package tr.edu.itu.cs.ben;

public class Painter {

    private Integer id = null;
    private String name = null;
    private String biography = null;
    private String country = null;
    private Integer age = null;
    private String comment = null;
    private String award = null;
    private String idiom = null;

    public Painter() {
    }

    public Painter(String bName) {
        this.setName(bName);
    }

    public Painter(String bName, String bBiography, String bCountry,
            Integer bAge, String bComment, String bAward, String bIdiom) {
        this.setName(bName);
        this.setBiography(bBiography);
        this.setCountry(bCountry);
        this.setAge(bAge);
        this.setComment(bComment);
        this.setAward(bAward);
        this.setIdiom(bIdiom);
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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getIdiom() {
        return idiom;
    }

    public void setIdiom(String idiom) {
        this.idiom = idiom;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

}
