package cn.com.sit.examplefeignclient.feignclients;


import com.netflix.ribbon.proxy.annotation.Http;
import feign.Headers;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.Map;

@FeignClient(value ="example-service",url = "http://localhost:9098")
@RequestMapping(value = "/example-service")
public interface MenuServieInterface {

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    String getMenu(@RequestHeader("Authorization") String Authorization);

}
