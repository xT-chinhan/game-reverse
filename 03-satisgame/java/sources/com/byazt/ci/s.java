package com.byazt.ci;

import android.content.ContentValues;
import android.database.Cursor;
import com.byazt.nf.rv;
import com.byazt.tk.k;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.cp.n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 8})
public class s implements qg {
    @Override // com.byazt.ci.qg
    public void n(String str, x.qg qgVar, w wVar, x.n nVar, n nVar2) {
        Cursor cursorQuery = com.byazt.xp.n.query(rv.getContext(), "union_meta_cache", null, "rit =?", new String[]{str}, null, null, "create_time ASC");
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            int count = (cursorQuery.getCount() - nVar.q()) + 1;
            if (count > 0) {
                do {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("uuid"));
                    if (nVar2 != null) {
                        nVar2.n(new x.qg(cursorQuery.getString(cursorQuery.getColumnIndex("meta_data")), cursorQuery.getLong(cursorQuery.getColumnIndex("create_time")), cursorQuery.getLong(cursorQuery.getColumnIndex("expire_time")), cursorQuery.getString(cursorQuery.getColumnIndex("uuid"))));
                    }
                    com.byazt.xp.n.delete(rv.getContext(), "union_meta_cache", "rit=? AND uuid=?", new String[]{str, string});
                    count--;
                    if (count <= 0) {
                        break;
                    }
                } while (cursorQuery.moveToNext());
            }
            cursorQuery.close();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", str);
        contentValues.put("uuid", qgVar.l);
        contentValues.put("create_time", Long.valueOf(qgVar.n));
        contentValues.put("save_version", Integer.valueOf(qgVar.q));
        contentValues.put("expire_time", Long.valueOf(qgVar.qg));
        contentValues.put("slot_type", nVar.n());
        contentValues.put("is_using", Integer.valueOf(wVar.n ? 1 : 0));
        contentValues.put("priority", Integer.valueOf(wVar.qg));
        contentValues.put("ad_index", Integer.valueOf(wVar.s));
        contentValues.put("meta_data", qgVar.s);
        com.byazt.xp.n.insert(rv.getContext(), "union_meta_cache", contentValues);
    }

    @Override // com.byazt.ci.qg
    public x.qg n(String str, x.n nVar, long j, List<String> list) {
        Cursor cursorN = n(nVar, str);
        if (cursorN == null) {
            return null;
        }
        while (cursorN.moveToNext()) {
            try {
                try {
                    String string = cursorN.getString(cursorN.getColumnIndex("uuid"));
                    if (list == null || string == null || !list.contains(string)) {
                        String string2 = cursorN.getString(cursorN.getColumnIndex("meta_data"));
                        long j2 = cursorN.getLong(cursorN.getColumnIndex("create_time"));
                        long j3 = cursorN.getLong(cursorN.getColumnIndex("expire_time"));
                        if (j <= 0 || j2 >= j) {
                            x.qg qgVar = new x.qg(string2, j2, j3, string);
                            cursorN.close();
                            return qgVar;
                        }
                    }
                } catch (Exception e) {
                    k.n("RewardFullLoadManager-DB", "db get error", e);
                }
            } catch (Throwable th) {
                cursorN.close();
                throw th;
            }
        }
        cursorN.close();
        return null;
    }

    @Override // com.byazt.ci.qg
    public void n(String str) {
        com.byazt.xp.n.delete(rv.getContext(), "union_meta_cache", "rit =?", new String[]{str});
    }

    @Override // com.byazt.ci.qg
    public void n(x.n nVar) {
        com.byazt.xp.n.delete(rv.getContext(), "union_meta_cache", "slot_type =?", new String[]{nVar.n()});
    }

    @Override // com.byazt.ci.qg
    public void n(String str, x.n nVar, n nVar2) {
        Cursor cursorQuery;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (nVar2 != null && (cursorQuery = com.byazt.xp.n.query(rv.getContext(), "union_meta_cache", null, "expire_time <? AND rit =?", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, null)) != null) {
            while (cursorQuery.moveToNext()) {
                nVar2.n(new x.qg(cursorQuery.getString(cursorQuery.getColumnIndex("meta_data")), cursorQuery.getLong(cursorQuery.getColumnIndex("create_time")), cursorQuery.getLong(cursorQuery.getColumnIndex("expire_time")), cursorQuery.getString(cursorQuery.getColumnIndex("uuid"))));
            }
            cursorQuery.close();
        }
        if (nVar.s()) {
            com.byazt.xp.n.delete(rv.getContext(), "union_meta_cache", "rit =? AND (save_version!=? OR expire_time <?)", new String[]{str, "7814", String.valueOf(jCurrentTimeMillis)});
        } else {
            com.byazt.xp.n.delete(rv.getContext(), "union_meta_cache", "rit =? AND expire_time <?", new String[]{str, String.valueOf(jCurrentTimeMillis)});
        }
    }

    @Override // com.byazt.ci.qg
    public void n(String str, String str2) {
        com.byazt.xp.n.delete(rv.getContext(), "union_meta_cache", "rit =? AND uuid =?", new String[]{str, str2});
    }

    @Override // com.byazt.ci.qg
    public void qg(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", (Integer) 0);
        com.byazt.xp.n.update(rv.getContext(), "union_meta_cache", contentValues, "rit =?", new String[]{str});
    }

    @Override // com.byazt.ci.qg
    public void n(String str, String str2, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", Boolean.valueOf(z));
        com.byazt.xp.n.update(rv.getContext(), "union_meta_cache", contentValues, "rit =? AND uuid =?", new String[]{str, str2});
    }

    @Override // com.byazt.ci.qg
    public boolean n(String str, x.n nVar) {
        Cursor cursorQuery;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (nVar.s()) {
            cursorQuery = com.byazt.xp.n.query(rv.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7814"}, null, null, null);
        } else {
            cursorQuery = com.byazt.xp.n.query(rv.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, null);
        }
        if (cursorQuery == null) {
            return false;
        }
        cursorQuery.getCount();
        boolean z = cursorQuery.getCount() > 0;
        cursorQuery.close();
        return z;
    }

    private Cursor n(x.n nVar, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iL = nVar.l();
        if (iL == 1) {
            return nVar.s() ? com.byazt.xp.n.query(rv.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7814"}, null, null, "create_time DESC") : com.byazt.xp.n.query(rv.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "create_time DESC");
        }
        if (iL == 2) {
            return nVar.s() ? com.byazt.xp.n.query(rv.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7814"}, null, null, "priority DESC") : com.byazt.xp.n.query(rv.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "priority DESC");
        }
        if (iL != 3) {
            return nVar.s() ? com.byazt.xp.n.query(rv.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7814"}, null, null, null) : com.byazt.xp.n.query(rv.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, null);
        }
        return nVar.s() ? com.byazt.xp.n.query(rv.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7814"}, null, null, "ad_index ASC, create_time DESC") : com.byazt.xp.n.query(rv.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "ad_index ASC, create_time DESC");
    }
}
