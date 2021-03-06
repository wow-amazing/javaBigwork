package com.java.guoshiguang.scholar.scholarlist;

import android.os.Bundle;

import com.java.guoshiguang.BasePresenter;
import com.java.guoshiguang.BaseView;
import com.java.guoshiguang.data.Scholar;

import java.util.List;

public interface ScholarListContract {
    interface View extends BaseView<ScholarListContract.Presenter> {

        /**
         * 清空当前UI，并填充新闻，用做初始化
         * 可能会调用多次
         *
         * @param list 新闻列表
         */
        void setScholarList(List<Scholar> list);

        /**
         * 添加新闻到当前UI的后面
         *
         * @param list 新闻列表
         */
        void appendScholarList(List<Scholar> list);


        /**
         * 获取新闻成功
         *
         * @param loadCompleted 是否加载完成
         */
        void onSuccess(boolean loadCompleted);

        /**
         * 获取新闻失败
         */
        void onError();
    }

    interface Presenter extends BasePresenter {

        /**
         * 是否正在加载
         */
        boolean isLoading();

        /**
         * 新闻列表翻到了最底下，需要更多数据
         */
        void requireMoreScholars() throws Exception;

        /**
         * 上拉刷新，重新获取最新的新闻
         */
        void refreshScholar() throws Exception;

        /**
         * 打开新闻详情
         *
         * @param news    被打开的新闻
         * @param options 过渡选项
         */
        void openScholarDetailUI(Scholar news, Bundle options);

    }
}
