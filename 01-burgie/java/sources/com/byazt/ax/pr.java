package com.byazt.ax;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.DownloadListener;
import com.byazt.ca.ho;
import com.byazt.cu.TTBaseVideoActivity;
import com.byazt.hg.of;
import com.byazt.hg.vk;
import com.byazt.jx.zo;
import com.byazt.qx.NativeExpressView;
import com.byazt.sd.a;
import com.byazt.sd.g;
import com.byazt.wt.ls;
import com.byazt.xlm.fw;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ, 37})
public class pr {
    public TTBaseVideoActivity c;
    public String fw;
    public com.byazt.nv.hn hw;
    public of uc;
    public String zo;
    public final Map<String, com.byazt.nv.hn> pr = Collections.synchronizedMap(new HashMap());
    public final hn x = new hn();
    public View hn = null;
    public long aj = 0;
    public long vk = 0;
    public long w = 0;
    public long k = 0;
    public long m = 0;
    public long g = 0;
    public boolean nt = true;
    public boolean ho = false;

    public interface hw {
        void hn(boolean z, long j, long j2, String str, String str2);

        void hw(boolean z, long j, long j2, String str, String str2);

        void pr(boolean z);

        void pr(boolean z, long j, long j2, String str, String str2);

        void pr(boolean z, long j, String str, String str2);

        void pr(boolean z, String str, String str2);
    }

    /* JADX INFO: renamed from: com.byazt.ax.pr$pr, reason: collision with other inner class name */
    public interface InterfaceC0021pr {
        void pr(View view, vk vkVar);

        void pr(String str, JSONObject jSONObject);
    }

    public pr(TTBaseVideoActivity tTBaseVideoActivity) {
        this.c = tTBaseVideoActivity;
    }

    public void pr(of ofVar, String str, String str2) {
        if (this.ho) {
            return;
        }
        this.ho = true;
        this.uc = ofVar;
        this.fw = str;
        zo();
        this.zo = str2;
    }

    private void zo() {
        of ofVar = this.uc;
        if (ofVar != null && ofVar.aj() == 4) {
            this.hw = zo.pr(this.c, this.uc, this.fw);
        }
    }

    public void pr() {
        of ofVar;
        if (this.hw == null && (ofVar = this.uc) != null && ofVar.aj() == 4) {
            this.hw = zo.pr(this.c, this.uc, this.fw);
        }
    }

    public com.byazt.nv.hn hw() {
        return this.hw;
    }

    public boolean hn() {
        return this.hw != null;
    }

    public void x() {
        com.byazt.nv.hn hnVar = this.hw;
        if (hnVar != null) {
            hnVar.pr((Activity) this.c, false);
            this.hw.hw();
        }
        for (Map.Entry<String, com.byazt.nv.hn> entry : this.pr.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().hw();
            }
        }
    }

    public void c() {
        for (Map.Entry<String, com.byazt.nv.hn> entry : this.pr.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue();
            }
        }
    }

    public void uc() {
        com.byazt.nv.hn hnVar = this.hw;
        if (hnVar != null) {
            hnVar.hn();
        }
        for (Map.Entry<String, com.byazt.nv.hn> entry : this.pr.entrySet()) {
            if (entry.getValue() != null) {
                entry.getValue().hn();
            }
        }
        try {
            pr(this.zo);
        } catch (Throwable th) {
            ho.pr("RewardFullDownloadManager", "remove from ITTAppDownloadListener throw Exception : ", th);
        }
    }

    private void pr(String str) {
        com.byazt.xlm.c.hw(new x("executeMultiProcessAppDownloadCallBack", str), 5);
    }

    public static g pr(int i) {
        return com.byazt.us.pr.pr(com.byazt.gt.pr.pr(a.getContext()).pr(i));
    }

    public void pr(final hw hwVar) {
        com.byazt.nv.hn hnVar = this.hw;
        if (hnVar == null) {
            return;
        }
        hnVar.pr(new com.byazt.nv.pr() { // from class: com.byazt.ax.pr.1
            @Override // com.byazt.nv.pr
            public void pr() {
                boolean z;
                if (System.currentTimeMillis() - pr.this.aj <= NativeExpressView.qa) {
                    z = false;
                } else {
                    z = true;
                    pr.this.aj = System.currentTimeMillis();
                }
                hw hwVar2 = hwVar;
                if (hwVar2 != null) {
                    hwVar2.pr(z);
                }
            }

            @Override // com.byazt.nv.pr
            public void pr(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - pr.this.w <= NativeExpressView.qa) {
                    z = false;
                } else {
                    pr.this.w = System.currentTimeMillis();
                    z = true;
                }
                hw hwVar2 = hwVar;
                if (hwVar2 != null) {
                    hwVar2.pr(z, j, j2, str, str2);
                }
            }

            @Override // com.byazt.nv.pr
            public void hw(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - pr.this.vk <= NativeExpressView.qa) {
                    z = false;
                } else {
                    pr.this.vk = System.currentTimeMillis();
                    z = true;
                }
                hw hwVar2 = hwVar;
                if (hwVar2 != null) {
                    hwVar2.hw(z, j, j2, str, str2);
                }
            }

            @Override // com.byazt.nv.pr
            public void hn(long j, long j2, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - pr.this.k <= NativeExpressView.qa) {
                    z = false;
                } else {
                    pr.this.k = System.currentTimeMillis();
                    z = true;
                }
                hw hwVar2 = hwVar;
                if (hwVar2 != null) {
                    hwVar2.hn(z, j, j2, str, str2);
                }
            }

            @Override // com.byazt.nv.pr
            public void pr(long j, String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - pr.this.m <= NativeExpressView.qa) {
                    z = false;
                } else {
                    pr.this.m = System.currentTimeMillis();
                    z = true;
                }
                hw hwVar2 = hwVar;
                if (hwVar2 != null) {
                    hwVar2.pr(z, j, str, str2);
                }
            }

            @Override // com.byazt.nv.pr
            public void pr(String str, String str2) {
                boolean z;
                if (System.currentTimeMillis() - pr.this.g <= NativeExpressView.qa) {
                    z = false;
                } else {
                    z = true;
                    pr.this.g = System.currentTimeMillis();
                }
                hw hwVar2 = hwVar;
                if (hwVar2 != null) {
                    hwVar2.pr(z, str, str2);
                }
            }
        });
    }

    public void pr(String str, boolean z) {
        if (this.pr.containsKey(str)) {
            com.byazt.nv.hn hnVar = this.pr.get(str);
            if (hnVar != null) {
                if (z) {
                    hnVar.pr(com.byazt.ri.c.pr(this.uc));
                }
                if (hnVar instanceof com.byazt.ri.pr) {
                    ((com.byazt.ri.pr) hnVar).fw().pr(this.nt);
                }
                hnVar.pr(ls.fo(this.uc), false);
                return;
            }
            return;
        }
        com.byazt.nv.hn hnVarPr = zo.pr(this.c, str, this.uc, this.fw);
        if (z) {
            hnVarPr.pr(com.byazt.ri.c.pr(this.uc));
        }
        if (hnVarPr instanceof com.byazt.ri.pr) {
            ((com.byazt.ri.pr) hnVarPr).fw().pr(this.nt);
        }
        this.pr.put(str, hnVarPr);
        hnVarPr.pr(ls.fo(this.uc), false);
    }

    public void pr(final InterfaceC0021pr interfaceC0021pr) {
        this.hw.pr(1, new com.byazt.lm.hn.pr() { // from class: com.byazt.ax.pr.2
            @Override // com.byazt.lm.hn.pr
            public boolean pr(int i, String str, String str2, String str3, Object obj) {
                if (i != 1 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                    return true;
                }
                boolean z = str2.equals("rewarded_video") || str2.equals("fullscreen_interstitial_ad");
                if (z && str3.equals("click_start")) {
                    interfaceC0021pr.pr(pr.this.hn, new vk());
                    pr.this.hn = null;
                    return true;
                }
                if (z) {
                    switch (str3) {
                        case "click_pause":
                            com.byazt.pj.pr.hw(pr.this.uc, str2, "click_play_pause", (Map<String, Object>) null);
                            break;
                        case "click_continue":
                            com.byazt.pj.pr.hw(pr.this.uc, str2, "click_play_continue", (Map<String, Object>) null);
                            break;
                    }
                    return true;
                }
                return true;
            }
        });
    }

    public void pr(View view, InterfaceC0021pr interfaceC0021pr, vk vkVar) {
        if (this.hw != null && view != null) {
            if (view.getId() == 2114387609) {
                interfaceC0021pr.pr("click_play_star_level", (JSONObject) null);
                return;
            }
            if (view.getId() == 2114387630) {
                interfaceC0021pr.pr("click_play_star_nums", (JSONObject) null);
                return;
            } else if (view.getId() == 2114387875) {
                interfaceC0021pr.pr("click_play_source", (JSONObject) null);
                return;
            } else {
                if (view.getId() == 2114387793) {
                    interfaceC0021pr.pr("click_play_logo", (JSONObject) null);
                    return;
                }
                return;
            }
        }
        interfaceC0021pr.pr(view, vkVar);
    }

    public hn fw() {
        return this.x;
    }

    public void pr(com.byazt.mm.pr.InterfaceC0136pr interfaceC0136pr) {
        com.byazt.nv.hn hnVar = this.hw;
        if (hnVar != null) {
            hnVar.pr(interfaceC0136pr);
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ, 100})
    private static class x extends fw {
        public final String pr;

        public x(String str, String str2) {
            super(str);
            this.pr = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                pr.pr(3).pr(this.pr, "recycleRes", 0L, 0L, "", "");
            } catch (Throwable th) {
                ho.pr("RewardFullDownloadManager", "executeAppDownloadCallback execute throw Exception : ", th);
            }
        }
    }

    @com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ, MediaPlayer.MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END})
    public class hn implements DownloadListener {
        public boolean hw = true;

        public hn() {
        }

        public void pr(boolean z) {
            this.hw = z;
        }

        @Override // android.webkit.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            pr(this.hw);
            pr.this.pr(str, true);
            pr.this.c.pr(1);
        }
    }
}
