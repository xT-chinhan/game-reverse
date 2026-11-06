package com.bytedance.sdk.openadsdk.core.component.reward.view.ugen;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.adsdk.ugeno.ah.sl;
import com.bytedance.adsdk.ugeno.ah.ub;
import com.bytedance.adsdk.ugeno.ah.zb;
import com.bytedance.adsdk.ugeno.ka.c;
import com.bytedance.adsdk.ugeno.xr.ah;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.t;
import com.bytedance.sdk.openadsdk.core.ugeno.ab.ka;
import com.bytedance.sdk.openadsdk.core.ugeno.c.ms;
import com.bytedance.sdk.openadsdk.core.xr.xr;
import com.tapsdk.tapad.e.a;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class UgenBanner extends FrameLayout {
    private boolean ah;
    private int c;
    private final AtomicBoolean d;
    private WeakReference<ObjectAnimator> ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private sl f2285ms;
    private View xr;

    public UgenBanner(Context context) {
        super(context);
        this.d = new AtomicBoolean(false);
    }

    public void ms(lm lmVar, xr xrVar) {
        if (lmVar.zh() == null || TextUtils.isEmpty(lmVar.zh().ah())) {
            return;
        }
        ms(t.sl(lmVar), lmVar, xrVar, lmVar.zh().ah(), lmVar.eh(), TextUtils.isEmpty(lmVar.bn()) ? "立即下载" : lmVar.bn(), false);
    }

    public void setTopMargin(int i) {
        this.c = i;
    }

    public void ms(ms msVar, final lm lmVar, final xr xrVar, final String str, final String str2, final String str3, final boolean z) {
        if (msVar == null || this.d.getAndSet(true) || lmVar.qd() == null || TextUtils.isEmpty(lmVar.qd().ms())) {
            return;
        }
        ka.ms(msVar, new ka.ms() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.ab.ka.ms
            public void ms(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("icon", lmVar.qd().ms());
                    jSONObject2.put("app_name", str);
                    jSONObject2.put("title", str2);
                    jSONObject2.put("button_text", str3);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
                UgenBanner ugenBanner = UgenBanner.this;
                ugenBanner.xr = ugenBanner.ms(jSONObject, jSONObject2, new ub() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.1.1
                    @Override // com.bytedance.adsdk.ugeno.ah.ub
                    public void ms(ah ahVar, String str4, c.ms msVar2) {
                    }

                    @Override // com.bytedance.adsdk.ugeno.ah.ub
                    public void ms(zb zbVar, ub.xr xrVar2, ub.ms msVar2) {
                        if (zbVar.ah() != null && "banner_click".equals(zbVar.ah().optString("type"))) {
                            UgenBanner.this.xr.setTag(2114387600, Boolean.TRUE);
                            xrVar.ms(UgenBanner.this.xr, null);
                            if (z) {
                                UgenBanner.this.ms();
                            }
                        }
                    }
                });
            }
        });
        postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.UgenBanner.2
            @Override // java.lang.Runnable
            public void run() {
                UgenBanner.this.xr();
            }
        }, a.f);
    }

    public void ms() {
        ObjectAnimator objectAnimator;
        this.ah = true;
        View view = this.xr;
        if (view != null) {
            view.setVisibility(8);
        }
        WeakReference<ObjectAnimator> weakReference = this.ka;
        if (weakReference == null || (objectAnimator = weakReference.get()) == null) {
            return;
        }
        objectAnimator.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View ms(JSONObject jSONObject, JSONObject jSONObject2, ub ubVar) {
        sl slVar = new sl(getContext());
        this.f2285ms = slVar;
        ah<View> ahVarMs = slVar.ms(jSONObject);
        this.f2285ms.ms(ubVar);
        this.f2285ms.xr(jSONObject2);
        if (ahVarMs == null) {
            return null;
        }
        View viewNy = ahVarMs.ny();
        if (viewNy != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ahVarMs.pc(), ahVarMs.jw());
            layoutParams.leftMargin = ul.ah(getContext(), 16.0f);
            layoutParams.rightMargin = ul.ah(getContext(), 16.0f);
            viewNy.setLayoutParams(layoutParams);
        }
        return viewNy;
    }

    public void xr() {
        View view = this.xr;
        if (view == null || this.ah) {
            return;
        }
        FrameLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParamsGenerateDefaultLayoutParams == null) {
            layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        }
        layoutParamsGenerateDefaultLayoutParams.topMargin = this.c;
        addView(this.xr, layoutParamsGenerateDefaultLayoutParams);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.xr, "translationY", -400.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.start();
        this.ka = new WeakReference<>(objectAnimatorOfFloat);
    }
}
