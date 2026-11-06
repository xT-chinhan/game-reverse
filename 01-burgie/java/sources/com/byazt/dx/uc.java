package com.byazt.dx;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 229, 5})
public class uc {
    public pr a;
    public List<com.byazt.cg.zo> aj;
    public Map<String, com.byazt.uxi.hn> c;
    public SparseArray<com.byazt.uxi.x> fw;
    public boolean g;
    public Map<String, List<com.byazt.cg.zo>> hn;
    public float k;
    public hw lb;
    public float m;
    public x nt;
    public hn qa;
    public List<com.byazt.uxi.fw> uc;
    public Rect vk;
    public float w;
    public Map<String, aj> x;
    public LongSparseArray<com.byazt.cg.zo> zo;
    public final qa pr = new qa();
    public final HashSet<String> hw = new HashSet<>();
    public int ho = 0;
    public String yb = "";

    @com.byazt.vzx.pr(pr = {0, 1, 229, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_VIDEO_WINDOW_SIZE})
    public static class hn {
        public String c;
        public JSONArray hn;
        public int[][] hw;
        public String pr;
        public int x = 10;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 229, MediaPlayer.MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED})
    public static class hw {
        public String aj;
        public int c;
        public JSONArray fw;
        public Map<String, Object> hn;
        public Map<String, Object> hw;
        public int pr;
        public String uc;
        public int x;
        public com.byazt.rwn.x zo;
    }

    @com.byazt.vzx.pr(pr = {0, 1, 229, 954})
    public static class x {
        public JSONArray aj;
        public int[] c;
        public JSONArray fw;
        public String hn;
        public String hw;
        public String[] k;
        public int m;
        public int pr;
        public String uc;
        public int vk;
        public int w;
        public String x;
        public String zo;
    }

    public void pr(Rect rect, float f, float f2, float f3, List<com.byazt.cg.zo> list, LongSparseArray<com.byazt.cg.zo> longSparseArray, Map<String, List<com.byazt.cg.zo>> map, Map<String, aj> map2, SparseArray<com.byazt.uxi.x> sparseArray, Map<String, com.byazt.uxi.hn> map3, List<com.byazt.uxi.fw> list2, x xVar, String str, hw hwVar, hn hnVar, pr prVar) {
        this.vk = rect;
        this.w = f;
        this.k = f2;
        this.m = f3;
        this.aj = list;
        this.zo = longSparseArray;
        this.hn = map;
        this.x = map2;
        this.fw = sparseArray;
        this.c = map3;
        this.uc = list2;
        this.nt = xVar;
        this.yb = str;
        this.lb = hwVar;
        this.qa = hnVar;
        this.a = prVar;
    }

    public void pr(String str) {
        com.byazt.ptr.uc.hw(str);
        this.hw.add(str);
    }

    public void pr(boolean z) {
        this.g = z;
    }

    public void pr(int i) {
        this.ho += i;
    }

    public boolean pr() {
        return this.g;
    }

    public int hw() {
        return this.ho;
    }

    public void hw(boolean z) {
        this.pr.pr(z);
    }

    public qa hn() {
        return this.pr;
    }

    public com.byazt.cg.zo pr(long j) {
        return this.zo.get(j);
    }

    public Rect x() {
        return this.vk;
    }

    public float c() {
        return (long) ((lb() / this.m) * 1000.0f);
    }

    public float uc() {
        return this.w;
    }

    public float fw() {
        return this.k;
    }

    public float pr(float f) {
        return com.byazt.ptr.aj.pr(this.w, this.k, f);
    }

    public x zo() {
        return this.nt;
    }

    public String aj() {
        return this.yb;
    }

    public pr vk() {
        return this.a;
    }

    public hn w() {
        return this.qa;
    }

    public hw k() {
        return this.lb;
    }

    public float m() {
        return this.m;
    }

    public List<com.byazt.cg.zo> g() {
        return this.aj;
    }

    public List<com.byazt.cg.zo> hw(String str) {
        return this.hn.get(str);
    }

    public SparseArray<com.byazt.uxi.x> ho() {
        return this.fw;
    }

    public Map<String, com.byazt.uxi.hn> nt() {
        return this.c;
    }

    public com.byazt.uxi.fw hn(String str) {
        int size = this.uc.size();
        for (int i = 0; i < size; i++) {
            com.byazt.uxi.fw fwVar = this.uc.get(i);
            if (fwVar.pr(str)) {
                return fwVar;
            }
        }
        return null;
    }

    public Map<String, aj> yb() {
        return this.x;
    }

    public float lb() {
        return this.k - this.w;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<com.byazt.cg.zo> it = this.aj.iterator();
        while (it.hasNext()) {
            sb.append(it.next().pr("\t"));
        }
        return sb.toString();
    }

    @com.byazt.vzx.pr(pr = {0, 1, 229, 129})
    public static class pr {
        public String hn;
        public String hw;
        public String pr;
        public String x;
        public float c = -1.0f;
        public float uc = -1.0f;
        public float fw = -1.0f;
        public float zo = -1.0f;

        public String toString() {
            return "area[" + this.pr + "," + this.hw + "," + this.hn + "," + this.x + "]->[" + this.c + "," + this.uc + "," + this.fw + "," + this.zo + "]";
        }
    }
}
