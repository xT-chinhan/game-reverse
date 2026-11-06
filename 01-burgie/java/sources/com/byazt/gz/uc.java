package com.byazt.gz;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.byazt.bs.TTViewStub;
import com.byazt.c.SSRenderTextureView;
import com.byazt.ca.yb;
import com.byazt.fj.TTProgressBar;
import com.byazt.hg.ie;
import com.byazt.hg.jn;
import com.byazt.hg.of;
import com.byazt.hg.qv;
import com.byazt.hg.v;
import com.byazt.ld.nt;
import com.byazt.ld.rc;
import com.byazt.mr.m;
import com.byazt.nc.g;
import com.byazt.nc.ho;
import com.byazt.pi.RoundImageView;
import com.byazt.qx.fo;
import com.byazt.sd.a;
import com.byazt.sd.cz;
import com.byazt.sd.qa;
import com.byazt.te.TTLottieVideoContainer;
import com.byazt.te.UpieVideoView;
import com.byazt.vkw.qi;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 672, 5})
public class uc implements com.byazt.c.pr, com.byazt.w.hw<of>, qi.pr, g.pr, ho.hw {
    public int a;
    public ImageView aj;
    public Context b;
    public String bm;
    public View c;
    public boolean cz;
    public AtomicBoolean d;
    public com.byazt.ng.pr e;
    public TextView er;
    public TextView f;
    public int fo;
    public TTViewStub fw;
    public TextView g;
    public final int gu;
    public boolean gz;
    public ImageView hn;
    public TTProgressBar ho;
    public View hs;
    public com.byazt.c.hw hw;
    public RelativeLayout i;
    public RoundImageView ie;
    public TextView ii;
    public ho iu;
    public int jn;
    public TextView k;
    public boolean l;
    public int lb;
    public View ls;
    public com.byazt.az.pr lv;
    public TextView m;
    public final int mw;
    public com.byazt.az.pr n;
    public com.byazt.nv.hn nl;
    public TTViewStub nt;
    public RelativeLayout nw;
    public volatile boolean ny;
    public TextView o;
    public com.byazt.mm.pr.InterfaceC0136pr od;
    public RoundImageView of;
    public View pr;
    public int qa;
    public NativeVideoTsView.pr qi;
    public RelativeLayout qn;
    public TTViewStub r;
    public EnumSet<com.byazt.w.hw.pr> rc;
    public boolean s;
    public final int sv;
    public ImageView uc;
    public TextView v;
    public hw ve;
    public fw vj;
    public View vk;
    public RoundImageView w;
    public com.byazt.az.pr ww;
    public View x;
    public com.byazt.w.hn y;
    public int yb;
    public of z;
    public View zo;

    public /* bridge */ /* synthetic */ void pr(Object obj, WeakReference weakReference, boolean z) {
        pr((of) obj, (WeakReference<Context>) weakReference, z);
    }

    public uc(Context context, View view, boolean z, EnumSet<com.byazt.w.hw.pr> enumSet, of ofVar, com.byazt.w.hn hnVar, boolean z2, com.byazt.az.pr prVar) {
        this.cz = true;
        this.gz = true;
        this.s = true;
        this.mw = 1;
        this.sv = 2;
        this.gu = 3;
        this.d = new AtomicBoolean(false);
        if (this instanceof c) {
            return;
        }
        this.b = a.getContext().getApplicationContext();
        x(z2);
        this.pr = view;
        this.cz = z;
        this.rc = enumSet == null ? EnumSet.noneOf(com.byazt.w.hw.pr.class) : enumSet;
        this.y = hnVar;
        this.lv = prVar;
        this.z = ofVar;
        gz();
        x(8);
        pr(context, this.pr, ofVar);
        x();
        nt();
    }

    public uc(Context context, View view, boolean z, EnumSet<com.byazt.w.hw.pr> enumSet, of ofVar, com.byazt.w.hn hnVar, com.byazt.az.pr prVar) {
        this(context, view, z, enumSet, ofVar, hnVar, true, prVar);
    }

    private void gz() {
        this.jn = 1;
        String strHw = ls.hw(this.z);
        String str = "embeded_ad_landingpage";
        if (strHw == null) {
            strHw = this.gz ? com.byazt.pfl.hw.AD_TAG_FEED : "embeded_ad_landingpage";
        }
        this.jn = ls.x(strHw);
        if (!this.gz && strHw.equals("draw_ad")) {
            str = "draw_ad_landingpage";
        } else if (this.gz || !strHw.equals(com.byazt.pfl.hw.AD_TAG_FEED)) {
            str = strHw;
        }
        this.bm = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nl() {
        zo.pr(new com.byazt.xlm.fw("native_video_layout_download_listener") { // from class: com.byazt.gz.uc.1
            @Override // java.lang.Runnable
            public void run() {
                if (uc.this.nl == null) {
                    uc ucVar = uc.this;
                    ucVar.nl = com.byazt.jx.zo.pr(ucVar.b, uc.this.z, uc.this.bm);
                }
                if (uc.this.ww != null) {
                    ((com.byazt.dl.pr) uc.this.ww.pr(com.byazt.dl.pr.class)).pr(uc.this.nl);
                }
                if (uc.this.n != null) {
                    ((com.byazt.dl.pr) uc.this.n.pr(com.byazt.dl.pr.class)).pr(uc.this.nl);
                }
                if (uc.this.od != null) {
                    uc.this.nl.pr(uc.this.od);
                }
                if (uc.this.nl != null) {
                    uc.this.nl.pr();
                }
            }
        });
    }

    public void nt() {
        View view;
        gz();
        if (com.byazt.lpk.pr.pr(this.z)) {
            com.byazt.az.pr prVar = this.lv;
            if (prVar != null) {
                this.ww = prVar;
            } else {
                this.ww = new com.byazt.az.pr(this.b, this.z, this.bm, this.jn);
            }
            com.byazt.dl.pr.InterfaceC0041pr interfaceC0041pr = new com.byazt.dl.pr.InterfaceC0041pr() { // from class: com.byazt.gz.uc.5
                @Override // com.byazt.dl.pr.InterfaceC0041pr
                public void pr(View view2, int i) {
                    if (uc.this.qi != null) {
                        uc.this.qi.pr(view2, i);
                    }
                }
            };
            ((com.byazt.dl.pr) this.ww.pr(com.byazt.dl.pr.class)).pr(interfaceC0041pr);
            of ofVar = this.z;
            if (ofVar != null) {
                cz.hw(ofVar.le(), interfaceC0041pr, com.byazt.dl.pr.InterfaceC0041pr.class);
            }
            if (this.lv == null && (view = this.pr) != null) {
                view.setOnClickListener(this.ww);
                this.pr.setOnTouchListener(this.ww);
            }
            if (er.x(this.i)) {
                this.i.setOnClickListener(this.ww);
                this.i.setOnTouchListener(this.ww);
                return;
            }
            return;
        }
        ww();
        com.byazt.az.pr prVar2 = new com.byazt.az.pr(this.b, this.z, this.bm, this.jn);
        this.ww = prVar2;
        ((com.byazt.dl.pr) prVar2.pr(com.byazt.dl.pr.class)).hw(true);
        com.byazt.dl.pr.InterfaceC0041pr interfaceC0041pr2 = new com.byazt.dl.pr.InterfaceC0041pr() { // from class: com.byazt.gz.uc.6
            @Override // com.byazt.dl.pr.InterfaceC0041pr
            public void pr(View view2, int i) {
                if (uc.this.qi != null) {
                    uc.this.qi.pr(view2, i);
                }
            }
        };
        ((com.byazt.dl.pr) this.ww.pr(com.byazt.dl.pr.class)).pr(interfaceC0041pr2);
        of ofVar2 = this.z;
        if (ofVar2 != null) {
            cz.hw(ofVar2.le(), interfaceC0041pr2, com.byazt.dl.pr.InterfaceC0041pr.class);
        }
        hw(this.ww);
        if (this.gz) {
            ((com.byazt.dl.pr) this.ww.pr(com.byazt.dl.pr.class)).hn(true);
        } else {
            ((com.byazt.dl.pr) this.ww.pr(com.byazt.dl.pr.class)).hn(false);
            ((com.byazt.dl.pr) this.ww.pr(com.byazt.dl.pr.class)).pr(true);
        }
        if (y()) {
            com.byazt.az.pr prVar3 = new com.byazt.az.pr(this.b, this.z, this.bm, this.jn);
            this.n = prVar3;
            hw(prVar3);
            this.vj = new fw(this);
            ((com.byazt.dl.pr) this.n.pr(com.byazt.dl.pr.class)).hw(true);
            com.byazt.dl.pr.InterfaceC0041pr interfaceC0041pr3 = new com.byazt.dl.pr.InterfaceC0041pr() { // from class: com.byazt.gz.uc.7
                @Override // com.byazt.dl.pr.InterfaceC0041pr
                public void pr(View view2, int i) {
                    if (uc.this.qi != null) {
                        uc.this.qi.pr(view2, i);
                    }
                }
            };
            ((com.byazt.dl.pr) this.n.pr(com.byazt.dl.pr.class)).pr(interfaceC0041pr3);
            of ofVar3 = this.z;
            if (ofVar3 != null) {
                cz.hw(ofVar3.le(), interfaceC0041pr3, com.byazt.dl.pr.InterfaceC0041pr.class);
            }
            if (this.gz) {
                ((com.byazt.dl.pr) this.n.pr(com.byazt.dl.pr.class)).hn(true);
            } else {
                ((com.byazt.dl.pr) this.n.pr(com.byazt.dl.pr.class)).hn(false);
            }
            pr(this.n);
            View view2 = this.pr;
            if (view2 != null) {
                view2.setOnClickListener(this.n);
                this.pr.setOnTouchListener(this.n);
            }
        }
    }

    private void pr(com.byazt.az.pr prVar) {
        of ofVar;
        if (prVar == null || (ofVar = this.z) == null || !com.byazt.lpk.pr.pr(ofVar)) {
            return;
        }
        HashMap map = new HashMap();
        map.put("click_live_element", "click_live_feed");
        ((com.byazt.yx.pr) prVar.pr(com.byazt.yx.pr.class)).pr(map);
    }

    private boolean y() {
        of ofVar = this.z;
        return ofVar != null && ie.fw(ofVar) == null && ie.zo(this.z) == null && this.z.fe() == 1 && of.hn(this.z);
    }

    public void pr(NativeVideoTsView.pr prVar) {
        this.qi = prVar;
    }

    public void pr(m mVar) {
        pr(mVar, this.ww);
        pr(mVar, this.n);
    }

    private void hw(com.byazt.az.pr prVar) {
        of ofVar;
        if (prVar == null || (ofVar = this.z) == null) {
            return;
        }
        com.byazt.mr.g gVarPr = com.byazt.it.pr.pr(Integer.valueOf(ofVar.hashCode()));
        if (!(gVarPr instanceof fo)) {
            return;
        }
        ((fo) gVarPr).pr((com.byazt.yx.hn) prVar.pr(com.byazt.yx.hn.class));
    }

    private void pr(m mVar, com.byazt.az.pr prVar) {
        qa qaVarB;
        if (prVar == null) {
            return;
        }
        ((com.byazt.dl.pr) prVar.pr(com.byazt.dl.pr.class)).pr(mVar);
        com.byazt.yx.hn hnVar = (com.byazt.yx.hn) prVar.pr(com.byazt.yx.hn.class);
        if (!(mVar instanceof com.byazt.fq.hn) || (qaVarB = ((com.byazt.fq.hn) mVar).b()) == null) {
            return;
        }
        qaVarB.pr(hnVar);
    }

    private void ww() {
        if (this.b == null || this.pr == null) {
            return;
        }
        View view = new View(this.b) { // from class: com.byazt.gz.uc.8
            public final AtomicBoolean hw = new AtomicBoolean(true);

            @Override // android.view.View
            public void onMeasure(int i, int i2) {
                super.onMeasure(0, 0);
            }

            @Override // android.view.View
            public void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (uc.this.nl != null && z) {
                    uc.this.nl.hw();
                }
            }

            @Override // android.view.View
            public void onAttachedToWindow() {
                super.onAttachedToWindow();
                uc.this.d.set(false);
                pr();
            }

            @Override // android.view.View
            public void onFinishTemporaryDetach() {
                super.onFinishTemporaryDetach();
                pr();
            }

            private void pr() {
                if (uc.this.z == null) {
                    return;
                }
                if (this.hw.getAndSet(false) && (com.byazt.lpk.pr.pr(uc.this.z) || uc.this.z.aj() == 4)) {
                    uc.this.nl();
                }
                cz.hw(uc.this.z.le(), uc.this.vj, fw.class);
            }

            private void hw() {
                if (!this.hw.getAndSet(true) && uc.this.nl != null) {
                    uc.this.nl.hn();
                }
            }

            @Override // android.view.View
            public void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                uc.this.d.set(true);
                hw();
            }

            @Override // android.view.View
            public void onStartTemporaryDetach() {
                super.onStartTemporaryDetach();
                hw();
            }
        };
        View view2 = this.pr;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(view, 0, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    public com.byazt.c.hw yb() {
        return this.hw;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void pr(Context context, View view, of ofVar) {
        View sSRenderTextureView;
        System.currentTimeMillis();
        if (view != null) {
            view.setKeepScreenOn(true);
        }
        if (com.byazt.ja.pr.hw(ofVar)) {
            sSRenderTextureView = new TTLottieVideoContainer(this.b);
        } else if (com.byazt.ja.pr.hn(ofVar)) {
            sSRenderTextureView = new UpieVideoView(context, com.byazt.ja.pr.vk(ofVar));
        } else {
            sSRenderTextureView = new SSRenderTextureView(this.b);
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(sSRenderTextureView, 0, layoutParams);
            if (s()) {
                view.setBackgroundColor(0);
            } else {
                view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
        }
        er.pr(sSRenderTextureView, 8);
        this.hw = (com.byazt.c.hw) sSRenderTextureView;
        this.hn = (ImageView) view.findViewById(2114387626);
        this.ho = (TTProgressBar) view.findViewById(2114387653);
        this.x = view.findViewById(2114387900);
        this.c = view.findViewById(2114387631);
        this.uc = (ImageView) view.findViewById(2114387651);
        this.fw = (TTViewStub) view.findViewById(2114387744);
        this.r = (TTViewStub) view.findViewById(2114387666);
        this.nt = (TTViewStub) view.findViewById(2114387828);
        if (com.byazt.lpk.pr.pr(ofVar)) {
            hw(context, view);
        }
        System.currentTimeMillis();
    }

    private void hw(Context context, View view) {
        if (view == null) {
            return;
        }
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(2114387888);
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(2114387688);
        if (n()) {
            er.pr((View) relativeLayout, 0);
            er.pr((View) relativeLayout2, 8);
            this.qn = relativeLayout;
        } else {
            er.pr((View) relativeLayout2, 0);
            er.pr((View) relativeLayout, 8);
            this.qn = relativeLayout2;
        }
        RelativeLayout relativeLayout3 = this.qn;
        if (relativeLayout3 == null) {
            return;
        }
        this.of = (RoundImageView) relativeLayout3.findViewById(2114387831);
        this.ii = (TextView) this.qn.findViewById(2114387742);
        this.i = (RelativeLayout) this.qn.findViewById(2114387693);
    }

    private boolean n() {
        if (this.z == null) {
            return false;
        }
        if ("fullscreen_interstitial_ad".equals(this.bm) || "rewarded_video".equals(this.bm)) {
            int iRf = this.z.rf();
            float fOq = this.z.oq();
            if (iRf == 1 && fOq == 100.0f) {
                return true;
            }
        }
        return false;
    }

    public void pr(Context context, View view) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.r) == null || tTViewStub.getParent() == null || this.hs != null) {
            return;
        }
        this.hs = this.r.pr();
        this.nw = (RelativeLayout) view.findViewById(2114387953);
        this.ie = (RoundImageView) view.findViewById(2114387958);
        this.o = (TextView) view.findViewById(2114387926);
        this.f = (TextView) view.findViewById(2114387877);
    }

    public void lb() {
        if (this.z == null) {
            return;
        }
        if (this.l) {
            er.pr((View) this.f, 8);
        }
        if (com.byazt.lpk.pr.pr(this.z)) {
            String strAj = v.aj(this.z);
            String strHn = v.hn(this.z);
            String strZo = v.zo(this.z);
            er.pr(this.hs, 0);
            er.pr((View) this.nw, 0);
            if (!TextUtils.isEmpty(strAj)) {
                com.byazt.ub.hw.pr(strAj).pr(this.ie);
            }
            if (!TextUtils.isEmpty(strHn)) {
                er.pr(this.o, strHn);
            }
            if (this.nw != null && Build.VERSION.SDK_INT >= 17) {
                com.byazt.ub.hw.pr(strZo).hn(2).pr(new rc<Bitmap>() { // from class: com.byazt.gz.uc.9
                    @Override // com.byazt.ld.rc
                    public void pr(nt<Bitmap> ntVar) {
                        Bitmap bitmapPr = com.byazt.js.hw.pr(uc.this.b, ntVar.hn(), 25);
                        if (bitmapPr == null) {
                            return;
                        }
                        final BitmapDrawable bitmapDrawable = new BitmapDrawable(uc.this.nw.getResources(), bitmapPr);
                        zo.pr(new Runnable() { // from class: com.byazt.gz.uc.9.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (uc.this.nw != null) {
                                    uc.this.nw.setBackground(bitmapDrawable);
                                }
                            }
                        });
                    }

                    @Override // com.byazt.ld.rc
                    public void pr(int i, String str, Throwable th) {
                    }
                }, 4);
            }
        }
    }

    private void e() {
        final long jCurrentTimeMillis = System.currentTimeMillis();
        of ofVar = this.z;
        if (ofVar != null && com.byazt.lpk.pr.pr(ofVar)) {
            String strAj = v.aj(this.z);
            if (!TextUtils.isEmpty(strAj)) {
                com.byazt.ub.hw.pr(strAj).pr(this.of);
            }
            String strHn = v.hn(this.z);
            String strZo = v.zo(this.z);
            if (!TextUtils.isEmpty(strHn)) {
                er.pr(this.ii, strHn);
            }
            if (this.qn != null && Build.VERSION.SDK_INT >= 17) {
                com.byazt.ub.hw.pr(strZo).hn(2).pr(new rc<Bitmap>() { // from class: com.byazt.gz.uc.10
                    @Override // com.byazt.ld.rc
                    public void pr(nt<Bitmap> ntVar) {
                        Bitmap bitmapPr = com.byazt.js.hw.pr(uc.this.b, ntVar.hn(), 25);
                        if (bitmapPr == null) {
                            return;
                        }
                        final BitmapDrawable bitmapDrawable = new BitmapDrawable(uc.this.qn.getResources(), bitmapPr);
                        zo.pr(new Runnable() { // from class: com.byazt.gz.uc.10.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (uc.this.qn != null) {
                                    uc.this.qn.setBackground(bitmapDrawable);
                                }
                            }
                        });
                        com.byazt.pj.pr.x(uc.this.z, uc.this.bm, System.currentTimeMillis() - jCurrentTimeMillis);
                    }

                    @Override // com.byazt.ld.rc
                    public void pr(int i, String str, Throwable th) {
                        com.byazt.pj.pr.pr(uc.this.z, uc.this.bm, i, str);
                    }
                }, 4);
            }
        }
    }

    public void pr(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.fw) == null || tTViewStub.getParent() == null || this.zo != null) {
            return;
        }
        this.zo = this.fw.pr();
        this.fw.setVisibility(0);
        this.aj = (ImageView) view.findViewById(2114387804);
        this.vk = view.findViewById(2114387961);
        this.w = (RoundImageView) view.findViewById(2114387664);
        this.k = (TextView) view.findViewById(2114387957);
        this.m = (TextView) view.findViewById(2114387764);
        this.g = (TextView) view.findViewById(2114387686);
    }

    private void hw(View view, Context context) {
        TTViewStub tTViewStub;
        if (view == null || context == null || (tTViewStub = this.nt) == null || tTViewStub.getParent() == null || this.ls != null) {
            return;
        }
        this.nt.pr();
        this.ls = view.findViewById(2114387674);
        this.er = (TextView) view.findViewById(2114387868);
        this.v = (TextView) view.findViewById(2114387842);
    }

    public void qa() {
        if (this.ve != null && this.iu == null) {
            System.currentTimeMillis();
            ho hoVar = new ho();
            this.iu = hoVar;
            hoVar.pr(this.b, this.pr);
            this.iu.pr(this.ve, this);
            System.currentTimeMillis();
        }
    }

    public boolean pr(int i, com.byazt.n.x xVar, boolean z) {
        ho hoVar = this.iu;
        return hoVar == null || hoVar.pr(i, xVar, z);
    }

    public void a() {
        ho hoVar = this.iu;
        if (hoVar != null) {
            hoVar.pr(false);
        }
    }

    public void pr(com.byazt.w.pr prVar) {
        if (prVar instanceof hw) {
            this.ve = (hw) prVar;
            qa();
        }
    }

    public boolean cz() {
        if (this.ve == null) {
            com.byazt.ca.ho.hw("NewLiveViewLayout", "callback is null");
            return false;
        }
        return true;
    }

    public void x() {
        this.hw.pr(this);
        ImageView imageView = this.hn;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.gz.uc.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (uc.this.cz()) {
                        if (uc.this.g != null && uc.this.g.getVisibility() == 0) {
                            return;
                        }
                        uc.this.ve.pr(uc.this, view);
                    }
                }
            });
        }
    }

    public void c(int i) {
        er.pr(this.pr, 0);
        com.byazt.c.hw hwVar = this.hw;
        if (hwVar != null) {
            hwVar.setVisibility(i);
        }
    }

    public void x(boolean z) {
        this.gz = z;
        if (z) {
            com.byazt.az.pr prVar = this.ww;
            if (prVar != null) {
                ((com.byazt.dl.pr) prVar.pr(com.byazt.dl.pr.class)).hn(true);
            }
            com.byazt.az.pr prVar2 = this.n;
            if (prVar2 != null) {
                ((com.byazt.dl.pr) prVar2.pr(com.byazt.dl.pr.class)).hn(true);
                return;
            }
            return;
        }
        com.byazt.az.pr prVar3 = this.ww;
        if (prVar3 != null) {
            ((com.byazt.dl.pr) prVar3.pr(com.byazt.dl.pr.class)).hn(true);
            ((com.byazt.dl.pr) this.ww.pr(com.byazt.dl.pr.class)).pr(true);
        }
        com.byazt.az.pr prVar4 = this.n;
        if (prVar4 != null) {
            ((com.byazt.dl.pr) prVar4.pr(com.byazt.dl.pr.class)).hn(true);
            ((com.byazt.dl.pr) this.n.pr(com.byazt.dl.pr.class)).pr(true);
        }
    }

    public void c() {
    }

    public void uc() {
    }

    public void hw(boolean z) {
    }

    public void pr(int i, int i2) {
        if (i == -1) {
            i = er.c(this.b);
        }
        if (i <= 0) {
            return;
        }
        this.yb = i;
        if (w() || vk() || this.rc.contains(com.byazt.w.hw.pr.fixedSize)) {
            this.lb = i2;
        } else {
            this.lb = fw(i);
        }
        hw(this.yb, this.lb);
    }

    public void hw(boolean z, boolean z2) {
        ImageView imageView = this.hn;
        if (imageView != null) {
            if (z) {
                com.byazt.ca.g.pr(this.b, "tt_new_play_video", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            } else {
                com.byazt.ca.g.pr(this.b, "tt_new_pause_video", imageView, MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME);
            }
        }
    }

    public void pr(String str) {
    }

    public void hw(int i, int i2) {
        ViewGroup.LayoutParams layoutParams;
        View view = this.pr;
        if (view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        if (i == -1 || i == -2 || i > 0) {
            layoutParams.width = i;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.height = i2;
        }
        this.pr.setLayoutParams(layoutParams);
    }

    private int fw(int i) {
        if (this.qa <= 0 || this.a <= 0) {
            return 0;
        }
        int iHn = er.hn(this.b, 228.0f);
        int iHn2 = er.hn(this.b, 160.0f);
        int i2 = (int) (this.a * ((i * 1.0f) / this.qa));
        if (i2 <= iHn) {
            if (i2 >= iHn2) {
                return i2;
            }
            return iHn2;
        }
        return iHn;
    }

    public void hn(int i, int i2) {
        this.qa = i;
        this.a = i2;
    }

    public void hw(int i) {
        er.pr((View) this.ho, 0);
        TTProgressBar tTProgressBar = this.ho;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(i);
        }
    }

    public void pr(long j, long j2) {
    }

    public void hn(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.pr.getParent() == null) {
            viewGroup.addView(this.pr);
        }
        x(0);
    }

    @Override // com.byazt.w.hw
    public View hn() {
        return this.pr;
    }

    public void fw() {
        if (com.byazt.lpk.pr.pr(this.z)) {
            ny();
        } else {
            ls();
        }
        ImageView imageView = this.hn;
        if (imageView != null && imageView.getVisibility() == 0) {
            er.pr((View) this.hn, 8);
        }
    }

    private boolean s() {
        return TextUtils.equals(this.bm, "splash_ad") || TextUtils.equals(this.bm, "cache_splash_ad");
    }

    private void ls() {
        if (s()) {
            er.pr((View) this.hn, 8);
            if (!a.hw().bg()) {
                er.pr(this.x, 8);
                er.pr(this.c, 8);
                er.pr((View) this.uc, 8);
                return;
            }
        }
        er.pr(this.x, 0);
        er.pr((View) this.qn, 8);
        er.uc(this.x);
        if (s() && a.hw().bg()) {
            er.pr(this.c, 8);
        } else {
            er.uc(this.c);
        }
        if (this.uc != null && !TextUtils.isEmpty(qv.hw(this.z))) {
            er.uc(this.uc);
            com.byazt.ub.hw.pr(qv.hw(this.z)).pr(this.uc);
            pr(this.uc, qv.hw(this.z));
        }
    }

    public void ny() {
        er.pr(this.x, 8);
        er.pr((View) this.qn, 0);
        e();
    }

    public void fo() {
        if (com.byazt.lpk.pr.pr(this.z)) {
            ny();
        } else {
            er.pr((View) this.qn, 8);
            er.uc(this.x);
            er.uc(this.c);
        }
        ImageView imageView = this.hn;
        if (imageView != null && imageView.getVisibility() == 0) {
            er.pr((View) this.hn, 8);
        }
    }

    public void pr() {
        pr(false, this.cz);
        z();
    }

    public void pr(long j) {
    }

    public void rc() {
        er.pr(this.pr, 0);
        com.byazt.c.hw hwVar = this.hw;
        if (hwVar != null) {
            View view = hwVar.getView();
            er.pr(view, 8);
            er.pr(view, 0);
        }
    }

    public void z() {
        er.pr(this.zo, 8);
        er.pr((View) this.aj, 8);
        er.pr(this.vk, 8);
        er.pr((View) this.w, 8);
        er.pr((View) this.k, 8);
        er.pr((View) this.m, 8);
        er.pr((View) this.g, 8);
        er.pr(this.hs, 8);
        er.pr((View) this.nw, 8);
    }

    private void zo(int i) {
        er.pr(this.vk, i);
        er.pr(this.ls, i);
    }

    @Override // com.byazt.w.hw
    public void pr(boolean z) {
        this.s = z;
    }

    public void uc(int i) {
        of ofVar;
        if (this.w == null || (ofVar = this.z) == null || ofVar.mo() == null || this.z.mo().pr() == null) {
            return;
        }
        if (i == 1) {
            int iHn = er.hn(this.b, 71.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iHn, iHn);
            layoutParams.addRule(14);
            this.w.setLayoutParams(layoutParams);
            this.k.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = er.hn(this.b, 16.0f);
            layoutParams2.topMargin = er.hn(this.b, 8.0f);
            layoutParams2.leftMargin = er.hn(this.b, 16.0f);
            layoutParams2.rightMargin = er.hn(this.b, 16.0f);
            layoutParams2.addRule(3, this.w.getId());
            layoutParams2.addRule(14);
            this.m.setLayoutParams(layoutParams2);
            this.m.setTextSize(16.0f);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, er.hn(this.b, 32.0f));
            layoutParams3.addRule(14);
            layoutParams3.addRule(3, this.m.getId());
            layoutParams3.leftMargin = er.hn(this.b, 20.0f);
            layoutParams3.rightMargin = er.hn(this.b, 20.0f);
            this.g.setPadding(er.hn(this.b, 36.0f), er.hn(this.b, 7.0f), er.hn(this.b, 36.0f), er.hn(this.b, 8.0f));
            this.g.setLayoutParams(layoutParams3);
            this.g.setEllipsize(TextUtils.TruncateAt.END);
            this.g.setSingleLine(true);
            this.g.setTextSize(14.0f);
            return;
        }
        if (i == 2) {
            int iHn2 = er.hn(this.b, 40.0f);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iHn2, iHn2);
            layoutParams4.addRule(14);
            this.w.setLayoutParams(layoutParams4);
            this.k.setLayoutParams(layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.bottomMargin = er.hn(this.b, 8.0f);
            layoutParams5.topMargin = er.hn(this.b, 8.0f);
            layoutParams5.addRule(3, this.w.getId());
            layoutParams5.addRule(14);
            this.m.setLayoutParams(layoutParams5);
            this.m.setTextSize(10.0f);
            er.pr((View) this.g, 8);
            return;
        }
        int iHn3 = er.hn(this.b, 49.0f);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(iHn3, iHn3);
        layoutParams6.addRule(14);
        this.w.setLayoutParams(layoutParams6);
        this.k.setLayoutParams(layoutParams6);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.bottomMargin = er.hn(this.b, 8.0f);
        layoutParams7.topMargin = er.hn(this.b, 8.0f);
        layoutParams7.addRule(3, this.w.getId());
        layoutParams7.addRule(14);
        this.m.setLayoutParams(layoutParams7);
        this.m.setTextSize(13.0f);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, er.hn(this.b, 28.0f));
        layoutParams8.addRule(13);
        layoutParams8.addRule(3, this.m.getId());
        int iHn4 = er.hn(this.b, 20.0f);
        int iHn5 = er.hn(this.b, 25.0f);
        int iHn6 = er.hn(this.b, 6.0f);
        TextPaint paint = this.g.getPaint();
        Rect rect = new Rect();
        CharSequence text = this.g.getText();
        if (TextUtils.isEmpty(text)) {
            text = "";
        }
        String string = text.toString();
        paint.getTextBounds(string, 0, string.length(), rect);
        this.g.setTextSize(13.0f);
        if (this.g.getWidth() > (iHn5 * 2) + rect.width() && this.g.getHeight() > (iHn6 * 2) + rect.height()) {
            layoutParams8.leftMargin = iHn4;
            layoutParams8.rightMargin = iHn4;
            this.g.setPadding(iHn5, er.hn(this.b, 5.0f), iHn5, iHn6);
        }
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setSingleLine(true);
        this.g.setLayoutParams(layoutParams8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void er() {
        try {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            layoutParams.addRule(15);
            View view = this.vk;
            if (view != null) {
                view.setLayoutParams(layoutParams);
            }
            View view2 = this.pr;
            if (view2 == null) {
                return;
            }
            int measuredWidth = view2.getMeasuredWidth();
            int measuredHeight = this.pr.getMeasuredHeight();
            int iHn = er.hn(this.b, 200.0f);
            int iHn2 = er.hn(this.b, 331.0f);
            int iHn3 = er.hn(this.b, 110.0f);
            int iHn4 = er.hn(this.b, 100.0f);
            if (measuredWidth >= iHn && measuredHeight >= iHn2) {
                uc(1);
                return;
            }
            if (measuredWidth > iHn3 && measuredHeight > iHn4) {
                uc(3);
                return;
            }
            uc(2);
        } catch (Exception e) {
        }
    }

    public void pr(final ImageView imageView, String str) {
        if (imageView != null && com.byazt.ja.pr.pr(this.z) && !com.byazt.ja.pr.fw(this.z)) {
            com.byazt.ub.hw.pr(str).pr(Bitmap.Config.ARGB_4444).hn(2).pr(new rc<Bitmap>() { // from class: com.byazt.gz.uc.12
                @Override // com.byazt.ld.rc
                public void pr(nt<Bitmap> ntVar) {
                    Bitmap bitmapHn;
                    if (ntVar != null && (bitmapHn = ntVar.hn()) != null) {
                        final Bitmap bitmapPr = com.byazt.js.hw.pr(uc.this.b, bitmapHn, 25);
                        zo.pr(new Runnable() { // from class: com.byazt.gz.uc.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (bitmapPr != null) {
                                    imageView.setBackground(new BitmapDrawable(bitmapPr));
                                }
                            }
                        });
                    }
                }

                @Override // com.byazt.ld.rc
                public void pr(int i, String str2, Throwable th) {
                }
            }, 4);
        }
    }

    public void pr(of ofVar, WeakReference<Context> weakReference, boolean z) {
        String strJv;
        of ofVar2;
        if (ofVar == null || s()) {
            return;
        }
        pr(false, this.cz);
        if (com.byazt.lpk.pr.pr(ofVar)) {
            pr(a.getContext(), this.pr);
            lb();
            return;
        }
        pr(this.pr, a.getContext());
        View view = this.zo;
        if (view != null) {
            er.pr(view, 0);
        }
        ImageView imageView = this.aj;
        if (imageView != null) {
            er.pr((View) imageView, 0);
        }
        if (ls.x(this.z)) {
            hw(this.pr, a.getContext());
            er.pr(this.vk, 8);
            er.pr((View) this.aj, 0);
            er.pr(this.ls, 0);
            er.pr((View) this.er, 0);
            er.pr((View) this.v, 0);
            if (this.v != null && yb.hn(a.getContext()) == 0) {
                er.pr((View) this.v, 8);
            }
            View view2 = this.zo;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.gz.uc.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        if (uc.this.y != null) {
                            ((com.byazt.w.pr) uc.this.y).pr();
                            if (uc.this.e != null) {
                                uc.this.e.pr();
                            }
                        }
                    }
                });
            }
            if (this.aj != null && !TextUtils.isEmpty(qv.hw(this.z))) {
                if (com.byazt.ja.pr.hw(ofVar)) {
                    com.byazt.ub.hw.pr(qv.hw(this.z)).pr(this.aj);
                    pr(this.aj, qv.hw(this.z));
                } else {
                    com.byazt.t.hw.pr(2147483647L, qv.pr(this.z), new com.byazt.t.hw.InterfaceC0192hw() { // from class: com.byazt.gz.uc.3
                        @Override // com.byazt.t.hw.InterfaceC0192hw
                        public void pr(Bitmap bitmap) {
                            if (bitmap != null) {
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) uc.this.aj.getLayoutParams();
                                if (bitmap.getWidth() > bitmap.getHeight()) {
                                    float height = (bitmap.getHeight() * er.c(a.getContext())) / bitmap.getWidth();
                                    layoutParams.width = er.c(a.getContext());
                                    layoutParams.height = (int) height;
                                    layoutParams.addRule(13);
                                    uc.this.aj.setLayoutParams(layoutParams);
                                }
                                uc.this.aj.setImageBitmap(bitmap);
                                return;
                            }
                            com.byazt.ub.hw.pr(qv.hw(uc.this.z)).pr(uc.this.aj);
                        }
                    });
                }
            }
        } else {
            er.pr(this.vk, 0);
            if (this.aj != null && !TextUtils.isEmpty(qv.hw(this.z))) {
                com.byazt.ub.hw.pr(qv.hw(this.z)).pr(this.aj);
                pr(this.aj, qv.hw(this.z));
            }
            if (v()) {
                this.vk.post(new Runnable() { // from class: com.byazt.gz.uc.4
                    @Override // java.lang.Runnable
                    public void run() {
                        uc.this.er();
                    }
                });
            }
        }
        if (!TextUtils.isEmpty(ofVar.zj())) {
            strJv = ofVar.zj();
        } else if (!TextUtils.isEmpty(ofVar.A_())) {
            strJv = ofVar.A_();
        } else if (TextUtils.isEmpty(ofVar.jv())) {
            strJv = "";
        } else {
            strJv = ofVar.jv();
        }
        if (this.w != null && (ofVar2 = this.z) != null && ofVar2.mo() != null && this.z.mo().pr() != null) {
            er.pr((View) this.w, 0);
            er.pr((View) this.k, 4);
            com.byazt.ub.hw.pr(this.z.mo()).pr(this.w);
            if (y()) {
                this.w.setOnClickListener(this.n);
                this.w.setOnTouchListener(this.n);
            } else {
                this.w.setOnClickListener(this.ww);
                this.w.setOnTouchListener(this.ww);
            }
        } else if (!TextUtils.isEmpty(strJv)) {
            er.pr((View) this.w, 4);
            er.pr((View) this.k, 0);
            TextView textView = this.k;
            if (textView != null) {
                textView.setText(strJv.substring(0, 1));
                if (y()) {
                    this.k.setOnClickListener(this.n);
                    this.k.setOnTouchListener(this.n);
                } else {
                    this.k.setOnClickListener(this.ww);
                    this.k.setOnTouchListener(this.ww);
                }
            }
        }
        if (this.m != null && !TextUtils.isEmpty(strJv)) {
            this.m.setText(strJv);
        }
        er.pr((View) this.m, 0);
        er.pr((View) this.g, 0);
        String strSe = ofVar.se();
        if (TextUtils.isEmpty(strSe)) {
            switch (ofVar.aj()) {
                case 4:
                    strSe = "立即下载";
                    break;
                case 5:
                    strSe = "立即拨打";
                    break;
                default:
                    strSe = "查看详情";
                    break;
            }
        }
        TextView textView2 = this.g;
        if (textView2 != null) {
            textView2.setText(strSe);
            this.g.setOnClickListener(this.ww);
            this.g.setOnTouchListener(this.ww);
        }
        TextView textView3 = this.er;
        if (textView3 != null) {
            textView3.setText(strSe);
            this.er.setOnClickListener(this.ww);
            this.er.setOnTouchListener(this.ww);
        }
        if (!this.s) {
            zo(4);
        }
    }

    private boolean v() {
        of ofVar;
        return this.gz && this.vk != null && (ofVar = this.z) != null && ofVar.bh() == 1;
    }

    public void b() {
        boolean z;
        of ofVar = this.z;
        if (ofVar == null) {
            return;
        }
        if (ofVar.sq() == 1 && jn.yb(this.z)) {
            z = true;
        } else {
            z = false;
        }
        if (!(this.z.sq() != 5 ? z : true)) {
            return;
        }
        pr(false, this.cz);
        pr(this.pr, a.getContext());
        if (this.aj != null && !TextUtils.isEmpty(qv.hw(this.z))) {
            er.pr(this.zo, 0);
            er.pr((View) this.aj, 0);
            er.pr(this.vk, 8);
            com.byazt.ub.hw.pr(qv.hw(this.z)).pr(this.aj);
            pr(this.aj, qv.hw(this.z));
        }
    }

    public void iu() {
        if (s()) {
            er.pr((View) this.hn, 8);
            er.c(this.x);
            er.c(this.c);
            ImageView imageView = this.uc;
            if (imageView != null) {
                er.c(imageView);
            }
        }
    }

    @Override // com.byazt.w.hw
    public void hw() {
        if (s()) {
            er.pr(this.x, 8);
            er.pr(this.c, 8);
            er.pr((View) this.uc, 8);
            er.pr((View) this.hn, 8);
            return;
        }
        er.pr((View) this.qn, 8);
        er.c(this.x);
        er.c(this.c);
        ImageView imageView = this.uc;
        if (imageView != null) {
            er.c(imageView);
        }
    }

    public void zo() {
        if (com.byazt.lpk.pr.pr(this.z)) {
            er.pr((View) this.qn, 8);
        } else {
            er.c(this.x);
        }
    }

    @Override // com.byazt.c.pr
    public void pr(SurfaceTexture surfaceTexture, int i, int i2) {
        this.ny = true;
        if (cz()) {
            this.ve.pr(this, surfaceTexture);
        }
    }

    @Override // com.byazt.c.pr
    public boolean pr(SurfaceTexture surfaceTexture) {
        this.ny = false;
        if (cz()) {
            this.ve.hw(this, surfaceTexture);
            return true;
        }
        return true;
    }

    public void aj() {
        TTProgressBar tTProgressBar = this.ho;
        if (tTProgressBar != null) {
            tTProgressBar.setProgress(0);
            this.ho.setSecondaryProgress(0);
        }
        x(8);
        if (ve()) {
            this.hw.setVisibility(8);
        }
        ImageView imageView = this.uc;
        if (imageView != null) {
            imageView.setImageDrawable(null);
            this.uc.setBackground(null);
        }
        ImageView imageView2 = this.aj;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
            this.aj.setBackground(null);
        }
        x(8);
        er.pr(this.zo, 8);
        er.pr((View) this.aj, 8);
        er.pr(this.vk, 8);
        er.pr((View) this.w, 8);
        er.pr((View) this.k, 8);
        er.pr((View) this.m, 8);
        er.pr(this.hs, 8);
        er.pr((View) this.nw, 8);
        ho hoVar = this.iu;
        if (hoVar != null) {
            hoVar.pr(true);
        }
    }

    public boolean vk() {
        return false;
    }

    public boolean w() {
        return this.cz;
    }

    public void pr(ViewGroup viewGroup) {
    }

    public void hw(ViewGroup viewGroup) {
    }

    public void pr(Message message) {
    }

    public void pr(boolean z, boolean z2, boolean z3) {
        er.pr((View) this.ho, 0);
        er.pr((View) this.hn, (z && (er.x(this.x) && er.x(this.qn))) ? 0 : 8);
    }

    public void pr(boolean z, boolean z2) {
        er.pr((View) this.ho, z ? 0 : 8);
        er.pr((View) this.hn, 8);
    }

    public void k() {
        pr(true, false);
    }

    public boolean hn(int i) {
        return false;
    }

    public void hn(boolean z) {
    }

    public boolean m() {
        return this.ny;
    }

    public void x(int i) {
        this.fo = i;
        er.pr(this.pr, i);
    }

    public void pr(View view, boolean z) {
    }

    public void g() {
    }

    public boolean ho() {
        ho hoVar = this.iu;
        return hoVar != null && hoVar.pr();
    }

    public boolean ve() {
        return !this.rc.contains(com.byazt.w.hw.pr.alwayShowMediaView) || this.cz;
    }

    public void pr(com.byazt.ng.pr prVar) {
        this.e = prVar;
        com.byazt.az.pr prVar2 = this.ww;
        if (prVar2 != null) {
            ((com.byazt.dl.pr) prVar2.pr(com.byazt.dl.pr.class)).pr(prVar);
        }
    }

    @Override // com.byazt.w.hw
    public void pr(Drawable drawable) {
        View view = this.pr;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
        }
    }

    @Override // com.byazt.w.hw
    public void pr(int i) {
        er.pr((View) this.i, i);
    }

    public void c(boolean z) {
        this.l = z;
    }

    public void pr(com.byazt.mm.pr.InterfaceC0136pr interfaceC0136pr) {
        this.od = interfaceC0136pr;
        com.byazt.nv.hn hnVar = this.nl;
        if (hnVar != null) {
            hnVar.pr(interfaceC0136pr);
        }
    }
}
