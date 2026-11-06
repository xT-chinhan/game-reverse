package com.mar.sdk;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.mar.sdk.utils.ResourceHelper;

/* JADX INFO: loaded from: classes2.dex */
public class MARTapTapLoginActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(128, 128);
        setContentView(ResourceHelper.getIdentifier(this, "R.layout.mar_taptap_login"));
        Button button = (Button) findViewById(ResourceHelper.getIdentifier(this, "R.id.mar_taptap_login_btn"));
        button.setOnClickListener(new View.OnClickListener() { // from class: com.mar.sdk.MARTapTapLoginActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                TapTapSDK.getInstance().loginWithScopes();
                MARTapTapLoginActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
