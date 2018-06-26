package zap.techmais.com.whatsappclone;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import zap.techmais.com.whatsappclone.helper.ReferenciaDBFireBase;
import zap.techmais.com.whatsappclone.models.Usuario;

public class LoginActivity extends AppCompatActivity {

    private Context contextLongin;

    private EditText emailLogin;
    private EditText senhaLogin;
    private Button entrarLogin;
    private Usuario usuario;
    private FirebaseAuth authLogar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        contextLongin = getApplicationContext();

        FirebaseAuth auth = ReferenciaDBFireBase.getFirebaseAuth();
        if (auth.getCurrentUser() !=null){
            irHomePrincipal(); }


        emailLogin = findViewById(R.id.emailLogin_id);

        senhaLogin = findViewById(R.id.senhaLogin_id);

        entrarLogin = findViewById(R.id.entrarLogin_id);


        entrarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                usuario = new Usuario();
                usuario.setEmail(emailLogin.getText().toString());
                usuario.setSenha(senhaLogin.getText().toString());
                logarUsuario();


            }
        });






    }//create


    private void logarUsuario(){

        authLogar = ReferenciaDBFireBase.getFirebaseAuth();

        authLogar.signInWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){

                            Toast.makeText(contextLongin , "Acesso Liberado!!", Toast.LENGTH_LONG).show();
                            irHomePrincipal();
                            finish();


                        }else {

                            Toast.makeText(contextLongin, "Acesso Negado!!", Toast.LENGTH_LONG).show();



                        }// if | else





                    }
                });



    }//logarUser


    public void link_cadastro(View view){

        Intent intentCadastrar = new Intent(LoginActivity.this,CadastrarActivity.class);
        startActivity(intentCadastrar);

    }// link cadastro





    private void irHomePrincipal(){
        Intent intentHomeP = new Intent(contextLongin, MainActivity.class);
        startActivity(intentHomeP);
    }






}//FP
