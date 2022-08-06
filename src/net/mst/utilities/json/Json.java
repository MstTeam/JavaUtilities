package net.mst.utilities.json;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import net.mst.utilities.strings.format.Formatter;

public class Json {
	
	private JsonObject root = null;
	
	private File directory = null;
	private String name = "jsonFile";
	
	private Character keyPathSplitter = '.';
	
	private Json(JsonObject JsonObject) {
		
		this.root = JsonObject;
		
	}
	
	private Json setRoot(JsonObject JsonObject) {
		
		this.root = JsonObject;
		return this;
		
	}
	
	public static Json ofPath(String Path) {
		
		return ofPath(new File(Path));
		
	}
	
	public static Json ofPath(File Path) {
		
		Json json = new Json(null);
		
		String jsonString = "";
		Scanner fileScanner = null;
		
		try {
			fileScanner = new Scanner(json.checkFile(Path, true));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(fileScanner.hasNextLine()) {
			
			jsonString += fileScanner.nextLine();
			
		}
		
		return json.setRoot(new Parser().parse(jsonString));
		
	}
	
	public Json setPath(String Path) {
		
		setPath(new File(Path));
		return this;
		
	}
	
	public Json setPath(File Path) {
		
		checkFile(Path, true);
		return this;
		
	}
	
	public Json setName(String Name) {
		
		this.name = Name;
		return this;
		
	}
	
	public void save() {
		
		if(this.directory != null) {
			
			save(new File(this.directory + "/" + this.name + ".json"));
			
		}
		
	}
	
	public void save(String Path) {
		
		save(new File(Path));
		
	}
	
	public void save(File Path) {
		
		FileWriter fw;
		
		try {
			
			fw = new FileWriter(checkFile(Path, false), false);
			
			fw.write(new Parser().parse(this.root));
			fw.flush();
			fw.close();
			
		} catch (IOException e) {}
		
	}
	
	private File checkFile(File file, boolean set) {
		
		String fileName = this.name;
		File dirPath = this.directory;
		
		if(isDirectory(file.getName())) {
			
			if(!file.exists()) {
				file.mkdirs();
			}
			
			dirPath = file;
			
		}
		
		if(isFile(file.getName())) {
			
			dirPath = file.getParentFile();
			fileName = Formatter.getFileName(file);
			
		}
		
		File targetFile = new File(dirPath + "/" + fileName + ".json");
		
		if(!targetFile.exists()) {
			targetFile.getParentFile().mkdirs();
			try {
				targetFile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(set) {
			this.directory = dirPath;
			this.name = fileName;
		}
		
		return targetFile;
		
	}
	
	// Object methods
	
	public JsonObject removeValue(String Key) {
		
		return root.removeValue(Key);
		
	}
	
	public boolean containsKey(String Key) {
		
		return root.containsKey(Key);
		
	}
	
	public JsonObject setValue(String KeyPath, Object Value, String... Parameters) {
		
		ArrayList<String> keys = new ArrayList<String>();
		
		int start = 0;
		for(int i = 0; i < KeyPath.length(); i++) {
			
			if(KeyPath.charAt(i) == keyPathSplitter && KeyPath.charAt(i - 1) != '\\') {
				
				keys.add(KeyPath.substring(start, i).replace("(\\)(\\" + keyPathSplitter + ")", keyPathSplitter.toString()));
				start = i + 1;
				
			}
			
		}

		keys.add(KeyPath.substring(start));
		
		JsonObject object = root;
		
		for(int i = 0; i < (keys.size() - 1); i++) {
			
			String string = keys.get(i);
			
			if(object.containsKey(string) && object.getJsonObject(string) != null) {
				object = object.get(string);
			}else {
				JsonObject newObject = new JsonObject();
				object.setValue(string, newObject);
				object = newObject;
			}
			
		}
		
		object.setValue(keys.get(keys.size() - 1), Value);
		
		return object;
		
	}
	
	public <T> T get(String Key) {
		
		return root.get(Key);
		
	}
	
	public <T> T get(String Key, Class<T> CastClass) {
		
		return root.get(Key);
		
	}
	
	public JsonObject getRoot() {
		
		return this.root;
		
	}
	
	public boolean isDirectory(String Name) {
		
		if(Name.endsWith("/") || Name.endsWith("\\")) {
			
			return true;
			
		}
		
		if(Name.contains(".")) {
			
			return false;
			
		}
		
		return true;
		
	}
	
	public boolean isFile(String Name) {
		
		if(Name.endsWith("/") || Name.endsWith("\\")) {
			
			return false;
			
		}
		
		if(!Name.contains(".")) {
			
			return false;
			
		}

		return true;
		
	}

}
