package com.example

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client

@Client("http://localhost:\${micronaut.server.port}")
interface Client {

  @Post("/test", consumes = [MediaType.TEXT_PLAIN], produces = [MediaType.APPLICATION_FORM_URLENCODED])
  fun send(@Body request: SendBody): String

  @Post("/test", consumes = [MediaType.TEXT_PLAIN], produces = [MediaType.APPLICATION_FORM_URLENCODED])
  fun sendWithoutIntrospected(@Body request: SendBodyNotIntrospected): String
}
