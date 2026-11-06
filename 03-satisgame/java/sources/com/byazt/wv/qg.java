package com.byazt.wv;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byakv.z.TTEncryptUtils;
import com.byazt.vf.k;
import java.util.HashMap;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 121, 26})
public class qg implements com.byazt.vf.s, Function {
    public static final long DAY_MILLIS = 86400000;
    public static volatile boolean l = false;
    public static volatile String qg = "";
    public static volatile String s = "";
    public static volatile boolean w = false;
    public final com.byazt.zve.n mAppLogInitConfig;
    public volatile String n;
    public final Context q;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == -3) {
            n((SparseArray) sparseArray.get(1));
            return null;
        }
        if (iIntValue == -2) {
            return x();
        }
        switch (iIntValue) {
            case 1:
                return n();
            case 2:
                return n(((Boolean) sparseArray.get(1)).booleanValue());
            case 3:
                return n((byte[]) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
            case 4:
                Object qVar = sparseArray.get(1);
                if (qVar != null) {
                    qVar = new com.byazt.zve.q((Function) qVar);
                }
                n((com.byazt.zve.s) qVar);
                return null;
            case 5:
                qg();
                return null;
            case 6:
                s();
                return null;
            case 7:
                return q();
            case 8:
                return n((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 9:
                n((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
                return null;
            case 10:
                qg((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
                return null;
            case 11:
                return Boolean.valueOf(l());
            default:
                return null;
        }
    }

    public void n(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj != null) {
            this.n = (String) obj;
        }
        Object obj2 = sparseArray.get(2);
        if (obj2 != null) {
            qg = (String) obj2;
        }
        Object obj3 = sparseArray.get(3);
        if (obj3 != null) {
            s = (String) obj3;
        }
    }

    public SparseArray x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, this.n);
        sparseArray.put(2, qg);
        sparseArray.put(3, s);
        return sparseArray;
    }

    public qg(Context context, com.byazt.zve.n nVar) {
        this.q = context;
        this.mAppLogInitConfig = nVar;
        n(nVar);
    }

    @Override // com.byazt.vf.s
    public String n() {
        if (!TextUtils.isEmpty(this.n)) {
            return this.n;
        }
        this.n = n.rv();
        return this.n;
    }

    @Override // com.byazt.vf.s
    public String n(boolean z) {
        return qg(z);
    }

    @Override // com.byazt.vf.s
    public byte[] n(byte[] bArr, int i) {
        return qg(bArr, i);
    }

    @Override // com.byazt.vf.s
    public void n(final com.byazt.zve.s sVar) {
        n.n(new com.byazt.zve.s() { // from class: com.byazt.wv.qg.1
            @Override // com.byazt.zve.s
            public void n(com.byazt.zve.qg qgVar) {
                com.byazt.zve.s sVar2 = sVar;
                if (sVar2 != null) {
                    sVar2.n(qgVar);
                }
                if (qgVar == null || TextUtils.isEmpty(qgVar.n())) {
                    return;
                }
                qg.this.n(qgVar.n());
                n.qg(this);
            }
        });
    }

    @Override // com.byazt.vf.s
    public void qg() {
        n.sz();
    }

    @Override // com.byazt.vf.s
    public void s() {
        n.k();
    }

    @Override // com.byazt.vf.s
    public String q() {
        return n.cp();
    }

    @Override // com.byazt.vf.s
    public String n(String str, String str2) {
        return (String) n.n(str, str2);
    }

    @Override // com.byazt.vf.s
    public void n(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        n.qg(str, jSONObject);
    }

    @Override // com.byazt.vf.s
    public void qg(String str, JSONObject jSONObject) {
        n.n(str, jSONObject);
    }

    @Override // com.byazt.vf.s
    public boolean l() {
        return l;
    }

    public void n(com.byazt.zve.n nVar) {
        x xVar = new x(nVar.n(), nVar.qg());
        xVar.q(nVar.s());
        xVar.s(nVar.q());
        xVar.s(nVar.l());
        xVar.l(nVar.w());
        xVar.qg(nVar.x());
        xVar.w(nVar.fs());
        xVar.n(nVar.rv());
        xVar.qg(nVar.tj());
        xVar.n(nVar.cp());
        xVar.qg(0);
        HashMap<String, Object> mapOa = nVar.oa();
        if (mapOa != null) {
            Object obj = mapOa.get("host_appid");
            if (obj instanceof String) {
                xVar.n((String) obj);
            }
        }
        n.n(nVar.d());
        n.n(this.q, xVar);
        n.n(mapOa);
    }

    public String qg(boolean z) {
        long j;
        if (!TextUtils.isEmpty(qg)) {
            return qg;
        }
        if (z && !TextUtils.isEmpty(s)) {
            return s;
        }
        try {
            String string = com.byazt.km.l.n(this.mAppLogInitConfig.k()).getString("new_app_log_oaid", null);
            if (TextUtils.isEmpty(string)) {
                j = 0;
            } else {
                JSONObject jSONObject = new JSONObject(string);
                s = ((k) com.byazt.qp.q.n("encrypt_service")).q(jSONObject.getString(com.byazt.km.l.n));
                j = jSONObject.getLong(com.byazt.km.l.qg);
            }
            if (!TextUtils.isEmpty(s) && (z || System.currentTimeMillis() - j < 86400000)) {
                fs();
                return s;
            }
            if (!w) {
                w();
                String strSz = this.mAppLogInitConfig.sz();
                if (!TextUtils.isEmpty(strSz)) {
                    qg = strSz;
                    l = !TextUtils.isEmpty(strSz);
                    update(l);
                }
            }
            return qg == null ? "" : qg;
        } catch (Exception unused) {
        }
    }

    private void fs() {
        l = com.byazt.km.l.n(this.mAppLogInitConfig.k()).getBoolean("is_use_dev_oaid", false);
    }

    public void n(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            w = true;
            qg = str;
            l = false;
            update(l);
        } catch (Throwable unused) {
        }
    }

    private void update(boolean z) {
        if (TextUtils.isEmpty(qg)) {
            return;
        }
        String strS = ((k) com.byazt.qp.q.n("encrypt_service")).s(qg);
        com.byazt.km.l.n(this.mAppLogInitConfig, "app_log_oaid", qg);
        com.byazt.km.l.n(this.mAppLogInitConfig, "new_app_log_oaid", strS);
        com.byazt.km.l.n(this.mAppLogInitConfig.k()).n("is_use_dev_oaid", z);
    }

    public void w() {
        n.n(this.mAppLogInitConfig.hd());
        n.n();
    }

    public static byte[] qg(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return TTEncryptUtils.n(bArr, i);
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
