package junior.sergivaldo;

import junior.sergivaldo.services.bucket.Bucket;
import junior.sergivaldo.services.bucket.BucketService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        final String AUTHORIZATION = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImNldmlva3llY2VreGlsZWtmZ3B2Iiwicm9sZSI6InNlcnZpY2Vfcm9sZSIsImlhdCI6MTcxMDg3NDYyMCwiZXhwIjoyMDI2NDUwNjIwfQ.A8slrV0WWgyx4NhELThmXjn4lIUmgJUfcT4oZju7aYo";
        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(chain -> {
                    var req = chain.request();
                    var newReq = req.newBuilder()
                            .addHeader("Authorization", AUTHORIZATION)
                            .build();
                    return chain.proceed(newReq);
                })
                .build();

        Retrofit rf = new Retrofit.Builder()
                .baseUrl("https://ceviokyecekxilekfgpv.supabase.co/storage/v1/")
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        BucketService bs = rf.create(BucketService.class);
        Optional<List<Bucket>> b = Optional.ofNullable(bs.getAll().execute().body());
        b.ifPresent(buckets -> buckets.forEach(System.out::println));
    }
}