package codingforlove.community.Cache;

import cn.hutool.core.util.StrUtil;
import codingforlove.community.DTO.TagDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TagCache {
    public static List<TagDTO> get(){
        List<TagDTO> tagDTOs = new ArrayList<>();
        TagDTO program = new TagDTO();
        program.setCategoryName("开发语言");
        program.setTags(Arrays.asList("js", "php", "css", "html", "java", "python", "node", "c", "c++", "c#", ".net"));
        TagDTO framework = new TagDTO();
        framework.setCategoryName("平台框架");
        framework.setTags(Arrays.asList("spring", "django", "koa"));
        TagDTO server = new TagDTO();
        server.setCategoryName("服务器");
        server.setTags(Arrays.asList("linux", "nginx", "docker", "apache", "ubuntu", "centos"));
        TagDTO dataBase = new TagDTO();
        dataBase.setCategoryName("数据库");
        dataBase.setTags(Arrays.asList("mysql", "redis", "mangodb", "sql", "nosql", "oracle"));
        TagDTO tool = new TagDTO();
        tool.setCategoryName("开发工具");
        tool.setTags(Arrays.asList("git", "github", "vscode", "idea", "maven", "svn"));
        tagDTOs.add(program);
        tagDTOs.add(framework);
        tagDTOs.add(server);
        tagDTOs.add(dataBase);
        return tagDTOs;
    }
    public static String filterInValid(String tags){
        List<String> split = StrUtil.split(tags, '，');
        List<TagDTO> tagDTOs = get();
        List<String> tagList = tagDTOs.stream().flatMap(tag -> tag.getTags().stream()).collect(Collectors.toList());
        String invalid = split.stream().filter(t -> !tagList.contains(t)).collect(Collectors.joining("，"));
        return invalid;
    }
}
