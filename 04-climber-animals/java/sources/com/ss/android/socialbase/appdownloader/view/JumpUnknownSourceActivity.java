package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.api.ab;
import com.ss.android.socialbase.appdownloader.ah;
import com.ss.android.socialbase.appdownloader.ah.hi;
import com.ss.android.socialbase.appdownloader.ah.sl;
import com.ss.android.socialbase.appdownloader.d;
import com.ss.android.socialbase.appdownloader.ny;
import com.ss.android.socialbase.appdownloader.x;
import com.ss.android.socialbase.appdownloader.xr;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class JumpUnknownSourceActivity extends Activity {
    private Intent ah;
    private int d;
    private JSONObject ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private hi f4596ms;
    private Intent xr;

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        x.ms().ms(this);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ms();
        x.ms().ms(this);
    }

    private void ms() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.xr = intent;
        if (intent != null) {
            this.ah = (Intent) intent.getParcelableExtra("intent");
            this.d = intent.getIntExtra("id", -1);
            try {
                this.ka = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception e) {
                ab.ms(e);
            }
        }
        if (this.ka == null) {
            ah.ms((Activity) this);
            return;
        }
        xr();
        hi hiVar = this.f4596ms;
        if (hiVar != null && !hiVar.xr()) {
            this.f4596ms.ms();
        } else if (this.f4596ms == null) {
            finish();
        }
    }

    private void xr() {
        if (this.f4596ms != null || this.xr == null) {
            return;
        }
        try {
            com.ss.android.socialbase.appdownloader.ah.ah ahVarMs = d.ch().ms();
            sl slVarMs = ahVarMs != null ? ahVarMs.ms(this) : null;
            if (slVarMs == null) {
                slVarMs = new com.ss.android.socialbase.appdownloader.d.ms(this);
            }
            int iMs = ny.ms(this, "tt_appdownloader_tip");
            int iMs2 = ny.ms(this, "tt_appdownloader_label_ok");
            int iMs3 = ny.ms(this, "tt_appdownloader_label_cancel");
            String strOptString = this.ka.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = getString(ny.ms(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            slVarMs.ms(iMs).ms(strOptString).ms(iMs2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (xr.ms(jumpUnknownSourceActivity, jumpUnknownSourceActivity.ah, JumpUnknownSourceActivity.this.d, JumpUnknownSourceActivity.this.ka)) {
                        xr.ah(JumpUnknownSourceActivity.this.d, JumpUnknownSourceActivity.this.ka);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        xr.ms((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.ah, true);
                    }
                    xr.ms(JumpUnknownSourceActivity.this.d, JumpUnknownSourceActivity.this.ka);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).xr(iMs3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (JumpUnknownSourceActivity.this.ah != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        xr.ms((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.ah, true);
                    }
                    xr.xr(JumpUnknownSourceActivity.this.d, JumpUnknownSourceActivity.this.ka);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).ms(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.ah != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        xr.ms((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.ah, true);
                    }
                    xr.xr(JumpUnknownSourceActivity.this.d, JumpUnknownSourceActivity.this.ka);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).ms(false);
            this.f4596ms = slVarMs.ms();
        } catch (Exception e) {
            ab.ms(e);
        }
    }
}
