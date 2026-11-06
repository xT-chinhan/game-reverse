package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.android.metrics.LiveMetrics;
import com.bytedance.sdk.component.utils.sl;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.ao.xr.xr.zb;
import com.bytedance.sdk.openadsdk.c.ah.h;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.qr;
import com.bytedance.sdk.openadsdk.core.nw.zf;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.widget.ub;
import com.bytedance.sdk.openadsdk.op.ch;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoDetail;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.bytedance.sdk.openadsdk.core.video.ms.ms {
    private Map<String, Object> am;
    private com.bykv.vk.openvk.component.video.api.d.ah.ms cv;
    private WeakReference<ms> e;
    private int eg;
    private final boolean g;
    private WeakReference<com.bykv.vk.openvk.component.video.api.d.ah.xr> jw;
    private int k;
    private int l;
    private WeakReference<com.bykv.vk.openvk.component.video.api.d.ah.d> lm;
    private String of;
    private boolean p;
    private boolean pc;
    private long qf;
    private long ti;
    private int v;
    private ViewGroup yu;
    private long op = 0;
    private long le = 0;
    private boolean f = false;
    private boolean ul = false;
    private boolean az = true;
    private volatile boolean m = false;
    private int fm = 0;
    private boolean xn = false;
    private boolean il = true;
    private com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms sa = new com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.1
        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void xr(com.bykv.vk.openvk.component.video.api.ms msVar, int i) {
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar) {
            d.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.1.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.il();
                }
            });
            d.this.ms(4);
            d.this.ah(4);
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, long j) {
            d.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.ka != null) {
                        if (!d.this.ti() || !re.xr().qo()) {
                            d.this.ka.xr();
                        } else {
                            d.this.ka.op();
                        }
                        d.this.f3587ms.removeCallbacks(d.this.w);
                        d.this.xn = false;
                    }
                    if (d.this.e != null && d.this.e.get() != null) {
                        ((ms) d.this.e.get()).B_();
                    }
                    d.this.f3587ms.removeCallbacks(d.this.w);
                }
            });
            d.this.tz();
            d.this.qf = System.currentTimeMillis();
            d.this.rt();
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void xr(com.bykv.vk.openvk.component.video.api.ms msVar) {
            if (!d.this.g || ch.ms(d.this.c)) {
                d.this.tz();
            }
            d.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.lm != null && d.this.lm.get() != null) {
                        ((com.bykv.vk.openvk.component.video.api.d.ah.d) d.this.lm.get()).D_();
                    }
                    if (d.this.ka != null && (!d.this.ti() || !re.xr().qo())) {
                        d.this.ka.xr();
                    }
                    d.this.f3587ms.removeCallbacks(d.this.w);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, final com.bykv.vk.openvk.component.video.api.ah.xr xrVar) {
            d.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.1.4
                /* JADX WARN: Code duplicated, block: B:27:0x00d9  */
                /* JADX WARN: Code duplicated, block: B:30:0x00ee  */
                @Override // java.lang.Runnable
                public void run() {
                    int iMs = xrVar.ms();
                    int iXr = xrVar.xr();
                    d.this.ms(iMs, iXr, xrVar.ah(), (JSONArray) null);
                    sl.d("NativeVideoController", "CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、");
                    if (!d.this.k() || iXr == -1004) {
                        sl.d("NativeVideoController", "出错后 errorcode,extra、、、、、、、" + iMs + "," + iXr);
                        if (!d.this.d(iMs, iXr) && !com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(d.this.c)) {
                            if (iMs == 1 && (iXr == -19 || iXr == -38)) {
                                if (d.this.ka != null) {
                                    d.this.ka.ms2(d.this.c, d.this.ny, false);
                                }
                            }
                            if (d.this.ka != null) {
                                d.this.ka.xr();
                            }
                            if (d.this.cv != null) {
                                d.this.cv.xr(d.this.le, com.bykv.vk.openvk.component.video.ms.ka.ms.ms(d.this.ab, d.this.ao));
                            }
                            if (d.this.lm != null || d.this.lm.get() == null || d.this.k()) {
                                return;
                            }
                            ((com.bykv.vk.openvk.component.video.api.d.ah.d) d.this.lm.get()).ms(iMs, iXr);
                            return;
                        }
                        sl.d("NativeVideoController", "出错后展示结果页、、、、、、、");
                        if (d.this.ka != null) {
                            d.this.ka.ms2(d.this.c, d.this.ny, false);
                        }
                        d.this.ah(true);
                        d.this.ch();
                        if (d.this.ka != null) {
                            d.this.ka.xr();
                        }
                        if (d.this.cv != null) {
                            d.this.cv.xr(d.this.le, com.bykv.vk.openvk.component.video.ms.ka.ms.ms(d.this.ab, d.this.ao));
                        }
                        if (d.this.lm != null) {
                        }
                    }
                }
            });
            d.this.ms(xrVar.ms(), xrVar.ah());
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, boolean z) {
            d.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.1.5
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.ka != null) {
                        d.this.ka.xr();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ah(com.bykv.vk.openvk.component.video.api.ms msVar) {
            d.this.vm();
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, final int i, final int i2) {
            d.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.1.6
                @Override // java.lang.Runnable
                public void run() {
                    d.this.xr(i, i2);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, int i, int i2, int i3) {
            d.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.1.7
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.ka != null) {
                        d.this.ka.re();
                        d.this.f3587ms.postDelayed(d.this.w, 8000L);
                        d.this.xn = true;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, int i) {
            d.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.1.8
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.ka != null) {
                        d.this.ka.xr();
                    }
                    d.this.f3587ms.removeCallbacks(d.this.w);
                    d.this.xn = false;
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, final long j, final long j2) {
            if (Math.abs(j - d.this.ab) < 50) {
                return;
            }
            d.this.f3587ms.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.1.9
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.re != null) {
                        d.this.re.ms(j, j2);
                    }
                    d.this.xr(j, j2);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.ms.InterfaceC0179ms
        public void ms(com.bykv.vk.openvk.component.video.api.ms msVar, JSONObject jSONObject, String str) {
            if (com.bytedance.sdk.openadsdk.core.ch.ub().fm()) {
                jSONObject.optString("start");
                jSONObject.optString("sdk_dns_analysis_end");
                jSONObject.optString("player_dns_analysis_end");
                jSONObject.optString("tcp_connect_end");
                jSONObject.optString("tcp_first_package_end");
                jSONObject.optString("first_video_package_end");
                jSONObject.optString("first_frame_video_decode_end");
                jSONObject.optString("first_frame_render_end");
                jSONObject.optLong("first_frame_render_end");
                jSONObject.optLong("start");
            }
            com.bytedance.sdk.openadsdk.core.zb.ah.ms((Context) d.this.ny.get(), d.this.c, d.this.of, "pangle_live_sdk_monitor", jSONObject);
        }
    };
    private int tz = 0;
    Runnable w = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.4
        @Override // java.lang.Runnable
        public void run() {
            if (d.this.ka != null) {
                d.this.ka.ms2(d.this.c, d.this.ny, false);
                d.this.ka.xr();
                d.this.ah(true);
                sl.d("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
            }
        }
    };
    private final w.ms s = new w.ms() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.6
        @Override // com.bytedance.sdk.component.utils.w.ms
        public void ms(Context context, Intent intent, boolean z, int i) {
            d.this.ah(context, i);
        }
    };
    private boolean qk = false;

    public interface ms {
        void B_();

        void ms(int i);

        void ny();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(int i, int i2) {
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200 || i == 60008;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public boolean ah() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.ms.ms, com.bykv.vk.openvk.component.video.api.d.ah
    public boolean d() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.ms.ms, com.bykv.vk.openvk.component.video.api.d.ah
    public boolean ka() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.ms.ms
    public boolean op() {
        return true;
    }

    public void ka(int i) {
        this.l = i;
    }

    public void ms(lm lmVar) {
        this.c = lmVar;
    }

    public void ms(com.bytedance.sdk.openadsdk.nw.ms.xr.ms.ms msVar) {
        if (this.ka != null) {
            this.ka.ms(msVar);
        }
    }

    public void ms(final NativeVideoTsView.ms msVar) {
        if (!this.sl || this.ka == null) {
            return;
        }
        this.ka.ms(new NativeVideoTsView.ms() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.ms
            public void ms(View view, int i) {
                NativeVideoTsView.ms msVar2 = msVar;
                if (msVar2 != null) {
                    msVar2.ms(view, i);
                }
            }
        });
    }

    public void ms(zb zbVar) {
        if (!this.sl || this.ka == null) {
            return;
        }
        this.ka.ms(zbVar);
    }

    public void ms(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.k = i;
        this.eg = i2;
    }

    private void ms(Context context) {
        EnumSet<com.bykv.vk.openvk.component.video.api.d.xr.ms> enumSetNoneOf = EnumSet.noneOf(com.bykv.vk.openvk.component.video.api.d.xr.ms.class);
        enumSetNoneOf.add(com.bykv.vk.openvk.component.video.api.d.xr.ms.hideCloseBtn);
        enumSetNoneOf.add(com.bykv.vk.openvk.component.video.api.d.xr.ms.hideBackBtn);
        try {
            this.ka = ms(context, enumSetNoneOf);
            if (this.ka != null) {
                this.ka.ms((com.bykv.vk.openvk.component.video.api.d.ms) this);
                this.ka.ms((com.bytedance.sdk.openadsdk.core.multipro.xr.ms.InterfaceC0296ms) this);
            }
        } catch (Throwable th) {
            sl.d("NativeVideoController", th.getMessage());
        }
    }

    protected c ms(Context context, EnumSet<com.bykv.vk.openvk.component.video.api.d.xr.ms> enumSet) {
        View layoutVideoDetail;
        if (this.sl) {
            layoutVideoDetail = xr(context);
        } else {
            layoutVideoDetail = new LayoutVideoDetail(context);
        }
        View view = layoutVideoDetail;
        if (view == null) {
            return null;
        }
        if (this.sl) {
            return new c(context, view, true, enumSet, this.c, this, ul(), null);
        }
        return new ka(context, view, true, enumSet, this.c, this, false);
    }

    private View xr(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387720);
        relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(2114387906);
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setId(2114387657);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        tTProgressBar.setId(2114387637);
        layoutParams3.addRule(13, -1);
        tTProgressBar.setLayoutParams(layoutParams3);
        tTProgressBar.setIndeterminateDrawable(t.ah(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(tTProgressBar);
        View viewXr = new com.bytedance.sdk.openadsdk.res.layout.video.d().xr(context);
        viewXr.setId(2114387694);
        viewXr.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(viewXr);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setId(2114387632);
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        t.ms(context, "tt_play_movebar_textpage", imageView2);
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        TTProgressBar tTProgressBar2 = new TTProgressBar(context, null, t.ab(context, "tt_Widget_ProgressBar_Horizontal"));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
        tTProgressBar2.setMax(100);
        tTProgressBar2.setId(2114387659);
        tTProgressBar2.setBackgroundColor(0);
        tTProgressBar2.setIndeterminateDrawable(null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float fAh = ul.ah(context, 1.0f);
        gradientDrawable.setCornerRadius(fAh);
        int iAh = ul.ah(context, 2.0f);
        gradientDrawable.setSize(-1, iAh);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(fAh);
        gradientDrawable2.setSize(-1, iAh);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(fAh);
        gradientDrawable3.setSize(-1, iAh);
        tTProgressBar2.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar2.setVisibility(8);
        layoutParams5.addRule(12, -1);
        tTProgressBar2.setLayoutParams(layoutParams5);
        relativeLayout.addView(tTProgressBar2);
        TTViewStub tTViewStub = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.c());
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387750);
        tTViewStub.setLayoutParams(layoutParams6);
        relativeLayout.addView(tTViewStub);
        TTViewStub tTViewStub2 = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.xr());
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub2.setId(2114387672);
        tTViewStub2.setLayoutParams(layoutParams7);
        relativeLayout.addView(tTViewStub2);
        TTViewStub tTViewStub3 = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.ab());
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13, -1);
        tTViewStub3.setId(2114387834);
        tTViewStub3.setLayoutParams(layoutParams8);
        relativeLayout.addView(tTViewStub3);
        return relativeLayout;
    }

    public d(Context context, ViewGroup viewGroup, lm lmVar, String str, boolean z, boolean z2, boolean z3) {
        this.of = "embeded_ad";
        this.p = false;
        this.pc = true;
        this.k = 0;
        this.eg = 0;
        this.v = 1;
        this.v = u.ah(context);
        ms(z);
        this.of = str;
        try {
            this.k = viewGroup.getWidth();
            this.eg = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.yu = viewGroup;
        this.ny = new WeakReference<>(context);
        this.c = lmVar;
        ms(context);
        this.g = true;
        this.p = z2;
        this.pc = z3;
    }

    public d(Context context, ViewGroup viewGroup, lm lmVar, String str, boolean z, boolean z2) {
        this.of = "embeded_ad";
        this.p = false;
        this.pc = true;
        this.k = 0;
        this.eg = 0;
        this.v = 1;
        this.v = u.ah(context);
        try {
            this.k = viewGroup.getWidth();
            this.eg = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.yu = viewGroup;
        this.of = str;
        this.ny = new WeakReference<>(context);
        this.c = lmVar;
        ms(context);
        this.g = true;
        this.p = z;
        this.pc = z2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ms(com.bykv.vk.openvk.component.video.api.d.ah.d dVar) {
        this.lm = new WeakReference<>(dVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public boolean ms(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        dVar.ao();
        if (TextUtils.isEmpty(dVar.ao())) {
            ms("url is null");
            sl.d("tag_video_play", "[video] play video stop , because no video info");
            return false;
        }
        this.b = dVar;
        this.h = dVar.hi();
        this.ab = dVar.ch();
        if (dVar.ch() > 0) {
            this.ab = dVar.ch();
            this.x = this.x > this.ab ? this.x : this.ab;
        }
        if (this.ka != null) {
            this.ka.ms();
            if (this.tz == 0) {
                this.ka.ab();
            }
            this.ka.ah(dVar.x(), dVar.ny());
            this.ka.ah(this.yu);
            this.ka.ms(dVar.x(), dVar.ny());
        }
        try {
            if (this.d == null) {
                if (!xn()) {
                    ms("create video error");
                    return false;
                }
                this.d.ms(this.sa);
            }
            yu();
            this.le = 0L;
            d(dVar);
            return true;
        } catch (Throwable th) {
            ms(th.getMessage());
            sl.d("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + th.toString());
            return false;
        }
    }

    private boolean xn() {
        com.bykv.vk.openvk.component.video.api.ms dVar;
        lm lmVar = this.c;
        if (com.bytedance.sdk.openadsdk.ka.ms.xr(lmVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.xr xrVarRe = re();
            if (xrVarRe != null) {
                this.d = new com.bytedance.sdk.openadsdk.upie.video.lottie.ms(xrVarRe, com.bytedance.sdk.openadsdk.ka.ms.ny(lmVar), new com.bykv.vk.openvk.component.video.ms.d.d(String.valueOf(f.x(this.c))), qr.h(lmVar));
            } else {
                if (this.sa != null) {
                    this.sa.ms((com.bykv.vk.openvk.component.video.api.ms) null, new com.bykv.vk.openvk.component.video.api.ah.xr(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建lottie播放器时，iRenderView为null, mediaLayout is null: " + (this.ka == null)));
                }
                sl.d("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else if (com.bytedance.sdk.openadsdk.ka.ms.ah(lmVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.xr xrVarRe2 = re();
            if (xrVarRe2 != null) {
                int iX = f.x(this.c);
                if (g.d() && this.b.qv() == 1) {
                    dVar = new com.bytedance.sdk.component.sl.xr.xr(re.getContext(), String.valueOf(iX));
                } else {
                    dVar = new com.bykv.vk.openvk.component.video.ms.d.d(String.valueOf(iX));
                }
                this.d = new com.bytedance.sdk.openadsdk.upie.video.lottie.xr(dVar, com.bytedance.sdk.openadsdk.ka.ms.ny(lmVar), xrVarRe2);
            } else {
                if (this.sa != null) {
                    this.sa.ms((com.bykv.vk.openvk.component.video.api.ms) null, new com.bykv.vk.openvk.component.video.api.ah.xr(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建Upie播放器时，iRenderView为null, mediaLayout is null: " + (this.ka == null)));
                }
                sl.d("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else {
            int iX2 = f.x(this.c);
            if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.c)) {
                this.d = new com.bytedance.sdk.component.sl.ms.ms(re.getContext(), op(), (long) qr.c(this.c), re.xr().vl(), null);
            } else if (g.d() && this.b.qv() == 1) {
                this.d = new com.bytedance.sdk.component.sl.xr.xr(re.getContext(), String.valueOf(iX2));
            } else {
                this.d = new com.bykv.vk.openvk.component.video.ms.d.d(String.valueOf(iX2));
            }
        }
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public int ub() {
        return com.bykv.vk.openvk.component.video.ms.ka.ms.ms(this.x, this.ao);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void xr(Map<String, Object> map) {
        this.am = map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.ms.ms
    protected Map<String, Object> e() {
        return this.am;
    }

    private void d(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        if (dVar == null) {
            ms("model is null");
            return;
        }
        final long jAh = ah(dVar);
        if (this.d != null) {
            if (this.c != null) {
                dVar.d(String.valueOf(f.ny(this.c)));
            }
            dVar.d(0);
            this.d.ms(dVar);
            this.d.ms(g());
        }
        this.op = System.currentTimeMillis();
        if (!TextUtils.isEmpty(dVar.ao())) {
            if (this.ka != null) {
                this.ka.ka(8);
                this.ka.ka(0);
            }
            boolean zAh = f.ah(this.c);
            boolean zXr = this.ka != null ? com.bytedance.sdk.openadsdk.core.f.xr(this.ka.f3616ms, 50, 9) : true;
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.3
                @Override // java.lang.Runnable
                public void run() {
                    d.this.nw.ms();
                    d.this.lm();
                    d.this.op = System.currentTimeMillis();
                    if (d.this.ka != null) {
                        d.this.ka.d(0);
                    }
                    if (d.this.d == null || d.this.ab != 0) {
                        if (d.this.d != null) {
                            d.this.d.ms(true, d.this.ab, d.this.h);
                            return;
                        }
                        return;
                    }
                    d.this.d.ms(true, jAh, d.this.h);
                }
            };
            if (zAh && !zXr) {
                xr(runnable);
                x(true);
                WeakReference<ms> weakReference = this.e;
                if (weakReference != null && weakReference.get() != null) {
                    this.e.get().ny();
                }
            } else {
                ms(runnable);
            }
        } else {
            ms("url is null");
        }
        if (this.sl) {
            eg();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ms(com.bykv.vk.openvk.component.video.api.d.ah.xr xrVar) {
        this.jw = new WeakReference<>(xrVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.ms.ms, com.bykv.vk.openvk.component.video.api.d.ah
    public long sl() {
        if (h() == null) {
            return 0L;
        }
        return h().ao();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public int zb() {
        if (h() == null) {
            return 0;
        }
        return h().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void il() {
        this.tz++;
        if (le() && this.ka != null) {
            this.ka.xr();
            com.bykv.vk.openvk.component.video.api.d.ah.ms msVar = this.cv;
            if (msVar != null) {
                msVar.ms(this.le, com.bykv.vk.openvk.component.video.ms.ka.ms.ms(this.ab, this.ao));
            }
            this.le = System.currentTimeMillis() - this.op;
            this.ka.ka(true);
            boolean zMs = com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.c);
            int iAm = this.c.am();
            boolean z = iAm <= 0;
            boolean z2 = !z && this.tz >= iAm;
            boolean zAh = f.ah(this.c);
            if (!zAh || z2 || zMs) {
                this.ka.ms2(this.c, this.ny, true);
            }
            if (!this.nw.ms(64) || qf() || l()) {
                this.nw.ah(64);
                xr(this.ao, this.ao);
                long j = this.ao;
                this.ab = j;
                this.x = j;
                h.ms msVar2 = new h.ms();
                msVar2.ms(hi());
                msVar2.ah(u());
                msVar2.xr(sl());
                msVar2.c(zb());
                com.bytedance.sdk.openadsdk.c.xr.d.d(this.ka, msVar2);
            }
            if (!this.sl && this.t) {
                ka(this.ka, null);
            }
            this.y = true;
            if (zMs) {
                return;
            }
            if (zAh && (z || this.tz < iAm)) {
                w();
                return;
            }
            if (!(ch.ms(this.c) && (((u() / 1000) > 10L ? 1 : ((u() / 1000) == 10L ? 0 : -1)) < 0)) || this.tz >= 2) {
                return;
            }
            w();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ms(com.bykv.vk.openvk.component.video.api.d.ah.ms msVar) {
        this.cv = msVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void c() {
        if (this.d != null) {
            this.d.ah();
        }
        if ((!this.nw.ms(64) || qf()) && this.nw.ms(2)) {
            h.ms msVar = new h.ms();
            msVar.ms(hi());
            msVar.ah(u());
            msVar.xr(sl());
            ms(this.ka, msVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ms(Map<String, Object> map) {
        if (this.d != null) {
            this.d.ah();
        }
        if ((!this.nw.ms(64) || qf()) && this.nw.ms(2)) {
            h.ms msVar = new h.ms();
            msVar.ms(hi());
            msVar.ah(u());
            msVar.xr(sl());
            if (map != null) {
                msVar.ms(map);
            }
            ms(this.ka, msVar);
        }
    }

    private boolean qf() {
        return this.tz > 0 && f.ah(this.c);
    }

    private boolean l() {
        return this.tz > 0 && ch.ms(this.c);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ab() {
        if (this.d != null) {
            this.d.ah();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void x() {
        if (this.ka != null) {
            this.ka.ms();
        }
        if (this.ka != null) {
            this.ka.i();
        }
        sa();
    }

    public void c(boolean z) {
        if (this.ka != null) {
            this.ka.ms();
        }
        if (this.ka != null && z) {
            this.ka.i();
        }
        sa();
    }

    private boolean am() {
        return this.sl && com.bytedance.sdk.openadsdk.core.ch.ub().s() > 0;
    }

    private void sa() {
        sl.ms("NativeVideoController", "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.ch));
        if (this.d != null) {
            if (this.d.u() && !am()) {
                if (this.ch || ((this.b != null && this.b.ab()) || com.bytedance.sdk.openadsdk.ka.ms.xr(this.c))) {
                    jw();
                } else {
                    xr(this.i);
                }
                sl.ms("NativeVideoController", "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.ch));
            } else if (am()) {
                this.ab = com.bytedance.sdk.openadsdk.core.ch.ub().s();
                com.bytedance.sdk.openadsdk.core.ch.ub().ms(-1L);
                this.d.ms(this.ab);
                this.d.xr();
            } else {
                this.d.ms(false, this.ab, this.h);
            }
        }
        if (this.nw.ms(2)) {
            h.ms msVar = new h.ms();
            msVar.ms(hi());
            msVar.ah(u());
            msVar.xr(sl());
            xr(qv(), msVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ms(long j) {
        this.ab = j;
        this.x = this.x > this.ab ? this.x : this.ab;
        if (this.ka != null) {
            this.ka.ms();
        }
        if (this.d != null) {
            this.d.ms(true, this.ab, this.h);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ny() {
        ms(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ms(boolean z, int i) {
        if (this.sl) {
            ms(1);
        }
        long jU = u();
        if ((!this.nw.ms(64) || qf()) && this.nw.ms(1) && jU > 0) {
            if (z) {
                h.ms msVar = new h.ms();
                msVar.ms(hi());
                msVar.ah(jU);
                msVar.xr(sl());
                msVar.ka(i);
                msVar.c(zb());
                this.nw.ah(32);
                com.bytedance.sdk.openadsdk.c.xr.d.ms(this.ka, msVar, this.am, !this.nw.ms(2) ? 1 : 0);
            } else {
                h.ms msVar2 = new h.ms();
                msVar2.ms(hi());
                msVar2.ah(jU);
                msVar2.xr(sl());
                ms(this.ka, msVar2);
            }
        }
        ch();
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ch() {
        ah(u() == 0 ? -2 : -1);
        if (this.d != null) {
            this.d.ka();
            this.d = null;
        }
        int iAm = this.c == null ? 2 : this.c.am();
        boolean z = iAm > 0 && this.tz == iAm;
        if (!f.ah(this.c) || z) {
            try {
                this.ka.ms2(this.c, this.ny, true);
            } catch (Exception e) {
                sl.d("NativeVideoController", e.getMessage());
            }
        }
        if (this.f3587ms != null) {
            this.f3587ms.removeCallbacksAndMessages(null);
        }
        if (this.hi != null) {
            this.hi.clear();
        }
        fm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tz() {
        if (!this.nw.ms(2) || qf()) {
            h.ms msVar = new h.ms();
            if (ti()) {
                this.az = true;
            }
            msVar.xr(this.az);
            msVar.ah(u());
            this.nw.ah(2);
            com.bytedance.sdk.openadsdk.c.xr.d.ms(this.ka, msVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0086  */
    /* JADX WARN: Code duplicated, block: B:43:0x008d A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:62:0x00e1, B:64:0x00e5, B:65:0x00ea), top: B:68:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0091 A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:62:0x00e1, B:64:0x00e5, B:65:0x00ea), top: B:68:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00a3 A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:62:0x00e1, B:64:0x00e5, B:65:0x00ea), top: B:68:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a9 A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:62:0x00e1, B:64:0x00e5, B:65:0x00ea), top: B:68:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x00ad A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:62:0x00e1, B:64:0x00e5, B:65:0x00ea), top: B:68:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00b3 A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:62:0x00e1, B:64:0x00e5, B:65:0x00ea), top: B:68:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00b7 A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:62:0x00e1, B:64:0x00e5, B:65:0x00ea), top: B:68:0x0000 }] */
    protected void xr(int i, int i2) {
        ViewGroup viewGroup;
        int iRound;
        int iRound2;
        RelativeLayout.LayoutParams layoutParams;
        Object objRe;
        ViewGroup.LayoutParams layoutParams2;
        try {
            if (this.ny != null && this.ny.get() != null && re() != null && this.d != null && (viewGroup = this.yu) != null && viewGroup != null) {
                if (i < 0 && i2 < 0) {
                    i = this.d.hi();
                    i2 = this.d.sl();
                }
                int width = this.yu.getWidth();
                int height = this.yu.getHeight();
                if (width > 0 && height > 0 && i2 > 0 && i > 0) {
                    if (i != i2) {
                        if (i > i2) {
                            iRound = (int) Math.round((((double) width) * 1.0d) / ((double) ((i * 1.0f) / i2)));
                            iRound2 = width;
                        } else if (s()) {
                            iRound = 0;
                        } else {
                            iRound2 = (int) Math.round(((double) (height * 1.0f)) / ((double) ((i2 * 1.0f) / i)));
                            iRound = height;
                        }
                        if (iRound <= height || iRound <= 0) {
                            iRound = height;
                        }
                        if (xr(i, i2, iRound2, width)) {
                            iRound2 = width;
                        }
                        if (s()) {
                            ms(i, i2, width, height);
                            return;
                        }
                        layoutParams = new RelativeLayout.LayoutParams(iRound2, iRound);
                        layoutParams.addRule(13);
                        objRe = re();
                        if (objRe instanceof TextureView) {
                            ((TextureView) objRe).setLayoutParams(layoutParams);
                        } else if (objRe instanceof UpieVideoView) {
                            ((UpieVideoView) objRe).setLayoutParams(layoutParams);
                        } else if (objRe instanceof SurfaceView) {
                            ((SurfaceView) objRe).setLayoutParams(layoutParams);
                        }
                        if (ah(i, i2) || (layoutParams2 = this.yu.getLayoutParams()) == null) {
                            return;
                        }
                        layoutParams2.height = iRound;
                        layoutParams2.width = iRound2;
                        this.yu.setLayoutParams(layoutParams2);
                        if (this.ka != null) {
                            this.ka.ms(layoutParams2.width, layoutParams2.height);
                            return;
                        }
                        return;
                    }
                    iRound = width > height ? height : width;
                    iRound2 = iRound;
                    if (iRound <= height) {
                        iRound = height;
                    } else {
                        iRound = height;
                    }
                    if (xr(i, i2, iRound2, width)) {
                        iRound2 = width;
                    }
                    if (s()) {
                        ms(i, i2, width, height);
                        return;
                    }
                    layoutParams = new RelativeLayout.LayoutParams(iRound2, iRound);
                    layoutParams.addRule(13);
                    objRe = re();
                    if (objRe instanceof TextureView) {
                        ((TextureView) objRe).setLayoutParams(layoutParams);
                    } else if (objRe instanceof UpieVideoView) {
                        ((UpieVideoView) objRe).setLayoutParams(layoutParams);
                    } else if (objRe instanceof SurfaceView) {
                        ((SurfaceView) objRe).setLayoutParams(layoutParams);
                    }
                    if (ah(i, i2)) {
                        return;
                    } else {
                        return;
                    }
                }
                return;
            }
            if (this.ny != null) {
                this.ny.get();
            }
            re();
        } catch (Throwable unused) {
        }
    }

    private void ms(int i, int i2, int i3, int i4) {
        Matrix matrix;
        if (i3 == 0 || i4 == 0) {
            return;
        }
        float f = i3;
        float f2 = i;
        float f3 = f / f2;
        float f4 = i4;
        float f5 = i2;
        float f6 = f4 / f5;
        try {
            Object objRe = re();
            if (objRe instanceof TextureView) {
                matrix = ((TextureView) objRe).getMatrix();
            } else if (objRe instanceof UpieVideoView) {
                matrix = ((UpieVideoView) objRe).getMatrix();
            } else {
                matrix = objRe instanceof SurfaceView ? ((SurfaceView) objRe).getMatrix() : null;
            }
            float fMax = Math.max(f3, f6);
            if (matrix == null) {
                matrix = new Matrix();
            } else {
                matrix.reset();
            }
            matrix.preTranslate((i3 - i) / 2, (i4 - i2) / 2);
            matrix.preScale(f2 / f, f5 / f4);
            matrix.postScale(fMax, fMax, i3 / 2, i4 / 2);
            if (objRe instanceof TextureView) {
                ((TextureView) objRe).setTransform(matrix);
                ((TextureView) objRe).postInvalidate();
            } else if (objRe instanceof UpieVideoView) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ((UpieVideoView) objRe).setAnimationMatrix(matrix);
                }
                ((UpieVideoView) objRe).postInvalidate();
            } else if (objRe instanceof SurfaceView) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ((SurfaceView) objRe).setAnimationMatrix(matrix);
                }
                ((SurfaceView) objRe).postInvalidate();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ti() {
        return TextUtils.equals(this.of, "splash_ad") || TextUtils.equals(this.of, "cache_splash_ad");
    }

    private boolean s() {
        zf zfVarM22do;
        if (ti()) {
            return this.c == null || (zfVarM22do = this.c.m22do()) == null || zfVarM22do.ms() != 0;
        }
        return false;
    }

    private boolean xr(int i, int i2, int i3, int i4) {
        return (i3 > i4 && !ah(i, i2)) || i3 <= 0;
    }

    private boolean ah(int i, int i2) {
        return i < i2 && v();
    }

    private boolean v() {
        return this.c != null && this.c.v() == 1 && "draw_ad".equals(this.of) && this.yu != null;
    }

    protected com.bykv.vk.openvk.component.video.api.renderview.xr re() {
        if (this.ny == null || this.ny.get() == null) {
            return null;
        }
        if ((this.ny.get().getResources().getConfiguration().orientation == 1 || com.bytedance.sdk.openadsdk.ka.ms.ms(this.c)) && this.ka != null) {
            return this.ka.h();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ms(com.bykv.vk.openvk.component.video.api.d.xr xrVar, View view) {
        if (this.d == null || !le()) {
            return;
        }
        if (this.d.zb()) {
            c();
            if (this.ka != null) {
                this.ka.xr(true, false);
                this.ka.c();
                return;
            }
            return;
        }
        if (!this.d.u()) {
            if (this.ka != null) {
                this.ka.ah(this.yu);
            }
            ms(this.ab);
            if (this.ka != null) {
                this.ka.xr(false, false);
                return;
            }
            return;
        }
        c(false);
        if (this.ka != null) {
            this.ka.xr(false, false);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ms(com.bykv.vk.openvk.component.video.api.d.xr xrVar, int i) {
        if (this.d == null) {
            return;
        }
        ms(this.ti, ab(i));
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void xr(com.bykv.vk.openvk.component.video.api.d.xr xrVar, int i) {
        if (this.ka != null) {
            this.ka.c();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ms(com.bykv.vk.openvk.component.video.api.d.xr xrVar, int i, boolean z) {
        if (le()) {
            long j = (long) (((((long) i) * this.ao) * 1.0f) / 100.0f);
            if (this.ao > 0) {
                this.ti = (int) j;
            } else {
                this.ti = 0L;
            }
            if (this.ka != null) {
                this.ka.ms(this.ti);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(long j, long j2) {
        this.ab = j;
        this.ao = j2;
        if (this.ka != null) {
            this.ka.ms(j, j2);
            this.ka.xr(com.bykv.vk.openvk.component.video.ms.ka.ms.ms(j, j2));
        }
        try {
            com.bykv.vk.openvk.component.video.api.d.ah.ms msVar = this.cv;
            if (msVar != null) {
                msVar.ms(j, j2);
            }
        } catch (Throwable th) {
            sl.ah("NativeVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void xr(com.bykv.vk.openvk.component.video.api.d.xr xrVar, View view) {
        xr(xrVar, view, false, false);
    }

    public void xr(com.bykv.vk.openvk.component.video.api.d.xr xrVar, View view, boolean z, boolean z2) {
        if (le()) {
            ny(!this.t);
            if (this.ny.get() instanceof Activity) {
                if (this.t) {
                    c(z ? 8 : 0);
                    if (this.ka != null) {
                        this.ka.ms(this.yu);
                        this.ka.ah(false);
                    }
                } else {
                    c(1);
                    if (this.ka != null) {
                        this.ka.xr(this.yu);
                        this.ka.ah(false);
                    }
                }
                WeakReference<com.bykv.vk.openvk.component.video.api.d.ah.xr> weakReference = this.jw;
                com.bykv.vk.openvk.component.video.api.d.ah.xr xrVar2 = weakReference != null ? weakReference.get() : null;
                if (xrVar2 != null) {
                    xrVar2.ms(this.t);
                }
            }
        }
    }

    public void c(int i) {
        if (le()) {
            boolean z = i == 0 || i == 8;
            Context context = this.ny.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i);
                } catch (Throwable unused) {
                }
                if (!z) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ah(com.bykv.vk.openvk.component.video.api.d.xr xrVar, View view) {
        if (this.ka != null) {
            this.ka.ny();
        }
        ms(1);
        ms(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ms(com.bykv.vk.openvk.component.video.api.d.xr xrVar, View view, boolean z, boolean z2) {
        if (this.sl) {
            c();
        }
        if (this.ka == null) {
            return;
        }
        if (z && !this.sl && !i()) {
            this.ka.xr(!k(), false);
            this.ka.ms(z2, true, false);
        }
        if (this.d != null && this.d.zb()) {
            this.ka.c();
            this.ka.ka();
        } else {
            this.ka.c();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void d(com.bykv.vk.openvk.component.video.api.d.xr xrVar, View view) {
        if (this.t) {
            ny(false);
            if (this.ka != null) {
                this.ka.xr(this.yu);
            }
            c(1);
            return;
        }
        ms(1);
        ms(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ka(com.bykv.vk.openvk.component.video.api.d.xr xrVar, View view) {
        ms(xrVar, view, false);
    }

    public void ms(com.bykv.vk.openvk.component.video.api.d.xr xrVar, View view, boolean z) {
        qk();
    }

    private void qk() {
        if (le()) {
            ny(!this.t);
            if (this.ny.get() instanceof Activity) {
                if (this.ka != null) {
                    this.ka.xr(this.yu);
                    this.ka.ah(false);
                }
                c(1);
                WeakReference<com.bykv.vk.openvk.component.video.api.d.ah.xr> weakReference = this.jw;
                com.bykv.vk.openvk.component.video.api.d.ah.xr xrVar = weakReference != null ? weakReference.get() : null;
                if (xrVar != null) {
                    xrVar.ms(this.t);
                }
            }
        }
    }

    public boolean i() {
        return this.d == null || this.d.ny();
    }

    public void w() {
        if (u.ah(re.getContext()) == 0) {
            return;
        }
        if (this.ka != null) {
            this.ka.ms();
        }
        ah(false);
        if (this.d != null) {
            this.nw.ms();
            lm();
            this.d.ms();
            tz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vm() {
        if (!this.m || this.ka == null || this.ka.ah() == null) {
            return;
        }
        this.m = false;
        this.ka.ah().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.b == null) {
                    return;
                }
                d.this.b.xr(d.this.c.df());
                d.this.b.xr(d.this.k);
                d.this.b.ah(d.this.eg);
                d.this.b.ms((List<String>) null);
                d.this.b.ah(d.this.c.lx());
                d.this.b.ms(0L);
                d.this.b.xr(d.this.y());
                d.this.b.ms(d.this.b.ka());
                d dVar = d.this;
                dVar.ms(dVar.b);
                d.this.ah(false);
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ms
    public void ms() {
        if (u.ah(re.getContext()) == 0) {
            return;
        }
        this.m = true;
        if (this.d == null) {
            ch();
            vm();
        } else {
            ch();
        }
    }

    public boolean k() {
        return this.d != null && this.d.zb();
    }

    private void ms(long j, boolean z) {
        if (this.d == null) {
            return;
        }
        if (z) {
            zf();
        }
        this.d.ms(j);
    }

    private boolean ab(int i) {
        return this.ka != null && this.ka.ah(i);
    }

    private void zf() {
        if (this.ka != null) {
            this.ka.d(0);
            this.ka.ms(false, false);
            this.ka.ah(false);
            this.ka.ka();
            this.ka.ab();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.d$9, reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        static final /* synthetic */ int[] f3649ms;

        static {
            int[] iArr = new int[ub.ms.values().length];
            f3649ms = iArr;
            try {
                iArr[ub.ms.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3649ms[ub.ms.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3649ms[ub.ms.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.xr
    public void ms(ub.ms msVar, String str) {
        int i = AnonymousClass9.f3649ms[msVar.ordinal()];
        if (i == 1) {
            c();
            return;
        }
        if (i == 2) {
            ms(true, 3);
        } else {
            if (i != 3) {
                return;
            }
            x();
            this.ub = false;
            this.f = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(int i) {
        int iAh = u.ah(re.getContext());
        if (iAh == 0) {
            c();
            this.ub = true;
            if (this.ka != null) {
                this.ka.ms2(this.c, this.ny, false);
            }
        }
        if (iAh != 4 && iAh != 0) {
            if (this.ka != null) {
                this.ka.ms();
            }
            c();
            this.ub = true;
            this.f = false;
            if (this.ka != null && this.c != null) {
                return this.ka.ms(i, qr.u(this.c), this.pc);
            }
        } else if (iAh == 4) {
            this.ub = false;
            if (this.ka != null) {
                this.ka.t();
            }
        }
        return true;
    }

    private void xr(Context context, int i) {
        if (!le() || context == null || this.v == i) {
            return;
        }
        this.v = i;
        if (i != 4 && i != 0) {
            this.f = false;
        }
        if (!this.f && !t() && this.p) {
            x.xr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.7
                @Override // java.lang.Runnable
                public void run() {
                    d.this.x(2);
                }
            });
        }
        WeakReference<ms> weakReference = this.e;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.e.get().ms(this.v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ah(Context context, int i) {
        xr(context, i);
        if (i == 4) {
            this.ub = false;
        }
    }

    public void ms(Context context, int i) {
        xr(context, i);
        if (i == 4) {
            this.ub = false;
            x.xr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.d.8
                @Override // java.lang.Runnable
                public void run() {
                    d.this.x();
                }
            });
        }
    }

    public void eg() {
        if (this.qk || !this.il) {
            return;
        }
        this.qk = true;
        w.ms(this.s, re.getContext().getApplicationContext());
    }

    public void fm() {
        if (this.qk) {
            this.qk = false;
            try {
                w.ms(this.s);
            } catch (Throwable unused) {
            }
        }
    }

    public void ms(ms msVar) {
        this.e = new WeakReference<>(msVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public boolean nw() {
        return this.az;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void d(boolean z) {
        this.az = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public boolean b() {
        return this.xn;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ka(boolean z) {
        this.il = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void xr(com.bykv.vk.openvk.component.video.api.ah.d dVar) {
        this.b = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.ms.ms
    public void lm() {
        if (this.ny == null) {
            return;
        }
        this.nw.ah(1);
        com.bytedance.sdk.openadsdk.c.xr.d.ms(this.c, this.ka, this.b, this.az);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rt() {
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.c) && !TextUtils.isEmpty(this.of)) {
            boolean zMs = this.nw.ms(1024);
            long jLongValue = this.nw.xr(1).longValue();
            if (zMs) {
                return;
            }
            this.nw.ah(1024);
            if (this.of.equals("embeded_ad")) {
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.c, "embeded_ad", System.currentTimeMillis() - jLongValue, com.bytedance.sdk.openadsdk.c.xr.d.ms(this.ka));
            } else if (this.of.equals("draw_ad")) {
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.c, "draw_ad", System.currentTimeMillis() - jLongValue, com.bytedance.sdk.openadsdk.c.xr.d.ms(this.ka));
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void ms(int i) {
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.c)) {
            if (this.qf <= 0) {
                this.qf = System.currentTimeMillis();
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.qf;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("close_reason", Integer.valueOf(i));
                jSONObject.putOpt("buffer_count", Integer.valueOf(zb()));
                jSONObject.putOpt("buffer_time", Long.valueOf(sl()));
            } catch (Exception e) {
                sl.ms(e);
            }
            if (!this.nw.ms(512)) {
                this.nw.ah(512);
                if (this.of.equals("embeded_ad")) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.c, "embeded_ad", jCurrentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.c.xr.d.ms(this.ka));
                } else if (this.of.equals("draw_ad")) {
                    com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.c, "draw_ad", jCurrentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.c.xr.d.ms(this.ka));
                }
            }
            if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.c)) {
                if (com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(this.c)) {
                    com.bytedance.sdk.openadsdk.core.live.xr.ms().ms(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.c, jCurrentTimeMillis);
                } else {
                    com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.c, jCurrentTimeMillis);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.d.ah
    public void xr() {
        if (this.d != null) {
            ah(false);
            this.d.ms();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ms(int i, String str) {
        if (com.bytedance.sdk.openadsdk.core.video.ah.ms.ms(this.c)) {
            if (this.of.equals("embeded_ad")) {
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.c, "embeded_ad", i, str, com.bytedance.sdk.openadsdk.c.xr.d.ms(this.ka));
            } else if (this.of.equals("draw_ad")) {
                com.bytedance.sdk.openadsdk.core.zb.ah.ms(this.c, "draw_ad", i, str, com.bytedance.sdk.openadsdk.c.xr.d.ms(this.ka));
            }
        }
    }
}
