package com.wubo.wanandroid.ui.personalcenter.fra;

import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wubo.wanandroid.R;
import com.wubo.wanandroid.config.ConstantConfig;
import com.wubo.wanandroid.config.NetConstant;
import com.wubo.wanandroid.databinding.FragmentPersonalCenterBinding;
import com.wubo.wanandroid.ui.dialog.ExitDialog;
import com.wubo.wanandroid.ui.my.act.LoginActivity;
import com.wubo.wanandroid.ui.personalcenter.vm.PersonalCenterVm;
import com.wubo.wanandroid.utils.CommonUtils;
import com.wubo.wanandroid.utils.Utils;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.bus.Messenger;
import me.goldze.mvvmhabit.utils.SPUtils;


/**
 * Author: wubo
 * Create on: 2019/3/25 14:38
 * Description:
 */
public class PersonalCenterFragment extends BaseFragment<FragmentPersonalCenterBinding,PersonalCenterVm> {
    ExitDialog exitDialog;
    public static PersonalCenterFragment newInstance(){
        Bundle bundle=new Bundle();
        PersonalCenterFragment personalCenterFragment =new PersonalCenterFragment();
        personalCenterFragment.setArguments(bundle);
        return personalCenterFragment;
    }
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_personal_center;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void onStart() {
        super.onStart();
        binding.personalCenterRefresh.autoRefresh();
        viewModel.refreshLoginData();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Messenger.getDefault().register(this, ConstantConfig.TOKEN_LOGOUT_LOGIN, new BindingAction() {
            @Override
            public void call() {
                viewModel.refreshLoginData();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void initViewObservable() {
        super.initViewObservable();
        viewModel.uc.loginOrLogout.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (CommonUtils.isLogin()){
                    exitDialog =new ExitDialog(getContext(), new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            switch (view.getId()){
                                case R.id.tv_queding:
                                    SPUtils.getInstance().put(NetConstant.ISLOGIN,false);
                                    viewModel.items.clear();
                                    CommonUtils.removeCookies();
                                    Messenger.getDefault().sendNoMsg(ConstantConfig.TOKEN_LOGOUT_LOGIN);
                                    viewModel.refreshLoginData();
                                    exitDialog.cancel();
                                    break;
                                case R.id.tv_quxiao:
                                    exitDialog.cancel();
                                    break;
                            }
                        }
                    });
                    exitDialog.show();

                }else{
                    startActivity(LoginActivity.class);
                }
            }
        });
    }
}
