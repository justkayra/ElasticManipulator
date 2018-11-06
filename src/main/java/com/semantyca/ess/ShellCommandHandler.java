package com.semantyca.ess;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.semantyca.ess.store.Mapping;
import com.semantyca.ess.store.model.Location;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ShellComponent
public class ShellCommandHandler {
    private static final String TEXT_FORMAT = "%-40s%s%n";

    @Autowired
    private Environment env;

    @Autowired
    private ESClientFactory esClientFactory;

    private static final Logger LOG = LoggerFactory.getLogger(ShellCommandHandler.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    @Value("${xml.file}")
    private String xmlFile;

    @ShellMethod("put Mapping into ES")
    public String mapindex() {
        CreateIndexRequest request = new CreateIndexRequest("store");
        try {
            request.mapping("location", new Mapping().get());
            CreateIndexResponse createIndexResponse = esClientFactory.get().indices().create(request, RequestOptions.DEFAULT);
            return createIndexResponse.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @ShellMethod("put a XML data into ES")
    public String putxml() {
        try {
            XMLReader xmlReader = new XMLReader(xmlFile);
            List<Location> locations = xmlReader.get();
            for(Location location: locations){
                String json = objectMapper.writeValueAsString(location);
                String id = location.getId();
                IndexRequest indexRequest = new IndexRequest("store", "location", id)
                        .source(json, XContentType.JSON);
                UpdateRequest updateRequest = new UpdateRequest("store", "location", id);
                updateRequest.doc(json, XContentType.JSON);
                updateRequest.upsert(indexRequest);
                esClientFactory.get().update(updateRequest, RequestOptions.DEFAULT);
                LOG.info(location.toString());
            }

        } catch (ElasticsearchException | IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return "done";
    }

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

    @ShellMethod("do data request")
    public String getdata() {

        try {
            QueryBuilder qb = QueryBuilders.matchAllQuery();

            String order = "addressLine2", indexName= "gp";
            SearchRequest searchRequest = new SearchRequest(indexName);
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.sort(SortBuilders.fieldSort(order + ".keyword").order(SortOrder.ASC)).query(QueryBuilders.matchAllQuery());
            searchRequest.source(sourceBuilder);
            SearchResponse searchResponse = esClientFactory.get().search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
            List<Map<String, Object>> resultAsListOfMaps = Arrays.stream(hits.getHits()).map(x -> x.getSourceAsMap()).collect(Collectors.toList());
            String result = resultAsListOfMaps.get(0).keySet() + "\n";
            result += "---------------------------------------------";
            for (Map map : resultAsListOfMaps){
                result += map.values() + "\n";
            }
            return result;

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



