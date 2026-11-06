package com.bytedance.adsdk.lottie;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    private SparseArray<com.bytedance.adsdk.lottie.model.d> ab;
    private Map<String, List<com.bytedance.adsdk.lottie.model.layer.x>> ah;
    private d ao;
    private List<com.bytedance.adsdk.lottie.model.c> c;
    private Rect ch;
    private Map<String, ny> d;
    private float hi;
    private Map<String, com.bytedance.adsdk.lottie.model.ah> ka;
    private List<com.bytedance.adsdk.lottie.model.layer.x> ny;
    private xr qv;
    private float sl;
    private ms t;
    private boolean u;
    private LongSparseArray<com.bytedance.adsdk.lottie.model.layer.x> x;
    private ah y;
    private float zb;

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final qv f143ms = new qv();
    private final HashSet<String> xr = new HashSet<>();
    private int ub = 0;
    private String h = "";

    public static class ah {
        public JSONArray ah;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public String f144ms;
        public int[][] xr;
    }

    public static class d {
        public JSONArray ab;
        public String ah;
        public String c;
        public String d;
        public int[] ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public int f145ms;
        public String xr;
    }

    public static class xr {
        public JSONArray ab;
        public Map<String, Object> ah;
        public String c;
        public int d;
        public int ka;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public int f147ms;
        public Map<String, Object> xr;
    }

    public void ms(Rect rect, float f, float f2, float f3, List<com.bytedance.adsdk.lottie.model.layer.x> list, LongSparseArray<com.bytedance.adsdk.lottie.model.layer.x> longSparseArray, Map<String, List<com.bytedance.adsdk.lottie.model.layer.x>> map, Map<String, ny> map2, SparseArray<com.bytedance.adsdk.lottie.model.d> sparseArray, Map<String, com.bytedance.adsdk.lottie.model.ah> map3, List<com.bytedance.adsdk.lottie.model.c> list2, d dVar, String str, xr xrVar, ah ahVar, ms msVar) {
        this.ch = rect;
        this.hi = f;
        this.sl = f2;
        this.zb = f3;
        this.ny = list;
        this.x = longSparseArray;
        this.ah = map;
        this.d = map2;
        this.ab = sparseArray;
        this.ka = map3;
        this.c = list2;
        this.ao = dVar;
        this.h = str;
        this.qv = xrVar;
        this.y = ahVar;
        this.t = msVar;
    }

    public void ms(String str) {
        com.bytedance.adsdk.lottie.ka.ka.xr(str);
        this.xr.add(str);
    }

    public void ms(boolean z) {
        this.u = z;
    }

    public void ms(int i) {
        this.ub += i;
    }

    public boolean ms() {
        return this.u;
    }

    public int xr() {
        return this.ub;
    }

    public void xr(boolean z) {
        this.f143ms.ms(z);
    }

    public qv ah() {
        return this.f143ms;
    }

    public com.bytedance.adsdk.lottie.model.layer.x ms(long j) {
        return this.x.get(j);
    }

    public Rect d() {
        return this.ch;
    }

    public float ka() {
        return (long) ((qv() / this.zb) * 1000.0f);
    }

    public float c() {
        return this.hi;
    }

    public float ab() {
        return this.sl;
    }

    public float ms(float f) {
        return com.bytedance.adsdk.lottie.ka.x.ms(this.hi, this.sl, f);
    }

    public d x() {
        return this.ao;
    }

    public String ny() {
        return this.h;
    }

    public ms ch() {
        return this.t;
    }

    public ah hi() {
        return this.y;
    }

    public xr sl() {
        return this.qv;
    }

    public float zb() {
        return this.zb;
    }

    public List<com.bytedance.adsdk.lottie.model.layer.x> u() {
        return this.ny;
    }

    public List<com.bytedance.adsdk.lottie.model.layer.x> xr(String str) {
        return this.ah.get(str);
    }

    public SparseArray<com.bytedance.adsdk.lottie.model.d> ub() {
        return this.ab;
    }

    public Map<String, com.bytedance.adsdk.lottie.model.ah> ao() {
        return this.ka;
    }

    public com.bytedance.adsdk.lottie.model.c ah(String str) {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            com.bytedance.adsdk.lottie.model.c cVar = this.c.get(i);
            if (cVar.ms(str)) {
                return cVar;
            }
        }
        return null;
    }

    public Map<String, ny> h() {
        return this.d;
    }

    public float qv() {
        return this.sl - this.hi;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.bytedance.adsdk.lottie.model.layer.x> it = this.ny.iterator();
        while (it.hasNext()) {
            sb.append(it.next().ms("\t"));
        }
        return sb.toString();
    }

    public static class ms {
        public String ah;
        public String d;

        /* JADX INFO: renamed from: ms, reason: collision with root package name */
        public String f146ms;
        public String xr;
        public float ka = -1.0f;
        public float c = -1.0f;
        public float ab = -1.0f;
        public float x = -1.0f;

        public String toString() {
            return "area[" + this.f146ms + "," + this.xr + "," + this.ah + "," + this.d + "]->[" + this.ka + "," + this.c + "," + this.ab + "," + this.x + "]";
        }
    }
}
