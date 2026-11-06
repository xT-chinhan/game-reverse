package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.umeng.analytics.pro.ek;

/* JADX INFO: loaded from: classes4.dex */
public final class x0 {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f4871ms;

    public x0(Context context) {
        this.f4871ms = context;
    }

    private static String ms(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "419075", new byte[]{51, 50, 70, 81, ek.k}));
        String string = columnIndex > 0 ? cursor.getString(columnIndex) : null;
        int columnIndex2 = cursor.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9a9074", new byte[]{43, 108, 78, 65}));
        if (columnIndex2 > 0) {
            cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1a3bf5", new byte[]{37, 123, 80, 31, 75, 39, 54}));
        if (columnIndex3 > 0) {
            cursor.getLong(columnIndex3);
        }
        return string;
    }

    public final void ms(pblk.pblb pblbVar) {
        Cursor cursorQuery;
        try {
            this.f4871ms.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0af615", new byte[]{34, 108, 24, 12, 3, 39, 58, 90, 34, 40, 39, 111, 12, 79, 11, 108, 60, 80, 50, 104, 40, 103, 6, 70, 5}), 0);
        } catch (Exception unused) {
        }
        Uri uri = Uri.parse((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2eaead", new byte[]{32, 104, 28, 5, 91, 125, 37, 30, 127, 122, 32, 104, 31, 95, 83, 118, 56, 94, 37, 123, 37, 107, 11, 28, 91, 61, 62, 84, 53, 59, 42, 99, 1, 21, 85, 60}));
        try {
            cursorQuery = this.f4871ms.getContentResolver().query(uri, null, null, new String[]{(String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5e3665", new byte[]{43, 102, 73, 70})}, null);
            try {
                String strMs = ms(cursorQuery);
                if (pblbVar != null) {
                    pblbVar.ms(strMs);
                }
                if (cursorQuery == null) {
                    return;
                }
            } catch (Throwable unused2) {
                if (cursorQuery == null) {
                    return;
                }
            }
        } catch (Throwable unused3) {
            cursorQuery = null;
        }
        cursorQuery.close();
    }
}
