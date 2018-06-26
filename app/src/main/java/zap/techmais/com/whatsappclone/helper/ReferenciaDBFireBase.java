package zap.techmais.com.whatsappclone.helper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public final class ReferenciaDBFireBase {


    private static DatabaseReference dbFireBase;
    private static FirebaseAuth firebaseAuth;


    public static DatabaseReference getDB(){
        if (dbFireBase == null) { dbFireBase = FirebaseDatabase.getInstance().getReference();}
        return dbFireBase;
    }//getDB


    public  static FirebaseAuth getFirebaseAuth(){

        if (firebaseAuth == null){
        firebaseAuth = FirebaseAuth.getInstance();}

        return firebaseAuth;
    }//getFirebaseAuth







}//FP
