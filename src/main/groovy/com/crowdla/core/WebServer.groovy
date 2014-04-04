package com.crowdla.core

import org.vertx.groovy.platform.Verticle

/**
 * User: olaf.geibig@tutaona.com
 * Created: 4/4/14 12:32 PM
 */
class WebServer extends Verticle {

    override def start() {
        vertx.createHttpServer().requestHandler { req ->
            container.logger.info("handling request - main")
            def file = req.uri == "/" ? "index.html" : req.uri
            req.response.sendFile "webroot/$file"
        }.listen(8080)
        container.logger.info("Main webserver running!")
    }

}
