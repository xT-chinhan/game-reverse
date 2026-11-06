package com.byazt.zs;

import android.content.Context;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.byakv.z.SoftDecTool;
import com.byazt.sd.a;
import com.byazt.sd.iu;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 14, 121})
public class x implements com.byazt.vkw.fw, Function {
    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case -1:
                c();
                return null;
            case 0:
            case 2:
            default:
                return null;
            case 1:
                return pr();
            case 3:
                return Boolean.valueOf(pr((String) sparseArray.get(1), (String) sparseArray.get(2)));
            case 4:
                return Boolean.valueOf(pr((String) sparseArray.get(1)));
            case 5:
                pr((MotionEvent) sparseArray.get(1));
                return null;
            case 6:
                return pr((String) sparseArray.get(1), ((Long) sparseArray.get(2)).longValue(), ((Integer) sparseArray.get(3)).intValue(), ((Boolean) sparseArray.get(4)).booleanValue());
            case 7:
                pr(((Long) sparseArray.get(1)).longValue(), ((Integer) sparseArray.get(2)).intValue());
                return null;
            case 8:
                return hw((String) sparseArray.get(1), (String) sparseArray.get(2));
            case 9:
                return hw();
            case 10:
                return hn();
            case 11:
                pr(((Double) sparseArray.get(1)).doubleValue(), ((Long) sparseArray.get(2)).longValue());
                return null;
            case 12:
                Object zoVar = sparseArray.get(1);
                if (zoVar != null) {
                    zoVar = new com.byazt.vkw.zo((Function) zoVar);
                }
                pr((com.byazt.vkw.fw.pr) zoVar);
                return null;
            case 13:
                return Boolean.valueOf(x());
            case 14:
                hw((String) sparseArray.get(1));
                return null;
            case 15:
                pr(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 16:
                pr((JSONObject) sparseArray.get(1));
                return null;
            case 17:
                return Boolean.valueOf(hw(((Integer) sparseArray.get(1)).intValue()));
        }
    }

    public x(com.byazt.vlp.pr prVar) {
        pr(prVar.pr());
    }

    @Override // com.byazt.vkw.fw
    public String pr() {
        return com.byazt.yi.zo.pr(com.byazt.wt.hn.pr);
    }

    @Override // com.byazt.vkw.fw
    public boolean pr(String str, String str2) throws Exception {
        return com.byazt.yi.uc.pr(str, str2);
    }

    @Override // com.byazt.vkw.fw
    public boolean pr(String str) {
        return com.byazt.yi.uc.pr(str);
    }

    @Override // com.byazt.vkw.fw
    public void pr(MotionEvent motionEvent) {
        com.byazt.yi.zo.pr(motionEvent);
    }

    @Override // com.byazt.vkw.fw
    public String pr(String str, long j, int i, boolean z) {
        return com.byazt.yi.zo.pr(str, j, i, z);
    }

    @Override // com.byazt.vkw.fw
    public void pr(long j, int i) {
        com.byazt.yi.zo.pr(j, i);
    }

    @Override // com.byazt.vkw.fw
    public String hw(String str, String str2) {
        return com.byazt.yi.zo.pr(str, str2);
    }

    @Override // com.byazt.vkw.fw
    public Context hw() {
        return com.byazt.yi.zo.hn();
    }

    @Override // com.byazt.vkw.fw
    public String hn() {
        return com.byazt.yi.zo.hw();
    }

    @Override // com.byazt.vkw.fw
    public void pr(double d, long j) {
        SoftDecTool.ua(d, j);
        Object[] objArr = {"predict probability ", Double.valueOf(SoftDecTool.acs)};
    }

    @Override // com.byazt.vkw.fw
    public void pr(final com.byazt.vkw.fw.pr prVar) {
        com.byazt.wqv.x.pr().pr(new com.byazt.wqv.x.pr() { // from class: com.byazt.zs.x.1
            @Override // com.byazt.wqv.x.pr
            public void pr(JSONObject jSONObject) {
                prVar.pr(jSONObject);
            }
        });
    }

    @Override // com.byazt.vkw.fw
    public boolean x() {
        return com.byazt.wqv.x.pr().hw();
    }

    private void pr(final com.byazt.vkw.fw.hw hwVar) {
        com.byazt.yi.aj.pr prVarPr = new com.byazt.yi.aj.pr(a.getContext(), iu.uc(), "7714").pr(true);
        prVarPr.pr(new com.byazt.yi.vk() { // from class: com.byazt.zs.x.2
            @Override // com.byazt.yi.vk
            public void pr(long j, boolean z) {
                hwVar.pr(j, z);
            }

            @Override // com.byazt.yi.vk
            public void pr(String str, JSONObject jSONObject) {
                hwVar.pr(str, jSONObject);
            }

            @Override // com.byazt.yi.vk
            public long pr() {
                return hwVar.pr();
            }
        });
        com.byazt.yi.zo.pr(prVarPr.pr());
    }

    public void c() {
        com.byazt.yi.zo.pr();
    }

    @Override // com.byazt.vkw.fw
    public void hw(String str) {
        com.byazt.wqv.hw.pr().hw(str);
    }

    @Override // com.byazt.vkw.fw
    public void pr(int i) {
        com.byazt.wqv.hw.pr().pr(i);
    }

    @Override // com.byazt.vkw.fw
    public void pr(JSONObject jSONObject) {
        com.byazt.wqv.c.pr().pr(jSONObject);
    }

    @Override // com.byazt.vkw.fw
    public boolean hw(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zHw = com.byazt.wqv.c.pr().hw();
        boolean z = ((long) (i - 1)) % com.byazt.wqv.c.pr().c() == 0;
        boolean z2 = jCurrentTimeMillis - com.byazt.wqv.x.pr().x() > com.byazt.wqv.c.pr().x();
        boolean zHn = com.byazt.wqv.x.pr().hn();
        com.byazt.wqv.c.pr();
        com.byazt.wqv.c.pr();
        com.byazt.wqv.c.pr();
        com.byazt.wqv.c.pr();
        double d = SoftDecTool.acs;
        long j = SoftDecTool.act;
        return z && z2 && zHw && !zHn;
    }
}
