package com.byazt.za;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.gct.kc;
import com.byazt.gct.pk;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_READ_CACHE_MODE, MediaPlayer.MEDIA_PLAYER_OPTION_NO_AV_SYNC})
public class wm {
    public int fs;
    public String l;
    public double n;
    public int q;
    public int qg;
    public NativeExpressView rv;
    public List<com.byazt.gct.cy> s;
    public List<com.byazt.ih.s<View>> w;
    public boolean x = true;

    public wm(pk pkVar, JSONObject jSONObject, NativeExpressView nativeExpressView) {
        com.byazt.gct.cy cyVarN;
        this.q = -1;
        this.fs = -1;
        this.rv = nativeExpressView;
        this.fs = com.byazt.vgx.w.n(pkVar);
        if (jSONObject != null) {
            this.n = jSONObject.optDouble("slide_threshold", 0.0d);
            this.qg = jSONObject.optInt("direction", 30);
            this.q = jSONObject.optInt("type", -1);
            this.l = jSONObject.optString("rgb_color");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rects");
            if (jSONArrayOptJSONArray != null) {
                this.s = new ArrayList();
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && (cyVarN = com.byazt.gct.cy.n(jSONObjectOptJSONObject)) != null) {
                        this.s.add(cyVarN);
                    }
                }
            }
        }
        List<com.byazt.gct.cy> list = this.s;
        if (list != null) {
            list.size();
        }
    }

    public void n(NativeExpressView nativeExpressView) {
        if (this.s != null) {
            Context context = nativeExpressView.getContext();
            for (com.byazt.gct.cy cyVar : this.s) {
                SiteGestureView siteGestureView = new SiteGestureView(context, new kc(this.q, this.n, this.qg, this.fs), this);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.byazt.okk.s.s(context, (float) cyVar.s), com.byazt.okk.s.s(context, (float) cyVar.q));
                layoutParams.leftMargin = com.byazt.okk.s.s(context, (float) cyVar.n);
                layoutParams.topMargin = com.byazt.okk.s.s(context, (float) cyVar.qg);
                try {
                    if (!TextUtils.isEmpty(this.l) && com.byazt.tk.k.s()) {
                        siteGestureView.setBackgroundColor(Color.parseColor(this.l));
                    }
                } catch (Exception unused) {
                }
                nativeExpressView.addView(siteGestureView, layoutParams);
            }
        }
    }

    public boolean n() {
        View viewRv;
        List<com.byazt.ih.s<View>> list = this.w;
        if (list == null || list.size() == 0) {
            return false;
        }
        for (com.byazt.ih.s<View> sVar : this.w) {
            if (sVar != null && (viewRv = sVar.rv()) != null && viewRv.getVisibility() == 0) {
                return true;
            }
        }
        return false;
    }

    public void n(List<com.byazt.ih.s<View>> list) {
        this.w = list;
    }

    public void n(MotionEvent motionEvent) {
        this.rv.n(motionEvent);
    }

    public void qg() {
        this.rv.a();
    }

    public void n(View view, int i, com.byazt.twc.s sVar, kc kcVar) {
        NativeExpressView nativeExpressView = this.rv;
        if (nativeExpressView != null) {
            nativeExpressView.n(view, i, sVar, kcVar);
        }
    }

    public boolean s() {
        return this.x;
    }

    public void q() {
        this.x = false;
    }
}
