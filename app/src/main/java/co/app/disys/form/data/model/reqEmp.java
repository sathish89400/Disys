package co.app.disys.form.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class reqEmp {
    @Expose
    @SerializedName("eid")
    int eid;
    @Expose
    @SerializedName("name")
    String name;
    @Expose
    @SerializedName("idbarahno")
    int idbarahno;
    @Expose
    @SerializedName("emailaddress")
    String emailaddress;
    @Expose
    @SerializedName("unifiednumber")
    int unifiednumber;
    @Expose
    @SerializedName("mobileno")
    String mobileno;

    public reqEmp() {
    }

    public reqEmp(int eid, String name, int idbarahno, String emailaddress, int unifiednumber, String mobileno) {
        this.eid = eid;
        this.name = name;
        this.idbarahno = idbarahno;
        this.emailaddress = emailaddress;
        this.unifiednumber = unifiednumber;
        this.mobileno = mobileno;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdbarahno() {
        return idbarahno;
    }

    public void setIdbarahno(int idbarahno) {
        this.idbarahno = idbarahno;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public int getUnifiednumber() {
        return unifiednumber;
    }

    public void setUnifiednumber(int unifiednumber) {
        this.unifiednumber = unifiednumber;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}
