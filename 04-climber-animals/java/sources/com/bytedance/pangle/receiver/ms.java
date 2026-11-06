package com.bytedance.pangle.receiver;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.ny;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class ms {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final ah f671ms;

    private interface ah {
        boolean ms(Context context) throws Throwable;
    }

    static {
        if (Build.VERSION.SDK_INT < 28) {
            f671ms = new ka();
        } else {
            f671ms = new xr();
        }
    }

    public static void ms(Application application) {
        if (application != null) {
            try {
                if (ny.t()) {
                    f671ms.ms(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static class xr extends ka {
        @Override // com.bytedance.pangle.receiver.ms.ka, com.bytedance.pangle.receiver.ms.C0224ms, com.bytedance.pangle.receiver.ms.ah
        public boolean ms(Context context) throws Throwable {
            return false;
        }

        private xr() {
            super();
        }
    }

    private static class ka extends C0224ms {
        private ka() {
            super();
        }

        @Override // com.bytedance.pangle.receiver.ms.C0224ms, com.bytedance.pangle.receiver.ms.ah
        public boolean ms(Context context) throws Throwable {
            Object objMs = ms(context, "mWhiteListMap");
            if (!(objMs instanceof Map)) {
                return false;
            }
            Map map = (Map) objMs;
            List arrayList = (List) map.get(0);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(0, arrayList);
            }
            arrayList.add(context.getPackageName());
            return true;
        }
    }

    private static class d extends C0224ms {
        private d() {
            super();
        }

        @Override // com.bytedance.pangle.receiver.ms.C0224ms, com.bytedance.pangle.receiver.ms.ah
        public boolean ms(Context context) throws Throwable {
            Object objMs = ms(context, "mWhiteList");
            if (!(objMs instanceof List)) {
                return false;
            }
            ((List) objMs).add(context.getPackageName());
            return true;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.pangle.receiver.ms$ms, reason: collision with other inner class name */
    private static class C0224ms implements ah {
        private C0224ms() {
        }

        @Override // com.bytedance.pangle.receiver.ms.ah
        public boolean ms(Context context) throws Throwable {
            Object objXr = xr(context);
            Object objMs = ms(objXr, "mWhiteList");
            if (!(objMs instanceof String[])) {
                if (objXr == null) {
                    return false;
                }
                FieldUtils.writeField(objXr, "mResourceConfig", (Object) null);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) objMs);
            FieldUtils.writeField(objXr, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        Object ms(Context context, String str) {
            return ms(xr(context), str);
        }

        private Object ms(Object obj, String str) {
            if (obj == null) {
                return null;
            }
            try {
                return FieldUtils.readField(obj, str);
            } catch (Throwable unused) {
                return null;
            }
        }

        private Object xr(Context context) {
            Field field;
            Object field2;
            try {
                Field field3 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field3 == null || (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) == null || (field2 = FieldUtils.readField(field, context)) == null) {
                    return null;
                }
                return FieldUtils.readField(field3, field2);
            } catch (Throwable unused) {
                return null;
            }
        }
    }
}
