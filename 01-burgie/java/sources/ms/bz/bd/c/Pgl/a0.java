package ms.bz.bd.c.Pgl;

import java.lang.reflect.Method;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
final class a0 extends pbls.pgla {
    a0() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    public final Object pr(long j, String str, Object obj) throws Throwable {
        String[] strArr = {(String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "22b385", new byte[]{44, 32, 1, 72}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "134cc7", new byte[]{45, 56, 82, 30}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "c87893", new byte[]{100, 51, 82, 67}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9005dd", new byte[]{37, 55, 74, 91, 78}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "8c2b48", new byte[]{59, 100, 69, 27, 2}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "24fc75", new byte[]{59, 63, 20, 24, 5, 43}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "fbdccf", new byte[]{127, 117, 22, 0, 89, 120}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4871e0", new byte[]{42, 52, 65, 85, 86, 50, 36}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9a87c8", new byte[]{36, 106, 69, 70, 93, 40, 63}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "800487", new byte[]{58, 51, 78, 83, 18, 46, 60}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1eca8a", new byte[]{56, 119, 31, 6, 2, 114}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "cea960", new byte[]{60, 107, 23, 88, 0, 105}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "005ed8", new byte[]{51, 55, 71, 29, 86, 42}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b276eb", new byte[]{114, 35, 81, 81}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d9e942", new byte[]{119, 55, 23, 78, 0, 54, 111, 25, 38, 98}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "369247", new byte[]{47, 49, 67, 82, 30}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9eb352", new byte[]{36, 110, 19, 84, 31}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d47dc2", new byte[]{122, 38, 72, 5, 79}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "33dad9", new byte[]{42, 62, 25, 26, 73})};
        HashSet hashSet = new HashSet();
        try {
            Method declaredMethod = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "164ed7", new byte[]{33, 58, 67, 3, 84, 41, 54, 89, 106, 38, 110, 7, 66, 3, 77, 41, 49, 18, 72, 52, 46, 53, 64, 20, 73})).getDeclaredMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9f47cf", new byte[]{36, 109, 84, 87, 111, 116, 40, 81, 108, 100, 45, 119}), new Class[0]);
            declaredMethod.setAccessible(true);
            String[] strArr2 = (String[]) declaredMethod.invoke(null, new Object[0]);
            if (strArr2 != null) {
                for (String str2 : strArr2) {
                    for (int i = 0; i < 19; i++) {
                        String str3 = strArr[i];
                        if (str2.toLowerCase().contains(str3)) {
                            hashSet.add(str3);
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return hashSet.toString();
    }
}
