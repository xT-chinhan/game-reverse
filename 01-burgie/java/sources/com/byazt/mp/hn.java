package com.byazt.mp;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.sd.a;
import com.byazt.vkw.g;
import com.byazt.wt.DeviceUtils;
import com.byazt.wt.b;
import com.byazt.xlm.fw;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 168, 20})
public final class hn {
    public static volatile hn hw;
    public SharedPreferences vk;
    public volatile boolean zo;
    public AtomicBoolean pr = new AtomicBoolean(false);
    public AtomicBoolean hn = new AtomicBoolean(false);
    public AtomicInteger x = new AtomicInteger(Integer.MAX_VALUE);
    public AtomicInteger c = new AtomicInteger(Integer.MAX_VALUE);
    public volatile String uc = null;
    public AtomicInteger fw = new AtomicInteger(Integer.MAX_VALUE);
    public AtomicInteger aj = new AtomicInteger(Integer.MAX_VALUE);
    public AtomicInteger w = new AtomicInteger(Integer.MAX_VALUE);
    public AtomicInteger k = new AtomicInteger(Integer.MAX_VALUE);
    public AtomicInteger m = new AtomicInteger(Integer.MAX_VALUE);

    private hn() {
    }

    public static hn pr() {
        if (hw == null) {
            synchronized (hn.class) {
                if (hw == null) {
                    hw = new hn();
                }
            }
        }
        return hw;
    }

    public void pr(boolean z) {
        this.pr.set(z);
        if (z) {
            pr("key_support_multiprocess", 1);
        }
    }

    public boolean hw() {
        if (!this.zo) {
            this.pr.set(com.byazt.jc.hw.pr("sp_bidding_opt_libra", "key_support_multiprocess", 2) == 1);
            this.zo = true;
        }
        return this.pr.get();
    }

    private SharedPreferences m() {
        return com.byazt.mg.hw.hw(a.getContext(), "sp_bidding_opt_libra", 0);
    }

    public boolean hn() {
        try {
            if (this.x.get() == Integer.MAX_VALUE) {
                if (this.pr.get()) {
                    this.x.set(com.byazt.jc.hw.pr("sp_bidding_opt_libra", "key_req_body_opt", 1));
                } else {
                    if (this.vk == null) {
                        this.vk = m();
                    }
                    this.x.set(this.vk.getInt("key_req_body_opt", 1));
                }
            }
            return this.x.get() == 1;
        } catch (Throwable th) {
            return false;
        }
    }

    public String x() {
        try {
            if (TextUtils.isEmpty(this.uc)) {
                if (this.pr.get()) {
                    this.uc = com.byazt.jc.hw.hw("sp_bidding_opt_libra", "key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                } else {
                    if (this.vk == null) {
                        this.vk = m();
                    }
                    this.uc = this.vk.getString("key_url_ads", "api-access.pangolin-sdk-toutiao.com");
                }
            }
        } catch (Throwable th) {
        }
        this.uc = TextUtils.isEmpty(this.uc) ? "api-access.pangolin-sdk-toutiao.com" : this.uc;
        return this.uc;
    }

    public int c() {
        try {
            if (this.c.get() == Integer.MAX_VALUE) {
                if (this.pr.get()) {
                    this.c.set(com.byazt.jc.hw.pr("sp_bidding_opt_libra", "key_net_queue_limit", 7));
                } else {
                    if (this.vk == null) {
                        this.vk = m();
                    }
                    this.c.set(this.vk.getInt("key_net_queue_limit", 7));
                }
            }
            return this.c.get();
        } catch (Throwable th) {
            return 7;
        }
    }

    public int uc() {
        try {
            if (this.fw.get() == Integer.MAX_VALUE) {
                if (this.pr.get()) {
                    this.fw.set(com.byazt.jc.hw.pr("sp_bidding_opt_libra", "key_network_module", 1));
                } else {
                    if (this.vk == null) {
                        this.vk = m();
                    }
                    this.fw.set(this.vk.getInt("key_network_module", 1));
                }
            }
            return this.fw.get();
        } catch (Throwable th) {
            return 1;
        }
    }

    public int fw() {
        try {
            if (this.aj.get() == Integer.MAX_VALUE) {
                if (this.pr.get()) {
                    this.aj.set(com.byazt.jc.hw.pr("sp_bidding_opt_libra", "key_req_build_opt", 1));
                } else {
                    if (this.vk == null) {
                        this.vk = m();
                    }
                    this.aj.set(this.vk.getInt("key_req_build_opt", 1));
                }
            }
            return this.aj.get();
        } catch (Exception e) {
            return 0;
        }
    }

    public void pr(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.m.set(jSONObject.optInt("bst_pl_exec_conf", -1));
        }
    }

    public int zo() {
        if (this.m.get() == Integer.MAX_VALUE) {
            this.m.set(aj());
        }
        return this.m.get();
    }

    public int aj() {
        try {
            if (this.k.get() == Integer.MAX_VALUE) {
                if (this.vk == null) {
                    this.vk = m();
                }
                this.k.set(this.vk.getInt("bst_pl_exec_conf", -1));
                if (this.k.get() < 0) {
                    this.k.set(this.vk.getInt("_use_pl_", 0));
                } else {
                    return this.k.get();
                }
            }
            return this.k.get();
        } catch (Throwable th) {
            return 0;
        }
    }

    public boolean vk() {
        try {
            if (this.w.get() == Integer.MAX_VALUE) {
                if (this.pr.get()) {
                    this.w.set(com.byazt.jc.hw.pr("sp_bidding_opt_libra", "boost_save_config", 0));
                } else {
                    if (this.vk == null) {
                        this.vk = m();
                    }
                    this.w.set(this.vk.getInt("boost_save_config", 0));
                }
            }
            return this.w.get() == 1;
        } catch (Throwable th) {
            return false;
        }
    }

    private void pr(String str, int i) {
        try {
            if (this.pr.get()) {
                com.byazt.jc.hw.pr("sp_bidding_opt_libra", str, Integer.valueOf(i));
                return;
            }
            if (this.vk == null) {
                this.vk = m();
            }
            SharedPreferences.Editor editorEdit = this.vk.edit();
            editorEdit.putInt(str, i);
            editorEdit.apply();
        } catch (Throwable th) {
        }
    }

    private void pr(String str, String str2) {
        try {
            if (this.pr.get()) {
                com.byazt.jc.hw.pr("sp_bidding_opt_libra", str, str2);
                return;
            }
            if (this.vk == null) {
                this.vk = m();
            }
            SharedPreferences.Editor editorEdit = this.vk.edit();
            editorEdit.putString(str, str2);
            editorEdit.apply();
        } catch (Throwable th) {
        }
    }

    public void w() {
        try {
            com.byazt.jc.hw.pr("sp_bidding_opt_libra");
            SharedPreferences.Editor editorEdit = m().edit();
            editorEdit.clear();
            editorEdit.apply();
            this.x.set(0);
            this.c.set(7);
            this.aj.set(0);
        } catch (Throwable th) {
        }
    }

    public void hw(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("ads_url", "api-access.pangolin-sdk-toutiao.com");
            this.uc = strOptString;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
            if (jSONObjectOptJSONObject == null) {
                if (com.byazt.iq.pr.fw()) {
                    return;
                }
                pr("key_url_ads", strOptString);
                return;
            }
            try {
                int iOptInt = jSONObjectOptJSONObject.optInt("network_module", 1);
                int iOptInt2 = jSONObjectOptJSONObject.optInt("if_req_body_opt", 1);
                this.x.set(iOptInt2);
                int iOptInt3 = jSONObjectOptJSONObject.optInt("net_queue_limit", 7);
                this.c.set(iOptInt3);
                int iOptInt4 = jSONObjectOptJSONObject.optInt("req_build_opt", 0);
                this.aj.set(iOptInt4);
                int i = jSONObjectOptJSONObject.optBoolean("_use_pl_", false) ? 1 : 0;
                String strOptString2 = jSONObjectOptJSONObject.optString("zeus_sp", "");
                int iOptInt5 = jSONObjectOptJSONObject.optInt("bst_pl_exec_conf", -1);
                int iOptInt6 = jSONObjectOptJSONObject.optInt("boost_save_config", 0);
                this.w.set(iOptInt6);
                long jOptLong = jSONObjectOptJSONObject.optLong("bstlayer_init_delay_time", 0L);
                if (com.byazt.iq.pr.fw()) {
                    return;
                }
                if (this.pr.get()) {
                    try {
                        com.byazt.jc.hw.pr("sp_bidding_opt_libra", "key_network_module", Integer.valueOf(iOptInt));
                        com.byazt.jc.hw.pr("sp_bidding_opt_libra", "key_req_body_opt", Integer.valueOf(iOptInt2));
                        com.byazt.jc.hw.pr("sp_bidding_opt_libra", "key_net_queue_limit", Integer.valueOf(iOptInt3));
                        com.byazt.jc.hw.pr("sp_bidding_opt_libra", "key_req_build_opt", Integer.valueOf(iOptInt4));
                        com.byazt.jc.hw.pr("sp_bidding_opt_libra", "_use_pl_", Integer.valueOf(i));
                        com.byazt.jc.hw.pr("sp_bidding_opt_libra", "bst_pl_exec_conf", Integer.valueOf(iOptInt5));
                        com.byazt.jc.hw.pr("sp_bidding_opt_libra", "key_url_ads", strOptString);
                        com.byazt.jc.hw.pr("sp_bidding_opt_libra", "boost_save_config", Integer.valueOf(iOptInt6));
                        com.byazt.jc.hw.pr("sp_bidding_opt_libra", "bstlayer_init_delay_time", Long.valueOf(jOptLong));
                        com.byazt.jc.hw.pr("sp_bidding_opt_libra", "zeus_sp", strOptString2);
                        return;
                    } catch (Throwable th) {
                        return;
                    }
                }
                try {
                    if (this.vk == null) {
                        this.vk = m();
                    }
                    SharedPreferences.Editor editorEdit = this.vk.edit();
                    editorEdit.putInt("key_network_module", iOptInt);
                    editorEdit.putInt("key_req_body_opt", iOptInt2);
                    editorEdit.putInt("key_net_queue_limit", iOptInt3);
                    editorEdit.putInt("key_req_build_opt", iOptInt4);
                    editorEdit.putInt("_use_pl_", i);
                    editorEdit.putInt("bst_pl_exec_conf", iOptInt5);
                    editorEdit.putString("key_url_ads", strOptString);
                    editorEdit.putInt("boost_save_config", iOptInt6);
                    editorEdit.putLong("bstlayer_init_delay_time", jOptLong);
                    editorEdit.putString("zeus_sp", strOptString2);
                    editorEdit.commit();
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
            }
        } catch (Throwable th4) {
        }
    }

    public void k() {
        com.byazt.xlm.c.pr(new fw("advance_init_rb") { // from class: com.byazt.mp.hn.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!hn.this.hn.get()) {
                        hn.this.hn.set(true);
                        hn.this.g();
                    }
                } catch (Throwable th) {
                }
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        boolean zHn = hn();
        if (zHn) {
            com.byazt.ks.x.x();
            x.pr();
            hw.pr();
        }
        try {
            if (!com.byazt.iq.pr.hn()) {
                String strX = pr().x();
                if (!TextUtils.isEmpty(strX)) {
                    com.byazt.tf.hn.hw(String.format("https://%s%s", strX, "/api/ad/union/ping")).pr((com.byazt.hcx.fw) null);
                }
            }
        } catch (Throwable th) {
        }
        if (zHn) {
            DeviceUtils.pr(3, false);
            pr.pr(a.getContext(), 3);
            int i = com.byazt.pj.pr.pr;
            com.byazt.hs.hw hwVar = com.byazt.hs.hw.pr;
            ho();
            b.pr(259200000L);
        }
    }

    private void ho() {
        com.byazt.qam.pr prVar = new com.byazt.qam.pr();
        g gVar = (g) com.byazt.zs.uc.pr("device_info_new");
        DeviceUtils.pr(Boolean.valueOf(prVar.pr(0)));
        DeviceUtils.hw();
        gVar.x(Boolean.valueOf(prVar.pr()));
        gVar.pr(Boolean.valueOf(prVar.pr()));
        gVar.c(Boolean.valueOf(prVar.pr(1)));
        gVar.hn(Boolean.valueOf(prVar.pr(2)));
        gVar.uc();
    }

    public boolean pr(int i) {
        if (i <= 0) {
            return false;
        }
        return pr(i, fw());
    }

    private boolean pr(int i, int i2) {
        if (i2 == 0) {
            return false;
        }
        if (i2 == 1) {
            return true;
        }
        if (i2 != 3 || i == 5) {
            return false;
        }
        return true;
    }
}
