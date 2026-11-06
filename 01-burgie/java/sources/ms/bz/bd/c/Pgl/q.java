package ms.bz.bd.c.Pgl;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
final class q extends pbls.pgla {
    q() {
    }

    @Override // ms.bz.bd.c.Pgl.pbls.pgla
    protected final Object pr(long j, String str, Object obj) throws Throwable {
        Throwable thHw = j1.pr().hw();
        if (thHw == null) {
            return null;
        }
        StackTraceElement[] stackTrace = thHw.getStackTrace();
        if (stackTrace.length < 4) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < 4; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (stackTraceElement != null && !TextUtils.isEmpty(stackTraceElement.getClassName())) {
                Class<?> cls = Class.forName(stackTrace[i].getClassName());
                j1 j1VarPr = j1.pr();
                String methodName = stackTrace[i].getMethodName();
                j1VarPr.getClass();
                ArrayList arrayList2 = new ArrayList();
                if (!TextUtils.isEmpty(methodName)) {
                    for (Method method : cls.getDeclaredMethods()) {
                        if (method != null && method.getName().equals(methodName)) {
                            arrayList2.add(method);
                        }
                    }
                }
                arrayList.addAll(arrayList2);
            }
        }
        return arrayList;
    }
}
