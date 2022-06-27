package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dto.AccountDTO;

@Controller
public class clientController {
	public clientController() {
	}
	
	
	
	//http://localhost:8090/myapps/list.do
	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
public ModelAndView excuteSelect(ModelAndView mav) throws IOException {
	URL url = new URL("http://localhost:8090/myapp/account/list");
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setRequestMethod("GET");
	if(conn.getResponseCode()==HttpURLConnection.HTTP_OK) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	
		List<AccountDTO> aList = new ArrayList<AccountDTO>();
		JsonElement element = JsonParser.parseReader(reader);
		JsonArray jsonList = element.getAsJsonArray();
		
		Gson gson = new Gson();
		for(int i=0; i<jsonList.size();i++) {
			 AccountDTO dto = gson.fromJson(jsonList.get(i), AccountDTO.class);
			 aList.add(dto);
		}
		reader.close();
		mav.addObject("aList",aList);
	}
	mav.setViewName("main");
	return mav;
}
	
	//http://localhost:8090/myapps/listone.do
	@RequestMapping(value = "/listone.do", method = RequestMethod.GET)
	public ModelAndView executeSelectone(ModelAndView mav) throws IOException {
		URL url = new URL("http://localhost:8090/myapp/account/list/"+1);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		if(conn.getResponseCode()==HttpURLConnection.HTTP_OK) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));	
		List<AccountDTO> aList = new ArrayList<AccountDTO>();
		JsonElement element = JsonParser.parseReader(reader);
		reader.close();
		JsonObject jsonList = element.getAsJsonObject();
		Gson gson = new Gson();
		AccountDTO dto = gson.fromJson(jsonList, AccountDTO.class);
		mav.addObject("dto",dto);
	}
		mav.setViewName("listone");
		return mav;
	}
	
	
	//http://localhost:8090/myapps/w	rite.do
	@RequestMapping(value = "/write.do", method = RequestMethod.GET)
	public String writeFrom() {
		return "write";
	}
	@RequestMapping(value = "/write.do", method = RequestMethod.POST)
	public String writePro(AccountDTO dto) throws IOException {
	URL url = new URL("http://localhost:8090/myapp/account/insert");
	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	conn.setRequestMethod("POST");
	conn.setRequestProperty("Content-Type", "application/json");
	conn.setDoOutput(true);
	Gson gson = new Gson();
	String json = gson.toJson(dto);
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
	bw.write(json);
	bw.close();
	int reponseCode = conn.getResponseCode();
	System.out.println(reponseCode);
	if(reponseCode == 200)
		return "redirect:/list.do";
	else {
		System.out.println(conn.getResponseMessage());
		return "redirect:/write.do";
	}
}
}