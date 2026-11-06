package com.byazt.zc;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.gct.cd;
import com.byazt.gct.pk;
import com.byazt.ih.s;
import com.byazt.ozc.l;
import com.byazt.vh.cy;
import com.byazt.vh.k;
import com.byazt.xz.x;
import com.byazt.ys.qg;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 30, 1725})
public class UgenBanner extends FrameLayout {
    public WeakReference<ObjectAnimator> l;
    public k n;
    public final AtomicBoolean q;
    public View qg;
    public boolean s;
    public int w;

    public UgenBanner(Context context) {
        super(context);
        this.q = new AtomicBoolean(false);
    }

    public void n(pk pkVar, qg qgVar) {
        if (pkVar.k() == null || TextUtils.isEmpty(pkVar.k().s())) {
            return;
        }
        n(cd.sz(pkVar), pkVar, qgVar, pkVar.k().s(), pkVar.E_(), TextUtils.isEmpty(pkVar.jb()) ? "立即下载" : pkVar.jb(), false);
    }

    public void setTopMargin(int i) {
        this.w = i;
    }

    public void n(com.byazt.ai.n nVar, final pk pkVar, final qg qgVar, final String str, final String str2, final String str3, final boolean z) {
        if (nVar == null || this.q.getAndSet(true) || pkVar.xu() == null || TextUtils.isEmpty(pkVar.xu().n())) {
            return;
        }
        l.n(nVar, new l.n() { // from class: com.byazt.zc.UgenBanner.1
            @Override // com.byazt.ozc.l.n
            public void n(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("icon", pkVar.xu().n());
                    jSONObject2.put("app_name", str);
                    jSONObject2.put("title", str2);
                    jSONObject2.put("button_text", str3);
                } catch (JSONException unused) {
                }
                UgenBanner ugenBanner = UgenBanner.this;
                ugenBanner.qg = ugenBanner.n(jSONObject, jSONObject2, new com.byazt.vh.cd() { // from class: com.byazt.zc.UgenBanner.1.1
                    @Override // com.byazt.vh.cd
                    public void n(s sVar, String str4, x.n nVar2) {
                    }

                    @Override // com.byazt.vh.cd
                    public void n(cy cyVar, com.byazt.vh.cd.qg qgVar2, com.byazt.vh.cd.n nVar2) {
                        if (cyVar.s() != null && "banner_click".equals(cyVar.s().optString("type"))) {
                            UgenBanner.this.qg.setTag(2114387594, Boolean.TRUE);
                            qgVar.n(UgenBanner.this.qg, null);
                            if (z) {
                                UgenBanner.this.n();
                            }
                        }
                    }
                });
            }
        });
        postDelayed(new Runnable() { // from class: com.byazt.zc.UgenBanner.2
            @Override // java.lang.Runnable
            public void run() {
                UgenBanner.this.qg();
            }
        }, 3000L);
    }

    public void n() {
        ObjectAnimator objectAnimator;
        this.s = true;
        View view = this.qg;
        if (view != null) {
            view.setVisibility(8);
        }
        WeakReference<ObjectAnimator> weakReference = this.l;
        if (weakReference == null || (objectAnimator = weakReference.get()) == null) {
            return;
        }
        objectAnimator.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View n(JSONObject jSONObject, JSONObject jSONObject2, com.byazt.vh.cd cdVar) {
        k kVar = new k(getContext());
        this.n = kVar;
        s<View> sVarN = kVar.n(jSONObject);
        this.n.n(cdVar);
        this.n.qg(jSONObject2);
        if (sVarN == null) {
            return null;
        }
        View viewRv = sVarN.rv();
        if (viewRv != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(sVarN.an(), sVarN.ae());
            layoutParams.leftMargin = com.byazt.okk.s.s(getContext(), 16.0f);
            layoutParams.rightMargin = com.byazt.okk.s.s(getContext(), 16.0f);
            viewRv.setLayoutParams(layoutParams);
        }
        return viewRv;
    }

    public void qg() {
        View view = this.qg;
        if (view == null || this.s) {
            return;
        }
        FrameLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (layoutParamsGenerateDefaultLayoutParams == null) {
            layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        }
        layoutParamsGenerateDefaultLayoutParams.topMargin = this.w;
        addView(this.qg, layoutParamsGenerateDefaultLayoutParams);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.qg, "translationY", -400.0f, 0.0f);
        objectAnimatorOfFloat.setDuration(600L);
        objectAnimatorOfFloat.start();
        this.l = new WeakReference<>(objectAnimatorOfFloat);
    }
}
