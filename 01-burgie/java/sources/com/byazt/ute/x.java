package com.byazt.ute;

import android.text.TextUtils;
import com.byazt.auw.DownloadInfo;
import com.byazt.eld.k;
import com.byazt.lj.Downloader;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_COST, 121})
public class x {
    public static volatile x pr;
    public long hw = 0;
    public ConcurrentHashMap<String, c> hn = new ConcurrentHashMap<>();
    public HashMap<String, Integer> x = new HashMap<>();
    public List<String> c = new CopyOnWriteArrayList();

    public static x pr() {
        if (pr == null) {
            synchronized (x.class) {
                if (pr == null) {
                    pr = new x();
                }
            }
        }
        return pr;
    }

    public void pr(String str, c cVar) {
        if (!TextUtils.isEmpty(str)) {
            this.hn.put(str, cVar);
        }
    }

    public void pr(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.hn.remove(str);
        }
    }

    public long hw() {
        return this.hw;
    }

    public void hn() {
        this.hw = System.currentTimeMillis();
    }

    public int hw(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.x == null) {
            this.x = new HashMap<>();
        }
        if (this.x.containsKey(str)) {
            return this.x.get(str).intValue();
        }
        return 0;
    }

    public static void pr(com.byazt.tia.hw hwVar) {
        DownloadInfo downloadInfo;
        if (hwVar == null || hwVar.hw() <= 0 || (downloadInfo = Downloader.getInstance(k.getContext()).getDownloadInfo(hwVar.qa())) == null) {
            return;
        }
        pr(downloadInfo);
    }

    public static void pr(DownloadInfo downloadInfo) {
        if (downloadInfo == null || com.byazt.ew.pr.pr(downloadInfo.getId()).pr("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
        }
    }
}
