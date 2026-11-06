package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.view.FullRewardExpressView;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.op;
import com.bytedance.sdk.openadsdk.core.jw.pc;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.yu;
import com.bytedance.sdk.openadsdk.core.nw.fm;
import com.bytedance.sdk.openadsdk.core.nw.hi;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    private com.bytedance.sdk.openadsdk.core.nativeexpress.ka ab;
    protected final String ah;
    private c c;
    private ViewGroup ch;
    public boolean d;
    private boolean hi;
    private int ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final TTBaseVideoActivity f2159ms;
    private com.bytedance.sdk.openadsdk.core.hi.xr.ah ny;
    private long sl;
    private final boolean u;
    private boolean ub;
    private com.bytedance.sdk.openadsdk.core.xr.ms x;
    protected final lm xr;
    private final AtomicBoolean zb = new AtomicBoolean(false);

    public xr(final TTBaseVideoActivity tTBaseVideoActivity, lm lmVar, String str, boolean z, boolean z2) {
        this.ny = null;
        this.f2159ms = tTBaseVideoActivity;
        this.xr = lmVar;
        this.ah = str;
        this.u = z;
        this.ub = z2;
        c cVar = new c(tTBaseVideoActivity, lmVar, str, f.xr(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.xr.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c, com.bytedance.sdk.openadsdk.core.xr.xr, com.bytedance.sdk.openadsdk.core.xr.d
            public void ms(View view, hi hiVar) {
                super.ms(view, hiVar);
                tTBaseVideoActivity.ms(2);
            }
        };
        this.c = cVar;
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) cVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(tTBaseVideoActivity.eg());
        com.bytedance.sdk.openadsdk.core.nativeexpress.ka kaVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.ka(tTBaseVideoActivity, lmVar, str, f.xr(str)) { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.xr.2
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.ka, com.bytedance.sdk.openadsdk.core.xr.xr, com.bytedance.sdk.openadsdk.core.xr.d
            public void ms(View view, hi hiVar) {
                super.ms(view, hiVar);
                com.bytedance.sdk.openadsdk.core.xr.ms.xr xrVar = (com.bytedance.sdk.openadsdk.core.xr.ms.xr) this.x.ms(com.bytedance.sdk.openadsdk.core.xr.ms.xr.class);
                if (xrVar == null || !xrVar.xr(view)) {
                    return;
                }
                tTBaseVideoActivity.ms(2);
            }
        };
        this.ab = kaVar;
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) kaVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(tTBaseVideoActivity.eg());
        com.bytedance.sdk.openadsdk.core.xr.ms msVar = new com.bytedance.sdk.openadsdk.core.xr.ms(tTBaseVideoActivity, lmVar, str, 7);
        this.x = msVar;
        tTBaseVideoActivity.ms((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah) msVar.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ah.class));
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms) this.x.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ah.ms.class)).ms(tTBaseVideoActivity.eg());
        if (lmVar.jr() == 4) {
            this.ny = com.bytedance.sdk.openadsdk.core.hi.ka.ms((Context) tTBaseVideoActivity, lmVar, str, false);
            final String strDf = ms().df();
            this.ny.ms(new com.bytedance.sdk.openadsdk.core.hi.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.xr.3
                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void ms() {
                    com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void ms(long j, long j2, String str2, String str3) {
                    if (j > 0) {
                        com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 3, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void xr(long j, long j2, String str2, String str3) {
                    if (j > 0) {
                        com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 2, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void ah(long j, long j2, String str2, String str3) {
                    if (j > 0) {
                        com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 4, (int) ((j2 * 100) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void ms(long j, String str2, String str3) {
                    com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.core.hi.xr.ms
                public void ms(String str2, String str3) {
                    com.bytedance.sdk.openadsdk.core.ao.ms.C0265ms.ms(strDf, 6, 100);
                }
            });
        }
    }

    public lm ms() {
        return this.xr;
    }

    public String xr() {
        return this.ah;
    }

    public com.bytedance.sdk.openadsdk.core.xr.ms ah() {
        return this.x;
    }

    public int d() {
        if (this.hi) {
            int iXr = fm.xr(this.xr) - this.ka;
            this.ka = fm.xr(this.xr);
            return iXr;
        }
        if (this.ka >= fm.xr(this.xr)) {
            return 0;
        }
        this.ka++;
        return 1;
    }

    public void ms(ViewGroup viewGroup, ViewGroup viewGroup2, FullRewardExpressView fullRewardExpressView) {
        this.ch = viewGroup2;
        if (viewGroup == null || fullRewardExpressView == null || ms() == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.ny;
        if (ahVar != null) {
            ahVar.x();
            if (fullRewardExpressView.getContext() != null && (fullRewardExpressView.getContext() instanceof Activity)) {
                this.ny.ms((Activity) fullRewardExpressView.getContext());
            }
        }
        this.c.ms(fullRewardExpressView);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.c.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.ny);
        fullRewardExpressView.setClickListener(this.c);
        this.ab.ms(fullRewardExpressView);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.ab.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.ny);
        fullRewardExpressView.setClickCreativeListener(this.ab);
        this.x.ms(viewGroup);
        ((com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr) this.x.ms(com.bytedance.sdk.openadsdk.core.xr.ms.ms.xr.class)).ms(this.ny);
        ab();
        ImageView imageView = new ImageView(this.f2159ms);
        com.bytedance.sdk.openadsdk.x.xr.ms(this.xr.fk().get(0)).ms(imageView);
        this.ch.addView(imageView);
    }

    public com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms ka() {
        return new com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.xr.4
            @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
            public void ah() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
            public void ms() {
                xr.this.hi = true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
            public void ms(int i, String str) {
                xr.this.x();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
            public void xr() {
                xr.this.x();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.xr.ms.InterfaceC0325ms
            public void ms(long j, long j2) {
                ul.ms((View) xr.this.ch, 8);
                xr.this.sl = j;
            }
        };
    }

    public void ms(boolean z) {
        this.d = z;
    }

    public boolean c() {
        return this.d;
    }

    public void ab() {
        if (this.ub) {
            return;
        }
        this.ub = true;
        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarMs = op.ms(7);
        if (qr.u(this.xr) != null) {
            com.bykv.vk.openvk.component.video.api.ah.d dVarMs = qr.ms(1, this.xr);
            dVarMs.ms("material_meta", this.xr);
            dVarMs.ms("ad_slot", Integer.valueOf(xrVarMs != null ? xrVarMs.t() : 0));
            com.bytedance.sdk.openadsdk.core.video.d.xr.ms(dVarMs, (com.bykv.vk.openvk.component.video.api.ka.ms.InterfaceC0178ms) null);
        }
    }

    public void x() {
        ul.ms((View) this.ch, 0);
        this.f2159ms.u();
    }

    public void ny() {
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVar = this.ny;
        if (ahVar != null) {
            ahVar.ny();
        }
        lm lmVar = this.xr;
        pc.xr(lmVar != null ? lmVar.ka() : 0);
    }

    public void ms(NativeExpressView nativeExpressView) {
        if (this.zb.getAndSet(true)) {
            return;
        }
        Map<String, Object> mapEg = this.f2159ms.eg();
        yu.ms(mapEg, this.xr, nativeExpressView);
        com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.xr, this.ah, mapEg, this.f2159ms.fm());
        com.bytedance.sdk.openadsdk.core.op.ms.ms().d();
        lm lmVar = this.xr;
        pc.ms(lmVar != null ? lmVar.ka() : 0);
    }

    public void ch() {
        if (this.u) {
            this.f2159ms.ms(this.xr, this.x);
        }
    }

    public com.bykv.vk.openvk.component.video.api.ah.d hi() {
        com.bykv.vk.openvk.component.video.api.ah.d dVarMs = qr.ms(1, this.xr);
        dVarMs.xr(this.xr.df());
        dVarMs.xr(100);
        dVarMs.ah(100);
        dVarMs.ah(this.xr.lx());
        dVarMs.xr(this.d);
        return dVarMs;
    }

    public long sl() {
        return this.sl;
    }

    public void xr(boolean z) {
        this.xr.sl(z);
    }
}
