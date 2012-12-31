/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.atgas.core.json;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.concurrent.Callable;

import org.atgas.core.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author ken
 */
public class JSONCollector implements Callable<Change>{
    private final JSONTokener tokenizer;

    public JSONCollector(InputStream stream) {
        tokenizer = new JSONTokener(new InputStreamReader(stream));
    }

    @Override
    public Change call() throws Exception {
        JSONObject jsonObject = new JSONObject(tokenizer);
        Change retval = new Change();
        if (jsonObject.has("add")) {
            JSONArray things = jsonObject.getJSONArray("add");

            for (int i = 0; i < things.length(); i++) {
                retval.add(readThing(things.getJSONObject(i)));
            }
        }

        if (jsonObject.has("replace")) {
            JSONArray things = jsonObject.getJSONArray("replaces");

            for (int i = 0; i < things.length(); i++) {
                retval.replace(readThing(things.getJSONObject(i)));
            }
        }

        if (jsonObject.has("remove")) {
            JSONArray things = jsonObject.getJSONArray("remove");

            for (int i = 0; i < things.length(); i++) {
                retval.remove(readThing(things.getJSONObject(i)));
            }
        }

        return retval;
    }

    Thing readThing(JSONObject json) throws JSONException {
        String standard = json.getString("atgas-standard");
        String source = json.getString("atgas-source");
        Thing thing;
        if (json.has("atgas-id")) {
            thing = new Thing(json.getString("atgas-id"), standard, source);
        } else {
            thing = new Thing(standard, source);
        }

        if (json.has("relationships")) {
            JSONArray relationships = json.getJSONArray("relationships");
            for (int i = 0; i < relationships.length(); i++) {
                thing.addRelationship(readRelationship(thing, relationships.getJSONObject(i)));
            }
        }
        json.remove("atgas-id");
        json.remove("atgas-source");
        json.remove("atgas-standard");
        json.remove("relationships");


        for (Iterator<String> it = json.keys(); it.hasNext();) {
            String key = it.next();
            thing.setProperty(key, json.getString(key));
        }

        return thing;
    }

    Relationship readRelationship(Thing origin, JSONObject json) throws JSONException {
        RelationshipType type = new RelationshipType(json.getString("type"));
        String id = json.getString("atgas-id");

        return new ProxyRelationship(type, origin.getID(), id);
    }
}
