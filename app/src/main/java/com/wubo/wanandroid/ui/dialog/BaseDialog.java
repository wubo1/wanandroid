package com.wubo.wanandroid.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.wubo.wanandroid.R;


/**
 * Created by Thinkpad on 2018/10/9.
 */

public abstract class BaseDialog<VD extends ViewDataBinding> {
    private NoStatuesBarDialog mDialog;
    protected Context context;
    protected VD viewDataBinding;
    public static final int STYLE_TOP = R.style.TopDialog_Animation;
    public static final int STYLE_BOTTOM = R.style.BottomDialog_Animation;
    public static final int STYLE_COMMON = R.style.myDialog;
    public static final int STYLE_COMMON_ALL = R.style.myDialog1;
    public static final int STYLE_RIGHT = R.style.RightDialog_Animation;

    public BaseDialog(Context mContext, int layout, int style) {
        context = mContext;
        setContent(layout, style);
    }
//
//    public BaseDialog(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public BaseDialog(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }

    private View getView(Context context, int Layout_Id) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View Layout = inflater.inflate(Layout_Id, null);
        //View rootView = inflater.inflate(Layout_Id, null);
        viewDataBinding = DataBindingUtil.inflate(inflater , Layout_Id , null , false);
        //ButterKnife.bind(this, rootView);
        return viewDataBinding.getRoot();
    }

    protected void setContent(int layout, int style) {
        //为自定义的对话框设置view
        mDialog = new NoStatuesBarDialog(context, R.style.myDialog);
        if(style==STYLE_BOTTOM || style == STYLE_COMMON_ALL || style == STYLE_RIGHT) {
            mDialog.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
            mDialog.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                @Override
                public void onSystemUiVisibilityChange(int visibility) {
                    int uiOptions =
//                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                            //布局位于状态栏下方
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                                    //全屏
//                        View.SYSTEM_UI_FLAG_FULLSCREEN |
                                    //隐藏导航栏
                                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                    if (Build.VERSION.SDK_INT >= 19) {
                        uiOptions |= 0x00001000;
                    } else {
                        uiOptions |= View.SYSTEM_UI_FLAG_LOW_PROFILE;
                    }
                    mDialog.getWindow().getDecorView().setSystemUiVisibility(uiOptions);
                }
            });
        }
        if(style == STYLE_TOP){
            mDialog.getWindow().setGravity(Gravity.TOP);
            mDialog.getWindow().setWindowAnimations(STYLE_TOP);
        }else if(style == STYLE_BOTTOM ){
            mDialog.getWindow().setGravity(Gravity.BOTTOM);
            mDialog.getWindow().setWindowAnimations(STYLE_BOTTOM);

        }else if(style == STYLE_RIGHT){
            mDialog.getWindow().setGravity(Gravity.TOP);
            mDialog.getWindow().setWindowAnimations(STYLE_RIGHT);
        }


        View dialogView = getView(context, layout);
        Window window = mDialog.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        //获得window窗口的属性
        WindowManager.LayoutParams lp = window.getAttributes();
        //设置窗口宽度为充满全屏
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        //设置窗口高度为包裹内容
        lp.height = (style == STYLE_RIGHT ||  style == STYLE_COMMON_ALL)  ? WindowManager.LayoutParams.MATCH_PARENT : WindowManager.LayoutParams.WRAP_CONTENT;
        //将设置好的属性set回去
        window.setAttributes(lp);
        mDialog.setContentView(dialogView);
        //初始view
        initView(dialogView);
    }


    public void show() {
        if (context != null)
            if (context instanceof Activity) {
                if (!((Activity) context).isFinishing())
                    mDialog.show();
            } else {
                mDialog.show();
            }
    }

    public void cancel() {
        mDialog.cancel();
    }

    protected void initView(View dialogView) {
    }

    public Boolean isShowing() {
        return mDialog.isShowing();
    }

    public void setCancelable(boolean b) {
        mDialog.setCancelable(b);
    }

    public NoStatuesBarDialog getmDialog() {
        return mDialog;
    }
}
