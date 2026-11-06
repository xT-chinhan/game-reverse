package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.ah.x;
import com.bytedance.sdk.component.adexpress.dynamic.interact.ub;
import com.bytedance.sdk.component.adexpress.widget.ImageFlipSlideGroup;
import com.bytedance.sdk.component.adexpress.xr.hi;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DynamicImageFlipSlide extends DynamicImageView {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final ImageFlipSlideGroup f816ms;
    private final xr xr;

    public interface ms {
        void ms();
    }

    private interface xr {
        void ms(ms msVar);
    }

    public DynamicImageFlipSlide(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.xr = new xr() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.1
            @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.xr
            public void ms(ms msVar) {
                if (DynamicImageFlipSlide.this.f816ms != null) {
                    DynamicImageFlipSlide.this.f816ms.ms(msVar);
                }
            }
        };
        ImageFlipSlideGroup imageFlipSlideGroup = new ImageFlipSlideGroup(getContext(), TextUtils.equals(getDynamicLayoutBrickValue().jr(), "slide"));
        this.f816ms = imageFlipSlideGroup;
        addView(imageFlipSlideGroup, getWidgetLayoutParams());
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f816ms.ms();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f816ms.xr();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidgetImp, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.d
    public boolean x() {
        super.x();
        this.f816ms.ms(this.sl.hi(), xr(this.sl.hi()));
        this.f816ms.xr(this.sl.j(), xr(this.sl.j()));
        this.f816ms.setFilterColors(this.sl.ih());
        this.f816ms.ah();
        return true;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget
    public com.bytedance.sdk.component.adexpress.dynamic.ka.ms getDynamicClickListener() {
        com.bytedance.sdk.component.adexpress.dynamic.ka.ms dynamicClickListener = this.u.getDynamicClickListener();
        return this.sl.oh() ? new ah(dynamicClickListener, this.xr) : dynamicClickListener;
    }

    private static class ah implements View.OnClickListener, View.OnTouchListener, com.bytedance.sdk.component.adexpress.dynamic.ka.ms {

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        com.bytedance.sdk.component.adexpress.dynamic.ka.ms f818ms;
        xr xr;

        public ah(com.bytedance.sdk.component.adexpress.dynamic.ka.ms msVar, xr xrVar) {
            this.f818ms = msVar;
            this.xr = xrVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(final View view) {
            xr xrVar = this.xr;
            if (xrVar != null) {
                xrVar.ms(new ms() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.ah.1
                    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageFlipSlide.ms
                    public void ms() {
                        if (ah.this.f818ms instanceof View.OnClickListener) {
                            ((View.OnClickListener) ah.this.f818ms).onClick(view);
                        }
                    }
                });
                return;
            }
            com.bytedance.sdk.component.adexpress.dynamic.ka.ms msVar = this.f818ms;
            if (msVar instanceof View.OnClickListener) {
                ((View.OnClickListener) msVar).onClick(view);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            com.bytedance.sdk.component.adexpress.dynamic.ka.ms msVar = this.f818ms;
            if (msVar instanceof View.OnTouchListener) {
                return ((View.OnTouchListener) msVar).onTouch(view, motionEvent);
            }
            return false;
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.ka.ms
        public void ms(View view) {
            com.bytedance.sdk.component.adexpress.dynamic.ka.ms msVar = this.f818ms;
            if (msVar != null) {
                msVar.ms(view);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.ka.ms
        public void xr(View view) {
            com.bytedance.sdk.component.adexpress.dynamic.ka.ms msVar = this.f818ms;
            if (msVar != null) {
                msVar.xr(view);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.ka.ms
        public void ms(hi hiVar) {
            com.bytedance.sdk.component.adexpress.dynamic.ka.ms msVar = this.f818ms;
            if (msVar != null) {
                msVar.ms(hiVar);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.ka.ms
        public void ms(boolean z, ub ubVar) {
            com.bytedance.sdk.component.adexpress.dynamic.ka.ms msVar = this.f818ms;
            if (msVar != null) {
                msVar.ms(z, ubVar);
            }
        }

        @Override // com.bytedance.sdk.component.adexpress.dynamic.ka.ms
        public void ms(JSONObject jSONObject) {
            com.bytedance.sdk.component.adexpress.dynamic.ka.ms msVar = this.f818ms;
            if (msVar != null) {
                msVar.ms(jSONObject);
            }
        }
    }
}
