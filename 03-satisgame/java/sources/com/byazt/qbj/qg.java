package com.byazt.qbj;

import android.util.Log;
import com.byazt.vx.w;
import com.bytedance.pangle.GlobalParam;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1733, 26})
public class qg implements s {
    @Override // com.byazt.qbj.s
    public void invokeHiddenApiRestrictions() {
        GlobalParam.getInstance().getReporter().n("zeus_stage_flipped", "v1");
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            Method method = (Method) declaredMethod.invoke(cls, "getRuntime", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(null, new Object[0]);
            Method method2 = (Method) declaredMethod.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            method2.setAccessible(true);
            method2.invoke(objInvoke, new String[]{"L"});
        } catch (Exception e) {
            GlobalParam.getInstance().getReporter().n("zeus_stage_flipped", "V1 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
            w.l("FlippedV1Impl", "V1 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
        }
    }
}
