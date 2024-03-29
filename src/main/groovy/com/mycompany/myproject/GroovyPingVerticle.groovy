/*
 * Copyright 2013 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 *
 */

package com.mycompany.myproject

import org.vertx.groovy.platform.Verticle

/*
 * This is a simple compiled Groovy verticle which receives `ping` messages on the event bus and sends back `pong`
 * replies
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
class GroovyPingVerticle extends Verticle {

  def start() {
      vertx.createHttpServer().requestHandler { req ->
          container.logger.info("handling request - supr")
          def file = req.uri == "/" ? "index.html" : req.uri
          req.response.sendFile "webroot/$file"
      }.listen(8080)
      container.logger.info("webserver running!")
//    vertx.eventBus.registerHandler("ping-address") { message ->
//      message.reply("pong!")
//      container.logger.info("Sent back pong groovy!")
//    }
  }
}
