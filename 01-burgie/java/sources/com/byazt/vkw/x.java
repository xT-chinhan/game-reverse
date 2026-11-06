package com.byazt.vkw;

import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, 121})
public class x implements hn, Function {
    public volatile hn hw;
    public volatile Function pr;

    public x(hn hnVar) {
        this.hw = hnVar;
    }

    public x(Function function) {
        this.pr = function;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case DownloadStatus.PAUSED_BY_DB_INIT /* -5 */:
                return this.hw != null ? this.hw : this.pr;
            case -4:
                Function function = (Function) sparseArray.get(1);
                if (function != null) {
                    this.pr = function;
                    this.hw = null;
                    return pr();
                }
                return null;
            case -3:
            case -2:
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

    @Override // com.byazt.vkw.hn
    public boolean c() {
        if (this.hw != null) {
            return this.hw.c();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.hn
    public void hn() {
        if (this.hw != null) {
            this.hw.hn();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.hn
    public void hw() {
        if (this.hw != null) {
            this.hw.hw();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.hn
    public void hw(String str, JSONObject jSONObject) {
        if (this.hw != null) {
            this.hw.hw(str, jSONObject);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.hn
    public String pr() {
        if (this.hw != null) {
            return this.hw.pr();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.hn
    public String pr(String str, String str2) {
        if (this.hw != null) {
            return this.hw.pr(str, str2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.hn
    public String pr(boolean z) {
        if (this.hw != null) {
            return this.hw.pr(z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Boolean.valueOf(z));
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.hn
    public void pr(com.byazt.lq.hn hnVar) {
        if (this.hw != null) {
            this.hw.pr(hnVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        if (hnVar != null) {
            hnVar = new com.byazt.lq.x(hnVar);
        }
        sparseArray.put(1, hnVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.hn
    public void pr(String str, JSONObject jSONObject) {
        if (this.hw != null) {
            this.hw.pr(str, jSONObject);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, str);
        sparseArray.put(2, jSONObject);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.hn
    public byte[] pr(byte[] bArr, int i) {
        if (this.hw != null) {
            return this.hw.pr(bArr, i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, bArr);
        sparseArray.put(2, Integer.valueOf(i));
        return (byte[]) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.hn
    public String x() {
        if (this.hw != null) {
            return this.hw.x();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.pr.apply(sparseArray);
    }
}
