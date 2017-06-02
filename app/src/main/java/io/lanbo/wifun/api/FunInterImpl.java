package io.lanbo.wifun.api;

import java.util.concurrent.TimeUnit;

import io.lanbo.wifun.model.Fun;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wumeng051 on 2017/6/2.
 * 接口实现类
 */

public class FunInterImpl implements FunInter {
    public static final String BASE_URL ="http://japi.juhe.cn/joke/content/";
    public static final String GIF_BASE_URL ="http://japi.juhe.cn/joke/img/";
    public static final String Random_BASE_URL ="http://v.juhe.cn/joke/";
    private static final int DEFAULT_TIMEOUT=5;
    private static final String TAG = "FunInterImpl";
    private Retrofit retrofit;
    private FunService funServices;

    public FunInterImpl(String url) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder().client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
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

    }

    @Override
    public void getRandomJoke(Subscriber<Fun> subscriber, String key, String type) {

    }

    @Override
    public void getRandomGif(Subscriber<Fun> subscriber, String key, String type) {

    }

    private static class SingletonHolder {
        private static final FunInterImpl INSTANCE = new FunInterImpl(BASE_URL);
        private static final FunInterImpl GIFINSTANCE = new FunInterImpl(GIF_BASE_URL);
        private static final FunInterImpl RANDOMINSTANCE = new FunInterImpl(Random_BASE_URL);
    }
}
