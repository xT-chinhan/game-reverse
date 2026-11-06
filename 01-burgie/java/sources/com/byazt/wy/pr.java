package com.byazt.wy;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.byazt.vkw.qi;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1595, 37})
public final class pr {
    public static final pr pr = new pr();
    public volatile x<hw> hw = x.pr(2);

    public static pr pr() {
        return pr;
    }

    public hw pr(qi.pr prVar, final String str) {
        hw hwVar;
        if (this.hw == null) {
            hwVar = null;
        } else {
            hwVar = (hw) this.hw.pr();
        }
        if (hwVar != null) {
            hwVar.pr(prVar);
            hwVar.post(new Runnable() { // from class: com.byazt.wy.pr.1
                @Override // java.lang.Runnable
                public void run() {
                    Thread.currentThread().setName(str);
                }
            });
            return hwVar;
        }
        return hw(prVar, str);
    }

    public Handler pr(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "csj-handler";
        }
        return pr(null, str);
    }

    private hw hw(qi.pr prVar, String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        try {
            handlerThread.start();
            return new hw(handlerThread.getLooper(), prVar);
        } catch (InternalError e) {
            return null;
        }
    }

    public boolean pr(Handler handler) {
        if (this.hw == null) {
            if (handler != null) {
                handler.getLooper().quit();
            }
            return false;
        }
        if (!(handler instanceof hw)) {
            return false;
        }
        hw hwVar = (hw) handler;
        if (!this.hw.pr(hwVar)) {
            hwVar.hw();
            return true;
        }
        return true;
    }

    public void hw() {
        pr(0);
        this.hw = null;
    }

    private void pr(int i) {
        hw hwVar;
        while (this.hw.hw() > i && (hwVar = (hw) this.hw.pr()) != null) {
            hwVar.hw();
        }
    }
}
