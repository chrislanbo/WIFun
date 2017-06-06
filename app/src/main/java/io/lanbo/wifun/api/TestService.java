package io.lanbo.wifun.api;

import io.lanbo.wifun.model.Fun;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TestService {
    @GET("text.from")
    Call<Fun> getTest(@Query("key")String key,
                            @Query("page")int page,
                            @Query("pagesize")int pagesize);
}