package hope.afterlifeprojects.seif.french.fittnes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int x = 10 ;
    int y = 20 ;
    int age ;
    int weight ;
    int height ;
    float sedentaryLifestyle = 1.2f;
    float slightlyActive =1.375f;
    float moderatelyActive = 1.55f;
    float activeLifestyle = 1.725f;
    float VeryActivelifestyle = 1.9f;

    TextView maintanceText , loseText ;
    double result ;
    Spinner sexSpinner,activitySpinner;
    EditText ageEditText ,weightEditText ,heightEditText, weightToLose,duration ;
    String checkSpinner ;
    String cardStatusString , activitySpinnerString  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        maintanceText = (TextView)findViewById(R.id.maintenanceTextView);
        loseText = (TextView)findViewById(R.id.losetTextView);
        ageEditText = (EditText)findViewById(R.id.ageEditText);
        weightEditText = (EditText)findViewById(R.id.weightEditText);
        heightEditText = (EditText)findViewById(R.id.heightEditText);
        weightToLose = (EditText)findViewById(R.id.weightToLoseEdittext);
        duration = (EditText)findViewById(R.id.durationEditText);
        sexSpinner = (Spinner)findViewById(R.id.sexSpinner);
        activitySpinner = (Spinner)findViewById(R.id.activitySpinner);


        String[] activity = new String[] {
                "Select from the dropdown", "Sedentary Lifestyle","Slightly Active","Moderately Active","Active Lifestyle","Very Active lifestyle"};
        String[] arraySpinner = new String[] {
                "Male", "Female"};

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, activity);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitySpinner.setAdapter(adapter2);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sexSpinner.setAdapter(adapter);

        sexSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

             @Override
             public void onItemSelected(AdapterView<?> parent,
                                        View view, int pos, long id) {
                 cardStatusString = parent.getItemAtPosition(pos).toString();


             }

             @Override
             public void onNothingSelected(AdapterView<?> arg0) {
                 // TODO Auto-generated method stub

             }
         });


        activitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int pos, long id) {
                activitySpinnerString = parent.getItemAtPosition(pos).toString();


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }

    public void any (){

       // String s = ageEditText.getText().toString();

    }

    public void test(View v)
    {
       // double z = 10 * 48 +6.25f *165-5*25-161 ;
        try {
       int ageNum = Integer.parseInt(ageEditText.getText().toString());
       int weightNum = Integer.parseInt(weightEditText.getText().toString());
       int heightNum = Integer.parseInt(heightEditText.getText().toString());
       int weightLose = Integer.parseInt(weightToLose.getText().toString());
       int durationt =  Integer.parseInt(duration.getText().toString());
       int s = weightLose * 7700 /durationt ;
       int tt = 7700 /durationt;

       if (cardStatusString.equals("Male") && activitySpinnerString.equals("Sedentary Lifestyle")){
           result = 10 * weightNum +6.25f * heightNum -5 * ageNum +5  ;

           String h = String.valueOf(Math.round(result)); // (int)Math.round(result)   TRY THIS U CLOSE TO SLEEP TRY IT TOM
           double  r =  result * sedentaryLifestyle - tt ;
           maintanceText.setText(h);
           loseText.setText(String.valueOf(Math.round(r))); // (int)Math.round(r)   TRY THIS U CLOSE TO SLEEP TRY IT TOM
           // Toast.makeText(MainActivity.this,String.valueOf(result)+ " Cal",Toast.LENGTH_LONG).show();
       }else if (cardStatusString.equals("Female")){
           result = 10 * weightNum +6.25f * heightNum -5 * ageNum -161 ;
           Toast.makeText(MainActivity.this,String.valueOf(result)+" Cal",Toast.LENGTH_LONG).show();
       }}catch (Exception e){

           Toast.makeText(MainActivity.this,"One of the Feilds Empty",Toast.LENGTH_LONG).show();
       }




    }



}
