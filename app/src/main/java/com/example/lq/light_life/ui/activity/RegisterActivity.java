package com.example.lq.light_life.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.lq.light_life.R;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    //获取Spinner控件示例
    Spinner spinner_ShoolName = (Spinner)findViewById(R.id.SchoolName);
    Spinner spinner_AcademyName = (Spinner)findViewById(R.id.AcademyName);
    Spinner spinner_DepartmentName = (Spinner)findViewById(R.id.DepartmentName);
    //获取下拉列表数据
    private String[] schoolname = getResources().getStringArray(R.array.SchoolName);
    private String[] academyname = getResources().getStringArray(R.array.AcademyName);
    private String[] departmentname = getResources().getStringArray(R.array.jsj_DepartmentName);
    //适配Spinner
//    ArrayAdapter<String> spinner_SchoolName_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, schoolname);
//
//    public Spinner getSpinner_ShoolName() {
//        return spinner_ShoolName;
//    }
//
//    public ArrayAdapter<String> getSpinner_SchoolName_adapter() {
//        return spinner_SchoolName_adapter;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }
}
