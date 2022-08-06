package net.mst.utilities.json;

import java.util.HashMap;
import java.util.Set;

public class JsonObject extends JsonRoot {
	
	private HashMap<String, Object> jsonData = new HashMap<String, Object>();
	
	public JsonObject() {
		
		
		
	}
	
	public HashMap<String, Object> getHash() {
		
		return this.jsonData;
		
	}
	
	public JsonObject setValue(String Key, Object Value) {
			
		jsonData.put(Key, Value);
		
		return this;
		
	}
	
	public JsonObject removeValue(String Key) {
		
		if(jsonData.containsKey(Key)) {
			
			jsonData.remove(Key);
			
		}
		
		return this;
		
	}
	
	public Boolean containsKey(String Key) {
		
		if(jsonData.containsKey(Key)) {
			
			return true;
			
		}

		return false;
		
	}
	
	public Set<String> getKeys() {
		
		return jsonData.keySet();
		
	}
	
	public boolean isEmpty() {
		
		if(jsonData.isEmpty()) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String Key) {
		
		if(jsonData.containsKey(Key)) {
			
			return (T) jsonData.get(Key);
			
		}
		
		return null;
		
	}
	
	public Object getObject(String Key) {
		
		if(jsonData.containsKey(Key)) {
			
			return jsonData.get(Key);
			
		}
		
		return null;
		
	}
	
	public String getString(String Key) {
		
		if(jsonData.containsKey(Key)) {
			
			return String.valueOf(jsonData.get(Key));
			
		}
		
		return null;
		
	}
	
	public Integer getInteger(String Key) {
		
		if(jsonData.containsKey(Key)) {
			
			return (Integer) jsonData.get(Key);
			
		}
		
		return null;
		
	}
	
	public Long getLong(String Key) {
		
		if(jsonData.containsKey(Key)) {
			
			return (Long) jsonData.get(Key);
			
		}
		
		return null;
		
	}
	
	public Boolean getBoolean(String Key) {
		
		if(jsonData.containsKey(Key)) {
			
			return (Boolean) jsonData.get(Key);
			
		}
		
		return null;
		
	}
	
	public JsonObject getJsonObject(String Key) {
		
		if(jsonData.containsKey(Key)) {
			
			return (JsonObject) jsonData.get(Key);
			
		}
		
		return null;
		
	}

	public JsonArray getArray(String Key) {
	
		if(jsonData.containsKey(Key)) {
		
			return (JsonArray) jsonData.get(Key);
		
		}
	
		return null;
	
	}
	
	public void addaptive(JsonObject JsonObject) {
		
		if(!JsonObject.isEmpty()) {
			
			JsonObject.getKeys().forEach(key -> {
				
				this.jsonData.put(key, JsonObject.get(key));
				
			});
			
		}
		
	}

}
