package com.example.asynckotlin.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.CompletableFuture

@Service
class CompletableFutureService {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(CompletableFutureService::class.java)
    }

    @Async
    fun getBooks(): String {

        logger.info("get books service before thread sleep " + Calendar.getInstance().time )

        try {
            Thread.sleep(5000)
        }catch (e: Exception){
            //TODO
        }

        logger.info("get books service after thread sleep " + Calendar.getInstance().time )

        return "books"
    }

    @Async
    fun getAllBooks(): CompletableFuture<String> {

        logger.info("get books service before thread sleep " + Calendar.getInstance().time )

        try {
            Thread.sleep(5000)
        }catch (e: Exception){
            //TODO
        }

        logger.info("get books service after thread sleep " + Calendar.getInstance().time )

        val completableFuture = CompletableFuture<String>()

        completableFuture.complete("books")

        return completableFuture
    }

}