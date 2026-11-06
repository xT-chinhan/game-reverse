package com.byazt.ro;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.az.hw;
import com.byazt.ch.ho;
import com.byazt.ch.nt;
import com.byazt.dd.fw;
import com.byazt.hg.lb;
import com.byazt.hg.of;
import com.byazt.ik.hn;
import com.byazt.sa.c;
import com.byazt.wt.er;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.taptap.sdk.compliance.constants.BundleKey;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 38, 1590})
public class UgenBanner extends FrameLayout {
    public WeakReference<ObjectAnimator> c;
    public boolean hn;
    public View hw;
    public ho pr;
    public int uc;
    public final AtomicBoolean x;

    public UgenBanner(Context context) {
        super(context);
        this.x = new AtomicBoolean(false);
    }

    public void pr(of ofVar, hw hwVar) {
        if (ofVar.ho() == null || TextUtils.isEmpty(ofVar.ho().hn())) {
            return;
        }
        pr(lb.g(ofVar), ofVar, hwVar, ofVar.ho().hn(), ofVar.A_(), TextUtils.isEmpty(ofVar.se()) ? "立即下载" : ofVar.se(), false);
    }

    public void setTopMargin(int i) {
        this.uc = i;
    }

    public void pr(com.byazt.qk.pr prVar, final of ofVar, final hw hwVar, final String str, final String str2, final String str3, final boolean z) {
        if (prVar == null || this.x.getAndSet(true) || ofVar.mo() == null || TextUtils.isEmpty(ofVar.mo().pr())) {
            return;
        }
        c.pr(prVar, new c.pr() { // from class: com.byazt.ro.UgenBanner.1
            @Override // com.byazt.sa.c.pr
            public void pr(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("icon", ofVar.mo().pr());
                    jSONObject2.put(NativeUnifiedADAppInfoImpl.Keys.APP_NAME, str);
                    jSONObject2.put(BundleKey.TITLE, str2);
                    jSONObject2.put("button_text", str3);
                } catch (JSONException e) {
                }
                UgenBanner ugenBanner = UgenBanner.this;
                ugenBanner.hw = ugenBanner.pr(jSONObject, jSONObject2, new com.byazt.ch.lb() { // from class: com.byazt.ro.UgenBanner.1.1
                    @Override // com.byazt.ch.lb
                    public void pr(nt ntVar, com.byazt.ch.lb.hw hwVar2, com.byazt.ch.lb.pr prVar2) {
                        if (ntVar.hn() != null && "banner_click".equals(ntVar.hn().optString("type"))) {
                            UgenBanner.this.hw.setTag(2114387594, Boolean.TRUE);
                            hwVar.pr(UgenBanner.this.hw, null);
                            if (z) {
                                UgenBanner.this.pr();
                            }
                        }
                    }

                    @Override // com.byazt.ch.lb
                    public void pr(hn hnVar, String str4, fw.pr prVar2) {
                    }
                });
            }
        });
        postDelayed(new Runnable() { // from class: com.byazt.ro.UgenBanner.2
            @Override // java.lang.Runnable
            public void run() {
                UgenBanner.this.hw();
            }
        }, 3000L);
    }

    public void pr() {
        ObjectAnimator objectAnimator;
        this.hn = true;
        View view = this.hw;
        if (view != null) {
            view.setVisibility(8);
        }
        WeakReference<ObjectAnimator> weakReference = this.c;
        if (weakReference != null && (objectAnimator = weakReference.get()) != null) {
            objectAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View pr(JSONObject jSONObject, JSONObject jSONObject2, com.byazt.ch.lb lbVar) {
        ho hoVar = new ho(getContext());
        this.pr = hoVar;
        hn<View> hnVarPr = hoVar.pr(jSONObject);
        this.pr.pr(lbVar);
        this.pr.hw(jSONObject2);
        if (hnVarPr == null) {
            return null;
        }
        View viewAj = hnVarPr.aj();
        if (viewAj != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(hnVarPr.e(), hnVarPr.s());
            layoutParams.leftMargin = er.hn(getContext(), 16.0f);
            layoutParams.rightMargin = er.hn(getContext(), 16.0f);
            viewAj.setLayoutParams(layoutParams);
        }
        return viewAj;
    }

    public void hw() {
        View view = this.hw;
        if (view == null || this.hn) {
            return;
        }
        FrameLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParamsGenerateDefaultLayoutParams == null) {
            layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        }
        layoutParamsGenerateDefaultLayoutParams.topMargin = this.uc;
        addView(this.hw, layoutParamsGenerateDefaultLayoutParams);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.hw, "translationY", -400.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.start();
        this.c = new WeakReference<>(objectAnimatorOfFloat);
    }
}
