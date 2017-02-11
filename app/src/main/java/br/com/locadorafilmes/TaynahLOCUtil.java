package br.com.locadorafilmes;

import android.app.Activity;
import android.view.WindowManager;

public class TaynahLOCUtil
{
    public static final String TAYNAH_LOC_CODE = "taynahloc_preferences";
    public static final String CANCEL_CONFIRM_ACTIVITY_CODE = "cancel_confirm_activity_code";
    public static final String CONFIRM_CONFIRM_ACTIVITY_CODE = "confirm_confirm_activity_code";

    public static void ocultarTeclado(Activity activity)
    {
        activity.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }
}
