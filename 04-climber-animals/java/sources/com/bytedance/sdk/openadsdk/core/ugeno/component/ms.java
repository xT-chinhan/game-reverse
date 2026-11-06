package com.bytedance.sdk.openadsdk.core.ugeno.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.c.d;
import com.bytedance.adsdk.ugeno.widget.image.RoundImageView;
import com.bytedance.adsdk.ugeno.xr.ah;
import com.bytedance.sdk.component.c.ao;
import com.bytedance.sdk.component.c.hi;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.op.ab;
import com.bytedance.sdk.openadsdk.x.xr;

/* JADX INFO: loaded from: classes2.dex */
public class ms extends ah<RoundImageView> {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected String f3476ms;
    protected int vf;

    public ms(Context context) {
        super(context);
        this.vf = 25;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
        x();
        ((RoundImageView) this.ka).setScaleType(ImageView.ScaleType.FIT_XY);
        ((RoundImageView) this.ka).setBorderColor(this.s);
        ((RoundImageView) this.ka).setCornerRadius(this.eg);
        ((RoundImageView) this.ka).setBorderWidth(this.ti);
    }

    private void x() {
        if (TextUtils.isEmpty(this.f3476ms)) {
            return;
        }
        ((RoundImageView) this.ka).setImageDrawable(null);
        if (this.f3476ms.startsWith("local://")) {
            ab.ms(new ny("UG_decode_img") { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.ms.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(ms.this.xr.getResources(), d.xr(ms.this.xr, ms.this.f3476ms.replace("local://", "")));
                    if (bitmapDecodeResource != null) {
                        ms.this.ms(bitmapDecodeResource);
                    }
                }
            });
        } else {
            xr.ms(this.f3476ms).ah(2).ms(new ao() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.ms.2
                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(1)
                public void ms(hi hiVar) {
                    Object objAh = hiVar.ah();
                    if (objAh == null || !(objAh instanceof Bitmap)) {
                        return;
                    }
                    ms.this.ms((Bitmap) objAh);
                }

                @Override // com.bytedance.sdk.component.c.ao
                @ATSMethod(2)
                public void ms(int i, String str, Throwable th) {
                    sl.xr("UGBlurWidget", str, th);
                }
            }, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(Bitmap bitmap) {
        final Bitmap bitmapMs = com.bytedance.sdk.component.adexpress.d.xr.ms(this.xr, bitmap, 25);
        if (bitmapMs != null) {
            ab.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.ms.3
                @Override // java.lang.Runnable
                public void run() {
                    if (ms.this.ka != null) {
                        ((RoundImageView) ms.this.ka).setImageBitmap(bitmapMs);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public RoundImageView ms() {
        RoundImageView roundImageView = new RoundImageView(this.xr);
        roundImageView.ms(this);
        return roundImageView;
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        super.ms(str, str2);
        str.hashCode();
        if (!str.equals("blurRate")) {
            if (str.equals("src")) {
                this.f3476ms = str2;
            }
        } else {
            try {
                this.vf = Integer.parseInt(str2);
            } catch (Exception e) {
                sl.xr("UGBlurWidget", e);
            }
        }
    }
}
