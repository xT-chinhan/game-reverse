package com.bytedance.pangle.d;

import com.bytedance.sdk.openadsdk.api.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class xr {
    public static String ab = "7z_unzip_finish";
    public static String ah = "download_finish";
    public static String c = "7z_unzip_start";
    public static String ch = "rm_entry_finish";
    public static String d = "install_start";
    private static volatile xr hi = null;
    public static String ka = "install_finish";

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    public static String f636ms = "request_finish";
    public static String ny = "load_finish";
    public static String x = "load_start";
    public static String xr = "download_start";
    private final List<com.bytedance.pangle.d.ms> sl = new ArrayList();

    public static class ms {
        public static int ab = 12002;
        public static int ah = -1;
        public static int ao = 22002;
        public static int b = 32002;
        public static int c = 12001;
        public static int ch = 20000;
        public static int cv = 32999;
        public static int d = -2;
        public static int g = 40000;
        public static int h = 22999;
        public static int hi = 21000;
        public static int i = 32004;
        public static int jw = 50004;
        public static int ka = 12000;
        public static int le = 32008;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public static int f637ms = 1;
        public static int nw = 32001;
        public static int ny = 12004;
        public static int of = 41000;
        public static int op = 32007;
        public static int p = 42000;
        public static int pc = 50000;
        public static int qv = 30000;
        public static int re = 32003;
        public static int sl = 21001;
        public static int t = 32000;
        public static int u = 22000;
        public static int ub = 22001;
        public static int w = 32005;
        public static int x = 12003;
        public static int xr = 2;
        public static int y = 31000;
        public static int yu = 32006;
        public static int zb = 21002;
    }

    public static xr ms() {
        if (hi == null) {
            synchronized (xr.class) {
                hi = new xr();
            }
        }
        return hi;
    }

    private xr() {
    }

    public void ms(com.bytedance.pangle.d.ms msVar) {
        synchronized (this.sl) {
            this.sl.add(msVar);
        }
    }

    public void ms(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.sl) {
            Iterator<com.bytedance.pangle.d.ms> it = this.sl.iterator();
            while (it.hasNext()) {
                try {
                    it.next().ms(str, jSONObject, jSONObject2, jSONObject3);
                } catch (Throwable th) {
                    ab.ms(th);
                }
            }
        }
    }
}
