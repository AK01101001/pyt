package com.example.pytania;

    import java.util.List;

    import retrofit2.Call;
    import retrofit2.http.GET;

    public interface ApiInterface {
        @GET("pytania")
        public Call<List<Pytanie>>getData();
    }
