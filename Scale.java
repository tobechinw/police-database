/** Gives names to the three temperature 
 scales we will consider in this assignment.
 */

public enum Scale{
    CELSIUS, FAHRENHEIT, KELVIN, NONE;
    public static char scales(Scale scale){
        char a='C';
        char b='F';
        char c='K';
        switch(scale){
            case CELSIUS:
                return a;
            case FAHRENHEIT:
                return b;
            case KELVIN:
                return c;
        }
        return a;
    }
}