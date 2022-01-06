import java.util.Date;

public class PoliceDatabase {
    public Vehicle[] vehicles;
    public int numVehicles;
    public Driver[] drivers;
    public int numDrivers;
    public Infraction[] infractions;
    public int numInfractions;
    private static final int maxVehicles=1000;
    private static final int maxDrivers=2000;
    private static final int maxInfractions=800;
    public Vehicle[] registeredVehicles;

    public PoliceDatabase(){
        vehicles=new Vehicle[maxVehicles];
        drivers=new Driver[maxDrivers];
        infractions=new Infraction[maxInfractions];
        registeredVehicles=new Vehicle[maxVehicles];
    }

    public void registerDriver(Driver aDriver) {
        if (numDrivers < maxDrivers) {
            drivers[numDrivers] = aDriver;
            numDrivers+= 1;
        }
    }

    public void registerVehicle(Vehicle aVehicle, String license){
        if(numVehicles<maxVehicles){
            vehicles[numVehicles]=aVehicle;
            numVehicles++;
            for(int i=0;i<numDrivers;i++){
                if(drivers[i].getLicense().equals(license)){
                    aVehicle.owner=drivers[i];
                }
            }
        }
    }

    public void unregisterVehicle(String plate){
        int first=0;
        for(int i=0;i<numVehicles;i++){
            if(vehicles[i].getPlate().equals(plate)){
                vehicles[i]=vehicles[i];
            }else{
                registeredVehicles[first]=vehicles[i];
                first++;
            }
        }
        numVehicles--;
        for(int i=0;i<numVehicles;i++){
            vehicles[i]=registeredVehicles[i];
        }
    }

    public void reportStolen(String plate){
        for(int i=0;i<numVehicles;i++){
            if(vehicles[i].getPlate().equals(plate)){
                vehicles[i].reportedStolen=true;
            }
        }
    }

    public void changeOwner(String plate, String license){
        for(int i=0;i<numVehicles;i++){
            if(vehicles[i].getPlate().equals(plate)){
                for(int j=0;j<numDrivers;j++){
                    if(drivers[j].getLicense().equals(license)){
                        vehicles[i].owner=drivers[j];
                    }
                }
            }
        }
    }

    public Infraction issueInfraction(String license, float amount, String description, Date date){
        if(numInfractions<maxInfractions){
            for(int i=0;i<numDrivers;i++){
                if(drivers[i].getLicense().equals(license)) {
                    infractions[numInfractions] = new Infraction(amount, description, date);
                    infractions[numInfractions].driver=drivers[i];
                    infractions[numInfractions].outstanding=true;
                    numInfractions++;
                }
            }
        }
        return infractions[numInfractions-1];
    }

    public boolean hasOutstandingInfractions(Driver d){
       for(int i=0;i<numInfractions;i++){
           if(infractions[i].driver.getLicense().equals(d.getLicense())&&infractions[i].outstanding){
               return true;
           }
       }
       return false;
    }

    public boolean shouldStopVehicle(String plate){
        for(int i=0;i<numVehicles;i++) {
            if (vehicles[i].getPlate().equals(plate) && (vehicles[i].reportedStolen || hasOutstandingInfractions(vehicles[i].owner))) {
                return true;
            }
        }
        return false;
    }


    public void showInfractionsFor(String license){
        int total=0;
        var driverInfractions=new Infraction[maxInfractions];
        for(int i=0;i<numInfractions;i++){
            if(infractions[i].driver.getLicense().equals(license)){
                System.out.println(infractions[i]);
                if(infractions[i].outstanding){
                    total++;
                }
            }
        }
        System.out.println("Total outstanding infractions="+total);
    }

    public Driver[] cleanDrivers(){
        var cleanGuys=new Driver[maxDrivers];
        int index=0;
        double h=0;
        for(int i=0;i<numDrivers;i++){
            for(int j=0;j<numInfractions;j++){
                if(!drivers[i].getLicense().equals(infractions[j].driver.getLicense())){
                    h=h+(1 / (float)numInfractions);
                    if((int)h==1){
                        cleanGuys[index]=drivers[i];
                        index++;
                        h=0;
                        break;
                    }
                }else{
                    h=0;
                    break;
                }
            }
        }
        var cleanGuysFiltered=new Driver[index];
        int index2=0;
        for(int i=0;i<numDrivers;i++){
            if(cleanGuys[i]!=null){
                cleanGuysFiltered[index2]=cleanGuys[i];
                index2++;
            }
        }
        return cleanGuysFiltered;
    }

    public void showInfractionReport(){
        int total=0;
        float price=0;
        for(int i=0;i<numDrivers;i++){
            for(int j=0;j<numInfractions;j++){
                if(infractions[j].driver.getLicense().equals(drivers[i].getLicense())){
                    total++;
                    if(!infractions[j].outstanding){
                        price=price+infractions[j].getAmount();
                    }
                }
            }
            if(total>0){
                System.out.println(drivers[i].getName()+": "+ total+" infractions, total paid= "+ "$"+price+"0");
                total=0;
                price=0;
            }
        }
    }






    public static  PoliceDatabase example() { // Register all drivers and their vehicles
        PoliceDatabase pdb = new PoliceDatabase();

        pdb.registerDriver(new Driver("L1567-34323-84980", "Matt Adore",
                "1323 Kenaston St.", "Gloucester", "ON"));
        pdb.registerDriver(new Driver("L0453-65433-87655", "Bob B. Pins",
                "32 Rideau Rd.", "Greely", "ON"));
        pdb.registerDriver(new Driver("L2333-45645-54354", "Stan Dupp",
                "1355 Louis Lane", "Gloucester", "ON"));
        pdb.registerDriver(new Driver("L1234-35489-99837", "Ben Dover",
                "2348 Walkley Rd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L8192-87498-27387", "Patty O'Lantern",
                "2338 Carling Ave.", "Nepean", "ON"));
        pdb.registerDriver(new Driver("L2325-45789-35647", "Ilene Dover",
                "287 Bank St.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1213-92475-03984", "Patty O'Furniture",
                "200 St. Laurant Blvd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1948-87265-34782", "Jen Tull",
                "1654 Stonehenge Cres.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L0678-67825-83940", "Jim Class",
                "98 Oak Blvd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L0122-43643-73286", "Mark Mywords",
                "3 Third St.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L6987-34532-43334", "Bob Upandown",
                "434 Gatineau Way", "Hull", "QC"));
        pdb.registerDriver(new Driver("L3345-32390-23789", "Carrie Meehome",
                "123 Thurston Drive", "Kanata", "ON"));
        pdb.registerDriver(new Driver("L3545-45396-88983", "Sam Pull",
                "22 Colonel By Drive", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1144-26783-58390", "Neil Down",
                "17 Murray St.", "Nepean", "ON"));
        pdb.registerDriver(new Driver("L5487-16576-38426", "Pete Reedish",
                "3445 Bronson Ave.", "Ottawa", "ON"));
        pdb.registerVehicle(new Vehicle("Honda", "Civic", 2015, "yellow", "W3EW4T"),
                "L0453-65433-87655");
        pdb.registerVehicle(new Vehicle("Pontiac","Grand Prix",2007,"dark green","GO SENS"),
                "L0453-65433-87655");
        pdb.registerVehicle(new Vehicle("Mazda", "RX-8", 2004, "white", "OH YEAH"),
                "L2333-45645-54354");
        pdb.registerVehicle(new Vehicle("Nissan","Altima",2017,"bergundy", "Y6P9O7"),
                "L1234-35489-99837");
        pdb.registerVehicle(new Vehicle("Saturn", "Vue", 2002, "white", "9R6P2P"),
                "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Honda", "Accord", 2018, "gray", "7U3H5E"),
                "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Chrysler", "PT-Cruiser", 2006, "gold", "OLDIE"),
                "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Nissan", "Cube", 2010, "white", "5Y6K8V"),
                "L1948-87265-34782");
        pdb.registerVehicle(new Vehicle("Porsche", "959", 1989, "silver", "CATCHME"),
                "L0678-67825-83940");
        pdb.registerVehicle(new Vehicle("Kia", "Soul", 2018, "red", "J8JG2Z"),
                "L0122-43643-73286");
        pdb.registerVehicle(new Vehicle("Porsche", "Cayenne", 2014, "black", "EXPNSV"),
                "L6987-34532-43334");
        pdb.registerVehicle(new Vehicle("Nissan", "Murano", 2010, "silver", "Q2WF6H"),
                "L3345-32390-23789");
        pdb.registerVehicle(new Vehicle("Honda", "Element", 2008, "black", "N7MB5C"),
                "L3545-45396-88983");
        pdb.registerVehicle(new Vehicle("Toyota", "RAV-4", 2010, "green", "R3W5Y7"),
                "L3545-45396-88983");
        pdb.registerVehicle(new Vehicle("Toyota", "Celica", 2006, "red", "FUNFUN"),
                "L5487-16576-38426");

        return pdb;
    }

}
