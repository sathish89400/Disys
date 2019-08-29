package co.app.disys.form.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class resultEmp {
    @Expose
    @SerializedName("success")
    String success;
    @Expose
    @SerializedName("message")
    String msg;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
