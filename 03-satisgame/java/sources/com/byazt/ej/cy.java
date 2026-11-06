package com.byazt.ej;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsIsDownloadSource, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy implements k, Function {
    public volatile Function n;
    public volatile k qg;

    public cy(k kVar) {
        this.qg = kVar;
    }

    public cy(Function function) {
        this.n = function;
    }

    @Override // com.byazt.ej.k
    public boolean a() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.qg.n();
            case 2:
                return Integer.valueOf(this.qg.qg());
            case 3:
                return Integer.valueOf(this.qg.s());
            case 4:
                return this.qg.q();
            case 5:
                return this.qg.l();
            case 6:
                this.qg.n((String) sparseArray.get(1));
                return null;
            case 7:
                this.qg.n(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 8:
                return Integer.valueOf(this.qg.w());
            case 9:
                return Integer.valueOf(this.qg.x());
            case 10:
                return Boolean.valueOf(this.qg.fs());
            case 11:
                this.qg.n(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 12:
                return this.qg.rv();
            case 13:
                this.qg.qg((String) sparseArray.get(1));
                return null;
            case 14:
                return Integer.valueOf(this.qg.tj());
            case 15:
                this.qg.qg(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 16:
                return Integer.valueOf(this.qg.cp());
            case 17:
                this.qg.s(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 18:
                return this.qg.d();
            case 19:
                this.qg.n((List<String>) sparseArray.get(1));
                return null;
            case 20:
                return this.qg.oa();
            case 21:
                this.qg.s((String) sparseArray.get(1));
                return null;
            case 22:
                return Long.valueOf(this.qg.sz());
            case 23:
                this.qg.n(((Long) sparseArray.get(1)).longValue());
                return null;
            case 24:
                return Boolean.valueOf(this.qg.k());
            case 25:
                this.qg.qg(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 26:
                return Long.valueOf(this.qg.cy());
            case 27:
                return Boolean.valueOf(this.qg.hd());
            case 28:
                return this.qg.cd();
            case 29:
                this.qg.q((String) sparseArray.get(1));
                return null;
            case 30:
                return Integer.valueOf(this.qg.um());
            case 31:
                this.qg.q(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 32:
                return Boolean.valueOf(this.qg.a());
            case 33:
                return Float.valueOf(this.qg.py());
            case 34:
                return this.qg.ou();
            case 35:
                return this.qg.wm();
            case 36:
                return Integer.valueOf(this.qg.m());
            case 37:
                this.qg.l(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 38:
                this.qg.n((String) sparseArray.get(1), sparseArray.get(2));
                return null;
            case 39:
                return this.qg.l((String) sparseArray.get(1));
            case 40:
                return this.qg.w((String) sparseArray.get(1));
            case 41:
                return Integer.valueOf(this.qg.hu());
            case 42:
                this.qg.w(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 43:
                return Integer.valueOf(this.qg.h());
            case 44:
                this.qg.x(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 45:
                return Integer.valueOf(this.qg.t());
            case 46:
                this.qg.fs(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 47:
                return Integer.valueOf(this.qg.ur());
            case 48:
                this.qg.rv(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 49:
                return Integer.valueOf(this.qg.bb());
            case 50:
                this.qg.tj(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 51:
                l lVarLn = this.qg.ln();
                return lVarLn != null ? new w(lVarLn) : lVarLn;
            case 52:
                Object wVar = sparseArray.get(1);
                if (wVar != null) {
                    wVar = new w((Function) wVar);
                }
                this.qg.n((l) wVar);
                return null;
            case 53:
                l lVarLh = this.qg.lh();
                return lVarLh != null ? new w(lVarLh) : lVarLh;
            case 54:
                l lVarV = this.qg.v();
                return lVarV != null ? new w(lVarV) : lVarV;
            case 55:
                Object wVar2 = sparseArray.get(1);
                if (wVar2 != null) {
                    wVar2 = new w((Function) wVar2);
                }
                this.qg.qg((l) wVar2);
                return null;
            default:
                return null;
        }
    }

    @Override // com.byazt.ej.k
    public int bb() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 49);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.k
    public String cd() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 28);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public int cp() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.k
    public long cy() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.ej.k
    public List d() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        return (List) this.n.apply(sparseArray);
    }

    public boolean equals(Object obj) {
        Object obj2;
        if (obj == null) {
            return false;
        }
        if (this.n != null) {
            obj2 = this.n;
        } else {
            if (this.qg == null) {
                return super.equals(obj);
            }
            obj2 = this.qg;
        }
        return obj.equals(obj2);
    }

    @Override // com.byazt.ej.k
    public void fs(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 46);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public boolean fs() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.ej.k
    public int h() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 43);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    public int hashCode() {
        Object obj;
        if (this.n != null) {
            obj = this.n;
        } else {
            if (this.qg == null) {
                return super.hashCode();
            }
            obj = this.qg;
        }
        return obj.hashCode();
    }

    @Override // com.byazt.ej.k
    public boolean hd() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.ej.k
    public int hu() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 41);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.k
    public boolean k() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Boolean) objApply).booleanValue();
        }
        return false;
    }

    @Override // com.byazt.ej.k
    public Object l(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 39);
        sparseArray.put(1, str);
        return this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public String l() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void l(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.ej.k
    public l lh() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 53);
        ?? Apply = this.n.apply(sparseArray);
        ?? wVar = Apply;
        if (Apply != 0) {
            wVar = new w((Function) Apply);
        }
        return (l) wVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.ej.k
    public l ln() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 51);
        ?? Apply = this.n.apply(sparseArray);
        ?? wVar = Apply;
        if (Apply != 0) {
            wVar = new w((Function) Apply);
        }
        return (l) wVar;
    }

    @Override // com.byazt.ej.k
    public int m() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.k
    public JSONObject n() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (JSONObject) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void n(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void n(long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        sparseArray.put(1, Long.valueOf(j));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void n(l lVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 52);
        if (lVar != null) {
            lVar = new w(lVar);
        }
        sparseArray.put(1, lVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void n(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void n(String str, Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 38);
        sparseArray.put(1, str);
        sparseArray.put(2, obj);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void n(List list) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        sparseArray.put(1, list);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void n(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, Boolean.valueOf(z));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public String oa() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public String ou() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public float py() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Float) objApply).floatValue();
        }
        return 0.0f;
    }

    @Override // com.byazt.ej.k
    public String q() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void q(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void q(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public int qg() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.k
    public void qg(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void qg(l lVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 55);
        if (lVar != null) {
            lVar = new w(lVar);
        }
        sparseArray.put(1, lVar);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void qg(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void qg(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        sparseArray.put(1, Boolean.valueOf(z));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public String rv() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void rv(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 48);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public int s() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.k
    public void s(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void s(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        sparseArray.put(1, str);
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public long sz() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Long) objApply).longValue();
        }
        return 0L;
    }

    @Override // com.byazt.ej.k
    public int t() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 45);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.k
    public int tj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.k
    public void tj(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 50);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public int um() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.k
    public int ur() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 47);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.ej.k
    public l v() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 54);
        ?? Apply = this.n.apply(sparseArray);
        ?? wVar = Apply;
        if (Apply != 0) {
            wVar = new w((Function) Apply);
        }
        return (l) wVar;
    }

    @Override // com.byazt.ej.k
    public int w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.k
    public Object w(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 40);
        sparseArray.put(1, str);
        return this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public void w(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 42);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public String wm() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        return (String) this.n.apply(sparseArray);
    }

    @Override // com.byazt.ej.k
    public int x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        Object objApply = this.n.apply(sparseArray);
        if (objApply != null) {
            return ((Integer) objApply).intValue();
        }
        return 0;
    }

    @Override // com.byazt.ej.k
    public void x(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 44);
        sparseArray.put(1, Integer.valueOf(i));
        this.n.apply(sparseArray);
    }
}
