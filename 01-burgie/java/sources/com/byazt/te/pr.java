package com.byazt.te;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.byazt.dx.LottieAnimationView;
import com.byazt.dx.aj;
import com.byazt.dx.cz;
import com.byazt.dx.x;
import com.byazt.ihe.fw;
import com.byazt.ihe.m;
import com.byazt.n.hn;
import com.byazt.n.uc;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mar.sdk.MARCode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, 37})
public class pr implements fw {
    public boolean a;
    public String aj;
    public boolean b;
    public final int c;
    public boolean cz;
    public boolean fo;
    public final Context fw;
    public final String g;
    public int gz;
    public final long hn;
    public final JSONObject ho;
    public final String hw;
    public boolean iu;
    public fw.pr lb;
    public ViewTreeObserverOnGlobalLayoutListenerC0195pr ls;
    public long nl;
    public final fw nt;
    public boolean ny;
    public boolean rc;
    public final com.byazt.c.hw uc;
    public LottieAnimationView vk;
    public Bitmap w;
    public boolean ww;
    public final int x;
    public boolean yb;
    public boolean z;
    public final com.byazt.n.hw zo;
    public final String pr = "TTLottieFakeVideoPlayer";
    public final Map<String, Bitmap> k = new HashMap();
    public final Map<String, Integer> m = new HashMap();
    public final Set<fw.pr> qa = new HashSet();
    public volatile int ve = 200;
    public float y = 1.0f;
    public int n = 0;
    public int e = 0;
    public final Handler er = new Handler(Looper.getMainLooper());
    public final Runnable v = new Runnable() { // from class: com.byazt.te.pr.5
        @Override // java.lang.Runnable
        public void run() {
            for (fw.pr prVar : pr.this.qa) {
                pr prVar2 = pr.this;
                prVar.pr(prVar2, prVar2.gz, pr.this.a());
            }
            if (pr.this.gz >= pr.this.a()) {
                if (pr.this.vk != null) {
                    pr.this.vk.uc();
                }
                if (pr.this.ny && !pr.this.rc && pr.this.nt != null && pr.this.nt.vk()) {
                    pr.this.nt.x();
                }
                pr.this.cz = false;
                pr.this.fo = true;
                pr.this.nl();
                Iterator it = pr.this.qa.iterator();
                while (it.hasNext()) {
                    ((fw.pr) it.next()).pr(pr.this);
                }
                return;
            }
            pr.this.gz += pr.this.ve;
            pr.this.er.postDelayed(pr.this.v, pr.this.ve);
        }
    };
    public long s = SystemClock.elapsedRealtime();

    public static /* synthetic */ int fo(pr prVar) {
        int i = prVar.e;
        prVar.e = i + 1;
        return i;
    }

    public static /* synthetic */ int z(pr prVar) {
        int i = prVar.n;
        prVar.n = i + 1;
        return i;
    }

    /* JADX INFO: renamed from: com.byazt.te.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private class ViewTreeObserverOnGlobalLayoutListenerC0195pr implements ViewTreeObserver.OnGlobalLayoutListener {
        public int hn;
        public final ViewGroup hw;

        private ViewTreeObserverOnGlobalLayoutListenerC0195pr(ViewGroup viewGroup) {
            this.hn = 10;
            this.hw = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            float f;
            int width = this.hw.getWidth();
            int height = this.hw.getHeight();
            this.hw.removeAllViews();
            int i = this.hn;
            this.hn = i - 1;
            if (i < 0) {
                this.hw.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            if (width <= 0 || height <= 0) {
                this.hw.addView(pr.this.vk);
            } else {
                this.hw.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                float f2 = width;
                float f3 = height;
                float f4 = f2 / f3;
                if (pr.this.c > 0) {
                    f = pr.this.x / pr.this.c;
                } else {
                    f = f4;
                }
                if (f > 0.0f && f >= f4) {
                    height = (int) (f2 / f);
                } else {
                    width = (int) (f3 * f);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
                layoutParams.gravity = 17;
                this.hw.addView(pr.this.vk, layoutParams);
            }
            if (pr.this.a && !pr.this.vk.c()) {
                pr.this.vk.pr();
            }
        }
    }

    public pr(com.byazt.c.hw hwVar, com.byazt.ic.pr prVar, fw fwVar, uc ucVar, com.byazt.n.hw hwVar2) {
        this.fw = hwVar.getView().getContext();
        this.uc = hwVar;
        this.zo = hwVar2;
        this.hn = prVar.uc();
        this.x = prVar.x();
        this.c = prVar.c();
        String strHn = prVar.hn();
        this.g = strHn;
        String strPr = prVar.pr();
        this.hw = strPr;
        String strHw = prVar.hw();
        this.ho = prVar.fw();
        pr(strPr);
        hw(strHn);
        this.nt = fwVar;
        pr(strHw, ucVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr() {
        final ViewGroup viewGroup = (ViewGroup) this.uc.getView();
        viewGroup.removeAllViews();
        viewGroup.addView(this.vk);
        this.ls = new ViewTreeObserverOnGlobalLayoutListenerC0195pr(viewGroup);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.ls);
        viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.te.pr.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                ViewGroup viewGroup2 = viewGroup;
                if (viewGroup2 == view) {
                    viewGroup2.getViewTreeObserver().removeOnGlobalLayoutListener(pr.this.ls);
                    viewGroup.removeOnAttachStateChangeListener(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj() {
        com.byazt.rhv.hw.pr(new Runnable() { // from class: com.byazt.te.pr.9
            @Override // java.lang.Runnable
            public void run() {
                if (pr.this.w == null || pr.this.aj == null || !pr.this.yb || pr.this.vk != null) {
                    return;
                }
                pr.this.vk = new LottieAnimationView(pr.this.fw);
                pr.this.vk.setVideoStats(pr.this.zo);
                pr.this.vk.setRepeatCount(-1);
                pr.this.vk.setSpeed(pr.this.y);
                pr.this.vk.setImageAssetDelegate(new x() { // from class: com.byazt.te.pr.9.1
                    @Override // com.byazt.dx.x
                    public Bitmap pr(aj ajVar) {
                        if (ajVar != null) {
                            String strM = ajVar.m();
                            if (!TextUtils.isEmpty(strM)) {
                                if (strM.startsWith("${") && strM.endsWith("}")) {
                                    strM = com.byazt.rhv.pr.pr(strM, pr.this.ho);
                                    if (TextUtils.isEmpty(strM)) {
                                        return null;
                                    }
                                    if (!strM.startsWith("http") || TextUtils.equals(strM, pr.this.g)) {
                                        Bitmap bitmap = pr.this.w;
                                        if (bitmap != null && (bitmap.getWidth() != ajVar.pr() || bitmap.getHeight() != ajVar.hw())) {
                                            pr.this.w = Bitmap.createScaledBitmap(bitmap, ajVar.pr(), ajVar.hw(), false);
                                        }
                                        return pr.this.w;
                                    }
                                }
                                Bitmap bitmap2 = (Bitmap) pr.this.k.get(strM);
                                if (bitmap2 == null) {
                                    pr.this.pr(strM, ajVar.pr(), ajVar.hw());
                                } else {
                                    return bitmap2;
                                }
                            }
                        }
                        return null;
                    }
                });
                pr.this.vk.setTextDelegate(new cz(pr.this.vk) { // from class: com.byazt.te.pr.9.2
                    @Override // com.byazt.dx.cz
                    public String pr(String str) {
                        return com.byazt.rhv.pr.pr(str, pr.this.ho != null ? pr.this.ho : null);
                    }
                });
                pr.this.vk.pr(pr.this.aj, pr.this.hw);
                pr.this.pr();
                pr.this.ny = true;
                pr.this.s = SystemClock.elapsedRealtime() - pr.this.s;
                for (fw.pr prVar : pr.this.qa) {
                    prVar.hn(pr.this);
                    pr prVar2 = pr.this;
                    prVar.pr((fw) prVar2, prVar2.x, pr.this.c);
                }
                if (pr.this.a) {
                    pr.this.nt.hw(pr.this.ww);
                    pr.this.nt.hn(true);
                    if (pr.this.nl > 0) {
                        pr prVar3 = pr.this;
                        prVar3.hw(prVar3.nl);
                    } else {
                        pr.this.hn();
                    }
                }
                for (fw.pr prVar4 : pr.this.qa) {
                    pr prVar5 = pr.this;
                    prVar4.pr(prVar5, prVar5.s);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final String str) {
        if (TextUtils.isEmpty(str)) {
            pr(new hn(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.byazt.rhv.hw.hn(new Runnable() { // from class: com.byazt.te.pr.10
                @Override // java.lang.Runnable
                public void run() {
                    String strPr = com.byazt.ic.hw.pr().pr(str);
                    if (!TextUtils.isEmpty(strPr)) {
                        pr.this.aj = strPr;
                        pr.this.aj();
                    } else {
                        com.byazt.ic.hw.pr().pr(str, new com.byazt.ic.hw.pr<String>() { // from class: com.byazt.te.pr.10.1
                            @Override // com.byazt.ic.hw.pr
                            public void pr(String str2) {
                                pr.this.aj = str2;
                                pr.this.aj();
                            }

                            @Override // com.byazt.ic.hw.pr
                            public void pr(int i, String str2) {
                                if (i == 10006) {
                                    pr.this.pr(new hn(60008, i, str2));
                                    return;
                                }
                                pr.fo(pr.this);
                                if (pr.this.e <= 3) {
                                    pr.this.pr(str);
                                } else {
                                    pr.this.pr(new hn(60008, i, str2));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(final String str) {
        if (TextUtils.isEmpty(str)) {
            pr(new hn(60008, AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS, "广告主图url为空"));
        } else {
            com.byazt.ic.hw.pr().hw(str, new com.byazt.ic.hw.pr<Bitmap>() { // from class: com.byazt.te.pr.11
                @Override // com.byazt.ic.hw.pr
                public void pr(Bitmap bitmap) {
                    pr.this.w = bitmap;
                    pr.this.aj();
                }

                @Override // com.byazt.ic.hw.pr
                public void pr(int i, String str2) {
                    pr.z(pr.this);
                    if (pr.this.n <= 3) {
                        pr.this.hw(str);
                    } else {
                        pr.this.pr(new hn(60008, AVMDLDataLoader.KeyIsStoRingBufferSizeKB, "广告主图url加载失败"));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final String str, final int i, final int i2) {
        Integer num = this.m.get(str);
        if (num == null || num.intValue() != 1) {
            this.m.put(str, 1);
            this.vk.pr(str, new com.byazt.rwn.aj() { // from class: com.byazt.te.pr.12
                @Override // com.byazt.rwn.aj
                public void pr(Bitmap bitmap) {
                    pr.this.pr(bitmap, str, i, i2);
                }

                @Override // com.byazt.rwn.aj
                public void pr() {
                    com.byazt.ic.hw.pr().pr(pr.this.fw, str, new com.byazt.ic.hw.pr<Bitmap>() { // from class: com.byazt.te.pr.12.1
                        @Override // com.byazt.ic.hw.pr
                        public void pr(Bitmap bitmap) {
                            pr.this.pr(bitmap, str, i, i2);
                        }

                        @Override // com.byazt.ic.hw.pr
                        public void pr(int i3, String str2) {
                            pr.this.m.put(str, 2);
                        }
                    });
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(Bitmap bitmap, String str, int i, int i2) {
        if (bitmap != null) {
            if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
            }
            this.k.put(str, bitmap);
            com.byazt.rhv.hw.pr(new Runnable() { // from class: com.byazt.te.pr.13
                @Override // java.lang.Runnable
                public void run() {
                    if (pr.this.vk != null) {
                        pr.this.vk.invalidate();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final hn hnVar) {
        com.byazt.rhv.hw.hw(new Runnable() { // from class: com.byazt.te.pr.14
            @Override // java.lang.Runnable
            public void run() {
                if (!pr.this.b) {
                    hnVar.pr();
                    hnVar.hw();
                    hnVar.hn();
                    Iterator it = pr.this.qa.iterator();
                    while (it.hasNext()) {
                        ((fw.pr) it.next()).pr(pr.this, hnVar);
                    }
                }
                pr.this.b = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iu() {
        com.byazt.rhv.hw.hw(new Runnable() { // from class: com.byazt.te.pr.15
            @Override // java.lang.Runnable
            public void run() {
                if (!pr.this.iu) {
                    if (pr.this.vk()) {
                        pr.this.ww();
                    }
                    Iterator it = pr.this.qa.iterator();
                    while (it.hasNext()) {
                        ((fw.pr) it.next()).pr(pr.this, -1, -1, -1);
                    }
                }
                pr.this.iu = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(final int i) {
        com.byazt.rhv.hw.hw(new Runnable() { // from class: com.byazt.te.pr.16
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = pr.this.qa.iterator();
                while (it.hasNext()) {
                    ((fw.pr) it.next()).hw(pr.this, i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        com.byazt.rhv.hw.hw(new Runnable() { // from class: com.byazt.te.pr.2
            @Override // java.lang.Runnable
            public void run() {
                pr.this.iu = false;
                if (pr.this.k()) {
                    pr.this.y();
                }
                Iterator it = pr.this.qa.iterator();
                while (it.hasNext()) {
                    ((fw.pr) it.next()).pr((fw) pr.this, -1);
                }
            }
        });
    }

    private void x(final boolean z) {
        com.byazt.rhv.hw.hw(new Runnable() { // from class: com.byazt.te.pr.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = pr.this.qa.iterator();
                while (it.hasNext()) {
                    ((fw.pr) it.next()).pr(pr.this, z);
                }
            }
        });
    }

    private void pr(String str, uc ucVar) {
        if (TextUtils.isEmpty(str)) {
            pr(new hn(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, "lottie音频url为空"));
            return;
        }
        fw.pr prVar = new fw.pr() { // from class: com.byazt.te.pr.4
            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, long j) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void hn(fw fwVar) {
                pr.this.yb = true;
                pr.this.aj();
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, com.byazt.ihe.hn hnVar) {
                String strHn;
                int iHw;
                int iPr = -1;
                if (hnVar == null) {
                    strHn = "";
                    iHw = -1;
                } else {
                    iPr = hnVar.pr();
                    iHw = hnVar.hw();
                    strHn = hnVar.hn();
                }
                pr.this.pr(new hn(iPr, iHw, "lottie音频播放失败:".concat(String.valueOf(strHn))));
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, boolean z) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void x(fw fwVar) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, int i, int i2) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, int i, int i2, int i3) {
                pr.this.iu();
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, int i) {
                pr.this.ve();
            }

            @Override // com.byazt.ihe.fw.pr
            public void hw(fw fwVar, int i) {
                pr.this.hn(i);
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, long j, long j2) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void pr(fw fwVar, JSONObject jSONObject, String str2) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void c(fw fwVar) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void uc(fw fwVar) {
            }

            @Override // com.byazt.ihe.fw.pr
            public void hw(fw fwVar) {
                for (fw.pr prVar2 : pr.this.qa) {
                    if (prVar2 != null) {
                        prVar2.hw(pr.this);
                    }
                }
            }
        };
        this.lb = prVar;
        this.nt.pr(prVar);
        this.nt.pr(ucVar);
    }

    private void gz() {
        this.er.removeCallbacksAndMessages(null);
        this.er.post(this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nl() {
        this.er.removeCallbacksAndMessages(null);
    }

    @Override // com.byazt.ihe.fw
    public void pr(m mVar) {
    }

    @Override // com.byazt.ihe.fw
    public void hw(boolean z) {
        this.ww = z;
        fw fwVar = this.nt;
        if (fwVar != null) {
            fwVar.hw(z);
        }
    }

    @Override // com.byazt.ihe.fw
    public void pr(long j) {
        this.gz = (int) j;
        LottieAnimationView lottieAnimationView = this.vk;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = a();
            }
            if (duration > 0) {
                this.vk.setProgress((j % duration) / duration);
            }
        }
        fw fwVar = this.nt;
        if (fwVar != null && fwVar.a() > 0) {
            this.nt.pr((int) (j % this.nt.a()));
        }
        x(true);
    }

    @Override // com.byazt.ihe.fw
    public void hw(int i) {
    }

    @Override // com.byazt.ihe.fw
    public void pr(boolean z, long j, boolean z2) {
        this.ww = z2;
        this.a = true;
        this.nl = j;
        this.nt.pr(z, j, z2);
        if (this.ny) {
            this.nt.hw(z2);
            this.nt.hn(true);
            if (j > 0) {
                hw(j);
            } else {
                hn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(long j) {
        LottieAnimationView lottieAnimationView = this.vk;
        if (lottieAnimationView != null) {
            lottieAnimationView.pr();
        }
        pr(j);
        fw fwVar = this.nt;
        if (fwVar != null) {
            fwVar.hn();
        }
        this.cz = true;
        gz();
    }

    @Override // com.byazt.ihe.fw
    public void hw() {
        nl();
        this.gz = 0;
        this.ny = true;
        this.fo = false;
        this.rc = false;
        LottieAnimationView lottieAnimationView = this.vk;
        if (lottieAnimationView != null) {
            lottieAnimationView.uc();
            this.vk.setProgress(0.0f);
        }
        hn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        fw fwVar;
        LottieAnimationView lottieAnimationView = this.vk;
        if (lottieAnimationView != null && this.ny && !lottieAnimationView.c()) {
            if (this.gz > 0) {
                this.vk.hw();
            } else {
                this.vk.pr();
            }
        }
        if (this.ny && !this.rc && (fwVar = this.nt) != null && !fwVar.vk()) {
            if (this.gz > 0) {
                this.nt.hn();
            } else {
                this.nt.pr(0L);
                this.nt.hn();
            }
        }
        this.cz = true;
        gz();
    }

    @Override // com.byazt.ihe.fw
    public void hn() {
        y();
        if (this.gz > 0) {
            com.byazt.rhv.hw.hw(new Runnable() { // from class: com.byazt.te.pr.6
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = pr.this.qa.iterator();
                    while (it.hasNext()) {
                        ((fw.pr) it.next()).uc(pr.this);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ww() {
        fw fwVar;
        LottieAnimationView lottieAnimationView = this.vk;
        if (lottieAnimationView != null && this.ny && lottieAnimationView.c()) {
            this.vk.fw();
        }
        if (this.ny && !this.rc && (fwVar = this.nt) != null && fwVar.vk()) {
            this.nt.x();
        }
        this.cz = false;
        nl();
    }

    @Override // com.byazt.ihe.fw
    public void x() {
        ww();
        com.byazt.rhv.hw.hw(new Runnable() { // from class: com.byazt.te.pr.7
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = pr.this.qa.iterator();
                while (it.hasNext()) {
                    ((fw.pr) it.next()).c(pr.this);
                }
            }
        });
    }

    @Override // com.byazt.ihe.fw
    public void fw() {
        fw fwVar;
        LottieAnimationView lottieAnimationView = this.vk;
        if (lottieAnimationView != null) {
            lottieAnimationView.uc();
            this.a = false;
        }
        if (this.ny && !this.rc && (fwVar = this.nt) != null && fwVar.vk()) {
            this.nt.x();
        }
        nl();
    }

    @Override // com.byazt.ihe.fw
    public void c() {
        fw fwVar;
        this.gz = 0;
        nl();
        LottieAnimationView lottieAnimationView = this.vk;
        if (lottieAnimationView != null) {
            lottieAnimationView.uc();
            this.vk.setProgress(0.0f);
        }
        if (this.ny && !this.rc && (fwVar = this.nt) != null) {
            if (fwVar.vk()) {
                this.nt.x();
            }
            this.nt.pr(0L);
        }
    }

    @Override // com.byazt.ihe.fw
    public void uc() {
        this.rc = true;
        nl();
        this.k.clear();
        this.w = null;
        fw fwVar = this.nt;
        if (fwVar != null) {
            if (this.ny) {
                fwVar.fw();
            }
            this.nt.uc();
        }
        com.byazt.rhv.hw.hw(new Runnable() { // from class: com.byazt.te.pr.8
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) pr.this.uc.getView();
                if (viewGroup != null) {
                    viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(pr.this.ls);
                }
                Iterator it = pr.this.qa.iterator();
                while (it.hasNext()) {
                    ((fw.pr) it.next()).x(pr.this);
                }
            }
        });
    }

    @Override // com.byazt.ihe.fw
    public boolean zo() {
        return this.ny;
    }

    @Override // com.byazt.ihe.fw
    public void pr(boolean z) {
    }

    @Override // com.byazt.ihe.fw
    public void pr(SurfaceHolder surfaceHolder) {
    }

    @Override // com.byazt.ihe.fw
    public SurfaceHolder rc() {
        return null;
    }

    @Override // com.byazt.ihe.fw
    public void pr(SurfaceTexture surfaceTexture) {
    }

    @Override // com.byazt.ihe.fw
    public SurfaceTexture z() {
        return null;
    }

    @Override // com.byazt.ihe.fw
    public boolean ho() {
        return this.fo;
    }

    @Override // com.byazt.ihe.fw
    public boolean g() {
        return this.ny;
    }

    @Override // com.byazt.ihe.fw
    public boolean w() {
        return this.a;
    }

    @Override // com.byazt.ihe.fw
    public boolean vk() {
        return this.cz;
    }

    @Override // com.byazt.ihe.fw
    public boolean k() {
        return (this.cz || this.fo || this.rc || !this.ny) ? false : true;
    }

    @Override // com.byazt.ihe.fw
    public boolean m() {
        return this.rc;
    }

    @Override // com.byazt.ihe.fw
    public int yb() {
        return this.x;
    }

    @Override // com.byazt.ihe.fw
    public int lb() {
        return this.c;
    }

    @Override // com.byazt.ihe.fw
    public long nt() {
        if (this.ny) {
            return this.s;
        }
        return 0L;
    }

    @Override // com.byazt.ihe.fw
    public int qa() {
        return 1;
    }

    @Override // com.byazt.ihe.fw
    public long a() {
        return this.hn;
    }

    @Override // com.byazt.ihe.fw
    public long cz() {
        return this.gz;
    }

    @Override // com.byazt.ihe.fw
    public void hn(boolean z) {
        this.z = z;
    }

    @Override // com.byazt.ihe.fw
    public boolean ny() {
        return this.z;
    }

    @Override // com.byazt.ihe.fw
    public void pr(fw.pr prVar) {
        this.qa.add(prVar);
    }

    @Override // com.byazt.ihe.fw
    public void hw(fw.pr prVar) {
        this.qa.remove(prVar);
    }

    @Override // com.byazt.ihe.fw
    public void pr(int i) {
        this.ve = i;
    }

    @Override // com.byazt.ihe.fw
    public int fo() {
        return this.ve;
    }

    @Override // com.byazt.ihe.fw
    public void pr(float f) {
        this.y = f;
    }

    @Override // com.byazt.ihe.fw
    public String b() {
        return "";
    }
}
