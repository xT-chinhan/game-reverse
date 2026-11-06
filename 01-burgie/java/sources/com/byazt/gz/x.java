package com.byazt.gz;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.byazt.bs.TTViewStub;
import com.byazt.ca.aj;
import com.byazt.ca.g;
import com.byazt.ca.ho;
import com.byazt.ca.yb;
import com.byazt.dx.LottieAnimationView;
import com.byazt.fj.TTProgressBar;
import com.byazt.hg.aa;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.jf.LayoutVideoDetail;
import com.byazt.mr.m;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import com.byazt.sd.ww;
import com.byazt.sd.zo;
import com.byazt.te.UpieVideoView;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.zp.k;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.android.metrics.LiveMetrics;
import com.taptap.sdk.kit.internal.p001const.TrackAction;
import com.umeng.analytics.pro.an;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 672, 121})
public class x extends com.byazt.vr.pr {
    public Map<String, Object> bm;
    public boolean e;
    public int f;
    public long gu;
    public int i;
    public WeakReference<pr> ii;
    public int jn;
    public WeakReference<com.byazt.w.hn.hw> ls;
    public String n;
    public long o;
    public WeakReference<com.byazt.w.hn.x> of;
    public int pq;
    public int r;
    public boolean s;
    public ViewGroup ve;
    public final boolean ww;
    public com.byazt.w.hn.pr y;
    public long gz = 0;
    public long nl = 0;
    public boolean er = false;
    public boolean v = false;
    public boolean qi = true;
    public volatile boolean qn = false;
    public int hs = 0;
    public boolean nw = false;
    public boolean ie = true;
    public boolean l = false;
    public boolean lv = false;
    public boolean od = false;
    public boolean vj = false;
    public com.byazt.ihe.fw.pr mw = new com.byazt.ihe.fw.pr() { // from class: com.byazt.gz.x.1
        @Override // com.byazt.ihe.fw.pr
        public void pr(com.byazt.ihe.fw fwVar) {
            com.byazt.qd.hn.uc(x.this.vj());
            x.this.pr.post(new Runnable() { // from class: com.byazt.gz.x.1.1
                @Override // java.lang.Runnable
                public void run() {
                    x.this.ii();
                }
            });
            x.this.pr(4);
            x.this.hw(4);
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(com.byazt.ihe.fw fwVar, long j) {
            if (!x.this.l) {
                x.this.l = true;
                com.byazt.qd.hn.hw(x.this.vj(), 1);
            }
            x.this.pr.post(new Runnable() { // from class: com.byazt.gz.x.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (x.this.c != null) {
                        if (!x.this.o() || !a.hw().bg()) {
                            x.this.c.hw();
                        } else {
                            x.this.c.iu();
                        }
                        x.this.pr.removeCallbacks(x.this.iu);
                        x.this.nw = false;
                    }
                    if (x.this.ii != null && x.this.ii.get() != null) {
                        ((pr) x.this.ii.get()).N_();
                    }
                    x.this.pr.removeCallbacks(x.this.iu);
                }
            });
            x.this.ie();
            x.this.o = System.currentTimeMillis();
            x.this.od();
        }

        @Override // com.byazt.ihe.fw.pr
        public void hn(com.byazt.ihe.fw fwVar) {
            if (!x.this.lv) {
                x.this.lv = true;
                com.byazt.qd.hn.hn(x.this.vj());
            }
            if (com.byazt.lpk.pr.pr(x.this.uc)) {
                x.this.uc.hn(fwVar.b());
            }
            if (!x.this.ww || k.pr(x.this.uc)) {
                x.this.ie();
            }
            x.this.pr.post(new Runnable() { // from class: com.byazt.gz.x.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (x.this.of != null && x.this.of.get() != null) {
                        ((com.byazt.w.hn.x) x.this.of.get()).O_();
                    }
                    if (x.this.c != null && (!x.this.o() || !a.hw().bg())) {
                        x.this.c.hw();
                    }
                    x.this.pr.removeCallbacks(x.this.iu);
                }
            });
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(com.byazt.ihe.fw fwVar, final com.byazt.ihe.hn hnVar) {
            com.byazt.qd.hn.hn(x.this.vj(), 1);
            x.this.pr.post(new Runnable() { // from class: com.byazt.gz.x.1.4
                /* JADX WARN: Code duplicated, block: B:27:0x00da  */
                /* JADX WARN: Code duplicated, block: B:30:0x00ef  */
                @Override // java.lang.Runnable
                public void run() {
                    int iPr = hnVar.pr();
                    int iHw = hnVar.hw();
                    x.this.pr(iPr, iHw, hnVar.hn(), (JSONArray) null);
                    ho.hw("NativeVideoController", "CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、");
                    if (!x.this.v() || iHw == -1004) {
                        ho.hw("NativeVideoController", "出错后 errorcode,extra、、、、、、、" + iPr + "," + iHw);
                        if (x.this.x(iPr, iHw) || com.byazt.lpk.pr.pr(x.this.uc)) {
                            ho.hw("NativeVideoController", "出错后展示结果页、、、、、、、");
                            if (x.this.c != null) {
                                x.this.c.pr(x.this.uc, x.this.aj, false);
                            }
                            x.this.hn(true);
                        } else {
                            if (iPr == 1 && (iHw == -19 || iHw == -38)) {
                                if (x.this.c != null) {
                                    x.this.c.pr(x.this.uc, x.this.aj, false);
                                }
                            }
                            if (x.this.c != null) {
                                x.this.c.hw();
                            }
                            if (x.this.y != null) {
                                x.this.y.hw(x.this.nl, com.byazt.t.pr.pr(x.this.fw, x.this.nt));
                            }
                            if (x.this.of == null && x.this.of.get() != null && !x.this.v()) {
                                ((com.byazt.w.hn.x) x.this.of.get()).a_(iPr, iHw);
                                return;
                            }
                            return;
                        }
                        x.this.vk();
                        if (x.this.c != null) {
                            x.this.c.hw();
                        }
                        if (x.this.y != null) {
                            x.this.y.hw(x.this.nl, com.byazt.t.pr.pr(x.this.fw, x.this.nt));
                        }
                        if (x.this.of == null) {
                        }
                    }
                }
            });
            x.this.pr(hnVar.pr(), hnVar.hn());
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(com.byazt.ihe.fw fwVar, boolean z) {
            x.this.pr.post(new Runnable() { // from class: com.byazt.gz.x.1.5
                @Override // java.lang.Runnable
                public void run() {
                    if (x.this.c != null) {
                        x.this.c.hw();
                    }
                }
            });
        }

        @Override // com.byazt.ihe.fw.pr
        public void x(com.byazt.ihe.fw fwVar) {
            com.byazt.qd.hn.hn(x.this.vj(), 2);
            x.this.l();
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(com.byazt.ihe.fw fwVar, final int i, final int i2) {
            x.this.pr.post(new Runnable() { // from class: com.byazt.gz.x.1.6
                @Override // java.lang.Runnable
                public void run() {
                    x.this.hw(i, i2);
                }
            });
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(com.byazt.ihe.fw fwVar, int i, int i2, int i3) {
            com.byazt.qd.hn.x(x.this.vj());
            x.this.pr.post(new Runnable() { // from class: com.byazt.gz.x.1.7
                @Override // java.lang.Runnable
                public void run() {
                    if (x.this.c != null) {
                        x.this.c.fo();
                        x.this.pr.postDelayed(x.this.iu, 8000L);
                        x.this.nw = true;
                    }
                }
            });
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(com.byazt.ihe.fw fwVar, int i) {
            x.this.pr.post(new Runnable() { // from class: com.byazt.gz.x.1.8
                @Override // java.lang.Runnable
                public void run() {
                    if (x.this.c != null) {
                        x.this.c.hw();
                    }
                    x.this.pr.removeCallbacks(x.this.iu);
                    x.this.nw = false;
                }
            });
        }

        @Override // com.byazt.ihe.fw.pr
        public void hw(com.byazt.ihe.fw fwVar, int i) {
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(com.byazt.ihe.fw fwVar, final long j, final long j2) {
            if (x.this.od && x.this.vj) {
                x.this.od = false;
                x.this.vj = false;
                com.byazt.qd.hn.hw(x.this.vj(), 2);
            }
            if (Math.abs(j - x.this.fw) >= 50) {
                x.this.pr.post(new Runnable() { // from class: com.byazt.gz.x.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        if (x.this.fo != null) {
                            x.this.fo.pr(j, j2);
                        }
                        x.this.pr(j, j2);
                        x.this.hw(j, j2);
                    }
                });
            }
        }

        @Override // com.byazt.ihe.fw.pr
        public void pr(com.byazt.ihe.fw fwVar, JSONObject jSONObject, String str) {
            if (zo.nt().of()) {
                jSONObject.optString(TrackAction.START);
                jSONObject.optString("sdk_dns_analysis_end");
                jSONObject.optString("player_dns_analysis_end");
                jSONObject.optString("tcp_connect_end");
                jSONObject.optString("tcp_first_package_end");
                jSONObject.optString("first_video_package_end");
                jSONObject.optString("first_frame_video_decode_end");
                jSONObject.optString("first_frame_render_end");
                jSONObject.optLong("first_frame_render_end");
                jSONObject.optLong(TrackAction.START);
            }
            com.byazt.pj.pr.pr((Context) x.this.aj.get(), x.this.uc, x.this.n, "pangle_live_sdk_monitor", jSONObject);
        }

        @Override // com.byazt.ihe.fw.pr
        public void c(com.byazt.ihe.fw fwVar) {
            x.this.od = true;
            com.byazt.qd.hn.c(x.this.vj());
        }

        @Override // com.byazt.ihe.fw.pr
        public void uc(com.byazt.ihe.fw fwVar) {
            x.this.vj = true;
        }

        @Override // com.byazt.ihe.fw.pr
        public void hw(com.byazt.ihe.fw fwVar) {
        }
    };
    public int sv = 0;
    public Runnable iu = new Runnable() { // from class: com.byazt.gz.x.6
        @Override // java.lang.Runnable
        public void run() {
            if (x.this.c != null) {
                x.this.c.pr(x.this.uc, x.this.aj, false);
                x.this.c.hw();
                x.this.hn(true);
                ho.hw("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
            }
        }
    };
    public final com.byazt.apo.hn d = new com.byazt.apo.hn() { // from class: com.byazt.gz.x.8
        @Override // com.byazt.apo.hn
        public void pr(Context context, Intent intent, boolean z, int i) {
            x.this.hn(context, i);
        }
    };
    public boolean jw = false;

    public interface pr {
        void N_();

        void aj();

        void pr(int i);
    }

    public void x(int i) {
        this.f = i;
    }

    public void hw(of ofVar) {
        this.uc = ofVar;
    }

    public void pr(com.byazt.ng.pr prVar) {
        if (this.c != null) {
            this.c.pr(prVar);
        }
    }

    public void pr(final NativeVideoTsView.pr prVar) {
        if (this.k && this.c != null) {
            this.c.pr(new NativeVideoTsView.pr() { // from class: com.byazt.gz.x.3
                @Override // com.byazt.gz.NativeVideoTsView.pr
                public void pr(View view, int i) {
                    NativeVideoTsView.pr prVar2 = prVar;
                    if (prVar2 != null) {
                        prVar2.pr(view, i);
                    }
                }
            });
        }
    }

    public void pr(m mVar) {
        if (this.k && this.c != null) {
            this.c.pr(mVar);
        }
    }

    public void pr(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.i = i;
        this.r = i2;
    }

    private void pr(Context context) {
        EnumSet<com.byazt.w.hw.pr> enumSetNoneOf = EnumSet.noneOf(com.byazt.w.hw.pr.class);
        enumSetNoneOf.add(com.byazt.w.hw.pr.hideCloseBtn);
        enumSetNoneOf.add(com.byazt.w.hw.pr.hideBackBtn);
        try {
            this.c = pr(context, enumSetNoneOf);
            if (this.c != null) {
                this.c.pr((com.byazt.w.pr) this);
                this.c.pr((com.byazt.mm.pr.InterfaceC0136pr) this);
            }
        } catch (Throwable th) {
            ho.hw("NativeVideoController", th.getMessage());
        }
    }

    public uc pr(Context context, EnumSet<com.byazt.w.hw.pr> enumSet) {
        View layoutVideoDetail;
        if (this.k) {
            layoutVideoDetail = hw(context);
        } else {
            layoutVideoDetail = new LayoutVideoDetail(context);
        }
        if (layoutVideoDetail == null) {
            return null;
        }
        if (this.k) {
            return new uc(context, layoutVideoDetail, true, enumSet, this.uc, this, n(), null);
        }
        return new c(context, layoutVideoDetail, true, enumSet, this.uc, this, false);
    }

    private View hw(final Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387714);
        relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(2114387900);
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setId(2114387651);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        final TTProgressBar tTProgressBar = new TTProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        tTProgressBar.setId(2114387631);
        layoutParams3.addRule(13, -1);
        tTProgressBar.setLayoutParams(layoutParams3);
        g.pr(context, "tt_normalscreen_loading", new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.gz.x.4
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                tTProgressBar.setIndeterminateDrawable(TTProgressBar.pr(context, new BitmapDrawable(context.getResources(), bitmap), 0, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL, 0.5f, 0.5f));
            }
        }, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        relativeLayout2.addView(tTProgressBar);
        View viewHw = new com.byazt.jf.x().hw(context);
        viewHw.setId(2114387688);
        viewHw.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(viewHw);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setId(2114387626);
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        g.pr(context, "tt_new_play_video", imageView2, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        TTProgressBar tTProgressBar2 = new TTProgressBar(context, null, R.style.Widget.ProgressBar.Horizontal);
        tTProgressBar2.setIndeterminate(false);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
        tTProgressBar2.setMax(100);
        tTProgressBar2.setId(2114387653);
        tTProgressBar2.setBackgroundColor(0);
        tTProgressBar2.setIndeterminateDrawable(null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float fHn = er.hn(context, 1.0f);
        gradientDrawable.setCornerRadius(fHn);
        int iHn = er.hn(context, 2.0f);
        gradientDrawable.setSize(-1, iHn);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(fHn);
        gradientDrawable2.setSize(-1, iHn);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(fHn);
        gradientDrawable3.setSize(-1, iHn);
        tTProgressBar2.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar2.setVisibility(8);
        layoutParams5.addRule(12, -1);
        tTProgressBar2.setLayoutParams(layoutParams5);
        relativeLayout.addView(tTProgressBar2);
        TTViewStub tTViewStub = new TTViewStub(context, new com.byazt.jf.uc());
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387744);
        tTViewStub.setLayoutParams(layoutParams6);
        relativeLayout.addView(tTViewStub);
        TTViewStub tTViewStub2 = new TTViewStub(context, new com.byazt.jf.hw());
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub2.setId(2114387666);
        tTViewStub2.setLayoutParams(layoutParams7);
        relativeLayout.addView(tTViewStub2);
        TTViewStub tTViewStub3 = new TTViewStub(context, new com.byazt.jf.fw());
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13, -1);
        tTViewStub3.setId(2114387828);
        tTViewStub3.setLayoutParams(layoutParams8);
        relativeLayout.addView(tTViewStub3);
        return relativeLayout;
    }

    public x(Context context, ViewGroup viewGroup, of ofVar, String str, boolean z, boolean z2, boolean z3) {
        this.n = com.byazt.pfl.hw.AD_TAG_FEED;
        this.e = false;
        this.s = true;
        this.i = 0;
        this.r = 0;
        this.pq = 1;
        this.pq = yb.hn(context);
        pr(z);
        this.n = str;
        try {
            this.i = viewGroup.getWidth();
            this.r = viewGroup.getHeight();
        } catch (Throwable th) {
        }
        this.ve = viewGroup;
        this.aj = new WeakReference<>(context);
        this.uc = ofVar;
        pr(context);
        this.ww = Build.VERSION.SDK_INT >= 17;
        this.e = z2;
        this.s = z3;
    }

    public x(Context context, ViewGroup viewGroup, of ofVar, String str, boolean z, boolean z2) {
        this.n = com.byazt.pfl.hw.AD_TAG_FEED;
        this.e = false;
        this.s = true;
        this.i = 0;
        this.r = 0;
        this.pq = 1;
        this.pq = yb.hn(context);
        try {
            this.i = viewGroup.getWidth();
            this.r = viewGroup.getHeight();
        } catch (Throwable th) {
        }
        this.ve = viewGroup;
        this.n = str;
        this.aj = new WeakReference<>(context);
        this.uc = ofVar;
        pr(context);
        this.ww = Build.VERSION.SDK_INT >= 17;
        this.e = z;
        this.s = z2;
    }

    @Override // com.byazt.w.hn
    public void pr(com.byazt.w.hn.x xVar) {
        this.of = new WeakReference<>(xVar);
    }

    @Override // com.byazt.w.hn
    public boolean pr(com.byazt.n.uc ucVar) {
        ucVar.ny();
        if (TextUtils.isEmpty(ucVar.ny())) {
            hw("url is null");
            ho.hw("tag_video_play", "[video] play video stop , because no video info");
            return false;
        }
        this.ny = ucVar;
        this.yb = ucVar.ho();
        this.fw = ucVar.g();
        if (ucVar.g() > 0) {
            this.fw = ucVar.g();
            this.zo = this.zo > this.fw ? this.zo : this.fw;
        }
        if (this.c != null) {
            this.c.pr();
            if (this.sv == 0) {
                this.c.fw();
            }
            this.c.hn(ucVar.vk(), ucVar.w());
            this.c.hn(this.ve);
            this.c.pr(ucVar.vk(), ucVar.w());
        }
        try {
            if (this.x == null) {
                if (!of()) {
                    hw("create video error");
                    return false;
                }
                this.x.pr(this.mw);
            }
            b();
            this.nl = 0L;
            hn(ucVar);
            return true;
        } catch (Throwable th) {
            hw(th.getMessage());
            ho.hw("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + th.toString());
            return false;
        }
    }

    private boolean of() {
        int i;
        com.byazt.ihe.fw xVar;
        of ofVar = this.uc;
        if (com.byazt.ja.pr.hw(ofVar)) {
            com.byazt.c.hw hwVarFo = fo();
            if (hwVarFo != null) {
                int iK = ls.k(this.uc);
                this.z = pr(an.aw);
                this.x = new com.byazt.te.pr(hwVarFo, com.byazt.ja.pr.vk(ofVar), new com.byazt.p.x(String.valueOf(iK), this.z), qv.lb(ofVar), pr("assist"));
                i = 1;
            } else {
                if (this.mw != null) {
                    this.mw.pr((com.byazt.ihe.fw) null, new com.byazt.n.hn(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建lottie播放器时，iRenderView为null, mediaLayout is null: " + (this.c == null)));
                }
                ho.hw("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else if (com.byazt.ja.pr.hn(ofVar)) {
            i = 2;
            com.byazt.c.hw hwVarFo2 = fo();
            if (hwVarFo2 != null) {
                int iK2 = ls.k(this.uc);
                if (!iu.x() || this.ny.rc() != 1) {
                    this.z = pr(an.aw);
                    xVar = new com.byazt.p.x(String.valueOf(iK2), this.z);
                } else {
                    xVar = com.byazt.it.hw.pr().pr(a.getContext(), String.valueOf(iK2));
                }
                this.x = new com.byazt.te.hw(xVar, com.byazt.ja.pr.vk(ofVar), pr("assist"), hwVarFo2);
            } else {
                if (this.mw != null) {
                    this.mw.pr((com.byazt.ihe.fw) null, new com.byazt.n.hn(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建Upie播放器时，iRenderView为null, mediaLayout is null: " + (this.c == null)));
                }
                ho.hw("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else {
            int iK3 = ls.k(this.uc);
            if (com.byazt.lpk.pr.pr(this.uc)) {
                i = 3;
                this.x = com.byazt.it.hw.pr().pr(a.getContext(), iu(), (long) qv.fw(this.uc), a.hw().ks(), null);
            } else if (!iu.x() || this.ny.rc() != 1) {
                this.z = pr(an.aw);
                this.x = new com.byazt.p.x(String.valueOf(iK3), this.z);
                i = 5;
            } else {
                this.x = com.byazt.it.hw.pr().pr(a.getContext(), String.valueOf(iK3));
                i = 4;
            }
        }
        if (ofVar != null) {
            com.byazt.qd.hn.pr(ofVar, String.valueOf(ls.m(this.uc)), ls.k(this.uc), i, this.uc.z());
        }
        return true;
    }

    @Override // com.byazt.w.hn
    public int ho() {
        return com.byazt.t.pr.pr(this.zo, this.nt);
    }

    @Override // com.byazt.w.hn
    public void hw(Map<String, Object> map) {
        this.bm = map;
    }

    @Override // com.byazt.vr.pr
    public Map<String, Object> er() {
        return this.bm;
    }

    private void hn(com.byazt.n.uc ucVar) {
        boolean zHw;
        if (ucVar == null) {
            hw("model is null");
            return;
        }
        boolean z = false;
        if (this.x != null) {
            if (this.uc != null) {
                ucVar.x(String.valueOf(ls.m(this.uc)));
            }
            ucVar.x(0);
            com.byazt.qd.hn.hw(vj());
            this.x.pr(ucVar);
        }
        this.gz = System.currentTimeMillis();
        if (!TextUtils.isEmpty(ucVar.ny())) {
            if (this.c != null) {
                this.c.c(8);
                this.c.c(0);
            }
            boolean zX = ls.x(this.uc);
            boolean zHn = ls.hn(this.uc);
            if (this.c == null) {
                zHw = true;
            } else {
                zHw = ww.hw(this.c.pr, 50, 9);
            }
            boolean zO = a.hw().o();
            Runnable runnable = new Runnable() { // from class: com.byazt.gz.x.5
                @Override // java.lang.Runnable
                public void run() {
                    x.this.cz.pr();
                    x.this.ls();
                    x.this.gz = System.currentTimeMillis();
                    if (x.this.c != null) {
                        x.this.c.x(0);
                    }
                    x.this.jn = 1;
                    x.this.l = false;
                    x.this.lv = false;
                    com.byazt.qd.hn.pr(x.this.vj(), x.this.jn);
                    x.this.x.pr(true, x.this.fw, x.this.yb);
                }
            };
            if (zX || (zHn && !zO)) {
                z = true;
            }
            if (z && !zHw) {
                hw(runnable);
                zo(true);
                WeakReference<pr> weakReference = this.ii;
                if (weakReference != null && weakReference.get() != null) {
                    this.ii.get().aj();
                }
            } else {
                pr(runnable);
            }
        } else {
            hw("url is null");
        }
        if (this.k) {
            qi();
        }
    }

    @Override // com.byazt.w.hn
    public void pr(com.byazt.w.hn.hw hwVar) {
        this.ls = new WeakReference<>(hwVar);
    }

    @Override // com.byazt.vr.pr, com.byazt.w.hn
    public long k() {
        if (yb() == null) {
            return 0L;
        }
        return yb().nt();
    }

    @Override // com.byazt.w.hn
    public int m() {
        if (yb() == null) {
            return 0;
        }
        return yb().qa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ii() {
        this.sv++;
        if (!ve() || this.c == null) {
            return;
        }
        this.c.hw();
        com.byazt.w.hn.pr prVar = this.y;
        if (prVar != null) {
            prVar.pr(this.nl, com.byazt.t.pr.pr(this.fw, this.nt));
        }
        this.nl = System.currentTimeMillis() - this.gz;
        this.c.c(true);
        boolean zPr = com.byazt.lpk.pr.pr(this.uc);
        int iMr = this.uc.mr();
        boolean z = iMr <= 0;
        boolean z2 = !z && this.sv >= iMr;
        boolean zX = ls.x(this.uc);
        if (!zX || z2 || zPr) {
            this.c.pr(this.uc, this.aj, true);
        }
        if (!this.cz.pr(64) || i() || r()) {
            this.cz.hn(64);
            hw(this.nt, this.nt);
            long j = this.nt;
            this.fw = j;
            this.zo = j;
            com.byazt.yo.yb.pr prVar2 = new com.byazt.yo.yb.pr();
            prVar2.pr(w());
            prVar2.hn(g());
            prVar2.hw(k());
            prVar2.uc(m());
            com.byazt.ne.hn.x(this.c, prVar2);
        }
        if (!this.k && this.a) {
            c(this.c, (View) null);
        }
        this.qa = true;
        if (zPr) {
            return;
        }
        if (zX && (z || this.sv < iMr)) {
            z();
            return;
        }
        if ((k.pr(this.uc) && (((g() / 1000) > 10L ? 1 : ((g() / 1000) == 10L ? 0 : -1)) < 0)) && this.sv < 2) {
            z();
        }
    }

    @Override // com.byazt.w.hn
    public void pr(com.byazt.w.hn.pr prVar) {
        this.y = prVar;
    }

    @Override // com.byazt.w.hn
    public void uc() {
        if (this.x != null) {
            this.x.x();
        }
        if ((!this.cz.pr(64) || i()) && this.cz.pr(2)) {
            com.byazt.yo.yb.pr prVar = new com.byazt.yo.yb.pr();
            prVar.pr(w());
            prVar.hn(g());
            prVar.hw(k());
            pr(this.c, prVar);
        }
    }

    @Override // com.byazt.w.hn
    public void pr(Map<String, Object> map) {
        if (this.x != null) {
            this.x.x();
        }
        if ((!this.cz.pr(64) || i()) && this.cz.pr(2)) {
            com.byazt.yo.yb.pr prVar = new com.byazt.yo.yb.pr();
            prVar.pr(w());
            prVar.hn(g());
            prVar.hw(k());
            if (map != null) {
                prVar.pr(map);
            }
            pr(this.c, prVar);
        }
    }

    private boolean i() {
        return this.sv > 0 && ls.x(this.uc);
    }

    private boolean r() {
        return this.sv > 0 && k.pr(this.uc);
    }

    @Override // com.byazt.w.hn
    public void fw() {
        if (this.x != null) {
            this.x.x();
        }
    }

    @Override // com.byazt.w.hn
    public void zo() {
        if (this.c != null) {
            this.c.pr();
        }
        if (this.c != null) {
            this.c.rc();
        }
        nw();
    }

    public void uc(boolean z) {
        if (this.c != null) {
            this.c.pr();
        }
        if (this.c != null && z) {
            this.c.rc();
        }
        nw();
    }

    private boolean hs() {
        return this.k && zo.nt().jn() > 0;
    }

    private void nw() {
        Object[] objArr = {"resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.vk)};
        if (this.x != null) {
            if (this.x.k() && !hs()) {
                if (this.vk || ((this.ny != null && this.ny.zo()) || com.byazt.ja.pr.hw(this.uc))) {
                    y();
                } else {
                    hw(this.b);
                }
                Object[] objArr2 = {"resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.vk)};
            } else if (hs()) {
                this.fw = zo.nt().jn();
                zo.nt().pr(-1L);
                this.x.pr(this.fw);
                this.x.hn();
            } else {
                this.jn = 1;
                this.l = false;
                this.x.pr(false, this.fw, this.yb);
            }
        }
        if (this.cz.pr(2)) {
            com.byazt.yo.yb.pr prVar = new com.byazt.yo.yb.pr();
            prVar.pr(w());
            prVar.hn(g());
            prVar.hw(k());
            hw(lb(), prVar);
        }
    }

    @Override // com.byazt.w.hn
    public void pr(long j) {
        this.fw = j;
        this.zo = this.zo > this.fw ? this.zo : this.fw;
        if (this.c != null) {
            this.c.pr();
        }
        if (this.x != null) {
            this.jn = 1;
            this.l = false;
            this.x.pr(true, this.fw, this.yb);
        }
    }

    @Override // com.byazt.w.hn
    public void aj() {
        pr(true, 3);
    }

    @Override // com.byazt.w.hn
    public void pr(boolean z, int i) {
        if (this.k) {
            pr(1);
        }
        long jG = g();
        if ((!this.cz.pr(64) || i()) && this.cz.pr(1) && jG > 0) {
            if (z) {
                com.byazt.yo.yb.pr prVar = new com.byazt.yo.yb.pr();
                prVar.pr(w());
                prVar.hn(jG);
                prVar.hw(k());
                prVar.c(i);
                prVar.uc(m());
                this.cz.hn(32);
                com.byazt.ne.hn.pr(this.c, prVar, this.bm, !this.cz.pr(2) ? 1 : 0);
            } else {
                com.byazt.yo.yb.pr prVar2 = new com.byazt.yo.yb.pr();
                prVar2.pr(w());
                prVar2.hn(jG);
                prVar2.hw(k());
                pr(this.c, prVar2);
            }
        }
        vk();
    }

    @Override // com.byazt.w.hn
    public void vk() {
        hw(g() == 0 ? -2 : -1);
        if (this.x != null) {
            this.x.uc();
            this.x = null;
        }
        int iMr = this.uc == null ? 2 : this.uc.mr();
        boolean z = iMr > 0 && this.sv == iMr;
        if (!ls.x(this.uc) || z) {
            try {
                this.c.pr(this.uc, this.aj, true);
            } catch (Exception e) {
                ho.hw("NativeVideoController", e.getMessage());
            }
        }
        if (this.pr != null) {
            this.pr.removeCallbacksAndMessages(null);
        }
        if (this.w != null) {
            this.w.clear();
        }
        qn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ie() {
        if (!this.cz.pr(2) || i()) {
            com.byazt.yo.yb.pr prVar = new com.byazt.yo.yb.pr();
            if (o()) {
                this.qi = true;
            }
            prVar.hw(this.qi);
            prVar.hn(g());
            this.cz.hn(2);
            com.byazt.ne.hn.pr(this.c, prVar);
        }
    }

    public void hw(int i, int i2) {
        ViewGroup viewGroup;
        int iRound;
        ViewGroup.LayoutParams layoutParams;
        try {
            if (this.aj != null && this.aj.get() != null && fo() != null && this.x != null && (viewGroup = this.ve) != null && viewGroup != null) {
                if (i < 0 && i2 < 0) {
                    i = this.x.yb();
                    i2 = this.x.lb();
                }
                int width = this.ve.getWidth();
                int height = this.ve.getHeight();
                if (width > 0 && height > 0 && i2 > 0 && i > 0) {
                    int iRound2 = 0;
                    if (i == i2) {
                        if (width > height) {
                            iRound2 = height;
                            iRound = iRound2;
                        } else {
                            iRound2 = width;
                            iRound = iRound2;
                        }
                    } else if (i > i2) {
                        iRound2 = (int) Math.round((((double) width) * 1.0d) / ((double) ((i * 1.0f) / i2)));
                        iRound = width;
                    } else if (!f()) {
                        iRound = (int) Math.round(((double) (height * 1.0f)) / ((double) ((i2 * 1.0f) / i)));
                        iRound2 = height;
                    } else {
                        iRound = 0;
                    }
                    if (iRound2 > height || iRound2 <= 0) {
                        iRound2 = height;
                    }
                    if (hw(i, i2, iRound, width)) {
                        iRound = width;
                    }
                    if (f()) {
                        pr(i, i2, width, height);
                        return;
                    }
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iRound, iRound2);
                    layoutParams2.addRule(13);
                    Object objFo = fo();
                    if (objFo instanceof TextureView) {
                        ((TextureView) objFo).setLayoutParams(layoutParams2);
                    } else if (objFo instanceof UpieVideoView) {
                        ((UpieVideoView) objFo).setLayoutParams(layoutParams2);
                    } else if (objFo instanceof SurfaceView) {
                        ((SurfaceView) objFo).setLayoutParams(layoutParams2);
                    }
                    if (hn(i, i2) && (layoutParams = this.ve.getLayoutParams()) != null) {
                        layoutParams.height = iRound2;
                        layoutParams.width = iRound;
                        this.ve.setLayoutParams(layoutParams);
                        if (this.c != null) {
                            this.c.pr(layoutParams.width, layoutParams.height);
                        }
                    }
                    pr(width, height, iRound, iRound2);
                    return;
                }
                return;
            }
            if (this.aj != null) {
                this.aj.get();
            }
            fo();
        } catch (Throwable th) {
        }
    }

    private void pr(float f, float f2, float f3, float f4) {
        View view;
        if (a.hw().ho()) {
            WeakReference<pr> weakReference = this.ii;
            pr prVar = weakReference != null ? weakReference.get() : null;
            boolean zVk = true;
            if (!(prVar instanceof NativeVideoTsView)) {
                view = null;
            } else {
                NativeVideoTsView nativeVideoTsView = (NativeVideoTsView) prVar;
                zVk = nativeVideoTsView.vk();
                Object parent = nativeVideoTsView.getParent();
                if (!(parent instanceof View)) {
                    view = null;
                } else {
                    view = (View) parent;
                }
            }
            if (zVk) {
                com.byazt.xk.hw.pr().pr(this.uc, f, f2, f3, f4, view);
            }
        }
    }

    private void pr(int i, int i2, int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return;
        }
        float f = i3;
        float f2 = i;
        float f3 = f / f2;
        float f4 = i4;
        float f5 = i2;
        float f6 = f4 / f5;
        Matrix matrix = null;
        try {
            Object objFo = fo();
            if (objFo instanceof TextureView) {
                matrix = ((TextureView) objFo).getMatrix();
            } else if (objFo instanceof UpieVideoView) {
                matrix = ((UpieVideoView) objFo).getMatrix();
            } else if (objFo instanceof SurfaceView) {
                matrix = ((SurfaceView) objFo).getMatrix();
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
            if (objFo instanceof TextureView) {
                ((TextureView) objFo).setTransform(matrix);
                ((TextureView) objFo).postInvalidate();
                return;
            }
            if (objFo instanceof UpieVideoView) {
                LottieAnimationView lottieAnimationViewPr = pr((View) objFo);
                if (lottieAnimationViewPr != null) {
                    lottieAnimationViewPr.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    return;
                }
                return;
            }
            if (objFo instanceof SurfaceView) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ((SurfaceView) objFo).setAnimationMatrix(matrix);
                }
                ((SurfaceView) objFo).postInvalidate();
            }
        } catch (Exception e) {
        }
    }

    private LottieAnimationView pr(View view) {
        LottieAnimationView lottieAnimationViewPr;
        if (view instanceof LottieAnimationView) {
            return (LottieAnimationView) view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof LottieAnimationView) {
                    return (LottieAnimationView) childAt;
                }
                if ((childAt instanceof ViewGroup) && (lottieAnimationViewPr = pr(childAt)) != null) {
                    return lottieAnimationViewPr;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o() {
        return TextUtils.equals(this.n, "splash_ad") || TextUtils.equals(this.n, "cache_splash_ad");
    }

    private boolean f() {
        aa aaVarZn;
        if (o()) {
            return this.uc == null || (aaVarZn = this.uc.zn()) == null || aaVarZn.pr() != 0;
        }
        return false;
    }

    private boolean hw(int i, int i2, int i3, int i4) {
        return (i3 > i4 && !hn(i, i2)) || i3 <= 0;
    }

    private boolean hn(int i, int i2) {
        return i < i2 && bm();
    }

    private boolean bm() {
        return this.uc != null && this.uc.sr() == 1 && "draw_ad".equals(this.n) && this.ve != null;
    }

    public com.byazt.c.hw fo() {
        if (this.aj != null && this.aj.get() != null) {
            if ((this.aj.get().getResources().getConfiguration().orientation == 1 || com.byazt.ja.pr.pr(this.uc)) && this.c != null) {
                return this.c.yb();
            }
            return null;
        }
        return null;
    }

    @Override // com.byazt.w.pr
    public void pr(com.byazt.w.hw hwVar, View view) {
        if (this.x == null || !ve()) {
            return;
        }
        if (this.x.vk()) {
            uc();
            if (this.c != null) {
                this.c.hw(true, false);
                this.c.uc();
                return;
            }
            return;
        }
        if (!this.x.k()) {
            if (this.c != null) {
                this.c.hn(this.ve);
            }
            pr(this.fw);
            if (this.c != null) {
                this.c.hw(false, false);
                return;
            }
            return;
        }
        uc(false);
        if (this.c != null) {
            this.c.hw(false, false);
        }
    }

    @Override // com.byazt.w.pr
    public void pr(com.byazt.w.hw hwVar, int i) {
        if (this.x == null) {
            return;
        }
        pr(this.gu, uc(i));
    }

    @Override // com.byazt.w.pr
    public void hw(com.byazt.w.hw hwVar, int i) {
        if (this.c != null) {
            this.c.uc();
        }
    }

    @Override // com.byazt.w.pr
    public void pr(com.byazt.w.hw hwVar, int i, boolean z) {
        if (!ve()) {
            return;
        }
        long j = (long) (((((long) i) * this.nt) * 1.0f) / 100.0f);
        if (this.nt > 0) {
            this.gu = (int) j;
        } else {
            this.gu = 0L;
        }
        if (this.c != null) {
            this.c.pr(this.gu);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hw(long j, long j2) {
        this.fw = j;
        this.nt = j2;
        if (this.c != null) {
            this.c.pr(j, j2);
            this.c.hw(com.byazt.t.pr.pr(j, j2));
        }
        try {
            com.byazt.w.hn.pr prVar = this.y;
            if (prVar != null) {
                prVar.pr(j, j2);
            }
        } catch (Throwable th) {
            ho.pr("NativeVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.byazt.w.pr
    public void hw(com.byazt.w.hw hwVar, View view) {
        hw(hwVar, view, false, false);
    }

    public void hw(com.byazt.w.hw hwVar, View view, boolean z, boolean z2) {
        if (!ve()) {
            return;
        }
        aj(!this.a);
        if (!(this.aj.get() instanceof Activity)) {
            return;
        }
        if (this.a) {
            c(z ? 8 : 0);
            if (this.c != null) {
                this.c.pr(this.ve);
                this.c.hn(false);
            }
        } else {
            c(1);
            if (this.c != null) {
                this.c.hw(this.ve);
                this.c.hn(false);
            }
        }
        WeakReference<com.byazt.w.hn.hw> weakReference = this.ls;
        com.byazt.w.hn.hw hwVar2 = weakReference != null ? weakReference.get() : null;
        if (hwVar2 != null) {
            hwVar2.pr(this.a);
        }
    }

    public void c(int i) {
        if (!ve()) {
            return;
        }
        boolean z = i == 0 || i == 8;
        Context context = this.aj.get();
        if (!(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        try {
            activity.setRequestedOrientation(i);
        } catch (Throwable th) {
        }
        if (!z) {
            activity.getWindow().setFlags(1024, 1024);
        } else {
            activity.getWindow().clearFlags(1024);
        }
    }

    @Override // com.byazt.w.pr
    public void hn(com.byazt.w.hw hwVar, View view) {
        if (this.c != null) {
            this.c.aj();
        }
        pr(1);
        pr(true, 3);
    }

    @Override // com.byazt.w.pr
    public void pr(com.byazt.w.hw hwVar, View view, boolean z, boolean z2) {
        if (this.k) {
            uc();
        }
        if (this.c == null) {
            return;
        }
        if (z && !this.k && !rc()) {
            this.c.hw(!v(), false);
            this.c.pr(z2, true, false);
        }
        if (this.x != null && this.x.vk()) {
            this.c.uc();
            this.c.c();
        } else {
            this.c.uc();
        }
    }

    @Override // com.byazt.w.pr
    public void x(com.byazt.w.hw hwVar, View view) {
        if (this.a) {
            aj(false);
            if (this.c != null) {
                this.c.hw(this.ve);
            }
            c(1);
            return;
        }
        pr(1);
        pr(true, 3);
    }

    @Override // com.byazt.w.pr
    public void c(com.byazt.w.hw hwVar, View view) {
        pr(hwVar, view, false);
    }

    public void pr(com.byazt.w.hw hwVar, View view, boolean z) {
        jn();
    }

    private void jn() {
        if (!ve()) {
            return;
        }
        aj(!this.a);
        if (!(this.aj.get() instanceof Activity)) {
            return;
        }
        if (this.c != null) {
            this.c.hw(this.ve);
            this.c.hn(false);
        }
        c(1);
        WeakReference<com.byazt.w.hn.hw> weakReference = this.ls;
        com.byazt.w.hn.hw hwVar = weakReference != null ? weakReference.get() : null;
        if (hwVar != null) {
            hwVar.pr(this.a);
        }
    }

    public boolean rc() {
        return this.x == null || this.x.ho();
    }

    public void z() {
        if (yb.hn(a.getContext()) == 0) {
            return;
        }
        if (this.c != null) {
            this.c.pr();
        }
        hn(false);
        if (this.x != null) {
            this.cz.pr();
            ls();
            this.jn = 2;
            this.l = false;
            this.x.hw();
            ie();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.qn && this.c != null && this.c.hn() != null) {
            this.qn = false;
            this.c.hn().post(new Runnable() { // from class: com.byazt.gz.x.7
                @Override // java.lang.Runnable
                public void run() {
                    if (x.this.ny != null) {
                        x.this.ny.hw(x.this.uc.x());
                        x.this.ny.hw(x.this.i);
                        x.this.ny.hn(x.this.r);
                        x.this.ny.pr((List<String>) null);
                        x.this.ny.hn(x.this.uc.B_());
                        x.this.ny.pr(0L);
                        x.this.ny.hw(x.this.qa());
                        x.this.ny.pr(x.this.ny.c());
                        x xVar = x.this;
                        xVar.pr(xVar.ny);
                        x.this.hn(false);
                    }
                }
            });
        }
    }

    @Override // com.byazt.w.pr
    public void pr() {
        if (yb.hn(a.getContext()) == 0) {
            return;
        }
        this.qn = true;
        if (this.x == null) {
            vk();
            l();
        } else {
            vk();
        }
    }

    public boolean v() {
        return this.x != null && this.x.vk();
    }

    private void pr(long j, boolean z) {
        if (this.x == null) {
            return;
        }
        if (z) {
            lv();
        }
        this.x.pr(j);
    }

    private boolean uc(int i) {
        return this.c != null && this.c.hn(i);
    }

    private void lv() {
        if (this.c != null) {
            this.c.x(0);
            this.c.pr(false, false);
            this.c.hn(false);
            this.c.c();
            this.c.fw();
        }
    }

    /* JADX INFO: renamed from: com.byazt.gz.x$2, reason: invalid class name */
    @com.byazt.vzx.pr(pr = {0, 1, 672, 441})
    static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] pr;

        static {
            int[] iArr = new int[com.byazt.nc.ho.pr.values().length];
            pr = iArr;
            try {
                iArr[com.byazt.nc.ho.pr.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                pr[com.byazt.nc.ho.pr.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                pr[com.byazt.nc.ho.pr.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Override // com.byazt.gz.hw
    public void pr(com.byazt.nc.ho.pr prVar, String str) {
        switch (AnonymousClass2.pr[prVar.ordinal()]) {
            case 1:
                uc();
                break;
            case 2:
                pr(true, 3);
                break;
            case 3:
                zo();
                this.ho = false;
                this.er = true;
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fw(int i) {
        int iHn = yb.hn(a.getContext());
        if (iHn == 0) {
            uc();
            this.ho = true;
            if (this.c != null) {
                this.c.pr(this.uc, this.aj, false);
            }
        }
        if (iHn != 4 && iHn != 0) {
            if (this.c != null) {
                this.c.pr();
            }
            uc();
            this.ho = true;
            this.er = false;
            if (this.c != null && this.uc != null) {
                return this.c.pr(i, qv.ho(this.uc), this.s);
            }
        } else if (iHn == 4) {
            this.ho = false;
            if (this.c != null) {
                this.c.a();
            }
        }
        return true;
    }

    private void hw(Context context, int i) {
        if (!ve() || context == null || this.pq == i) {
            return;
        }
        this.pq = i;
        if (i != 4 && i != 0) {
            this.er = false;
        }
        if (!this.er && !a() && this.e) {
            aj.hw().post(new Runnable() { // from class: com.byazt.gz.x.9
                @Override // java.lang.Runnable
                public void run() {
                    x.this.fw(2);
                }
            });
        }
        WeakReference<pr> weakReference = this.ii;
        if (weakReference != null && weakReference.get() != null) {
            this.ii.get().pr(this.pq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hn(Context context, int i) {
        hw(context, i);
        if (i == 4) {
            this.ho = false;
        }
    }

    public void pr(Context context, int i) {
        hw(context, i);
        if (i == 4) {
            this.ho = false;
            aj.hw().post(new Runnable() { // from class: com.byazt.gz.x.10
                @Override // java.lang.Runnable
                public void run() {
                    x.this.zo();
                }
            });
        }
    }

    public void qi() {
        if (this.jw || !this.ie) {
            return;
        }
        this.jw = true;
        ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).pr(this.d);
    }

    public void qn() {
        if (!this.jw) {
            return;
        }
        this.jw = false;
        try {
            ((com.byazt.vkw.g) com.byazt.zs.uc.pr("device_info_new")).hw(this.d);
        } catch (Throwable th) {
        }
    }

    public void pr(pr prVar) {
        this.ii = new WeakReference<>(prVar);
    }

    @Override // com.byazt.w.hn
    public boolean cz() {
        return this.qi;
    }

    @Override // com.byazt.w.hn
    public void x(boolean z) {
        this.qi = z;
    }

    @Override // com.byazt.w.hn
    public boolean ny() {
        return this.nw;
    }

    @Override // com.byazt.w.hn
    public void c(boolean z) {
        this.ie = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(int i, int i2) {
        boolean z;
        switch (i) {
            case -1010:
            case -1007:
            case -1004:
            case -110:
            case 100:
            case 200:
            case 60008:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        switch (i2) {
            case 1:
            case 700:
            case 800:
                return true;
            default:
                return z;
        }
    }

    @Override // com.byazt.w.hn
    public void hw(com.byazt.n.uc ucVar) {
        this.ny = ucVar;
    }

    @Override // com.byazt.vr.pr
    public boolean iu() {
        return true;
    }

    @Override // com.byazt.vr.pr
    public void ls() {
        if (this.aj == null) {
            return;
        }
        this.rc = com.byazt.ne.hn.pr();
        if (this.z != null) {
            this.z.hw(this.rc);
        }
        this.cz.hn(1);
        com.byazt.ne.hn.pr(this.uc, this.c, this.ny, this.qi, this.rc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void od() {
        if (!com.byazt.lpk.pr.pr(this.uc) || TextUtils.isEmpty(this.n)) {
            return;
        }
        boolean zPr = this.cz.pr(1024);
        long jLongValue = this.cz.hw(1).longValue();
        if (!zPr) {
            this.cz.hn(1024);
            if (this.n.equals(com.byazt.pfl.hw.AD_TAG_FEED)) {
                com.byazt.pj.pr.pr(this.uc, com.byazt.pfl.hw.AD_TAG_FEED, System.currentTimeMillis() - jLongValue, com.byazt.ne.hn.pr(this.c));
            } else if (this.n.equals("draw_ad")) {
                com.byazt.pj.pr.pr(this.uc, "draw_ad", System.currentTimeMillis() - jLongValue, com.byazt.ne.hn.pr(this.c));
            }
        }
    }

    @Override // com.byazt.w.hn
    public void pr(int i) {
        if (!com.byazt.lpk.pr.pr(this.uc)) {
            return;
        }
        if (this.o <= 0) {
            this.o = System.currentTimeMillis();
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.o;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("close_reason", Integer.valueOf(i));
            jSONObject.putOpt("buffer_count", Integer.valueOf(m()));
            jSONObject.putOpt("buffer_time", Long.valueOf(k()));
        } catch (Exception e) {
        }
        if (!this.cz.pr(512)) {
            this.cz.hn(512);
            if (this.n.equals(com.byazt.pfl.hw.AD_TAG_FEED)) {
                com.byazt.pj.pr.pr(this.uc, com.byazt.pfl.hw.AD_TAG_FEED, jCurrentTimeMillis, jSONObject, com.byazt.ne.hn.pr(this.c));
            } else if (this.n.equals("draw_ad")) {
                com.byazt.pj.pr.pr(this.uc, "draw_ad", jCurrentTimeMillis, jSONObject, com.byazt.ne.hn.pr(this.c));
            }
        }
        if (com.byazt.lpk.pr.pr(this.uc)) {
            if (com.byazt.eg.hw.pr().pr(this.uc)) {
                com.byazt.eg.hw.pr().pr(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.uc, jCurrentTimeMillis);
            } else {
                com.byazt.lpk.pr.pr(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.uc, jCurrentTimeMillis);
            }
        }
    }

    @Override // com.byazt.w.hn
    public void hw() {
        if (this.x != null) {
            hn(false);
            this.jn = 2;
            this.l = false;
            this.x.hw();
        }
    }

    @Override // com.byazt.w.hn
    public boolean hn() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i, String str) {
        if (!com.byazt.lpk.pr.pr(this.uc)) {
            return;
        }
        if (this.n.equals(com.byazt.pfl.hw.AD_TAG_FEED)) {
            com.byazt.pj.pr.pr(this.uc, com.byazt.pfl.hw.AD_TAG_FEED, i, str, com.byazt.ne.hn.pr(this.c));
        } else if (this.n.equals("draw_ad")) {
            com.byazt.pj.pr.pr(this.uc, "draw_ad", i, str, com.byazt.ne.hn.pr(this.c));
        }
    }

    @Override // com.byazt.vr.pr, com.byazt.w.hn
    public boolean x() {
        return false;
    }

    @Override // com.byazt.vr.pr, com.byazt.w.hn
    public boolean c() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String vj() {
        if (this.uc == null) {
            return null;
        }
        return this.uc.z();
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.qd.hn.hn(vj(), 3);
    }
}
