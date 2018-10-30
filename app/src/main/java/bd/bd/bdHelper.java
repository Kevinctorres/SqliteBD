package bd.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class bdHelper extends SQLiteOpenHelper {
    private static final String NOMBRE_BD="encuesta.bd";
    private static final int VERSION_BD=1;
    private static final String TABLA_ENCUESTA="CREATE TABLE ENCUESTA(DOCUMENTO TEXT PRIMARY KEY, NOMBRE TEXT, EDAD TEXT, UNIVERSIDAD TEXT)";

    public bdHelper(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(TABLA_ENCUESTA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLA_ENCUESTA);
        sqLiteDatabase.execSQL(TABLA_ENCUESTA);
    }
    public void nuevoUsuario(String documento, String nombre, String edad, String universidad){

        SQLiteDatabase bd=getWritableDatabase();
        if (bd!=null){
            bd.execSQL("INSERT INTO ENCUESTA VALUES('"+documento+"','"+nombre+"','"+edad+"','"+universidad+"')");
            bd.close();
        }
    }
}
