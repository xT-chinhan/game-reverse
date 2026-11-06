package com.bytedance.adsdk.ugeno.widget.xr;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.widget.image.RoundImageView;
import com.bytedance.adsdk.ugeno.widget.image.xr;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ms extends xr {
    private int gs;

    public abstract String x(String str);

    public ms(Context context) {
        super(context);
        this.gs = ViewCompat.MEASURED_STATE_MASK;
    }

    @Override // com.bytedance.adsdk.ugeno.widget.image.xr, com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        this.f411ms = ch(this.f411ms);
        super.xr();
        ((RoundImageView) this.ka).setColorFilter(this.gs);
        ((RoundImageView) this.ka).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    private String ch(String str) {
        String strX = x(str);
        return TextUtils.isEmpty(strX) ? "" : "local://".concat(String.valueOf(strX));
    }

    @Override // com.bytedance.adsdk.ugeno.widget.image.xr, com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        super.ms(str, str2);
        str.hashCode();
        if (str.equals("textColor")) {
            this.gs = com.bytedance.adsdk.ugeno.c.ms.ms(str2);
        }
    }
}
