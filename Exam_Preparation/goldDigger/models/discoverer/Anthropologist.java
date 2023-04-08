package goldDigger.models.discoverer;

import goldDigger.models.museum.Museum;

public class Anthropologist extends BaseDiscoverer{
    public Anthropologist(String name) {
        super(name, 40);
    }



    @Override
    public void dig() {
        double currentEnergy = getEnergy() - 15.00;

        if (currentEnergy < 0){
            setEnergy(0);
        }

    }
}
