package com.bytedance.sdk.openadsdk.upie.video.lottie;

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
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.component.video.api.ah.d;
import com.bytedance.adsdk.lottie.LottieAnimationView;
import com.bytedance.adsdk.lottie.ny;
import com.bytedance.adsdk.lottie.t;
import com.bytedance.sdk.component.utils.sl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ms implements com.bykv.vk.openvk.component.video.api.ms {
    private final Context ab;
    private final long ah;
    private boolean ao;
    private boolean b;
    private final com.bykv.vk.openvk.component.video.api.renderview.xr c;
    private Bitmap ch;
    private final int d;
    private boolean g;
    private boolean i;
    private ViewTreeObserverOnGlobalLayoutListenerC0341ms jw;
    private final int ka;
    private long le;
    private boolean nw;
    private LottieAnimationView ny;
    private int op;
    private boolean qv;
    private boolean re;
    private boolean t;
    private final JSONObject u;
    private final com.bykv.vk.openvk.component.video.api.ms ub;
    private boolean w;
    private String x;
    private final String xr;
    private boolean y;
    private final String zb;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final String f4249ms = "TTLottieFakeVideoPlayer";
    private final Map<String, Bitmap> hi = new HashMap();
    private final Map<String, Integer> sl = new HashMap();
    private final Set<com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms> h = new HashSet();
    private volatile int yu = 200;
    private float cv = 1.0f;
    private int of = 0;
    private int p = 0;
    private final Handler f = new Handler(Looper.getMainLooper());
    private final Runnable ul = new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.4
        @Override // java.lang.Runnable
        public void run() {
            for (com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms interfaceC0179ms : ms.this.h) {
                ms msVar = ms.this;
                interfaceC0179ms.ms(msVar, msVar.op, ms.this.qv());
            }
            sl.ms("TTLottieFakeVideoPlayer", "--==--play curr: " + ms.this.op);
            if (ms.this.op >= ms.this.qv()) {
                if (ms.this.ny != null) {
                    ms.this.ny.c();
                }
                if (ms.this.t && !ms.this.b && ms.this.ub != null && ms.this.ub.zb()) {
                    ms.this.ub.ah();
                }
                ms.this.y = false;
                ms.this.nw = true;
                ms.this.w();
                Iterator it = ms.this.h.iterator();
                while (it.hasNext()) {
                    ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) it.next()).ms(ms.this);
                }
                return;
            }
            ms.this.op += ms.this.yu;
            ms.this.f.postDelayed(ms.this.ul, ms.this.yu);
        }
    };
    private long pc = SystemClock.elapsedRealtime();

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public SurfaceHolder ab() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(SurfaceTexture surfaceTexture) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(SurfaceHolder surfaceHolder) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public SurfaceTexture x() {
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void xr(boolean z) {
    }

    static /* synthetic */ int b(ms msVar) {
        int i = msVar.p;
        msVar.p = i + 1;
        return i;
    }

    static /* synthetic */ int i(ms msVar) {
        int i = msVar.of;
        msVar.of = i + 1;
        return i;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.upie.video.lottie.ms$ms, reason: collision with other inner class name */
    private class ViewTreeObserverOnGlobalLayoutListenerC0341ms implements ViewTreeObserver.OnGlobalLayoutListener {
        private int ah;
        private final ViewGroup xr;

        private ViewTreeObserverOnGlobalLayoutListenerC0341ms(ViewGroup viewGroup) {
            this.ah = 10;
            this.xr = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int width = this.xr.getWidth();
            int height = this.xr.getHeight();
            this.xr.removeAllViews();
            int i = this.ah;
            this.ah = i - 1;
            if (i < 0) {
                this.xr.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            if (width <= 0 || height <= 0) {
                this.xr.addView(ms.this.ny);
            } else {
                this.xr.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                float f = ms.this.d / ms.this.ka;
                float f2 = width;
                float f3 = height;
                float f4 = f2 / f3;
                if (ms.this.ka <= 0 || f < f4) {
                    width = (int) (f3 * f);
                } else {
                    height = (int) (f2 / f);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height);
                layoutParams.gravity = 17;
                this.xr.addView(ms.this.ny, layoutParams);
            }
            if (!ms.this.qv || ms.this.ny.ka()) {
                return;
            }
            ms.this.ny.ms();
        }
    }

    public ms(com.bykv.vk.openvk.component.video.api.renderview.xr xrVar, com.bytedance.sdk.openadsdk.upie.ms msVar, com.bykv.vk.openvk.component.video.api.ms msVar2, d dVar) {
        this.ab = xrVar.getView().getContext();
        this.c = xrVar;
        this.ah = msVar.c();
        this.d = msVar.d();
        this.ka = msVar.ka();
        String strAh = msVar.ah();
        this.zb = strAh;
        String strMs = msVar.ms();
        this.xr = strMs;
        String strXr = msVar.xr();
        this.u = msVar.ab();
        ms(strMs);
        xr(strAh);
        this.ub = msVar2;
        ms(strXr, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        final ViewGroup viewGroup = (ViewGroup) this.c.getView();
        viewGroup.removeAllViews();
        viewGroup.addView(this.ny);
        this.jw = new ViewTreeObserverOnGlobalLayoutListenerC0341ms(viewGroup);
        viewGroup.getViewTreeObserver().addOnGlobalLayoutListener(this.jw);
        viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                ViewGroup viewGroup2 = viewGroup;
                if (viewGroup2 == view) {
                    viewGroup2.getViewTreeObserver().removeOnGlobalLayoutListener(ms.this.jw);
                    viewGroup.removeOnAttachStateChangeListener(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nw() {
        com.bytedance.sdk.openadsdk.upie.ms.xr.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.8
            @Override // java.lang.Runnable
            public void run() {
                if (ms.this.ch == null || ms.this.x == null || !ms.this.ao || ms.this.ny != null) {
                    return;
                }
                ms.this.ny = new LottieAnimationView(ms.this.ab);
                ms.this.ny.ms(ms.this.x, ms.this.xr);
                ms.this.ny.setRepeatCount(-1);
                ms.this.ny.setSpeed(ms.this.cv);
                ms.this.ny.setTextDelegate(new t(ms.this.ny) { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.8.1
                    @Override // com.bytedance.adsdk.lottie.t
                    public String ms(String str) {
                        return com.bytedance.sdk.openadsdk.upie.ms.ms.ms(str, ms.this.u != null ? ms.this.u : null);
                    }
                });
                ms.this.ny.setImageAssetDelegate(new com.bytedance.adsdk.lottie.d() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.8.2
                    @Override // com.bytedance.adsdk.lottie.d
                    public Bitmap ms(ny nyVar) {
                        if (nyVar != null) {
                            String strSl = nyVar.sl();
                            if (!TextUtils.isEmpty(strSl)) {
                                if (strSl.startsWith("${") && strSl.endsWith("}")) {
                                    strSl = com.bytedance.sdk.openadsdk.upie.ms.ms.ms(strSl, ms.this.u);
                                    if (TextUtils.isEmpty(strSl)) {
                                        return null;
                                    }
                                    if (!strSl.startsWith("http") || TextUtils.equals(strSl, ms.this.zb)) {
                                        Bitmap bitmap = ms.this.ch;
                                        if (bitmap != null && (bitmap.getWidth() != nyVar.ms() || bitmap.getHeight() != nyVar.xr())) {
                                            ms.this.ch = Bitmap.createScaledBitmap(bitmap, nyVar.ms(), nyVar.xr(), false);
                                        }
                                        return ms.this.ch;
                                    }
                                }
                                Bitmap bitmap2 = (Bitmap) ms.this.hi.get(strSl);
                                if (bitmap2 != null) {
                                    return bitmap2;
                                }
                                ms.this.ms(strSl, nyVar.ms(), nyVar.xr());
                            }
                        }
                        return null;
                    }
                });
                ms.this.t();
                ms.this.t = true;
                sl.ms("TTLottieFakeVideoPlayer", "--==--onPrepared");
                ms.this.pc = SystemClock.elapsedRealtime() - ms.this.pc;
                for (com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms interfaceC0179ms : ms.this.h) {
                    interfaceC0179ms.xr(ms.this);
                    ms msVar = ms.this;
                    interfaceC0179ms.ms((com.bykv.vk.openvk.component.video.api.ms) msVar, msVar.d, ms.this.ka);
                }
                if (ms.this.qv) {
                    ms.this.ub.ms(ms.this.g);
                    ms.this.ub.ah(true);
                    if (ms.this.le > 0) {
                        ms msVar2 = ms.this;
                        msVar2.xr(msVar2.le);
                    } else {
                        ms.this.xr();
                    }
                }
                for (com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms interfaceC0179ms2 : ms.this.h) {
                    ms msVar3 = ms.this;
                    interfaceC0179ms2.ms(msVar3, msVar3.pc);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final String str) {
        if (TextUtils.isEmpty(str)) {
            ms(new com.bykv.vk.openvk.component.video.api.ah.xr(60008, 10000, "lottieJsonUrl为空"));
        } else {
            com.bytedance.sdk.openadsdk.upie.ms.xr.ah(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.9
                @Override // java.lang.Runnable
                public void run() {
                    String strMs = com.bytedance.sdk.openadsdk.upie.xr.ms().ms(str);
                    if (!TextUtils.isEmpty(strMs)) {
                        ms.this.x = strMs;
                        ms.this.nw();
                    } else {
                        com.bytedance.sdk.openadsdk.upie.xr.ms().ms(str, new com.bytedance.sdk.openadsdk.upie.xr.ms<String>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.9.1
                            @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                            public void ms(String str2) {
                                sl.ms("TTLottieFakeVideoPlayer", "--==-- lottie jsonStr ok");
                                ms.this.x = str2;
                                ms.this.nw();
                            }

                            @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                            public void ms(int i, String str2) {
                                sl.ms("TTLottieFakeVideoPlayer", "--==-- lottie jsonStr load fail: " + i + ", " + str2);
                                if (i == 10006) {
                                    ms.this.ms(new com.bykv.vk.openvk.component.video.api.ah.xr(60008, i, str2));
                                    return;
                                }
                                ms.b(ms.this);
                                if (ms.this.p <= 3) {
                                    ms.this.ms(str);
                                } else {
                                    ms.this.ms(new com.bykv.vk.openvk.component.video.api.ah.xr(60008, i, str2));
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(final String str) {
        if (TextUtils.isEmpty(str)) {
            ms(new com.bykv.vk.openvk.component.video.api.ah.xr(60008, AVMDLDataLoader.KeyIsStoPlayDldWinSizeKBLS, "广告主图url为空"));
        } else {
            com.bytedance.sdk.openadsdk.upie.xr.ms().xr(str, new com.bytedance.sdk.openadsdk.upie.xr.ms<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.10
                @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                public void ms(Bitmap bitmap) {
                    ms.this.ch = bitmap;
                    ms.this.nw();
                }

                @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                public void ms(int i, String str2) {
                    ms.i(ms.this);
                    if (ms.this.of <= 3) {
                        ms.this.xr(str);
                    } else {
                        ms.this.ms(new com.bykv.vk.openvk.component.video.api.ah.xr(60008, AVMDLDataLoader.KeyIsStoRingBufferSizeKB, "广告主图url加载失败"));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final String str, final int i, final int i2) {
        Integer num = this.sl.get(str);
        if (num == null || num.intValue() != 1) {
            this.sl.put(str, 1);
            com.bytedance.sdk.openadsdk.upie.xr.ms().ms(this.ab, str, new com.bytedance.sdk.openadsdk.upie.xr.ms<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.11
                @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                public void ms(Bitmap bitmap) {
                    if (bitmap != null) {
                        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
                            bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                        }
                        ms.this.hi.put(str, bitmap);
                        com.bytedance.sdk.openadsdk.upie.ms.xr.ms(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.11.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ms.this.ny != null) {
                                    ms.this.ny.invalidate();
                                }
                            }
                        });
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.upie.xr.ms
                public void ms(int i3, String str2) {
                    ms.this.sl.put(str, 2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(final com.bykv.vk.openvk.component.video.api.ah.xr xrVar) {
        com.bytedance.sdk.openadsdk.upie.ms.xr.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.12
            @Override // java.lang.Runnable
            public void run() {
                if (!ms.this.i) {
                    sl.ms("TTLottieFakeVideoPlayer", "--==--play err, code: " + xrVar.ms() + ", extra: " + xrVar.xr() + ", msg: " + xrVar.ah());
                    Iterator it = ms.this.h.iterator();
                    while (it.hasNext()) {
                        ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) it.next()).ms(ms.this, xrVar);
                    }
                }
                ms.this.i = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.bytedance.sdk.openadsdk.upie.ms.xr.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.13
            @Override // java.lang.Runnable
            public void run() {
                if (!ms.this.w) {
                    sl.ms("TTLottieFakeVideoPlayer", "--==--audio buffering start");
                    if (ms.this.zb()) {
                        ms.this.op();
                    }
                    Iterator it = ms.this.h.iterator();
                    while (it.hasNext()) {
                        ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) it.next()).ms(ms.this, -1, -1, -1);
                    }
                }
                ms.this.w = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(final int i) {
        com.bytedance.sdk.openadsdk.upie.ms.xr.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.14
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ms.this.h.iterator();
                while (it.hasNext()) {
                    ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) it.next()).xr(ms.this, i);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void re() {
        com.bytedance.sdk.openadsdk.upie.ms.xr.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.15
            @Override // java.lang.Runnable
            public void run() {
                sl.ms("TTLottieFakeVideoPlayer", "--==--audio buffering end");
                ms.this.w = false;
                if (ms.this.u()) {
                    ms.this.yu();
                }
                Iterator it = ms.this.h.iterator();
                while (it.hasNext()) {
                    ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) it.next()).ms((com.bykv.vk.openvk.component.video.api.ms) ms.this, -1);
                }
            }
        });
    }

    private void d(final boolean z) {
        com.bytedance.sdk.openadsdk.upie.ms.xr.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.2
            @Override // java.lang.Runnable
            public void run() {
                sl.ms("TTLottieFakeVideoPlayer", "--==--seek completed");
                Iterator it = ms.this.h.iterator();
                while (it.hasNext()) {
                    ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) it.next()).ms(ms.this, z);
                }
            }
        });
    }

    private void ms(String str, d dVar) {
        if (TextUtils.isEmpty(str)) {
            ms(new com.bykv.vk.openvk.component.video.api.ah.xr(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh1, "lottie音频url为空"));
        } else {
            this.ub.ms(new com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.3
                @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
                public void ah(com.bykv.vk.openvk.component.video.api.ms msVar) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
                public void ms(com.bykv.vk.openvk.component.video.api.ms msVar) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
                public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, int i, int i2) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
                public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, long j) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
                public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, long j, long j2) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
                public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, JSONObject jSONObject, String str2) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
                public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, boolean z) {
                }

                @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
                public void xr(com.bykv.vk.openvk.component.video.api.ms msVar) {
                    ms.this.ao = true;
                    ms.this.nw();
                }

                @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
                public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, com.bykv.vk.openvk.component.video.api.ah.xr xrVar) {
                    int iMs;
                    String strAh;
                    int iXr;
                    if (xrVar != null) {
                        iMs = xrVar.ms();
                        iXr = xrVar.xr();
                        strAh = xrVar.ah();
                    } else {
                        iMs = -1;
                        strAh = "";
                        iXr = -1;
                    }
                    ms.this.ms(new com.bykv.vk.openvk.component.video.api.ah.xr(iMs, iXr, "lottie音频播放失败:".concat(String.valueOf(strAh))));
                }

                @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
                public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, int i, int i2, int i3) {
                    ms.this.b();
                }

                @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
                public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, int i) {
                    ms.this.re();
                }

                @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
                public void xr(com.bykv.vk.openvk.component.video.api.ms msVar, int i) {
                    ms.this.ah(i);
                }
            });
            this.ub.ms(dVar);
        }
    }

    private void i() {
        this.f.removeCallbacksAndMessages(null);
        this.f.post(this.ul);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.f.removeCallbacksAndMessages(null);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(d dVar) {
        sl.ms("TTLottieFakeVideoPlayer", "--==--setDataSource: ".concat(String.valueOf(dVar)));
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(boolean z) {
        sl.ms("TTLottieFakeVideoPlayer", "--==--setQuietPlay: ".concat(String.valueOf(z)));
        this.g = z;
        com.bykv.vk.openvk.component.video.api.ms msVar = this.ub;
        if (msVar != null) {
            msVar.ms(z);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(long j) {
        sl.ms("TTLottieFakeVideoPlayer", "--==--seekTo: ".concat(String.valueOf(j)));
        this.op = (int) j;
        LottieAnimationView lottieAnimationView = this.ny;
        if (lottieAnimationView != null) {
            long duration = lottieAnimationView.getDuration();
            if (duration <= 0) {
                duration = qv();
            }
            if (duration > 0) {
                this.ny.setProgress((j % duration) / duration);
            }
        }
        com.bykv.vk.openvk.component.video.api.ms msVar = this.ub;
        if (msVar != null && msVar.qv() > 0) {
            this.ub.ms((int) (j % this.ub.qv()));
        }
        d(true);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(int i) {
        sl.ms("TTLottieFakeVideoPlayer", "--==--setSeekMode: ".concat(String.valueOf(i)));
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(boolean z, long j, boolean z2) {
        sl.ms("TTLottieFakeVideoPlayer", "--==--start: " + z + ", " + j + ", " + z2);
        this.g = z2;
        this.qv = true;
        this.le = j;
        this.ub.ms(z, j, z2);
        if (this.t) {
            this.ub.ms(z2);
            this.ub.ah(true);
            if (j > 0) {
                xr(j);
            } else {
                xr();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(long j) {
        LottieAnimationView lottieAnimationView = this.ny;
        if (lottieAnimationView != null) {
            lottieAnimationView.ms();
        }
        ms(j);
        com.bykv.vk.openvk.component.video.api.ms msVar = this.ub;
        if (msVar != null) {
            msVar.xr();
        }
        this.y = true;
        i();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms() {
        sl.ms("TTLottieFakeVideoPlayer", "--==--reStart");
        w();
        this.op = 0;
        this.t = true;
        this.nw = false;
        this.b = false;
        LottieAnimationView lottieAnimationView = this.ny;
        if (lottieAnimationView != null) {
            lottieAnimationView.c();
            this.ny.setProgress(0.0f);
        }
        xr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yu() {
        com.bykv.vk.openvk.component.video.api.ms msVar;
        sl.ms("TTLottieFakeVideoPlayer", "--==--play");
        LottieAnimationView lottieAnimationView = this.ny;
        if (lottieAnimationView != null && this.t && !lottieAnimationView.ka()) {
            sl.ms("TTLottieFakeVideoPlayer", "--==--play --- enter");
            if (this.op > 0) {
                this.ny.xr();
            } else {
                this.ny.ms();
            }
        }
        if (this.t && !this.b && (msVar = this.ub) != null && !msVar.zb()) {
            sl.ms("TTLottieFakeVideoPlayer", "--==--audio play --- enter");
            if (this.op > 0) {
                this.ub.xr();
            } else {
                this.ub.ms(0L);
                this.ub.xr();
            }
        }
        this.y = true;
        i();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void xr() {
        yu();
        if (this.op > 0) {
            com.bytedance.sdk.openadsdk.upie.ms.xr.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.5
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = ms.this.h.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void op() {
        com.bykv.vk.openvk.component.video.api.ms msVar;
        sl.ms("TTLottieFakeVideoPlayer", "--==--pause");
        LottieAnimationView lottieAnimationView = this.ny;
        if (lottieAnimationView != null && this.t && lottieAnimationView.ka()) {
            sl.ms("TTLottieFakeVideoPlayer", "--==--pause --- enter");
            this.ny.ab();
        }
        if (this.t && !this.b && (msVar = this.ub) != null && msVar.zb()) {
            sl.ms("TTLottieFakeVideoPlayer", "--==--audio pause --- enter");
            this.ub.ah();
        }
        this.y = false;
        w();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ah() {
        op();
        com.bytedance.sdk.openadsdk.upie.ms.xr.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.6
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ms.this.h.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void d() {
        com.bykv.vk.openvk.component.video.api.ms msVar;
        sl.ms("TTLottieFakeVideoPlayer", "--==--stop");
        LottieAnimationView lottieAnimationView = this.ny;
        if (lottieAnimationView != null) {
            lottieAnimationView.c();
            this.qv = false;
        }
        if (this.t && !this.b && (msVar = this.ub) != null && msVar.zb()) {
            this.ub.ah();
        }
        w();
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ka() {
        sl.ms("TTLottieFakeVideoPlayer", "--==--release");
        this.b = true;
        w();
        this.hi.clear();
        this.ch = null;
        com.bykv.vk.openvk.component.video.api.ms msVar = this.ub;
        if (msVar != null) {
            if (this.t) {
                msVar.d();
            }
            this.ub.ka();
        }
        com.bytedance.sdk.openadsdk.upie.ms.xr.xr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.upie.video.lottie.ms.7
            @Override // java.lang.Runnable
            public void run() {
                ViewGroup viewGroup = (ViewGroup) ms.this.c.getView();
                if (viewGroup != null) {
                    viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(ms.this.jw);
                }
                Iterator it = ms.this.h.iterator();
                while (it.hasNext()) {
                    ((com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms) it.next()).ah(ms.this);
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean c() {
        sl.ms("TTLottieFakeVideoPlayer", "--==--isFirstFrameSuccess: " + this.t);
        return this.t;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean ny() {
        sl.ms("TTLottieFakeVideoPlayer", "--==--isCompleted: " + this.nw);
        return this.nw;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean ch() {
        sl.ms("TTLottieFakeVideoPlayer", "--==--isStarted: " + this.qv);
        return this.qv;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean zb() {
        sl.ms("TTLottieFakeVideoPlayer", "--==--isPlaying: " + this.y);
        return this.y;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean u() {
        boolean z = (this.y || this.nw || this.b || !this.t) ? false : true;
        sl.ms("TTLottieFakeVideoPlayer", "--==--isPaused: ".concat(String.valueOf(z)));
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public boolean ub() {
        sl.ms("TTLottieFakeVideoPlayer", "--==--isReleased: " + this.b);
        return this.b;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public int hi() {
        sl.ms("TTLottieFakeVideoPlayer", "--==--getVideoWidth: " + this.d);
        return this.d;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public int sl() {
        sl.ms("TTLottieFakeVideoPlayer", "--==--getVideoHeight: " + this.ka);
        return this.ka;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public long ao() {
        if (this.t) {
            sl.ms("TTLottieFakeVideoPlayer", "--==--getTotalBufferTime: " + this.pc);
            return this.pc;
        }
        sl.ms("TTLottieFakeVideoPlayer", "--==--is not prepared, getTotalBufferTime: 0");
        return 0L;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public int h() {
        sl.ms("TTLottieFakeVideoPlayer", "--==--getBufferCount: 1");
        return 1;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public long qv() {
        return this.ah;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public long y() {
        sl.ms("TTLottieFakeVideoPlayer", "--==--getCurrentPosition: " + this.op);
        return this.op;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ah(boolean z) {
        sl.ms("TTLottieFakeVideoPlayer", "--==--setLoop:".concat(String.valueOf(z)));
        this.re = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms interfaceC0179ms) {
        this.h.add(interfaceC0179ms);
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void xr(int i) {
        this.yu = i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.ms
    public void ms(float f) {
        this.cv = f;
    }
}
