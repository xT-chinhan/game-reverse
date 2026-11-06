package com.bytedance.adsdk.ugeno.ka.ah;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.c.ny;

/* JADX INFO: loaded from: classes2.dex */
public class c extends ms implements ny.ms {
    private int hi;
    private boolean sl;
    private Handler zb;

    public c(Context context) {
        super(context);
        this.hi = 500;
        this.zb = new ny(Looper.getMainLooper(), this);
    }

    @Override // com.bytedance.adsdk.ugeno.ka.ah.ms
    public boolean ms(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        this.hi = com.bytedance.adsdk.ugeno.c.ah.ms(this.ka.get("delay"), 500);
        return ms(this.xr, motionEvent);
    }

    private boolean ms(com.bytedance.adsdk.ugeno.xr.ah ahVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zb.sendEmptyMessageDelayed(1102, this.hi);
        } else {
            if (action == 1) {
                if (this.sl && this.f360ms != null) {
                    this.f360ms.ms(this.xr, this.c, this.ah.xr());
                    this.sl = false;
                    Handler handler = this.zb;
                    if (handler != null) {
                        handler.removeMessages(1102);
                    }
                    return true;
                }
                Handler handler2 = this.zb;
                if (handler2 != null) {
                    handler2.removeMessages(1102);
                }
                this.sl = false;
                return false;
            }
            if (action == 3) {
                Handler handler3 = this.zb;
                if (handler3 != null) {
                    handler3.removeMessages(1102);
                }
                this.sl = false;
            }
        }
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.c.ny.ms
    public void ms(Message message) {
        if (message.what != 1102) {
            return;
        }
        this.sl = true;
        Handler handler = this.zb;
        if (handler != null) {
            handler.removeMessages(1102);
        }
    }
}
