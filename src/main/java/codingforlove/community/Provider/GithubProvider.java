package codingforlove.community.Provider;

import codingforlove.community.DTO.AccessTokenDTO;
import codingforlove.community.DTO.UserDTO;
import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO), mediaType);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            //System.out.println(string);
            String[] split = string.split("&");
            String tokenstr = split[0];
            String token = tokenstr.split("=")[1];
            return token;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public UserDTO getGithubUser(String accessToken) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .header("Authorization", "token" + " " + accessToken)
                .header("Host", "api.github.com")
                .url("https://api.github.com/user")
                .build();
        try (Response response = client.newCall(request).execute())
        {
            String string = response.toString();
            return JSON.parseObject(string, UserDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
