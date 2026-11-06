package com.byazt.vkw;

import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.byazt.mrs.DownloadStatus;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, 61})
public class aj implements fw, Function {
    public volatile fw hw;
    public volatile Function pr;

    public aj(fw fwVar) {
        this.hw = fwVar;
    }

    public aj(Function function) {
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
            case 2:
            default:
                return null;
            case 1:
                return pr();
            case 3:
                return Boolean.valueOf(pr((String) sparseArray.get(1), (String) sparseArray.get(2)));
            case 4:
                return Boolean.valueOf(pr((String) sparseArray.get(1)));
            case 5:
                pr((MotionEvent) sparseArray.get(1));
                return null;
            case 6:
                return pr((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue(), ((Integer) sparseArray.get(3)).intValue(), ((Boolean) sparseArray.get(4)).booleanValue());
            case 7:
                pr(((Long) sparseArray.get(1)).longValue(), ((Integer) sparseArray.get(2)).intValue());
                return null;
            case 8:
                return hw((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 9:
                return hw();
            case 10:
                return hn();
            case 11:
                pr(((Double) sparseArray.get(1)).doubleValue(), ((Long) sparseArray.get(2)).longValue());
                return null;
            case 12:
                Object zoVar = sparseArray.get(1);
                if (zoVar != null) {
                    zoVar = new zo((Function) zoVar);
                }
                pr((fw.pr) zoVar);
                return null;
            case 13:
                return Boolean.valueOf(x());
            case 14:
                hw((String) sparseArray.get(1));
                return null;
            case 15:
                pr(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 16:
                pr((JSONObject) sparseArray.get(1));
                return null;
            case 17:
                return Boolean.valueOf(hw(((Integer) sparseArray.get(1)).intValue()));
        }
    }

    @Override // com.byazt.vkw.fw
    public String hn() {
        if (this.hw != null) {
            return this.hw.hn();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.fw
    public Context hw() {
        if (this.hw != null) {
            return this.hw.hw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (Context) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.fw
    public String hw(String str, String str2) {
        if (this.hw != null) {
            return this.hw.hw(str, str2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.fw
    public void hw(String str) {
        if (this.hw != null) {
            this.hw.hw(str);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.fw
    public boolean hw(int i) {
        if (this.hw != null) {
            return this.hw.hw(i);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        sparseArray.put(1, Integer.valueOf(i));
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.fw
    public String pr() {
        if (this.hw != null) {
            return this.hw.pr();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.fw
    public String pr(String str, long j, int i, boolean z) {
        if (this.hw != null) {
            return this.hw.pr(str, j, i, z);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        sparseArray.put(2, Long.valueOf(j));
        sparseArray.put(3, Integer.valueOf(i));
        sparseArray.put(4, Boolean.valueOf(z));
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.fw
    public void pr(double d, long j) {
        if (this.hw != null) {
            this.hw.pr(d, j);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, Double.valueOf(d));
        sparseArray.put(2, Long.valueOf(j));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.fw
    public void pr(int i) {
        if (this.hw != null) {
            this.hw.pr(i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.fw
    public void pr(long j, int i) {
        if (this.hw != null) {
            this.hw.pr(j, i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, Long.valueOf(j));
        sparseArray.put(2, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.fw
    public void pr(MotionEvent motionEvent) {
        if (this.hw != null) {
            this.hw.pr(motionEvent);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, motionEvent);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.fw
    public void pr(fw.pr prVar) {
        if (this.hw != null) {
            this.hw.pr(prVar);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        if (prVar != null) {
            prVar = new zo(prVar);
        }
        sparseArray.put(1, prVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.fw
    public void pr(JSONObject jSONObject) {
        if (this.hw != null) {
            this.hw.pr(jSONObject);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, jSONObject);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.fw
    public boolean pr(String str) {
        if (this.hw != null) {
            return this.hw.pr(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.fw
    public boolean pr(String str, String str2) {
        if (this.hw != null) {
            return this.hw.pr(str, str2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.vkw.fw
    public boolean x() {
        if (this.hw != null) {
            return this.hw.x();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }
}
