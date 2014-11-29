package tr.edu.itu.cs.ben;

import java.util.List;


public interface IExhibitionCollection {
    public List<Exhibition> getExhibitions();

    public void addExhibition(Exhibition bExhibition);

    public void deleteExhibition(Exhibition bExhibition);

    public void updateExhibition(Exhibition bExhibition);
}
