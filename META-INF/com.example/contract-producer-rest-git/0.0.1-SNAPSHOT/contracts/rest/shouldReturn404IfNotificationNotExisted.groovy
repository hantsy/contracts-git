import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType

org.springframework.cloud.contract.spec.Contract.make {
    description("""
        Get notification by id
    """)
    // input to the contract
    request {
        url "/notifications/404"
        method GET()
        headers {
            header("accept", applicationJson())
        }
    }
    response {
        status(404)
        body([
            message: regex(".*not found.*"),
            code   : "not_found"
        ])
        headers {
            header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE)
        }
    }
}
