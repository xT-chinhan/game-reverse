package com.byazt.rc;

import android.app.Dialog;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import com.byazt.mr.uc;
import java.lang.reflect.Field;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@com.byazt.vzx.pr(pr = {0, 1, 91, 13})
public class hw {
    public pr hw;
    public final com.byazt.dw.hw pr;

    public interface pr {
        void pr(uc ucVar);
    }

    public hw(com.byazt.dw.hw hwVar) {
        this.pr = hwVar;
    }

    public void pr(uc ucVar) {
        if (this.pr != null && ucVar != null) {
            com.byazt.rc.pr.pr().pr(this.pr, ucVar);
        }
        pr prVar = this.hw;
        if (prVar != null) {
            prVar.pr(ucVar);
        }
    }

    public static final void pr(com.byazt.dw.hw hwVar, Dialog dialog, Integer[] numArr) {
        pr(hwVar, dialog, numArr, null);
    }

    public static final void pr(com.byazt.dw.hw hwVar, Dialog dialog, Integer[] numArr, pr prVar) {
        if (numArr == null || numArr.length <= 0) {
            return;
        }
        hw hwVar2 = new hw(hwVar);
        hwVar2.hw = prVar;
        for (Integer num : numArr) {
            View viewFindViewById = dialog.findViewById(num.intValue());
            if (viewFindViewById instanceof ListView) {
                ListView listView = (ListView) viewFindViewById;
                listView.setOnItemClickListener(new C0174hw(listView.getOnItemClickListener(), hwVar2));
            }
        }
    }

    /* JADX INFO: renamed from: com.byazt.rc.hw$hw, reason: collision with other inner class name */
    @com.byazt.vzx.pr(pr = {0, 1, 91, 497})
    private static final class C0174hw implements AdapterView.OnItemClickListener {
        public final AdapterView.OnItemClickListener hw;
        public final hw pr;

        private C0174hw(AdapterView.OnItemClickListener onItemClickListener, hw hwVar) {
            this.pr = hwVar;
            this.hw = onItemClickListener;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Adapter adapter = adapterView.getAdapter();
            if (adapter != null) {
                Object item = adapter.getItem(i);
                if (item instanceof Function) {
                    this.pr.pr(pr(item));
                }
            }
            AdapterView.OnItemClickListener onItemClickListener = this.hw;
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(adapterView, view, i, j);
            }
        }

        private com.byazt.dw.hn pr(Object obj) {
            if (obj == null) {
                return null;
            }
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            for (int i = 0; i < declaredFields.length; i++) {
                try {
                    declaredFields[i].setAccessible(true);
                    Object obj2 = declaredFields[i].get(obj);
                    if (obj2 instanceof uc) {
                        return new com.byazt.dw.hn(((uc) obj2).pr(), ((uc) obj2).hw());
                    }
                    continue;
                } catch (Exception e) {
                }
            }
            return null;
        }
    }
}
