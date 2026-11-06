package com.byazt.gx;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.byazt.jt.ImageFlipSlideGroup;
import com.byazt.mq.w;
import com.byazt.rk.zo;
import com.byazt.yhm.ho;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 63, 1559})
public class DynamicImageFlipSlide extends DynamicImageView {
    public final hw hw;
    public final ImageFlipSlideGroup pr;

    private interface hw {
        void pr(pr prVar);
    }

    public interface pr {
        void pr();
    }

    public DynamicImageFlipSlide(Context context, DynamicRootView dynamicRootView, zo zoVar) {
        super(context, dynamicRootView, zoVar);
        this.hw = new hw() { // from class: com.byazt.gx.DynamicImageFlipSlide.1
            @Override // com.byazt.gx.DynamicImageFlipSlide.hw
            public void pr(pr prVar) {
                if (DynamicImageFlipSlide.this.pr != null) {
                    DynamicImageFlipSlide.this.pr.pr(prVar);
                }
            }
        };
        ImageFlipSlideGroup imageFlipSlideGroup = new ImageFlipSlideGroup(getContext(), TextUtils.equals(getDynamicLayoutBrickValue().wo(), "slide"));
        this.pr = imageFlipSlideGroup;
        addView(imageFlipSlideGroup, getWidgetLayoutParams());
    }

    @Override // com.byazt.gx.DynamicImageView, com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.pr.pr();
    }

    @Override // com.byazt.gx.DynamicImageView, com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.pr.hw();
    }

    @Override // com.byazt.gx.DynamicImageView, com.byazt.gx.DynamicBaseWidgetImp, com.byazt.gx.x
    public boolean zo() {
        super.zo();
        this.pr.pr(this.k.w(), hw(this.k.w()));
        this.pr.hw(this.k.qo(), hw(this.k.qo()));
        this.pr.setFilterColors(this.k.bh());
        this.pr.hn();
        return true;
    }

    @Override // com.byazt.gx.DynamicBaseWidget
    public com.byazt.mft.pr getDynamicClickListener() {
        com.byazt.mft.pr dynamicClickListener = this.g.getDynamicClickListener();
        if (this.k.pj()) {
            return new hn(dynamicClickListener, this.hw);
        }
        return dynamicClickListener;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 63, 1923})
    private static class hn implements View.OnClickListener, View.OnTouchListener, com.byazt.mft.pr {
        public hw hw;
        public com.byazt.mft.pr pr;

        public hn(com.byazt.mft.pr prVar, hw hwVar) {
            this.pr = prVar;
            this.hw = hwVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            hw hwVar = this.hw;
            if (hwVar != null) {
                hwVar.pr(new pr() { // from class: com.byazt.gx.DynamicImageFlipSlide.hn.1
                    @Override // com.byazt.gx.DynamicImageFlipSlide.pr
                    public void pr() {
                        if (hn.this.pr instanceof View.OnClickListener) {
                            ((View.OnClickListener) hn.this.pr).onClick(view);
                        }
                    }
                });
                return;
            }
            com.byazt.mft.pr prVar = this.pr;
            if (prVar instanceof View.OnClickListener) {
                ((View.OnClickListener) prVar).onClick(view);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.byazt.mft.pr prVar = this.pr;
            if (prVar instanceof View.OnTouchListener) {
                return ((View.OnTouchListener) prVar).onTouch(view, motionEvent);
            }
            return false;
        }

        @Override // com.byazt.mft.pr
        public void pr(View view) {
            com.byazt.mft.pr prVar = this.pr;
            if (prVar != null) {
                prVar.pr(view);
            }
        }

        @Override // com.byazt.mft.pr
        public void hw(View view) {
            com.byazt.mft.pr prVar = this.pr;
            if (prVar != null) {
                prVar.hw(view);
            }
        }

        @Override // com.byazt.mft.pr
        public void pr(w wVar) {
            com.byazt.mft.pr prVar = this.pr;
            if (prVar != null) {
                prVar.pr(wVar);
            }
        }

        @Override // com.byazt.mft.pr
        public void pr(boolean z, ho hoVar) {
            com.byazt.mft.pr prVar = this.pr;
            if (prVar != null) {
                prVar.pr(z, hoVar);
            }
        }

        @Override // com.byazt.mft.pr
        public void pr(JSONObject jSONObject) {
            com.byazt.mft.pr prVar = this.pr;
            if (prVar != null) {
                prVar.pr(jSONObject);
            }
        }
    }
}
