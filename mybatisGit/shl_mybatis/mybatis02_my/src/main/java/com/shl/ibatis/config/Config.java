/**
 * @Copyright (C) 2018 苏何丽自创有限公司
 * 本系统是商用软件,未经授权擅自复制或传播本程序的部分或全部将是非法的.
 * @文件名称: Config.java
 * @描述:
 * @创建人:苏何丽
 * @创建时间: 2019/1/5 20:19
 * @版本:
 */

package com.shl.ibatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.swing.tree.VariableHeightLayoutCache;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @类功能说明:
 * @创建人: 苏何丽
 * @创建时间: 2019/1/5 20:19
 */
public class Config {
   private  Map<String, Mapper> map;

    private static Config config;
    private DruidDataSource dataSource;

    private String url;
    private String driver;
    private String username;
    private String password;



    public Config() {
        //创建这个对象时加载配置config上的配置信息
        loadConfig();

    }


    //生成单例config对象
    public static Config getConfig() {
        if (config == null) {
            return new Config();
        }
        return config;
    }

    //获得mapper对象
    public Map<String, Mapper> getMapper() {
        return map;

    }


    //返回获得数据源
    public DruidDataSource getDruidDataSource() {
        return loadDataSource();

    }


    //加载配置config文件
    private void loadConfig() {
        //dom4j方法
        try {
            SAXReader saxReader = new SAXReader();
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("sqlMapConfig.xml");
            Document read = saxReader.read(in);

            //获得根元素
            Element rootElement = read.getRootElement();
            List<Element> list = rootElement.selectNodes("//property");

            //遍历获取值,封住数据源信息
            for (Element ele : list) {
                String name = ele.getName();
                if (name.equals("url")) {
                    String value = ele.attributeValue("url");
                    this.url = value;
                }
                if (name.equals("driver")) {
                    String value = ele.attributeValue("driver");
                    this.driver = value;
                }
                if (name.equals("username")) {
                    String value = ele.attributeValue("username");
                    this.username = value;
                }
                if (name.equals("password")) {
                    String value = ele.attributeValue("password");
                    this.password = value;
                }
            }

            //引入mapper映射文件
            Element mappers = read.getRootElement();
            List<Element> mapper = mappers.selectNodes("//mapper");
            for (Element ele: mapper) {
                String resource = ele.attributeValue("resource");
                loadMapper(resource);

            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }


    //单例加载mapper的配置文件
    private Map<String, Mapper> loadMapper(String resource) {

        try {
            //dom4j
            SAXReader saxReader = new SAXReader();
            InputStream in = this.getClass().getClassLoader().getResourceAsStream(resource);
            Document read = saxReader.read(in);
            Element rootElement = read.getRootElement();
            String namespace = rootElement.attributeValue("namespace");
            List<Element> list = rootElement.selectNodes("//select");

            for (Element ele : list) {
                String id = ele.attributeValue("id");
                String resultType = ele.attributeValue("resultType");
                String queryString = ele.getTextTrim();

                Mapper mapper = new Mapper();
                mapper.setNamespace(namespace);
                mapper.setId(id);
                mapper.setQueryString(queryString);
                mapper.setResultType(resultType);

                String key = namespace + "." + id;

                map.put(key, mapper);
            }
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //单例获得数据源方法
    private DruidDataSource loadDataSource() {
        if (dataSource == null) {
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setDriverClassName(driver);
            dataSource.setPassword(password);
            return dataSource;
        }
        return dataSource;

    }


}