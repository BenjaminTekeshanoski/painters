package tr.edu.tr.cs.sh;

import java.util.List;


//import tr.edu.itu.cs.hca.Museum;

public interface IYourPaintingCollection {

    public List<YourPainting> getYourPaintings();

    public void addYourPainting(YourPainting aYourPainting);

    public void deleteYourPainting(YourPainting aYourPainting);

    public void updateYourPainting(YourPainting aYourPainting);

}
