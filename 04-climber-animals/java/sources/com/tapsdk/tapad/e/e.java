package com.tapsdk.tapad.e;

import android.location.Location;
import android.util.Pair;
import com.tapsdk.tapad.TapAdLocation;
import com.tapsdk.tapad.internal.Callback;
import com.tapsdk.tapad.internal.utils.TapADLogger;

/* JADX INFO: loaded from: classes3.dex */
public class e {
    private volatile boolean a;
    private long b;
    private long c;
    private TapAdLocation d;
    private TapAdLocation e;

    class a implements Callback<Location> {
        a() {
        }

        @Override // com.tapsdk.tapad.internal.Callback
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Location location) {
            TapADLogger.d("getLocation onSuccess:" + location);
            e.this.d = new TapAdLocation(location.getLatitude(), location.getLongitude(), location.getAccuracy());
            e.this.a = false;
            e.this.c = System.currentTimeMillis() - e.this.b;
            e.this.b = -1L;
        }

        @Override // com.tapsdk.tapad.internal.Callback
        public void onFail(Exception exc) {
            TapADLogger.d("getLocation fail:" + (exc != null ? exc.getMessage() : ""));
            e.this.a = false;
            e.this.b = -1L;
        }
    }

    static class b {
        public static e a = new e(null);

        b() {
        }
    }

    private e() {
        this.a = false;
        this.b = -1L;
        this.c = 0L;
        this.d = null;
        this.e = null;
    }

    /* synthetic */ e(a aVar) {
        this();
    }

    public static e b() {
        return b.a;
    }

    public Pair<TapAdLocation, Long> a() {
        TapAdLocation tapAdLocation = this.d;
        if (tapAdLocation == null) {
            tapAdLocation = this.e;
        }
        return Pair.create(tapAdLocation, Long.valueOf(this.c));
    }

    public void a(TapAdLocation tapAdLocation) {
        this.e = tapAdLocation;
        this.c = 0L;
    }

    public void c() {
        synchronized (e.class) {
            if (!this.a) {
                this.a = true;
                this.b = System.currentTimeMillis();
                TapADLogger.d("start getLocation");
                com.tapsdk.tapad.internal.utils.d.a(com.tapsdk.tapad.c.a, new a());
            }
        }
    }
}
