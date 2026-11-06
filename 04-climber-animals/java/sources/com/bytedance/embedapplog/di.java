package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
final class di {
    static pl ms(Context context) {
        if (ny.c()) {
            return new kk(new hi());
        }
        if (ny.ab() && hi.ms()) {
            return new hi();
        }
        if (wp.ms()) {
            return new wp(context);
        }
        if (ny.ah() && ny.d()) {
            return new gs();
        }
        if (ny.ah() && !ny.d()) {
            return new qo();
        }
        if (ny.ms(context) || ny.ah()) {
            return new gs();
        }
        if (ny.ny()) {
            return new kk();
        }
        if (ny.x()) {
            return new cj();
        }
        if (Build.VERSION.SDK_INT > 28) {
            if (ny.ch()) {
                return new zx();
            }
            if (ny.sl()) {
                return new wq();
            }
            if (ny.hi()) {
                return new cc();
            }
            if (ny.zb()) {
                return new ul();
            }
            ec ecVar = new ec(context);
            return ecVar.ms(context) ? ecVar : new n();
        }
        if (ny.ka() || !gs.ah(context)) {
            return null;
        }
        return new gs();
    }
}
