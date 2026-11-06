package com.byazt.tka;

import android.util.SparseArray;
import android.view.MotionEvent;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 689, 13})
public class w implements com.byazt.vf.x, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return n();
            case 2:
                return Boolean.valueOf(n((String) sparseArray.get(1), (String) sparseArray.get(2)));
            case 3:
                return Boolean.valueOf(n((String) sparseArray.get(1)));
            case 4:
                n((MotionEvent) sparseArray.get(1));
                return null;
            case 5:
                return n((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue(), ((Integer) sparseArray.get(3)).intValue(), ((Boolean) sparseArray.get(4)).booleanValue());
            case 6:
                n(((Long) sparseArray.get(1)).longValue(), ((Integer) sparseArray.get(2)).intValue());
                return null;
            case 7:
                return qg((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 8:
                return qg();
            case 9:
                qg((String) sparseArray.get(1));
                return null;
            case 10:
                n(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 11:
                n((JSONObject) sparseArray.get(1));
                return null;
            case 12:
                n(((Integer) sparseArray.get(1)).intValue(), ((Integer) sparseArray.get(2)).intValue(), ((Boolean) sparseArray.get(3)).booleanValue());
                return null;
            default:
                return null;
        }
    }

    public w(com.byazt.xl.n nVar) {
        n(nVar);
    }

    private void n(com.byazt.xl.n nVar) {
        tj.n(cp.n(nVar.qg(), nVar.s(), nVar.q(), nVar.l(), nVar));
    }

    @Override // com.byazt.vf.x
    public String n() {
        return tj.n();
    }

    @Override // com.byazt.vf.x
    public boolean n(String str, String str2) throws Exception {
        return x.n(str, str2);
    }

    @Override // com.byazt.vf.x
    public boolean n(String str) {
        return x.n(str);
    }

    @Override // com.byazt.vf.x
    public void n(MotionEvent motionEvent) {
        tj.n(motionEvent);
    }

    @Override // com.byazt.vf.x
    public String n(String str, long j, int i, boolean z) {
        return tj.n(str, j, i, z);
    }

    @Override // com.byazt.vf.x
    public void n(long j, int i) {
        tj.n(j, i);
    }

    @Override // com.byazt.vf.x
    public String qg(String str, String str2) {
        return tj.n(str, str2);
    }

    @Override // com.byazt.vf.x
    public String qg() {
        return tj.qg();
    }

    @Override // com.byazt.vf.x
    public void qg(String str) {
        com.byazt.zqc.qg.n().qg(str);
    }

    @Override // com.byazt.vf.x
    public void n(int i) {
        com.byazt.zqc.qg.n().n(i);
    }

    @Override // com.byazt.vf.x
    public void n(JSONObject jSONObject) {
        com.byazt.zqc.l.n().n(jSONObject);
    }

    @Override // com.byazt.vf.x
    public void n(int i, int i2, boolean z) {
        fs.n(i, i2, z);
    }
}
