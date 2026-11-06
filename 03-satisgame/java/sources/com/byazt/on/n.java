package com.byazt.on;

import com.byazt.xz.l;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 789, 19})
public class n implements com.byazt.sx.s {
    @Override // com.byazt.sx.s
    public boolean qg(String str) {
        return "tick".equals(str);
    }

    @Override // com.byazt.sx.s
    public boolean n(String str, String str2, int i, Map<String, Object> map, Map<String, Object> map2, l lVar) {
        if (lVar == null) {
            return true;
        }
        lVar.n(map2);
        return true;
    }
}
