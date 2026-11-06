package com.taptap.sdk.flowlayout;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TagAdapter<T> {

    @Deprecated
    private HashSet<Integer> mCheckedPosList = new HashSet<>();
    private OnDataChangedListener mOnDataChangedListener;
    private List<T> mTagDatas;

    interface OnDataChangedListener {
        void onChanged();
    }

    public abstract View getView(FlowLayout flowLayout, int i, T t);

    public boolean setSelected(int i, T t) {
        return false;
    }

    public TagAdapter(List<T> list) {
        this.mTagDatas = list;
    }

    @Deprecated
    public TagAdapter(T[] tArr) {
        this.mTagDatas = new ArrayList(Arrays.asList(tArr));
    }

    public void setOnDataChangedListener(OnDataChangedListener onDataChangedListener) {
        this.mOnDataChangedListener = onDataChangedListener;
    }

    @Deprecated
    public void setSelectedList(int... iArr) {
        HashSet hashSet = new HashSet();
        for (int i : iArr) {
            hashSet.add(Integer.valueOf(i));
        }
        setSelectedList(hashSet);
    }

    @Deprecated
    public void setSelectedList(Set<Integer> set) {
        this.mCheckedPosList.clear();
        if (set != null) {
            this.mCheckedPosList.addAll(set);
        }
        notifyDataChanged();
    }

    @Deprecated
    public HashSet<Integer> getPreCheckedList() {
        return this.mCheckedPosList;
    }

    public int getCount() {
        List<T> list = this.mTagDatas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void notifyDataChanged() {
        OnDataChangedListener onDataChangedListener = this.mOnDataChangedListener;
        if (onDataChangedListener != null) {
            onDataChangedListener.onChanged();
        }
    }

    public T getItem(int i) {
        return this.mTagDatas.get(i);
    }

    public void onSelected(int i, View view) {
        Log.d("zhy", "onSelected " + i);
    }

    public void unSelected(int i, View view) {
        Log.d("zhy", "unSelected " + i);
    }
}
