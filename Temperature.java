/**
 * A Temperature object represents temperature (with a value and scale)
 * Assignment 2
 */

public class Temperature{
    private double temp;
    private char scale;


    public double celsiusToFahrenheit(double temp){
        return ((temp*9)/5)+32;
    }
    public double celsiusToKelvin(double temp){
        return temp+273.15;
    }
    public double fahrenheitToCelsius(double temp){
        return((temp-32)*5)/9;
    }
    public double fahrenheitToKelvin(double temp){
        return((temp+459.67)*5)/9;
    }
    public double kelvinToCelsius(double temp){
        return temp-273.15;
    }
    public double kelvinToFahrenheit(double temp){
        return ((temp*9)/5)-459.67;
    }

    /** Initializes a temperature object with given value in Celcius
     *
     *  If the initial temperature is less than -273.15C then the temperature
     *  object will be initialized with -273.15C.
     *
     * @param temp is the initial temperature in Celsius.
     */
    public Temperature(double temp) {
        this.temp = temp;
        this.scale = 'C';
        if(temp<-273.15) {
            this.temp = -273.15;
        }
    }

    /** Initializes a temperature object with given value using the specified scale
     * <par>
     * If the temperature is lower than absolute zero, in the given scale,
     * then set the temperature to absolute zero (in that scale).
     * <par>
     * Example: new Temperature(12.3, Scale.KELVIN)
     *
     * @param temp is the initial temperature
     * @param scale is the scale of initial temperature and must a constant
     *        defined in the Scale enum type.
     */

    public Temperature(double temp, Scale scale){
        this.temp=temp;
        this.scale= Scale.scales(scale);
        if(this.scale=='C'&&this.temp<-273.15){
            this.temp=-273.15;
        }else if(this.scale=='F'&&this.temp<-459.67){
            this.temp=-459.67;
        }else if(this.scale=='K'&&this.temp<0){
            this.temp=0;
        }
    }


    /** Initializes a temperature object with given value using the specified scale
     * <par>
     * If the temperature is lower than absolute zero, in the given scale,
     * then set the temperature to absolute zero (in that scale).
     * <par>
     * Example: each of the following will create the same temerature 12.3K
     *          new Temperature(12.3, "Kelvin")
     *          new Temperature(12.3, "k")
     *          new Temperature(12.3, "kel"
     *
     * @param temp is the initial temperature
     * @param scale is a the scale of initial temperature. As long as the input string
     *        can uniquely identify one of the three scales it is acceptable.
     *        Case is not important. Abbreviations are allowed.
     */
    public Temperature(double temp, String scale){
        this.temp=temp;
        String s=scale.toUpperCase();
        if(s.charAt(0)=='C'){
            this.scale='C';
        }else if(s.charAt(0)=='K'){
            this.scale='K';
        }else if(s.charAt(0)=='F'){
            this.scale='F';
        }
    }




    /** getter for the scale. The output will always be one of the enum objects from Scale.
     *
     * @return the current scale of this object.
     */
    public Scale getScale(){
        if(scale=='C') {
            return Scale.CELSIUS;
        }else if(scale=='K'){
            return Scale.KELVIN;
        }else if(scale=='F'){
            return Scale.FAHRENHEIT;
        }
        return Scale.CELSIUS;
    }

    /** getter for the temperature
     *
     * @return the temperature of the object using the current scale
     */
    public double getTemp(){
        return temp;
    }


    /** setter for scale
     *
     * @param scale is the new scale of the temperature and must be
     *        a constant from the Scale enum type.
     */
    public void setScale(Scale scale){
        if(scale==Scale.CELSIUS&&this.scale=='F' ){
            this.temp=fahrenheitToCelsius(temp);
            this.scale='C';
        }else if(scale==Scale.CELSIUS&&this.scale=='K'){
            this.temp=kelvinToCelsius(temp);
            this.scale='C';
        }else if(scale==Scale.CELSIUS){
            this.temp='C';
        }else if(scale==Scale.FAHRENHEIT&&this.scale=='C'){
            this.temp=celsiusToFahrenheit(temp);
            this.scale='F';
        }else if(scale==Scale.FAHRENHEIT&&this.scale=='K'){
            this.temp=kelvinToFahrenheit(temp);
            this.scale='F';
        }else if(scale==Scale.FAHRENHEIT){
            this.scale='F';
        }else if(scale==Scale.KELVIN&&this.scale=='C'){
            this.temp=celsiusToKelvin(temp);
            this.scale='K';
        }else if(scale==Scale.KELVIN&&this.scale=='F'){
            this.temp=fahrenheitToKelvin(temp);
            this.scale='K';
        }else if(scale==Scale.KELVIN){
            this.scale='K';
        }
    }



    /** setter for temperature
     *  <par>
     * If the temperature is lower than absolute zero, in the given scale,
     * then sets the temperature to absolute zero (in that scale).
     *
     * @param temp is the new temperature
     * @param scale is the scale of the new temperature. It must be
     *        a constant from the Scale enum type.
     */
    public void setTemp(double temp, Scale scale){
        if(scale==Scale.CELSIUS&&this.temp<-273.15){
            this.temp=-273.15;
        }else if(scale==Scale.CELSIUS){
            this.temp=temp;
        }else if(scale==Scale.FAHRENHEIT&&this.temp<-459.67){
            this.temp=-459.67;
        }else if(scale==Scale.FAHRENHEIT){
            this.temp=temp;
        }else if(scale==Scale.KELVIN&&this.temp<0){
            this.temp=0;
        }else if(scale==scale.KELVIN){
            this.temp=temp;
        }
    }










    /* ------------------------------------------------- */
    /* ------------------------------------------------- */
    /* do not change anything below this                 */
    /* ------------------------------------------------- */
    /* ------------------------------------------------- */



    /** String representation of a temperature object    */
    @Override
    public String toString(){
        return "" + this.getTemp() + this.getScale().name().charAt(0);
    }

}