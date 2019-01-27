package ru.javathon.springbootvuejs.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class GeoJsonToAtmMapperTest {

    @Autowired
    private GeoJsonToAtmMapper machineMapper;

    @Test
    public void map() {
        machineMapper.map("{\n" +
                "  \"type\": \"FeatureCollection\",\n" +
                "  \"properties\": {\n" +
                "    \"Attribution\": {\n" +
                "      \"Sources\": {\n" +
                "        \"facebook\": {\n" +
                "          \"id\": \"facebook\",\n" +
                "          \"author\": {\n" +
                "            \"name\": \"Facebook\",\n" +
                "            \"uri\": \"http:\\/\\/facebook.com\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"ok\": {\n" +
                "          \"id\": \"ok\",\n" +
                "          \"author\": {\n" +
                "            \"name\": \"Одноклассники\",\n" +
                "            \"uri\": \"http:\\/\\/ok.ru\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"twitter\": {\n" +
                "          \"id\": \"twitter\",\n" +
                "          \"author\": {\n" +
                "            \"name\": \"Twitter\",\n" +
                "            \"uri\": \"http:\\/\\/twitter.com\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"sberbank-bankomat\": {\n" +
                "          \"id\": \"sberbank-bankomat\",\n" +
                "          \"author\": {\n" +
                "            \"name\": \"Сбербанк России\",\n" +
                "            \"uri\": \"http:\\/\\/www.sberbank.ru\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"vkontakte\": {\n" +
                "          \"id\": \"vkontakte\",\n" +
                "          \"author\": {\n" +
                "            \"name\": \"ВКонтакте\",\n" +
                "            \"uri\": \"http:\\/\\/vk.com\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"yandex\": {\n" +
                "          \"id\": \"yandex\",\n" +
                "          \"author\": {\n" +
                "            \"name\": \"Яндекс\",\n" +
                "            \"uri\": \"https:\\/\\/www.yandex.ru\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"aqua_sbkz_atm\": {\n" +
                "          \"id\": \"aqua_sbkz_atm\",\n" +
                "          \"author\": {\n" +
                "            \"name\": \"sberbank.kz\",\n" +
                "            \"uri\": \"http:\\/\\/www.sberbank.kz\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"youtube\": {\n" +
                "          \"id\": \"youtube\",\n" +
                "          \"author\": {\n" +
                "            \"name\": \"YouTube\",\n" +
                "            \"uri\": \"http:\\/\\/youtube.com\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"instagram\": {\n" +
                "          \"id\": \"instagram\",\n" +
                "          \"author\": {\n" +
                "            \"name\": \"Instagram\",\n" +
                "            \"uri\": \"http:\\/\\/instagram.com\"\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    \"ResponseMetaData\": {\n" +
                "      \"SearchRequest\": {\n" +
                "        \"request\": \"банкоматы Сбербанк\",\n" +
                "        \"results\": 2,\n" +
                "        \"skip\": 0,\n" +
                "        \"boundedBy\": [\n" +
                "          [\n" +
                "            37.048426749999997,\n" +
                "            55.436448290000001\n" +
                "          ],\n" +
                "          [\n" +
                "            38.175902260000001,\n" +
                "            56.046901239999997\n" +
                "          ]\n" +
                "        ]\n" +
                "      },\n" +
                "      \"SearchResponse\": {\n" +
                "        \"found\": 12,\n" +
                "        \"display\": \"multiple\"\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"features\": [\n" +
                "    {\n" +
                "      \"type\": \"Feature\",\n" +
                "      \"properties\": {\n" +
                "        \"id\": \"1\",\n" +
                "        \"CompanyMetaData\": {\n" +
                "          \"id\": \"1044581598\",\n" +
                "          \"name\": \"Сбербанк России, банкомат\",\n" +
                "          \"nameHighlight\": [\n" +
                "            [\n" +
                "              0,\n" +
                "              8\n" +
                "            ],\n" +
                "            [\n" +
                "              17,\n" +
                "              25\n" +
                "            ]\n" +
                "          ],\n" +
                "          \"shortName\": \"Сбербанк\",\n" +
                "          \"address\": \"Красная площадь, 3\",\n" +
                "          \"postalCode\": \"109012\",\n" +
                "          \"url\": \"http:\\/\\/www.sberbank.ru\\/\",\n" +
                "          \"Categories\": [\n" +
                "            {\n" +
                "              \"class\": \"atm\",\n" +
                "              \"name\": \"Банкомат\",\n" +
                "              \"Tags\": {\n" +
                "                \"tag\": \"plural_name:Банкоматы\"\n" +
                "              }\n" +
                "            }\n" +
                "          ],\n" +
                "          \"Chains\": [\n" +
                "            {\n" +
                "              \"id\": \"6003611\",\n" +
                "              \"name\": \"Сбербанк России, банкоматы\",\n" +
                "              \"seoname\": \"sberbank\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"Phones\": [\n" +
                "            {\n" +
                "              \"type\": \"phone\",\n" +
                "              \"formatted\": \"8 (800) 555-55-50\",\n" +
                "              \"country\": \"7\",\n" +
                "              \"prefix\": \"800\",\n" +
                "              \"number\": \"5555550\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"phone\",\n" +
                "              \"formatted\": \"+7 (495) 555-55-50\",\n" +
                "              \"country\": \"7\",\n" +
                "              \"prefix\": \"495\",\n" +
                "              \"number\": \"5555550\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"phone\",\n" +
                "              \"formatted\": \"+7 (495) 500-55-50\",\n" +
                "              \"country\": \"7\",\n" +
                "              \"prefix\": \"495\",\n" +
                "              \"number\": \"5005550\"\n" +
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
                "          \"Geo\": {\n" +
                "            \"precision\": \"exact\"\n" +
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
                "          },\n" +
                "          \"Links\": [\n" +
                "            {\n" +
                "              \"type\": \"social\",\n" +
                "              \"aref\": \"#twitter\",\n" +
                "              \"href\": \"https:\\/\\/twitter.com\\/sberbank\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"social\",\n" +
                "              \"aref\": \"#vkontakte\",\n" +
                "              \"href\": \"https:\\/\\/vk.com\\/sberbank\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"social\",\n" +
                "              \"aref\": \"#facebook\",\n" +
                "              \"href\": \"https:\\/\\/www.facebook.com\\/sberbank\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"social\",\n" +
                "              \"aref\": \"#instagram\",\n" +
                "              \"href\": \"https:\\/\\/www.instagram.com\\/sberbank\\/\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"Properties\": {\n" +
                "            \"Property\": {\n" +
                "              \"key\": \"sensitive\",\n" +
                "              \"value\": \"1\"\n" +
                "            }\n" +
                "          }\n" +
                "        },\n" +
                "        \"References\": {\n" +
                "          \"items\": [\n" +
                "            {\n" +
                "              \"scope\": \"parent_org\",\n" +
                "              \"id\": \"1331623198\"\n" +
                "            }\n" +
                "          ]\n" +
                "        },\n" +
                "        \"description\": \"Красная площадь, 3\",\n" +
                "        \"name\": \"Сбербанк России, банкомат\",\n" +
                "        \"boundedBy\": [\n" +
                "          [\n" +
                "            37.617437610000003,\n" +
                "            55.752358739999998\n" +
                "          ],\n" +
                "          [\n" +
                "            37.625648210000001,\n" +
                "            55.756989019999999\n" +
                "          ]\n" +
                "        ],\n" +
                "        \"attributions\": [\n" +
                "          \"#sberbank-bankomat\",\n" +
                "          \"#yandex\"\n" +
                "        ]\n" +
                "      },\n" +
                "      \"geometry\": {\n" +
                "        \"type\": \"Point\",\n" +
                "        \"coordinates\": [\n" +
                "          37.621544,\n" +
                "          55.754672999999997\n" +
                "        ]\n" +
                "      },\n" +
                "      \"geometries\": [\n" +
                "        {\n" +
                "          \"type\": \"Point\",\n" +
                "          \"coordinates\": [\n" +
                "            37.621544,\n" +
                "            55.754672999999997\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"type\": \"Feature\",\n" +
                "      \"properties\": {\n" +
                "        \"id\": \"2\",\n" +
                "        \"CompanyMetaData\": {\n" +
                "          \"id\": \"1024157025\",\n" +
                "          \"name\": \"Сбербанк России, банкомат\",\n" +
                "          \"nameHighlight\": [\n" +
                "            [\n" +
                "              0,\n" +
                "              8\n" +
                "            ],\n" +
                "            [\n" +
                "              17,\n" +
                "              25\n" +
                "            ]\n" +
                "          ],\n" +
                "          \"shortName\": \"Сбербанк\",\n" +
                "          \"address\": \"ул. 7-я Линия, 23, Видное\",\n" +
                "          \"url\": \"http:\\/\\/www.sberbank.ru\\/\",\n" +
                "          \"Categories\": [\n" +
                "            {\n" +
                "              \"class\": \"atm\",\n" +
                "              \"name\": \"Банкомат\",\n" +
                "              \"Tags\": {\n" +
                "                \"tag\": \"plural_name:Банкоматы\"\n" +
                "              }\n" +
                "            }\n" +
                "          ],\n" +
                "          \"Chains\": [\n" +
                "            {\n" +
                "              \"id\": \"6003611\",\n" +
                "              \"name\": \"Сбербанк России, банкоматы\",\n" +
                "              \"seoname\": \"sberbank\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"Phones\": [\n" +
                "            {\n" +
                "              \"type\": \"phone\",\n" +
                "              \"formatted\": \"8 (800) 555-55-50\",\n" +
                "              \"country\": \"7\",\n" +
                "              \"prefix\": \"800\",\n" +
                "              \"number\": \"5555550\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"Geo\": {\n" +
                "            \"precision\": \"exact\"\n" +
                "          },\n" +
                "          \"Features\": [\n" +
                "            {\n" +
                "              \"id\": \"operations_accounts_cards\",\n" +
                "              \"type\": \"enum\",\n" +
                "              \"name\": \"операции со счетами и картами\",\n" +
                "              \"values\": [\n" +
                "                {\n" +
                "                  \"id\": \"issuance_of_cash\",\n" +
                "                  \"value\": \"выдача наличности\"\n" +
                "                }\n" +
                "              ]\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"cash_to_card\",\n" +
                "              \"type\": \"bool\",\n" +
                "              \"name\": \"внесение наличных\",\n" +
                "              \"value\": true\n" +
                "            },\n" +
                "            {\n" +
                "              \"id\": \"location_opening_hours\",\n" +
                "              \"type\": \"bool\",\n" +
                "              \"name\": \"в режиме работы места установки\",\n" +
                "              \"value\": false\n" +
                "            }\n" +
                "          ],\n" +
                "          \"Snippet\": {\n" +
                "            \"FeatureSet\": [\n" +
                "              \"cash_to_card\"\n" +
                "            ]\n" +
                "          },\n" +
                "          \"Links\": [\n" +
                "            {\n" +
                "              \"type\": \"social\",\n" +
                "              \"aref\": \"#twitter\",\n" +
                "              \"href\": \"https:\\/\\/twitter.com\\/sberbank\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"social\",\n" +
                "              \"aref\": \"#vkontakte\",\n" +
                "              \"href\": \"https:\\/\\/vk.com\\/sberbank\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"social\",\n" +
                "              \"aref\": \"#facebook\",\n" +
                "              \"href\": \"https:\\/\\/www.facebook.com\\/sberbank\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"social\",\n" +
                "              \"aref\": \"#instagram\",\n" +
                "              \"href\": \"https:\\/\\/www.instagram.com\\/sberbank\\/\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"Properties\": {\n" +
                "            \"Property\": {\n" +
                "              \"key\": \"sensitive\",\n" +
                "              \"value\": \"1\"\n" +
                "            }\n" +
                "          }\n" +
                "        },\n" +
                "        \"description\": \"ул. 7-я Линия, 23, Видное\",\n" +
                "        \"name\": \"Сбербанк России, банкомат\",\n" +
                "        \"boundedBy\": [\n" +
                "          [\n" +
                "            37.749328259999999,\n" +
                "            55.547254600000002\n" +
                "          ],\n" +
                "          [\n" +
                "            37.757520900000003,\n" +
                "            55.551909289999998\n" +
                "          ]\n" +
                "        ],\n" +
                "        \"attributions\": [\n" +
                "          \"#sberbank-bankomat\",\n" +
                "          \"#yandex\"\n" +
                "        ]\n" +
                "      },\n" +
                "      \"geometry\": {\n" +
                "        \"type\": \"Point\",\n" +
                "        \"coordinates\": [\n" +
                "          37.753428999999997,\n" +
                "          55.549582999999998\n" +
                "        ]\n" +
                "      },\n" +
                "      \"geometries\": [\n" +
                "        {\n" +
                "          \"type\": \"Point\",\n" +
                "          \"coordinates\": [\n" +
                "            37.753428999999997,\n" +
                "            55.549582999999998\n" +
                "          ]\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}");
    }
}