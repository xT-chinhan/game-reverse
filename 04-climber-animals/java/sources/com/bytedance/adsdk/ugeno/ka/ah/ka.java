package com.bytedance.adsdk.ugeno.ka.ah;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.c.ny;

/* JADX INFO: loaded from: classes2.dex */
public class ka extends ms implements ny.ms {
    private int hi;
    private int sl;
    private int u;
    private Handler zb;

    public ka(Context context) {
        super(context);
        this.sl = 0;
        this.zb = new ny(Looper.getMainLooper(), this);
        this.u = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.ka.ah.ms
    public boolean ms(Object... objArr) {
        if (this.ka != null) {
            int iMs = com.bytedance.adsdk.ugeno.c.ah.ms(this.ka.get("loop"), 0);
            this.hi = iMs;
            if (iMs <= 0) {
                this.u = -1;
            } else {
                this.u = iMs;
            }
            this.sl = com.bytedance.adsdk.ugeno.c.ah.ms(this.ka.get("duration"), 0);
        }
        this.zb.sendEmptyMessageDelayed(1001, this.sl);
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.c.ny.ms
    public void ms(Message message) {
        int i;
        int i2;
        if (message.what != 1001) {
            return;
        }
        this.f360ms.ms(this.xr, this.c, this.ah.xr());
        int i3 = this.u - 1;
        this.u = i3;
        if (i3 < 0 && (i2 = this.sl) != 0) {
            this.zb.sendEmptyMessageDelayed(1001, i2);
        } else if (i3 > 0 && (i = this.sl) != 0) {
            this.zb.sendEmptyMessageDelayed(1001, i);
        } else {
            this.zb.removeMessages(1001);
        }
    }
}
