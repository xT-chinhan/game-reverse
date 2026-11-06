package com.tapsdk.tapad.oaid.honor;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.tapsdk.tapad.oaid.honor.oaidl.IA;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
public class HonorA {
    public Context context;
    public AdvertisingIdClient.Info info;
    public final HonorAA d = new HonorAA(this);
    public final HonorAB c = new HonorAB(this);
    public final CountDownLatch e = new CountDownLatch(2);

    public static class HonorAA extends IA.ABinder {
        public final HonorA a;

        public HonorAA(HonorA honorA) {
            this.a = honorA;
        }

        @Override // com.tapsdk.tapad.oaid.honor.oaidl.IA
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.tapsdk.tapad.oaid.honor.oaidl.IA
        public void a(int i, Bundle bundle) {
            Objects.toString(bundle);
            if (i == 0) {
                try {
                    AdvertisingIdClient.Info info = this.a.info;
                    if (info != null) {
                        info.id = bundle.getString("oa_id_flag");
                    }
                } catch (Exception e) {
                    e.getMessage();
                    HonorA.a(this.a);
                }
            }
            HonorA.a(this.a);
        }
    }

    public static class HonorAB extends IA.ABinder {
        public final HonorA a;

        public HonorAB(HonorA honorA) {
            this.a = honorA;
        }

        @Override // com.tapsdk.tapad.oaid.honor.oaidl.IA
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.tapsdk.tapad.oaid.honor.oaidl.IA
        public void a(int i, Bundle bundle) {
            Objects.toString(bundle);
            if (i == 0) {
                try {
                    if (this.a.info != null) {
                        this.a.info.isLimit = bundle.getBoolean("oa_id_limit_state");
                    }
                } catch (Exception e) {
                    e.getMessage();
                    HonorA.a(this.a);
                }
            }
            HonorA.a(this.a);
        }
    }

    public static void a(HonorA honorA) {
        honorA.getClass();
        try {
            honorA.e.countDown();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public boolean a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getPackageInfo("com.hihonor.id", 0);
            Intent intent = new Intent("com.hihonor.id.HnOaIdService");
            intent.setPackage("com.hihonor.id");
            return !packageManager.queryIntentServices(intent, 0).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public final void a() {
        try {
            this.e.countDown();
            this.e.countDown();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
