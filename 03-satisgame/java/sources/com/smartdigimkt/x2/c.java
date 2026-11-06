package com.smartdigimkt.x2;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.smartdigimkt.z.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public final IntentFilter a;
    public final BroadcastReceiver b;
    public boolean c;
    public boolean d;

    public c(IntentFilter intentFilter, f0 f0Var) {
        this.a = intentFilter;
        this.b = f0Var;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(this.b);
        sb.append(" filter=");
        sb.append(this.a);
        if (this.d) {
            sb.append(" DEAD");
        }
        sb.append("}");
        return sb.toString();
    }
}
