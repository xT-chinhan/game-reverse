package com.byazt.cv;

import android.text.TextUtils;
import android.view.View;
import com.byazt.xz.x;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1039, 26})
public class qg {
    public com.byazt.ih.s fs;
    public JSONArray l;
    public JSONArray n;
    public JSONArray q;
    public JSONArray qg;
    public com.byazt.ih.s rv;
    public JSONArray s;
    public JSONArray w;
    public n x;

    public qg(n nVar) {
        this.x = nVar;
    }

    public JSONObject n(com.byazt.ih.s sVar) throws JSONException {
        if (sVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        this.n = new JSONArray();
        this.qg = new JSONArray();
        this.s = new JSONArray();
        this.q = new JSONArray();
        this.l = new JSONArray();
        this.w = new JSONArray();
        qg(sVar);
        if (this.n.length() > 0) {
            jSONObject.putOpt(ILivePush.ClickType.CLOSE, this.n);
        }
        if (this.qg.length() > 0) {
            jSONObject.putOpt("convert", this.qg);
        }
        if (this.s.length() > 0) {
            jSONObject.putOpt(com.byazt.wg.qg.AD_TAG_DISLIKE, this.s);
        }
        if (this.q.length() > 0) {
            jSONObject.putOpt("muteVideo", this.q);
        }
        if (this.l.length() > 0) {
            jSONObject.putOpt("openPrivacy", this.l);
        }
        if (this.w.length() > 0) {
            jSONObject.putOpt("skip", this.w);
        }
        com.byazt.ih.s sVar2 = this.fs;
        if (sVar2 != null) {
            n(sVar2, false);
        } else {
            com.byazt.ih.s sVar3 = this.rv;
            if (sVar3 != null) {
                n(sVar3, true);
            }
        }
        return jSONObject;
    }

    private void qg(com.byazt.ih.s sVar) {
        if (sVar == null) {
            return;
        }
        if (sVar instanceof com.byazt.ih.n) {
            n((com.byazt.ih.n<?>) sVar);
        } else {
            s(sVar);
        }
    }

    private void n(com.byazt.ih.n<?> nVar) {
        s(nVar);
        List<com.byazt.ih.s<View>> listX = nVar.x();
        if (listX == null || listX.isEmpty()) {
            return;
        }
        Iterator<com.byazt.ih.s<View>> it = listX.iterator();
        while (it.hasNext()) {
            qg(it.next());
        }
    }

    private void s(com.byazt.ih.s sVar) {
        Map<String, List<com.byazt.et.qg>> mapTj;
        if (sVar == null || sVar.yw() == null || (mapTj = sVar.yw().tj()) == null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        for (List<com.byazt.et.qg> list : mapTj.values()) {
            if (list != null && !list.isEmpty()) {
                Iterator<com.byazt.et.qg> it = list.iterator();
                while (it.hasNext()) {
                    List<x.n> listQg = it.next().cp().qg();
                    if (listQg != null && !listQg.isEmpty()) {
                        for (x.n nVar : listQg) {
                            if (nVar != null && !TextUtils.isEmpty(nVar.qg())) {
                                String strQg = nVar.qg();
                                strQg.hashCode();
                                switch (strQg) {
                                    case "openPrivacy":
                                        if (!z5) {
                                            n(this.l, sVar);
                                        }
                                        z5 = true;
                                        break;
                                    case "skip":
                                        if (!z6) {
                                            n(this.w, sVar);
                                        }
                                        if (this.rv == null) {
                                            this.rv = sVar;
                                        }
                                        z6 = true;
                                        break;
                                    case "close":
                                        if (this.fs == null) {
                                            this.fs = sVar;
                                        }
                                        if (!z) {
                                            n(this.n, sVar);
                                        }
                                        z = true;
                                        break;
                                    case "convert":
                                        if (!z2) {
                                            n(this.qg, sVar);
                                        }
                                        z2 = true;
                                        break;
                                    case "muteVideo":
                                        if (!z4) {
                                            n(this.q, sVar);
                                        }
                                        z4 = true;
                                        break;
                                    case "dislike":
                                        if (!z3) {
                                            n(this.s, sVar);
                                        }
                                        z3 = true;
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void n(JSONArray jSONArray, com.byazt.ih.s sVar) {
        View viewRv;
        com.byazt.ih.n nVarBb;
        View viewRv2;
        if (jSONArray == null || sVar == null || (viewRv = sVar.rv()) == null || (nVarBb = sVar.bb()) == null || (viewRv2 = nVarBb.rv()) == null) {
            return;
        }
        int[] iArr = new int[2];
        viewRv.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        viewRv2.getLocationInWindow(iArr2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", sVar.v());
            jSONObject.putOpt("width", Integer.valueOf(viewRv.getWidth()));
            jSONObject.putOpt("height", Integer.valueOf(viewRv.getHeight()));
            jSONObject.putOpt(com.byazt.af.x.n, Integer.valueOf(iArr[0] - iArr2[0]));
            jSONObject.putOpt("y", Integer.valueOf(iArr[1] - iArr2[1]));
        } catch (Throwable unused) {
        }
        jSONArray.put(jSONObject);
    }

    private void n(com.byazt.ih.s sVar, boolean z) {
        View viewRv;
        if (sVar == null || (viewRv = sVar.rv()) == null) {
            return;
        }
        int[] iArr = new int[2];
        viewRv.getLocationOnScreen(iArr);
        this.x.n(new int[]{iArr[0], iArr[1], viewRv.getWidth(), viewRv.getHeight()}, z);
    }
}
