package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.adsdk.ugeno.d;

/* JADX INFO: loaded from: classes2.dex */
public class xr extends com.bytedance.adsdk.ugeno.xr.ah<CycleCountDownView> {
    private String gs;
    private String kl;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private String f3429ms;
    private String vf;

    public xr(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    /* JADX INFO: renamed from: ab, reason: merged with bridge method [inline-methods] */
    public CycleCountDownView ms() {
        return new CycleCountDownView(this.xr);
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void xr() {
        super.xr();
    }

    @Override // com.bytedance.adsdk.ugeno.xr.ah
    public void ms(String str, String str2) {
        super.ms(str, str2);
        str.hashCode();
        switch (str) {
            case "boxImage":
                ((CycleCountDownView) this.ka).setBoxImage(null);
                d.ms().xr().ms(this.ny, str2, new com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xr.1
                    @Override // com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms
                    public void ms(Bitmap bitmap) {
                        ((CycleCountDownView) xr.this.ka).setBoxImage(bitmap);
                    }
                });
                break;
            case "before":
                this.f3429ms = str2;
                break;
            case "finish":
                this.gs = str2;
                break;
            case "text":
                this.kl = str2;
                break;
            case "after":
                this.vf = str2;
                break;
            case "boxFinishImage":
                d.ms().xr().ms(this.ny, str2, new com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.xr.2
                    @Override // com.bytedance.adsdk.ugeno.ms.InterfaceC0196ms
                    public void ms(Bitmap bitmap) {
                        ((CycleCountDownView) xr.this.ka).setBoxFinish(bitmap);
                    }
                });
                break;
        }
        ((CycleCountDownView) this.ka).ms(this.f3429ms, this.vf, this.kl, this.gs);
    }

    public void ms(int i, int i2, int i3, boolean z) {
        if (this.ka != 0) {
            ((CycleCountDownView) this.ka).ms(i, i2, i3);
            ((CycleCountDownView) this.ka).setCanSkip(z);
            ((CycleCountDownView) this.ka).setClickable(z);
            ((CycleCountDownView) this.ka).setEnabled(z);
        }
    }
}
