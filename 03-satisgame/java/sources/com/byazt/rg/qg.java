package com.byazt.rg;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.byazt.gct.cy;
import com.byazt.gct.g;
import com.byazt.gct.oa;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO, 26})
public abstract class qg {
    public pk n;
    public EasyPlayableContainer q;
    public n qg;
    public com.byazt.whi.n s;

    public abstract l n();

    public abstract oa qg();

    public void s() {
    }

    public qg(pk pkVar, n nVar) {
        this.n = pkVar;
        this.qg = nVar;
    }

    public void n(com.byazt.dc.qg qgVar, int i) {
        com.byazt.whi.n nVar = this.s;
        if (nVar != null) {
            nVar.n(qgVar, i);
        }
    }

    public void n(final ViewGroup viewGroup, final View view, final View view2, final float[] fArr) {
        final HashMap map = new HashMap();
        final oa oaVarQg = qg();
        if (viewGroup == null || view == null) {
            com.byazt.de.w.s(com.byazt.de.x.n(this.n), 2);
            s.qg(this.n, oaVarQg, false, 101, null);
        } else if (view2 == null) {
            com.byazt.de.w.s(com.byazt.de.x.n(this.n), 2);
            s.qg(this.n, oaVarQg, false, 102, null);
        } else {
            view.post(new Runnable() { // from class: com.byazt.rg.qg.1
                @Override // java.lang.Runnable
                public void run() {
                    cy cyVar;
                    oa oaVar = oaVarQg;
                    if (oaVar == null) {
                        return;
                    }
                    if (oaVar.qg()) {
                        boolean[] zArr = {true};
                        cy cyVarN = q.n(zArr, fArr, qg.this.s, view.getWidth(), view.getHeight(), 0.8d);
                        if (!zArr[0]) {
                            com.byazt.de.w.s(com.byazt.de.x.n(qg.this.n), 2);
                            qg qgVar = qg.this;
                            qgVar.n(qgVar.s);
                            return;
                        }
                        cyVar = cyVarN;
                    } else {
                        cyVar = null;
                    }
                    if (view2.getParent() != null) {
                        ((ViewGroup) view2.getParent()).removeView(view2);
                    }
                    qg.this.q = new EasyPlayableContainer(com.byazt.nf.rv.getContext(), qg.this.n(), cyVar, qg.this.n, oaVarQg);
                    oa oaVar2 = oaVarQg;
                    if (oaVar2 instanceof g) {
                        qg.this.q.setIfStayTop(((g) oaVar2).rv());
                    }
                    int iN = oaVarQg.n();
                    if (iN == 1 || iN == 2) {
                        qg.this.q.setTag("easy_play_tag");
                    } else if (iN == 3) {
                        qg.this.q.setTag("overlay_tag");
                    } else if (iN == 4) {
                        qg.this.q.setTag("effects_tag");
                    } else if (iN == 5) {
                        qg.this.q.setTag("fullscreen_tag");
                    }
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(view.getWidth(), view.getHeight());
                    layoutParams.gravity = 17;
                    qg.this.q.addView(view2, layoutParams);
                    map.put("container_name", viewGroup.getClass().getName());
                    map.put("enable_layout_restrict", Boolean.valueOf(com.byazt.nf.rv.qg().ed()));
                    qg qgVar2 = qg.this;
                    if (qgVar2.n(viewGroup, view, qgVar2.q)) {
                        EasyPlayableContainer.n(viewGroup);
                        if (oaVarQg.n() == 1) {
                            qg qgVar3 = qg.this;
                            qgVar3.n(qgVar3.s, cyVar);
                        }
                        com.byazt.de.w.s(com.byazt.de.x.n(qg.this.n), 1);
                        s.n(qg.this.n, oaVarQg, new JSONObject(map), qg.this.q(), view);
                        qg.this.s();
                        return;
                    }
                    com.byazt.de.w.s(com.byazt.de.x.n(qg.this.n), 2);
                    if (qg.this.s != null) {
                        qg.this.s.qg(null);
                    }
                    s.qg(qg.this.n, oaVarQg, false, 202, new JSONObject(map));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(ViewGroup viewGroup, View view, View view2) {
        if (!q.n(viewGroup) && viewGroup != null && view != null && view2 != null) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            view.getLocationInWindow(iArr);
            viewGroup.getLocationInWindow(iArr2);
            int i = iArr[0] - iArr2[0];
            int i2 = iArr[1] - iArr2[1];
            int width = view.getWidth();
            int height = view.getHeight();
            if (width > 0 && height > 0) {
                if (viewGroup instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                    layoutParams.setMargins(i, i2, 0, 0);
                    viewGroup.addView(view2, layoutParams);
                } else if (viewGroup instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(width, height);
                    layoutParams2.setMargins(i, i2, 0, 0);
                    viewGroup.addView(view2, layoutParams2);
                } else {
                    q.n(viewGroup, view2, width, height, i, i2);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.whi.n nVar, cy cyVar) {
        if (nVar != null) {
            nVar.n(cy.n(cyVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.byazt.whi.n nVar) {
        if (nVar != null) {
            nVar.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int q() {
        com.byazt.whi.n nVar = this.s;
        if (nVar != null) {
            return nVar.n();
        }
        return -1;
    }
}
