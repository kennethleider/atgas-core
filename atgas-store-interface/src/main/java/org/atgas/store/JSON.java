/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.atgas.store;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Ken
 */
public class JSON {

    public static String format(Change change) {
        try {
            return convert(change).toString(3);
        } catch (JSONException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static JSONObject convert(Change change) {
        try {
            JSONObject retval = new JSONObject();
            JSONArray adds = new JSONArray();
            retval.put("adds", adds);
            for(Thing thing : change.getAdds()) {
                adds.put(convert(thing));
            }

            JSONArray replaces = new JSONArray();
            retval.put("replaces", replaces);
            for(Thing thing : change.getReplaces()) {
                replaces.put(convert(thing));
            }

            JSONArray removes = new JSONArray();
            retval.put("removes", removes);
            for(Thing thing : change.getRemoves()) {
                removes.put(convert(thing));
            }

            return retval;
        } catch (JSONException e) {

        }

        return null;
    }


    public static JSONObject convert(Thing thing) {
        try {
            JSONObject retval = new JSONObject();
            retval.put("atgas-id", thing.getID());
            retval.put("atgas-standard", thing.getStandardID());
            retval.put("atgas-source", thing.getSourceID());

            for (String key : thing.getProperties()) {
                retval.put(key, thing.get(key));
            }

            JSONArray relationships = new JSONArray();
            retval.put("relationships", relationships);

            for (Relationship relationship : thing.getRelationships()) {
                relationships.put(convert(relationship));
            }
            return retval;
        } catch (JSONException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    public static JSONObject convert(Relationship relationship) {
        try {
            JSONObject retval = new JSONObject();
            retval.put("atgas-id", relationship.getTargetID());
            retval.put("atgas-standard", relationship.getTargetStandardID());
            retval.put("atgas-source", relationship.getTargetSourceID());
            retval.put("type", relationship.getType().name());
            return retval;
        } catch (JSONException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
