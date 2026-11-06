package com.byazt.ihe;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 588, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g implements m, Function {
    public volatile m hw;
    public volatile Function pr;

    public g(m mVar) {
        this.hw = mVar;
    }

    public g(Function function) {
        this.pr = function;
    }

    @Override // com.byazt.ihe.m
    public boolean a() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ihe.m
    public String aj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void aj(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 48);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return this.hw.pr();
            case 2:
                return Integer.valueOf(this.hw.hw());
            case 3:
                return Integer.valueOf(this.hw.hn());
            case 4:
                return this.hw.x();
            case 5:
                return this.hw.c();
            case 6:
                this.hw.pr((String) sparseArray.get(1));
                return null;
            case 7:
                this.hw.pr(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 8:
                return Integer.valueOf(this.hw.uc());
            case 9:
                return Integer.valueOf(this.hw.fw());
            case 10:
                return Boolean.valueOf(this.hw.zo());
            case 11:
                this.hw.pr(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 12:
                return this.hw.aj();
            case 13:
                this.hw.hw((String) sparseArray.get(1));
                return null;
            case 14:
                return Integer.valueOf(this.hw.vk());
            case 15:
                this.hw.hw(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 16:
                return Integer.valueOf(this.hw.w());
            case 17:
                this.hw.hn(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 18:
                return this.hw.k();
            case 19:
                this.hw.pr((List<String>) sparseArray.get(1));
                return null;
            case 20:
                return this.hw.m();
            case 21:
                this.hw.hn((String) sparseArray.get(1));
                return null;
            case 22:
                return Long.valueOf(this.hw.g());
            case 23:
                this.hw.pr(((Long) sparseArray.get(1)).longValue());
                return null;
            case 24:
                return Boolean.valueOf(this.hw.ho());
            case 25:
                this.hw.hw(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 26:
                return Long.valueOf(this.hw.nt());
            case 27:
                return Boolean.valueOf(this.hw.yb());
            case 28:
                return this.hw.lb();
            case 29:
                this.hw.x((String) sparseArray.get(1));
                return null;
            case 30:
                return Integer.valueOf(this.hw.qa());
            case 31:
                this.hw.x(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 32:
                return Boolean.valueOf(this.hw.a());
            case 33:
                return Float.valueOf(this.hw.cz());
            case 34:
                return this.hw.ny();
            case 35:
                return this.hw.fo();
            case 36:
                return Integer.valueOf(this.hw.rc());
            case 37:
                this.hw.c(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 38:
                this.hw.pr((String) sparseArray.get(1), sparseArray.get(2));
                return null;
            case 39:
                return this.hw.c((String) sparseArray.get(1));
            case 40:
                return this.hw.uc((String) sparseArray.get(1));
            case 41:
                return Integer.valueOf(this.hw.z());
            case 42:
                this.hw.uc(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 43:
                return Integer.valueOf(this.hw.b());
            case 44:
                this.hw.fw(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 45:
                return Integer.valueOf(this.hw.iu());
            case 46:
                this.hw.zo(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 47:
                return Integer.valueOf(this.hw.ve());
            case 48:
                this.hw.aj(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 49:
                return Integer.valueOf(this.hw.gz());
            case 50:
                this.hw.vk(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 51:
                c cVarNl = this.hw.nl();
                return cVarNl != null ? new uc(cVarNl) : cVarNl;
            case 52:
                Object ucVar = sparseArray.get(1);
                if (ucVar != null) {
                    ucVar = new uc((Function) ucVar);
                }
                this.hw.pr((c) ucVar);
                return null;
            case 53:
                c cVarY = this.hw.y();
                return cVarY != null ? new uc(cVarY) : cVarY;
            case 54:
                c cVarWw = this.hw.ww();
                return cVarWw != null ? new uc(cVarWw) : cVarWw;
            case 55:
                Object ucVar2 = sparseArray.get(1);
                if (ucVar2 != null) {
                    ucVar2 = new uc((Function) ucVar2);
                }
                this.hw.hw((c) ucVar2);
                return null;
            default:
                return null;
        }
    }

    @Override // com.byazt.ihe.m
    public int b() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 43);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.m
    public Object c(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 39);
        sparseArray.put(1, str);
        return this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public String c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void c(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public float cz() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        return ((Float) this.pr.apply(sparseArray)).floatValue();
    }

    @Override // com.byazt.ihe.m
    public String fo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public int fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.m
    public void fw(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 44);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public long g() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.ihe.m
    public int gz() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 49);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.m
    public int hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.m
    public void hn(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void hn(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public boolean ho() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ihe.m
    public int hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.m
    public void hw(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void hw(c cVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 55);
        if (cVar != null) {
            cVar = new uc(cVar);
        }
        sparseArray.put(1, cVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void hw(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void hw(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        sparseArray.put(1, Boolean.valueOf(z));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public int iu() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 45);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.m
    public List k() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        return (List) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public String lb() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 28);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public String m() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        return (String) this.pr.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.ihe.m
    public c nl() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 51);
        ?? Apply = this.pr.apply(sparseArray);
        ?? ucVar = Apply;
        if (Apply != 0) {
            ucVar = new uc((Function) Apply);
        }
        return (c) ucVar;
    }

    @Override // com.byazt.ihe.m
    public long nt() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.ihe.m
    public String ny() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public JSONObject pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (JSONObject) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void pr(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void pr(long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        sparseArray.put(1, Long.valueOf(j));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void pr(c cVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 52);
        if (cVar != null) {
            cVar = new uc(cVar);
        }
        sparseArray.put(1, cVar);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void pr(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void pr(String str, Object obj) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 38);
        sparseArray.put(1, str);
        sparseArray.put(2, obj);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void pr(List list) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        sparseArray.put(1, list);
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void pr(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, Boolean.valueOf(z));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public int qa() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.m
    public int rc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.m
    public int uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.m
    public Object uc(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 40);
        sparseArray.put(1, str);
        return this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void uc(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 42);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public int ve() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 47);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.m
    public int vk() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.m
    public void vk(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 50);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public int w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.ihe.m
    public c ww() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 54);
        ?? Apply = this.pr.apply(sparseArray);
        ?? ucVar = Apply;
        if (Apply != 0) {
            ucVar = new uc((Function) Apply);
        }
        return (c) ucVar;
    }

    @Override // com.byazt.ihe.m
    public String x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void x(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public void x(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        sparseArray.put(1, str);
        this.pr.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.ihe.m
    public c y() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 53);
        ?? Apply = this.pr.apply(sparseArray);
        ?? ucVar = Apply;
        if (Apply != 0) {
            ucVar = new uc((Function) Apply);
        }
        return (c) ucVar;
    }

    @Override // com.byazt.ihe.m
    public boolean yb() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.ihe.m
    public int z() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 41);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.ihe.m
    public void zo(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 46);
        sparseArray.put(1, Integer.valueOf(i));
        this.pr.apply(sparseArray);
    }

    @Override // com.byazt.ihe.m
    public boolean zo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }
}
