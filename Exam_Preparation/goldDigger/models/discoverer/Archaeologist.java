package goldDigger.models.discoverer;



public class Archaeologist extends BaseDiscoverer{




    public Archaeologist(String name) {
        super(name,60);
    }



    @Override
    public void dig() {
        double currentEnergy = getEnergy() - 15;

        if (currentEnergy < 0){
            setEnergy(0);
        }

    }
}
