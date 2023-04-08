package militaryEliteV2.Classes;

public class SpyImpl extends Soldier {

    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName,String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public String toString() {
        return super.toString()  + System.lineSeparator() +
                String.format("Code Number: %s", codeNumber);
    }
}
