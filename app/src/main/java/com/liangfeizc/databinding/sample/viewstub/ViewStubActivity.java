package com.liangfeizc.databinding.sample.viewstub;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import com.liangfeizc.databinding.R;
import com.liangfeizc.databinding.core.BaseActivity;
import com.liangfeizc.databinding.databinding.ActivityViewStubBinding;
import com.liangfeizc.databinding.databinding.ViewStubBinding;
import com.liangfeizc.databinding.model.User;

public class ViewStubActivity extends BaseActivity {
    private ActivityViewStubBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_stub);
        binding.viewStub.setOnInflateListener(new ViewStub.OnInflateListener() {
            @Override
            public void onInflate(ViewStub stub, View inflated) {
                ViewStubBinding binding = DataBindingUtil.bind(inflated);
                User user = new User("fee", "lang");
                binding.setUser(user);
            }
        });

    }


    public void inflateViewStub(View view) {
        if (!binding.viewStub.isInflated()) {
            binding.viewStub.getViewStub().inflate();
        }
    }
}