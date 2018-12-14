package defaultConfig;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONConfig {
	private String jsonPath = "/config.json";

	private String rootString = "";

	private String OS = "";
	private String username = "";
	private String currentFolder = "";

	private String InstallPath = "";
	private String HistoryPath = "";
	private String StartupPath = "";
	private String DesktopPath = "";

	private String configOS = "";
	private boolean configHistory = false;
	private long configCountdown = 7;
	private boolean configStartup = false;
	private boolean configVoice = false;
	private String configISO6391 = "";
	private boolean configTrigg = true;

	private JSONObject root;
	private JSONObject jsonConfig, jsonDefault;
	private JSONArray jsonVNto, jsonISO6391;
	private JSONParser jsonParser;

	public JSONConfig() {
		getInfo(); // get Username, currentFolder, OS ->var.
		readCurrentJSON(); // get root, jsonConfig ->var.
		getPathOS(); // get IHSDpath from json ->var.
		fixPath(); // fix IHSDpath(### --> username) from var. ->var.
	}

	public void changed() {
		readCurrentJSON(); // get root, jsonConfig ->var.
		getPathOS(); // get IHSDpath from json ->var.
		fixPath(); // fix IHSDpath(### --> username) from var. ->var.
		updateJSON();
	}

	@SuppressWarnings("unchecked")
	public void updateJSON() {
		root.replace("Config", jsonConfig);
		// String temp = new JSONConfig().getJsonConfig().toJSONString().toString();
		// if(temp.equals(root.get("Config").toString())) return;
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(this.currentFolder + jsonPath), "UTF-8"));
			bufferedWriter.write(root.toString());
			bufferedWriter.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private void fixPath() {
		this.InstallPath = this.InstallPath.replaceAll("###", username);
		this.HistoryPath = this.HistoryPath.replaceAll("###", username);
		this.StartupPath = this.StartupPath.replaceAll("###", username);
		this.DesktopPath = this.DesktopPath.replaceAll("###", username);

		setConfigOS(this.OS);
		updateJSON();
	}

	private void getPathOS() {
		JSONObject path = (JSONObject) root.get(OS);
		this.InstallPath = (String) path.get("InstallPath");
		this.HistoryPath = (String) path.get("HistoryPath");
		this.StartupPath = (String) path.get("StartupPath");
		this.DesktopPath = (String) path.get("DesktopPath");
	}

	private void readCurrentJSON() {
		String jsonCurrentPath = this.currentFolder + "/config.json";
		readFile(jsonCurrentPath);
		try {
			// FileReader reader = new FileReader(this.currentFolder + "/config.json");
			// jsonParser = new JSONParser();
			// this.root = (JSONObject) jsonParser.parse(reader);
			jsonParser = new JSONParser();
			this.root = (JSONObject) jsonParser.parse(rootString.toString());
			jsonConfig = (JSONObject) this.root.get("Config");
			getConfig();
			jsonDefault = (JSONObject) this.root.get("Default");
			jsonVNto = (JSONArray) this.jsonDefault.get("VNto");
			jsonISO6391 = (JSONArray) this.jsonDefault.get("ISO6391");

		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("parse json file error!");
		}
	}

	private void getConfig() {
		this.configCountdown = (long) jsonConfig.get("Countdown");
		this.configHistory = (boolean) jsonConfig.get("History");
		this.configISO6391 = (String) jsonConfig.get("ISO6391");
		this.configOS = (String) jsonConfig.get("OS");
		this.configStartup = (boolean) jsonConfig.get("Startup");
		this.configVoice = (boolean) jsonConfig.get("Voice");
		this.configTrigg = (boolean) jsonConfig.get("Trigg");
	}

	private void getInfo() {
		String path = System.clearProperty("user.name").toString();
		this.username = path.replace('\\', '/');

		this.currentFolder = (String) System.getProperty("user.dir");

		this.OS = System.getProperty("os.name");
	}

	private void readFile(String filePath) {

		try {
			String s = "", UTF = "";
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(filePath), "UTF-8"));

			while ((s = bufferedReader.readLine()) != null) {
				UTF += s;
			}
			this.rootString = UTF;
			bufferedReader.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public String getRootString() {
		return rootString;
	}

	public String getUsername() {
		return username;
	}

	public String getCurrentFolder() {
		return currentFolder;
	}

	public String getOS() {
		return OS;
	}

	public String getInstallPath() {
		return InstallPath;
	}

	public String getHistoryPath() {
		return HistoryPath;
	}

	public String getStartupPath() {
		return StartupPath;
	}

	public String getDesktopPath() {
		return DesktopPath;
	}

	public String getConfigOS() {
		return configOS;
	}

	@SuppressWarnings("unchecked")
	public void setConfigOS(String configOS) {
		jsonConfig.replace("OS", configOS);
		this.configOS = configOS;
	}

	public boolean isConfigHistory() {
		return configHistory;
	}

	@SuppressWarnings("unchecked")
	public void setConfigHistory(boolean configHistory) {
		jsonConfig.replace("History", configHistory);
		this.configHistory = configHistory;
	}

	public long getConfigCountdown() {
		return configCountdown;
	}

	@SuppressWarnings("unchecked")
	public void setConfigCountdown(int configCountdown) {
		jsonConfig.replace("Countdown", configCountdown);
		this.configCountdown = configCountdown;
	}

	public boolean isConfigStartup() {
		return configStartup;
	}

	@SuppressWarnings("unchecked")
	public void setConfigStartup(boolean configStartup) {
		jsonConfig.replace("Startup", configStartup);
		this.configStartup = configStartup;
	}

	public boolean isConfigVoice() {
		return configVoice;
	}

	@SuppressWarnings("unchecked")
	public void setConfigVoice(boolean configVoice) {
		jsonConfig.replace("Voice", configVoice);
		this.configVoice = configVoice;
	}

	public ArrayList<String> getVNto() {
		ArrayList<String> VNto = new ArrayList<String>();
		for (int i = 0; i < jsonVNto.size(); i++) {
			VNto.add((String) jsonVNto.get(i));
		}
		return VNto;
	}

	public ArrayList<String> getISO6391() {
		ArrayList<String> ISO6391 = new ArrayList<String>();
		for (int i = 0; i < jsonISO6391.size(); i++) {
			ISO6391.add((String) jsonISO6391.get(i));
		}
		return ISO6391;
	}

	public JSONArray getJsonISO6391() {
		return jsonISO6391;
	}

	public JSONObject getJsonConfig() {
		return jsonConfig;
	}

	public void setJsonISO6391(JSONArray jsonISO6391) {
		this.jsonISO6391 = jsonISO6391;
	}

	public JSONArray getJsonVNto() {
		return jsonVNto;
	}

	public String getConfigISO6391() {
		return configISO6391;
	}

	@SuppressWarnings("unchecked")
	public void setConfigISO6391(String configISO6391) {
		jsonConfig.replace("ISO6391", configISO6391);
		this.configISO6391 = configISO6391;
	}

	public boolean isConfigTrigg() {
		return configTrigg;
	}

	@SuppressWarnings("unchecked")
	public void setConfigTrigg(boolean configTrigg) {
		jsonConfig.replace("Trigg", configTrigg);
		this.configTrigg = configTrigg;
	}

}
