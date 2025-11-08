package com.example.mnf_apis


import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("products")
    suspend fun getProducts() : Response<List<ProductModel>>
    @POST("products")
    suspend fun createProduct(@Body product: ProductModel) : Response<ProductModel>
    // Response<Unit>
}
//Todo 1 : Get All Products Api in screen
// ( How to show image using url )
//Todo 2 : Create new User
//Todo 3 : Use Login API
