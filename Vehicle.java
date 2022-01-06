public class Vehicle {
    private String make;
    private String model;
    private int year;
    private String color;
    public String plate;
    public Driver owner;
    public boolean reportedStolen;

    public Vehicle(String make, String model, int year, String color, String plate){
        this.make=make;
        this.model=model;
        this.year=year;
        this.color=color;
        this.plate=plate;
    }
    public Vehicle(){
        this.make="";
        this.model="";
        this.year=0;
        this.color="";
        this.plate="";
    }

    //getters
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
    public String getColor() {
        return color;
    }
    public String getPlate() {
        return plate;
    }

    //setters
    public void setMake(String make) {
        this.make = make;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setPlate(String plate) {
        this.plate = plate;
    }


    //toString
    public String toString(){
        String colorChecker=color.toLowerCase();
        String article="";
        char article2;
        if(color.charAt(0)=='a'||color.charAt(0)=='e'||color.charAt(0)=='i'||color.charAt(0)=='o'||color.charAt(0)=='u'){
            article="An";
            return article+" "+getColor()+" "+getYear()+" "+getMake()+" "+getModel()+" with plate "+getPlate()+".";
        }else{
            article2='A';
            return article2+" "+getColor()+" "+getYear()+" "+getMake()+" "+getModel()+" with plate "+getPlate()+".";
        }
    }
}
