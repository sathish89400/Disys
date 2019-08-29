package co.app.disys.form.ui;

import co.app.disys.form.data.model.reqEmp;
import co.app.disys.form.data.model.resultEmp;

public interface AddDataView {
    public void sendEmpData(resultEmp request);
    public void errorMsg(String error);
}
