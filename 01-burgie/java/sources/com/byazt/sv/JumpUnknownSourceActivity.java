package com.byazt.sv;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.byazt.mdu.fw;
import com.byazt.mdu.hn;
import com.byazt.mdu.hw;
import com.byazt.zkm.k;
import com.byazt.zkm.m;
import com.byazt.zkm.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 787, 788})
public class JumpUnknownSourceActivity extends Activity {
    public JSONObject c;
    public Intent hn;
    public Intent hw;
    public k pr;
    public int x;

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        fw.pr().pr(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pr();
        fw.pr().pr(this);
    }

    private void pr() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.hw = intent;
        if (intent != null) {
            this.hn = (Intent) intent.getParcelableExtra("intent");
            this.x = intent.getIntExtra("id", -1);
            try {
                this.c = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception e) {
            }
        }
        if (this.c == null) {
            hn.pr((Activity) this);
            return;
        }
        hw();
        k kVar = this.pr;
        if (kVar != null && !kVar.hw()) {
            this.pr.pr();
        } else if (this.pr == null) {
            finish();
        }
    }

    private void hw() {
        if (this.pr != null || this.hw == null) {
            return;
        }
        try {
            x xVarHw = com.byazt.mdu.x.w().hw();
            m prVar = null;
            if (xVarHw != null) {
                prVar = xVarHw.pr(this);
            }
            if (prVar == null) {
                prVar = new com.byazt.lkw.pr(this);
            }
            String strOptString = this.c.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = "提示";
            }
            prVar.pr((CharSequence) "提示").pr(strOptString).pr("确定", new DialogInterface.OnClickListener() { // from class: com.byazt.sv.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (hw.pr(jumpUnknownSourceActivity, jumpUnknownSourceActivity.hn, JumpUnknownSourceActivity.this.x, JumpUnknownSourceActivity.this.c)) {
                        hw.hn(JumpUnknownSourceActivity.this.x, JumpUnknownSourceActivity.this.c);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        hw.pr((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.hn, true);
                    }
                    hw.pr(JumpUnknownSourceActivity.this.x, JumpUnknownSourceActivity.this.c);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).hw("取消", new DialogInterface.OnClickListener() { // from class: com.byazt.sv.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (JumpUnknownSourceActivity.this.hn != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        hw.pr((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.hn, true);
                    }
                    hw.hw(JumpUnknownSourceActivity.this.x, JumpUnknownSourceActivity.this.c);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).pr(new DialogInterface.OnCancelListener() { // from class: com.byazt.sv.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.hn != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        hw.pr((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.hn, true);
                    }
                    hw.hw(JumpUnknownSourceActivity.this.x, JumpUnknownSourceActivity.this.c);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).pr(false);
            this.pr = prVar.pr();
        } catch (Exception e) {
        }
    }
}
