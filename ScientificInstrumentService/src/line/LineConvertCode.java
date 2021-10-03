package line;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;


import Class_End_Project.Boxtoken;
import okhttp3.*;

public class LineConvertCode {
	public   Boxtoken  setAuthorizationCode(String code) {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "grant_type=authorization_code&code="+code
				+"&redirect_uri=http://www.itsci.mju.ac.th/ScientificInstrumentService/lineRegister&client_id=LI9HWJcCJ9MROcOlByMDCt&client_secret=" + 
				"mIwTnlv3wypQ5O0B84zXPDdNRe2ahnuih0Wxt38rV0Z");
		Request request = new Request.Builder()
		  .url("https://notify-bot.line.me/oauth/token")
		  .post(body)
		  .addHeader("content-type", "application/x-www-form-urlencoded")
		  .addHeader("cache-control", "no-cache")
		//  .addHeader("postman-token", "ac34b327-e86a-610b-9724-866ddfdd28ca")
		  .build();
		
		Boxtoken boxtoken = null;
		
		try {
			Response response = client.newCall(request).execute();
			
			// return response.body().string();
			// System.out.println(response.body().string());
			String str = response.body().string();
			 ObjectMapper mapper = new ObjectMapper();
			  boxtoken = mapper.readValue(str, Boxtoken.class);
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boxtoken;
	
	}
	
}
