package com.byazt.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.byazt.e.qg;
import com.byazt.e.s;
import com.byazt.e.x;
import com.byazt.z.d;
import com.byazt.z.oa;
import com.byazt.z.q;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 845})
public class JumpUnknownSourceActivity extends Activity {
    public JSONObject l;
    public d n;
    public int q;
    public Intent qg;
    public Intent s;

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        x.n().n(this);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        n();
        x.n().n(this);
    }

    private void n() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.qg = intent;
        if (intent != null) {
            this.s = (Intent) intent.getParcelableExtra("intent");
            this.q = intent.getIntExtra("id", -1);
            try {
                this.l = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception unused) {
            }
        }
        if (this.l == null) {
            s.n((Activity) this);
            return;
        }
        qg();
        d dVar = this.n;
        if (dVar != null && !dVar.qg()) {
            this.n.n();
        } else if (this.n == null) {
            finish();
        }
    }

    private void qg() {
        if (this.n != null || this.qg == null) {
            return;
        }
        try {
            q qVarQg = com.byazt.e.q.cp().qg();
            oa oaVarN = qVarQg != null ? qVarQg.n(this) : null;
            if (oaVarN == null) {
                oaVarN = new com.byazt.n.n(this);
            }
            String strOptString = this.l.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(strOptString)) {
                strOptString = "提示";
            }
            oaVarN.n((CharSequence) "提示").n(strOptString).n("确定", new DialogInterface.OnClickListener() { // from class: com.byazt.a.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (qg.n(jumpUnknownSourceActivity, jumpUnknownSourceActivity.s, JumpUnknownSourceActivity.this.q, JumpUnknownSourceActivity.this.l)) {
                        qg.s(JumpUnknownSourceActivity.this.q, JumpUnknownSourceActivity.this.l);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        qg.n((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.s, true);
                    }
                    qg.n(JumpUnknownSourceActivity.this.q, JumpUnknownSourceActivity.this.l);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).qg("取消", new DialogInterface.OnClickListener() { // from class: com.byazt.a.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (JumpUnknownSourceActivity.this.s != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        qg.n((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.s, true);
                    }
                    qg.qg(JumpUnknownSourceActivity.this.q, JumpUnknownSourceActivity.this.l);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).n(new DialogInterface.OnCancelListener() { // from class: com.byazt.a.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.s != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        qg.n((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.s, true);
                    }
                    qg.qg(JumpUnknownSourceActivity.this.q, JumpUnknownSourceActivity.this.l);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).n(false);
            this.n = oaVarN.n();
        } catch (Exception unused) {
        }
    }
}
