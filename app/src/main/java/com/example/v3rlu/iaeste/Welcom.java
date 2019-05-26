package com.example.v3rlu.iaeste;

//package com.example.v3rlu.iaestejobraising;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Welcom extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText compname,tel,addresse,status,zone ;
    Button lgout,inset,list ;
    TextView TVname ;
    FirebaseDatabase database ;
    DatabaseReference ref ;
    Zones zones ;
    String userst ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        mAuth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        ref=database.getReference("Zones");
        compname=(EditText) findViewById(R.id.editText3) ;
        tel=(EditText) findViewById(R.id.editText6) ;
        addresse=(EditText) findViewById(R.id.editText4) ;
        status=(EditText) findViewById(R.id.editText5) ;
        zone=(EditText) findViewById(R.id.editText7) ;
        lgout=(Button) findViewById(R.id.logout) ;
        inset=(Button) findViewById(R.id.button5) ;
        list=(Button) findViewById(R.id.button4) ;
        TVname=(TextView) findViewById(R.id.textView) ;
        zones=new Zones();


        if (mAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(getApplicationContext(),IAESTE_login.class));
        }

        FirebaseUser user =mAuth.getCurrentUser() ;
        userst=user.getEmail();

        if (user!=null){
            TVname.setText("welcome Member : "+userst);
        }




        inset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getVlaue();
                DatabaseReference post=ref.child("Zones") ;
                DatabaseReference newPostRef = post.push();
                newPostRef.setValue(zones);
                //finish() ;

                Toast.makeText(Welcom.this,"data Inserted please wait .... ",Toast.LENGTH_LONG).show() ;
            }
        });


        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Welcom.this,LIST.class) ;
                startActivity(i);
            }
        });


    }


    private void getVlaue(){

        zones.setCompname(compname.getText().toString()) ;
        zones.setAddresse(addresse.getText().toString()) ;
        zones.setTel(tel.getText().toString()) ;
        zones.setStatus(status.getText().toString()) ;
        zones.setUser(userst);
        zones.setZone(zone.getText().toString()) ;
    }


    public void logout(View v) {

        mAuth.signOut();
        finish();
        startActivity(new Intent(getApplicationContext(),IAESTE_login.class));
        Toast.makeText(Welcom.this, "Logout Done we are waiting for you",
                Toast.LENGTH_SHORT).show();
    }



}
