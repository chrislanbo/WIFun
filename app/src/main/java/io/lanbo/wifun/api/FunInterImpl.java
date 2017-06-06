package io.lanbo.wifun.api;

import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.lanbo.wifun.model.Fun;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wumeng051 on 2017/6/2.
 * 接口实现类
 */

public class FunInterImpl implements FunInter {
    private static final String BASE_URL ="http://japi.juhe.cn/joke/content/";
    private static final String GIF_BASE_URL ="http://japi.juhe.cn/joke/img/";
    private static final String Random_BASE_URL ="http://v.juhe.cn/joke/";
    private static final int DEFAULT_TIMEOUT=5;
    private static final String TAG = "FunInterImpl";
    private Retrofit retrofit;
    private FunService funServices;
    private RandomService randomService;

    public FunInterImpl(String url) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder().client(builder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
    }

    @Override
    public void getJoke(Subscriber<Fun> subscriber, String key, int Page, int pageSize) {
        funServices = retrofit.create(FunService.class);
        funServices.getItem(key,Page,pageSize)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void getGif(Subscriber<Fun> subscriber, String key, int Page, int pageSize) {
        funServices = retrofit.create(FunService.class);
        funServices.getItem(key,Page,pageSize)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void getRandomJoke(Subscriber<Fun> subscriber, String key, String type) {
        randomService = retrofit.create(RandomService.class);
        randomService.getItem(key,type)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void getRandomGif(Subscriber<Fun> subscriber, String key, String type) {
        randomService = retrofit.create(RandomService.class);
        randomService.getItem(key,type)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void test(String key, int Page, int pageSize) {
        TestService testService = retrofit.create(TestService.class);
        Call<Fun> test = testService.getTest(key, Page, pageSize);
        test.enqueue(new Callback<Fun>() {
            @Override
            public void onResponse(Call<Fun> call, Response<Fun> response) {
                Log.i(TAG,response + "");
                Fun fun = response.body();
                if (null!=fun){
                    Fun.ResultBean result = fun.getResult();
                    Log.i(TAG, "请求成功:" + fun+ "");
                    if (null!=result){
                        List<Fun.ResultBean.DataBean> data = result.getData();
                        for (Fun.ResultBean.DataBean d : result.getData()) {
                            Log.i(TAG, "请求成功:" + d+ "");
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<Fun> call, Throwable t) {
                Log.i(TAG, "失败:" + t + "");
            }
        });
    }

    public static FunInterImpl getIntance(){
        return SingletonHolder.INSTANCE;
    }

    public static FunInterImpl getGifIntance(){
        return SingletonHolder.GIFINSTANCE;
    }

    public static FunInterImpl getRandomIntance(){
        return SingletonHolder.RANDOMINSTANCE;
    }

    private static class SingletonHolder {
        private static final FunInterImpl INSTANCE = new FunInterImpl(BASE_URL);
        private static final FunInterImpl GIFINSTANCE = new FunInterImpl(GIF_BASE_URL);
        private static final FunInterImpl RANDOMINSTANCE = new FunInterImpl(Random_BASE_URL);
    }
}
