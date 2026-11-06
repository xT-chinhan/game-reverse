package com.byazt.ce;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.LruCache;
import com.byazt.ca.ho;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.taptap.sdk.update.download.DownloadTask;
import com.taptap.sdk.update.download.core.breakpoint.BreakpointSQLiteKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, 5})
public class uc {
    public static volatile uc hw;
    public static int pr = DownloadTask.Builder.DEFAULT_SYNC_BUFFER_INTERVAL_MILLIS;
    public volatile ConcurrentHashMap<String, com.byazt.hfm.hn> c;
    public final Object x = new Object();
    public AtomicBoolean uc = new AtomicBoolean(false);
    public LruCache<String, com.byazt.hfm.hw> fw = new LruCache<String, com.byazt.hfm.hw>(pr) { // from class: com.byazt.ce.uc.1
        @Override // android.util.LruCache
        /* JADX INFO: renamed from: pr, reason: merged with bridge method [inline-methods] */
        public int sizeOf(String str, com.byazt.hfm.hw hwVar) {
            return 1;
        }
    };
    public Set<String> hn = Collections.synchronizedSet(new HashSet());

    public static uc pr() {
        if (hw == null) {
            synchronized (uc.class) {
                if (hw == null) {
                    hw = new uc();
                }
            }
        }
        return hw;
    }

    private uc() {
    }

    public com.byazt.hfm.hw pr(String str) {
        com.byazt.hfm.hw hwVar;
        com.byazt.hfm.hw hwVarPr;
        if (TextUtils.isEmpty(str) || com.byazt.bg.pr.pr().hw() == null) {
            return null;
        }
        synchronized (this.x) {
            hwVar = this.fw.get(String.valueOf(str));
        }
        if (hwVar != null) {
            return hwVar;
        }
        Cursor cursorQuery = com.byazt.bg.pr.pr().hw().query("template_diff_new", null, "id=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex(BreakpointSQLiteKey.URL));
                        String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                        hwVarPr = new com.byazt.hfm.hw().pr(string).hw(string2).hn(string3).x(string4).c(string5).uc(cursorQuery.getString(cursorQuery.getColumnIndex("version"))).pr(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time"))));
                        synchronized (this.x) {
                            this.fw.put(string2, hwVarPr);
                        }
                        this.hn.add(string2);
                    } while (cursorQuery.moveToNext());
                    cursorQuery.close();
                    return hwVarPr;
                }
            } catch (Throwable th) {
                try {
                    ho.pr("TmplDbHelper", "getTemplate error", th);
                } finally {
                    cursorQuery.close();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00ea  */
    public Set<com.byazt.hfm.hw> hw(String str) {
        com.byazt.hfm.hw hwVar;
        if (TextUtils.isEmpty(str) || com.byazt.bg.pr.pr().hw() == null) {
            return Collections.emptySet();
        }
        Cursor cursorQuery = com.byazt.bg.pr.pr().hw().query("template_diff_new", null, "rit=?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.getCount() > 0) {
                    HashSet hashSet = new HashSet();
                    if (cursorQuery.moveToFirst()) {
                        do {
                            String string = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                            if (!TextUtils.isEmpty(string)) {
                                synchronized (this.x) {
                                    hwVar = this.fw.get(string);
                                }
                                if (hwVar != null) {
                                    hashSet.add(hwVar);
                                } else {
                                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex(BreakpointSQLiteKey.URL));
                                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                                    com.byazt.hfm.hw hwVarPr = new com.byazt.hfm.hw().pr(str).hw(string).hn(string2).x(string3).c(string4).uc(cursorQuery.getString(cursorQuery.getColumnIndex("version"))).pr(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time"))));
                                    hashSet.add(hwVarPr);
                                    synchronized (this.x) {
                                        this.fw.put(string, hwVarPr);
                                    }
                                    this.hn.add(string);
                                }
                            }
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    return hashSet;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Exception e) {
                if (cursorQuery != null) {
                }
                return Collections.emptySet();
            } catch (Throwable th) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                throw th;
            }
        } else if (cursorQuery != null) {
            cursorQuery.close();
        }
        return Collections.emptySet();
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00f0 A[DONT_GENERATE] */
    public List<com.byazt.hfm.hw> hw() {
        if (com.byazt.bg.pr.pr().hw() == null) {
            return null;
        }
        boolean z = this.uc.get();
        this.uc.set(true);
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = com.byazt.bg.pr.pr().hw().query("template_diff_new", null, null, null, null, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("id"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("md5"));
                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex(BreakpointSQLiteKey.URL));
                    String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("data"));
                    String string6 = cursorQuery.getString(cursorQuery.getColumnIndex("version"));
                    arrayList.add(new com.byazt.hfm.hw().pr(string).hw(string2).hn(string3).x(string4).c(string5).uc(string6).pr(Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("update_time")))));
                    synchronized (this.x) {
                        this.fw.put(string2, (com.byazt.hfm.hw) arrayList.get(arrayList.size() - 1));
                    }
                    this.hn.add(string2);
                    if (!z && com.byazt.bg.pr.pr().uc() != null) {
                        if (this.c == null) {
                            this.c = new ConcurrentHashMap<>();
                        }
                        if (string2 != null && !this.c.contains(string2)) {
                            this.c.put(string2, new com.byazt.hfm.hn(string, string2, string3));
                        }
                    }
                } catch (Throwable th) {
                    try {
                        ho.pr("TmplDbHelper", "getTemplate error", th);
                    } finally {
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
            }
            if (cursorQuery != null) {
            }
        }
        return arrayList;
    }

    public void pr(com.byazt.hfm.hw hwVar, boolean z) {
        if (hwVar == null || com.byazt.bg.pr.pr().hw() == null || TextUtils.isEmpty(hwVar.hw())) {
            return;
        }
        Cursor cursorQuery = com.byazt.bg.pr.pr().hw().query("template_diff_new", null, "id=?", new String[]{hwVar.hw()}, null, null, null);
        boolean z2 = cursorQuery != null && cursorQuery.getCount() > 0;
        String string = null;
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndex("rit"));
                }
                cursorQuery.close();
            } catch (Throwable th) {
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("rit", hwVar.pr());
        contentValues.put("id", hwVar.hw());
        contentValues.put("md5", hwVar.hn());
        contentValues.put(BreakpointSQLiteKey.URL, hwVar.x());
        contentValues.put("data", hwVar.c());
        contentValues.put("version", hwVar.uc());
        contentValues.put("update_time", hwVar.fw());
        if (z2) {
            com.byazt.bg.pr.pr().hw().update("template_diff_new", contentValues, "id=?", new String[]{hwVar.hw()});
        } else {
            com.byazt.bg.pr.pr().hw().insert("template_diff_new", contentValues);
        }
        synchronized (this.x) {
            this.fw.put(hwVar.hw(), hwVar);
        }
        this.hn.add(hwVar.hw());
        if (z) {
            return;
        }
        try {
            if (com.byazt.bg.pr.pr().uc() == null) {
                return;
            }
            if (this.c == null) {
                this.c = new ConcurrentHashMap<>();
            }
            com.byazt.hfm.hn hnVar = new com.byazt.hfm.hn(hwVar.pr(), hwVar.hw(), hwVar.hn());
            this.c.put(hwVar.hw(), hnVar);
            if (string != null) {
                com.byazt.bg.pr.pr().uc().delete(string, hnVar.hw());
            }
            com.byazt.bg.pr.pr().uc().update(hwVar.pr(), hnVar);
        } catch (Throwable th2) {
        }
    }

    public void pr(Set<String> set) {
        if (set == null || set.isEmpty() || com.byazt.bg.pr.pr().hw() == null) {
            return;
        }
        String[] strArr = (String[]) set.toArray(new String[set.size()]);
        if (strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                x(strArr[i]);
                com.byazt.bg.pr.pr().hw().delete("template_diff_new", "id=?", new String[]{strArr[i]});
                hn(strArr[i]);
            }
        }
    }

    public void hn(String str) {
        com.byazt.hfm.hn hnVar;
        try {
            if (this.c == null || this.c.isEmpty() || (hnVar = this.c.get(str)) == null) {
                return;
            }
            String strPr = hnVar.pr();
            if (!TextUtils.isEmpty(strPr) && com.byazt.bg.pr.pr().uc() != null) {
                com.byazt.bg.pr.pr().uc().delete(strPr, str);
            }
            this.c.remove(str);
        } catch (Throwable th) {
        }
    }

    private void x(String str) {
        LruCache<String, com.byazt.hfm.hw> lruCache;
        if (TextUtils.isEmpty(str) || (lruCache = this.fw) == null || lruCache.size() <= 0) {
            return;
        }
        synchronized (this.x) {
            this.fw.remove(str);
        }
    }

    public static String hn() {
        return new StringBuilder("CREATE TABLE IF NOT EXISTS template_diff_new (_id INTEGER PRIMARY KEY AUTOINCREMENT,rit TEXT ,id TEXT UNIQUE,md5 TEXT ,url TEXT , data TEXT , version TEXT , update_time TEXT)").toString();
    }
}
