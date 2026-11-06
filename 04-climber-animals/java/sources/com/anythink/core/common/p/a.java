package com.anythink.core.common.p;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.api.AdError;
import com.anythink.core.common.d.t;
import com.anythink.core.common.f;
import com.anythink.core.common.h.ar;
import com.anythink.core.common.u;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class a implements d {
    String b;
    String c;
    b d;
    long f;
    private ATAdRequest i;
    String a = "a";
    AtomicBoolean e = new AtomicBoolean(false);
    long g = com.anythink.basead.exoplayer.i.a.f;
    com.anythink.core.common.t.b h = new com.anythink.core.common.t.b() { // from class: com.anythink.core.common.p.a.1
        @Override // java.lang.Runnable
        public final void run() {
            a.this.e();
        }
    };

    public a(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e() {
        if (b()) {
            if (this.e.get()) {
                this.e.set(false);
                if (this.f == 0 || SystemClock.elapsedRealtime() - this.f > this.g) {
                    this.f = SystemClock.elapsedRealtime();
                    a(t.b().M(), this.i, 4);
                }
            }
        }
    }

    @Override // com.anythink.core.common.p.d
    public final synchronized void a(int i) {
        if (this.e.get()) {
            return;
        }
        this.e.set(true);
        com.anythink.core.common.t.d.a().a(this.h, ((long) Math.pow(2.0d, i)) * 1000, false);
    }

    public final ATAdRequest a() {
        return this.i;
    }

    @Override // com.anythink.core.common.p.d
    public final void a(Context context, ATAdRequest aTAdRequest, int i) {
        this.i = aTAdRequest;
        ar arVar = new ar();
        arVar.a(context);
        arVar.a(aTAdRequest);
        arVar.c = i;
        f.a(context, this.b, this.c).b(context, this.c, this.b, arVar, null);
    }

    @Override // com.anythink.core.common.p.d
    public final boolean b() {
        return u.a().e(this.b);
    }

    @Override // com.anythink.core.common.p.d
    public final void c() {
        b bVar;
        if (!b() || (bVar = this.d) == null) {
            return;
        }
        bVar.a(this.b);
    }

    @Override // com.anythink.core.common.p.d
    public final void a(AdError adError, int i, boolean z) {
        if (b()) {
            if (z) {
                a(i);
            }
            b bVar = this.d;
            if (bVar != null) {
                bVar.a(this.b, adError);
            }
        }
    }

    @Override // com.anythink.core.common.p.d
    public final synchronized void d() {
        this.e.set(false);
        com.anythink.core.common.t.d.a().b(this.h);
    }

    @Override // com.anythink.core.common.p.d
    public final void a(b bVar) {
        this.d = bVar;
    }

    @Override // com.anythink.core.common.p.d
    public final boolean a(int i, List<String> list) {
        String str;
        if (list == null) {
            return true;
        }
        if (i == 4) {
            str = "1";
        } else if (i == 5) {
            str = "2";
        } else if (i != 6) {
            str = i != 7 ? "-1" : "4";
        } else {
            str = "3";
        }
        if (TextUtils.equals(str, "-1")) {
            new StringBuilder("canLoadInAutoLoadMode, error load type: ").append(i).append(", 'autoload_t': ").append(list);
            return true;
        }
        if (list.contains(str)) {
            new StringBuilder("canLoadInAutoLoadMode, timing: ").append(str).append(", 'autoload_t': ").append(list);
            return true;
        }
        new StringBuilder("canLoadInAutoLoadMode, , timing: ").append(str).append(", 'autoload_t': ").append(list);
        return false;
    }
}
