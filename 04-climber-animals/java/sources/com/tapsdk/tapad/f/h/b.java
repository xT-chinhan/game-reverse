package com.tapsdk.tapad.f.h;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.umeng.analytics.pro.bk;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    public com.tapsdk.tapad.f.h.a.C0596a a;
    public Context b;
    public final a c = new a(this);
    public final BinderC0597b d = new BinderC0597b(this);
    public final CountDownLatch e = new CountDownLatch(2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static class a extends com.tapsdk.tapad.f.h.c.a.AbstractBinderC0598a {
        public final b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // com.tapsdk.tapad.f.h.c.a
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.tapsdk.tapad.f.h.c.a
        public void a(int i, Bundle bundle) {
            Log.i("AdvertisingIdPlatform", "OAIDCallBack handleResult retCode = " + i + " retInfo = " + bundle);
            if (i == 0) {
                try {
                    com.tapsdk.tapad.f.h.a.C0596a c0596a = this.a.a;
                    if (c0596a != null) {
                        c0596a.a = bundle.getString(bk.c.b);
                        Log.i("AdvertisingIdPlatform", "OAIDCallBack handleResult success");
                    }
                } catch (Exception e) {
                    Log.i("AdvertisingIdPlatform", "OAIDCallBack handleResult error: " + e.getMessage());
                    b.a(this.a);
                }
            }
            b.a(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.tapsdk.tapad.f.h.b$b, reason: collision with other inner class name */
    public static class BinderC0597b extends com.tapsdk.tapad.f.h.c.a.AbstractBinderC0598a {
        public final b a;

        public BinderC0597b(b bVar) {
            this.a = bVar;
        }

        @Override // com.tapsdk.tapad.f.h.c.a
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.tapsdk.tapad.f.h.c.a
        public void a(int i, Bundle bundle) {
            Log.i("AdvertisingIdPlatform", "OAIDLimitCallback handleResult retCode=" + i + " retInfo= " + bundle);
            if (i == 0) {
                try {
                    if (this.a.a != null) {
                        boolean z = bundle.getBoolean("oa_id_limit_state");
                        this.a.a.b = z;
                        Log.i("AdvertisingIdPlatform", "OAIDLimitCallback handleResult success  isLimit=" + z);
                    }
                } catch (Exception e) {
                    Log.i("AdvertisingIdPlatform", "OAIDLimitCallback handleResult error:  " + e.getMessage());
                    b.a(this.a);
                }
            }
            b.a(this.a);
        }
    }

    public static void a(b bVar) {
        bVar.getClass();
        try {
            bVar.e.countDown();
        } catch (Exception e) {
            Log.i("AdvertisingIdPlatform", "doCountDown  error:  " + e.getMessage());
        }
    }

    public final void a() {
        Log.i("AdvertisingIdPlatform", "release");
        try {
            this.e.countDown();
            this.e.countDown();
        } catch (Exception e) {
            Log.e("AdvertisingIdPlatform", "release error=" + e.getMessage() + " : b");
        }
    }

    public boolean a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo("com.hihonor.id", 0);
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }
}
