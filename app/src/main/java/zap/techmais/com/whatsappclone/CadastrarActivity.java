package zap.techmais.com.whatsappclone;

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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.database.DatabaseReference;

import zap.techmais.com.whatsappclone.helper.ReferenciaDBFireBase;
import zap.techmais.com.whatsappclone.models.Usuario;

public class CadastrarActivity extends AppCompatActivity {


    private EditText nomeCadastro;
    private  EditText emailCadastro;
    private  EditText senhaCadastro;
    private Button cadastrarDados;
    private FirebaseAuth autentica;



    private  Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);



     nomeCadastro = findViewById(R.id.nomeCadastro_id);
     emailCadastro = findViewById(R.id.emailCadastro_id);
     senhaCadastro = findViewById(R.id.senhaCadastro_id);

     cadastrarDados = findViewById(R.id.cadastrarDados_id);



     cadastrarDados.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             usuario = new Usuario();
            usuario.setNome(nomeCadastro.getText().toString());
            usuario.setEmail(emailCadastro.getText().toString());
            usuario.setSenha(senhaCadastro.getText().toString());

            cadastrarUserDBFire();

         }
     });





    }//create



    private void cadastrarUserDBFire(){
            autentica = ReferenciaDBFireBase.getFirebaseAuth();
            autentica.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha()).addOnCompleteListener(
                    CadastrarActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()) {
                                Toast.makeText(getApplicationContext(), "Cadastro com Sucesso!!!", Toast.LENGTH_LONG).show();

                                usuario.setId(task.getResult().getUser().getUid());
                                usuario.salvarDBFire();
                                autentica.signOut();
                                finish();


                            } else {

                                String msgExes = "";


                                try{


                                  throw   task.getException();

                                }catch (FirebaseAuthWeakPasswordException ewek){
                                    msgExes = "Senha Frasca!";

                                }catch (FirebaseAuthInvalidCredentialsException ecre){

                                    msgExes = "Email Invalido";
                                }catch (FirebaseAuthUserCollisionException exc){

                                    msgExes = "Usuario Já existe";
                                } catch (Exception e){
                                    e.printStackTrace();
                                }




                                Toast.makeText(getApplicationContext(), "ERRO!!!" + msgExes, Toast.LENGTH_LONG).show();
                            }//

                        }
                    }
            );

    }//



}//FP




