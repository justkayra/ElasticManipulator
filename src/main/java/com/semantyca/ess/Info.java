package com.semantyca.ess;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.File;
import java.io.IOException;

@ShellComponent
public class Info {
    public static final String format = "%-40s%s%n";

    @Autowired
    private Environment env;


    @Autowired
    private ESClientFactory esClientFactory;

    @ShellMethod("Show basic info of the service")
    public String putdata() {
        try {

            XContentBuilder document = XContentFactory.jsonBuilder();
            String id = "4";
            document.startObject();
            document.field("Location", id);
            // document.field("Location", id);
            document.endObject();
            IndexRequest indexRequest = new IndexRequest("store", "location", id)
                    .source(data, XContentType.JSON);
            UpdateRequest updateRequest = new UpdateRequest("store", "location", id);
            updateRequest.doc(data, XContentType.JSON);
            updateRequest.upsert(indexRequest);
            esClientFactory.get().update(updateRequest);

        } catch (ElasticsearchException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "done";
    }

    @ShellMethod("Show basic info of the service")
    public String info() {
        Class<?> envConstClass;

        System.out.printf(format, "os",
                System.getProperty("os.version") + "(" + System.getProperty("os.arch") + ")");
        System.out.printf(format, "jvm", System.getProperty("java.version"));
        System.out.printf(format, "work directory", new File("").getAbsolutePath());
        String defaultLang = "";

        System.out.printf(format, "default language", defaultLang);
        File file = new File(File.separator);
        long totalSpace = file.getTotalSpace();
        long freeSpace = file.getFreeSpace();
        System.out.printf(format, "total disk size", totalSpace / 1024 / 1024 / 1024 + " gb");
        System.out.printf(format, "space free", freeSpace / 1024 / 1024 / 1024 + " gb");

        return "done";
    }

    static String  data = "{\n" +
            "      \"Location\": {\n" +
            "        \"storeNumber\": 4,\n" +
            "        \"Address\": {\n" +
            "          \"town\": \"Nottingham\",\n" +
            "          \"street\": \"71 Bracebridge Drive\",\n" +
            "          \"countryCode\": \"GB\",\n" +
            "          \"locality\": \"Bilborough\",\n" +
            "          \"county\": \"Nottinghamshire\",\n" +
            "          \"postcode\": \"NG8 4PH\",\n" +
            "          \"gridLocation\": {\n" +
            "            \"type\" : \"geo_point\", \n" +
            "            \"latitude\": 52.964938911,\n" +
            "            \"propertyEasting\": \"452009\",\n" +
            "            \"propertyNorthing\": \"341120\",\n" +
            "            \"longitude\": -1.227128667\n" +
            "          }\n" +
            "        },\n" +
            "        \"vanRoutes\": {\n" +
            "          \"vanRoute\": {\n" +
            "            \"code\": \"551\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"origin\": \"BTC\",\n" +
            "        \"NDSASQM\": 74,\n" +
            "        \"type\": \"Chemist (HS)\",\n" +
            "        \"deliveryChain\": \"Boots\",\n" +
            "        \"example\": \"LP\",\n" +
            "        \"isFranchise\": \"N\",\n" +
            "        \"nhsMarket\": \"England\",\n" +
            "        \"operationalHours\": [\n" +
            "          {\n" +
            "            \"special\": \"N\",\n" +
            "            \"closeTime\": \"19:00\",\n" +
            "            \"closed\": \"N\",\n" +
            "            \"type\": \"Main\",\n" +
            "            \"openTime\": \"08:00\",\n" +
            "            \"day\": \"Monday\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"special\": \"N\",\n" +
            "            \"closeTime\": \"19:00\",\n" +
            "            \"closed\": \"N\",\n" +
            "            \"type\": \"Main\",\n" +
            "            \"openTime\": \"08:00\",\n" +
            "            \"day\": \"Monday\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"currency\": {\n" +
            "          \"code\": \"GBP\"\n" +
            "        },\n" +
            "        \"id\": 4,\n" +
            "        \"priceBand\": {\n" +
            "          \"code\": \"NUK\",\n" +
            "          \"text\": \"National UK\"\n" +
            "        },\n" +
            "        \"isStore\": \"Y\",\n" +
            "        \"manager\": {\n" +
            "          \"name\": \"lisa stevenson\",\n" +
            "          \"email\": \"lisa.stevenson@boots.com\"\n" +
            "        },\n" +
            "        \"hierarchy\": {\n" +
            "          \"areaID\": 98,\n" +
            "          \"regionID\": 98,\n" +
            "          \"areaName\": \"Unassigned\",\n" +
            "          \"regionName\": \"Unassigned\",\n" +
            "          \"divisionName\": \"Unassigned\",\n" +
            "          \"divisionID\": 98\n" +
            "        },\n" +
            "        \"pmaClassification\": {\n" +
            "          \"code\": \"H\",\n" +
            "          \"text\": \"Smaller Retail Towns\"\n" +
            "        },\n" +
            "        \"costCentre\": {\n" +
            "          \"code\": \"0004\"\n" +
            "        },\n" +
            "        \"contactDetails\": {\n" +
            "          \"phone\": 1159292316\n" +
            "        },\n" +
            "        \"closeDate\": \"2010-10-30\",\n" +
            "        \"Services\": [\n" +
            "          {\n" +
            "            \"active\": \"N\",\n" +
            "            \"text\": \"Boots Opticians Services (in-store)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"active\": \"N\",\n" +
            "            \"text\": \"Boots Opticians Services (in-store)\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"primaryCareOrganisation\": \"5EM\",\n" +
            "        \"displayname\": \"Nottingham Bilborough\",\n" +
            "        \"name\": \"Nottingham Bilborough\",\n" +
            "        \"subType\": \"BUK\",\n" +
            "        \"isSpecialDummy\": \"N\",\n" +
            "        \"openDate\": \"1971-01-01\",\n" +
            "        \"isMidnightPharmacy\": \"N\",\n" +
            "        \"status\": {\n" +
            "          \"code\": 3,\n" +
            "          \"text\": \"closed\"\n" +
            "        },\n" +
            "        \"isPharmacy\": \"Y\"\n" +
            "      }\n" +
            "    }\n" +
            "\n{\n" +
            "      \"Location\": {\n" +
            "        \"storeNumber\": 4,\n" +
            "        \"Address\": {\n" +
            "          \"town\": \"Nottingham\",\n" +
            "          \"street\": \"71 Bracebridge Drive\",\n" +
            "          \"countryCode\": \"GB\",\n" +
            "          \"locality\": \"Bilborough\",\n" +
            "          \"county\": \"Nottinghamshire\",\n" +
            "          \"postcode\": \"NG8 4PH\",\n" +
            "          \"gridLocation\": {\n" +
            "            \"latitude\": 52.964938911,\n" +
            "            \"propertyEasting\": \"452009\",\n" +
            "            \"propertyNorthing\": \"341120\",\n" +
            "            \"longitude\": -1.227128667\n" +
            "          }\n" +
            "        },\n" +
            "        \"vanRoutes\": {\n" +
            "          \"vanRoute\": {\n" +
            "            \"code\": \"551\"\n" +
            "          }\n" +
            "        },\n" +
            "        \"origin\": \"BTC\",\n" +
            "        \"NDSASQM\": 74,\n" +
            "        \"type\": \"Chemist (HS)\",\n" +
            "        \"deliveryChain\": \"Boots\",\n" +
            "        \"example\": \"LP\",\n" +
            "        \"isFranchise\": \"N\",\n" +
            "        \"nhsMarket\": \"England\",\n" +
            "        \"operationalHours\": [\n" +
            "          {\n" +
            "            \"special\": \"N\",\n" +
            "            \"closeTime\": \"19:00\",\n" +
            "            \"closed\": \"N\",\n" +
            "            \"type\": \"Main\",\n" +
            "            \"openTime\": \"08:00\",\n" +
            "            \"day\": \"Monday\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"special\": \"N\",\n" +
            "            \"closeTime\": \"19:00\",\n" +
            "            \"closed\": \"N\",\n" +
            "            \"type\": \"Main\",\n" +
            "            \"openTime\": \"08:00\",\n" +
            "            \"day\": \"Monday\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"currency\": {\n" +
            "          \"code\": \"GBP\"\n" +
            "        },\n" +
            "        \"id\": 4,\n" +
            "        \"priceBand\": {\n" +
            "          \"code\": \"NUK\",\n" +
            "          \"text\": \"National UK\"\n" +
            "        },\n" +
            "        \"isStore\": \"Y\",\n" +
            "        \"manager\": {\n" +
            "          \"name\": \"lisa stevenson\",\n" +
            "          \"email\": \"lisa.stevenson@boots.com\"\n" +
            "        },\n" +
            "        \"hierarchy\": {\n" +
            "          \"areaID\": 98,\n" +
            "          \"regionID\": 98,\n" +
            "          \"areaName\": \"Unassigned\",\n" +
            "          \"regionName\": \"Unassigned\",\n" +
            "          \"divisionName\": \"Unassigned\",\n" +
            "          \"divisionID\": 98\n" +
            "        },\n" +
            "        \"pmaClassification\": {\n" +
            "          \"code\": \"H\",\n" +
            "          \"text\": \"Smaller Retail Towns\"\n" +
            "        },\n" +
            "        \"costCentre\": {\n" +
            "          \"code\": \"0004\"\n" +
            "        },\n" +
            "        \"contactDetails\": {\n" +
            "          \"phone\": 1159292316\n" +
            "        },\n" +
            "        \"closeDate\": \"2010-10-30\",\n" +
            "        \"Services\": [\n" +
            "          {\n" +
            "            \"active\": \"N\",\n" +
            "            \"text\": \"Boots Opticians Services (in-store)\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"active\": \"N\",\n" +
            "            \"text\": \"Boots Opticians Services (in-store)\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"primaryCareOrganisation\": \"5EM\",\n" +
            "        \"displayname\": \"Nottingham Bilborough\",\n" +
            "        \"name\": \"Nottingham Bilborough\",\n" +
            "        \"subType\": \"BUK\",\n" +
            "        \"isSpecialDummy\": \"N\",\n" +
            "        \"openDate\": \"1971-01-01\",\n" +
            "        \"isMidnightPharmacy\": \"N\",\n" +
            "        \"status\": {\n" +
            "          \"code\": 3,\n" +
            "          \"text\": \"closed\"\n" +
            "        },\n" +
            "        \"isPharmacy\": \"Y\"\n" +
            "      }\n" +
            "    }\n" +
            "\n";

}



