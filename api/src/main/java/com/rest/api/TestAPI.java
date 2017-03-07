package com.rest.api;

import com.google.gson.Gson;
import com.rest.dbentity.TestEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * 描述 ：
 *
 * @author : maozebing
 * @version : v1.00
 * @CreationDate : 2016/12/28 20:02
 * @Description :
 * @update : 修改人，修改时间，修改内容
 * @see :[相关类/方法]
 */
@Path("test")
public class TestAPI {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getTest(){
        TestEntity entity=new TestEntity();
        entity.setId(1);
        entity.setName("11");
        return Response.ok(new Gson().toJson(entity)).build();
    }

}
