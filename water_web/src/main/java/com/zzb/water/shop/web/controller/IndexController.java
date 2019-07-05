package com.zzb.water.shop.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.zzb.water.shop.common.utils.IdUtils;
import com.zzb.water.shop.domain.Item;
import com.zzb.water.shop.domain.User;
import com.zzb.water.shop.repository.ItemRepository;
import com.zzb.water.shop.service.ItemService;
import com.zzb.water.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Author by 张志斌 .
 * @Date 16:35 2019/7/1
 */
@Controller
@RequestMapping("/v1/web")
public class IndexController {
    @Reference(version = "${demo.service.version}")
    private UserService userService;
    @Reference(version = "${demo.service.version}")
    private ItemService itemService;

    @RequestMapping("/test")
    public Object test(){
        User user = new User();
        List<User> user1 = userService.findUser(user);
        return "default.html";
    }

    @GetMapping("/test/es/put")
    @ResponseBody
    public Object testEs(){
        Item item = new Item();
        item.setId(IdUtils.getId());
        item.setTitle("我只是个测试用的物品啊，请你放过我");
        item.setCreatetime(new Date());
        item.setDescription("我只是个描述啊");
        item.setImageUrl("https://img.alicdn.com/tfs/TB1pwi9EwHqK1RjSZJnXXbNLpXa-479-59.png");
        item.setSummary("全剧终");
        return itemService.save(item);
    }
    @GetMapping("/test/es/find")
    @ResponseBody
    public Object findEs(String title){
        return itemService.findByTitle(title);
    }
}
