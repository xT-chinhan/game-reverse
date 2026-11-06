package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.umeng.analytics.pro.ek;

/* JADX INFO: loaded from: classes4.dex */
public final class u1 {

    /* JADX INFO: renamed from: ms, reason: collision with root package name */
    private final Context f4869ms;

    public u1(Context context) {
        this.f4869ms = context;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x007b A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r1
      0x007b: PHI (r1v5 java.lang.String) = (r1v3 java.lang.String), (r1v2 java.lang.String) binds: [B:16:0x0084, B:10:0x0067] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    public final String ms() {
        Cursor cursorQuery = this.f4869ms.getContentResolver().query(Uri.parse((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "85dc82", new byte[]{42, 56, 25, 3, 2, 43, 47, 78, 122, 124, 42, 56, 26, 89, 17, 44, 45, 27, 123, 37, 36, 36, 89, 62, 3, 21, 41, 27, 35, 58, 45, 50, 5, 88, 46, 33, 62, 26, 33, 58, 47, 62, 18, 5, 46, 33, 116, 59, 20, 26, ek.k})), null, null, null, null);
        String string = null;
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToNext()) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5d5be8", new byte[]{50, 103, 74, 3, 95})));
                }
                if (cursorQuery != null) {
                }
            } catch (Throwable unused) {
                try {
                    com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "a4fe60", new byte[]{102, 57});
                } finally {
                    try {
                        cursorQuery.close();
                    } catch (Throwable unused2) {
                    }
                }
            }
        } else if (cursorQuery != null) {
        }
        return string;
    }
}
