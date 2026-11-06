package com.bytedance.sdk.openadsdk.core.ah;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm.common.utility.Logger;
import com.bytedance.sdk.component.ch.ab;
import com.bytedance.sdk.component.ch.ny;
import com.bytedance.sdk.openadsdk.core.jw.ch;
import com.bytedance.sdk.openadsdk.core.jw.yu;
import com.bytedance.sdk.openadsdk.core.re;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ah {
    private static volatile ah xr;
    private SharedPreferences ch;
    private volatile boolean x;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private AtomicBoolean f1966ms = new AtomicBoolean(false);
    private AtomicBoolean ah = new AtomicBoolean(false);
    private AtomicInteger d = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger ka = new AtomicInteger(Integer.MAX_VALUE);
    private volatile String c = null;
    private AtomicInteger ab = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger ny = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger hi = new AtomicInteger(Integer.MAX_VALUE);
    private AtomicInteger sl = new AtomicInteger(Integer.MAX_VALUE);

    private boolean ms(int i, int i2) {
        if (i2 == 0) {
            return false;
        }
        if (i2 == 1) {
            return true;
        }
        return i2 == 3 && i != 5;
    }

    private ah() {
    }

    public static ah ms() {
        if (xr == null) {
            synchronized (ah.class) {
                if (xr == null) {
                    xr = new ah();
                }
            }
        }
        return xr;
    }

    public void ms(boolean z) {
        this.f1966ms.set(z);
        if (z) {
            ms("key_support_multiprocess", 1);
        }
    }

    public boolean xr() {
        if (!this.x) {
            this.f1966ms.set(com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", "key_support_multiprocess", 2) == 1);
            this.x = true;
        }
        return this.f1966ms.get();
    }

    private SharedPreferences sl() {
        return com.bytedance.sdk.openadsdk.api.plugin.xr.xr(re.getContext(), "sp_bidding_opt_libra", 0);
    }

    public boolean ah() {
        try {
            if (this.d.get() == Integer.MAX_VALUE) {
                if (this.f1966ms.get()) {
                    this.d.set(com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", "key_req_body_opt", 1));
                } else {
                    if (this.ch == null) {
                        this.ch = sl();
                    }
                    this.d.set(this.ch.getInt("key_req_body_opt", 1));
                }
            }
            return this.d.get() == 1;
        } catch (Throwable unused) {
        }
    }

    public String d() {
        try {
            if (TextUtils.isEmpty(this.c)) {
                if (this.f1966ms.get()) {
                    this.c = com.bytedance.sdk.component.ab.ah.ms.xr.xr("sp_bidding_opt_libra", "key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                } else {
                    if (this.ch == null) {
                        this.ch = sl();
                    }
                    this.c = this.ch.getString("key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                }
            }
        } catch (Throwable unused) {
        }
        this.c = TextUtils.isEmpty(this.c) ? "api-access.pangolin-sdk-toutiao.com" : this.c;
        return this.c;
    }

    public int ka() {
        try {
            if (this.ka.get() == Integer.MAX_VALUE) {
                if (this.f1966ms.get()) {
                    this.ka.set(com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", "key_net_queue_limit", 7));
                } else {
                    if (this.ch == null) {
                        this.ch = sl();
                    }
                    this.ka.set(this.ch.getInt("key_net_queue_limit", 7));
                }
            }
            return this.ka.get();
        } catch (Throwable unused) {
            return 7;
        }
    }

    public int c() {
        try {
            if (this.ab.get() == Integer.MAX_VALUE) {
                if (this.f1966ms.get()) {
                    this.ab.set(com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", "key_network_module", 1));
                } else {
                    if (this.ch == null) {
                        this.ch = sl();
                    }
                    this.ab.set(this.ch.getInt("key_network_module", 1));
                }
            }
            return this.ab.get();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public int ab() {
        try {
            if (this.ny.get() == Integer.MAX_VALUE) {
                if (this.f1966ms.get()) {
                    this.ny.set(com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", "key_req_build_opt", 1));
                } else {
                    if (this.ch == null) {
                        this.ch = sl();
                    }
                    this.ny.set(this.ch.getInt("key_req_build_opt", 1));
                }
            }
            return this.ny.get();
        } catch (Exception unused) {
            return 0;
        }
    }

    public boolean x() {
        try {
            if (this.hi.get() == Integer.MAX_VALUE) {
                if (this.f1966ms.get()) {
                    this.hi.set(com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", "_use_pl_", 0));
                } else {
                    if (this.ch == null) {
                        this.ch = sl();
                    }
                    this.hi.set(this.ch.getInt("_use_pl_", 0));
                }
            }
            return this.hi.get() == 1;
        } catch (Throwable unused) {
        }
    }

    public boolean ny() {
        try {
            if (this.sl.get() == Integer.MAX_VALUE) {
                if (this.f1966ms.get()) {
                    this.sl.set(com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", "boost_save_config", 0));
                } else {
                    if (this.ch == null) {
                        this.ch = sl();
                    }
                    this.sl.set(this.ch.getInt("boost_save_config", 0));
                }
                Logger.i("bstsdk", "isBstTwConf get: " + this.sl.get());
            }
            return this.sl.get() == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void ms(String str, int i) {
        try {
            if (this.f1966ms.get()) {
                com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", str, Integer.valueOf(i));
                return;
            }
            if (this.ch == null) {
                this.ch = sl();
            }
            SharedPreferences.Editor editorEdit = this.ch.edit();
            editorEdit.putInt(str, i);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    private void ms(String str, String str2) {
        try {
            if (this.f1966ms.get()) {
                com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", str, str2);
                return;
            }
            if (this.ch == null) {
                this.ch = sl();
            }
            SharedPreferences.Editor editorEdit = this.ch.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable unused) {
        }
    }

    public void ch() {
        try {
            com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra");
            SharedPreferences.Editor editorEdit = sl().edit();
            editorEdit.clear();
            editorEdit.apply();
            this.d.set(0);
            this.ka.set(7);
            this.ny.set(0);
        } catch (Throwable unused) {
        }
    }

    public static String ms(String str) {
        String strD = ms().d();
        if (TextUtils.isEmpty(strD)) {
            return null;
        }
        return String.format("https://%s%s", strD, str);
    }

    public void ms(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("ads_url", "api-access.pangolin-sdk-toutiao.com");
            this.c = strOptString;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
            if (jSONObjectOptJSONObject == null) {
                if (com.bytedance.sdk.openadsdk.core.d.ms.c()) {
                    return;
                }
                ms("key_url_ads", strOptString);
                return;
            }
            int i = 1;
            int iOptInt = jSONObjectOptJSONObject.optInt("network_module", 1);
            int iOptInt2 = jSONObjectOptJSONObject.optInt("if_req_body_opt", 1);
            this.d.set(iOptInt2);
            int iOptInt3 = jSONObjectOptJSONObject.optInt("net_queue_limit", 7);
            this.ka.set(iOptInt3);
            int iOptInt4 = jSONObjectOptJSONObject.optInt("req_build_opt", 0);
            this.ny.set(iOptInt4);
            if (!jSONObjectOptJSONObject.optBoolean("_use_pl_", false)) {
                i = 0;
            }
            this.hi.set(i);
            int iOptInt5 = jSONObjectOptJSONObject.optInt("boost_save_config", 0);
            this.sl.set(iOptInt5);
            if (com.bytedance.sdk.openadsdk.core.d.ms.c()) {
                return;
            }
            if (this.f1966ms.get()) {
                try {
                    com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", "key_network_module", Integer.valueOf(iOptInt));
                    com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", "key_req_body_opt", Integer.valueOf(iOptInt2));
                    com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", "key_net_queue_limit", Integer.valueOf(iOptInt3));
                    com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", "key_req_build_opt", Integer.valueOf(iOptInt4));
                    com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", "_use_pl_", Integer.valueOf(i));
                    com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", "key_url_ads", strOptString);
                    com.bytedance.sdk.component.ab.ah.ms.xr.ms("sp_bidding_opt_libra", "boost_save_config", Integer.valueOf(iOptInt5));
                    return;
                } catch (Throwable unused) {
                    return;
                }
            }
            if (this.ch == null) {
                this.ch = sl();
            }
            SharedPreferences.Editor editorEdit = this.ch.edit();
            editorEdit.putInt("key_network_module", iOptInt);
            editorEdit.putInt("key_req_body_opt", iOptInt2);
            editorEdit.putInt("key_net_queue_limit", iOptInt3);
            editorEdit.putInt("key_req_build_opt", iOptInt4);
            editorEdit.putInt("_use_pl_", i);
            editorEdit.putString("key_url_ads", strOptString);
            editorEdit.putInt("boost_save_config", iOptInt5);
            editorEdit.commit();
        } catch (Throwable unused2) {
        }
    }

    public void hi() {
        ab.ms(new ny("advance_init_rb") { // from class: com.bytedance.sdk.openadsdk.core.ah.ah.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ah.this.ah.get()) {
                        return;
                    }
                    ah.this.ah.set(true);
                    ah.this.zb();
                } catch (Throwable unused) {
                }
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zb() {
        boolean zAh = ah();
        if (zAh) {
            com.bytedance.sdk.openadsdk.core.component.splash.ms.d.d();
            d.ms();
            xr.ms();
        }
        try {
            if (!com.bytedance.sdk.openadsdk.core.d.ms.ah()) {
                String strMs = ms("/api/ad/union/ping");
                if (!TextUtils.isEmpty(strMs)) {
                    com.bytedance.sdk.component.ny.xr.ah ahVarAh = com.bytedance.sdk.openadsdk.core.re.ka.ms().xr().ah();
                    ahVarAh.ms(strMs);
                    ahVarAh.ms(new com.bytedance.sdk.component.ny.ms.ms() { // from class: com.bytedance.sdk.openadsdk.core.ah.ah.2
                        @Override // com.bytedance.sdk.component.ny.ms.ms
                        public void ms(com.bytedance.sdk.component.ny.xr.d dVar, com.bytedance.sdk.component.ny.xr xrVar) {
                        }

                        @Override // com.bytedance.sdk.component.ny.ms.ms
                        public void ms(com.bytedance.sdk.component.ny.xr.d dVar, IOException iOException) {
                        }
                    });
                }
            }
        } catch (Throwable unused) {
        }
        if (zAh) {
            ch.xr(3);
            ms.ms(re.getContext(), 3);
            com.bytedance.sdk.openadsdk.core.jw.re.d();
            int i = com.bytedance.sdk.openadsdk.core.zb.ah.f3815ms;
            LogAdapter logAdapter = LogAdapter.f4121ms;
            u();
            yu.ms(259200000L);
        }
    }

    private void u() {
        com.bytedance.sdk.openadsdk.core.i.ms msVar = new com.bytedance.sdk.openadsdk.core.i.ms();
        t.ms(msVar);
        t.c();
        t.ah(msVar);
        t.d(msVar);
        t.xr(msVar);
        t.ka(msVar);
        t.h();
    }

    public boolean ms(int i) {
        if (i <= 0) {
            return false;
        }
        return ms(i, ab());
    }
}
