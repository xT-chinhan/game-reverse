package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.component.video.api.d.ah;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.op.ch;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class NativeVideoView extends NativeVideoTsView implements ah.ms {
    private boolean b;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private int f3483ms;
    private com.bytedance.adsdk.ugeno.ah nw;
    private ms xr;

    public NativeVideoView(Context context) {
        super(context);
        if (this.ka != null) {
            this.ka.ms(true);
        }
        this.t.set(true);
        setNeedNativeVideoPlayBtnVisible(false);
        setEnableBlur(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected void A_() {
        super.A_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    protected ah ms(Context context, ViewGroup viewGroup, lm lmVar, String str, boolean z, boolean z2, boolean z3) {
        ms msVar = new ms(context, viewGroup, lmVar, str, z, z2, z3);
        this.xr = msVar;
        return msVar;
    }

    public void setPlayerType(int i) {
        this.f3483ms = i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void d() {
        if (this.ka == null) {
            A_();
        } else if ((this.ka instanceof d) && !ao()) {
            ((d) this.ka).eg();
        }
        if (this.ka == null || !this.t.get()) {
            return;
        }
        this.t.set(false);
        ab();
        if (u()) {
            ul.ms((View) this.ch, 0);
            if (this.sl != null) {
                ul.ms((View) this.sl, 8);
            }
            if (qr.u(this.d) != null) {
                com.bykv.vk.openvk.component.video.api.ah.d dVarMs = qr.ms(4, this.d);
                dVarMs.xr(this.d.df());
                dVarMs.xr(this.c.getWidth());
                dVarMs.ah(this.c.getHeight());
                dVarMs.ah(this.d.lx());
                this.d.tz(this.f3483ms);
                dVarMs.ka(this.f3483ms);
                dVarMs.ms(ch.ms(this.d));
                dVarMs.ms(this.ka.hi());
                dVarMs.xr(this.ka.y());
                ((d) this.ka).ka(this.f3483ms);
                ((d) this.ka).ms(this.d);
                ms(dVarMs);
                this.ka.ah(false);
                return;
            }
            sl.d("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            return;
        }
        if (this.ka.t()) {
            ul.ms((View) this.ch, 0);
            return;
        }
        sl.ms("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
        hi();
        ul.ms((View) this.ch, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void ka() {
        super.ka();
        ul.ms((View) this.ch, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public void setIsAutoPlay(boolean z) {
        super.setIsAutoPlay(z);
        ul.ms((View) this.ch, 0);
    }

    public void ms(boolean z, boolean z2) {
        hi();
        ul.ms((View) this.ch, 0);
        ul.ms((View) this.zb, z ? 0 : 8);
        ul.ms((View) this.hi, z2 ? 0 : 8);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.ah ahVar = this.nw;
        if (ahVar != null) {
            int[] iArrMs = ahVar.ms(i, i2);
            super.onMeasure(iArrMs[0], iArrMs[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView
    public boolean ms(long j, boolean z, boolean z2) {
        this.c.setVisibility(0);
        if (this.ka == null) {
            this.ka = new d(getContext(), this.ab, this.d, this.ub, false, false);
        }
        if (sl() || this.ny) {
            ms(this.ah, 25, qr.xr(this.d));
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, com.bytedance.sdk.openadsdk.core.video.nativevideo.d.ms
    public void B_() {
        ul.ms((View) this.ch, 8);
        super.B_();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, com.bykv.vk.openvk.component.video.api.d.ah.ms
    public void xr(long j, int i) {
        super.xr(j, i);
        ul.ms((View) this.ch, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (!this.b && i == 8) {
            ka();
        }
    }

    public void setExtraMap(Map<String, Object> map) {
        if (this.ka != null) {
            this.ka.xr(map);
        }
    }

    public void N_() {
        ms msVar = this.xr;
        if (msVar != null) {
            msVar.x();
            ul.ms((View) this.ch, 8);
        }
    }

    public void x() {
        ms msVar = this.xr;
        if (msVar != null) {
            msVar.c();
        }
    }

    public void setLp(boolean z) {
        this.b = z;
    }

    public void ms(com.bytedance.adsdk.ugeno.ah ahVar) {
        this.nw = ahVar;
    }
}
