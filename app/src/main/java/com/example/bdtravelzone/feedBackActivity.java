package com.example.bdtravelzone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class feedBackActivity extends AppCompatActivity implements View.OnClickListener {

    private Button submitButton,clearButton;
    private EditText nameText,emailText,msgText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        submitButton = (Button) findViewById(R.id.submitButtonId);
        clearButton = (Button) findViewById(R.id.clearButtonId);

        setTitle("BD Travel Guide");//Edit Text
        nameText = (EditText) findViewById(R.id.editTextNameId);
        emailText = (EditText) findViewById(R.id.editTextEmailId);
        msgText = (EditText) findViewById(R.id.editTextMsgId);
        clearButton.setOnClickListener(this);
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        try {
            String name = nameText.getText().toString();
            String message = msgText.getText().toString();
            String email = emailText.getText().toString();

            if(name.equals("") && message.equals("") && email.equals("") && v.getId()==R.id.submitButtonId)
            {
                Toast.makeText(getApplicationContext(), "Please Enter Data", Toast.LENGTH_LONG).show();
            }

            else if(v.getId()==R.id.submitButtonId)
            {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL,new String[] {"mdgiasu.cu@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback From App");
                intent.putExtra(Intent.EXTRA_TEXT,"Name: "+name+"\n"+"Email: "+email+"\nMessage: "+message);

                startActivity(intent.createChooser(intent,"Feedback With"));
            }
            else if(v.getId() == R.id.clearButtonId)
            {
                nameText.setText("");
                msgText.setText("");
                emailText.setText("");
            }
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Exception: "+e, Toast.LENGTH_SHORT).show();
        }
    }
}
