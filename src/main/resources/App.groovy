//def appConfig = container.config()
def conf = [
    "address": "mongodb-persistor",
    "host": "localhost",
    "port": 27017,
    "pool_size": 10,
    "db_name": "docinsider"
]

container.with {

    deployModule('io.vertx~mod.mongo-persistor~2.1.0', conf) {
        log.info "App: The mongo-persister module is deployed."
    }

    deployVerticle('groovy:com.crowdla.core.WebServer')
}

