package com.dsource.idc.jellowintl;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class TextFactory {

    static JSONObject JSON = null;

    /**
     *
     * @param file - the JSON file location
     * @param iconNames - iconNames without extension
     * @return
     */

    public static Icon[] getIconObjects(@NonNull File file,@NonNull String[] iconNames) {
        if (JSON == null) {
            try {
                JSON = new JSONObject(getStringFromFile(file));
            } catch (Exception e) {
                Log.d("JSON", e.getMessage());
            }
        }

        ArrayList<Icon> iconObjects = new ArrayList<>();

        for (String iconName : iconNames) {
            try {
                String jsonString = JSON.getJSONObject(iconName).toString();
                Gson gson = new Gson();
                Icon icon = gson.fromJson(jsonString, Icon.class);
                iconObjects.add(icon);
            } catch (Exception e) {
                Log.d("JSON", e.getMessage());
            }
        }

        Icon[] generalIconObjects = new Icon[iconObjects.size()];

        iconObjects.toArray(generalIconObjects);

        return generalIconObjects;
    }


    public static ExpressiveIcon[] getExpressiveIconObjects(@NonNull File file,@NonNull String[] iconNames) {
        if (JSON == null) {
            try {
                JSON = new JSONObject(getStringFromFile(file));
            } catch (Exception e) {
                Log.d("JSON", e.getMessage());
            }
        }

        ArrayList<ExpressiveIcon> iconObjects = new ArrayList<>();

        for (String iconName : iconNames) {
            try {
                String jsonString = JSON.getJSONObject(iconName).toString();
                Gson gson = new Gson();
                ExpressiveIcon icon = gson.fromJson(jsonString, ExpressiveIcon.class);
                iconObjects.add(icon);
            } catch (Exception e) {
                Log.d("JSON", e.getMessage());
            }
        }

        ExpressiveIcon[] expressiveIconsObjects = new ExpressiveIcon[iconObjects.size()];

        iconObjects.toArray(expressiveIconsObjects);

        return expressiveIconsObjects;
    }

    public static MiscellaneousIcon[] getMiscellaneousIconObjects(@NonNull File file,@NonNull String[] iconNames) {
        if (JSON == null) {
            try {
                JSON = new JSONObject(getStringFromFile(file));
            } catch (Exception e) {
                Log.d("JSON", e.getMessage());
            }
        }

        ArrayList<MiscellaneousIcon> iconObjects = new ArrayList<>();

        for (String iconName : iconNames) {
            try {
                String jsonString = JSON.getJSONObject(iconName).toString();
                Gson gson = new Gson();
                MiscellaneousIcon icon = gson.fromJson(jsonString, MiscellaneousIcon.class);
                iconObjects.add(icon);
            } catch (Exception e) {
                Log.d("JSON", e.getMessage());
            }
        }

        MiscellaneousIcon[] miscellaneousIconsObjects = new MiscellaneousIcon[iconObjects.size()];

        iconObjects.toArray(miscellaneousIconsObjects);

        return miscellaneousIconsObjects;
    }


    private static String getStringFromFile(@NonNull File file) {

        StringBuilder text = new StringBuilder();
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return text.toString();

    }

    public static String[] getDisplayText(Icon[] iconObjects){

        ArrayList<String> displayText = new ArrayList<>();
        for(Icon icon : iconObjects){
            displayText.add(icon.Display_Label);
        }

        String[] displayTextArray = new String[displayText.size()];

        return displayText.toArray(displayTextArray);
    }

    public static String[] getTitle(MiscellaneousIcon[] iconObjects){

        ArrayList<String> title = new ArrayList<>();
        for(MiscellaneousIcon icon : iconObjects){
            title.add(icon.Title);
        }

        String[] titleArray = new String[title.size()];

        return title.toArray(titleArray);
    }

    public static String[] getExpressiveSpeechText(ExpressiveIcon[] iconObjects){

        ArrayList<String> title = new ArrayList<>();
        for(ExpressiveIcon icon : iconObjects){
            title.add(icon.L);
            title.add(icon.LL);
        }

        String[] titleArray = new String[title.size()];

        return title.toArray(titleArray);
    }


    public static String[] getSpeechText(Icon[] iconObjects){

        ArrayList<String> speechText = new ArrayList<>();
        for(Icon icon : iconObjects){
            speechText.add(icon.Speech_Label);
        }

        String[] speechTextArray = new String[speechText.size()];

        return speechText.toArray(speechTextArray);
    }

}
