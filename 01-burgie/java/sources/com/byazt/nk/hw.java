package com.byazt.nk;

import android.support.v4.view.PointerIconCompat;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.api.push.ILivePush;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 13})
public class hw {
    public JSONArray c;
    public pr fw;
    public JSONArray hn;
    public JSONArray hw;
    public JSONArray pr;
    public JSONArray uc;
    public JSONArray x;

    public hw(pr prVar) {
        this.fw = prVar;
    }

    public JSONObject pr(com.byazt.ik.hn hnVar) throws JSONException {
        if (hnVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        this.pr = new JSONArray();
        this.hw = new JSONArray();
        this.hn = new JSONArray();
        this.x = new JSONArray();
        this.c = new JSONArray();
        this.uc = new JSONArray();
        hw(hnVar);
        if (this.pr.length() > 0) {
            jSONObject.putOpt(ILivePush.ClickType.CLOSE, this.pr);
        }
        if (this.hw.length() > 0) {
            jSONObject.putOpt("convert", this.hw);
        }
        if (this.hn.length() > 0) {
            jSONObject.putOpt(com.byazt.pfl.hw.AD_TAG_DISLIKE, this.hn);
        }
        if (this.x.length() > 0) {
            jSONObject.putOpt("muteVideo", this.x);
        }
        if (this.c.length() > 0) {
            jSONObject.putOpt("openPrivacy", this.c);
        }
        if (this.uc.length() > 0) {
            jSONObject.putOpt("skip", this.uc);
        }
        return jSONObject;
    }

    private void hw(com.byazt.ik.hn hnVar) {
        if (hnVar == null) {
            return;
        }
        if (hnVar instanceof com.byazt.ik.pr) {
            pr((com.byazt.ik.pr<?>) hnVar);
        } else {
            hn(hnVar);
        }
    }

    private void pr(com.byazt.ik.pr<?> prVar) {
        hn(prVar);
        List<com.byazt.ik.hn<View>> listFw = prVar.fw();
        if (listFw == null || listFw.isEmpty()) {
            return;
        }
        Iterator<com.byazt.ik.hn<View>> it = listFw.iterator();
        while (it.hasNext()) {
            hw(it.next());
        }
    }

    private void hn(com.byazt.ik.hn hnVar) {
        Map<String, List<com.byazt.xv.hw>> mapAj;
        if (hnVar == null || hnVar.l() == null || (mapAj = hnVar.l().aj()) == null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        for (List<com.byazt.xv.hw> list : mapAj.values()) {
            if (list != null && !list.isEmpty()) {
                Iterator<com.byazt.xv.hw> it = list.iterator();
                while (it.hasNext()) {
                    List<com.byazt.dd.fw.pr> listHw = it.next().w().hw();
                    if (listHw != null && !listHw.isEmpty()) {
                        for (com.byazt.dd.fw.pr prVar : listHw) {
                            if (prVar != null && !TextUtils.isEmpty(prVar.hw())) {
                                switch (prVar.hw()) {
                                    case "close":
                                        if (!z) {
                                            pr(this.pr, hnVar);
                                            x(hnVar);
                                        }
                                        z = true;
                                        break;
                                    case "convert":
                                        if (!z2) {
                                            pr(this.hw, hnVar);
                                        }
                                        z2 = true;
                                        break;
                                    case "dislike":
                                        if (!z3) {
                                            pr(this.hn, hnVar);
                                        }
                                        z3 = true;
                                        break;
                                    case "muteVideo":
                                        if (!z4) {
                                            pr(this.x, hnVar);
                                        }
                                        z4 = true;
                                        break;
                                    case "openPrivacy":
                                        if (!z5) {
                                            pr(this.c, hnVar);
                                        }
                                        z5 = true;
                                        break;
                                    case "skip":
                                        if (!z6) {
                                            pr(this.uc, hnVar);
                                        }
                                        z6 = true;
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void pr(JSONArray jSONArray, com.byazt.ik.hn hnVar) {
        View viewAj;
        com.byazt.ik.pr prVarGz;
        View viewAj2;
        if (jSONArray == null || hnVar == null || (viewAj = hnVar.aj()) == null || (prVarGz = hnVar.gz()) == null || (viewAj2 = prVarGz.aj()) == null) {
            return;
        }
        int[] iArr = new int[2];
        viewAj.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        viewAj2.getLocationInWindow(iArr2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("id", hnVar.ww());
            jSONObject.putOpt("width", Integer.valueOf(viewAj.getWidth()));
            jSONObject.putOpt("height", Integer.valueOf(viewAj.getHeight()));
            jSONObject.putOpt("x", Integer.valueOf(iArr[0] - iArr2[0]));
            jSONObject.putOpt("y", Integer.valueOf(iArr[1] - iArr2[1]));
        } catch (Throwable th) {
        }
        jSONArray.put(jSONObject);
    }

    private void x(com.byazt.ik.hn hnVar) {
        View viewAj;
        if (hnVar == null || (viewAj = hnVar.aj()) == null) {
            return;
        }
        int[] iArr = new int[2];
        viewAj.getLocationOnScreen(iArr);
        this.fw.pr(new int[]{iArr[0], iArr[1], viewAj.getWidth(), viewAj.getHeight()});
    }
}
