package com.byazt.ndr;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.byazt.cp.n;
import com.byazt.fvm.w;
import com.byazt.nnl.qg;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: classes2.dex */
@n(n = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 2462})
public class TTDislikeScrollListView extends ListView {
    public qg n;
    public AdapterView.OnItemClickListener qg;
    public AdapterView.OnItemClickListener s;

    public TTDislikeScrollListView(Context context) {
        super(context);
        this.s = new AdapterView.OnItemClickListener() { // from class: com.byazt.ndr.TTDislikeScrollListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (TTDislikeScrollListView.this.getAdapter() != null && TTDislikeScrollListView.this.getAdapter().getItem(i) != null && (TTDislikeScrollListView.this.getAdapter().getItem(i) instanceof w)) {
                    w wVar = (w) TTDislikeScrollListView.this.getAdapter().getItem(i);
                    if (wVar.x()) {
                        return;
                    }
                    if (TTDislikeScrollListView.this.qg != null) {
                        TTDislikeScrollListView.this.qg.onItemClick(adapterView, view, i, j);
                    }
                    if (TTDislikeScrollListView.this.n != null) {
                        TTDislikeScrollListView.this.n.n(wVar);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        n();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    private void n() {
        super.setOnItemClickListener(this.s);
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.qg = onItemClickListener;
    }

    public void setDislikeController(qg qgVar) {
        this.n = qgVar;
    }
}
