package com.xmind;

import org.xmind.core.*;
import org.xmind.core.marker.IMarkerRef;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class XmindRead {
    private static IWorkbookBuilder builder = null;
    private static List<String> list = new ArrayList();

    /**
     * 获取工作簿
     * IWorkbook：表示整个思维导图
     * @param xmindPath:xmind文件路径
     */
    public static IWorkbook getIWorkbook(String xmindPath) throws IOException, CoreException {
        if (builder == null) {
            builder = Core.getWorkbookBuilder();
        }
        return builder.loadFromFile(new File(xmindPath));
    }

    /**
     * 获取根节点
     * @param  iWorkbook:加载的思维导图
     */
    public static ITopic getRootTopic(IWorkbook iWorkbook){
        ITopic topics = iWorkbook.getPrimarySheet().getRootTopic();
        System.out.println(topics.getHyperlink());
        Set<IMarkerRef> markers = topics.getMarkerRefs();
        for(IMarkerRef market:markers){
            //System.out.println(market.getMarker());
            System.out.println(market.getMarkerId());
        }
        return topics;
    }

    /**
     * 获取从根目录到每一个叶子节点的的路径
     */
    public static List<String> getAllPath(ITopic rootTopic){
        return getAllPathIter(rootTopic.getTitleText(),rootTopic.getAllChildren());
    }

    public static List<String> getAllPathIter(String parentContext,List<ITopic> childrens){
        for(ITopic children:childrens){
            if(children.getAllChildren().size() == 0){
                list.add(parentContext+" —— "+children.getTitleText());
            }else {
                getAllPathIter(parentContext+" —— "+children.getTitleText(), children.getAllChildren());
            }
        }
        return list;
    }

    /**
     * 解析Xmind文件
     */
    public static List<String> xmindToList(String xmindPath) throws IOException, CoreException {
        return getAllPath(getRootTopic(getIWorkbook(xmindPath)));
    }


}
