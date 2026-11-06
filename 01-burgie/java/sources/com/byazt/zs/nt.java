package com.byazt.zs;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.byazt.vkw.qi;
import com.byazt.vkw.qn;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 14, 74})
public class nt implements qi, Function {
    public volatile Handler c;
    public volatile Handler fw;
    public volatile ThreadPoolExecutor hn;
    public ThreadPoolExecutor hw;
    public volatile ThreadPoolExecutor pr;
    public volatile Handler uc;
    public volatile ScheduledExecutorService x;
    public com.byazt.wy.pr zo = com.byazt.wy.pr.pr();

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case -3:
                pr((SparseArray) sparseArray.get(1));
                return null;
            case -2:
                return vk();
            case -1:
                aj();
                return null;
            case 0:
            default:
                return null;
            case 1:
                return pr();
            case 2:
                return hw();
            case 3:
                return hn();
            case 4:
                return pr(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue());
            case 5:
                return x();
            case 6:
                return c();
            case 7:
                return uc();
            case 8:
                return fw();
            case 9:
                return zo();
            case 10:
                pr((Runnable) sparseArray.get(1), ((Integer) sparseArray.get(2)).intValue());
                return null;
            case 11:
                pr((Runnable) sparseArray.get(1));
                return null;
            case 12:
                hw((Runnable) sparseArray.get(1));
                return null;
            case 13:
                return pr((String) sparseArray.get(1));
            case 14:
                Object qnVar = sparseArray.get(1);
                Object obj2 = sparseArray.get(2);
                if (qnVar != null) {
                    qnVar = new qn((Function) qnVar);
                }
                return pr((qi.pr) qnVar, (String) obj2);
            case 15:
                pr((Handler) sparseArray.get(1));
                return null;
            case 16:
                pr((JSONObject) sparseArray.get(1));
                return null;
            case 17:
                hn((Runnable) sparseArray.get(1));
                return null;
        }
    }

    public void pr(SparseArray sparseArray) {
        Object obj = sparseArray.get(1);
        if (obj != null) {
            this.pr = (ThreadPoolExecutor) obj;
        }
        Object obj2 = sparseArray.get(2);
        if (obj2 != null) {
            this.hw = (ThreadPoolExecutor) obj2;
        }
        Object obj3 = sparseArray.get(3);
        if (obj3 != null) {
            this.hn = (ThreadPoolExecutor) obj3;
        }
        Object obj4 = sparseArray.get(4);
        if (obj4 != null) {
            this.x = (ScheduledExecutorService) obj4;
        }
        Object obj5 = sparseArray.get(5);
        if (obj5 != null) {
            this.c = (Handler) obj5;
        }
        Object obj6 = sparseArray.get(6);
        if (obj6 != null) {
            this.uc = (Handler) obj6;
        }
        Object obj7 = sparseArray.get(7);
        if (obj7 != null) {
            this.fw = (Handler) obj7;
        }
    }

    public SparseArray vk() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(1, this.pr);
        sparseArray.put(2, this.hw);
        sparseArray.put(3, this.hn);
        sparseArray.put(4, this.x);
        sparseArray.put(5, this.c);
        sparseArray.put(6, this.uc);
        sparseArray.put(7, this.fw);
        return sparseArray;
    }

    @Override // com.byazt.vkw.qi
    public ExecutorService pr() {
        if (this.pr == null) {
            this.pr = com.byazt.xlm.aj.hw.aj();
        }
        return this.pr;
    }

    @Override // com.byazt.vkw.qi
    public ExecutorService hw() {
        return com.byazt.xlm.aj.hw.m();
    }

    @Override // com.byazt.vkw.qi
    public ExecutorService hn() {
        if (this.hw == null) {
            this.hw = com.byazt.xlm.aj.hw.vk();
        }
        return this.hw;
    }

    @Override // com.byazt.vkw.qi
    public ExecutorService pr(int i, int i2) {
        return null;
    }

    @Override // com.byazt.vkw.qi
    public Handler x() {
        Handler handlerPr;
        if (this.fw == null) {
            synchronized (nt.class) {
                if (this.fw == null && (handlerPr = this.zo.pr("csj_io")) != null) {
                    this.fw = handlerPr;
                }
            }
        }
        return this.fw;
    }

    @Override // com.byazt.vkw.qi
    public Handler c() {
        Handler handlerPr;
        if (this.c == null) {
            synchronized (nt.class) {
                if (this.c == null && (handlerPr = this.zo.pr("csj_main")) != null) {
                    this.c = handlerPr;
                }
            }
        }
        return this.c;
    }

    @Override // com.byazt.vkw.qi
    public Handler uc() {
        if (this.uc == null) {
            synchronized (nt.class) {
                if (this.uc == null) {
                    this.uc = new Handler(Looper.getMainLooper());
                }
            }
        }
        return this.uc;
    }

    @Override // com.byazt.vkw.qi
    public ExecutorService fw() {
        if (this.hn == null) {
            this.hn = com.byazt.xlm.aj.hw.m();
        }
        return this.hn;
    }

    @Override // com.byazt.vkw.qi
    public ScheduledExecutorService zo() {
        if (this.x == null) {
            this.x = com.byazt.xlm.aj.hw.k();
        }
        return this.x;
    }

    @Override // com.byazt.vkw.qi
    public void pr(Runnable runnable, int i) {
        hn().execute(runnable);
    }

    @Override // com.byazt.vkw.qi
    public void pr(Runnable runnable) {
        hn().execute(runnable);
    }

    @Override // com.byazt.vkw.qi
    public void hw(Runnable runnable) {
        pr().execute(runnable);
    }

    @Override // com.byazt.vkw.qi
    public Handler pr(String str) {
        return this.zo.pr(str);
    }

    @Override // com.byazt.vkw.qi
    public Handler pr(qi.pr prVar, String str) {
        return this.zo.pr(prVar, str);
    }

    @Override // com.byazt.vkw.qi
    public void pr(Handler handler) {
        this.zo.pr(handler);
    }

    @Override // com.byazt.vkw.qi
    public void pr(JSONObject jSONObject) {
        com.byazt.xlm.aj.hw.pr(jSONObject);
    }

    @Override // com.byazt.vkw.qi
    public void hn(Runnable runnable) {
        x().post(runnable);
    }

    public void aj() {
        this.zo.hw();
    }
}
