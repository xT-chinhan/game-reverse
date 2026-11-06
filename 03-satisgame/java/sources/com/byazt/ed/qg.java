package com.byazt.ed;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.byazt.ehw.DeviceUtils;
import com.byazt.nf.rv;
import com.byazt.qit.x;
import com.byazt.vf.oa;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 854, 26})
public final class qg {
    public static volatile qg qg;
    public AtomicBoolean n = new AtomicBoolean(false);
    public AtomicBoolean s = new AtomicBoolean(false);
    public AtomicInteger q = new AtomicInteger(Integer.MAX_VALUE);
    public AtomicInteger l = new AtomicInteger(Integer.MAX_VALUE);
    public volatile String w = null;
    public AtomicInteger x = new AtomicInteger(Integer.MAX_VALUE);
    public AtomicInteger fs = new AtomicInteger(Integer.MAX_VALUE);
    public AtomicInteger rv = new AtomicInteger(Integer.MAX_VALUE);
    public AtomicInteger tj = new AtomicInteger(Integer.MAX_VALUE);
    public AtomicInteger cp = new AtomicInteger(Integer.MAX_VALUE);

    private boolean n(int i, int i2) {
        if (i2 == 0) {
            return false;
        }
        if (i2 == 1) {
            return true;
        }
        return i2 == 3 && i != 5;
    }

    private qg() {
    }

    public static qg n() {
        if (qg == null) {
            synchronized (qg.class) {
                if (qg == null) {
                    qg = new qg();
                }
            }
        }
        return qg;
    }

    public void n(boolean z) {
        if (this.n.get()) {
            return;
        }
        this.n.set(z);
    }

    public boolean qg() {
        return this.n.get();
    }

    private com.byazt.gwu.s oa() {
        return com.byazt.lk.l.qg(com.byazt.vyf.s.cy().ou(), "sp_bidding_opt_libra", 1, com.byazt.p001if.n.qg());
    }

    public boolean s() {
        try {
            if (this.q.get() == Integer.MAX_VALUE) {
                this.q.set(oa().getInt("key_req_body_opt", 1));
            }
            return this.q.get() == 1;
        } catch (Throwable unused) {
        }
    }

    public String q() {
        try {
            if (TextUtils.isEmpty(this.w)) {
                this.w = oa().getString("key_url_ads", "api-access.pangolin-sdk-toutiao.com");
            }
        } catch (Throwable unused) {
        }
        this.w = TextUtils.isEmpty(this.w) ? "api-access.pangolin-sdk-toutiao.com" : this.w;
        return this.w;
    }

    public int l() {
        try {
            if (this.l.get() == Integer.MAX_VALUE) {
                this.l.set(oa().getInt("key_net_queue_limit", 7));
            }
            return this.l.get();
        } catch (Throwable unused) {
            return 7;
        }
    }

    public int w() {
        try {
            if (this.x.get() == Integer.MAX_VALUE) {
                this.x.set(oa().getInt("key_network_module", 1));
            }
            return this.x.get();
        } catch (Throwable unused) {
            return 1;
        }
    }

    public int x() {
        try {
            if (this.fs.get() == Integer.MAX_VALUE) {
                this.fs.set(oa().getInt("key_req_build_opt", 1));
            }
            return this.fs.get();
        } catch (Exception unused) {
            return 0;
        }
    }

    public void n(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.cp.set(jSONObject.optInt("bst_pl_exec_conf", -1));
        }
    }

    public int fs() {
        if (this.cp.get() == Integer.MAX_VALUE) {
            this.cp.set(rv());
        }
        return this.cp.get();
    }

    public int rv() {
        try {
            if (this.tj.get() == Integer.MAX_VALUE) {
                com.byazt.gwu.s sVarOa = oa();
                this.tj.set(sVarOa.getInt("bst_pl_exec_conf", -1));
                if (this.tj.get() >= 0) {
                    return this.tj.get();
                }
                this.tj.set(sVarOa.getInt("_use_pl_", 0));
            }
            return this.tj.get();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public boolean tj() {
        try {
            if (this.rv.get() == Integer.MAX_VALUE) {
                this.rv.set(oa().getInt("boost_save_config", 0));
            }
            return this.rv.get() == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void n(String str, String str2) {
        try {
            oa().n(str, str2);
        } catch (Throwable unused) {
        }
    }

    public void cp() {
        try {
            oa().n();
            this.q.set(0);
            this.l.set(7);
            this.fs.set(0);
        } catch (Throwable unused) {
        }
    }

    public void qg(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("ads_url", "api-access.pangolin-sdk-toutiao.com");
            this.w = strOptString;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
            if (jSONObjectOptJSONObject == null) {
                if (com.byazt.gv.n.x()) {
                    return;
                }
                n("key_url_ads", strOptString);
                return;
            }
            int i = 1;
            int iOptInt = jSONObjectOptJSONObject.optInt("network_module", 1);
            int iOptInt2 = jSONObjectOptJSONObject.optInt("if_req_body_opt", 1);
            this.q.set(iOptInt2);
            int iOptInt3 = jSONObjectOptJSONObject.optInt("net_queue_limit", 7);
            this.l.set(iOptInt3);
            int iOptInt4 = jSONObjectOptJSONObject.optInt("req_build_opt", 0);
            this.fs.set(iOptInt4);
            if (!jSONObjectOptJSONObject.optBoolean("_use_pl_", false)) {
                i = 0;
            }
            String strOptString2 = jSONObjectOptJSONObject.optString("zeus_sp", "");
            int iOptInt5 = jSONObjectOptJSONObject.optInt("bst_pl_exec_conf", -1);
            int iOptInt6 = jSONObjectOptJSONObject.optInt("boost_save_config", 0);
            this.rv.set(iOptInt6);
            long jOptLong = jSONObjectOptJSONObject.optLong("bstlayer_init_delay_time", 0L);
            if (com.byazt.gv.n.x()) {
                return;
            }
            com.byazt.gwu.s sVarOa = oa();
            SharedPreferences.Editor editorEdit = sVarOa.edit();
            if (editorEdit != null) {
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
                return;
            }
            sVarOa.n("key_network_module", iOptInt);
            sVarOa.n("key_req_body_opt", iOptInt2);
            sVarOa.n("key_net_queue_limit", iOptInt3);
            sVarOa.n("key_req_build_opt", iOptInt4);
            sVarOa.n("_use_pl_", i);
            sVarOa.n("bst_pl_exec_conf", iOptInt5);
            sVarOa.n("key_url_ads", strOptString);
            sVarOa.n("boost_save_config", iOptInt6);
            sVarOa.n("bstlayer_init_delay_time", jOptLong);
            sVarOa.n("zeus_sp", strOptString2);
        } catch (Throwable unused) {
        }
    }

    public void d() {
        com.byazt.qit.l.n(new x("advance_init_rb") { // from class: com.byazt.ed.qg.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (qg.this.s.get()) {
                        return;
                    }
                    qg.this.s.set(true);
                    qg.this.sz();
                } catch (Throwable unused) {
                }
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sz() {
        boolean zS = s();
        if (zS) {
            com.byazt.mz.q.l();
            s.n();
            n.n();
        }
        try {
            if (!com.byazt.gv.n.s()) {
                String strQ = n().q();
                if (!TextUtils.isEmpty(strQ)) {
                    com.byazt.phf.s.qg(String.format("https://%s%s", strQ, "/api/ad/union/ping")).n((com.byazt.qk.x) null);
                }
            }
        } catch (Throwable unused) {
        }
        if (zS) {
            DeviceUtils.n(3, false);
            com.byazt.ehw.n.n(rv.getContext(), 3);
            int i = com.byazt.hm.n.n;
            com.byazt.lq.qg qgVar = com.byazt.lq.qg.n;
            k();
            com.byazt.rd.n.n(259200000L);
        }
    }

    private void k() {
        com.byazt.af.qg qgVar = new com.byazt.af.qg();
        oa oaVar = (oa) com.byazt.qp.q.n("device_info_new");
        DeviceUtils.n(Boolean.valueOf(qgVar.n(0)));
        DeviceUtils.qg();
        oaVar.q(Boolean.valueOf(qgVar.n()));
        oaVar.n(Boolean.valueOf(qgVar.n()));
        oaVar.l(Boolean.valueOf(qgVar.n(1)));
        oaVar.s(Boolean.valueOf(qgVar.n(2)));
        oaVar.w();
    }

    public boolean n(int i) {
        if (i <= 0) {
            return false;
        }
        return n(i, x());
    }
}
