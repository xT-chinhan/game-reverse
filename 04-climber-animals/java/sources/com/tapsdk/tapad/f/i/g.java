package com.tapsdk.tapad.f.i;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Looper;
import com.tapsdk.tapad.oaid.huawei.AdvertisingIdClient;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes3.dex */
class g implements com.tapsdk.tapad.f.b {
    private final Context a;
    private final Handler b = new Handler(Looper.getMainLooper());

    class a implements Runnable {
        final /* synthetic */ com.tapsdk.tapad.f.a a;

        a(com.tapsdk.tapad.f.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.b(this.a);
        }
    }

    class b implements Runnable {
        final /* synthetic */ com.tapsdk.tapad.f.a a;
        final /* synthetic */ String b;

        b(com.tapsdk.tapad.f.a aVar, String str) {
            this.a = aVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b);
        }
    }

    class c implements Runnable {
        final /* synthetic */ com.tapsdk.tapad.f.a a;
        final /* synthetic */ com.tapsdk.tapad.f.c b;

        c(com.tapsdk.tapad.f.a aVar, com.tapsdk.tapad.f.c cVar) {
            this.a = aVar;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b);
        }
    }

    public g(Context context) {
        this.a = context;
    }

    private void a(com.tapsdk.tapad.f.a aVar, com.tapsdk.tapad.f.c cVar) {
        this.b.post(new c(aVar, cVar));
    }

    private void a(com.tapsdk.tapad.f.a aVar, String str) {
        this.b.post(new b(aVar, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.tapsdk.tapad.f.a aVar) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.a);
            if (advertisingIdInfo == null) {
                a(aVar, new com.tapsdk.tapad.f.c("Advertising identifier info is null"));
            } else if (advertisingIdInfo.isLimitAdTrackingEnabled()) {
                a(aVar, new com.tapsdk.tapad.f.c("User has disabled advertising identifier"));
            } else {
                a(aVar, advertisingIdInfo.getId());
            }
        } catch (Throwable th) {
            a(aVar, new com.tapsdk.tapad.f.c(th));
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a() {
        try {
            if (AdvertisingIdClient.isAdvertisingIdAvailable(this.a)) {
                return;
            }
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null && packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null && packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                throw new com.tapsdk.tapad.f.c("com.huawei 不支持 oaid 接口");
            }
        } catch (Throwable th) {
            throw new com.tapsdk.tapad.f.c(th);
        }
    }

    @Override // com.tapsdk.tapad.f.b
    public void a(com.tapsdk.tapad.f.a aVar) {
        Executors.newSingleThreadExecutor().execute(new a(aVar));
    }

    @Override // com.tapsdk.tapad.f.b
    public String l() {
        return "Huawei";
    }
}
