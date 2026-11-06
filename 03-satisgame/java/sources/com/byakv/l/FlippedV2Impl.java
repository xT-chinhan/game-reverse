package com.byakv.l;

import android.util.Log;
import com.byazt.qbj.s;
import com.byazt.vx.w;
import com.bytedance.pangle.GlobalParam;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class FlippedV2Impl implements s {
    public static final String TAG = "FlippedV2Impl";

    private native Method getDeclaredMethod(Object obj, String str, Class<?>[] clsArr);

    static {
        com.byazt.xhd.s.n("pangleflipped");
    }

    @Override // com.byazt.qbj.s
    public void invokeHiddenApiRestrictions() {
        GlobalParam.getInstance().getReporter().n("zeus_stage_flipped", "v2");
        try {
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            Method declaredMethod = getDeclaredMethod(cls, "getRuntime", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Method declaredMethod2 = getDeclaredMethod(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(objInvoke, new String[]{"L"});
        } catch (Exception e) {
            GlobalParam.getInstance().getReporter().n("zeus_stage_flipped", "V2 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
            w.l(TAG, "V2 invokeHiddenApiRestrictions fail: " + Log.getStackTraceString(e));
        }
    }
}
