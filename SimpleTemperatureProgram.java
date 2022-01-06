public class SimpleTemperatureProgram{

    // Code from Assignment Specification
    public static void main(String[] args){

        Scale s = Scale.CELSIUS;       // a variable of an enum type
        Temperature t1 = new Temperature(33.1, s);
        Temperature t2 = new Temperature(87.2, Scale.FAHRENHEIT);
        boolean b = Scale.CELSIUS == s;   // will be true! can compare with ==

        System.out.println("Make a Temperature object");
        System.out.println("> Temperature t = new Temperature(10.1)");
        Temperature t = new Temperature(10.1);
        System.out.println(">> t.getScale() -> " + t.getScale());    // outputs Scale.CELSIUS.toString()
        System.out.println(">> t.toString() -> " + t);               // outputs 10.1C
        System.out.println("> t.setScale(Scale.FAHRENHEIT)");

        t.setScale(Scale.FAHRENHEIT);                                // change scale
        System.out.println(">> t.toString() -> " + t);               // outputs 50.18F
        System.out.println(">> t.getScale() -> " + t.getScale());    // outputs Scale.FAHREHEIT.toString()

        System.out.println("> t = new Temperature(12.25, \"Kel\")");
        t = new Temperature(12.25, "Kel");              // must recognize short form
        System.out.println(">> t.toString() -> " + t);  // outputs 12.25K

    }

}