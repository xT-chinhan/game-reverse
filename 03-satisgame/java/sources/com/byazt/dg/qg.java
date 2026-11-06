package com.byazt.dg;

import com.varbto.utils.api.UtilConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, 1140, 26})
public class qg {
    public String s;
    public String n = UtilConst.CRASH_CAT_A;
    public String qg = "defer";
    public n q = new n("score_reach", "${level.targetScore}");
    public n l = new n("time_expire", "${level.timeLimit}");
    public final Map<String, q> w = new HashMap();
    public final List<C0152qg> x = new ArrayList();

    @com.byazt.cp.n(n = {0, 1, 1140, 1474})
    public static class q {
        public String n;
        public String qg;
        public int s;
        public String w;
        public double x;
        public int q = 68;
        public int l = 68;
        public double fs = 0.0d;
        public double rv = 0.0d;
        public boolean tj = false;
        public double cp = 0.0d;
        public boolean d = false;
    }

    /* JADX INFO: renamed from: com.byazt.dg.qg$qg, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1140, 201})
    public static class C0152qg {
        public JSONObject d;
        public double fs;
        public int l;
        public int n;
        public double qg;
        public double rv;
        public double s;
        public double tj;
        public double x;
        public int q = 2800;
        public final List<s> w = new ArrayList();
        public double cp = 1.0d;
    }

    @com.byazt.cp.n(n = {0, 1, 1140, 47})
    public static class s {
        public String n;
        public int qg;
    }

    @com.byazt.cp.n(n = {0, 1, 1140, 48})
    public static class n {
        public String n;
        public String qg;

        public n(String str, String str2) {
            this.n = str;
            this.qg = str2;
        }
    }

    public boolean n() {
        return (this.w.isEmpty() || this.x.isEmpty()) ? false : true;
    }

    public boolean qg() {
        return "static".equals(this.qg);
    }
}
