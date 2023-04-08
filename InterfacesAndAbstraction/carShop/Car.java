package carShop;

import java.io.Serializable;

public interface Car extends Serializable {
    int TIRES = 4;
    int getTires();
    String getModel();

    String getColor();

    int getHorsePower();

    String countryProduced();
}
