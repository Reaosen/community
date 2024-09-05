package codingforlove.community.Provider;

import codingforlove.community.DTO.AccessTokenDTO;
import codingforlove.community.DTO.TokenResponseDTO;
import codingforlove.community.DTO.UserDTO;
import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GiteeProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json");
        OkHttpClient client = new OkHttpClient();


            RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO), mediaType);
            Request request = new Request.Builder()
                    .url("https://gitee.com/oauth/token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
//                System.out.println(string);
                TokenResponseDTO tokenResponseDTO = JSON.parseObject(string, TokenResponseDTO.class);
                String token = tokenResponseDTO.getAccess_token();
//                System.out.println(token);
                return token;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
    }

    public UserDTO getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://gitee.com/api/v5/user?access_token=" + accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            UserDTO userDTO = JSON.parseObject(string, UserDTO.class);
            return userDTO;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
