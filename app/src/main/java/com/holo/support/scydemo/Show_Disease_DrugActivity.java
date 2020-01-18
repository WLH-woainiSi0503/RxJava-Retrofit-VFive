package com.holo.support.scydemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.holo.support.base.BaseActivity;
import com.holo.support.fragment.ShowoneCommonDrugsFragment;
import com.holo.support.fragment.ShowoneCommonSymptomsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Show_Disease_DrugActivity extends BaseActivity {

    @BindView(R.id.disease_drug_imageone)
    ImageView diseaseDrugImageone;
    @BindView(R.id.disease_drug_imagetwo)
    ImageView diseaseDrugImagetwo;
    @BindView(R.id.disease_drug_btone)
    RadioButton diseaseDrugBtone;
    @BindView(R.id.disease_drug_bttwo)
    RadioButton diseaseDrugBttwo;
    @BindView(R.id.disease_drug_radio)
    RadioGroup diseaseDrugRadio;
    @BindView(R.id.disease_drug_frame)
    FrameLayout diseaseDrugFrame;
    private ShowoneCommonSymptomsFragment showoneCommonSymptomsFragment;//常见病症
    private ShowoneCommonDrugsFragment showoneCommonDrugsFragment;//常见药品

    protected int getLayout() {
        return R.layout.activity_show__disease__drug;
    }

    @Override
    protected void initView() {
        //获取传过来的值
        int code = getIntent().getIntExtra("code", 0);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction Transaction = supportFragmentManager.beginTransaction();


        //1是常见病症2是常见药品
        if (code==1){//常见病症
            showoneCommonSymptomsFragment = new ShowoneCommonSymptomsFragment();
            Transaction.add(R.id.disease_drug_frame,showoneCommonSymptomsFragment);
            Transaction.show(showoneCommonSymptomsFragment);
            Transaction.commit();
        }else{//常见药品
            showoneCommonDrugsFragment = new ShowoneCommonDrugsFragment();
            Transaction.add(R.id.disease_drug_frame,showoneCommonDrugsFragment);
            Transaction.show(showoneCommonDrugsFragment);
            Transaction.commit();
        }

        //切换选择
        diseaseDrugRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

            }
        });

    }
}
