package de.dimk.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Date;

/**
 * Created by korb009 on 18.05.2017.
 */
public class JsonParsing {

    static String transactionId = "1671586060";
    static String clientId = "98765";
    static String apikey = "0a000045-54cf5d47-6f2a-9be1e61a";
    static String reportType = "revenues";
    static Date transactionDate = new Date();

    //static String rawData = "[{\"cat\":\"Lohn\",\"oamt\":\"\",\"ormr\":\"\",\"blz\":\"59010066\",\"purp\":\"\",\"pnnr\":\"\",\"bschluessl\":\"N053\",\"coam\":\"\",\"txtkeyadd\":\"000\",\"abwe\":\"\",\"bic\":\"\",\"mref\":\"\",\"abwa\":\"\",\"gnam\":\"1-2-3 Gebaeudemanagement GmbH 2017, 22761 Hamburg\",\"orcr\":\"\",\"bankref\":\"\",\"debt\":\"\",\"kref\":\"\",\"cred\":\"\",\"valuta\":\"30.01.2017\",\"kontonummer\":\"932604660\",\"gkto\":\"DE87200505501051211231\",\"mdat\":\"\",\"saldo\":\"\",\"bdatum\":\"30.01.2017\",\"betrag\":\"1091.82\",\"rref\":\"\",\"btxt\":\"GEHALT\\/RENTE\",\"eref\":\"00000491-00000058\",\"referenz\":\"NONREF\",\"bref\":\"\",\"uuid\":\"2\",\"svwz\":\"Lohn\\/Gehalt Monat 1.2017\",\"gblz\":\"HASPDEHHXXX\",\"gvfc\":\"153\",\"iban\":\"\"},{\"cat\":\"Geldautomat \\/ Abhebungen\",\"oamt\":\"\",\"ormr\":\"\",\"blz\":\"59010066\",\"purp\":\"\",\"pnnr\":\"\",\"bschluessl\":\"N037\",\"coam\":\"\",\"txtkeyadd\":\"000\",\"abwe\":\"\",\"bic\":\"\",\"mref\":\"\",\"abwa\":\"\",\"gnam\":\"\",\"orcr\":\"\",\"bankref\":\"\",\"debt\":\"\",\"kref\":\"\",\"cred\":\"\",\"valuta\":\"31.01.2017\",\"kontonummer\":\"932604660\",\"gkto\":\"\",\"mdat\":\"\",\"saldo\":\"\",\"bdatum\":\"31.01.2017\",\"betrag\":\"-300.00\",\"rref\":\"\",\"btxt\":\"AUSZAHLUNG\",\"eref\":\"\",\"referenz\":\"NONREF\",\"bref\":\"\",\"uuid\":\"3\",\"svwz\":\"AUSZAHLUNG 31.01. UM 14:18 KASSENNUMMER 81022355 AUSZAHLUNGSSCHEIN 655\",\"gblz\":\"\",\"gvfc\":\"083\",\"iban\":\"\"}]";
    //static  String rawData = "{\"requestid\":\"1578327804\",\"score\":\"453\",\"iban\":\"DE75860555921802303576\",\"accountOwner\":\"R\\u00fcbnerNicole\",\"numberOfChildren\":1,\"employerName\":\"csy compact systems service\",\"income\":\"989.01\",\"childBenefit\":\"192.00\",\"pension\":\"0.00\",\"rent\":\"490.13\",\"vehicle\":false,\"validation\":true}";
    static String rawData = "hello my name is  Rücklastschrift, äöüß!§$%: \"accountOwner\": \"RübnerNicole\"";

    public static void main(String[] args) {

        Object rawDataObject = rawData;

        int x = 0;

        JSONObject result = new JSONObject();
        JSONObject resultJson = new JSONObject();

        result.put("TransactionId", transactionId);
        result.put("ClientId", clientId);
        result.put("ApiKey", apikey);
        result.put("ReportType", reportType);
       // result.put("TransactionDate", transactionDate);

        try {
            Object parsedJSONObject = (new JSONParser()).parse((String) rawDataObject);
            rawDataObject = parsedJSONObject;
        } catch (ParseException e) {
            // no need to parse, because not valid JSON String is in rawdata
            //e.printStackTrace();
        }

        result.put("RawData", rawDataObject);



        resultJson.put("Result#" + x+1, result);


        System.out.println(resultJson.toJSONString());


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(resultJson.toJSONString());
        String prettyJsonString = gson.toJson(je);


        System.out.println(prettyJsonString);

    }


}
