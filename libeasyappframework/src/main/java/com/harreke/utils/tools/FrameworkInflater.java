package com.harreke.utils.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.harreke.utils.frameworks.IFramework;

public class FrameworkInflater {
    /**
     使用框架生成指定视图

     @param framework
     需要生成视图的框架
     @param layoutId
     布局Id
     @param parent
     父视图

     @return 指定视图
     */
    public static View inflate(IFramework framework, int layoutId, ViewGroup parent) {
        View view;
        Context context;

        if (framework == null) {
            throw new IllegalArgumentException("Framework must not be null!");
        } else {
            context = framework.getActivity();
            if (context == null) {
                throw new IllegalStateException("Framework's context has been recycled!");
            } else {
                view = View.inflate(context, layoutId, parent);
            }
        }

        return view;
    }
}