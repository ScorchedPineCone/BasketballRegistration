package Shoes;


public class ShoeSizeConverter {

    private double length;

    public void updateShoeSize(String code, int size) {
        switch (code) {
            case "USWOMEN":
                length = convertUSToMillimeters(size, true);
                break;
            case "USMEN":
                length = convertUSToMillimeters(size, false);
                break;
            case "UK":
                length = convertUKToMillimeters(size);
                break;
            case "EU":
                length = convertEUToMillimeters(size);
                break;
            default:
                throw new IllegalArgumentException("Invalid country code");
        }
    }

    public double getLength() {
        return length;
    }

    public double convertLengthToEU() {
        return Math.round((length / 6.667) + 2);
    }

    public double convertLengthToUK() {
        return Math.round(((length * 3) / 25.4) - 23);
    }

    public double convertLengthToUSMen() {
        return Math.round(((length * 3) / 25.4) - 22);
    }

    public double convertLengthToUSWomen() {
        return Math.round(((length * 3) / 25.4) - 21);
    }

    // Reversing the conversion formulas
    private double convertEUToMillimeters(double size) {
        return Math.round((size - 2) * 6.667);
    }

    private double convertUKToMillimeters(double size) {
        return Math.round(((size + 23) * 25.4) / 3);
    }

    private double convertUSToMillimeters(double size, boolean isWoman) {
        if (isWoman) {
            return Math.round(((size + 21) * 25.4) / 3);
        } else {
            return Math.round(((size + 22) * 25.4) / 3);
        }
    }


}


