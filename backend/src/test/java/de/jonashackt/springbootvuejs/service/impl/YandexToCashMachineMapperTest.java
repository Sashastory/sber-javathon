package de.jonashackt.springbootvuejs.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class YandexToCashMachineMapperTest {

    @Autowired
    private YandexToCashMachineMapper machineMapper;

    @Test
    public void map() {
        machineMapper.map("{\n" +
                "  \"type\": \"FeatureCollection\",\n" +
                "  \"features\": [\n" +
                "    {\n" +
                "      \"type\": \"Feature\",\n" +
                "      \"properties\": {\n" +
                "        \"id\": \"1\",\n" +
                "        \"CompanyMetaData\": {\n" +
                "          \"id\": \"1044581598\",\n" +
                "          \"name\": \"Сбербанк России, банкомат\",\n" +
                "          \"shortName\": \"Сбербанк\",\n" +
                "          \"address\": \"Красная площадь, 3\",\n" +
                "          \"postalCode\": \"109012\",\n" +
                "          \"url\": \"http://www.sberbank.ru/\",\n" +
                "          \"Categories\": [\n" +
                "            {\n" +
                "              \"class\": \"atm\",\n" +
                "              \"name\": \"Банкомат\",\n" +
                "              \"Tags\": {\n" +
                "                \"tag\": \"plural_name:Банкоматы\"\n" +
                "              }\n" +
                "            }\n" +
                "          ],\n" +
                "          \"Phones\": [\n" +
                "            {\n" +
                "              \"type\": \"phone\",\n" +
                "              \"formatted\": \"8 (800) 555-55-50\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"phone\",\n" +
                "              \"formatted\": \"+7 (495) 555-55-50\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"phone\",\n" +
                "              \"formatted\": \"+7 (495) 500-55-50\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"Hours\": {\n" +
                "            \"Availabilities\": [\n" +
                "              {\n" +
                "                \"Everyday\": true,\n" +
                "                \"Intervals\": [\n" +
                "                  {\n" +
                "                    \"from\": \"10:00:00\",\n" +
                "                    \"to\": \"22:00:00\"\n" +
                "                  }\n" +
                "                ]\n" +
                "              }\n" +
                "            ],\n" +
                "            \"text\": \"ежедневно, 10:00–22:00\",\n" +
                "            \"tzOffset\": 10800,\n" +
                "            \"State\": {\n" +
                "              \"is_open_now\": \"0\",\n" +
                "              \"text\": \"Закрыто до 10:00\",\n" +
                "              \"short_text\": \"Закрыто до 10:00\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"Features\": [\n" +
                "            {\n" +
                "              \"id\": \"cash_to_card\",\n" +
                "              \"type\": \"bool\",\n" +
                "              \"name\": \"внесение наличных\",\n" +
                "              \"value\": false\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"location_opening_hours\",\n" +
                "              \"type\": \"bool\",\n" +
                "              \"name\": \"в режиме работы места установки\",\n" +
                "              \"value\": true\n" +
                "            }\n" +
                "          ],\n" +
                "          \"Snippet\": {\n" +
                "            \"FeatureSet\": [\n" +
                "              \"cash_to_card\"\n" +
                "            ]\n" +
                "          }\n" +
                "        },\n" +
                "        \"description\": \"Красная площадь, 3\",\n" +
                "        \"name\": \"Сбербанк России, банкомат\"\n" +
                "      },\n" +
                "      \"geometry\": {\n" +
                "        \"type\": \"Point\",\n" +
                "        \"coordinates\": [\n" +
                "          37.621544,\n" +
                "          55.754673\n" +
                "        ]\n" +
                "      },\n" +
                "      \"geometries\": [\n" +
                "        {\n" +
                "          \"type\": \"Point\",\n" +
                "          \"coordinates\": [\n" +
                "            37.621544,\n" +
                "            55.754673\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}");
    }
}