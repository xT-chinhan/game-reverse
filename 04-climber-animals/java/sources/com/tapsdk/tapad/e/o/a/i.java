package com.tapsdk.tapad.e.o.a;

import android.content.Context;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.utils.r;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
public class i<T> extends c<T> implements d<T> {
    final com.tapsdk.tapad.e.o.a.a b;
    final WeakReference<Context> c;

    class a implements com.tapsdk.tapad.e.o.a.a.d {
        final /* synthetic */ e a;

        a(e eVar) {
            this.a = eVar;
        }

        @Override // com.tapsdk.tapad.e.o.a.a.d
        public void a(k kVar) {
            Boolean bool = kVar.b() == 0 ? Boolean.TRUE : Boolean.FALSE;
            if (bool.booleanValue()) {
                com.tapsdk.tapad.e.o.a.l.a.c("Init success");
                this.a.a(new b.a<>(kVar, bool));
            } else {
                com.tapsdk.tapad.e.o.a.l.a.c("Init fail");
                this.a.a(kVar.b(), kVar.a());
            }
        }
    }

    public i(com.tapsdk.tapad.e.o.a.a aVar, Context context) {
        this.b = aVar;
        this.c = new WeakReference<>(context);
    }

    @Override // com.tapsdk.tapad.e.o.a.d
    public void a(e<T> eVar) {
        com.tapsdk.tapad.e.o.a.l.a.c("Init task enqueue:isMainThread（" + r.b() + "),threadId:" + Thread.currentThread().getId());
        if (eVar != null) {
            if (this.c.get() != null) {
                this.b.a(new a(eVar), this.c.get());
            } else {
                eVar.a(1000, Constants.l.d);
            }
        }
    }

    @Override // com.tapsdk.tapad.e.o.a.d
    public void cancel() {
    }

    @Override // com.tapsdk.tapad.e.o.a.d
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public d<T> m40clone() {
        return new i(this.b, this.c.get());
    }
}
