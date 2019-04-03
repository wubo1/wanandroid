package com.wubo.wanandroid.http;

import com.wubo.wanandroid.bean.BaseBean;
import com.wubo.wanandroid.config.NetConstant;
import com.wubo.wanandroid.utils.CommonUtils;
import com.wubo.wanandroid.utils.NetDialogBack;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import me.goldze.mvvmhabit.utils.SPUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;

public abstract class BaseNetObserver<T extends BaseBean> implements Observer<T> {
    private NetDialogBack dialogBack;

    public BaseNetObserver() {
    }

    public BaseNetObserver(NetDialogBack back) {
        this.dialogBack = back;
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (dialogBack != null) {
            dialogBack.netStart();
        }
    }


    @Override
    public void onNext(T t) {
        if (t.getErrorCode() == 0) {
            onSuccess(t);
        } else {
            ToastUtils.showShort(t.getErrorMsg());
            Throwable throwable = new Throwable(t.getErrorMsg());
            onFail(throwable);
            if(t.getErrorCode() == -1001){
                ToastUtils.showShort("登录授权过期,请重新登录");
                CommonUtils.removeCookies();
                SPUtils.getInstance().put(NetConstant.ISLOGIN,false);
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        onFail(e);
        if(e instanceof java.net.SocketTimeoutException){
            ToastUtils.showShort("网络连接超时");
        }else {
            ToastUtils.showShort(e.getMessage());
        }
        if (dialogBack != null) {
            dialogBack.netEnd();
        }
    }

    @Override
    public void onComplete() {
        if (dialogBack != null) {
            dialogBack.netEnd();
        }
    }


    public abstract void onSuccess(T data);

    public abstract void onFail(Throwable t);


}
