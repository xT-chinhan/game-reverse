package com.byazt.yb;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.bs.LazeLayout;
import com.byazt.ca.yb;
import com.byazt.gz.NativeDrawVideoTsView;
import com.byazt.gz.NativeVideoTsView;
import com.byazt.hg.of;
import com.byazt.mr.m;
import com.byazt.sd.a;
import com.byazt.sd.qa;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import com.byazt.zp.zo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 20})
public class hn extends com.byazt.xn.pr implements LazeLayout.pr<NativeVideoTsView>, com.byazt.bs.pr<NativeVideoTsView> {
    public LazeLayout aj;
    public x c;
    public final of fw;
    public int hn;
    public Bitmap hw;
    public com.byazt.ti.pr k;
    public boolean pr;
    public final Context uc;
    public volatile WeakReference<NativeVideoTsView> vk;
    public CreativeContainer w;
    public com.byazt.ng.pr x;
    public com.byazt.qe.hw zo;

    /* JADX WARN: Multi-variable type inference failed */
    public hn(Context context, of ofVar, int i, com.byazt.qe.hw hwVar) {
        super(new x(context, ofVar, i, hwVar));
        this.aj = null;
        this.vk = null;
        this.k = new com.byazt.ti.pr(0 == true ? 1 : 0) { // from class: com.byazt.yb.hn.3
            @Override // com.byazt.ti.pr
            public void pr(View view, m mVar) {
                NativeVideoTsView nativeVideoTsViewUc = hn.this.c.uc();
                if (nativeVideoTsViewUc != null) {
                    nativeVideoTsViewUc.w();
                }
            }

            @Override // com.byazt.ti.pr
            public void hw(View view, m mVar) {
                NativeVideoTsView nativeVideoTsViewUc = hn.this.c.uc();
                if (nativeVideoTsViewUc != null) {
                    nativeVideoTsViewUc.w();
                }
            }

            @Override // com.byazt.ti.pr
            public void pr(m mVar) {
                NativeVideoTsView nativeVideoTsViewUc = hn.this.c.uc();
                if (nativeVideoTsViewUc != null) {
                    nativeVideoTsViewUc.a();
                }
            }
        };
        this.zo = hwVar;
        x xVar = (x) c();
        this.c = xVar;
        this.fw = ofVar;
        this.uc = context;
        ((com.byazt.fq.hn) xVar.fo()).pr(this.k);
        if (context != null && !of.hn(ofVar) && CreativeContainer.hw(ofVar)) {
            com.byazt.fq.hn hnVar = (com.byazt.fq.hn) this.c.fo();
            this.w = new CreativeContainer(context, ofVar, hnVar != null ? hnVar.uc() : null);
        }
    }

    @Override // com.byazt.xn.pr, com.byazt.mr.m
    public View pr() {
        of ofVar = this.fw;
        NativeVideoTsView nativeVideoTsViewHw = null;
        if (ofVar == null || this.uc == null) {
            return null;
        }
        com.byazt.ua.hw.pr(ofVar.pr());
        if (of.hw(this.fw)) {
            com.byazt.xk.hw.pr().pr(this.fw, 3, "valid invoke");
        }
        if (of.hn(this.fw)) {
            if (zo.pr()) {
                this.aj = new LazeLayout(this.uc, this, this);
            } else {
                try {
                    nativeVideoTsViewHw = hw(this.uc);
                } catch (Throwable th) {
                }
                if (nativeVideoTsViewHw != null) {
                    pr(nativeVideoTsViewHw);
                }
                return nativeVideoTsViewHw;
            }
        } else if (this.w != null) {
            com.byazt.fq.hn hnVar = (com.byazt.fq.hn) this.c.fo();
            if (hnVar != null && hnVar.b() != null) {
                hnVar.b().pr(this.w);
            }
            return this.w;
        }
        com.byazt.nz.x.pr().pr(this.fw).pr(this.c.fw()).hw(this.c.zo());
        return this.aj;
    }

    @Override // com.byazt.bs.pr
    /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
    public NativeVideoTsView hw(Context context) {
        NativeVideoTsView nativeVideoTsViewPr = this.c.pr(true);
        nativeVideoTsViewPr.setControllerStatusCallBack(new NativeVideoTsView.x() { // from class: com.byazt.yb.hn.1
            @Override // com.byazt.gz.NativeVideoTsView.x
            public void pr(boolean z, long j, long j2, long j3, boolean z2, boolean z3) {
                hn.this.c.pr.pr = z;
                hn.this.c.pr.c = j;
                hn.this.c.pr.uc = j2;
                hn.this.c.pr.fw = j3;
                hn.this.c.pr.x = z2;
                hn.this.c.pr.zo = z3;
            }
        });
        nativeVideoTsViewPr.setAdCreativeClickListener(new NativeVideoTsView.pr() { // from class: com.byazt.yb.hn.2
            @Override // com.byazt.gz.NativeVideoTsView.pr
            public void pr(View view, int i) {
                qa qaVarB = ((com.byazt.fq.hn) hn.this.c.fo()).b();
                if (qaVarB != null) {
                    qaVarB.pr(view, i);
                }
            }
        });
        nativeVideoTsViewPr.setVideoAdLoadListener(this.c);
        nativeVideoTsViewPr.setVideoAdInteractionListener(this.c);
        nativeVideoTsViewPr.setIsAutoPlay(pr(ls.m(this.fw)));
        nativeVideoTsViewPr.setIsQuiet(this.fw.ax() == 1);
        NativeDrawVideoTsView nativeDrawVideoTsView = (NativeDrawVideoTsView) nativeVideoTsViewPr;
        nativeDrawVideoTsView.setCanInterruptVideoPlay(this.pr);
        Bitmap bitmap = this.hw;
        if (bitmap != null) {
            nativeDrawVideoTsView.pr(bitmap, this.hn);
        }
        nativeVideoTsViewPr.setDrawVideoListener(this.x);
        this.vk = new WeakReference<>(nativeVideoTsViewPr);
        return nativeVideoTsViewPr;
    }

    @Override // com.byazt.bs.LazeLayout.pr
    public void pr(NativeVideoTsView nativeVideoTsView) {
        if (nativeVideoTsView != null) {
            nativeVideoTsView.setNativeRenderAd(true);
            nativeVideoTsView.pr(0L, true, false);
        }
    }

    @Override // com.byazt.mr.m
    public void pr(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.byazt.ti.pr prVar, com.byazt.mt.pr prVar2) {
        View viewPr;
        try {
            pr(viewGroup, (List<View>) null, list, list2, list3, (View) null, prVar);
            if (prVar2 != null) {
                View viewFindViewById = viewGroup.findViewById(prVar2.hw());
                if (viewFindViewById != null && aj() != null) {
                    viewFindViewById.setVisibility(0);
                    if (viewFindViewById instanceof ViewGroup) {
                        ((ViewGroup) viewFindViewById).removeAllViews();
                        ImageView imageView = new ImageView(viewGroup.getContext());
                        imageView.setImageBitmap(aj());
                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                        layoutParams.width = er.hn(viewGroup.getContext(), 38.0f);
                        layoutParams.height = er.hn(viewGroup.getContext(), 38.0f);
                        viewFindViewById.setLayoutParams(layoutParams);
                        ((ViewGroup) viewFindViewById).addView(imageView, -1, -1);
                    } else if (viewFindViewById instanceof ImageView) {
                        ((ImageView) viewFindViewById).setImageBitmap(aj());
                    }
                }
                FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(prVar2.pr());
                if (frameLayout == null || (viewPr = pr()) == null) {
                    return;
                }
                er.zo(viewPr);
                frameLayout.removeAllViews();
                frameLayout.addView(viewPr, -1, -1);
            }
        } catch (Throwable th) {
        }
    }

    @Override // com.byazt.mr.m
    public void pr(com.byazt.ti.hw hwVar) {
        x xVar = this.c;
        if (xVar != null) {
            xVar.pr(hwVar);
        }
    }

    @Override // com.byazt.mr.m
    public com.byazt.wd.x hw() {
        return new com.byazt.vd.hn();
    }

    @Override // com.byazt.mr.aj
    public void pr(boolean z) {
        this.pr = z;
    }

    @Override // com.byazt.mr.aj
    public void pr(Bitmap bitmap, int i) {
        this.hw = bitmap;
        this.hn = i;
        fw();
    }

    @Override // com.byazt.xn.pr, com.byazt.mr.m
    public void hn() {
        NativeVideoTsView nativeVideoTsView;
        super.hn();
        if (this.vk != null && (nativeVideoTsView = this.vk.get()) != null) {
            nativeVideoTsView.a();
        }
        LazeLayout lazeLayout = this.aj;
        if (lazeLayout != null) {
            lazeLayout.pr();
        }
        CreativeContainer creativeContainer = this.w;
        if (creativeContainer != null) {
            creativeContainer.setOnClickListener(null);
        }
    }

    @Override // com.byazt.mr.m
    public String x() {
        of ofVar = this.fw;
        if (ofVar != null) {
            return ofVar.z();
        }
        return null;
    }

    private boolean pr(int i) {
        int iUc = a.hw().uc(i);
        if (3 == iUc) {
            return false;
        }
        if (1 == iUc && yb.x(this.uc)) {
            return true;
        }
        if (2 == iUc) {
            if (yb.c(this.uc) || yb.x(this.uc)) {
                return true;
            }
            yb.uc(this.uc);
            return true;
        }
        if (5 != iUc || yb.x(this.uc)) {
            return true;
        }
        yb.uc(this.uc);
        return true;
    }

    @Override // com.byazt.mr.aj
    public void pr(com.byazt.ng.pr prVar) {
        this.x = prVar;
    }

    private void fw() {
        int i = this.hn;
        if (i >= 200) {
            this.hn = 200;
        } else if (i <= 20) {
            this.hn = 20;
        }
    }
}
