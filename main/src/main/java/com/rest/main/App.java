package com.rest.main;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * 描述 ：
 *
 * @author : maozebing
 * @version : v1.00
 * @CreationDate : 2016/12/28 20:03
 * @Description :
 * @update : 修改人，修改时间，修改内容
 * @see :[相关类/方法]
 */
public class App {
    public static void main(String[] args) {
        try{
            //启动restful服务
            Server restServer = new Server(8100);
            ServletContextHandler restHandler = new ServletContextHandler();
            restServer.setHandler(restHandler);
            ResourceConfig resourceConfig = new PackagesResourceConfig("com.rest.api");
            resourceConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, true);
            /*resourceConfig.getProperties().put(
                    "com.sun.jersey.spi.container.ContainerResponseFilters",
                    "gsunis.monitor.utility.CrossDomainFilter"
            );*/
            ServletHolder sh = new ServletHolder(new ServletContainer(resourceConfig));
            restHandler.addServlet(sh, "/api/v1.0/*");

            HandlerList handlers = new HandlerList();
            handlers.setHandlers(new Handler[]{restHandler});
            restServer.setHandler(handlers);

            //启动restful服务
            restServer.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
