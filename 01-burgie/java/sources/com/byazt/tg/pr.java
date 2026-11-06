package com.byazt.tg;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.byazt.ch.ny;
import com.byazt.ea.w;
import com.byazt.hg.b;
import com.byazt.hg.bh;
import com.byazt.hg.ie;
import com.byazt.hg.m;
import com.byazt.hg.of;
import com.byazt.mq.g;
import com.byazt.pv.zo;
import com.byazt.sd.a;
import com.byazt.uq.EasyPlayableContainer;
import com.byazt.wt.ls;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 37})
public class pr extends com.byazt.uq.hw implements com.byazt.fy.hw {
    public Context aj;
    public View c;
    public com.byazt.gu.c fw;
    public boolean uc;
    public final com.byazt.uq.fw vk;
    public bh x;
    public com.byazt.qe.hw zo;

    public pr(of ofVar, com.byazt.uq.pr prVar, bh bhVar) {
        super(ofVar, prVar);
        this.uc = false;
        this.vk = new com.byazt.uq.fw() { // from class: com.byazt.tg.pr.1
            @Override // com.byazt.uq.fw
            public void pr() {
            }

            @Override // com.byazt.uq.fw
            public void pr(boolean z) {
            }

            @Override // com.byazt.uq.fw
            public void hw() {
                pr.this.uc = true;
                pr.this.aj();
            }

            @Override // com.byazt.uq.fw
            public void hn() {
                pr.this.uc = false;
                if (pr.this.c != null) {
                    pr.this.c.setVisibility(8);
                }
            }

            @Override // com.byazt.uq.fw
            public void x() {
                if (b.pr() && pr.this.hn != null) {
                    pr.this.hn.pr(pr.this.pr);
                }
            }

            @Override // com.byazt.uq.fw
            public void c() {
                pr.this.zo();
            }

            @Override // com.byazt.uq.fw
            public void pr(int i) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("second_page_type", i);
                } catch (JSONException e) {
                }
                com.byazt.uq.hn.hw(pr.this.pr, pr.this.x, false, jSONObject);
                pr.this.pr(i);
            }
        };
        this.x = bhVar;
    }

    public void pr(bh bhVar) {
        this.x = bhVar;
    }

    public boolean pr(ViewGroup viewGroup, View view) {
        bh bhVar = this.x;
        if (bhVar == null || view == null || viewGroup == null) {
            com.byazt.uq.hn.pr(this.pr, (m) this.x, false, 5);
            return false;
        }
        if (!bhVar.k()) {
            com.byazt.uq.hn.pr(this.pr, (m) this.x, false, 6);
            return false;
        }
        if (com.byazt.uq.x.pr(viewGroup)) {
            String name = viewGroup.getClass().getName();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("container_name", name);
                jSONObject.put("enable_layout_restrict", a.hw().yc());
            } catch (JSONException e) {
            }
            com.byazt.uq.hn.pr(this.pr, (m) this.x, false, 1, jSONObject);
            return false;
        }
        if (!com.byazt.uq.x.pr(this.pr, true)) {
            com.byazt.uq.hn.pr(this.pr, (m) this.x, false, 2);
            return false;
        }
        if (a.hw().w() && Build.VERSION.SDK_INT <= 25) {
            com.byazt.uq.hn.pr(this.pr, (m) this.x, false, 9);
            return false;
        }
        if (this.x.zo() == 1) {
            com.byazt.uq.hn.pr(this.pr, (m) this.x, false, 11);
            return false;
        }
        if (this.x.pr(view.getWidth(), view.getHeight())) {
            return true;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("view_width", view.getWidth());
            jSONObject2.put("view_height", view.getHeight());
        } catch (JSONException e2) {
        }
        com.byazt.uq.hn.pr(this.pr, (m) this.x, false, 10, jSONObject2);
        return false;
    }

    public void hw(ViewGroup viewGroup, View view) {
        if (!pr(viewGroup, view)) {
            com.byazt.qd.uc.pr(com.byazt.ewt.fw.pr(this.pr), 2);
            pr(viewGroup);
        } else {
            hn(viewGroup, view);
        }
    }

    public int x() {
        return 2;
    }

    private void hn(final ViewGroup viewGroup, final View view) {
        bh bhVar = this.x;
        if (bhVar == null) {
            pr(viewGroup);
        } else {
            w.pr(this.x.vk(), bhVar.aj(), new com.byazt.ea.hn() { // from class: com.byazt.tg.pr.2
                @Override // com.byazt.ea.hn
                public void pr(String str) {
                    try {
                        com.byazt.qd.uc.pr(com.byazt.ewt.fw.pr(pr.this.pr), 1);
                        com.byazt.uq.hn.pr(pr.this.pr, (m) pr.this.x, true);
                        pr.this.pr(new JSONObject(str), viewGroup, view);
                    } catch (JSONException e) {
                        com.byazt.qd.uc.pr(com.byazt.ewt.fw.pr(pr.this.pr), 2);
                        com.byazt.uq.hn.pr(pr.this.pr, (m) pr.this.x, false, 3);
                        pr.this.pr(viewGroup);
                    }
                }

                @Override // com.byazt.ea.hn
                public void pr() {
                    com.byazt.qd.uc.pr(com.byazt.ewt.fw.pr(pr.this.pr), 2);
                    com.byazt.uq.hn.pr(pr.this.pr, (m) pr.this.x, false, 4);
                    pr.this.pr(viewGroup);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final JSONObject jSONObject, final ViewGroup viewGroup, final View view) {
        viewGroup.post(new Runnable() { // from class: com.byazt.tg.pr.3
            @Override // java.lang.Runnable
            public void run() {
                if (pr.this.pr == null || pr.this.x == null) {
                    com.byazt.uq.hn.pr(pr.this.pr, (m) pr.this.x, false, 100, "materialMeta or ugenComponent is null");
                    pr.this.pr(viewGroup);
                    return;
                }
                int iHn = pr.this.x.hn();
                com.byazt.gu.hw hwVarPr = pr.this.pr(view, pr.this.pr(iHn, jSONObject, view));
                pr.this.fw();
                pr prVar = pr.this;
                prVar.fw = prVar.pr(iHn, hwVarPr, viewGroup);
                pr.this.vk();
                final int i = iHn != 3 ? 2 : 3;
                com.byazt.qd.uc.pr().pr(com.byazt.ewt.fw.pr(pr.this.pr), new com.byazt.ewt.x.pr() { // from class: com.byazt.tg.pr.3.1
                    @Override // com.byazt.ewt.x.pr
                    public void pr(com.byazt.ewt.hw hwVar) {
                        if (hwVar instanceof zo) {
                            ((zo) hwVar).x = i;
                        }
                    }
                });
                com.byazt.qd.uc.hn(com.byazt.ewt.fw.pr(pr.this.pr));
                com.byazt.uq.hn.hw(pr.this.pr, pr.this.x);
                pr.this.fw.pr(new com.byazt.mq.fw() { // from class: com.byazt.tg.pr.3.2
                    @Override // com.byazt.mq.fw
                    public void pr(View view2, g gVar) {
                        pr.this.pr(view2, viewGroup, view, gVar);
                    }

                    @Override // com.byazt.mq.fw
                    public void pr(int i2, String str) {
                        if (pr.this.hw != null) {
                            pr.this.hw.pr(viewGroup);
                        }
                        com.byazt.qd.uc.hw(com.byazt.ewt.fw.pr(pr.this.pr), 2);
                        com.byazt.uq.hn.pr(pr.this.pr, (m) pr.this.x, false, i2, str);
                        pr.this.pr(viewGroup);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject pr(int i, JSONObject jSONObject, View view) {
        if (i == 3) {
            return com.byazt.hc.hw.pr(this.pr, com.byazt.hc.hw.pr(view), jSONObject, w(), null, false);
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.gu.hw pr(View view, JSONObject jSONObject) {
        com.byazt.gu.hw.pr prVar = new com.byazt.gu.hw.pr();
        prVar.c(w.pr(this.pr, view, w()));
        prVar.pr(jSONObject);
        prVar.pr((ny) new com.byazt.qx.a());
        prVar.hw(view.getHeight());
        prVar.pr(view.getWidth());
        prVar.pr(com.byazt.sd.zo.nt().x());
        prVar.vk(this.pr.nl());
        prVar.w(x());
        int iK = ls.k(this.pr);
        if (iK == 3 || iK == 4) {
            prVar.uc(com.byazt.zp.w.c());
        }
        return prVar.pr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.byazt.gu.c pr(int i, com.byazt.gu.hw hwVar, ViewGroup viewGroup) {
        if (i == 3) {
            return new com.byazt.gu.fw(a.getContext(), this.pr, hwVar, viewGroup);
        }
        return new com.byazt.gu.c(a.getContext(), this.pr, hwVar, viewGroup);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vk() {
        this.fw.pr(this.vk);
        this.fw.pr(this.hw);
        this.fw.pr(this);
        this.fw.pr(new com.byazt.mq.zo() { // from class: com.byazt.tg.pr.4
            @Override // com.byazt.mq.zo
            public void pr(View view, int i, com.byazt.dj.hn hnVar, int i2) {
                com.byazt.qd.uc.x(com.byazt.ewt.fw.pr(pr.this.pr));
                if (pr.this.hw != null) {
                    pr.this.hw.pr(view, i, hnVar, pr.this.x);
                }
            }

            @Override // com.byazt.mq.zo
            public void hw(View view, int i, com.byazt.dj.hn hnVar, int i2) {
                com.byazt.qd.uc.x(com.byazt.ewt.fw.pr(pr.this.pr));
                if (pr.this.hw != null) {
                    pr.this.hw.pr(view, i, hnVar, pr.this.x);
                }
            }
        });
        this.fw.pr(new com.byazt.uq.zo() { // from class: com.byazt.tg.pr.5
            @Override // com.byazt.uq.zo
            public void pr() {
                com.byazt.qd.uc.x(com.byazt.ewt.fw.pr(pr.this.pr), 1);
                pr.this.zo();
            }
        });
    }

    @Override // com.byazt.fy.hw
    public boolean pr(String str, com.byazt.ik.hn hnVar, com.byazt.fy.hn hnVar2) {
        switch (str) {
            case "closeWidget":
                zo();
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:11:0x001d  */
    @Override // com.byazt.fy.hw
    public void pr(String str) {
        switch (str) {
            case "clickEvent":
            case "convert":
                com.byazt.uq.hn.pr(this.pr, (m) this.x, false, (JSONObject) null, false);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(View view, ViewGroup viewGroup, View view2, g gVar) {
        if (view == null) {
            pr(viewGroup);
            com.byazt.qd.uc.hw(com.byazt.ewt.fw.pr(this.pr), 2);
            com.byazt.uq.hn.pr(this.pr, (m) this.x, false, 101, "renderView is null");
            return;
        }
        com.byazt.qd.uc.hw(com.byazt.ewt.fw.pr(this.pr), 1);
        com.byazt.uq.hn.hw(this.pr, this.x, true);
        this.c = view;
        view.setVisibility(8);
        if (!pr(view)) {
            pr(viewGroup);
            com.byazt.qd.uc.hn(com.byazt.ewt.fw.pr(this.pr), 2);
            com.byazt.uq.hn.hw(this.pr, this.x, false, 103, new JSONObject());
        } else {
            View view3 = this.c;
            com.byazt.gu.c cVar = this.fw;
            pr(viewGroup, view2, view3, cVar != null ? cVar.c() : null, gVar);
            aj();
        }
    }

    public void pr(ViewGroup viewGroup, View view, View view2, float[] fArr, g gVar) {
        pr(viewGroup, view, view2, fArr);
    }

    public void pr(ViewGroup viewGroup) {
    }

    private boolean pr(View view) {
        View childAt;
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() <= 0) {
            return false;
        }
        View childAt2 = viewGroup.getChildAt(0);
        if (!(this.fw instanceof com.byazt.gu.fw) || childAt2 == null) {
            return childAt2 != null && childAt2.getVisibility() == 0;
        }
        ViewGroup viewGroup2 = (ViewGroup) childAt2;
        return viewGroup2.getChildCount() > 0 && (childAt = viewGroup2.getChildAt(0)) != null && childAt.getVisibility() == 0;
    }

    public void c() {
        final View view = this.c;
        if (view == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            hw(view);
        } else {
            view.post(new Runnable() { // from class: com.byazt.tg.pr.6
                @Override // java.lang.Runnable
                public void run() {
                    pr.this.hw(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void hw(View view) {
        if (view == null) {
            return;
        }
        view.setVisibility(4);
        if (view instanceof ViewGroup) {
            ((ViewGroup) view).removeAllViews();
        }
        ViewParent parent = view.getParent();
        if (!(parent instanceof EasyPlayableContainer)) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        } else {
            ViewParent parent2 = parent.getParent();
            ((ViewGroup) parent).removeView(view);
            if (parent2 instanceof ViewGroup) {
                ((ViewGroup) parent2).removeView((View) parent);
            }
        }
    }

    public void uc() {
        zo();
        this.c = null;
        fw();
    }

    public void fw() {
        com.byazt.gu.c cVar = this.fw;
        if (cVar != null) {
            cVar.pr((com.byazt.uq.fw) null);
            this.fw.pr((com.byazt.mq.zo) null);
            this.fw.pr((com.byazt.uq.zo) null);
            this.fw.pr(true);
            this.fw = null;
        }
    }

    @Override // com.byazt.uq.hw
    public m hw() {
        return this.x;
    }

    @Override // com.byazt.uq.hw
    public com.byazt.uq.fw pr() {
        return this.vk;
    }

    public void zo() {
        c();
        com.byazt.qd.uc.x(com.byazt.ewt.fw.pr(this.pr), 1);
        if (this.hn != null) {
            this.hn.hn();
        }
    }

    public void aj() {
        View view = this.c;
        if (view != null && this.uc) {
            view.setVisibility(0);
        }
    }

    private boolean w() {
        return ie.pr(this.pr) == 1;
    }

    public void pr(com.byazt.qe.hw hwVar) {
        this.zo = hwVar;
    }

    public void pr(Context context) {
        this.aj = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(int i) {
        new com.byazt.tt.pr(this.pr, this.aj).pr(i, this.zo);
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.qd.uc.x(com.byazt.ewt.fw.pr(this.pr), 2);
    }
}
