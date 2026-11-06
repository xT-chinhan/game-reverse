package com.bytedance.sdk.openadsdk.core.component.ms;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.ao.xr.xr.zb;
import com.bytedance.sdk.openadsdk.c.ah.h;
import com.bytedance.sdk.openadsdk.core.b.d;
import com.bytedance.sdk.openadsdk.core.ch;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.pc;
import com.bytedance.sdk.openadsdk.core.live.EcMallWebView;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.ul;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.mediation.MediationNativeManagerDefault;
import com.bytedance.sdk.openadsdk.op.ab;
import com.bytedance.sdk.openadsdk.res.layout.LazeLayout;
import com.bytedance.sdk.openadsdk.upie.image.lottie.UpieImageView;
import com.uc.crashsdk.export.LogType;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ah extends com.bytedance.sdk.openadsdk.ao.xr.xr implements com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah, com.bykv.vk.openvk.component.video.api.d.ah.d, com.bykv.vk.openvk.component.video.api.xr.ms, com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms, LazeLayout.ms<NativeVideoTsView>, com.bytedance.sdk.openadsdk.res.layout.ms<NativeVideoTsView> {
    private int ab;
    int ah;
    private lm ao;
    private d c;
    private LazeLayout ch;
    private int[] d;
    private com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms h;
    private volatile WeakReference<NativeVideoTsView> hi;
    private com.bytedance.sdk.openadsdk.b.ms.xr.ms.ms ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected com.bytedance.sdk.openadsdk.core.multipro.xr.ms f2045ms;
    private boolean ny;
    private WeakReference<View> sl;
    private volatile int u;
    private volatile boolean ub;
    private com.bytedance.sdk.openadsdk.b.ms.xr.xr.ms x;
    com.bytedance.sdk.openadsdk.ao.xr.ah.xr xr;
    private com.bytedance.sdk.openadsdk.b.ms.xr.ms.xr zb;

    ah(Context context, lm lmVar, int i, com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVar) {
        super(new d(context, lmVar, i, xrVar, true));
        this.d = null;
        this.ny = false;
        this.ch = null;
        this.hi = null;
        this.sl = null;
        this.h = new com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms(null) { // from class: com.bytedance.sdk.openadsdk.core.component.ms.ah.4
            @Override // com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms
            public void ms(zb zbVar) {
            }

            @Override // com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms
            public void ms(View view, zb zbVar) {
                if (ah.this.hi == null || ah.this.hi.get() == null) {
                    return;
                }
                ((NativeVideoTsView) ah.this.hi.get()).ch();
            }

            @Override // com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms
            public void xr(View view, zb zbVar) {
                if (ah.this.hi == null || ah.this.hi.get() == null) {
                    return;
                }
                ((NativeVideoTsView) ah.this.hi.get()).ch();
            }
        };
        d dVar = (d) nw();
        this.c = dVar;
        dVar.i().ms(this);
        this.ah = i;
        this.xr = xrVar;
        this.f2045ms = new com.bytedance.sdk.openadsdk.core.multipro.xr.ms();
        this.ao = lmVar;
        int iNy = f.ny(lmVar);
        this.ab = iNy;
        ms(iNy);
        this.c.ms(this.h);
    }

    public NativeVideoTsView c() {
        if (this.hi != null) {
            return this.hi.get();
        }
        return null;
    }

    public int l_() {
        return this.ah;
    }

    public int x() {
        return this.ab;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms
    public boolean m_() {
        return this.ny;
    }

    public NativeVideoTsView ms(boolean z) {
        NativeVideoTsView nativeVideoTsView;
        if (z) {
            nativeVideoTsView = new NativeDrawVideoTsView(this.c.getContext(), this.c.w());
        } else {
            nativeVideoTsView = new NativeVideoTsView(this.c.getContext(), this.c.w(), false, false, f.xr(this.ah), false, false);
        }
        this.hi = new WeakReference<>(nativeVideoTsView);
        this.c.ms(this.hi);
        this.c.ka();
        return nativeVideoTsView;
    }

    private View i() {
        View view;
        WeakReference<View> weakReference = this.sl;
        if (weakReference != null && (view = weakReference.get()) != null) {
            return view;
        }
        EcMallWebView ecMallWebView = new EcMallWebView(this.c.getContext(), this.c.w(), this.ah == 9 ? 6 : 1);
        ecMallWebView.setMaterialMeta(pc.ms(this.ao));
        this.sl = new WeakReference<>(ecMallWebView);
        return ecMallWebView;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public View ms() {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsViewXr = null;
        if (this.c.w() == null || this.c.getContext() == null) {
            return null;
        }
        if (com.bytedance.sdk.openadsdk.core.live.ka.d.ms(this.c.w())) {
            return i();
        }
        Context context = this.c.getContext();
        if (n_()) {
            if (ab.ms() && re.xr().yy().xr) {
                if (this.hi != null && (nativeVideoTsView = this.hi.get()) != null) {
                    return nativeVideoTsView;
                }
                this.ch = new LazeLayout(context, this, this);
            } else {
                try {
                    nativeVideoTsViewXr = xr(context);
                } catch (Throwable unused) {
                }
                if (nativeVideoTsViewXr != null) {
                    ms(nativeVideoTsViewXr);
                }
                return nativeVideoTsViewXr;
            }
        } else {
            lm lmVarW = this.c.w();
            if (context != null && lmVarW != null && com.bytedance.sdk.openadsdk.ka.ms.x(this.c.w())) {
                return new UpieImageView(context, com.bytedance.sdk.openadsdk.ka.ms.ny(lmVarW), null);
            }
        }
        com.bytedance.sdk.openadsdk.core.ab.d.ms().ms(this.c.w()).ms(this.ah).xr(this.ab);
        return this.ch;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.ms
    /* JADX INFO: renamed from: ms, reason: merged with bridge method [inline-methods] */
    public NativeVideoTsView xr(Context context) {
        NativeVideoTsView nativeVideoTsViewMs = ms(false);
        nativeVideoTsViewMs.setVideoAdClickListenerTTNativeAd(this);
        nativeVideoTsViewMs.setAdCreativeClickListener(new NativeVideoTsView.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.ms.ah.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.ms
            public void ms(View view, int i) {
                if (ah.this.c.i() != null) {
                    ah.this.c.i().ms(view, i);
                }
            }
        });
        ch.ub().ms(-1L);
        nativeVideoTsViewMs.setControllerStatusCallBack(new NativeVideoTsView.d() { // from class: com.bytedance.sdk.openadsdk.core.component.ms.ah.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.d
            public void ms(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                if (ah.this.f2045ms != null) {
                    ah.this.f2045ms.f2932ms = z;
                    ah.this.f2045ms.ka = j;
                    ah.this.f2045ms.c = j2;
                    ah.this.f2045ms.ab = j3;
                    ah.this.f2045ms.d = z2;
                    ah.this.f2045ms.x = z3;
                }
            }
        });
        nativeVideoTsViewMs.setVideoAdLoadListener(this);
        nativeVideoTsViewMs.setVideoAdInteractionListener(this);
        if (5 == this.ah) {
            nativeVideoTsViewMs.setIsAutoPlay(this.c.op() ? this.xr.ka() : this.c.yu());
        } else {
            nativeVideoTsViewMs.setIsAutoPlay(this.c.yu());
        }
        nativeVideoTsViewMs.setIsQuiet(re.xr().d(this.ab));
        com.bytedance.sdk.openadsdk.core.hi.xr.ah ahVarMs = this.c.i().ms();
        if (ahVarMs != null) {
            ahVarMs.ms(this);
        }
        return nativeVideoTsViewMs;
    }

    @Override // com.bytedance.sdk.openadsdk.res.layout.LazeLayout.ms
    public void ms(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.ms(0L, true, false);
        }
    }

    boolean n_() {
        return lm.xr(this.c.w());
    }

    private void ms(int i) {
        int iAb = re.xr().ab(i);
        if (3 == iAb) {
            this.c.xr(false);
            this.c.ms(false);
            return;
        }
        if (1 == iAb && u.d(this.c.getContext())) {
            this.c.xr(false);
        } else if (2 == iAb) {
            if (!u.ka(this.c.getContext()) && !u.d(this.c.getContext()) && !u.c(this.c.getContext())) {
                return;
            } else {
                this.c.xr(false);
            }
        } else if (4 == iAb) {
            this.c.xr(true);
            return;
        } else {
            if (5 != iAb) {
                return;
            }
            if (!u.d(this.c.getContext()) && !u.c(this.c.getContext())) {
                return;
            }
        }
        this.c.ms(true);
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ch
    public void ms(com.bytedance.sdk.openadsdk.b.ms.xr.ms.ms msVar) {
        this.ka = msVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ch
    public double k_() {
        if (com.bytedance.sdk.openadsdk.op.ch.ms(this.c.w())) {
            return 0.0d;
        }
        return qr.c(this.c.w());
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ch
    public int sl() {
        d dVar = this.c;
        if (dVar != null) {
            lm lmVarW = dVar.w();
            int iY = this.c.y();
            if (com.bytedance.sdk.openadsdk.ka.ms.x(lmVarW) && (iY == 5 || iY == 15)) {
                return lmVarW.fk().get(0).xr();
            }
        }
        try {
            if (this.d == null) {
                this.d = w();
            }
            int[] iArr = this.d;
            if (iArr != null && iArr.length >= 2) {
                return iArr[0];
            }
            return LogType.UNEXP_ANR;
        } catch (Throwable th) {
            sl.ah("TTFeedAdImpl", "getAdViewWidth error", th);
            return LogType.UNEXP_ANR;
        }
    }

    private int[] w() {
        if (this.c.w() == null) {
            return null;
        }
        if (this.c.w().kz() == 166 && ul.ms(this.c.w())) {
            return new int[]{ul.sl(this.c.w()), ul.zb(this.c.w())};
        }
        if (this.c.w().pd() == 1 && this.c.w().vx() == 1 && qr.ub(this.c.w()) != null) {
            return qr.ub(this.c.w()).ch();
        }
        if (qr.u(this.c.w()) != null) {
            return qr.u(this.c.w()).ch();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ch
    public int zb() {
        d dVar = this.c;
        if (dVar != null) {
            lm lmVarW = dVar.w();
            int iY = this.c.y();
            if (com.bytedance.sdk.openadsdk.ka.ms.x(lmVarW) && (iY == 5 || iY == 15)) {
                return lmVarW.fk().get(0).ah();
            }
        }
        try {
            if (this.d == null) {
                this.d = w();
            }
            int[] iArr = this.d;
            if (iArr != null && iArr.length >= 2) {
                return iArr[1];
            }
            return 720;
        } catch (Throwable th) {
            sl.ah("TTFeedAdImpl", "getAdViewHeight error", th);
            return 720;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ch
    public void ms(com.bytedance.sdk.openadsdk.b.ms.xr.ms.xr xrVar) {
        this.zb = xrVar;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.ch
    public com.bytedance.sdk.openadsdk.b.ms.xr.xr.ms u() {
        if (!lm.ms(this.c.w())) {
            return null;
        }
        if (this.x == null) {
            this.x = new com.bytedance.sdk.openadsdk.b.ms.xr.xr.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.ms.ah.3
                private long xr = 0;

                @Override // com.bytedance.sdk.openadsdk.b.ms.xr.xr.ms
                public String ms() {
                    if (ah.this.c.w() == null || ah.this.c.w().e() != 1 || qr.u(ah.this.c.w()) == null) {
                        return null;
                    }
                    if (!ah.this.ny) {
                        ah.this.ny = true;
                    }
                    return qr.ms(ah.this.c.w());
                }

                @Override // com.bytedance.sdk.openadsdk.b.ms.xr.xr.ms
                public void xr() {
                    this.xr = SystemClock.elapsedRealtime();
                    h.ms msVar = new h.ms();
                    msVar.xr(true);
                    msVar.ms(true);
                    com.bytedance.sdk.openadsdk.c.xr.d.ms(ah.this, msVar);
                }

                @Override // com.bytedance.sdk.openadsdk.b.ms.xr.xr.ms
                public void ms(long j) {
                    if (this.xr == 0) {
                        this.xr = SystemClock.elapsedRealtime();
                    }
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.xr) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    h.ms msVar = new h.ms();
                    msVar.ms(j);
                    msVar.ah(((long) ah.this.k_()) * 1000);
                    msVar.xr(j2);
                    msVar.ms(true);
                    com.bytedance.sdk.openadsdk.c.xr.d.ms(ah.this, msVar, -1);
                }

                @Override // com.bytedance.sdk.openadsdk.b.ms.xr.xr.ms
                public void xr(long j) {
                    if (this.xr == 0) {
                        this.xr = SystemClock.elapsedRealtime();
                    }
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.xr) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    h.ms msVar = new h.ms();
                    msVar.ms(j);
                    msVar.ah(((long) ah.this.k_()) * 1000);
                    msVar.xr(j2);
                    msVar.ms(true);
                    com.bytedance.sdk.openadsdk.c.xr.d.xr(ah.this, msVar);
                }

                @Override // com.bytedance.sdk.openadsdk.b.ms.xr.xr.ms
                public void ah() {
                    if (this.xr == 0) {
                        this.xr = SystemClock.elapsedRealtime();
                    }
                    long jK_ = ((long) ah.this.k_()) * 1000;
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.xr) - jK_;
                    long j = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    h.ms msVar = new h.ms();
                    msVar.ms(jK_);
                    msVar.ah(jK_);
                    msVar.xr(j);
                    msVar.c(0);
                    msVar.ms(true);
                    com.bytedance.sdk.openadsdk.c.xr.d.d(ah.this, msVar);
                }

                @Override // com.bytedance.sdk.openadsdk.b.ms.xr.xr.ms
                public void ah(long j) {
                    if (this.xr == 0) {
                        this.xr = SystemClock.elapsedRealtime();
                    }
                    long jK_ = ((long) ah.this.k_()) * 1000;
                    long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.xr) - j;
                    long j2 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    h.ms msVar = new h.ms();
                    msVar.ms(j);
                    msVar.ah(jK_);
                    msVar.xr(j2);
                    msVar.ka(0);
                    msVar.c(0);
                    msVar.ms(true);
                    com.bytedance.sdk.openadsdk.c.xr.d.ms(ah.this, msVar, (Map<String, Object>) null, -1);
                }

                @Override // com.bytedance.sdk.openadsdk.b.ms.xr.xr.ms
                public void d() {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(ah.this.c.w(), f.xr(ah.this.c.w()), "feed_auto_play", 0L, 0, (Map<String, Object>) null);
                    if (qr.u(ah.this.c.w()) != null) {
                        com.bykv.vk.openvk.component.video.api.ah.d dVarMs = qr.ms(4, ah.this.c.w());
                        dVarMs.ms("material_meta", ah.this.c.w());
                        com.bytedance.sdk.openadsdk.ao.xr.ah.xr xrVarRt = ah.this.c.w().rt();
                        dVarMs.ms("ad_slot", Integer.valueOf(xrVarRt != null ? xrVarRt.t() : 0));
                        dVarMs.ka(-1);
                        com.bytedance.sdk.openadsdk.c.xr.d.ms(ah.this.c.w(), (com.bykv.vk.openvk.component.video.api.xr.ms) ah.this, dVarMs, true);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.b.ms.xr.xr.ms
                public void ms(int i, int i2) {
                    HashMap map = new HashMap();
                    map.put("creative_id", ah.this.c.w().df());
                    map.put("error_code", Integer.valueOf(i));
                    map.put("extra_error_code", Integer.valueOf(i2));
                    map.put("is_customer", 1);
                    com.bykv.vk.openvk.component.video.api.ah.ah ahVarU = qr.u(ah.this.c.w());
                    if (ahVarU != null) {
                        map.put("video_size", Long.valueOf(ahVarU.ka()));
                        map.put("video_resolution", ahVarU.ny());
                    }
                    com.bytedance.sdk.openadsdk.core.zb.ah.ah(ah.this.c.w(), f.xr(ah.this.c.w()), "play_start_error", map);
                }

                @Override // com.bytedance.sdk.openadsdk.b.ms.xr.xr.ms
                public void ms(long j, int i, int i2) {
                    long jElapsedRealtime = SystemClock.elapsedRealtime();
                    if (this.xr == 0) {
                        this.xr = jElapsedRealtime;
                    }
                    long j2 = jElapsedRealtime - this.xr;
                    long jK_ = ((long) ah.this.k_()) * 1000;
                    long j3 = j2 - j;
                    if (j3 < 0) {
                        j3 = 0;
                    }
                    int i3 = j2 == 0 ? 1 : 0;
                    h.ms msVar = new h.ms();
                    msVar.xr(j3);
                    msVar.ah(jK_);
                    msVar.ms(j);
                    msVar.ms(i);
                    msVar.xr(i2);
                    msVar.ms(true);
                    com.bytedance.sdk.openadsdk.c.xr.d.ms(ah.this, msVar, "customer error", i3, false);
                }
            };
        }
        return this.x;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.d
    public void D_() {
        com.bytedance.sdk.openadsdk.b.ms.xr.ms.ms msVar = this.ka;
        if (msVar != null) {
            msVar.ms(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.d
    public void ms(int i, int i2) {
        com.bytedance.sdk.openadsdk.b.ms.xr.ms.ms msVar = this.ka;
        if (msVar != null) {
            msVar.ms(i, i2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void o_() {
        com.bytedance.sdk.openadsdk.b.ms.xr.ms.ms msVar = this.ka;
        if (msVar != null) {
            msVar.xr(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void p_() {
        com.bytedance.sdk.openadsdk.b.ms.xr.ms.ms msVar = this.ka;
        if (msVar != null) {
            msVar.ah(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void q_() {
        com.bytedance.sdk.openadsdk.b.ms.xr.ms.ms msVar = this.ka;
        if (msVar != null) {
            msVar.d(this);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void ms(long j, long j2) {
        com.bytedance.sdk.openadsdk.b.ms.xr.ms.ms msVar = this.ka;
        if (msVar != null) {
            msVar.ms(j, j2);
        }
        xr(j, j2);
    }

    private boolean yu() {
        if (this.c.w() == null || this.zb == null) {
            return false;
        }
        int iS = this.c.w().s();
        return iS == 1 || iS == 2;
    }

    private void xr(long j, long j2) {
        long j3;
        int i;
        if (yu() && !this.ub) {
            int iS = this.c.w().s();
            if (iS == 1) {
                j3 = 15000;
            } else {
                j3 = iS == 2 ? 30000L : 0L;
            }
            if (j2 <= j3) {
                i = (int) ((j2 - j) / 1000);
            } else {
                i = (int) ((j3 - j) / 1000);
            }
            if (i < 0) {
                i = 0;
            }
            if (i == this.u) {
                return;
            }
            this.u = i;
            if (this.u == 0) {
                this.ub = true;
            }
            this.zb.ms(this.u);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public Map<String, Object> ub() {
        Map<String, Object> mapUb = this.c.ub();
        if (this.c.w() == null || this.c.w().kz() != 166) {
            return mapUb;
        }
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.c.w())) {
            int iD = ul.d(this.c.w());
            int iKa = ul.ka(this.c.w());
            if (mapUb == null) {
                mapUb = new HashMap<>();
            }
            mapUb.put("live_author_follower_count", Integer.valueOf(iD));
            mapUb.put("live_watch_count", Integer.valueOf(iKa));
        }
        return mapUb;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ms(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.i.ms.xr.ms.ms msVar, com.bytedance.sdk.openadsdk.mediation.ad.ms.xr.ms.ms msVar2) {
        View viewMs;
        try {
            ms(viewGroup, (List<View>) null, list, list2, list3, (View) null, msVar);
            if (msVar2 != null) {
                View viewFindViewById = viewGroup.findViewById(msVar2.xr());
                if (viewFindViewById != null && ab() != null) {
                    viewFindViewById.setVisibility(0);
                    if (viewFindViewById instanceof ViewGroup) {
                        ((ViewGroup) viewFindViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(ab());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                        layoutParams.width = com.bytedance.sdk.openadsdk.core.jw.ul.ah(viewGroup.getContext(), 38.0f);
                        layoutParams.height = com.bytedance.sdk.openadsdk.core.jw.ul.ah(viewGroup.getContext(), 38.0f);
                        viewFindViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) viewFindViewById).addView(imageView, -1, -1);
                    } else if (viewFindViewById instanceof ImageView) {
                        ((ImageView) viewFindViewById).setImageBitmap(ab());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(msVar2.ms());
                if (frameLayout == null || (viewMs = ms()) == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.jw.ul.x(viewMs);
                frameLayout.removeAllViews();
                frameLayout.addView(viewMs, -1, -1);
            }
        } catch (Throwable th) {
            sl.ms(th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ms(com.bytedance.sdk.openadsdk.i.ms.xr.ms.xr xrVar) {
        d dVar = this.c;
        if (dVar != null) {
            dVar.ms(xrVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah.InterfaceC0177ah
    public void C_() {
        com.bytedance.sdk.openadsdk.b.ms.xr.ms.ms msVar = this.ka;
        if (msVar != null) {
            msVar.ka(this);
        }
        if (!yu() || this.ub) {
            return;
        }
        this.zb.ms(0);
        this.ub = true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms
    public com.bytedance.sdk.openadsdk.core.multipro.xr.ms r_() {
        return this.f2045ms;
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr, com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public void ah() {
        NativeVideoTsView nativeVideoTsView;
        if (this.hi != null && (nativeVideoTsView = this.hi.get()) != null) {
            nativeVideoTsView.y();
        }
        LazeLayout lazeLayout = this.ch;
        if (lazeLayout != null) {
            lazeLayout.ms();
        }
        super.ah();
    }

    @Override // com.bytedance.sdk.openadsdk.ao.xr.xr.zb
    public com.bytedance.sdk.openadsdk.mediation.manager.ms.xr.ms.d xr() {
        return new MediationNativeManagerDefault();
    }
}
