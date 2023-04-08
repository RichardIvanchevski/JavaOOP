package goldDigger.models.spot;

import goldDigger.models.museum.BaseMuseum;

import java.util.Collection;

public class SpotImpl implements Spot{
    private String name;
    private BaseMuseum baseMuseum;

    public SpotImpl(String name) {
        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return baseMuseum.getExhibits();
    }

    @Override
    public String getName() {
        return name;
    }
}
