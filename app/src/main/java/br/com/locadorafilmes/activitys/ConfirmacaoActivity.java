package br.com.locadorafilmes.activitys;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.locadorafilmes.R;
import br.com.locadorafilmes.TaynahLOCUtil;

public class ConfirmacaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacao);
    }

    public void confirmLocacao_onClick(View view)
    {
        SharedPreferences sharedPreferences = this.getSharedPreferences(TaynahLOCUtil.TAYNAH_LOC_CODE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(TaynahLOCUtil.CONFIRM_CONFIRM_ACTIVITY_CODE, true);
        editor.apply();

        finish();
    }

    public void cancelarLocacao_onClick(View view)
    {
        SharedPreferences sharedPreferences = this.getSharedPreferences(TaynahLOCUtil.TAYNAH_LOC_CODE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(TaynahLOCUtil.CANCEL_CONFIRM_ACTIVITY_CODE, true);
        editor.apply();

        finish();
    }
}
