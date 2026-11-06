package com.byazt.bri;

import com.byazt.auw.DownloadInfo;
import com.byazt.zkm.vk;
import com.byazt.zkm.w;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@com.byazt.vzx.pr(pr = {0, 1, 407, 20})
public class hn implements w {
    public static volatile hn pr;
    public List<w> hw;

    public static hn pr() {
        if (pr == null) {
            synchronized (hn.class) {
                if (pr == null) {
                    pr = new hn();
                }
            }
        }
        return pr;
    }

    private hn() {
        ArrayList arrayList = new ArrayList();
        this.hw = arrayList;
        arrayList.add(new hw());
        this.hw.add(new pr());
    }

    @Override // com.byazt.zkm.w
    public void pr(DownloadInfo downloadInfo, vk vkVar) {
        if (downloadInfo == null || this.hw.size() == 0) {
            if (vkVar != null) {
                vkVar.pr();
                return;
            }
            return;
        }
        pr(downloadInfo, 0, vkVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(final DownloadInfo downloadInfo, final int i, final vk vkVar) {
        if (i == this.hw.size() || i < 0) {
            vkVar.pr();
        } else {
            this.hw.get(i).pr(downloadInfo, new vk() { // from class: com.byazt.bri.hn.1
                @Override // com.byazt.zkm.vk
                public void pr() {
                    hn.this.pr(downloadInfo, i + 1, vkVar);
                }
            });
        }
    }
}
