package com.mcto.sspsdk.ssp.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.mcto.sspsdk.R;
import com.mcto.sspsdk.internal.e1;

/* JADX INFO: loaded from: classes2.dex */
public class DialogActivity extends AppCompatActivity implements View.OnClickListener {
    private String a;
    private String b;

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public final void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int id = view.getId();
        if (id == R.id.qy_dialog_negative_btn) {
            finish();
        } else if (id == R.id.qy_dialog_positive_btn) {
            e1.a(true, this, this.b, this.a);
            finish();
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.qy_activity_dialog);
        Window window = getWindow();
        window.setFlags(512, 512);
        if (Build.VERSION.SDK_INT >= 29) {
            window.getDecorView().setForceDarkAllowed(false);
        }
        Intent intent = getIntent();
        this.a = intent.getStringExtra("apkName");
        this.b = intent.getStringExtra("deeplink");
        String stringExtra = intent.getStringExtra("appName");
        if (TextUtils.isEmpty(stringExtra)) {
            ((TextView) findViewById(R.id.qy_dialog_msg)).setText("您刚刚安装了一款精选应用，快来体验一下吧？");
        } else {
            ((TextView) findViewById(R.id.qy_dialog_msg)).setText("您刚刚安装了精选应用【" + stringExtra + "】，快来体验一下吧？");
        }
        findViewById(R.id.qy_dialog_negative_btn).setOnClickListener(this);
        findViewById(R.id.qy_dialog_positive_btn).setOnClickListener(this);
    }
}
