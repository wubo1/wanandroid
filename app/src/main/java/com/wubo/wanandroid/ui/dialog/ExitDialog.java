package com.wubo.wanandroid.ui.dialog;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.wubo.wanandroid.R;
import com.wubo.wanandroid.databinding.DialogExitBinding;

/**
 * Author: wubo
 * Create on: 2019/4/3 16:31
 * Description:
 */
public class ExitDialog extends BaseDialog<DialogExitBinding> implements View.OnClickListener {
    private View.OnClickListener listener;

    public ExitDialog(Context context, View.OnClickListener listener) {
        super(context, R.layout.dialog_exit, BaseDialog.STYLE_COMMON);
        WindowManager windowManager =getmDialog().getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams lp = getmDialog().getWindow().getAttributes();
        lp.width = (int)(display.getWidth()*0.8); //设置宽度
        lp.height = RecyclerView.LayoutParams.WRAP_CONTENT;
        getmDialog().getWindow().setAttributes(lp);
        this.listener = listener;

        viewDataBinding.tvQueding.setOnClickListener(listener);
        viewDataBinding.tvQuxiao.setOnClickListener(listener);

    }

    @Override
    public void onClick(View view) {
        listener.onClick(view);
        this.cancel();
    }
}
