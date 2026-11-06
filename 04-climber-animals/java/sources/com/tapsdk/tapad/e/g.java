package com.tapsdk.tapad.e;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class g {
    private static final long g = 300000;
    private static final long h = 5000;
    private static final String i = "android.permission.QUERY_ALL_PACKAGES";
    private static final List<String> j = new ArrayList();
    private final AtomicBoolean a;
    private volatile CopyOnWriteArrayList<String> b;
    private final AtomicBoolean c;
    private final AtomicBoolean d;
    private final AtomicBoolean e;
    private volatile long f;

    class a implements ObservableOnSubscribe<List<String>> {
        final /* synthetic */ boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<List<String>> observableEmitter) throws Exception {
            g.this.a(this.a);
            observableEmitter.onNext(this.a ? g.this.h() : g.j);
            observableEmitter.onComplete();
        }
    }

    static class b {
        public static g a = new g(null);

        b() {
        }
    }

    private g() {
        this.a = new AtomicBoolean(false);
        this.b = new CopyOnWriteArrayList<>();
        this.c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        this.e = new AtomicBoolean(false);
        this.f = -1L;
    }

    /* synthetic */ g(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.d.set(z);
        try {
            if (com.tapsdk.tapad.c.a != null) {
                Context context = com.tapsdk.tapad.c.a;
                context.getPackageManager().checkPermission(i, context.getPackageName());
                if (Build.VERSION.SDK_INT <= 29) {
                    this.c.set(true);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static g d() {
        return b.a;
    }

    public void a(String str) {
        if (this.b == null) {
            this.b = new CopyOnWriteArrayList<>();
        }
        if (str == null || str.length() <= 0 || this.b.contains(str)) {
            return;
        }
        this.b.add(str);
    }

    public Observable<List<String>> b(boolean z) {
        return Observable.create(new a(z));
    }

    public List<String> b() {
        return this.b != null ? this.b : j;
    }

    public void b(String str) {
        if (this.b == null || str == null || str.length() <= 0) {
            return;
        }
        this.b.remove(str);
    }

    public String[] c() {
        if (this.b == null || this.b.size() == 0) {
            return new String[0];
        }
        String[] strArr = new String[this.b.size()];
        this.b.toArray(strArr);
        return strArr;
    }

    public boolean e() {
        return this.c.get();
    }

    public boolean f() {
        return this.b != null && this.b.size() > 0;
    }

    public boolean g() {
        return this.d.get();
    }

    /* JADX WARN: Code duplicated, block: B:34:0x008f  */
    public List<String> h() {
        if (this.a.get()) {
            return j;
        }
        this.a.set(true);
        long j2 = this.e.get() ? g : 5000L;
        if (this.e.get() && this.f != -1 && System.currentTimeMillis() - this.f < j2) {
            return this.b;
        }
        List<PackageInfo> listD = com.tapsdk.tapad.internal.utils.d.d(com.tapsdk.tapad.c.a);
        HashSet hashSet = new HashSet();
        for (PackageInfo packageInfo : listD) {
            if ((packageInfo.applicationInfo.flags & 1) == 0) {
                hashSet.add(packageInfo.packageName);
            }
        }
        if (hashSet.size() > 0) {
            if (hashSet.size() == 1) {
                Iterator it = hashSet.iterator();
                String packageName = com.tapsdk.tapad.c.a.getPackageName();
                if (packageName != null) {
                    if (packageName.equals(it.next())) {
                        this.c.set(false);
                    } else {
                        this.c.set(true);
                    }
                }
            } else {
                this.c.set(true);
            }
            if (this.c.get()) {
                this.b = new CopyOnWriteArrayList<>(hashSet);
                this.e.set(true);
            }
        } else {
            this.c.set(false);
        }
        this.f = System.currentTimeMillis();
        this.a.set(false);
        return this.b;
    }
}
