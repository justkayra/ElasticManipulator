package com.semantyca.ess;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@ShellComponent
public class ShellCommandHandler {
    private static final String TEXT_FORMAT = "%-40s%s%n";

    @Autowired
    private Environment env;


    @Autowired
    private ESClientFactory esClientFactory;

    private static final Logger LOG = LoggerFactory.getLogger(ShellCommandHandler.class);

    @ShellMethod("put a data into ES")
    public String putdata() {
        try {
            String data = new String(Files.readAllBytes(Paths.get("/home/aida/tmp/json/store.json")));
            XContentBuilder document = XContentFactory.jsonBuilder();
            String id = "4";
            document.startObject();
            document.field("Location", id);
            document.endObject();
            IndexRequest indexRequest = new IndexRequest("store", "location", id)
                    .source(data, XContentType.JSON);
            UpdateRequest updateRequest = new UpdateRequest("store", "location", id);
            updateRequest.doc(data, XContentType.JSON);
            updateRequest.upsert(indexRequest);
            esClientFactory.get().update(updateRequest, RequestOptions.DEFAULT);

        } catch (ElasticsearchException | IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return "done";
    }

    @ShellMethod("Show basic info of the service")
    public String info() {
        LOG.info(TEXT_FORMAT, "os",
                System.getProperty("os.version") + "(" + System.getProperty("os.arch") + ")");
        LOG.info(TEXT_FORMAT, "jvm", System.getProperty("java.version"));
        LOG.info(TEXT_FORMAT, "work directory", new File("").getAbsolutePath());
        String defaultLang = "";

        LOG.info(TEXT_FORMAT, "default language", defaultLang);
        File file = new File(File.separator);
        LOG.info(TEXT_FORMAT, "total disk size", file.getTotalSpace() / 1024 / 1024 / 1024 + " gb");
        LOG.info(TEXT_FORMAT, "space free", file.getFreeSpace() / 1024 / 1024 / 1024 + " gb");

        return "done";
    }



}



