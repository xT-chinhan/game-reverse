package com.byazt.xv;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.tapsdk.tapad.group.constants.Constants;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 793, 50})
public class vk extends hw implements com.byazt.aa.aj.pr {
    public Handler k;
    public int w;

    public vk(Context context) {
        super(context);
        this.w = 500;
        this.k = new com.byazt.aa.aj(Looper.getMainLooper(), this);
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

    private boolean pr(com.byazt.ik.hn hnVar, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.k.sendEmptyMessageDelayed(1101, this.w);
                break;
            case 1:
            case 3:
                this.k.removeMessages(1101);
                break;
        }
        return false;
    }

    @Override // com.byazt.aa.aj.pr
    public void pr(Message message) {
        switch (message.what) {
            case 1101:
                if (this.pr != null) {
                    this.pr.pr(this.hw, this.uc, this.hn.hw(), this.hn);
                }
                Handler handler = this.k;
                if (handler != null) {
                    handler.removeMessages(1101);
                }
                break;
        }
    }
}
