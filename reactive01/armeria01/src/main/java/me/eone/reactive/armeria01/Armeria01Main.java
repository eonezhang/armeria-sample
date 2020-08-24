package me.eone.reactive.armeria01;

import java.time.Duration;

import com.linecorp.armeria.common.HttpRequest;
import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.common.MediaType;
import com.linecorp.armeria.common.QueryParams;
import com.linecorp.armeria.server.Server;
import com.linecorp.armeria.server.ServerBuilder;
import com.linecorp.armeria.server.ServiceRequestContext;
import com.linecorp.armeria.server.annotation.AdditionalTrailer;
import com.linecorp.armeria.server.annotation.ExceptionHandlerFunction;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.Post;
import com.linecorp.armeria.server.file.FileService;
import com.linecorp.armeria.server.file.FileServiceBuilder;

/**
 * @author eonezhang (eonezhang@gmail.com)
 * @since 2020/8/15-8:40 PM
 */
public class Armeria01Main {
    public static void main(String[] args) {
        ServerBuilder sb = Server.builder();
        sb.http(8080)
          .disableServerHeader()
          .disableDateHeader();

        sb.annotatedService()
          .pathPrefix("/users")
          .requestTimeout(Duration.ofSeconds(15))
          .maxRequestLength(1024 * 1024 * 10)
          .exceptionHandlers(new ExceptionHandlerFunction() {
              @Override
              public HttpResponse handleException(ServiceRequestContext ctx, HttpRequest req, Throwable cause) {
                  return null;
              }
          })
          .build(new UserService());

        FileServiceBuilder fsb = FileService.builder(ClassLoader.getSystemClassLoader(), "/pages");
        fsb.serveCompressedFiles(true);

        sb.serviceUnder("/pages", fsb.build());

        Server server = sb.build();
        server.start().join();
    }
}

class UserService {
    @Post("/login")
//    @AdditionalTrailer(name = "custom-trailer", value = "custom-overwritten")
    public HttpResponse login(QueryParams params) {
        String username = params.get("username");
        String password = params.get("password");
        return HttpResponse.of(HttpStatus.OK, MediaType.ANY_TEXT_TYPE, "success");
    }

    @Get("/login")
    public HttpResponse loginPage(HttpRequest req) {
        return HttpResponse.of("OK");
    }
}
