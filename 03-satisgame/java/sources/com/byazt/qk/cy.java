package com.byazt.qk;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, AVMDLDataLoader.KeyIsMaxIpCountEachDomain, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE})
public class cy implements k, Function {
    public volatile Function n;
    public volatile k qg;

    public cy(k kVar) {
        this.qg = kVar;
    }

    public cy(Function function) {
        this.n = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int iIntValue = ((Integer) sparseArray.get(0)).intValue();
        if (iIntValue == 1) {
            Object dVar = sparseArray.get(1);
            if (dVar != null) {
                dVar = new d((Function) dVar);
            }
            rv rvVarN = this.qg.n((rv) dVar);
            return rvVarN != null ? new d(rvVarN) : rvVarN;
        }
        if (iIntValue != 2) {
            return null;
        }
        Object szVar = sparseArray.get(1);
        if (szVar != null) {
            szVar = new sz((Function) szVar);
        }
        oa oaVarN = this.qg.n((oa) szVar);
        return oaVarN != null ? new sz(oaVarN) : oaVarN;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // com.byazt.qk.k
    public oa n(oa oaVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        if (oaVar != null) {
            oaVar = new sz(oaVar);
        }
        sparseArray.put(1, oaVar);
        ?? Apply = this.n.apply(sparseArray);
        ?? szVar = Apply;
        if (Apply != 0) {
            szVar = new sz((Function) Apply);
        }
        return (oa) szVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8 */
    @Override // com.byazt.qk.k
    public rv n(rv rvVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (rvVar != null) {
            rvVar = new d(rvVar);
        }
        sparseArray.put(1, rvVar);
        ?? Apply = this.n.apply(sparseArray);
        ?? dVar = Apply;
        if (Apply != 0) {
            dVar = new d((Function) Apply);
        }
        return (rv) dVar;
    }
}
