package com.byazt.yhm;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.gx.DynamicBaseWidget;
import com.byazt.jt.WriggleGuideAnimationView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1226, 101})
public class qa implements fw<WriggleGuideAnimationView> {
    public com.byazt.rk.fw c;
    public com.byazt.rk.vk fw;
    public Context hn;
    public WriggleGuideAnimationView hw;
    public int pr;
    public String uc;
    public DynamicBaseWidget x;
    public boolean zo;

    public qa(Context context, DynamicBaseWidget dynamicBaseWidget, com.byazt.rk.fw fwVar, String str, com.byazt.rk.vk vkVar, boolean z, int i) {
        this.zo = true;
        this.hn = context;
        this.x = dynamicBaseWidget;
        this.c = fwVar;
        this.uc = str;
        this.fw = vkVar;
        this.zo = z;
        this.pr = i;
        c();
    }

    private void c() {
        int iR = this.c.r();
        final com.byazt.mft.pr dynamicClickListener = this.x.getDynamicClickListener();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("convertActionType", 2);
            dynamicClickListener.pr(jSONObject);
        } catch (Throwable th) {
        }
        if ("18".equals(this.uc)) {
            Context context = this.hn;
            WriggleGuideAnimationView wriggleGuideAnimationView = new WriggleGuideAnimationView(context, com.byazt.uz.hw.aj(context), this.fw, this.zo, this.pr);
            this.hw = wriggleGuideAnimationView;
            if (wriggleGuideAnimationView.getWriggleLayout() != null) {
                this.hw.getWriggleLayout().setOnClickListener((View.OnClickListener) dynamicClickListener);
            }
            if (this.hw.getTopTextView() != null) {
                if (TextUtils.isEmpty(this.c.d())) {
                    this.hw.getTopTextView().setText("扭动手机 或 点击图标");
                } else {
                    this.hw.getTopTextView().setText(this.c.d());
                }
            }
        } else {
            Context context2 = this.hn;
            this.hw = new WriggleGuideAnimationView(context2, com.byazt.uz.hw.aj(context2), this.fw, this.zo, this.pr);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 81;
        this.hw.setTranslationY(-((int) com.byazt.js.zo.pr(this.hn, iR)));
        this.hw.setLayoutParams(layoutParams);
        this.hw.setShakeText(this.c.o());
        this.hw.setClipChildren(false);
        final View wriggleProgressIv = this.hw.getWriggleProgressIv();
        this.hw.setOnShakeViewListener(new WriggleGuideAnimationView.pr() { // from class: com.byazt.yhm.qa.1
            @Override // com.byazt.jt.WriggleGuideAnimationView.pr
            public void pr() {
                if (wriggleProgressIv != null) {
                    if (qa.this.hw != null) {
                        qa.this.hw.setOnClickListener((View.OnClickListener) dynamicClickListener);
                        qa.this.hw.performClick();
                    }
                    if (qa.this.c != null && qa.this.c.jn()) {
                        qa.this.hw.setOnClickListener(null);
                    }
                }
            }
        });
    }

    @Override // com.byazt.yhm.fw
    public void pr() {
        this.hw.pr();
    }

    @Override // com.byazt.yhm.fw
    public void hw() {
        this.hw.clearAnimation();
    }

    @Override // com.byazt.yhm.fw
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public WriggleGuideAnimationView hn() {
        return this.hw;
    }
}
