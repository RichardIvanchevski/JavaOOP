package borderControl;

public class Robot implements Identifiable{
    private String id;
    private String model;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }


    @Override
    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
