package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.component.utils.le;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class xr implements le.ms {
    private ms xr;
    private AtomicBoolean ah = new AtomicBoolean(true);

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    protected final le f2382ms = new le(Looper.getMainLooper(), this);
    private int d = 5;
    private int ka = 1;

    public interface ms {
        void ms();

        void ms(int i);
    }

    private void ah() {
        this.f2382ms.removeMessages(1);
        this.ka = 1;
    }

    public void ms() {
        ah();
    }

    public void ms(boolean z) {
        this.ah.set(z);
        if (!this.ah.get()) {
            d();
        } else {
            ka();
        }
    }

    private void d() {
        try {
            this.f2382ms.removeMessages(1);
        } catch (Throwable unused) {
        }
    }

    private void ka() {
        try {
            this.f2382ms.sendEmptyMessage(1);
        } catch (Throwable unused) {
        }
    }

    public void xr() {
        ah();
        this.f2382ms.sendEmptyMessage(1);
    }

    public void ms(ms msVar) {
        this.xr = msVar;
    }

    public void ms(int i) {
        this.d = i;
        ah();
    }

    @Override // com.bytedance.sdk.component.utils.le.ms
    public void ms(Message message) {
        if (message.what == 1) {
            c();
        }
    }

    private void c() {
        try {
            int i = this.ka;
            if (i >= this.d + 1) {
                ms msVar = this.xr;
                if (msVar != null) {
                    msVar.ms();
                    return;
                }
                return;
            }
            int i2 = i + 1;
            this.ka = i2;
            ms msVar2 = this.xr;
            if (msVar2 != null) {
                msVar2.ms(i2);
            }
            this.f2382ms.sendEmptyMessageDelayed(1, 1000L);
        } catch (Exception unused) {
        }
    }
}
