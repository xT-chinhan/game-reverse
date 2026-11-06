package com.bytedance.sdk.openadsdk.core.ugeno.component.gif;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.c.d;
import com.bytedance.adsdk.ugeno.xr.ah;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ah<UgenGif> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected String f3433ms;
    protected ImageView.ScaleType vf;

    public ms(Context context) {
        super(context);
        this.vf = ImageView.ScaleType.FIT_CENTER;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public UgenGif ms() {
        this.ka = new UgenGif(this.xr);
        ((UgenGif) this.ka).ms(this);
        return (UgenGif) this.ka;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        x();
        ((UgenGif) this.ka).setScaleType(this.vf);
    }

    private void x() {
        if (TextUtils.isEmpty(this.f3433ms)) {
            return;
        }
        if (this.f3433ms.startsWith("local://")) {
            ((UgenGif) this.ka).ms(d.ms(this.xr, this.f3433ms.replace("local://", "")), false);
        } else {
            com.bytedance.adsdk.ugeno.d.ms().xr().ms(this.ny, this.f3433ms, (ImageView) this.ka);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        super.ms(str, str2);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        str.hashCode();
        if (str.equals("scaleType")) {
            this.vf = x(str2);
        } else if (str.equals("src")) {
            this.f3433ms = str2;
        }
    }

    private ImageView.ScaleType x(String str) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            default:
                return scaleType;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah, com.bytedance.adsdk.ugeno.ah
    public void ka() {
        super.ka();
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah, com.bytedance.adsdk.ugeno.ah
    public void ms(boolean z) {
        super.ms(z);
        if (z) {
            xr();
        }
    }
}
