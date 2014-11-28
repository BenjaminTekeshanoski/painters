package tr.edu.tr.cs.sh;

import tr.edu.itu.cs.db.BasePage;
//import tr.edu.itu.cs.hca.Museum;
//import tr.edu.itu.cs.hca.MuseumEditForm;


public class YourPaintingEditPage extends BasePage {

    public YourPaintingEditPage(YourPainting aYourPainting) {
        this.add(new YourPaintingEditForm("yourPainting_edit", aYourPainting,
                true));
    }

    public YourPaintingEditPage(YourPainting aYourPainting,
            boolean newYourPaintingFlag) {
        this.add(new YourPaintingEditForm("yourPainting_edit", aYourPainting,
                newYourPaintingFlag));
    }
}
