package tk;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.VerboseProgressCallback;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Test1 {

    @Test
    public void t1() {
        try {
            List<String> warnings = new ArrayList<>();

            File configFile = new File("src/main/resources/generatorConfiguration-tk.xml");

            Properties pros = new Properties();
            pros.setProperty("author", "xiao");


            String projectBase = "../mybatis-example/src/main/java";
            String projectResource = "../mybatis-example/src/main/resources";
            //entity
            pros.setProperty("entity.Package", "vip.corejava.entity");
            pros.setProperty("entity.Project", projectBase);

            //Mapper
            pros.setProperty("mapper.Package", "vip.corejava.mapper");
            pros.setProperty("mapper.Project", projectBase);

            //Mapper.xml
            pros.setProperty("mapperXml.Package", "vip.corejava.mapper");
            pros.setProperty("mapperXml.Project", projectResource);

            //service interface
            pros.setProperty("service.Package", "vip.corejava.service");
            pros.setProperty("service.Project", projectBase);

            //service Implate
            pros.setProperty("serviceImpl.Package", "vip.corejava.service.impl");
            pros.setProperty("serviceImpl.Project", projectBase);

            //controller
            pros.setProperty("controller.Package", "vip.corejava.controller");
            pros.setProperty("controller.Project", projectBase);

            //DB
            pros.setProperty("jdbc.driver", "com.mysql.jdbc.Driver");
            pros.setProperty("jdbc.url", "jdbc:mysql://127.0.0.1:13306/mybatis-showcase?tinyInt1isBit=false");
            pros.setProperty("jdbc.user", "root");
            pros.setProperty("jdbc.password", "toor");

            ConfigurationParser cp = new ConfigurationParser(pros, warnings);
            Configuration config = cp.parseConfiguration(configFile);
            Context context = config.getContext("AceContext");

            //Tables
            TableConfiguration sysUserTable = new TableConfiguration(context);
            sysUserTable.setTableName("user");
            sysUserTable.setDomainObjectName("User");
            sysUserTable.setGeneratedKey(new GeneratedKey("id","JDBC",true,""));
            context.addTableConfiguration(sysUserTable);


            DefaultShellCallback callback = new DefaultShellCallback(true);
            VerboseProgressCallback progressCallback = new VerboseProgressCallback();
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(progressCallback);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
