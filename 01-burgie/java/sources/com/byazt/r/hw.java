package com.byazt.r;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 203, 13})
public class hw implements pr, Function {
    public volatile pr hw;
    public volatile Function pr;

    public hw(pr prVar) {
        this.hw = prVar;
    }

    public hw(Function function) {
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
                    return Boolean.valueOf(pr((Context) sparseArray.get(1), (JSONObject) sparseArray.get(2)));
                }
                return null;
            case -3:
            case -2:
            case -1:
            case 0:
            default:
                return null;
            case 1:
                return Boolean.valueOf(pr((Context) sparseArray.get(1), (JSONObject) sparseArray.get(2)));
            case 2:
                pr((ScheduledExecutorService) sparseArray.get(1));
                return null;
            case 3:
                pr();
                return null;
            case 4:
                pr(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 5:
                pr((Context) sparseArray.get(1), (String) sparseArray.get(2), (String) sparseArray.get(3));
                return null;
            case 6:
                pr((String) sparseArray.get(1));
                return null;
            case 7:
                hw();
                return null;
            case 8:
                pr((String) sparseArray.get(1), (String) sparseArray.get(2));
                return null;
            case 9:
                hw((String) sparseArray.get(1), (String) sparseArray.get(2));
                return null;
            case 10:
                hn((String) sparseArray.get(1), (String) sparseArray.get(2));
                return null;
            case 11:
                x((String) sparseArray.get(1), (String) sparseArray.get(2));
                return null;
            case 12:
                pr((String) sparseArray.get(1), (Throwable) sparseArray.get(2));
                return null;
            case 13:
                pr((String) sparseArray.get(1), (String) sparseArray.get(2), (Throwable) sparseArray.get(3));
                return null;
            case 14:
                c((String) sparseArray.get(1), (String) sparseArray.get(2));
                return null;
            case 15:
                hw((String) sparseArray.get(1), (String) sparseArray.get(2), (Throwable) sparseArray.get(3));
                return null;
            case 16:
                hw((String) sparseArray.get(1), (Throwable) sparseArray.get(2));
                return null;
            case 17:
                hn();
                return null;
        }
    }

    @Override // com.byazt.r.pr
    public void c(String str, String str2) {
        if (this.hw != null) {
            this.hw.c(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.pr
    public void hn() {
        if (this.hw != null) {
            this.hw.hn();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.pr
    public void hn(String str, String str2) {
        if (this.hw != null) {
            this.hw.hn(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.pr
    public void hw() {
        if (this.hw != null) {
            this.hw.hw();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.pr
    public void hw(String str, String str2) {
        if (this.hw != null) {
            this.hw.hw(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.pr
    public void hw(String str, String str2, Throwable th) {
        if (this.hw != null) {
            this.hw.hw(str, str2, th);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, th);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.pr
    public void hw(String str, Throwable th) {
        if (this.hw != null) {
            this.hw.hw(str, th);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, str);
        sparseArray.put(2, th);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.pr
    public void pr() {
        if (this.hw != null) {
            this.hw.pr();
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.pr
    public void pr(int i) {
        if (this.hw != null) {
            this.hw.pr(i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.pr
    public void pr(Context context, String str, String str2) {
        if (this.hw != null) {
            this.hw.pr(context, str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, context);
        sparseArray.put(2, str);
        sparseArray.put(3, str2);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.pr
    public void pr(String str) {
        if (this.hw != null) {
            this.hw.pr(str);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.pr
    public void pr(String str, String str2) {
        if (this.hw != null) {
            this.hw.pr(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.pr
    public void pr(String str, String str2, Throwable th) {
        if (this.hw != null) {
            this.hw.pr(str, str2, th);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        sparseArray.put(3, th);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.pr
    public void pr(String str, Throwable th) {
        if (this.hw != null) {
            this.hw.pr(str, th);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, str);
        sparseArray.put(2, th);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.pr
    public void pr(ScheduledExecutorService scheduledExecutorService) {
        if (this.hw != null) {
            this.hw.pr(scheduledExecutorService);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, scheduledExecutorService);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.r.pr
    public boolean pr(Context context, JSONObject jSONObject) {
        if (this.hw != null) {
            return this.hw.pr(context, jSONObject);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        sparseArray.put(1, context);
        sparseArray.put(2, jSONObject);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.r.pr
    public void x(String str, String str2) {
        if (this.hw != null) {
            this.hw.x(str, str2);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        this.pr.apply(sparseArray);
    }
}
