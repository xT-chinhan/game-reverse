package com.byazt.vkw;

import android.os.Handler;
import android.util.SparseArray;
import com.byazt.mrs.DownloadStatus;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1069, MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND})
public class of implements qi, Function {
    public volatile qi hw;
    public volatile Function pr;

    public of(qi qiVar) {
        this.hw = qiVar;
    }

    public of(Function function) {
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

    @Override // com.byazt.vkw.qi
    public Handler c() {
        if (this.hw != null) {
            return this.hw.c();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (Handler) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.qi
    public ExecutorService fw() {
        if (this.hw != null) {
            return this.hw.fw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return (ExecutorService) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.qi
    public ExecutorService hn() {
        if (this.hw != null) {
            return this.hw.hn();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (ExecutorService) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.qi
    public void hn(Runnable runnable) {
        if (this.hw != null) {
            this.hw.hn(runnable);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        sparseArray.put(1, runnable);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.qi
    public ExecutorService hw() {
        if (this.hw != null) {
            return this.hw.hw();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (ExecutorService) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.qi
    public void hw(Runnable runnable) {
        if (this.hw != null) {
            this.hw.hw(runnable);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, runnable);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.qi
    public Handler pr(qi.pr prVar, String str) {
        if (this.hw != null) {
            return this.hw.pr(prVar, str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        if (prVar != null) {
            prVar = new qn(prVar);
        }
        sparseArray.put(1, prVar);
        sparseArray.put(2, str);
        return (Handler) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.qi
    public Handler pr(String str) {
        if (this.hw != null) {
            return this.hw.pr(str);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, str);
        return (Handler) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.qi
    public ExecutorService pr() {
        if (this.hw != null) {
            return this.hw.pr();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (ExecutorService) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.qi
    public ExecutorService pr(int i, int i2) {
        if (this.hw != null) {
            return this.hw.pr(i, i2);
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(2, Integer.valueOf(i2));
        return (ExecutorService) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.qi
    public void pr(Handler handler) {
        if (this.hw != null) {
            this.hw.pr(handler);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, handler);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.qi
    public void pr(Runnable runnable) {
        if (this.hw != null) {
            this.hw.pr(runnable);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, runnable);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.qi
    public void pr(Runnable runnable, int i) {
        if (this.hw != null) {
            this.hw.pr(runnable, i);
            return;
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, runnable);
        sparseArray.put(2, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.qi
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

    @Override // com.byazt.vkw.qi
    public Handler uc() {
        if (this.hw != null) {
            return this.hw.uc();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (Handler) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.qi
    public Handler x() {
        if (this.hw != null) {
            return this.hw.x();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (Handler) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.vkw.qi
    public ScheduledExecutorService zo() {
        if (this.hw != null) {
            return this.hw.zo();
        }
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return (ScheduledExecutorService) this.pr.apply(sparseArray);
    }
}
