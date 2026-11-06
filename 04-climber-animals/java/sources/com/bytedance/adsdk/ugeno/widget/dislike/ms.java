package com.bytedance.adsdk.ugeno.widget.dislike;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.c.x;
import com.bytedance.adsdk.ugeno.xr.ah;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ah<DislikeView> {
    private int kl;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f405ms;
    private int vf;

    public ms(Context context) {
        super(context);
        this.f405ms = 0;
        this.kl = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public DislikeView ms() {
        DislikeView dislikeView = new DislikeView(this.xr);
        dislikeView.ms(this);
        return dislikeView;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        ((DislikeView) this.ka).setRadius(this.eg);
        ((DislikeView) this.ka).setStrokeWidth((int) this.ti);
        ((DislikeView) this.ka).setDislikeColor(this.f405ms);
        ((DislikeView) this.ka).setStrokeColor(this.s);
        ((DislikeView) this.ka).setDislikeWidth(this.vf);
        ((DislikeView) this.ka).setBgColor(this.kl);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "dislikeColor":
                this.f405ms = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
                break;
            case "dislikeWidth":
                this.vf = (int) x.ms(this.xr, Integer.parseInt(str2));
                break;
            case "dislikeFillColor":
                this.kl = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
                break;
        }
    }
}
