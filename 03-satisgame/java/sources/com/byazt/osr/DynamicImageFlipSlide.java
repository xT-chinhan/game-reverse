package com.byazt.osr;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.jmk.k;
import com.byazt.lh.fs;
import com.byazt.stl.ImageFlipSlideGroup;
import com.byazt.udb.cp;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 38, 1698})
public class DynamicImageFlipSlide extends DynamicImageView {
    public final ImageFlipSlideGroup n;
    public final qg qg;

    public interface n {
        void n();
    }

    private interface qg {
        void n(n nVar);
    }

    public DynamicImageFlipSlide(Context context, DynamicRootView dynamicRootView, fs fsVar) {
        super(context, dynamicRootView, fsVar);
        this.qg = new qg() { // from class: com.byazt.osr.DynamicImageFlipSlide.1
            @Override // com.byazt.osr.DynamicImageFlipSlide.qg
            public void n(n nVar) {
                if (DynamicImageFlipSlide.this.n != null) {
                    DynamicImageFlipSlide.this.n.n(nVar);
                }
            }
        };
        ImageFlipSlideGroup imageFlipSlideGroup = new ImageFlipSlideGroup(getContext(), TextUtils.equals(getDynamicLayoutBrickValue().tr(), "slide"));
        this.n = imageFlipSlideGroup;
        addView(imageFlipSlideGroup, getWidgetLayoutParams());
    }

    @Override // com.byazt.osr.DynamicImageView, com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.n.n();
    }

    @Override // com.byazt.osr.DynamicImageView, com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.n.qg();
    }

    @Override // com.byazt.osr.DynamicImageView, com.byazt.osr.DynamicBaseWidgetImp, com.byazt.osr.q
    public boolean fs() {
        super.fs();
        this.n.n(this.d.cp(), qg(this.d.cp()));
        this.n.qg(this.d.dw(), qg(this.d.dw()));
        this.n.setFilterColors(this.d.su());
        this.n.s();
        return true;
    }

    @Override // com.byazt.osr.DynamicBaseWidget
    public com.byazt.xnr.n getDynamicClickListener() {
        com.byazt.xnr.n dynamicClickListener = this.sz.getDynamicClickListener();
        return this.d.ha() ? new s(dynamicClickListener, this.qg) : dynamicClickListener;
    }

    @com.byazt.cp.n(n = {0, 1, 38, 2251})
    private static class s implements View.OnClickListener, View.OnTouchListener, com.byazt.xnr.n {
        public com.byazt.xnr.n n;
        public qg qg;

        public s(com.byazt.xnr.n nVar, qg qgVar) {
            this.n = nVar;
            this.qg = qgVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            qg qgVar = this.qg;
            if (qgVar != null) {
                qgVar.n(new n() { // from class: com.byazt.osr.DynamicImageFlipSlide.s.1
                    @Override // com.byazt.osr.DynamicImageFlipSlide.n
                    public void n() {
                        if (s.this.n instanceof View.OnClickListener) {
                            ((View.OnClickListener) s.this.n).onClick(view);
                        }
                    }
                });
                return;
            }
            com.byazt.xnr.n nVar = this.n;
            if (nVar instanceof View.OnClickListener) {
                ((View.OnClickListener) nVar).onClick(view);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.byazt.xnr.n nVar = this.n;
            if (nVar instanceof View.OnTouchListener) {
                return ((View.OnTouchListener) nVar).onTouch(view, motionEvent);
            }
            return false;
        }

        @Override // com.byazt.xnr.n
        public void n(View view) {
            com.byazt.xnr.n nVar = this.n;
            if (nVar != null) {
                nVar.n(view);
            }
        }

        @Override // com.byazt.xnr.n
        public void qg(View view) {
            com.byazt.xnr.n nVar = this.n;
            if (nVar != null) {
                nVar.qg(view);
            }
        }

        @Override // com.byazt.xnr.n
        public void n(cp cpVar) {
            com.byazt.xnr.n nVar = this.n;
            if (nVar != null) {
                nVar.n(cpVar);
            }
        }

        @Override // com.byazt.xnr.n
        public void n(boolean z, k kVar) {
            com.byazt.xnr.n nVar = this.n;
            if (nVar != null) {
                nVar.n(z, kVar);
            }
        }

        @Override // com.byazt.xnr.n
        public void n(JSONObject jSONObject) {
            com.byazt.xnr.n nVar = this.n;
            if (nVar != null) {
                nVar.n(jSONObject);
            }
        }
    }
}
