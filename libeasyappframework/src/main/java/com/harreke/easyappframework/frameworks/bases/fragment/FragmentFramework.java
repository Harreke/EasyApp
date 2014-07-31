package com.harreke.easyappframework.frameworks.bases.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.harreke.easyappframework.R;
import com.harreke.easyappframework.frameworks.bases.IActionBar;
import com.harreke.easyappframework.frameworks.bases.IFramework;
import com.harreke.easyappframework.frameworks.bases.activity.ActivityFramework;
import com.harreke.easyappframework.helpers.outers.VolleyRequestHelper;
import com.harreke.easyappframework.requests.IRequestCallback;
import com.harreke.easyappframework.requests.RequestBuilder;
import com.harreke.easyappframework.tools.DevUtil;
import com.harreke.easyappframework.widgets.InfoView;
import com.harreke.easyappframework.widgets.ToastView;

/**
 * 由 Harreke（harreke@live.cn） 创建于 2014/07/24
 *
 * Fragment框架
 */
public abstract class FragmentFramework extends Fragment implements IFramework, IFragment, IActionBar {
    private static final String TAG = "FragmentFramework";
    private FrameLayout framework_content;
    private InfoView framework_info;
    private ToastView framework_toast;
    private View.OnClickListener mInfoClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (framework_info.isShowingRetry()) {
                onInfoClick();
            }
        }
    };
    private VolleyRequestHelper mRequest;

    /**
     * 为ActionBar添加一个菜单选项
     *
     * @param title
     *         选项标题
     * @param imageId
     *         选项的图标Id
     */
    @Override
    public void addActionBarItem(String title, int imageId) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.addActionBarItem(title, imageId);
        }
    }

    /**
     * 为ActionBar添加一个菜单选项
     *
     * @param title
     *         选项标题
     * @param imageId
     *         选项的图标Id
     * @param flag
     *         选项的Flag
     */
    @Override
    public void addActionBarItem(String title, int imageId, int flag) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.addActionBarItem(title, imageId, flag);
        }
    }

    /**
     * 为ActionBar添加一个菜单选项
     *
     * @param title
     *         选项标题
     * @param view
     *         选项的视图
     */
    @Override
    public void addActionBarItem(String title, View view) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.addActionBarItem(title, view);
        }
    }

    /**
     * 为ActionBar添加一个菜单选项
     *
     * @param title
     *         选项标题
     * @param view
     *         选项的视图
     * @param flag
     *         选项的Flag
     */
    @Override
    public void addActionBarItem(String title, View view, int flag) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.addActionBarItem(title, view, flag);
        }
    }

    /**
     * 为ActionBar添加一个菜单选项
     *
     * @param title
     *         选项标题 选项的图标Id 选项的视图
     * @param view
     *         选项的视图
     * @param items
     *         选项的内容数组
     */
    @Override
    public void addActionBarItem(String title, View view, String[] items) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.addActionBarItem(title, view, items);
        }
    }

    /**
     * 为ActionBar添加一个菜单选项
     *
     * @param title
     *         选项标题
     * @param view
     *         选项的视图
     * @param items
     *         选项的内容数组
     * @param flag
     *         选项的Flag
     */
    @Override
    public void addActionBarItem(String title, View view, String[] items, int flag) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.addActionBarItem(title, view, items, flag);
        }
    }

    /**
     * 为ActionBar添加一个菜单选项
     *
     * @param title
     *         选项标题
     * @param imageId
     *         选项的图标Id
     * @param items
     *         选项的内容数组
     */
    @Override
    public void addActionBarItem(String title, int imageId, String[] items) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.addActionBarItem(title, imageId, items);
        }
    }

    /**
     * 为ActionBar添加一个菜单选项
     *
     * @param title
     *         选项标题
     * @param imageId
     *         选项的图标Id
     * @param items
     *         选项的内容数组
     * @param flag
     *         选项的Flag
     */
    @Override
    public void addActionBarItem(String title, int imageId, String[] items, int flag) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.addActionBarItem(title, imageId, items, flag);
        }
    }

    /**
     * 禁用ActionBar的Home键上的图标
     */
    @Override
    public void disableActionBarHomeIcon() {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.disableActionBarHomeIcon();
        }
    }

    /**
     * 显示ActionBar的Home键左边的返回箭头
     */
    @Override
    public void enableActionBarHomeBack() {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.enableActionBarHomeBack();
        }
    }

    /**
     * 隐藏ActoinBar上的指定菜单选项
     */
    @Override
    public void hideActionBarItem(int position) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.hideActionBarItem(position);
        }
    }

    /**
     * 判断ActionB上的某个菜单选项是否正在显示
     *
     * @param position
     *         菜单选项位置
     *
     * @return 菜单选项是否正在显示
     */
    @Override
    public boolean isActionBarItemShowing(int position) {
        ActivityFramework activity = getActivityFramework();

        return activity != null && activity.isActionBarItemShowing(position);
    }

    /**
     * 判断ActionBar是否正在显示
     *
     * @return ActionBar是否正在显示
     */
    @Override
    public boolean isActionBarShowing() {
        ActivityFramework activity = getActivityFramework();

        return activity != null && activity.isActionBarShowing();
    }

    /**
     * 刷新ActionBar上的菜单选项
     */
    @Override
    public void refreshActionBarItems() {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.refreshActionBarItems();
        }
    }

    /**
     * 设置ActionBar的Home键是否可点击
     *
     * @param clickable
     *         是否可点击
     */
    @Override
    public final void setActionBarHomeClickable(boolean clickable) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.setActionBarHomeClickable(clickable);
        }
    }

    /**
     * 设置ActionBar的Home键上的标题
     *
     * @param titleId
     *         标题Id
     */
    @Override
    public void setActionBarHomeTitle(int titleId) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.setActionBarHomeTitle(titleId);
        }
    }

    /**
     * 设置ActionBar的Home键上的标题
     *
     * @param title
     *         标题
     */
    @Override
    public void setActionBarHomeTitle(String title) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.setActionBarHomeTitle(title);
        }
    }

    /**
     * 设置ActionBar的Home键上的标题是否可见
     *
     * @param visible
     *         是否可见
     */
    @Override
    public void setActionBarHomeTitleVisible(boolean visible) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.setActionBarHomeTitleVisible(visible);
        }
    }

    /**
     * 设置ActionBar的Home键是否可见
     *
     * @param visible
     *         是否可见
     */
    @Override
    public void setActionBarHomeVisible(boolean visible) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.setActionBarHomeVisible(visible);
        }
    }

    /**
     * 设置ActionBar上的所有菜单选项是否可见
     *
     * @param visible
     *         是否可见
     */
    @Override
    public void setActionBarItemsVisible(boolean visible) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.setActionBarItemsVisible(visible);
        }
    }

    /**
     * 设置ActionBar的视图
     *
     * @param viewId
     *         ActionBar的视图Id
     */
    @Override
    public void setActionBarView(int viewId) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.setActionBarView(viewId);
        }
    }

    /**
     * 设置ActionBar是否可见
     *
     * @param visible
     *         是否可见
     */
    @Override
    public void setActionBarVisible(boolean visible) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.setActionBarVisible(visible);
        }
    }

    /**
     * 显示ActionBar上的指定菜单选项
     *
     * @param position
     *         菜单选项位置
     */
    @Override
    public void showActionBarItem(int position) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            activity.showActionBarItem(position);
        }
    }

    /**
     * 布局新增视图
     *
     * @param view
     *         视图
     * @param params
     *         布局参数
     */
    @Override
    public final void addContentView(View view, FrameLayout.LayoutParams params) {
        framework_content.addView(view, params);
    }

    /**
     * 取消正在执行的Http请求
     */
    @Override
    public final void cancelRequest() {
        mRequest.cancel();
    }

    /**
     * 输出调试信息
     *
     * @param message
     *         调试信息
     */
    @Override
    public void debug(String message) {
        DevUtil.e(TAG, message);
    }

    /**
     * 执行一个Http请求
     *
     * 注：同一时间只能执行一个请求，新增请求前会先取消正在执行的请求
     *
     * @param builder
     *         Http请求
     * @param callback
     *         Http请求回调
     */
    @Override
    public final <RESULT> void executeRequest(RequestBuilder builder, IRequestCallback<RESULT> callback) {
        mRequest.execute(getActivity(), builder, callback);
    }

    /**
     * 获得内容层视图
     *
     * 框架拥有两层视图，内容层和消息层
     *
     * 内容层为xml文件中编写的实际布局内容
     *
     * @return 内容层视图
     */
    @Override
    public final View getContent() {
        return framework_content;
    }

    /**
     * 获得框架
     *
     * @return 框架
     */
    @Override
    public final IFramework getFramework() {
        return this;
    }

    /**
     * 获得消息层视图
     *
     * 框架拥有两层视图，内容层和消息层
     * 消息层为一个InfoView（消息视图），盖在内容层上，用来提示相关信息（如加载中）
     * 框架因执行启动、刷新数据等异步操作，而导致内容层里的内容不可用时，会显示出消息层
     * 当异步操作完成后，消息层会隐藏，重新显示出内容层
     *
     * @return 消息层视图
     *
     * @see com.harreke.easyappframework.widgets.InfoView
     */
    @Override
    public final InfoView getInfo() {
        return framework_info;
    }

    /**
     * 隐藏Toast
     *
     * @param animate
     *         是否显示动画
     */
    @Override
    public final void hideToast(boolean animate) {
        framework_toast.hide(animate);
    }

    /**
     * 隐藏Toast
     */
    @Override
    public final void hideToast() {
        framework_toast.hide();
    }

    /**
     * 是否正在执行一个Http请求
     *
     * @return boolean
     */
    @Override
    public boolean isRequestExecuting() {
        return mRequest.isExecuting();
    }

    /**
     * 查找视图
     *
     * @param viewId
     *         视图id
     *
     * @return 视图
     */
    @Override
    public final View queryContent(int viewId) {
        return framework_content.findViewById(viewId);
    }

    /**
     * 设置内容层布局
     *
     * @param view
     *         布局视图
     */
    @Override
    public final void setContent(View view) {
        framework_content.removeAllViews();
        framework_content.addView(view);
    }

    /**
     * 设置内容层布局
     *
     * @param layoutId
     *         布局Id
     */
    @Override
    public final void setContent(int layoutId) {
        framework_content.removeAllViews();
        View.inflate(getActivity(), layoutId, framework_content);
    }

    /**
     * 设置内容层是否可见
     *
     * @param visible
     *         是否可见
     */
    @Override
    public void setContentVisible(boolean visible) {
        if (visible) {
            framework_content.setVisibility(View.VISIBLE);
        } else {
            framework_content.setVisibility(View.GONE);
        }
    }

    /**
     * 设置消息层可见方式
     *
     * @param infoVisibility
     *         可见方式
     *         {@link com.harreke.easyappframework.widgets.InfoView#INFO_HIDE}
     *         {@link com.harreke.easyappframework.widgets.InfoView#INFO_LOADING}
     *         {@link com.harreke.easyappframework.widgets.InfoView#INFO_EMPTY}
     *         {@link com.harreke.easyappframework.widgets.InfoView#INFO_ERROR}
     */
    @Override
    public void setInfoVisibility(int infoVisibility) {
        framework_info.setInfoVisibility(infoVisibility);
    }

    /**
     * 显示Toast
     *
     * @param text
     *         Toast文本
     */
    @Override
    public final void showToast(String text) {
        framework_toast.show(text, false);
    }

    /**
     * 显示Toast
     *
     * @param text
     *         文本
     * @param progress
     *         是否显示进度条
     */
    @Override
    public final void showToast(String text, boolean progress) {
        framework_toast.show(text, progress);
    }

    /**
     * 启动Intent
     *
     * @param intent
     *         目标Intent
     */
    @Override
    public final void start(Intent intent) {
        start(intent, true);
    }

    /**
     * 启动Intent
     *
     * @param intent
     *         目标Intent
     * @param animate
     *         是否显示切换动画
     */
    @Override
    public final void start(Intent intent, boolean animate) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            hideToast(false);
            activity.start(intent, animate);
        }
    }

    /**
     * 启动带回调的Intent
     *
     * @param intent
     *         目标Intent
     * @param requestCode
     *         请求代码
     */
    @Override
    public final void start(Intent intent, int requestCode) {
        ActivityFramework activity = getActivityFramework();

        if (activity != null) {
            hideToast(false);
            startActivityForResult(intent, requestCode);
            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        }
    }

    private ActivityFramework getActivityFramework() {
        ActivityFramework activityFramework;

        try {
            activityFramework = (ActivityFramework) getActivity();
        } catch (ClassCastException e) {
            activityFramework = null;
        }

        return activityFramework;
    }

    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FrameLayout framework = (FrameLayout) inflater.inflate(R.layout.widget_framework, null);

        if (framework != null) {
            framework_content = (FrameLayout) framework.findViewById(R.id.framework_content);
            framework_info = (InfoView) framework.findViewById(R.id.framework_info);
            framework_toast = (ToastView) framework.findViewById(R.id.framework_toast);
            mRequest = new VolleyRequestHelper();
            framework_info.setOnClickListener(mInfoClickListener);
        }

        return framework;
    }

    @Override
    public final void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setLayout();
        initData(getArguments());
        queryLayout();
        newEvents();
        assignEvents();
        startAction();
    }

    @Override
    public void onDestroyView() {
        hideToast(false);
        cancelRequest();
        super.onDestroyView();
    }

    /**
     * 当消息层被点击时触发
     */
    @Override
    public void onInfoClick() {
        if (!isRequestExecuting()) {
            startAction();
        }
    }
}