package com.byazt.nq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 1373, 13})
public class hw {

    public interface pr {
        int delete(Uri uri, String str, String[] strArr);

        String getTableName();

        String getType(Uri uri);

        void init();

        void injectContext(Context context);

        Uri insert(Uri uri, ContentValues contentValues);

        Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

        int update(Uri uri, ContentValues contentValues, String str, String[] strArr);
    }

    public static Object pr(pr prVar, Class cls, Bundle bundle) {
        if (pr(bundle)) {
            return new C0143hw(prVar);
        }
        if (pr(cls)) {
            return new hn(prVar);
        }
        return null;
    }

    public static boolean pr(Class cls, Bundle bundle) {
        if (cls == null) {
            return false;
        }
        return pr(cls) || pr(bundle);
    }

    private static boolean pr(Class cls) {
        return cls != null && "com.bytedance.sdk.openadsdk.ITTProvider".equals(cls.getName());
    }

    private static boolean pr(Bundle bundle) {
        return bundle != null && bundle.getBoolean("proto2_ittprovider");
    }

    /* JADX INFO: renamed from: com.byazt.nq.hw$hw, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 1373, 497})
    private static class C0143hw extends com.byazt.ofr.x implements pr {
        public pr pr;

        public C0143hw(pr prVar) {
            this.pr = prVar;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.byazt.ofr.x
        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            T t = (T) 0;
            switch (i) {
                case -7999907:
                    if (this.pr != null) {
                        return (T) Integer.valueOf(update((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (ContentValues) pluginValueSet.objectValue(-7999922, ContentValues.class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class)));
                    }
                    return t;
                case -7999906:
                    if (this.pr != null) {
                        return (T) Integer.valueOf(delete((Uri) pluginValueSet.objectValue(-7999921, Uri.class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class)));
                    }
                    return t;
                case -7999905:
                    if (this.pr != null) {
                        return (T) insert((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (ContentValues) pluginValueSet.objectValue(-7999922, ContentValues.class));
                    }
                    return null;
                case -7999904:
                    if (this.pr != null) {
                        return (T) query((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (String[]) pluginValueSet.objectValue(-7999922, String[].class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class), pluginValueSet.stringValue(-7999925, null));
                    }
                    return null;
                case -7999903:
                    if (this.pr != null) {
                        return (T) getType((Uri) pluginValueSet.objectValue(-7999921, Uri.class));
                    }
                    return null;
                case -7999902:
                    init();
                    return null;
                case -7999901:
                    return (T) getTableName();
                case -7999900:
                    if (this.pr != null) {
                        injectContext((Context) pluginValueSet.objectValue(-7999920, Context.class));
                    }
                    return null;
                default:
                    return null;
            }
        }

        @Override // com.byazt.nq.hw.pr
        public void injectContext(Context context) {
            pr prVar = this.pr;
            if (prVar != null) {
                prVar.injectContext(context);
            }
        }

        @Override // com.byazt.nq.hw.pr
        public String getTableName() {
            pr prVar = this.pr;
            if (prVar != null) {
                return prVar.getTableName();
            }
            return null;
        }

        @Override // com.byazt.nq.hw.pr
        public void init() {
            pr prVar = this.pr;
            if (prVar != null) {
                prVar.init();
            }
        }

        @Override // com.byazt.nq.hw.pr
        public String getType(Uri uri) {
            pr prVar = this.pr;
            if (prVar != null) {
                return prVar.getType(uri);
            }
            return null;
        }

        @Override // com.byazt.nq.hw.pr
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            pr prVar = this.pr;
            if (prVar != null) {
                return prVar.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        }

        @Override // com.byazt.nq.hw.pr
        public Uri insert(Uri uri, ContentValues contentValues) {
            pr prVar = this.pr;
            if (prVar != null) {
                return prVar.insert(uri, contentValues);
            }
            return null;
        }

        @Override // com.byazt.nq.hw.pr
        public int delete(Uri uri, String str, String[] strArr) {
            pr prVar = this.pr;
            if (prVar != null) {
                return prVar.delete(uri, str, strArr);
            }
            return 0;
        }

        @Override // com.byazt.nq.hw.pr
        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
            pr prVar = this.pr;
            if (prVar != null) {
                return prVar.update(uri, contentValues, str, strArr);
            }
            return 0;
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, 1373, MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_CREATE_TIME})
    private static class hn implements ITTProvider, pr {
        public pr pr;

        public hn(pr prVar) {
            this.pr = prVar;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.nq.hw.pr
        public void injectContext(Context context) {
            pr prVar = this.pr;
            if (prVar != null) {
                prVar.injectContext(context);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.nq.hw.pr
        public String getTableName() {
            pr prVar = this.pr;
            if (prVar != null) {
                return prVar.getTableName();
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.nq.hw.pr
        public void init() {
            pr prVar = this.pr;
            if (prVar != null) {
                prVar.init();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.nq.hw.pr
        public String getType(Uri uri) {
            pr prVar = this.pr;
            if (prVar != null) {
                return prVar.getType(uri);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.nq.hw.pr
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            pr prVar = this.pr;
            if (prVar != null) {
                return prVar.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.nq.hw.pr
        public Uri insert(Uri uri, ContentValues contentValues) {
            pr prVar = this.pr;
            if (prVar != null) {
                return prVar.insert(uri, contentValues);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.nq.hw.pr
        public int delete(Uri uri, String str, String[] strArr) {
            pr prVar = this.pr;
            if (prVar != null) {
                return prVar.delete(uri, str, strArr);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.nq.hw.pr
        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
            pr prVar = this.pr;
            if (prVar != null) {
                return prVar.update(uri, contentValues, str, strArr);
            }
            return 0;
        }
    }
}
