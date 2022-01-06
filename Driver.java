public class Driver {
    private String license;
    private String name;
    private String street;
    private String city;
    private String province;

    public Driver(String license, String name, String street, String city, String province){
        this.license=license;
        this.name=name;
        this.street=street;
        this.city=city;
        this.province=province;
    }

    public Driver(){
        this.license="";
        this.name="";
        this.street="";
        this.city="";
        this.province="";
    }

    //getters
    public String getLicense(){
        return license;
    }
    public String getName(){
        return name;
    }
    public String getStreet(){
        return street;
    }
    public String getCity(){
        return city;
    }
    public String getProvince(){
        return province;
    }

    //setters
    public void setLicense(String license) {
        this.license = license;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setProvince(String province) {
        this.province = province;
    }

    //toString
    @Override
    public String toString(){
        return getLicense() + " " + getName() + " living at " + getStreet() + ", "+ getCity()+", " + getProvince();
    }


}
