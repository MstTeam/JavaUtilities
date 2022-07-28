package net.mst.utilities.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class JsonObject {
	
	private File sourceFile = null;
	private String name = "jsonFile";

	private HashMap<String, Object> data;
	
	public JsonObject() {
		
		data = new HashMap<String, Object>();
		
	}
	
	public JsonObject(String Name) {
		
		data = new HashMap<String, Object>();
		this.name = Name;
		
	}
	
	private JsonObject(File file) {
		
		this.sourceFile = file;
		
	}
	
	public static JsonObject ofPath(File Path) {
		
		if(!Path.exists()) {
			
			Path.getParentFile().mkdirs();
			JsonObject object = new JsonObject(Path);
			
			if(Path.isDirectory()) {
				Path.mkdirs();
			}
			
			if(Path.isFile()) {
				try {
					Path.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				object.save(Path);
			}
		
			return object;
			
		}else {
			
			if(Path.isFile()) {
				
				String jsonString = "";
				
				Scanner fileScanner = null;
				try {
					fileScanner = new Scanner(Path);
				} catch (FileNotFoundException e) {}
				
				while(fileScanner.hasNextLine()) {
					
					jsonString += fileScanner.nextLine();
					
				}
				
				return new Parser().parse(jsonString).setSource(Path);
				
			}
			
			return null;
			
		}
		
	}
	
	public void save() {
		
		if(this.sourceFile != null) {
			
			save(this.sourceFile);
			
		}
		
	}
	
	public void save(File File) {
		
		File jsonFile = File;
		
		if(jsonFile.isDirectory()) {
			
			for(int i = 0; i >= 0; i++) {
				String fileName = this.name;
				
				if(i > 0) {
					fileName = fileName + i;
				}
				
				File newFile = new File(jsonFile + "/" + fileName + ".json");
				
				if(!newFile.exists()) {
					jsonFile = newFile;
					newFile.getParentFile().mkdirs();
					try {
						newFile.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				
			}
			
		}
			
		try {
			FileWriter fw = new FileWriter(jsonFile, false);
				
			fw.write(new Parser().parse(this));
			fw.flush();
			fw.close();
				
		} catch (IOException e) {}
		
	}
	
	public HashMap<String, Object> getHash() {
		
		return this.data;
		
	}
	
	public JsonObject setName(String Name) {
		
		this.name = Name;
		return this;
		
	}
	
	public JsonObject setSource(File File) {
		
		this.sourceFile = File;
		return this;
		
	}
	
	public JsonObject setValue(String Key, Object Value) {
			
		data.put(Key, Value);
		
		return this;
		
	}
	
	public JsonObject removeValue(String Key) {
		
		if(data.containsKey(Key)) {
			
			data.remove(Key);
			
		}
		
		return this;
		
	}
	
	public Boolean containsKey(String Key) {
		
		if(data.containsKey(Key)) {
			
			return true;
			
		}

		return false;
		
	}
	
	public Set<String> getKeys() {
		
		return data.keySet();
		
	}
	
	public boolean isEmpty() {
		
		if(data.isEmpty()) {
			
			return true;
			
		}
		
		return false;
		
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(String Key) {
		
		if(data.containsKey(Key)) {
			
			return (T) data.get(Key);
			
		}
		
		return null;
		
	}
	
	public Object getObject(String Key) {
		
		if(data.containsKey(Key)) {
			
			return data.get(Key);
			
		}
		
		return null;
		
	}
	
	public String getString(String Key) {
		
		if(data.containsKey(Key)) {
			
			return String.valueOf(data.get(Key));
			
		}
		
		return null;
		
	}
	
	public Integer getInteger(String Key) {
		
		if(data.containsKey(Key)) {
			
			return (Integer) data.get(Key);
			
		}
		
		return null;
		
	}
	
	public Long getLong(String Key) {
		
		if(data.containsKey(Key)) {
			
			return (Long) data.get(Key);
			
		}
		
		return null;
		
	}
	
	public Boolean getBoolean(String Key) {
		
		if(data.containsKey(Key)) {
			
			return (Boolean) data.get(Key);
			
		}
		
		return null;
		
	}
	
	public JsonObject getJsonObject(String Key) {
		
		if(data.containsKey(Key)) {
			
			return (JsonObject) data.get(Key);
			
		}
		
		return null;
		
	}

	public JsonArray getArray(String Key) {
	
		if(data.containsKey(Key)) {
		
			return (JsonArray) data.get(Key);
		
		}
	
		return null;
	
	}
	
	public void addaptive(JsonObject JsonObject) {
		
		if(!JsonObject.isEmpty()) {
			
			JsonObject.getKeys().forEach(key -> {
				
				this.data.put(key, JsonObject.get(key));
				
			});
			
		}
		
	}
	
}
