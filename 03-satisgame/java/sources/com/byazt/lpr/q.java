package com.byazt.lpr;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.ITTProvider;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE, 5})
public class q {

    public interface n {
        int delete(Uri uri, String str, String[] strArr);

        String getTableName();

        String getType(Uri uri);

        void init();

        void injectContext(Context context);

        Uri insert(Uri uri, ContentValues contentValues);

        Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

        int update(Uri uri, ContentValues contentValues, String str, String[] strArr);
    }

    public static Object n(n nVar, Class cls, Bundle bundle) {
        if (n(bundle)) {
            return new qg(nVar);
        }
        if (n(cls)) {
            return new s(nVar);
        }
        return null;
    }

    public static boolean n(Class cls, Bundle bundle) {
        if (cls == null) {
            return false;
        }
        return n(cls) || n(bundle);
    }

    private static boolean n(Class cls) {
        return cls != null && "com.bytedance.sdk.openadsdk.ITTProvider".equals(cls.getName());
    }

    private static boolean n(Bundle bundle) {
        return bundle != null && bundle.getBoolean("proto2_ittprovider");
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE, 524})
    private static class qg extends com.byazt.gf.q implements n {
        public n n;

        public qg(n nVar) {
            this.n = nVar;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.byazt.gf.q
        public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
            T t = (T) 0;
            switch (i) {
                case -7999907:
                    return this.n != null ? (T) Integer.valueOf(update((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (ContentValues) pluginValueSet.objectValue(-7999922, ContentValues.class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class))) : t;
                case -7999906:
                    return this.n != null ? (T) Integer.valueOf(delete((Uri) pluginValueSet.objectValue(-7999921, Uri.class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class))) : t;
                case -7999905:
                    if (this.n != null) {
                        return (T) insert((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (ContentValues) pluginValueSet.objectValue(-7999922, ContentValues.class));
                    }
                    return null;
                case -7999904:
                    if (this.n != null) {
                        return (T) query((Uri) pluginValueSet.objectValue(-7999921, Uri.class), (String[]) pluginValueSet.objectValue(-7999922, String[].class), pluginValueSet.stringValue(-7999923, null), (String[]) pluginValueSet.objectValue(-7999924, String[].class), pluginValueSet.stringValue(-7999925, null));
                    }
                    return null;
                case -7999903:
                    if (this.n != null) {
                        return (T) getType((Uri) pluginValueSet.objectValue(-7999921, Uri.class));
                    }
                    return null;
                case -7999902:
                    init();
                    return null;
                case -7999901:
                    return (T) getTableName();
                case -7999900:
                    if (this.n != null) {
                        injectContext((Context) pluginValueSet.objectValue(-7999920, Context.class));
                    }
                    return null;
                default:
                    return null;
            }
        }

        @Override // com.byazt.lpr.q.n
        public void injectContext(Context context) {
            n nVar = this.n;
            if (nVar != null) {
                nVar.injectContext(context);
            }
        }

        @Override // com.byazt.lpr.q.n
        public String getTableName() {
            n nVar = this.n;
            if (nVar != null) {
                return nVar.getTableName();
            }
            return null;
        }

        @Override // com.byazt.lpr.q.n
        public void init() {
            n nVar = this.n;
            if (nVar != null) {
                nVar.init();
            }
        }

        @Override // com.byazt.lpr.q.n
        public String getType(Uri uri) {
            n nVar = this.n;
            if (nVar != null) {
                return nVar.getType(uri);
            }
            return null;
        }

        @Override // com.byazt.lpr.q.n
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            n nVar = this.n;
            if (nVar != null) {
                return nVar.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        }

        @Override // com.byazt.lpr.q.n
        public Uri insert(Uri uri, ContentValues contentValues) {
            n nVar = this.n;
            if (nVar != null) {
                return nVar.insert(uri, contentValues);
            }
            return null;
        }

        @Override // com.byazt.lpr.q.n
        public int delete(Uri uri, String str, String[] strArr) {
            n nVar = this.n;
            if (nVar != null) {
                return nVar.delete(uri, str, strArr);
            }
            return 0;
        }

        @Override // com.byazt.lpr.q.n
        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
            n nVar = this.n;
            if (nVar != null) {
                return nVar.update(uri, contentValues, str, strArr);
            }
            return 0;
        }
    }

    @com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE, 1366})
    private static class s implements ITTProvider, n {
        public n n;

        public s(n nVar) {
            this.n = nVar;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
        public void injectContext(Context context) {
            n nVar = this.n;
            if (nVar != null) {
                nVar.injectContext(context);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
        public String getTableName() {
            n nVar = this.n;
            if (nVar != null) {
                return nVar.getTableName();
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
        public void init() {
            n nVar = this.n;
            if (nVar != null) {
                nVar.init();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
        public String getType(Uri uri) {
            n nVar = this.n;
            if (nVar != null) {
                return nVar.getType(uri);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
            n nVar = this.n;
            if (nVar != null) {
                return nVar.query(uri, strArr, str, strArr2, str2);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
        public Uri insert(Uri uri, ContentValues contentValues) {
            n nVar = this.n;
            if (nVar != null) {
                return nVar.insert(uri, contentValues);
            }
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
        public int delete(Uri uri, String str, String[] strArr) {
            n nVar = this.n;
            if (nVar != null) {
                return nVar.delete(uri, str, strArr);
            }
            return 0;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTProvider, com.byazt.lpr.q.n
        public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
            n nVar = this.n;
            if (nVar != null) {
                return nVar.update(uri, contentValues, str, strArr);
            }
            return 0;
        }
    }
}
