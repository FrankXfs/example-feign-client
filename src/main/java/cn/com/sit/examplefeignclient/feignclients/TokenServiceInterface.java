package cn.com.sit.examplefeignclient.feignclients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

//@FeignClient(name = "token-service")
@FeignClient(value = "token-service",
                url = "http://localhost:9098")
@RequestMapping(value = "/token-service")
public interface TokenServiceInterface {

    @RequestMapping(value = "/session", method = RequestMethod.POST)
    String getSessionString(@RequestBody Map<String,String> login);

}
