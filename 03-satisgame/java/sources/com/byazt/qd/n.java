package com.byazt.qd;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.byazt.gx.rv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.util.FieldUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, 1607, 19})
public final class n {
    public static final s n;

    private interface s {
        boolean n(Context context) throws Throwable;
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i < 26) {
            n = new q();
        } else if (i < 28) {
            n = new l();
        } else {
            n = new qg();
        }
    }

    public static void n(Application application) {
        if (application != null) {
            try {
                if (rv.um()) {
                    n.n(application.getBaseContext());
                }
            } catch (Throwable unused) {
            }
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1607, 226})
    private static class qg extends l {
        @Override // com.byazt.qd.n.l, com.byazt.qd.n.C0310n, com.byazt.qd.n.s
        public boolean n(Context context) throws Throwable {
            return false;
        }

        private qg() {
            super();
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1607, 1705})
    private static class l extends C0310n {
        private l() {
            super();
        }

        @Override // com.byazt.qd.n.C0310n, com.byazt.qd.n.s
        public boolean n(Context context) throws Throwable {
            Object objN = n(context, "mWhiteListMap");
            if (!(objN instanceof Map)) {
                return false;
            }
            Map map = (Map) objN;
            List arrayList = (List) map.get(0);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(0, arrayList);
            }
            arrayList.add(context.getPackageName());
            return true;
        }
    }

    @com.byazt.cp.n(n = {0, 1, 1607, 1125})
    private static class q extends C0310n {
        private q() {
            super();
        }

        @Override // com.byazt.qd.n.C0310n, com.byazt.qd.n.s
        public boolean n(Context context) throws Throwable {
            Object objN = n(context, "mWhiteList");
            if (!(objN instanceof List)) {
                return false;
            }
            ((List) objN).add(context.getPackageName());
            return true;
        }
    }

    /* JADX INFO: renamed from: com.byazt.qd.n$n, reason: collision with other inner class name */
    @com.byazt.cp.n(n = {0, 1, 1607, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM})
    private static class C0310n implements s {
        private C0310n() {
        }

        @Override // com.byazt.qd.n.s
        public boolean n(Context context) throws Throwable {
            Object objQg = qg(context);
            Object objN = n(objQg, "mWhiteList");
            if (!(objN instanceof String[])) {
                if (objQg == null) {
                    return false;
                }
                FieldUtils.writeField(objQg, "mResourceConfig", (Object) null);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(context.getPackageName());
            Collections.addAll(arrayList, (String[]) objN);
            FieldUtils.writeField(objQg, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
            return true;
        }

        public Object n(Context context, String str) {
            return n(qg(context), str);
        }

        private Object n(Object obj, String str) {
            if (obj == null) {
                return null;
            }
            try {
                return FieldUtils.readField(obj, str);
            } catch (Throwable unused) {
                return null;
            }
        }

        private Object qg(Context context) {
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
