package com.byazt.ee;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.pp.w;
import com.byazt.rt.s;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 84, 1310})
public class CSJSpriteView extends FrameLayout {
    public final n n;
    public final float q;
    public CSJGameGuideTipView qg;
    public CSJGameRunnerView s;

    public interface qg {
        void n(int i, int i2);
    }

    public CSJSpriteView(Context context) {
        super(context);
        this.q = context.getResources().getDisplayMetrics().density;
        n nVar = new n(context);
        this.n = nVar;
        addView(nVar, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setSceneFactory(qg qgVar) {
        this.n.q = qgVar;
    }

    public void n(com.byazt.eu.n nVar) {
        this.n.n = nVar;
    }

    public void n() {
        this.n.n();
    }

    public void qg() {
        this.n.qg();
    }

    public void n(w wVar, JSONObject jSONObject, double d, double d2, double d3, double d4) {
        if (wVar == null) {
            return;
        }
        if (this.qg == null) {
            CSJGameGuideTipView cSJGameGuideTipView = new CSJGameGuideTipView(getContext());
            this.qg = cSJGameGuideTipView;
            addView(cSJGameGuideTipView);
        }
        this.qg.n(wVar, jSONObject, d, d2, d3, d4);
    }

    public void s() {
        CSJGameGuideTipView cSJGameGuideTipView = this.qg;
        if (cSJGameGuideTipView != null) {
            cSJGameGuideTipView.fs();
        }
    }

    public void n(Bitmap bitmap, double d, double d2, double d3, double d4) {
        l();
        this.s.n(bitmap, d, d2, d3, d4);
    }

    public void qg(w wVar, JSONObject jSONObject, double d, double d2, double d3, double d4) {
        l();
        this.s.n(wVar, jSONObject, d, d2, d3, d4);
    }

    public void n(double d, double d2, double d3) {
        CSJGameRunnerView cSJGameRunnerView = this.s;
        if (cSJGameRunnerView != null) {
            cSJGameRunnerView.n(d, d2, d3);
        }
    }

    public void q() {
        CSJGameRunnerView cSJGameRunnerView = this.s;
        if (cSJGameRunnerView != null) {
            cSJGameRunnerView.n();
        }
    }

    private void l() {
        if (this.s == null) {
            CSJGameRunnerView cSJGameRunnerView = new CSJGameRunnerView(getContext());
            this.s = cSJGameRunnerView;
            addView(cSJGameRunnerView);
        }
    }

    @com.byazt.cp.n(n = {0, 1, 84, 2235})
    private class n extends View {
        public boolean l;
        public com.byazt.eu.n n;
        public qg q;
        public s qg;
        public com.byazt.rt.qg s;

        public n(Context context) {
            super(context);
            this.l = false;
            this.qg = new com.byazt.rt.n(CSJSpriteView.this.q);
            this.s = new com.byazt.rt.qg(new com.byazt.rt.qg.n() { // from class: com.byazt.ee.CSJSpriteView.n.1
                @Override // com.byazt.rt.qg.n
                public void n(double d) {
                    if (n.this.n != null) {
                        n.this.n.update(d);
                        n.this.invalidate();
                    }
                }
            });
        }

        public void n() {
            com.byazt.rt.qg qgVar = this.s;
            if (qgVar != null) {
                qgVar.n();
            }
        }

        public void qg() {
            com.byazt.rt.qg qgVar = this.s;
            if (qgVar != null) {
                qgVar.qg();
            }
        }

        @Override // android.view.View
        public void onSizeChanged(int i, int i2, int i3, int i4) {
            qg qgVar;
            super.onSizeChanged(i, i2, i3, i4);
            if (this.l || i <= 0 || i2 <= 0 || (qgVar = this.q) == null) {
                return;
            }
            this.l = true;
            qgVar.n(i, i2);
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            com.byazt.eu.n nVar = this.n;
            if (nVar == null || this.qg == null) {
                return;
            }
            this.qg.n(canvas, this.n.O_(), 0.0d, nVar.q().x.isEmpty() ? 0.0d : this.n.q().x.get(0).qg);
            Object obj = this.n;
            if (obj instanceof com.byazt.eu.n.s) {
                com.byazt.eu.n.s sVar = (com.byazt.eu.n.s) obj;
                List<? extends com.byazt.eu.n.qg> listN = sVar.n();
                double dQg = sVar.qg();
                double dP_ = this.n.P_();
                for (int i = 0; i < listN.size(); i++) {
                    com.byazt.eu.n.qg qgVar = listN.get(i);
                    this.qg.n(canvas, qgVar.n(), qgVar.qg(), qgVar.s(), 1.0d - ((dP_ - qgVar.q()) / dQg), qgVar.l(), 36.0f);
                }
            }
        }

        @Override // android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (this.n != null && motionEvent.getAction() == 0) {
                this.n.n(new com.byazt.xx.n(0, motionEvent.getX() / CSJSpriteView.this.q, motionEvent.getY() / CSJSpriteView.this.q));
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
    }
}
