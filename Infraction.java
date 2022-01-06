import java.util.Date;

public class Infraction {
    private float amount;
    private String description;
    private Date dateIssued;
    public boolean outstanding;
    public Driver driver;

    public Infraction(float amount, String description, Date dateIssued){
        this.amount=amount;
        this.description=description;
        this.dateIssued=dateIssued;
        this.outstanding=true;
    }
    public Infraction(){
        this.amount=0;
        this.description="";
        this.dateIssued=new Date(1970,01,01,00,00);
    }

    //getters
    public float getAmount() {
        return amount;
    }
    public String getDescription() {
        return description;
    }
    public Date getDateIssued() {
        return dateIssued;
    }
    public Driver getDriver() {
        return driver;
    }

    //setters
    public void setAmount(float amount) {
        this.amount = amount;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDateIssued(Date dateIssued) {
        this.dateIssued = dateIssued;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    //pay method
    public void pay(){
        outstanding=false;
    }

    //toString\
    @Override
    public String toString(){
        String paid_or_not="";
        if(outstanding){
            paid_or_not="[OUTSTANDING]";
        }else{
            paid_or_not="[PAID IN FULL]";
        }
        return "$"+String.format("%.2f",getAmount())+" Infraction on "+getDateIssued()+" "+paid_or_not;
    }


}
