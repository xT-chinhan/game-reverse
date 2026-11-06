package com.byazt.nc;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.byazt.sd.a;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.taptap.sdk.compliance.constants.BundleKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 52, 108})
public class m extends hn {
    public JSONObject c;
    public volatile boolean fw;
    public Window hn;
    public com.byazt.ea.aj uc;
    public com.byazt.sa.fw x;
    public boolean zo;

    public m(Activity activity, JSONObject jSONObject, com.byazt.sa.fw fwVar) {
        super(activity);
        this.hn = activity == null ? null : activity.getWindow();
        this.c = jSONObject;
        this.x = fwVar;
        this.uc = new com.byazt.ea.aj(activity);
    }

    @Override // com.byazt.nc.hn, android.app.AlertDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.byazt.nc.hn
    public void pr() {
        if (this.pr == null) {
            this.pr = a.getContext();
        }
        if (this.pr.getResources().getConfiguration().orientation != 1) {
            this.zo = true;
            super.pr();
            super.hw();
            fw();
            return;
        }
        c();
        uc();
    }

    private void c() {
        if (this.hn != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            this.hn.setBackgroundDrawable(gradientDrawable);
            WindowManager.LayoutParams attributes = this.hn.getAttributes();
            attributes.alpha = 1.0f;
            this.hn.setAttributes(attributes);
        }
    }

    private void uc() {
        JSONObject jSONObject = this.c;
        if (jSONObject == null || this.x == null) {
            return;
        }
        JSONObject jSONObjectPr = com.byazt.ea.w.pr(jSONObject.remove("ugen_url").toString(), this.c.remove("ugen_md5").toString(), (com.byazt.ea.hn) null);
        if (jSONObjectPr == null) {
            this.x.pr(11, "uegnTemplate is empty");
            this.fw = true;
        } else {
            final FrameLayout frameLayout = new FrameLayout(this.pr);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.uc.pr(jSONObjectPr, this.c, new com.byazt.sa.fw() { // from class: com.byazt.nc.m.1
                @Override // com.byazt.sa.fw
                public void pr(int i, String str) {
                    m.this.fw = true;
                    if (m.this.x != null) {
                        FrameLayout frameLayout2 = frameLayout;
                        if (frameLayout2 != null) {
                            frameLayout2.removeAllViews();
                        }
                        m.this.x.pr(i, str);
                    }
                }

                @Override // com.byazt.sa.fw
                public void pr(com.byazt.ik.hn<View> hnVar) {
                    m.this.fw = false;
                    if (m.this.x != null) {
                        m.this.x.pr(null);
                    }
                    frameLayout.addView(hnVar.aj(), new FrameLayout.LayoutParams(hnVar.e(), hnVar.s()));
                    m.this.setContentView(frameLayout);
                }
            });
        }
    }

    @Override // com.byazt.nc.hn
    public void hw() {
    }

    private void fw() {
        JSONObject jSONObject = this.c;
        if (jSONObject == null) {
            return;
        }
        pr(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.APP_NAME));
        c(this.c.optString("app_version"));
        uc(this.c.optString("reg_number"));
        fw(this.c.optString("reg_url"));
        hw(this.c.optString("icon_url"));
        zo(this.c.optString("developer_name"));
        pr(this.c.optInt("score"));
        pr(this.c.optJSONArray("creative_tags"));
        x(this.c.optString(BundleKey.DESCRIPTION));
    }

    @Override // com.byazt.nc.hn
    public void hn() {
        if (!this.zo) {
            return;
        }
        super.hn();
    }

    public void hw(hn.pr prVar) {
        super.pr(prVar);
        com.byazt.ea.aj ajVar = this.uc;
        if (ajVar != null) {
            ajVar.pr(prVar);
        }
    }

    @Override // com.byazt.nc.hn, android.app.Dialog
    public void show() {
        super.show();
        if (this.fw) {
            hide();
            dismiss();
        }
    }
}
