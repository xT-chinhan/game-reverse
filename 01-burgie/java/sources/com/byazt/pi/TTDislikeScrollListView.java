package com.byazt.pi;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.byazt.mr.uc;
import com.byazt.rc.hw;
import com.byazt.vzx.pr;

/* JADX INFO: loaded from: classes2.dex */
@pr(pr = {0, 1, 118, 2274})
public class TTDislikeScrollListView extends ListView {
    public AdapterView.OnItemClickListener hn;
    public AdapterView.OnItemClickListener hw;
    public hw pr;

    public TTDislikeScrollListView(Context context) {
        super(context);
        this.hn = new AdapterView.OnItemClickListener() { // from class: com.byazt.pi.TTDislikeScrollListView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (TTDislikeScrollListView.this.getAdapter() != null && TTDislikeScrollListView.this.getAdapter().getItem(i) != null && (TTDislikeScrollListView.this.getAdapter().getItem(i) instanceof uc)) {
                    uc ucVar = (uc) TTDislikeScrollListView.this.getAdapter().getItem(i);
                    if (!ucVar.fw()) {
                        if (TTDislikeScrollListView.this.hw != null) {
                            TTDislikeScrollListView.this.hw.onItemClick(adapterView, view, i, j);
                        }
                        if (TTDislikeScrollListView.this.pr != null) {
                            TTDislikeScrollListView.this.pr.pr(ucVar);
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("adapter数据异常，必须为FilterWord");
            }
        };
        pr();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    private void pr() {
        super.setOnItemClickListener(this.hn);
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.hw = onItemClickListener;
    }

    public void setDislikeController(hw hwVar) {
        this.pr = hwVar;
    }
}
