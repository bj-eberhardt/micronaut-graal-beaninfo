package com.example

import io.micronaut.core.annotation.Introspected

@Introspected
data class SendBody(
  val normalProperty: String,
  val `hypthened-property`: String
)

data class SendBodyNotIntrospected(
  val normalProperty: String,
  val `hypthened-property`: String
)