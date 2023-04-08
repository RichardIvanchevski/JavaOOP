package goldDigger.models.discoverer;



public class Geologist extends BaseDiscoverer{
    public Geologist(String name) {
        super(name, 100);
    }



    @Override
    public void dig() {

        double currentEnergy = getEnergy() - 15;

        if (currentEnergy < 0){
            setEnergy(0);
        }

    }
}
