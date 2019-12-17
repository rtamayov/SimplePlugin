package pe.entel.cordova.plugin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import android.content.res.Configuration;
import android.content.res.Resources;

public class InputActivity extends Activity {

    private Button btnSalir;
    private EditText txtValor;
    private String package_name;
	private Resources resources;
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


		setContentView(getResourceId("layout/activity_input"));
		

        btnSalir = (Button) findViewById(getResourceId("id/button"));
        txtValor =  (EditText) findViewById(getResourceId("id/editText"));


        btnSalir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                regresar();
            }
        });


    }

    private int getResourceId (String typeAndName)
    {
        if(package_name == null) package_name = getApplication().getPackageName();
        if(resources == null) resources = getApplication().getResources();
        return resources.getIdentifier(typeAndName, null, package_name);
    }
	
	
    @Override
    public void onBackPressed() {

    }

    private void regresar() {

        Intent i = new Intent();
        i.putExtra("respuesta", txtValor.getText().toString());
        setResult(Activity.RESULT_OK, i);
        finish();

    }
}
