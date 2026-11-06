package com.byazt.hg;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 166})
public class iu {
    public List<bh> pr;

    public iu(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        this.pr = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            this.pr.add(new bh(jSONArray.optJSONObject(i), 4));
        }
    }

    public static List<bh> pr(of ofVar) {
        iu iuVarXd;
        if (ofVar == null || (iuVarXd = ofVar.xd()) == null) {
            return null;
        }
        return iuVarXd.pr;
    }

    public static boolean hw(of ofVar) {
        iu iuVarXd;
        List<bh> list;
        if (ofVar == null || (iuVarXd = ofVar.xd()) == null || (list = iuVarXd.pr) == null || list.isEmpty()) {
            return false;
        }
        return true;
    }

    public static bh hn(of ofVar) {
        List<bh> listPr;
        if (!hw(ofVar) || (listPr = pr(ofVar)) == null || listPr.isEmpty()) {
            return null;
        }
        for (bh bhVar : listPr) {
            if (bhVar != null && bhVar.k()) {
                boolean z = bhVar.x() == 1;
                if (1 == bhVar.fw() && z) {
                    return bhVar;
                }
            }
        }
        return null;
    }

    public static List<bh> x(of ofVar) {
        List<bh> listPr;
        if (!hw(ofVar) || (listPr = pr(ofVar)) == null || listPr.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (bh bhVar : listPr) {
            if (bhVar != null && bhVar.k() && bhVar.fw() == 0) {
                arrayList.add(bhVar);
            }
        }
        return arrayList;
    }

    public static boolean c(of ofVar) {
        return (ofVar == null || com.byazt.sd.a.hw().xk() || !hw(ofVar) || hn(ofVar) == null) ? false : true;
    }
}
