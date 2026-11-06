package com.byazt.fw;

import com.byazt.vx.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1056, 26})
public class qg {
    public static String cp = "e_create_ac_failed";
    public static volatile qg d = null;
    public static String fs = "load_start";
    public static String l = "install_finish";
    public static String n = "request_finish";
    public static String q = "install_start";
    public static String qg = "download_start";
    public static String rv = "load_finish";
    public static String s = "download_finish";
    public static String tj = "rm_entry_finish";
    public static String w = "7z_unzip_start";
    public static String x = "7z_unzip_finish";
    public final List<com.byazt.fw.n> oa = new ArrayList();

    @com.byazt.cp.n(n = {0, 1, 1056, 48})
    public static class n {
        public static int a = 32000;
        public static int an = 50004;
        public static int bb = 32999;
        public static int cd = 30000;
        public static int cp = 21000;
        public static int cy = 22002;
        public static int d = 21001;
        public static int fs = 12003;
        public static int h = 32006;
        public static int hd = 22999;
        public static int hu = 32005;
        public static int j = 50000;
        public static int k = 22001;
        public static int l = 12000;
        public static int lh = 41000;
        public static int ln = 40000;
        public static int m = 32004;
        public static int n = 1;
        public static int oa = 21002;
        public static int ou = 32002;
        public static int py = 32001;
        public static int q = -2;
        public static int qg = 2;
        public static int rv = 12004;
        public static int s = -1;
        public static int sz = 22000;
        public static int t = 32007;
        public static int tj = 20000;
        public static int um = 31000;
        public static int ur = 32008;
        public static int v = 42000;
        public static int w = 12001;
        public static int wm = 32003;
        public static int x = 12002;
    }

    public static qg n() {
        if (d == null) {
            synchronized (qg.class) {
                d = new qg();
            }
        }
        return d;
    }

    private qg() {
    }

    public void n(com.byazt.fw.n nVar) {
        synchronized (this.oa) {
            this.oa.add(nVar);
        }
    }

    public void n(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.oa) {
            Iterator<com.byazt.fw.n> it = this.oa.iterator();
            while (it.hasNext()) {
                try {
                    it.next().n(str, jSONObject, jSONObject2, jSONObject3);
                } catch (Throwable th) {
                    w.n(th);
                }
            }
        }
    }
}
