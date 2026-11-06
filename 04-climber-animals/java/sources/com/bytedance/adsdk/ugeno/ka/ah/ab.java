package com.bytedance.adsdk.ugeno.ka.ah;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.c.ny;

/* JADX INFO: loaded from: classes2.dex */
public class ab extends ms implements ny.ms {
    private int hi;
    private Handler sl;

    public ab(Context context) {
        super(context);
        this.hi = 500;
        this.sl = new ny(Looper.getMainLooper(), this);
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
            this.sl.sendEmptyMessageDelayed(1101, this.hi);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        this.sl.removeMessages(1101);
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.c.ny.ms
    public void ms(Message message) {
        if (message.what != 1101) {
            return;
        }
        if (this.f360ms != null) {
            this.f360ms.ms(this.xr, this.c, this.ah.xr());
        }
        Handler handler = this.sl;
        if (handler != null) {
            handler.removeMessages(1101);
        }
    }
}
