package com.byazt.ub;

import com.byazt.ld.k;
import com.byazt.ld.n;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR, 20})
public class hn implements n {
    public static int pr = 0;
    public String c;
    public long hn;
    public long hw = 0;
    public boolean x;

    public hn() {
        pr++;
        this.c = "image_request_" + pr;
    }

    @Override // com.byazt.ld.n
    public void pr(String str, k kVar) {
        if (!this.x) {
            kVar.hw();
            kVar.hn();
            kVar.x();
            this.x = true;
        }
        this.hw = System.currentTimeMillis();
        hn(str, kVar);
    }

    @Override // com.byazt.ld.n
    public void hw(String str, k kVar) {
        this.hn += System.currentTimeMillis() - this.hw;
        hn(str, kVar);
    }

    private String hn(String str, k kVar) {
        com.byazt.sl.pr prVarA;
        if (str != null) {
            switch (str) {
                case "cache_policy":
                    return "查询缓存策略";
                case "decode":
                    return "解码";
                case "check_duplicate":
                    return "检查重复请求";
                case "memory_cache":
                    return "查询Bitmap内存缓存";
                case "raw_cache":
                    return "查询RAW内存缓存";
                case "disk_cache":
                    return "查询文件缓存";
                case "generate_key":
                    return "生成KEY:" + kVar.fw();
                case "net_request":
                    return "请求网络";
                case "success":
                    return "成功";
                case "failed":
                    if ((kVar instanceof com.byazt.sl.hn) && (prVarA = ((com.byazt.sl.hn) kVar).a()) != null) {
                        Throwable thHn = prVarA.hn();
                        return "失败：code:" + prVarA.pr() + ", msg:" + prVarA.hw() + ", exception:" + (thHn != null ? thHn.getMessage() : "null \r\n");
                    }
                    return "失败";
                case "image_type":
                    return "判断图片类型：";
            }
        }
        return str;
    }
}
