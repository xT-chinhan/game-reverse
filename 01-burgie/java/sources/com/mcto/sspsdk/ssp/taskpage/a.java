package com.mcto.sspsdk.ssp.taskpage;

import android.support.v7.widget.RecyclerView;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import com.mcto.sspsdk.internal.kh;
import com.mcto.sspsdk.internal.lh;
import com.mcto.sspsdk.internal.oj;
import com.mcto.sspsdk.internal.pj;
import com.mcto.sspsdk.internal.uc;
import com.mcto.sspsdk.internal.w3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements w3 {
    public final /* synthetic */ QyTaskPageActivity a;

    public a(QyTaskPageActivity qyTaskPageActivity) {
        this.a = qyTaskPageActivity;
    }

    @Override // com.mcto.sspsdk.internal.w3
    public final void a(Object obj) {
        int i;
        List list = (List) obj;
        if (list == null || list.size() <= 1) {
            QyTaskPageActivity.n(this.a);
            return;
        }
        ArrayList arrayList = new ArrayList();
        oj ojVar = (oj) list.get(0);
        if (ojVar.a.P0 == 1) {
            h hVar = this.a.w;
            hVar.getClass();
            hVar.f.a(ojVar);
            hVar.f.a(true);
            hVar.f.b();
            hVar.f.a(new pj(hVar));
            QyTaskPageActivity.a(this.a, ojVar.a.Q0);
            i = 1;
        } else {
            QyTaskPageActivity.b(this.a);
            QyTaskPageActivity.m(this.a);
            i = 0;
        }
        while (i < list.size()) {
            arrayList.add(list.get(i));
            i++;
        }
        h hVar2 = this.a.w;
        hVar2.e.clear();
        hVar2.e.addAll(arrayList);
        hVar2.notifyDataSetChanged();
        hVar2.c = -1;
        hVar2.d = -1;
        lh lhVar = kh.a;
        uc ucVar = new uc(hVar2);
        lhVar.getClass();
        try {
            lhVar.a.postDelayed(ucVar, 300L);
        } catch (Exception e) {
        }
        RecyclerView recyclerView = hVar2.a;
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setInterpolator(new DecelerateInterpolator());
        TranslateAnimation translateAnimation = new TranslateAnimation(2, -0.5f, 2, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(300L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(300L);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(animationSet);
        layoutAnimationController.setDelay(0.15f);
        layoutAnimationController.setOrder(0);
        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.scheduleLayoutAnimation();
        arrayList.size();
    }
}
