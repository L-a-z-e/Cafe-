package kr.ac.gachon.Project201533745.Rest;

import java.util.List;

import kr.ac.gachon.Project201533745.Order;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

//POST나 GET안에 URL을 넣고 Call<>는 반환받을 데이터 타입,
//요청시 POST는 Body에 데이터를 넣어 보내고
//GET은 Query에 데이터를 넣어서 전송
public interface RetrofitService {
    @POST("/Login")
    Call<ResponseLogin> PostLogin(@Body RequestLogin requestLogin);

    @POST("/Register")
    Call<RequestRegister> PostRegister(@Body RequestRegister requestRegister);

    @GET("/Orders")
    Call<List<ResponseOrders>> GetOrders();

    @POST("/Order")
    Call<ResponseResult> PostOrder(@Body RequestOrder requestOrder);

    @GET("/Update/Status")
    Call<ResponseResult> UpdateStatus(@Query("OrderID") int OrderID);

    @GET("/Orders/My")
    Call<List<ResponseOrders>> GetMyOrders(@Query("UserID") String UserID);
}
