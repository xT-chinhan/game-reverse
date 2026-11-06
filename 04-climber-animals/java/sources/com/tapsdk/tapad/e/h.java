package com.tapsdk.tapad.e;

import android.content.Context;
import android.text.TextUtils;
import com.tapsdk.tapad.constants.Constants;
import com.tapsdk.tapad.internal.utils.TapADLogger;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public class h {
    private static final String d = "OaidModel";
    private static final String e = "sp_oaid";
    private static volatile boolean f = false;
    private final com.tapsdk.tapad.e.o.a.a a;
    private final Scheduler b;
    private volatile String c;

    class a implements ObservableOnSubscribe<String> {
        final /* synthetic */ com.tapsdk.tapad.internal.u.a a;

        a(com.tapsdk.tapad.internal.u.a aVar) {
            this.a = aVar;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
            try {
                observableEmitter.onNext(h.this.b(this.a));
                observableEmitter.onComplete();
            } catch (Throwable th) {
                observableEmitter.onError(th);
            }
        }
    }

    class b implements Function<Boolean, ObservableSource<? extends String>> {
        final /* synthetic */ ObservableOnSubscribe a;

        b(ObservableOnSubscribe observableOnSubscribe) {
            this.a = observableOnSubscribe;
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ObservableSource<? extends String> apply(Boolean bool) throws Exception {
            return bool.booleanValue() ? Observable.create(this.a) : Observable.error(new com.tapsdk.tapad.e.o.a.g(1000, Constants.l.d));
        }
    }

    class c implements Consumer<String> {
        final /* synthetic */ CountDownLatch a;

        c(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            com.tapsdk.tapad.e.o.a.l.a.c("The OAID configuration of media is complete:" + str);
            h.this.c = str;
            this.a.countDown();
        }
    }

    class d implements Consumer<Throwable> {
        final /* synthetic */ CountDownLatch a;

        d(CountDownLatch countDownLatch) {
            this.a = countDownLatch;
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.a.countDown();
        }
    }

    class e implements Consumer<String> {
        e() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
        }
    }

    class f implements Consumer<Throwable> {
        f() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    class g implements Runnable {
        final /* synthetic */ com.tapsdk.tapad.f.i.l a;

        g(com.tapsdk.tapad.f.i.l lVar) {
            this.a = lVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.a(this.a);
        }
    }

    /* JADX INFO: renamed from: com.tapsdk.tapad.e.h$h, reason: collision with other inner class name */
    class C0589h implements com.tapsdk.tapad.f.a {
        final /* synthetic */ com.tapsdk.tapad.f.i.l a;

        C0589h(com.tapsdk.tapad.f.i.l lVar) {
            this.a = lVar;
        }

        @Override // com.tapsdk.tapad.f.a
        public void a(Exception exc) {
            this.a.a(exc);
        }

        @Override // com.tapsdk.tapad.f.a
        public void a(String str) {
            this.a.a(str);
            TapADLogger.i("oaid_manufacturer:" + str);
        }
    }

    static class i {
        public static h a = new h(null);

        i() {
        }
    }

    static class j implements Function<Observable<Throwable>, Observable<?>> {
        private final int a;
        private final int b;
        private int c = 0;

        class a implements Function<Throwable, ObservableSource<?>> {
            a() {
            }

            @Override // io.reactivex.functions.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ObservableSource<?> apply(Throwable th) throws Exception {
                if (j.b(j.this) > j.this.a) {
                    return Observable.error(th);
                }
                com.tapsdk.tapad.e.o.a.l.a.c("重试第 " + j.this.c + " 次, 等待 " + j.this.b + " 毫秒后重试");
                return Observable.timer(j.this.b, TimeUnit.MILLISECONDS);
            }
        }

        public j(int i, int i2, TimeUnit timeUnit) {
            this.a = i;
            this.b = (int) timeUnit.toMillis(i2);
        }

        static /* synthetic */ int b(j jVar) {
            int i = jVar.c + 1;
            jVar.c = i;
            return i;
        }

        @Override // io.reactivex.functions.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Observable<?> apply(Observable<Throwable> observable) {
            return observable.flatMap(new a());
        }
    }

    private h() {
        this.b = Schedulers.from(Executors.newSingleThreadExecutor());
        this.a = new com.tapsdk.tapad.e.o.a.a();
    }

    /* synthetic */ h(a aVar) {
        this();
    }

    private Observable<String> a(com.tapsdk.tapad.internal.u.a aVar) {
        return Observable.create(new a(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.tapsdk.tapad.f.i.l lVar) {
        com.tapsdk.tapad.f.b bVarA = lVar.a();
        if (bVarA == null) {
            return;
        }
        bVarA.a(new C0589h(lVar));
    }

    public static void a(boolean z) {
        f = z;
    }

    public static h b() {
        return i.a;
    }

    private Observable<String> b(Context context) {
        return a(context).flatMap(new b(new com.tapsdk.tapad.e.o.a.j(new com.tapsdk.tapad.e.o.a.f(new com.tapsdk.tapad.e.o.a.h(this.a, context)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(com.tapsdk.tapad.internal.u.a aVar) throws TimeoutException {
        String strC = "";
        try {
            strC = c();
        } catch (Error | Exception e2) {
            try {
                TapADLogger.e(e2.toString());
            } catch (Error | Exception unused) {
            }
        }
        if (!TextUtils.isEmpty(strC)) {
            this.c = strC;
        }
        if (TextUtils.isEmpty(strC)) {
            TapADLogger.d("Get OAID through ExpOAIDClient");
            CountDownLatch countDownLatch = new CountDownLatch(1);
            b(com.tapsdk.tapad.c.a).retryWhen(new j(f ? 0 : 2, 100, TimeUnit.MILLISECONDS)).subscribe(new c(countDownLatch), new d(countDownLatch));
            countDownLatch.await();
        }
        if (aVar != null && this.c != null && this.c.length() > 0) {
            aVar.b(e, this.c);
        }
        return strC;
    }

    private String c() {
        try {
            Method declaredMethod = Class.forName("com.tds.tapdb.internal.OaidHelper").getDeclaredMethod("getOAID", Context.class);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, com.tapsdk.tapad.c.a);
        } catch (Exception e2) {
            TapADLogger.e(e2.getMessage());
            return "";
        }
    }

    public Observable<Boolean> a(Context context) {
        return Observable.create(new com.tapsdk.tapad.e.o.a.j(new com.tapsdk.tapad.e.o.a.f(new com.tapsdk.tapad.e.o.a.i(this.a, context))));
    }

    public synchronized String a() {
        TapADLogger.d("Get oaid from memory begin");
        if (this.c != null && this.c.length() > 0) {
            TapADLogger.d("Get oaid from memory success: (cachedOaId " + this.c + ")");
            return this.c;
        }
        if (!com.tapsdk.tapad.internal.u.a.b()) {
            com.tapsdk.tapad.internal.u.a.a(com.tapsdk.tapad.c.a);
        }
        com.tapsdk.tapad.internal.u.a aVarB = com.tapsdk.tapad.internal.u.a.b(d);
        TapADLogger.d("Get oaid from sp begin");
        if (aVarB != null) {
            TapADLogger.d("oaidSp not null");
            String strA = aVarB.a(e, "");
            if (strA != null && strA.length() > 0) {
                this.c = strA;
                TapADLogger.d("Get oaid from sp success: (cachedOaId " + this.c + ")");
                return this.c;
            }
        }
        return this.c;
    }

    public void a(String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        this.c = str;
        if (!com.tapsdk.tapad.internal.u.a.b()) {
            com.tapsdk.tapad.internal.u.a.a(com.tapsdk.tapad.c.a);
        }
        com.tapsdk.tapad.internal.u.a aVarB = com.tapsdk.tapad.internal.u.a.b(d);
        if (aVarB != null) {
            aVarB.b(e, str);
        }
    }

    public void b(com.tapsdk.tapad.f.i.l lVar) {
        if (TextUtils.isEmpty(lVar.b())) {
            new Thread(new g(lVar)).start();
        }
    }

    public void d() {
        if (!com.tapsdk.tapad.internal.u.a.b()) {
            com.tapsdk.tapad.internal.u.a.a(com.tapsdk.tapad.c.a);
        }
        a(com.tapsdk.tapad.internal.u.a.b(d)).subscribeOn(this.b).subscribe(new e(), new f());
    }

    public void e() {
    }
}
