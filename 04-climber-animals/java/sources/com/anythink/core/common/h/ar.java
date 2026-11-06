package com.anythink.core.common.h;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.anythink.core.api.ATAdMultipleLoadedListener;
import com.anythink.core.api.ATAdRequest;
import com.anythink.core.basead.adx.api.ATAdxBidFloorInfo;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ar {
    public String a;
    public int c;
    public com.anythink.core.common.d.c d;
    public com.anythink.core.common.n e;
    public ATAdMultipleLoadedListener f;
    public Map<String, Object> g;
    public int h;
    public d i;
    public ATAdxBidFloorInfo l;
    public final h m;
    private Context p;
    private WeakReference<Activity> q;
    private ATAdRequest r;
    public int b = -1;
    public long n = 0;
    public long o = 0;
    public boolean j = false;
    public long k = SystemClock.elapsedRealtime();

    public ar() {
        h hVar = new h();
        this.m = hVar;
        hVar.a(System.currentTimeMillis());
    }

    public final void a(Context context) {
        this.p = com.anythink.core.common.d.t.b().g();
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        Activity activity = (Activity) context;
        this.q = new WeakReference<>(activity);
        com.anythink.core.common.d.t.b().a(activity);
    }

    public final Context a() {
        Activity activity;
        WeakReference<Activity> weakReference = this.q;
        if (weakReference != null && (activity = weakReference.get()) != null) {
            return activity;
        }
        Activity activityN = com.anythink.core.common.d.t.b().N();
        return activityN != null ? activityN : this.p;
    }

    public final ATAdRequest b() {
        return this.r;
    }

    public final void a(ATAdRequest aTAdRequest) {
        this.r = aTAdRequest;
    }

    private int f() {
        return this.c;
    }

    public final ar c() {
        ar arVar = new ar();
        arVar.p = this.p;
        arVar.q = this.q;
        arVar.c = this.c;
        arVar.d = this.d;
        arVar.e = this.e;
        arVar.g = this.g;
        arVar.h = this.h;
        arVar.r = this.r;
        return arVar;
    }

    public final boolean d() {
        int i = this.c;
        return i == 13 || i == 14;
    }

    private long g() {
        return this.n;
    }

    private void a(long j) {
        this.n = j;
    }

    private long h() {
        return this.o;
    }

    private void b(long j) {
        this.o = j;
    }

    public final boolean e() {
        int i = this.c;
        return (i == 9 || i == 13 || i == 14) ? false : true;
    }
}
