package com.efs.sdk.net;

import android.content.Context;
import android.content.SharedPreferences;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.pa.config.ConfigManager;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class NetConfigManager {
    private final String a = "NetConfigManager";
    private final int b = 0;
    private EfsReporter c;
    private int d;
    private int e;
    private boolean f;
    private Context g;

    public NetConfigManager(Context context, EfsReporter efsReporter) {
        int i;
        long j;
        boolean z;
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorEdit2;
        SharedPreferences.Editor editorEdit3;
        SharedPreferences.Editor editorEdit4;
        SharedPreferences.Editor editorEdit5;
        this.d = 0;
        this.f = false;
        this.g = context.getApplicationContext();
        this.c = efsReporter;
        SharedPreferences sharedPreferences = this.g.getSharedPreferences("net_launch", 0);
        if (sharedPreferences != null) {
            this.e = sharedPreferences.getInt("apm_netperf_sampling_rate_last", 0);
        }
        SharedPreferences sharedPreferences2 = this.g.getSharedPreferences("net_launch", 0);
        if (sharedPreferences2 != null) {
            i = sharedPreferences2.getInt("apm_netperf_sampling_rate", -1);
        } else {
            i = -1;
        }
        boolean z2 = true;
        this.c.getAllSdkConfig(new String[]{"apm_netperf_sampling_rate"}, new IConfigCallback() { // from class: com.efs.sdk.net.NetConfigManager.1
            @Override // com.efs.sdk.base.observer.IConfigCallback
            public final void onChange(Map<String, Object> map) {
                SharedPreferences sharedPreferences3;
                final SharedPreferences.Editor editorEdit6;
                try {
                    final Object obj = map.get("apm_netperf_sampling_rate");
                    if (obj != null && (sharedPreferences3 = NetConfigManager.this.g.getSharedPreferences("net_launch", 0)) != null && (editorEdit6 = sharedPreferences3.edit()) != null) {
                        new Thread(new Runnable() { // from class: com.efs.sdk.net.NetConfigManager.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                editorEdit6.putInt("apm_netperf_sampling_rate", Integer.parseInt(obj.toString()));
                                editorEdit6.commit();
                            }
                        }).start();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        if (i != -1) {
            this.d = i;
        }
        SharedPreferences sharedPreferences3 = this.g.getSharedPreferences("net_launch", 0);
        if (sharedPreferences3 != null) {
            j = sharedPreferences3.getLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L);
        } else {
            j = 0;
        }
        if (sharedPreferences3 != null) {
            z = sharedPreferences3.getBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false);
        } else {
            z = false;
        }
        if (this.d == 0) {
            if (z && sharedPreferences3 != null && (editorEdit5 = sharedPreferences3.edit()) != null) {
                editorEdit5.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, false);
                editorEdit5.commit();
            }
            if (j != 0 && sharedPreferences3 != null && (editorEdit4 = sharedPreferences3.edit()) != null) {
                editorEdit4.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, 0L);
                editorEdit4.commit();
            }
            z2 = false;
        } else {
            boolean z3 = this.d != this.e;
            Long lValueOf = Long.valueOf(j);
            int i2 = this.d;
            Long lValueOf2 = Long.valueOf(System.currentTimeMillis());
            Long lValueOf3 = Long.valueOf(lValueOf2.longValue() - lValueOf.longValue());
            if (z && lValueOf3.longValue() < 86400000 && !z3) {
                Log.d("NetConfigManager", " check in allready");
            } else if (lValueOf3.longValue() < 86400000 && !z3) {
                Log.d("NetConfigManager", "un repeat check in 24 hour!");
                z2 = false;
            } else {
                if (i2 != 0 && (i2 == 100 || new Random().nextInt(100) <= i2)) {
                    Log.d("NetConfigManager", "random check in");
                } else {
                    Log.d("NetConfigManager", "random not check in!");
                    z2 = false;
                }
                SharedPreferences sharedPreferences4 = this.g.getSharedPreferences("net_launch", 0);
                if (sharedPreferences4 != null && (editorEdit2 = sharedPreferences4.edit()) != null) {
                    editorEdit2.putBoolean(ConfigManager.FLAG_PA_CHECK_IN_STATE, z2);
                    editorEdit2.commit();
                }
                if (sharedPreferences4 != null && (editorEdit = sharedPreferences4.edit()) != null) {
                    editorEdit.putLong(ConfigManager.FLAG_PA_FORE_CHECK_TIME, lValueOf2.longValue());
                    editorEdit.commit();
                }
            }
        }
        this.f = z2;
        SharedPreferences sharedPreferences5 = this.g.getSharedPreferences("net_launch", 0);
        if (sharedPreferences5 == null || (editorEdit3 = sharedPreferences5.edit()) == null) {
            return;
        }
        editorEdit3.putInt("apm_netperf_sampling_rate_last", this.d);
        editorEdit3.commit();
    }

    public boolean enableTracer() {
        return this.f;
    }
}
