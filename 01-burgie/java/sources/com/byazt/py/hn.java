package com.byazt.py;

import android.content.ContentValues;
import android.database.Cursor;
import com.byazt.ca.ho;
import com.byazt.sd.a;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 438, 20})
public class hn implements hw {
    @Override // com.byazt.py.hw
    public void pr(String str, fw.hw hwVar, uc ucVar, fw.pr prVar, pr prVar2) {
        Cursor cursorQuery = com.byazt.ad.pr.query(a.getContext(), "union_meta_cache", null, "rit =?", new String[]{str}, null, null, "create_time ASC");
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            int count = (cursorQuery.getCount() - prVar.x()) + 1;
            if (count > 0) {
                do {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("uuid"));
                    if (prVar2 != null) {
                        prVar2.pr(new fw.hw(cursorQuery.getString(cursorQuery.getColumnIndex("meta_data")), cursorQuery.getLong(cursorQuery.getColumnIndex("create_time")), cursorQuery.getLong(cursorQuery.getColumnIndex("expire_time")), cursorQuery.getString(cursorQuery.getColumnIndex("uuid"))));
                    }
                    com.byazt.ad.pr.delete(a.getContext(), "union_meta_cache", "rit=? AND uuid=?", new String[]{str, string});
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
        contentValues.put("uuid", hwVar.c);
        contentValues.put("create_time", Long.valueOf(hwVar.pr));
        contentValues.put("save_version", Integer.valueOf(hwVar.x));
        contentValues.put("expire_time", Long.valueOf(hwVar.hw));
        contentValues.put("slot_type", prVar.pr());
        contentValues.put("is_using", Integer.valueOf(ucVar.pr ? 1 : 0));
        contentValues.put("priority", Integer.valueOf(ucVar.hw));
        contentValues.put("ad_index", Integer.valueOf(ucVar.hn));
        contentValues.put("meta_data", hwVar.hn);
        com.byazt.ad.pr.insert(a.getContext(), "union_meta_cache", contentValues);
    }

    @Override // com.byazt.py.hw
    public fw.hw pr(String str, fw.pr prVar, long j, List<String> list) {
        Cursor cursorPr = pr(prVar, str);
        if (cursorPr == null) {
            return null;
        }
        while (cursorPr.moveToNext()) {
            try {
                try {
                    String string = cursorPr.getString(cursorPr.getColumnIndex("uuid"));
                    if (list == null || string == null || !list.contains(string)) {
                        String string2 = cursorPr.getString(cursorPr.getColumnIndex("meta_data"));
                        long j2 = cursorPr.getLong(cursorPr.getColumnIndex("create_time"));
                        long j3 = cursorPr.getLong(cursorPr.getColumnIndex("expire_time"));
                        if (j <= 0 || j2 >= j) {
                            fw.hw hwVar = new fw.hw(string2, j2, j3, string);
                            cursorPr.close();
                            return hwVar;
                        }
                    }
                } catch (Exception e) {
                    ho.pr("RewardFullLoadManager-DB", "db get error", e);
                }
            } catch (Throwable th) {
                cursorPr.close();
                throw th;
            }
        }
        cursorPr.close();
        return null;
    }

    @Override // com.byazt.py.hw
    public void pr(String str) {
        com.byazt.ad.pr.delete(a.getContext(), "union_meta_cache", "rit =?", new String[]{str});
    }

    @Override // com.byazt.py.hw
    public void pr(fw.pr prVar) {
        com.byazt.ad.pr.delete(a.getContext(), "union_meta_cache", "slot_type =?", new String[]{prVar.pr()});
    }

    @Override // com.byazt.py.hw
    public void pr(String str, fw.pr prVar, pr prVar2) {
        Cursor cursorQuery;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (prVar2 != null && (cursorQuery = com.byazt.ad.pr.query(a.getContext(), "union_meta_cache", null, "expire_time <? AND rit =?", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, null)) != null) {
            while (cursorQuery.moveToNext()) {
                prVar2.pr(new fw.hw(cursorQuery.getString(cursorQuery.getColumnIndex("meta_data")), cursorQuery.getLong(cursorQuery.getColumnIndex("create_time")), cursorQuery.getLong(cursorQuery.getColumnIndex("expire_time")), cursorQuery.getString(cursorQuery.getColumnIndex("uuid"))));
            }
            cursorQuery.close();
        }
        if (prVar.hn()) {
            com.byazt.ad.pr.delete(a.getContext(), "union_meta_cache", "rit =? AND (save_version!=? OR expire_time <?)", new String[]{str, "7714", String.valueOf(jCurrentTimeMillis)});
        } else {
            com.byazt.ad.pr.delete(a.getContext(), "union_meta_cache", "rit =? AND expire_time <?", new String[]{str, String.valueOf(jCurrentTimeMillis)});
        }
    }

    @Override // com.byazt.py.hw
    public void pr(String str, String str2) {
        com.byazt.ad.pr.delete(a.getContext(), "union_meta_cache", "rit =? AND uuid =?", new String[]{str, str2});
    }

    @Override // com.byazt.py.hw
    public void hw(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", (Integer) 0);
        com.byazt.ad.pr.update(a.getContext(), "union_meta_cache", contentValues, "rit =?", new String[]{str});
    }

    @Override // com.byazt.py.hw
    public void pr(String str, String str2, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("is_using", Boolean.valueOf(z));
        com.byazt.ad.pr.update(a.getContext(), "union_meta_cache", contentValues, "rit =? AND uuid =?", new String[]{str, str2});
    }

    @Override // com.byazt.py.hw
    public boolean pr(String str, fw.pr prVar) {
        Cursor cursorQuery;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (prVar.hn()) {
            cursorQuery = com.byazt.ad.pr.query(a.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7714"}, null, null, null);
        } else {
            cursorQuery = com.byazt.ad.pr.query(a.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, null);
        }
        if (cursorQuery == null) {
            return false;
        }
        cursorQuery.getCount();
        boolean z = cursorQuery.getCount() > 0;
        cursorQuery.close();
        return z;
    }

    private Cursor pr(fw.pr prVar, String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        switch (prVar.c()) {
            case 1:
                return prVar.hn() ? com.byazt.ad.pr.query(a.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7714"}, null, null, "create_time DESC") : com.byazt.ad.pr.query(a.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "create_time DESC");
            case 2:
                return prVar.hn() ? com.byazt.ad.pr.query(a.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7714"}, null, null, "priority DESC") : com.byazt.ad.pr.query(a.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "priority DESC");
            case 3:
                return prVar.hn() ? com.byazt.ad.pr.query(a.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7714"}, null, null, "ad_index ASC, create_time DESC") : com.byazt.ad.pr.query(a.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, "ad_index ASC, create_time DESC");
            default:
                return prVar.hn() ? com.byazt.ad.pr.query(a.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND save_version =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str, "7714"}, null, null, null) : com.byazt.ad.pr.query(a.getContext(), "union_meta_cache", null, "expire_time >? AND rit =? AND is_using = 0", new String[]{String.valueOf(jCurrentTimeMillis), str}, null, null, null);
        }
    }
}
