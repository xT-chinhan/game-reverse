package com.byazt.yb;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.anythink.core.common.f.e;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE, 866})
public final class py implements hd {
    public static final qg<Boolean> n = new qg<Boolean>() { // from class: com.byazt.yb.py.1
        @Override // com.byazt.yb.qg
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public Boolean n(Object... objArr) {
            return Boolean.valueOf("1".equals(py.qg("persist.sys.identifierid.supported", "0")));
        }
    };

    public py(Context context) {
    }

    public static boolean n() {
        return n.qg(new Object[0]).booleanValue();
    }

    @Override // com.byazt.yb.hd
    public boolean qg(Context context) {
        return n();
    }

    @Override // com.byazt.yb.hd
    public hd.n s(Context context) {
        hd.n nVar = new hd.n();
        nVar.qg = query(context, 0, null);
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String qg(String str, String str2) {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
            return objInvoke instanceof String ? (String) objInvoke : str2;
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private static String query(Context context, int i, String str) throws Throwable {
        Uri uri;
        Uri uri2;
        boolean zMoveToNext;
        int columnIndex;
        String string = null;
        string = null;
        string = null;
        string = null;
        string = null;
        ?? r0 = 0;
        try {
            if (i == 0) {
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
            } else {
                if (i != 1) {
                    if (i != 2) {
                        uri2 = null;
                    } else {
                        uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_".concat(String.valueOf(str)));
                    }
                    if (uri2 != null) {
                        try {
                            context = context.getContentResolver().query(uri2, null, null, null, null);
                            if (context != 0) {
                                try {
                                    zMoveToNext = context.moveToNext();
                                    context = context;
                                    if (zMoveToNext && (columnIndex = context.getColumnIndex(e.a.d)) != -1) {
                                        context = context;
                                        string = context.getString(columnIndex);
                                        context = context;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    com.byazt.km.cp.n(e);
                                    context = context;
                                }
                                context = context;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            context = 0;
                        } catch (Throwable th) {
                            th = th;
                            com.byazt.km.sz.n((Cursor) r0);
                            throw th;
                        }
                        com.byazt.km.sz.n((Cursor) context);
                    }
                    return string;
                }
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_".concat(String.valueOf(str)));
            }
            if (uri2 != null) {
                context = context.getContentResolver().query(uri2, null, null, null, null);
                if (context != 0) {
                    zMoveToNext = context.moveToNext();
                    context = context;
                    if (zMoveToNext) {
                        context = context;
                        string = context.getString(columnIndex);
                        context = context;
                    }
                    context = context;
                }
                com.byazt.km.sz.n((Cursor) context);
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
            r0 = context;
        }
        uri2 = uri;
    }
}
