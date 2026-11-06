package com.byazt.mr;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.smartdigimkt.sdk.api.SDMAdConst;
import com.taptap.sdk.compilance.constants.BundleKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT})
public class oa extends s {
    public boolean fs;
    public JSONObject l;
    public com.byazt.ozc.x q;
    public Window s;
    public com.byazt.ep.rv w;
    public volatile boolean x;

    @Override // com.byazt.mr.s
    public void qg() {
    }

    public oa(Activity activity, JSONObject jSONObject, com.byazt.ozc.x xVar) {
        super(activity);
        this.s = activity == null ? null : activity.getWindow();
        this.l = jSONObject;
        this.q = xVar;
        this.w = new com.byazt.ep.rv(activity);
    }

    @Override // com.byazt.mr.s, android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.byazt.mr.s
    public void n() {
        if (this.n == null) {
            this.n = com.byazt.nf.rv.getContext();
        }
        if (this.n.getResources().getConfiguration().orientation != 1) {
            this.fs = true;
            super.n();
            super.qg();
            x();
            return;
        }
        l();
        w();
    }

    private void l() {
        if (this.s != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            this.s.setBackgroundDrawable(gradientDrawable);
            WindowManager.LayoutParams attributes = this.s.getAttributes();
            attributes.alpha = 1.0f;
            this.s.setAttributes(attributes);
        }
    }

    private void w() {
        JSONObject jSONObject = this.l;
        if (jSONObject == null || this.q == null) {
            return;
        }
        JSONObject jSONObjectN = com.byazt.ep.cp.n(jSONObject.remove("ugen_url").toString(), this.l.remove("ugen_md5").toString(), (com.byazt.ep.s) null);
        if (jSONObjectN == null) {
            this.q.n(11, "uegnTemplate is empty");
            this.x = true;
        } else {
            final FrameLayout frameLayout = new FrameLayout(this.n);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.w.n(jSONObjectN, this.l, new com.byazt.ozc.x() { // from class: com.byazt.mr.oa.1
                @Override // com.byazt.ozc.x
                public void n(int i, String str) {
                    oa.this.x = true;
                    if (oa.this.q != null) {
                        FrameLayout frameLayout2 = frameLayout;
                        if (frameLayout2 != null) {
                            frameLayout2.removeAllViews();
                        }
                        oa.this.q.n(i, str);
                    }
                }

                @Override // com.byazt.ozc.x
                public void n(com.byazt.ih.s<View> sVar) {
                    oa.this.x = false;
                    if (oa.this.q != null) {
                        oa.this.q.n(null);
                    }
                    frameLayout.addView(sVar.rv(), new FrameLayout.LayoutParams(sVar.an(), sVar.ae()));
                    oa.this.setContentView(frameLayout);
                }
            });
        }
    }

    private void x() {
        JSONObject jSONObject = this.l;
        if (jSONObject == null) {
            return;
        }
        n(jSONObject.optString("app_name"));
        l(this.l.optString("app_version"));
        w(this.l.optString("reg_number"));
        x(this.l.optString("reg_url"));
        qg(this.l.optString(SDMAdConst.NETWORK_CUSTOM_KEY.ICON_URL));
        fs(this.l.optString("developer_name"));
        n(this.l.optInt("score"));
        n(this.l.optJSONArray("creative_tags"));
        q(this.l.optString(BundleKey.DESCRIPTION));
    }

    @Override // com.byazt.mr.s
    public void s() {
        if (this.fs) {
            super.s();
        }
    }

    public void qg(s.n nVar) {
        super.n(nVar);
        com.byazt.ep.rv rvVar = this.w;
        if (rvVar != null) {
            rvVar.n(nVar);
        }
    }

    @Override // com.byazt.mr.s, android.app.Dialog
    public void show() {
        super.show();
        if (this.x) {
            hide();
            dismiss();
        }
    }
}
