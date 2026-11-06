package com.byazt.xv;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.tapsdk.tapad.group.constants.Constants;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 793, 61})
public class aj extends hw implements com.byazt.aa.aj.pr {
    public boolean k;
    public Handler m;
    public int w;

    public aj(Context context) {
        super(context);
        this.w = 500;
        this.m = new com.byazt.aa.aj(Looper.getMainLooper(), this);
    }

    @Override // com.byazt.xv.hw
    public boolean pr(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        Object obj = this.c.get(Constants.DELAY_FIELD);
        if (obj != null) {
            this.w = com.byazt.aa.hn.pr(String.valueOf(obj), 500);
        } else {
            this.w = 500;
        }
        return pr(this.hw, motionEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean pr(com.byazt.ik.hn hnVar, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.m.sendEmptyMessageDelayed(1102, this.w);
                return true;
            case 1:
                if (this.k && this.pr != null) {
                    this.pr.pr(this.hw, this.uc, this.hn.hw(), this.hn);
                    this.k = false;
                    Handler handler = this.m;
                    if (handler != null) {
                        handler.removeMessages(1102);
                    }
                    return true;
                }
                Handler handler2 = this.m;
                if (handler2 != null) {
                    handler2.removeMessages(1102);
                }
                this.k = false;
                return false;
            case 2:
            default:
                return true;
            case 3:
                Handler handler3 = this.m;
                if (handler3 != null) {
                    handler3.removeMessages(1102);
                }
                this.k = false;
                return true;
        }
    }

    @Override // com.byazt.aa.aj.pr
    public void pr(Message message) {
        switch (message.what) {
            case 1102:
                this.k = true;
                Handler handler = this.m;
                if (handler != null) {
                    handler.removeMessages(1102);
                }
                break;
        }
    }
}
