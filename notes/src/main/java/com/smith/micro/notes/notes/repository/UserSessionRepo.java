package com.smith.micro.notes.notes.repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smith.micro.notes.notes.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@Slf4j
public class UserSessionRepo {

    private final RedisTemplate<String, String> template;

    private final String USER_SESSION_KEY = "USER";

    public UserSessionRepo(RedisTemplate<String, String> template){
        this.template = template;
    }

    /**
     * This method will fetch user for given token
     * @param key
     * @return
     */
    public User getRedisData(String key) {
        String jsonUser = (String) template.opsForHash().entries(USER_SESSION_KEY).get(key);
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            User user = objectMapper.readValue(jsonUser, User.class);
            return user;
        } catch(Exception ex){
            log.error("User not found for given token : {}", key);
        }
        return null;
    }

    /**
     * This method will insert user into Redis
     * @param key
     * @param user
     */
    public void putRedisData(String key, User user){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String userJson = objectMapper.writeValueAsString(user);
            template.opsForHash().put( USER_SESSION_KEY, key, userJson);
        }  catch (JsonParseException ex){
            log.error("Json parsing exception for User : {}", user);
        }
        catch (JsonProcessingException ex) {
            log.error("Json processing exception for user : {} ", user);
        }
}






    }
