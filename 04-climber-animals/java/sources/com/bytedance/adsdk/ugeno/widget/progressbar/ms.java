package com.bytedance.adsdk.ugeno.widget.progressbar;

import android.content.Context;
import com.bytedance.adsdk.ugeno.c.x;
import com.bytedance.adsdk.ugeno.xr.ah;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ah<UGProgressBar> {
    private int gs;
    private String kl;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f423ms;
    private float nl;
    private float r;
    private int vf;

    public ms(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public UGProgressBar ms() {
        UGProgressBar uGProgressBar = new UGProgressBar(this.xr);
        uGProgressBar.ms(this);
        return uGProgressBar;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        ((UGProgressBar) this.ka).setBackgroundColor(this.vf);
        ((UGProgressBar) this.ka).setText(this.kl);
        ((UGProgressBar) this.ka).setProgressBgColor(this.vf);
        ((UGProgressBar) this.ka).setProgressColor(this.f423ms);
        ((UGProgressBar) this.ka).setTextColor(this.gs);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "progressBgColor":
                this.vf = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
                break;
            case "textColor":
                this.gs = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
                break;
            case "textSize":
                this.r = x.ms(this.xr, str2);
                break;
            case "progress":
                this.nl = com.bytedance.adsdk.ugeno.c.ah.ms(str2, 0.0f);
                break;
            case "text":
                this.kl = str2;
                break;
            case "progressColor":
                this.f423ms = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
                break;
        }
    }
}
