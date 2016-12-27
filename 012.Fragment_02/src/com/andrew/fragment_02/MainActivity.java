package com.andrew.fragment_02;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements OnClickListener {
    
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    
    private RadioGroup rGroup;
    
    private Fragment f1,f2,f3;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        
        /**
         * �õ��������������������
         */
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        
        /**
         * ��ʼ����ť
         */
        rb1 = (RadioButton) findViewById(R.id.rb_1);
        rb2 = (RadioButton) findViewById(R.id.rb_2);
        rb3 = (RadioButton) findViewById(R.id.rb_3);
        
        rGroup = (RadioGroup) findViewById(R.id.rg);
        
        /**
         * Ϊ������ť��Ӽ���
         */
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        
        /**
         * ����Ĭ��ѡ�е�һ��
         */
        rGroup.check(R.id.rb_1);
        f1 = new Fragment1();
        transaction.replace(R.id.fl_content, f1);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();

        switch (v.getId()) {
            case R.id.rb_1 :
                /**
                 * Ϊ�˷�ֹ�ص�����Ҫ���֮ǰ���Ƴ�����Fragment
                 */
                hideFragment(transaction);
                f1 = new Fragment1();
                transaction.replace(R.id.fl_content, f1);
                transaction.commit();
                Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_2 :
                hideFragment(transaction);
                f2 = new Fragment2();
                transaction.replace(R.id.fl_content, f2);
                transaction.commit();
                Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_3 :
                hideFragment(transaction);
                f3 = new Fragment3();
                transaction.replace(R.id.fl_content, f3);
                transaction.commit();
                Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
                break;

            default :
                break;
        }
    }
    
    /*
     * ȥ�������أ����е�Fragment
     * */
    private void hideFragment(FragmentTransaction transaction) {
        if (f1 != null) {
            //transaction.hide(f1);���ط���Ҳ����ʵ��ͬ����Ч����������һ��ʹ��ȥ��
            transaction.remove(f1);
        }
        if (f2 != null) {
            //transaction.hide(f2);
            transaction.remove(f2);
        }
        if (f3 != null) {
            //transaction.hide(f3);
            transaction.remove(f3);
        }
    
        
    }

}