package ninja.ytb.senpai.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import ninja.ytb.senpai.annotations.SenpaiResource;

@SenpaiResource
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final AtomicLong counter;

    public HelloWorldResource() {
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public String sayHello() {
        return new String("Hello world " + counter.incrementAndGet());
    }
}