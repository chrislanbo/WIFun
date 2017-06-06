package io.lanbo.wifun.api;

import io.lanbo.wifun.model.Fun;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomService {
    @GET("randJoke.php")
    rx.Observable<Fun> getItem(@Query("key")String key,
                               @Query("type")String type);
}