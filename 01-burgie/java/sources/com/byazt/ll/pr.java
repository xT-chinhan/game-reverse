package com.byazt.ll;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.byazt.ca.g;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, AVMDLDataLoader.KeyIsMarkedFileIOSpeed, 37})
public class pr extends com.byazt.igz.pr {
    public pr(Context context) {
        super(context);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003a  */
    @Override // com.byazt.igz.pr
    public String w(String str) {
        switch (str) {
            case "logo":
                return "tt_ugen_logo";
            case "back":
                return "tt_ugen_back";
            case "close":
                return "tt_ugen_close";
            case "muted":
                return "tt_ugen_muted";
            case "unmuted":
                return "tt_ugen_unmuted";
            default:
                return "";
        }
    }

    @Override // com.byazt.hl.hw
    public void pr(final ImageView imageView, String str) {
        g.pr(this.hw, str, new com.byazt.ezf.pr<Bitmap>() { // from class: com.byazt.ll.pr.1
            @Override // com.byazt.ezf.pr
            public void pr(Bitmap bitmap) {
                imageView.setImageDrawable(com.byazt.hl.pr.pr(bitmap));
            }
        }, 160);
    }
}
