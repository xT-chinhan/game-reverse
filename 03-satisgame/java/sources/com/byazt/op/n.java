package com.byazt.op;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.gct.hd;
import com.byazt.gct.pk;
import com.byazt.gct.py;
import com.byazt.llp.cp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 502, 19})
public abstract class n implements q {
    public volatile Function<SparseArray<Object>, Object> n = null;
    public volatile String qg;
    public JSONObject s;

    public abstract boolean N_();

    public void a_(String str) {
    }

    @Override // com.byazt.op.q
    public void n() {
    }

    @Override // com.byazt.op.q
    public void n(String str, pk pkVar, long j) {
    }

    @Override // com.byazt.op.q
    public long s() {
        return -1L;
    }

    @Override // com.byazt.op.q
    public void s(cp cpVar) {
    }

    @Override // com.byazt.op.q
    public void n(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return;
        }
        this.n = function;
    }

    public boolean n(cp cpVar) {
        if (cpVar == null) {
            return false;
        }
        return n(cpVar.tj(), cpVar.l());
    }

    @Override // com.byazt.op.q
    public boolean n(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Long.parseLong(str) <= 0) {
                return false;
            }
            switch (i) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                    return true;
                default:
                    return false;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public long n(pk pkVar) {
        if (pkVar == null) {
            return 0L;
        }
        String strTj = pkVar.tj();
        if (TextUtils.isEmpty(strTj)) {
            strTj = n(pkVar.sz());
        }
        try {
            return Long.parseLong(strTj);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public String n(hd hdVar) {
        Map<String, String> mapN;
        if (hdVar == null) {
            return null;
        }
        String strQg = hdVar.qg();
        if (TextUtils.isEmpty(strQg)) {
            return null;
        }
        if ((strQg.startsWith("snssdk2329") || strQg.startsWith("snssdk1128")) && (mapN = com.byazt.rd.s.n(strQg)) != null) {
            return mapN.get("room_id");
        }
        return null;
    }

    public String n(cp cpVar, String str, Map map) {
        if (map == null) {
            return str;
        }
        try {
            String str2 = (String) map.get("dpa_tag");
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            String strL = py.l(cpVar.oa(), str2);
            if (TextUtils.isEmpty(strL)) {
                return str;
            }
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(strL);
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.putOpt(next, jSONObject2.opt(next));
            }
            return jSONObject.toString();
        } catch (Exception e) {
            com.byazt.eji.s.n().n("getEcomLiveParams", e);
            return str;
        }
    }

    public void n(pk pkVar, String str, int i, int i2, int i3) {
        com.byazt.hm.n.n(pkVar, str, i, i2, i3, N_());
    }

    public boolean n(cp cpVar, int i) {
        return cpVar.l() == 7 || i == 103;
    }

    public int qg(cp cpVar) {
        hd hdVarSz;
        if (1 != com.byazt.wq.qg.n().l()) {
            return 2;
        }
        if (!com.byazt.hoz.n.n(cpVar)) {
            return 3;
        }
        if (com.byazt.vgx.w.h() && (hdVarSz = cpVar.sz()) != null) {
            String strQg = hdVarSz.qg();
            if (!TextUtils.isEmpty(strQg)) {
                Uri uri = Uri.parse(strQg);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(uri);
                return com.byazt.vgx.w.qg(intent, true) ? 0 : 4;
            }
        }
        return 0;
    }

    @Override // com.byazt.op.q
    public int n(Context context, long j) {
        if (context == null || j <= 0) {
            return 5;
        }
        if (this.n == null) {
            return 4;
        }
        if (!w()) {
            return 1;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putLong("room_id", j);
            HashMap map = new HashMap();
            map.put("context", context);
            map.put("bundle", bundle);
            Object objApply = this.n.apply(com.byazt.of.qg.n().n(0).n(Integer.class).n(0, map).qg());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        } catch (Throwable unused) {
        }
        return 2;
    }
}
