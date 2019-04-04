package com.wubo.wanandroid.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Yang on 2017/5/8.
 */

public class NoStatuesBarDialog extends Dialog {
    public NoStatuesBarDialog(@NonNull Context context) {
        super(context);
        hideStatusBar();
    }

    public NoStatuesBarDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        hideStatusBar();
    }

    protected NoStatuesBarDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        hideStatusBar();
    }

    private void hideStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    /*| WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION*/);

            //TODO 这句代码影响到布局无法跟随键盘往上移动
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN /*| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION*/ | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);


            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

}
