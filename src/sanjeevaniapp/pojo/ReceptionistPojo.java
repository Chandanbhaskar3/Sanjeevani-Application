package sanjeevaniapp.pojo;

public class ReceptionistPojo {

    public String getReceName() {
        return receName;
    }

    public void setReceName(String receName) {
        this.receName = receName;
    }

    public String getReceId() {
        return receId;
    }

    public void setReceId(String receId) {
        this.receId = receId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
     

    public ReceptionistPojo(){
        
    }

    public ReceptionistPojo(String receName, String receId, String gender) {
        this.receName = receName;
        this.receId = receId;
        this.gender = gender;
        
    }
    private String receName;
    private String receId;
    private String gender;
    
    
}
