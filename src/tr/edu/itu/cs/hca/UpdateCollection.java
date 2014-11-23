package tr.edu.itu.cs.hca;

import java.util.LinkedList;
import java.util.List;


public class UpdateCollection {
    private List<Update> updates;

    public UpdateCollection() {
        this.updates = new LinkedList<Update>();
    }

    public List<Update> getUpdates() {
        return this.updates;
    }

    public void addMuseum(Update aUpdate) {
        this.updates.add(aUpdate);
    }
}
