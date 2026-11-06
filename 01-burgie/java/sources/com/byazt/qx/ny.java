package com.byazt.qx;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.hg.mw;
import com.byazt.hg.of;
import com.byazt.wt.er;
import com.byazt.wt.ls;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 49, 36})
public class ny {
    public NativeExpressView aj;
    public String c;
    public boolean fw;
    public List<com.byazt.hg.nt> hn;
    public int hw;
    public double pr;
    public List<com.byazt.ik.hn<View>> uc;
    public int x;
    public int zo;

    public ny(of ofVar, JSONObject jSONObject, NativeExpressView nativeExpressView) {
        com.byazt.hg.nt ntVarPr;
        this.x = -1;
        this.fw = false;
        this.zo = -1;
        this.fw = true;
        this.aj = nativeExpressView;
        this.zo = ls.pr(ofVar);
        if (jSONObject != null) {
            this.pr = jSONObject.optDouble("slide_threshold", 0.0d);
            this.hw = jSONObject.optInt("direction", 30);
            this.x = jSONObject.optInt("type", -1);
            this.c = jSONObject.optString("rgb_color");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rects");
            if (jSONArrayOptJSONArray != null) {
                this.hn = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (ntVarPr = com.byazt.hg.nt.pr(jSONObjectOptJSONObject)) != null) {
                        this.hn.add(ntVarPr);
                    }
                }
            }
        }
        List<com.byazt.hg.nt> list = this.hn;
        if (list != null) {
            list.size();
        }
    }

    public void pr(NativeExpressView nativeExpressView) {
        if (this.hn != null) {
            Context context = nativeExpressView.getContext();
            for (com.byazt.hg.nt ntVar : this.hn) {
                SiteGestureView siteGestureView = new SiteGestureView(context, new mw(this.x, this.pr, this.hw, this.zo), this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(er.hn(context, (float) ntVar.hn), er.hn(context, (float) ntVar.x));
                layoutParams.leftMargin = er.hn(context, (float) ntVar.pr);
                layoutParams.topMargin = er.hn(context, (float) ntVar.hw);
                try {
                    if (!TextUtils.isEmpty(this.c) && com.byazt.ca.ho.hn()) {
                        siteGestureView.setBackgroundColor(Color.parseColor(this.c));
                    }
                } catch (Exception e) {
                }
                nativeExpressView.addView(siteGestureView, layoutParams);
            }
        }
    }

    public boolean pr() {
        View viewAj;
        List<com.byazt.ik.hn<View>> list = this.uc;
        if (list != null && list.size() != 0) {
            for (com.byazt.ik.hn<View> hnVar : this.uc) {
                if (hnVar != null && (viewAj = hnVar.aj()) != null && viewAj.getVisibility() == 0) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void pr(List<com.byazt.ik.hn<View>> list) {
        this.uc = list;
    }

    public void pr(MotionEvent motionEvent) {
        this.aj.pr(motionEvent);
    }

    public void hw() {
        this.aj.a();
    }

    public void pr(View view, int i, com.byazt.dj.hn hnVar, mw mwVar) {
        NativeExpressView nativeExpressView = this.aj;
        if (nativeExpressView != null) {
            nativeExpressView.pr(view, i, hnVar, mwVar);
        }
    }

    public boolean hn() {
        return this.fw;
    }

    public void x() {
        this.fw = false;
    }
}
