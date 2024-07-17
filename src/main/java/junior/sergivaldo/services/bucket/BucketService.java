package junior.sergivaldo.services.bucket;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import java.util.List;

public interface BucketService {

    @GET("bucket")
    Call<List<Bucket>> getAll();

    @GET("bucket/{bucketId}")
    Call<Bucket> getById(@Path("bucketId") String bucketId);

    @POST("bucket")
    Call<Bucket> create(@Body Bucket bucket);

    @POST("bucket/{bucketId}/empty")
    Call<Bucket> createEmpty(@Path("bucketId") String bucketId);

    @PUT("bucket/{bucketId}")
    Call<Void> update(@Path("bucketId") String bucketId, @Body UpdateBucket bucket);

    @DELETE("bucket/{bucketId}")
    Call<Void> delete(@Path("bucketId") String bucketId);
}
