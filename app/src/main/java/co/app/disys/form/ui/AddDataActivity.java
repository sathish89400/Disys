package co.app.disys.form.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import co.app.disys.R;
import co.app.disys.form.data.model.reqEmp;
import co.app.disys.form.data.model.resultEmp;
import co.app.disys.form.presenter.AddDatapresenterImp;

public class AddDataActivity extends AppCompatActivity implements View.OnClickListener,AddDataView{

    private String TAG = getClass().getSimpleName();
    private EditText eId;
    private EditText eName;
    private EditText eIdbarahno;
    private EditText eEmail;
    private EditText eUnifiednumber;
    private EditText eMobile;
    private Button butSave;
    private String strEid;
    private String strEname;
    private String strEibarahno;
    private String strEemail;
    private String strEunifiednumber;
    private String strEmobile;
    private AddDatapresenterImp addDataPresenterImp;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eId = findViewById(R.id.e_id);
        eName = findViewById(R.id.e_name);
        eIdbarahno = findViewById(R.id.e_idbarahno);
        eEmail = findViewById(R.id.e_email);
        eUnifiednumber = findViewById(R.id.e_unifiednumber);
        eMobile = findViewById(R.id.e_mobileno);
        butSave = findViewById(R.id.but_save);
        butSave.setOnClickListener(this);
        progressBar = findViewById(R.id.progress);
        addDataPresenterImp = new AddDatapresenterImp(this);

    }

    @Override
    public void onClick(View view) {
        strEid = eId.getText().toString().trim();
        strEname = eName.getText().toString().trim();
        strEibarahno = eIdbarahno.getText().toString().trim();
        strEemail = eEmail.getText().toString().trim();
        strEunifiednumber = eUnifiednumber.getText().toString().trim();
        strEmobile = eMobile.getText().toString().trim();
        if(TextUtils.isEmpty(strEid)){
            Toast.makeText(getApplicationContext(),R.string.invalid_id,Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(strEname)){
            Toast.makeText(getApplicationContext(),R.string.name_invalid,Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(strEibarahno) && !isNumber(Integer.parseInt(strEibarahno))){
            Toast.makeText(getApplicationContext(),R.string.id_bar,Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(strEemail)){
            Toast.makeText(getApplicationContext(),R.string.email_not_valide,Toast.LENGTH_SHORT).show();
        }else if(!isValideEmail(strEemail)){
            Toast.makeText(getApplicationContext(),R.string.email_not_valide,Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(strEunifiednumber)){
            Toast.makeText(getApplicationContext(),R.string.unified_no,Toast.LENGTH_SHORT).show();
        }else if(TextUtils.isEmpty(strEmobile)){
            Toast.makeText(getApplicationContext(),R.string.mobile_no,Toast.LENGTH_SHORT).show();
        }else if(strEmobile.length() != 10){
            Toast.makeText(getApplicationContext(),R.string.mobile_no,Toast.LENGTH_SHORT).show();
        }else{
            progressShow();
            reqEmp reqEmp = new reqEmp();
            reqEmp.setEid(Integer.parseInt(strEid));
            reqEmp.setName(strEname);
            reqEmp.setIdbarahno(Integer.parseInt(strEibarahno));
            reqEmp.setEmailaddress(strEemail);
            reqEmp.setUnifiednumber(Integer.parseInt(strEunifiednumber));
            reqEmp.setMobileno(strEmobile);
            addDataPresenterImp.sendAddDataResponse(reqEmp);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }

    private boolean isValideEmail(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return false;
        }
    }

    // A placeholder password validation check
    private boolean isNumber(int num) {
        return String.valueOf(num) != null && num > 0;
    }
    private void progressShow(){
        progressBar.setVisibility(View.VISIBLE);
    }

    private void progressHide(){
        progressBar.setVisibility(View.GONE);
    }
    @Override
    public void sendEmpData(resultEmp request) {
        progressHide();
        Toast.makeText(getApplicationContext(),""+request.getMsg(),Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void errorMsg(String error) {
        progressHide();
        Toast.makeText(getApplicationContext()," Sending Failed",Toast.LENGTH_SHORT).show();
    }
}
