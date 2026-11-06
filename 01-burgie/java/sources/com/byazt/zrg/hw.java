package com.byazt.zrg;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byakv.z.TTEncryptUtils;
import com.byazt.vkw.nt;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 400, 13})
public class hw implements com.byazt.vkw.hn, Function {
    public static final long DAY_MILLIS = 86400000;
    public final com.byazt.lq.pr mAppLogInitConfig;
    public volatile String pr;
    public final Context x;
    public static volatile String hw = "";
    public static volatile String hn = "";
    public static volatile boolean c = false;
    public static volatile boolean uc = false;

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case -3:
                pr((SparseArray) sparseArray.get(1));
                return null;
            case -2:
                return fw();
            case -1:
            case 0:
            default:
                return null;
            case 1:
                return pr();
            case 2:
                return pr(((Boolean) sparseArray.get(1)).booleanValue());
            case 3:
                return pr((byte[]) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
            case 4:
                Object xVar = sparseArray.get(1);
                if (xVar != null) {
                    xVar = new com.byazt.lq.x((Function) xVar);
                }
                pr((com.byazt.lq.hn) xVar);
                return null;
            case 5:
                hw();
                return null;
            case 6:
                hn();
                return null;
            case 7:
                return x();
            case 8:
                return pr((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 9:
                pr((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
                return null;
            case 10:
                hw((String) sparseArray.get(1), (JSONObject) sparseArray.get(2));
                return null;
            case 11:
                return Boolean.valueOf(c());
        }
    }

    public SparseArray fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, this.pr);
        sparseArray.put(2, hw);
        sparseArray.put(3, hn);
        return sparseArray;
    }

    public void pr(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj != null) {
            this.pr = (String) obj;
        }
        Object obj2 = sparseArray.get(2);
        if (obj2 != null) {
            hw = (String) obj2;
        }
        Object obj3 = sparseArray.get(3);
        if (obj3 != null) {
            hn = (String) obj3;
        }
    }

    public hw(Context context, com.byazt.lq.pr prVar) {
        this.x = context;
        this.mAppLogInitConfig = prVar;
        pr(prVar);
    }

    @Override // com.byazt.vkw.hn
    public String pr() {
        if (!TextUtils.isEmpty(this.pr)) {
            return this.pr;
        }
        this.pr = pr.aj();
        return this.pr;
    }

    @Override // com.byazt.vkw.hn
    public String pr(boolean z) {
        return hw(z);
    }

    @Override // com.byazt.vkw.hn
    public byte[] pr(byte[] bArr, int i) {
        return hw(bArr, i);
    }

    @Override // com.byazt.vkw.hn
    public void pr(final com.byazt.lq.hn hnVar) {
        pr.pr(new com.byazt.lq.hn() { // from class: com.byazt.zrg.hw.1
            @Override // com.byazt.lq.hn
            public void pr(com.byazt.lq.hw hwVar) {
                com.byazt.lq.hn hnVar2 = hnVar;
                if (hnVar2 != null) {
                    hnVar2.pr(hwVar);
                }
                if (hwVar != null && !TextUtils.isEmpty(hwVar.pr())) {
                    hw.this.pr(hwVar.pr());
                    pr.hw(this);
                }
            }
        });
    }

    @Override // com.byazt.vkw.hn
    public void hw() {
        pr.g();
    }

    @Override // com.byazt.vkw.hn
    public void hn() {
        pr.ho();
    }

    @Override // com.byazt.vkw.hn
    public String x() {
        return pr.w();
    }

    @Override // com.byazt.vkw.hn
    public String pr(String str, String str2) {
        return (String) pr.pr(str, str2);
    }

    @Override // com.byazt.vkw.hn
    public void pr(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        pr.hw(str, jSONObject);
    }

    @Override // com.byazt.vkw.hn
    public void hw(String str, JSONObject jSONObject) {
        pr.pr(str, jSONObject);
    }

    @Override // com.byazt.vkw.hn
    public boolean c() {
        return c;
    }

    public void pr(com.byazt.lq.pr prVar) {
        fw fwVar = new fw(prVar.pr(), prVar.hw());
        fwVar.x(prVar.hn());
        fwVar.hw(prVar.x());
        fwVar.hn(prVar.c());
        fwVar.c(prVar.uc());
        fwVar.pr(prVar.fw());
        fwVar.uc(prVar.zo());
        fwVar.pr(prVar.aj());
        fwVar.hw(prVar.vk());
        fwVar.pr(prVar.w());
        fwVar.hw(0);
        pr.pr(prVar.k());
        pr.pr(this.x, fwVar);
        pr.pr(prVar.m());
    }

    public String hw(boolean z) {
        if (!TextUtils.isEmpty(hw)) {
            return hw;
        }
        if (z && !TextUtils.isEmpty(hn)) {
            return hn;
        }
        long j = 0;
        try {
            String string = com.byazt.ec.c.pr(this.mAppLogInitConfig.ho()).getString("new_app_log_oaid", null);
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                hn = ((nt) com.byazt.zs.uc.pr("encrypt_service")).x(jSONObject.getString(com.byazt.ec.c.pr));
                j = jSONObject.getLong(com.byazt.ec.c.hw);
            }
            if (!TextUtils.isEmpty(hn) && (z || System.currentTimeMillis() - j < 86400000)) {
                zo();
                return hn;
            }
            if (!uc) {
                uc();
                String strG = this.mAppLogInitConfig.g();
                if (!TextUtils.isEmpty(strG)) {
                    hw = strG;
                    c = !TextUtils.isEmpty(strG);
                    update(c);
                }
            }
            return hw == null ? "" : hw;
        } catch (Exception e) {
        }
    }

    private void zo() {
        c = com.byazt.ec.c.pr(this.mAppLogInitConfig.ho()).getBoolean("is_use_dev_oaid", false);
    }

    public void pr(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                uc = true;
                hw = str;
                c = false;
                update(c);
            }
        } catch (Throwable th) {
        }
    }

    private void update(boolean z) {
        if (!TextUtils.isEmpty(hw)) {
            String strHn = ((nt) com.byazt.zs.uc.pr("encrypt_service")).hn(hw);
            com.byazt.ec.c.pr(this.mAppLogInitConfig, "app_log_oaid", hw);
            com.byazt.ec.c.pr(this.mAppLogInitConfig, "new_app_log_oaid", strHn);
            com.byazt.ec.c.pr(this.mAppLogInitConfig.ho()).pr("is_use_dev_oaid", z);
        }
    }

    public void uc() {
        pr.pr(this.mAppLogInitConfig.yb());
        pr.pr();
    }

    public static byte[] hw(byte[] bArr, int i) {
        if (bArr != null && i > 0) {
            try {
                if (bArr.length == i) {
                    return TTEncryptUtils.pr(bArr, i);
                }
            } catch (Throwable th) {
                return null;
            }
        }
        return null;
    }
}
