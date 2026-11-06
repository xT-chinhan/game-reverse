package com.byazt.bq;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.byazt.gs.aj;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.pangle.util.FieldUtils;
import com.mar.sdk.MARCode;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 122, 37})
public final class pr {
    public static final hn pr;

    private interface hn {
        boolean pr(Context context) throws Throwable;
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i < 24) {
            pr = new C0027pr();
            return;
        }
        if (i < 26) {
            pr = new x();
        } else if (i < 28) {
            pr = new c();
        } else {
            pr = new hw();
        }
    }

    public static void pr(Application application) {
        if (application == null) {
            return;
        }
        try {
            if (aj.qa()) {
                pr.pr(application.getBaseContext());
            }
        } catch (Throwable th) {
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 122, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE})
    private static class hw extends c {
        private hw() {
            super();
        }

        @Override // com.byazt.bq.pr.c, com.byazt.bq.pr.C0027pr, com.byazt.bq.pr.hn
        public boolean pr(Context context) throws Throwable {
            return false;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 122, 103})
    private static class c extends C0027pr {
        private c() {
            super();
        }

        @Override // com.byazt.bq.pr.C0027pr, com.byazt.bq.pr.hn
        public boolean pr(Context context) throws Throwable {
            Object objPr = pr(context, "mWhiteListMap");
            if (!(objPr instanceof Map)) {
                return false;
            }
            Map map = (Map) objPr;
            List arrayList = (List) map.get(0);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(0, arrayList);
            }
            arrayList.add(context.getPackageName());
            return true;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 122, 100})
    private static class x extends C0027pr {
        private x() {
            super();
        }

        @Override // com.byazt.bq.pr.C0027pr, com.byazt.bq.pr.hn
        public boolean pr(Context context) throws Throwable {
            Object objPr = pr(context, "mWhiteList");
            if (objPr instanceof List) {
                ((List) objPr).add(context.getPackageName());
                return true;
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: com.byazt.bq.pr$pr, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 122, MARCode.CODE_VIVOCHANNEL_CALLBACK})
    private static class C0027pr implements hn {
        private C0027pr() {
        }

        @Override // com.byazt.bq.pr.hn
        public boolean pr(Context context) throws Throwable {
            Object objHw = hw(context);
            Object objPr = pr(objHw, "mWhiteList");
            if (objPr instanceof String[]) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(context.getPackageName());
                Collections.addAll(arrayList, (String[]) objPr);
                FieldUtils.writeField(objHw, "mWhiteList", arrayList.toArray(new String[arrayList.size()]));
                return true;
            }
            if (objHw != null) {
                FieldUtils.writeField(objHw, "mResourceConfig", (Object) null);
                return false;
            }
            return false;
        }

        public Object pr(Context context, String str) {
            return pr(hw(context), str);
        }

        private Object pr(Object obj, String str) {
            if (obj != null) {
                try {
                    return FieldUtils.readField(obj, str);
                } catch (Throwable th) {
                    return null;
                }
            }
            return null;
        }

        private Object hw(Context context) {
            Field field;
            Object field2;
            try {
                Field field3 = FieldUtils.getField(Class.forName("android.app.LoadedApk"), "mReceiverResource");
                if (field3 != null && (field = FieldUtils.getField(Class.forName("android.app.ContextImpl"), "mPackageInfo")) != null && (field2 = FieldUtils.readField(field, context)) != null) {
                    return FieldUtils.readField(field3, field2);
                }
                return null;
            } catch (Throwable th) {
                return null;
            }
        }
    }
}
