package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import testPrisacaBarnova.BaseTestsPB;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class DataUtilsDataProvider extends BaseTestsPB {

    @DataProvider
    public Object[] dataProvider1(){
        JSONParser parser = new JSONParser(); //create a parser to parse the data from testData.json file
        JSONObject jsonObject; //we need a Json Object to store the Parse data

        //than we go to read the Json File
        Object obj = null;//create a JAVA object; set it null first and use the java object to store the parsed data
        try {
            //read the data from the json file(testData.json) and store in this JAVA object (Object obj) Object is used for Java Objects
            obj = parser.parse(new FileReader("src/main/resources/testData2.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        jsonObject = (JSONObject) obj; //create a JSON object; to read the data from the .json file and store it to a Json Object(JSONObject) obj

        //Extract Array data from  the (JsonObject)obj - testData2.json is a Json Object but this object contains an Array(the data inside testData2.json)
        //In our case testData2.json: Json Object - contains an Array - made by 2 Elements, each separate by {} but inside []
        assert jsonObject!=null;//make sure that the json object is not null

        //Create a Json Array to be able to work with the array; get the Elements in array by name , Example:
        // { "auth info": [ {"key":"value"} ] }
        //We work with Arrays so first set cast(.get) data from Json Object to Json Array (formInfo)
        JSONArray formInfo = (JSONArray) jsonObject.get("auth info");//cast Json Object into Json Array type

        //Our Test cannot work with a Json Array so we need to create a Java String Array

        // ******JAVA String Array(Java type) ****** to store JSONArray data(formInfo); the size of the JavaArray is being set the same as the JsonArray
        String[] dataArray = new String[formInfo.size()];//whatever the size of the array, that is the size of this array here "dataArray"

        //Create a new Json Object (formInfoData) to read each set of data inside JSONArray object
        JSONObject formInfoData;
        String userField, passwordField, rememberMeCheckbox ;//Create Strings to store the array info in strings
        //This strings are going to go to the String Array from up (String[] dataArray)

        //In the for loop we gonna retrieve the data from the Json Array and store it into the String Array(JAVA)
        //Get data from JSONArray and store in String array
        for(int i=0;i< formInfo.size(); i++){
            formInfoData = (JSONObject) formInfo.get(i);//get the -Json Data (formInfo.get(i))- from the JSON Array
            //once we got that info there we gonna go item by item and put that into the strings
            userField = (String) formInfoData.get("UserField");//grab the info located at UserField and send it to userField
            passwordField = (String) formInfoData.get("PasswordField");
            rememberMeCheckbox = (String) formInfoData.get("RememberMeCheckbox");
            //got to the first item in the string Array and store all the info and separate it by comma, so the first time the loop runs, grabs all the items inside
            //each data and put them into the strings that we created up: String userField, passwordField, rememberMeCheckbox separated by comma and then store
            //the information in the Array - up: "String[] dataArray = new String[formInfo.size()]" ; so the first item in the array will contain the info
            //from the first set between curls {} - first set of data; when the loop runs second time it will get the second set of data and set the data into
            //the second item of the Array "String[] dataArray = new String[formInfo.size()]" array wich will have 2 elements {} {}
            dataArray[i] = userField+ "," + passwordField + "," + rememberMeCheckbox;
        }
        //return this Array "String[] dataArray = new String[formInfo.size()]"  to be used by our test
        return dataArray;
    }

    @DataProvider
    public Object[] dataProvider2() {

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        //read json file
        try {
            Object obj = parser.parse(new FileReader("src/main/resources/testData.json"));
            jsonObject = (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        //create an array to store Json data
        Object[] data = new Object[1];

        //Store Json data as key/value pairs in a hashmap
        HashMap<String, String> hashMap = new LinkedHashMap<>();
        if (jsonObject != null) {
            Set<String> jsonObjKeys = jsonObject.keySet();
            for (String jsonObjKey : jsonObjKeys) {
                hashMap.put(jsonObjKey, (String) jsonObject.get(jsonObjKey));
            }
        } else {
            log.error("Error retrieving JSON data");
            throw new RuntimeException();
        }
        //Store the HashMap in an array and return array
        data[0] = hashMap;
        return data;
    }


}