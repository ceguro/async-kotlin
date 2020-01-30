package com.example.asynckotlin.controller

import com.example.asynckotlin.service.CompletableFutureService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*
import java.util.concurrent.CompletableFuture

@Controller
@RequestMapping("/api")
class AsyncController(
        val completableFutureService: CompletableFutureService
) {

    companion object {
        val logger: Logger = LoggerFactory.getLogger(CompletableFutureService::class.java)
    }


    @GetMapping("/books")
    fun getBooks(): ResponseEntity<String> {

        logger.info("before service call: {} " + Calendar.getInstance().time)

        completableFutureService.getBooks()
        completableFutureService.getBooks()
        completableFutureService.getBooks()
        completableFutureService.getBooks()
        completableFutureService.getBooks()

        logger.info("after service call: {} " + Calendar.getInstance().time)
        return ResponseEntity("", HttpStatus.OK)
    }


    @GetMapping("/books/all")
    fun getAllBooks(): ResponseEntity<String> {

        logger.info("before service call: {} " + Calendar.getInstance().time)

        val completableFuture1 = completableFutureService.getAllBooks()
        val completableFuture2 = completableFutureService.getAllBooks()
        val completableFuture3 = completableFutureService.getAllBooks()
        val completableFuture4 = completableFutureService.getAllBooks()
        val completableFuture5 = completableFutureService.getAllBooks()

        val completableFutureCombined = CompletableFuture.allOf(completableFuture1, completableFuture2, completableFuture3,completableFuture4, completableFuture5)

        completableFutureCombined.join()

        logger.info("after service call: {} " + Calendar.getInstance().time)
        return ResponseEntity("", HttpStatus.OK)
    }

}