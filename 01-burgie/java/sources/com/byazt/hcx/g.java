package com.byazt.hcx;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1225, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public class g implements m, Function {
    public volatile m hw;
    public volatile Function pr;

    public g(m mVar) {
        this.hw = mVar;
    }

    public g(Function function) {
        this.pr = function;
    }

    @Override // com.byazt.hcx.m
    public long aj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return ((Long) this.pr.apply(sparseArray)).longValue();
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return Integer.valueOf(this.hw.pr());
            case 2:
                return this.hw.hw();
            case 3:
                return this.hw.hn();
            case 4:
                return this.hw.pr((String) sparseArray.get(1));
            case 5:
                return this.hw.pr((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 6:
                return this.hw.x();
            case 7:
                return this.hw.c();
            case 8:
                vk vkVarUc = this.hw.uc();
                return vkVarUc != null ? new w(vkVarUc) : vkVarUc;
            case 9:
                return Boolean.valueOf(this.hw.fw());
            case 10:
                return this.hw.zo();
            case 11:
                return Long.valueOf(this.hw.aj());
            case 12:
                return this.hw.vk();
            case 13:
                return this.hw.w();
            case 14:
                return this.hw.k();
            default:
                return null;
        }
    }

    @Override // com.byazt.hcx.m
    public JSONObject c() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (JSONObject) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.m
    public boolean fw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Boolean) this.pr.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.hcx.m
    public Map hn() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return (Map) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.m
    public String hw() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.m
    public String k() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.m
    public int pr() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Integer) this.pr.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.hcx.m
    public String pr(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, str);
        return (String) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.m
    public String pr(String str, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        sparseArray.put(1, str);
        sparseArray.put(2, str2);
        return (String) this.pr.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.hcx.m
    public vk uc() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        ?? Apply = this.pr.apply(sparseArray);
        ?? wVar = Apply;
        if (Apply != 0) {
            wVar = new w((Function) Apply);
        }
        return (vk) wVar;
    }

    @Override // com.byazt.hcx.m
    public File vk() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return (File) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.m
    public Throwable w() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return (Throwable) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.m
    public byte[] x() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (byte[]) this.pr.apply(sparseArray);
    }

    @Override // com.byazt.hcx.m
    public String zo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return (String) this.pr.apply(sparseArray);
    }
}
