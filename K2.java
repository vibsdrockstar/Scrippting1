try {
    JSONArray jsonArr = new JSONArray("[{\"id\":[\"5\"]},{\"Tech\":[\"Java\"]}]");

    for (int i = 0; i < jsonArr.length(); i++) {
        JSONObject jsonObj = jsonArr.getJSONObject(i);
        String k = jsonObj.keys().next();
        Log.i("Info", "Key: " + k + ", value: " + jsonObj.getString(k));
    }

} catch (JSONException ex) {
    ex.printStackTrace();
}
