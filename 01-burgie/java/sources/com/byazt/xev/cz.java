package com.byazt.xev;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tapsdk.tapad.group.constants.Constants;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, 213})
public final class cz implements yb {
    public static final hw<Boolean> pr = new hw<Boolean>() { // from class: com.byazt.xev.cz.1
        @Override // com.byazt.xev.hw
        /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
        public Boolean pr(Object... objArr) {
            return Boolean.valueOf("1".equals(cz.hw("persist.sys.identifierid.supported", "0")));
        }
    };

    public cz(Context context) {
    }

    public static boolean pr() {
        return pr.hw(new Object[0]).booleanValue();
    }

    @Override // com.byazt.xev.yb
    public boolean hw(Context context) {
        return pr();
    }

    @Override // com.byazt.xev.yb
    public yb.pr hn(Context context) {
        yb.pr prVar = new yb.pr();
        prVar.hw = query(context, 0, null);
        return prVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hw(String str, String str2) {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return str2;
        } catch (Throwable th) {
            return str2;
        }
    }

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
        int columnIndex;
        String string = null;
        string = null;
        string = null;
        string = null;
        string = null;
        ?? r0 = 0;
        switch (i) {
            case 0:
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
                break;
            case 1:
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_".concat(String.valueOf(str)));
                break;
            case 2:
                uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_".concat(String.valueOf(str)));
                break;
            default:
                uri = null;
                break;
        }
        try {
            if (uri != null) {
                try {
                    context = context.getContentResolver().query(uri, null, null, null, null);
                    if (context != 0) {
                        try {
                            boolean zMoveToNext = context.moveToNext();
                            context = context;
                            if (zMoveToNext && (columnIndex = context.getColumnIndex(Constants.VALUE_FIELD)) != -1) {
                                context = context;
                                string = context.getString(columnIndex);
                                context = context;
                            }
                        } catch (Exception e) {
                            e = e;
                            com.byazt.ec.w.pr(e);
                            context = context;
                        }
                        context = context;
                    }
                } catch (Exception e2) {
                    e = e2;
                    context = 0;
                } catch (Throwable th) {
                    th = th;
                    com.byazt.ec.g.pr((Cursor) r0);
                    throw th;
                }
                com.byazt.ec.g.pr((Cursor) context);
            }
            return string;
        } catch (Throwable th2) {
            th = th2;
            r0 = context;
        }
    }
}
