package com.bytedance.sdk.openadsdk.core.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class x extends AlertDialog {
    private com.bytedance.sdk.openadsdk.core.ugeno.ab.ab ab;
    private Context ah;
    private com.bytedance.sdk.openadsdk.core.ugeno.ms c;
    private ab.ms d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private JSONObject f3745ms;
    private boolean x;
    private JSONObject xr;

    public x(String str, Context context, JSONObject jSONObject, JSONObject jSONObject2, com.bytedance.sdk.openadsdk.core.ugeno.ab.ab abVar, lm lmVar) {
        super(context, t.ab(context, "tt_dialog_full"));
        this.ab = abVar;
        this.ah = context;
        this.f3745ms = jSONObject;
        this.ka = str;
        this.xr = jSONObject2;
        this.c = new com.bytedance.sdk.openadsdk.core.ugeno.ms(context, lmVar);
    }

    public String ms() {
        return this.ka;
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        if (this.x) {
            hide();
            dismiss();
        }
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xr();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        ab.ms msVar = this.d;
        if (msVar != null) {
            msVar.ah(this);
        }
    }

    public void ms(ab.ms msVar) {
        this.d = msVar;
        com.bytedance.sdk.openadsdk.core.ugeno.ms msVar2 = this.c;
        if (msVar2 != null) {
            msVar2.ms(msVar);
        }
    }

    public void ms(com.bytedance.sdk.openadsdk.core.ugeno.ab.ab abVar) {
        this.ab = abVar;
    }

    private void xr() {
        if (this.f3745ms == null || this.xr == null || this.c == null) {
            return;
        }
        this.x = false;
        final FrameLayout frameLayout = new FrameLayout(this.ah);
        this.c.ms(this.f3745ms, this.xr, new com.bytedance.sdk.openadsdk.core.ugeno.ab.ab() { // from class: com.bytedance.sdk.openadsdk.core.widget.x.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
            public void ms(int i, String str) {
                x.this.x = true;
                if (x.this.ab != null) {
                    FrameLayout frameLayout2 = frameLayout;
                    if (frameLayout2 != null) {
                        frameLayout2.removeAllViews();
                    }
                    x.this.ab.ms(i, str);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ab
            public void ms(com.bytedance.adsdk.ugeno.xr.ah<View> ahVar) {
                x.this.x = false;
                if (x.this.ab != null) {
                    x.this.ab.ms(null);
                }
                frameLayout.addView(ahVar.ny(), new FrameLayout.LayoutParams(ahVar.pc(), ahVar.jw()));
                x.this.setContentView(frameLayout);
            }
        });
    }
}
