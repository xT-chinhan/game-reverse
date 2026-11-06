package com.mcto.sspsdk.internal;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class t9 extends ContentObserver {
    public final /* synthetic */ x9 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t9(x9 x9Var, Handler handler) {
        super(handler);
        this.a = x9Var;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z, Uri uri) {
        onChange(z);
        x9 x9Var = this.a;
        int streamVolume = x9Var.b.getStreamVolume(3);
        int streamMaxVolume = x9Var.b.getStreamMaxVolume(3);
        float f = streamMaxVolume > 0 ? streamVolume / streamMaxVolume : 0.0f;
        x9 x9Var2 = this.a;
        if (x9Var2.h != f) {
            x9Var2.h = f;
            Float fValueOf = Float.valueOf(f);
            List list = (List) x9Var2.c.get("android.media.VOLUME_CHANGED_ACTION");
            if (list != null) {
                Iterator it = new ArrayList(list).iterator();
                while (it.hasNext()) {
                    ((w9) it.next()).a(fValueOf);
                }
            }
        }
    }
}
