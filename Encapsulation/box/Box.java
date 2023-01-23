package box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public void setLength(double length) {
        checkSize(length, "Length");
        this.length = length;
    }

    public void setWidth(double width) {
        checkSize(width, "Width");
        this.width = width;
    }

    public void setHeight(double height) {
        checkSize(height, "Height");
        this.height = height;
    }

    //Volume = lwh
    //Lateral Surface Area = 2lh + 2wh
    //Surface Area = 2lw + 2lh + 2wh

    public double calculateVolume (){
        return length * width * height;
    }
    public double calculateSurfaceArea(){
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }
    public double calculateLateralSurfaceArea(){
        return 2 * length * height + 2 * width * height;
    }

    private void checkSize (double value, String prefix){
        if (value <= 0){
            throw new IllegalArgumentException(prefix + " cannot be zero or negative.");
        }
    }
}
