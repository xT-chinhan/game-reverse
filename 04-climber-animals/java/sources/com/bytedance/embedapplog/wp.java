package com.bytedance.embedapplog;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;

/* JADX INFO: loaded from: classes2.dex */
final class wp implements pl {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private static final ce<Boolean> f538ms = new ce<Boolean>() { // from class: com.bytedance.embedapplog.wp.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bytedance.embedapplog.ce
        /* JADX INFO: renamed from: ah, reason: merged with bridge method [inline-methods] */
        public Boolean ms(Object... objArr) {
            return Boolean.valueOf("1".equals(wp.xr("persist.sys.identifierid.supported", "0")));
        }
    };

    wp(Context context) {
    }

    static boolean ms() {
        return f538ms.xr(new Object[0]).booleanValue();
    }

    @Override // com.bytedance.embedapplog.pl
    public boolean ms(Context context) {
        return ms();
    }

    @Override // com.bytedance.embedapplog.pl
    public pl.ms xr(Context context) {
        pl.ms msVar = new pl.ms();
        msVar.xr = ms(context, 0, null);
        return msVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String xr(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0046 A[Catch: Exception -> 0x0052, all -> 0x0060, TRY_LEAVE, TryCatch #0 {all -> 0x0060, blocks: (B:16:0x0040, B:18:0x0046, B:27:0x005c), top: B:35:0x0030 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private static String ms(Context context, int i, String str) throws Throwable {
        Uri uri;
        Uri uri2;
        boolean zMoveToNext;
        String string = null;
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
                                    if (zMoveToNext) {
                                        string = context.getString(context.getColumnIndex(com.anythink.core.common.e.f.a.d));
                                        context = context;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    oh.ms(e);
                                    context = context;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            context = 0;
                        } catch (Throwable th) {
                            th = th;
                            zd.ms((Cursor) r0);
                            throw th;
                        }
                        zd.ms((Cursor) context);
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
                        string = context.getString(context.getColumnIndex(com.anythink.core.common.e.f.a.d));
                        context = context;
                    }
                }
                zd.ms((Cursor) context);
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
            r0 = context;
        }
        uri2 = uri;
    }
}
