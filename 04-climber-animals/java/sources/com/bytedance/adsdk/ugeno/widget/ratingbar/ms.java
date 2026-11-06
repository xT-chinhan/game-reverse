package com.bytedance.adsdk.ugeno.widget.ratingbar;

import android.content.Context;
import android.graphics.Color;
import com.bytedance.adsdk.ugeno.xr.ah;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ah<UGRatingBar> {
    private static final int nl = Color.parseColor("#FFC642");
    private static final int qo = Color.parseColor("#e3e3e4");
    private float gs;
    private float kl;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f425ms;
    private float r;
    private int vf;

    public ms(Context context) {
        super(context);
        this.f425ms = nl;
        this.vf = qo;
        this.kl = 4.0f;
        this.gs = 20.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public UGRatingBar ms() {
        UGRatingBar uGRatingBar = new UGRatingBar(this.xr);
        uGRatingBar.ms(this);
        return uGRatingBar;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        if (cv()) {
            ((UGRatingBar) this.ka).ms(this.kl, this.f425ms, this.vf, this.gs, (int) this.r);
        } else {
            ((UGRatingBar) this.ka).ms(this.kl, this.f425ms, this.vf, this.gs, 5);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "highLightColor":
            case "highlightColor":
                this.f425ms = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
                break;
            case "lowLightColor":
            case "lowlightColor":
                this.vf = com.bytedance.adsdk.ugeno.c.ms.ms(str2, qo);
                break;
            case "gap":
                this.r = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case "size":
                this.gs = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 20.0f);
                break;
            case "score":
                this.kl = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 4.0f);
                break;
        }
    }
}
