package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.widget.text.UGTextView;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends com.bytedance.adsdk.ugeno.widget.text.xr {
    private String gs;
    protected String kl;
    private String r;

    public ms(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.xr, com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        if (TextUtils.isEmpty(this.r) || TextUtils.equals(this.r, AbstractJsonLexerKt.NULL)) {
            this.r = "";
        }
        if (TextUtils.isEmpty(this.gs) || TextUtils.equals(this.gs, AbstractJsonLexerKt.NULL)) {
            this.gs = "";
        }
        this.f430ms = this.gs + this.r;
        ny(this.f430ms);
        ((UGTextView) this.ka).setGravity(17);
    }

    public void ms(int i, int i2, int i3) {
        if (i <= 0 && !TextUtils.isEmpty(this.kl)) {
            this.f430ms = this.kl;
            ny(this.f430ms);
            return;
        }
        if (TextUtils.isEmpty(this.r) || TextUtils.equals(this.r, AbstractJsonLexerKt.NULL)) {
            this.r = "";
        }
        if (TextUtils.isEmpty(this.gs) || TextUtils.equals(this.gs, AbstractJsonLexerKt.NULL)) {
            this.gs = "";
        }
        this.f430ms = this.gs + i + this.r;
        ny(this.f430ms);
    }

    protected void ny(String str) {
        ((UGTextView) this.ka).setText(str);
        try {
            float fMeasureText = ((UGTextView) this.ka).getPaint().measureText(str);
            if (fMeasureText >= 0.0f) {
                d((int) fMeasureText);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.widget.text.xr, com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "before":
                this.gs = str2;
                break;
            case "finish":
                this.kl = str2;
                break;
            case "after":
                this.r = str2;
                break;
        }
    }
}
