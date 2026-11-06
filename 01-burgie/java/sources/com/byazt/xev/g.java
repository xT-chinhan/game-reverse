package com.byazt.xev;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.tapsdk.tapad.group.constants.Constants;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 75, MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF})
public final class g implements yb {
    public hw<Boolean> pr = new hw<Boolean>() { // from class: com.byazt.xev.g.1
        @Override // com.byazt.xev.hw
        /* JADX INFO: renamed from: hn, reason: merged with bridge method [inline-methods] */
        public Boolean pr(Object... objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Exception e) {
            }
            return Boolean.FALSE;
        }
    };

    @Override // com.byazt.xev.yb
    public boolean hw(Context context) {
        if (context == null) {
            return false;
        }
        return this.pr.hw(context).booleanValue();
    }

    @Override // com.byazt.xev.yb
    public yb.pr hn(Context context) {
        Cursor cursorQuery;
        try {
            cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);
            if (cursorQuery == null) {
                com.byazt.ec.g.pr(cursorQuery);
                return null;
            }
            try {
                yb.pr prVar = new yb.pr();
                prVar.hw = pr(cursorQuery);
                com.byazt.ec.g.pr(cursorQuery);
                return prVar;
            } catch (Throwable th) {
                th = th;
                try {
                    com.byazt.ec.w.pr(th);
                    return null;
                } finally {
                    com.byazt.ec.g.pr(cursorQuery);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = null;
        }
    }

    private String pr(Cursor cursor) {
        if (cursor == null || cursor.isClosed()) {
            return null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(Constants.VALUE_FIELD);
        if (columnIndex < 0) {
            return null;
        }
        return cursor.getString(columnIndex);
    }
}
