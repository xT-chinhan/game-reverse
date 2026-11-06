package com.smartdigimkt.q;

import android.content.Context;
import com.smartdigimkt.odopt.api.ATOaidBindHandler;
import com.smartdigimkt.r.e0;
import com.smartdigimkt.r.h;
import com.smartdigimkt.r.j0;
import com.smartdigimkt.r.m;
import com.smartdigimkt.r.m0;
import com.smartdigimkt.r.s;
import com.smartdigimkt.r.w;
import com.smartdigimkt.r.z;
import com.smartdigimkt.t.f;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {
    public final /* synthetic */ a a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;

    public c(a aVar, Context context, String str) {
        this.a = aVar;
        this.b = context;
        this.c = str;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x009b  */
    @Override // java.lang.Runnable
    public final void run() {
        b bVar = new b(this);
        try {
            switch (this.c) {
                case "ASUS":
                    new com.smartdigimkt.r.b(this.b).a(bVar);
                    break;
                case "OPPO":
                case "ONEPLUS":
                case "REALME":
                    if (!new z(this.b).a(bVar)) {
                        new e0(this.b).a(bVar);
                        break;
                    }
                    break;
                case "HUAWEI":
                    new m(this.b).a(bVar);
                    break;
                case "SAMSUNG":
                    new j0(this.b).a(bVar);
                    break;
                case "LENOVO":
                case "MOTOLORA":
                    new m0(this.b).a(bVar);
                    break;
                case "MEIZU":
                    new w(this.b).a(bVar);
                    break;
                case "FREEME":
                    new h(this.b).a(bVar);
                    break;
                case "COOLPAD":
                    new com.smartdigimkt.r.c(this.b).a(bVar);
                    break;
                case "COOLSEA":
                    new com.smartdigimkt.r.d(this.b).a(bVar);
                    break;
                case "HONOR":
                    new s(this.b).a(bVar);
                    break;
                default:
                    ATOaidBindHandler.handleInitOaidBind(this.b, this.a);
                    break;
            }
        } catch (Throwable th) {
            f.a(5, th.getMessage());
            a aVar = this.a;
            if (aVar != null) {
                aVar.a(th.getMessage());
            }
        }
    }
}
