package com.byazt.ir;

import android.text.TextUtils;
import com.anythink.core.common.d.i;
import com.byazt.gwu.l;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DECODE_SECOND_VIDEO_FRAME_TIME, 26})
public class qg {
    public static volatile qg n;
    public int s = -1;
    public long q = -1;
    public int l = -1;
    public int w = -1;
    public int x = -1;
    public int fs = Integer.MIN_VALUE;
    public int rv = Integer.MIN_VALUE;
    public int tj = -1;
    public int cp = -1;
    public int d = -1;
    public l qg = com.byazt.ri.n.qg();

    private qg() {
    }

    public static qg n() {
        if (n == null) {
            synchronized (qg.class) {
                if (n == null) {
                    n = new qg();
                }
            }
        }
        return n;
    }

    private synchronized void qg(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("event_batch_size", 100);
        this.s = iOptInt;
        if (iOptInt <= 0 || iOptInt > 1000) {
            this.s = 100;
        }
        long jOptLong = jSONObject.optLong("event_routine_interval", i.l.c);
        this.q = jOptLong;
        if (jOptLong < 10000 || jOptLong > 300000) {
            this.q = i.l.c;
        }
        int iOptInt2 = jSONObject.optInt("dynamic_adapter_type", 0);
        this.l = iOptInt2;
        if (iOptInt2 != 0 && iOptInt2 != 1) {
            this.l = 0;
        }
        this.x = jSONObject.optInt("rv_start_time", 5000);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("rv_cb");
        if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optInt("open") == 1) {
            this.rv = Math.max(jSONObjectOptJSONObject.optInt("adn", 0), 0);
            long jOptLong2 = jSONObjectOptJSONObject.optLong("time", 0L);
            if (jOptLong2 <= 0) {
                this.fs = 0;
            } else if (jOptLong2 >= 2147483) {
                this.fs = Integer.MAX_VALUE;
            } else {
                this.fs = (int) (jOptLong2 * 1000);
            }
        } else {
            this.fs = -1;
            this.rv = 0;
        }
        int iOptInt3 = jSONObject.optInt("wf_dynamic_adapter_type", 0);
        this.w = iOptInt3;
        if (iOptInt3 != 0 && iOptInt3 != 1) {
            this.w = 0;
        }
        com.byazt.qa.q.n().n(jSONObject.optInt("pre_fetch_count", 20));
        this.tj = jSONObject.optInt("adapter_plugin_loader_gdt", -1);
        this.cp = jSONObject.optInt("can_log", -1);
        this.d = jSONObject.optInt("enable_abtest_id", 0);
    }

    private synchronized JSONObject cp() {
        l lVar = this.qg;
        if (lVar == null) {
            return null;
        }
        String string = lVar.getString("app_common_config", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        if (!string.startsWith("[") && !string.startsWith("{")) {
            string = com.byazt.vy.n.qg(string, com.byazt.vy.qg.n());
        }
        if (!TextUtils.isEmpty(string)) {
            try {
                return new JSONObject(string);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public synchronized void n(final JSONObject jSONObject) {
        if (jSONObject != null) {
            qg(jSONObject);
            if (com.byazt.qt.qg.n().s()) {
                com.byazt.rb.l.q(new Runnable() { // from class: com.byazt.ir.qg.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String string = jSONObject.toString();
                        if (TextUtils.isEmpty(string)) {
                            return;
                        }
                        qg.this.qg.n("app_common_config", string);
                    }
                });
            } else {
                String string = jSONObject.toString();
                if (!TextUtils.isEmpty(string)) {
                    this.qg.n("app_common_config", string);
                }
            }
        }
    }

    public synchronized int qg() {
        int i = this.s;
        if (i != -1) {
            return i;
        }
        JSONObject jSONObjectCp = cp();
        if (jSONObjectCp == null) {
            return 100;
        }
        qg(jSONObjectCp);
        return this.s;
    }

    public synchronized long s() {
        long j = this.q;
        if (j != -1) {
            return j;
        }
        JSONObject jSONObjectCp = cp();
        if (jSONObjectCp == null) {
            return i.l.c;
        }
        qg(jSONObjectCp);
        return this.q;
    }

    public int q() {
        int i = this.l;
        if (i != -1) {
            return i;
        }
        JSONObject jSONObjectCp = cp();
        if (jSONObjectCp == null) {
            return 0;
        }
        qg(jSONObjectCp);
        return this.l;
    }

    public int l() {
        int i = this.w;
        if (i != -1) {
            return i;
        }
        JSONObject jSONObjectCp = cp();
        if (jSONObjectCp == null) {
            return 0;
        }
        qg(jSONObjectCp);
        return this.w;
    }

    public int w() {
        int i = this.x;
        if (i != -1) {
            return i;
        }
        JSONObject jSONObjectCp = cp();
        if (jSONObjectCp == null) {
            return 5000;
        }
        qg(jSONObjectCp);
        return this.x;
    }

    public int x() {
        int i = this.fs;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        JSONObject jSONObjectCp = cp();
        if (jSONObjectCp == null) {
            return -1;
        }
        qg(jSONObjectCp);
        return this.fs;
    }

    public int fs() {
        int i = this.rv;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        JSONObject jSONObjectCp = cp();
        if (jSONObjectCp == null) {
            return 0;
        }
        qg(jSONObjectCp);
        return this.rv;
    }

    public boolean rv() {
        int i = this.cp;
        if (i != -1) {
            return i == 1;
        }
        JSONObject jSONObjectCp = cp();
        if (jSONObjectCp != null) {
            qg(jSONObjectCp);
            if (this.cp == 1) {
                return true;
            }
        }
        return false;
    }

    public int tj() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        JSONObject jSONObjectCp = cp();
        if (jSONObjectCp == null) {
            return 0;
        }
        qg(jSONObjectCp);
        return this.d;
    }
}
