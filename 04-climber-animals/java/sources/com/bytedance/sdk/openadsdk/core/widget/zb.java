package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.re;
import com.taptap.sdk.compliance.constants.BundleKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zb extends ah {
    private volatile boolean ab;
    Window ah;
    private com.bytedance.sdk.openadsdk.core.ugeno.x c;
    private com.bytedance.sdk.openadsdk.core.ugeno.ab.ab d;
    private JSONObject ka;
    private boolean x;

    @Override // com.bytedance.sdk.openadsdk.core.widget.ah
    protected void xr() {
    }

    public zb(Activity activity, JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.ugeno.ab.ab abVar) {
        super(activity);
        this.ah = activity == null ? null : activity.getWindow();
        this.ka = jSONObject;
        this.d = abVar;
        this.c = new com.bytedance.sdk.openadsdk.core.ugeno.x(activity);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ah, android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ah
    public void ms() {
        if (this.f3695ms == null) {
            this.f3695ms = re.getContext();
        }
        if (this.f3695ms.getResources().getConfiguration().orientation != 1) {
            this.x = true;
            super.ms();
            super.xr();
            ab();
            return;
        }
        ka();
        c();
    }

    private void ka() {
        if (this.ah != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            this.ah.setBackgroundDrawable(gradientDrawable);
            WindowManager.LayoutParams attributes = this.ah.getAttributes();
            attributes.alpha = 1.0f;
            this.ah.setAttributes(attributes);
        }
    }

    private void c() {
        JSONObject jSONObject = this.ka;
        if (jSONObject == null || this.d == null) {
            return;
        }
        JSONObject jSONObjectXr = com.bytedance.sdk.openadsdk.core.ugeno.ch.xr(this.ka.remove("ugen_md5").toString(), jSONObject.remove("ugen_url").toString());
        if (jSONObjectXr == null) {
            this.d.ms(11, "uegnTemplate is empty");
            this.ab = true;
        } else {
            final FrameLayout frameLayout = new FrameLayout(this.f3695ms);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.c.ms(jSONObjectXr, this.ka, new com.bytedance.sdk.openadsdk.core.ugeno.ab.ab() { // from class: com.bytedance.sdk.openadsdk.core.widget.zb.1
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
                public void ms(int i, String str) {
                    zb.this.ab = true;
                    if (zb.this.d != null) {
                        FrameLayout frameLayout2 = frameLayout;
                        if (frameLayout2 != null) {
                            frameLayout2.removeAllViews();
                        }
                        zb.this.d.ms(i, str);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
                public void ms(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
                    zb.this.ab = false;
                    if (zb.this.d != null) {
                        zb.this.d.ms(null);
                    }
                    frameLayout.addView(ahVar.ny(), new FrameLayout.LayoutParams(ahVar.pc(), ahVar.jw()));
                    zb.this.setContentView(frameLayout);
                }
            });
        }
    }

    private void ab() {
        JSONObject jSONObject = this.ka;
        if (jSONObject == null) {
            return;
        }
        ms(jSONObject.optString("app_name"));
        ka(this.ka.optString("app_version"));
        c(this.ka.optString("reg_number"));
        ab(this.ka.optString("reg_url"));
        xr(this.ka.optString("icon_url"));
        x(this.ka.optString("developer_name"));
        ms(this.ka.optInt("score"));
        ms(this.ka.optJSONArray("creative_tags"));
        d(this.ka.optString(BundleKey.DESCRIPTION));
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ah
    protected void ah() {
        if (this.x) {
            super.ah();
        }
    }

    public void xr(ah.ms msVar) {
        super.ms(msVar);
        com.bytedance.sdk.openadsdk.core.ugeno.x xVar = this.c;
        if (xVar != null) {
            xVar.ms(msVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.ah, android.app.Dialog
    public void show() {
        super.show();
        if (this.ab) {
            hide();
            dismiss();
        }
    }
}
