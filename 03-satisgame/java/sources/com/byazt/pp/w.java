package com.byazt.pp;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 13})
public class w {
    public n a;
    public qg cd;
    public float cp;
    public q cy;
    public float d;
    public LongSparseArray<com.byazt.eg.fs> fs;
    public Map<String, com.byazt.ld.s> l;
    public float oa;
    public Map<String, rv> q;
    public List<com.byazt.eg.fs> rv;
    public Map<String, List<com.byazt.eg.fs>> s;
    public boolean sz;
    public Rect tj;
    public s um;
    public List<com.byazt.ld.x> w;
    public SparseArray<com.byazt.ld.q> x;
    public final um n = new um();
    public final HashSet<String> qg = new HashSet<>();
    public int k = 0;
    public String hd = "";

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, AVMDLDataLoader.KeyIsGetVersionInfo})
    public static class q {
        public int cp;
        public String[] d;
        public String fs;
        public int[] l;
        public int n;
        public int oa;
        public String q;
        public String qg;
        public JSONArray rv;
        public String s;
        public int tj;
        public String w;
        public JSONArray x;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ})
    public static class qg {
        public com.byazt.vk.q fs;
        public int l;
        public int n;
        public int q;
        public Map<String, Object> qg;
        public String rv;
        public Map<String, Object> s;
        public String w;
        public JSONArray x;
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_OPT_SUB_FIRST_LOAD_TIME})
    public static class s {
        public String l;
        public String n;
        public int q = 10;
        public int[][] qg;
        public JSONArray s;
    }

    public void n(Rect rect, float f, float f2, float f3, List<com.byazt.eg.fs> list, LongSparseArray<com.byazt.eg.fs> longSparseArray, Map<String, List<com.byazt.eg.fs>> map, Map<String, rv> map2, SparseArray<com.byazt.ld.q> sparseArray, Map<String, com.byazt.ld.s> map3, List<com.byazt.ld.x> list2, q qVar, String str, qg qgVar, s sVar, n nVar) {
        this.tj = rect;
        this.cp = f;
        this.d = f2;
        this.oa = f3;
        this.rv = list;
        this.fs = longSparseArray;
        this.s = map;
        this.q = map2;
        this.x = sparseArray;
        this.l = map3;
        this.w = list2;
        this.cy = qVar;
        this.hd = str;
        this.cd = qgVar;
        this.um = sVar;
        this.a = nVar;
    }

    public void n(String str) {
        com.byazt.nu.w.qg(str);
        this.qg.add(str);
    }

    public void n(boolean z) {
        this.sz = z;
    }

    public void n(int i) {
        this.k += i;
    }

    public boolean n() {
        return this.sz;
    }

    public int qg() {
        return this.k;
    }

    public void qg(boolean z) {
        this.n.n(z);
    }

    public um s() {
        return this.n;
    }

    public com.byazt.eg.fs n(long j) {
        return this.fs.get(j);
    }

    public Rect q() {
        return this.tj;
    }

    public float l() {
        return (long) ((cd() / this.oa) * 1000.0f);
    }

    public float w() {
        return this.cp;
    }

    public float x() {
        return this.d;
    }

    public float n(float f) {
        return com.byazt.nu.rv.n(this.cp, this.d, f);
    }

    public q fs() {
        return this.cy;
    }

    public String rv() {
        return this.hd;
    }

    public n tj() {
        return this.a;
    }

    public s cp() {
        return this.um;
    }

    public qg d() {
        return this.cd;
    }

    public float oa() {
        return this.oa;
    }

    public List<com.byazt.eg.fs> sz() {
        return this.rv;
    }

    public List<com.byazt.eg.fs> qg(String str) {
        return this.s.get(str);
    }

    public SparseArray<com.byazt.ld.q> k() {
        return this.x;
    }

    public Map<String, com.byazt.ld.s> cy() {
        return this.l;
    }

    public com.byazt.ld.x s(String str) {
        int size = this.w.size();
        for (int i = 0; i < size; i++) {
            com.byazt.ld.x xVar = this.w.get(i);
            if (xVar.n(str)) {
                return xVar;
            }
        }
        return null;
    }

    public Map<String, rv> hd() {
        return this.q;
    }

    public float cd() {
        return this.d - this.cp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.byazt.eg.fs> it = this.rv.iterator();
        while (it.hasNext()) {
            sb.append(it.next().n("\t"));
        }
        return sb.toString();
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, 108})
    public static class n {
        public String n;
        public String q;
        public String qg;
        public String s;
        public float l = -1.0f;
        public float w = -1.0f;
        public float x = -1.0f;
        public float fs = -1.0f;

        public String toString() {
            return "area[" + this.n + "," + this.qg + "," + this.s + "," + this.q + "]->[" + this.l + "," + this.w + "," + this.x + "," + this.fs + "]";
        }
    }
}
