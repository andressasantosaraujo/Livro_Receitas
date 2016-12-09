package ifsp.andressa.livro_receitas.domain;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Andressa on 05/12/2016.
 */

public class Receita implements Parcelable{
    private long id;
    private String titulo;
    private String ingredientes;
    private String passo_passo;

    public Receita(){

    }

    protected Receita(Parcel in) {
        id = in.readLong();
        titulo = in.readString();
        ingredientes = in.readString();
        passo_passo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(titulo);
        dest.writeString(ingredientes);
        dest.writeString(passo_passo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Receita> CREATOR = new Creator<Receita>() {
        @Override
        public Receita createFromParcel(Parcel in) {
            return new Receita(in);
        }

        @Override
        public Receita[] newArray(int size) {
            return new Receita[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPasso_passo() {
        return passo_passo;
    }

    public void setPasso_passo(String passo_passo) {
        this.passo_passo = passo_passo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
