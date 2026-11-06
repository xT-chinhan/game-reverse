package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.jw.f;
import com.bytedance.sdk.openadsdk.core.jw.ul;
import com.bytedance.sdk.openadsdk.core.nw.lm;
import com.bytedance.sdk.openadsdk.core.nw.sa;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private boolean ab = true;
    private List<com.bytedance.sdk.openadsdk.core.nw.ao> ah;
    private List<com.bytedance.adsdk.ugeno.xr.ah<View>> c;
    private int d;
    private String ka;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private double f2956ms;
    private NativeExpressView ny;
    private int x;
    private int xr;

    public b(lm lmVar, JSONObject jSONObject, NativeExpressView nativeExpressView) {
        com.bytedance.sdk.openadsdk.core.nw.ao aoVarMs;
        this.d = -1;
        this.x = -1;
        this.ny = nativeExpressView;
        this.x = f.ms(lmVar);
        if (jSONObject != null) {
            this.f2956ms = jSONObject.optDouble("slide_threshold", 0.0d);
            this.xr = jSONObject.optInt("direction", 30);
            this.d = jSONObject.optInt("type", -1);
            this.ka = jSONObject.optString("rgb_color");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rects");
            if (jSONArrayOptJSONArray != null) {
                this.ah = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (aoVarMs = com.bytedance.sdk.openadsdk.core.nw.ao.ms(jSONObjectOptJSONObject)) != null) {
                        this.ah.add(aoVarMs);
                    }
                }
            }
        }
        List<com.bytedance.sdk.openadsdk.core.nw.ao> list = this.ah;
        com.bytedance.sdk.component.utils.sl.ms("xdy", "priority:" + this.x + " dirction:" + this.xr + " type:" + this.d + " hold:" + this.f2956ms + " size:" + (list != null ? list.size() : 0));
    }

    public void ms(NativeExpressView nativeExpressView) {
        if (this.ah != null) {
            Context context = nativeExpressView.getContext();
            for (com.bytedance.sdk.openadsdk.core.nw.ao aoVar : this.ah) {
                SiteGestureView siteGestureView = new SiteGestureView(context, new sa(this.d, this.f2956ms, this.xr, this.x), this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ul.ah(context, (float) aoVar.ah), ul.ah(context, (float) aoVar.d));
                layoutParams.leftMargin = ul.ah(context, (float) aoVar.f3032ms);
                layoutParams.topMargin = ul.ah(context, (float) aoVar.xr);
                try {
                    if (!TextUtils.isEmpty(this.ka) && com.bytedance.sdk.component.utils.sl.ah()) {
                        siteGestureView.setBackgroundColor(Color.parseColor(this.ka));
                    }
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.sl.ms(e);
                }
                nativeExpressView.addView(siteGestureView, layoutParams);
                com.bytedance.sdk.component.utils.sl.ms("xdy", "(" + aoVar.f3032ms + "," + aoVar.xr + "," + aoVar.ah + "," + aoVar.d + ")");
            }
        }
    }

    public boolean ms() {
        View viewNy;
        List<com.bytedance.adsdk.ugeno.xr.ah<View>> list = this.c;
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.bytedance.adsdk.ugeno.xr.ah<View> ahVar : this.c) {
            if (ahVar != null && (viewNy = ahVar.ny()) != null && viewNy.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void ms(List<com.bytedance.adsdk.ugeno.xr.ah<View>> list) {
        this.c = list;
    }

    public void ms(MotionEvent motionEvent) {
        this.ny.ms(motionEvent);
    }

    public void xr() {
        this.ny.t();
    }

    public void ms(View view, int i, com.bytedance.sdk.component.adexpress.ah ahVar, sa saVar) {
        NativeExpressView nativeExpressView = this.ny;
        if (nativeExpressView != null) {
            nativeExpressView.ms(view, i, ahVar, saVar);
        }
    }

    public boolean ah() {
        return this.ab;
    }

    public void d() {
        this.ab = false;
    }
}
