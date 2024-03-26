package Shoes;

public class ShoesSize {

    public static void main(String[] args) {

        ShoeSizeConverter converter = new ShoeSizeConverter();

        converter.updateShoeSize("UK", 8);
        System.out.println(converter.getLength());
        System.out.println(converter.convertLengthToEU());
        System.out.println(converter.convertLengthToUK());
        System.out.println(converter.convertLengthToUSWomen());
        System.out.println(converter.convertLengthToUSMen());



    }
}

