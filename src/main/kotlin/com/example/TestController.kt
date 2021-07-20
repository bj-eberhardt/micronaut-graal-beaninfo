package com.example

import io.micronaut.http.HttpRequest
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller
class TestController(
  private val client: Client
) {

  @Get
  fun test() {
    println("called GET /")
    val responseIntrospected = client.send(SendBody("data1", "data2"))
    println("called GET / with introspected response $responseIntrospected")

    val response = client.sendWithoutIntrospected(SendBodyNotIntrospected("data1", "data2"))
    println("called GET / with non introspected response $response")
  }

  @Post("/test", consumes = [MediaType.APPLICATION_FORM_URLENCODED], produces = [MediaType.TEXT_PLAIN])
  fun consumer(req: HttpRequest<String>): String {
    println("called POST /test")
    return req.body.orElse("EMPTY")
  }
}