package com.bytedance.sdk.openadsdk.core.ugeno.component.ah;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.xr.ah;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ah<UpieImageView> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected ImageView.ScaleType f3425ms;
    protected boolean vf;

    public ms(Context context) {
        super(context);
        this.f3425ms = ImageView.ScaleType.FIT_XY;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public UpieImageView ms() {
        return new UpieImageView(this.xr, null, null);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.f3425ms = x(str2);
                break;
            case "isBgGaussianBlur":
                this.vf = com.bytedance.adsdk.ugeno.c.ah.ms(str2, false);
                break;
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
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        lm lmVarMs = com.bytedance.sdk.openadsdk.core.ms.ms(this.d);
        if (lmVarMs != null) {
            ((UpieImageView) this.ka).ms(com.bytedance.sdk.openadsdk.ka.ms.ms(lmVarMs, this.d), com.bytedance.sdk.openadsdk.ka.ms.ch(lmVarMs));
            ((UpieImageView) this.ka).setScaleType(this.f3425ms);
        }
    }
}
