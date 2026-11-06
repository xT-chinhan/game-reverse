package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView;
import com.bytedance.sdk.component.utils.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class y implements ab<WriggleGuideAnimationView> {
    private com.bytedance.sdk.component.adexpress.dynamic.ah.ch ab;
    private Context ah;
    private String c;
    private DynamicBaseWidget d;
    private com.bytedance.sdk.component.adexpress.dynamic.ah.ab ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public int f869ms;
    private boolean x;
    private WriggleGuideAnimationView xr;

    public y(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.ah.ab abVar, String str, com.bytedance.sdk.component.adexpress.dynamic.ah.ch chVar, boolean z, int i) {
        this.ah = context;
        this.d = dynamicBaseWidget;
        this.ka = abVar;
        this.c = str;
        this.ab = chVar;
        this.x = z;
        this.f869ms = i;
        ka();
    }

    private void ka() {
        int iXn = this.ka.xn();
        final com.bytedance.sdk.component.adexpress.dynamic.ka.ms dynamicClickListener = this.d.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 2);
            dynamicClickListener.ms(jSONObject);
        } catch (Throwable unused) {
        }
        if ("18".equals(this.c)) {
            Context context = this.ah;
            WriggleGuideAnimationView wriggleGuideAnimationView = new WriggleGuideAnimationView(context, com.bytedance.sdk.component.adexpress.ah.ms.ny(context), this.ab, this.x, this.f869ms);
            this.xr = wriggleGuideAnimationView;
            if (wriggleGuideAnimationView.getWriggleLayout() != null) {
                this.xr.getWriggleLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
            if (this.xr.getTopTextView() != null) {
                if (TextUtils.isEmpty(this.ka.sk())) {
                    this.xr.getTopTextView().setText(t.xr(this.ah, "tt_splash_wriggle_top_text_style_17"));
                } else {
                    this.xr.getTopTextView().setText(this.ka.sk());
                }
            }
        } else {
            Context context2 = this.ah;
            this.xr = new WriggleGuideAnimationView(context2, com.bytedance.sdk.component.adexpress.ah.ms.ny(context2), this.ab, this.x, this.f869ms);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.xr.setTranslationY(-((int) com.bytedance.sdk.component.adexpress.d.x.ms(this.ah, iXn)));
        this.xr.setLayoutParams(layoutParams);
        this.xr.setShakeText(this.ka.am());
        this.xr.setClipChildren(false);
        final View wriggleProgressIv = this.xr.getWriggleProgressIv();
        this.xr.setOnShakeViewListener(new WriggleGuideAnimationView.ms() { // from class: com.bytedance.sdk.component.adexpress.dynamic.interact.y.1
            @Override // com.bytedance.sdk.component.adexpress.widget.WriggleGuideAnimationView.ms
            public void ms() {
                if (wriggleProgressIv != null) {
                    if (y.this.xr != null) {
                        y.this.xr.setOnClickListener((View.OnClickListener) dynamicClickListener);
                        y.this.xr.performClick();
                    }
                    if (y.this.ka == null || !y.this.ka.ti()) {
                        return;
                    }
                    y.this.xr.setOnClickListener(null);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void ms() {
        this.xr.ms();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    public void xr() {
        this.xr.clearAnimation();
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.interact.ab
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public WriggleGuideAnimationView ah() {
        return this.xr;
    }
}
