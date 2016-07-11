package com.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.models.TBus;


public class RequestExecutor extends AsyncTask<Object, Object, Object> {
	public AsyncResponse delegate = null;
	public Context con;

	public RequestExecutor(Context con) {
		super();
		this.con = con;
	}

	@Override
	protected void onPostExecute(Object result) {
		delegate.onProcessCompelete(  result);
	};
	@Override
	protected Object doInBackground(Object... params) {
		//write logic here

		if (Utils.isNetworkAvailable(con)) {

		//	if(params[0].toString() == "1")
		//	{

			try {
				return getSpecificBus((String) params[1]);
			} catch (IOException e) {
				e.printStackTrace();
			}
			//	}


		//	return getData(params);
		//	return postData(params);
		}
		else {
			return null ;//"Network error";
		}

		return null ;//"Network error";
	}
	public Object getSpecificBus(String Id) throws ClientProtocolException, IOException
	{	TBus tBus = new TBus();
		HttpClient httpclient = Utils.getClient();

	//	String baseUrl = RgPreference.busDataUrl.replace("{id}", Id);
		HttpGet httpget = new HttpGet(RgPreference.host+RgPreference.busDataUrl.replace("{id}", Id));//"http://192.168.10.134/cloud"

	//	ArrayList<TBus> busList = new ArrayList<TBus>();
		String jsonString = "Nothing returned";
		Log.i("jsonString", "Entered in get data finction");
		try {

			HttpResponse response = httpclient.execute(httpget);
			jsonString = EntityUtils.toString(response.getEntity());
		//	jsonString = "[{\"id\":1,\"busnumber\":23},{\"id\":2,\"busnumber\":22}]";
			JSONObject jsonObject = new JSONObject(jsonString);

			tBus.setNumber("" +jsonObject.getInt("busnumber"));
			tBus.setSourceterminal("" +jsonObject.getString("sourceterminal"));
			tBus.setDestinationterminal("" +jsonObject.getString("destinationterminal"));
			tBus.setStatus("" +jsonObject.getString("status"));
/*
			for(int i = 0  ; i  < jsonArray.length(); i ++)
			{
			TBus tBusjsonArray.getJSONObject(i).getInt("id"),jsonArray.getJSONObject(i).getInt("busnumber"));

				busList.add(tBus);
				Log.i("busList :" + i, String.valueOf(jsonArray.getJSONObject(i).getInt("id")));
			}
*/

			Log.d("jsonString", "Recived JSOn response: " + jsonString);
			return tBus;
			//	return "[{\"Name\":\"Brofen\"},{\"Name\":\"Citrocine\"},{\"Name\":\"Asperine\"}]\n";
		} catch (JSONException e) {
			e.printStackTrace();
		}


		return tBus;
	}
public String postSmsToServer(String sender,String message)
{    HttpClient httpclient = HttpClientBuilder.create().build();//HttpClients.createDefault();//


	try {
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("sender", sender));
		formparams.add(new BasicNameValuePair("message", message));
		//    formparams.add(new BasicNameValuePair("messaage", "value2"));



		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		//	entity.setContentType("application/x-www-form-urlencoded");
		//	entity.setChunked(true);




		HttpPost httpPost = new HttpPost("");
		//	httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
		httpPost.setEntity(entity);


		HttpResponse response = httpclient.execute(httpPost);


	}


	catch (ClientProtocolException e) {

	}
	catch (IOException e) {

	}

	return "";
}



	public String postData(Object... params) {

		String returnData = "nothing..";
		HttpClient httpClient = Utils.getClient();
		HttpPost httpPost = new HttpPost(""); //"http://192.168.10.134/sendmessage"
// Request parameters and other properties.
		List<NameValuePair> nVparams = new ArrayList<NameValuePair>();


		nVparams.add(new BasicNameValuePair("sender", "09887"));
		nVparams.add(new BasicNameValuePair("message", "jjku"));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(nVparams, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// writing error to Log
			e.printStackTrace();
		}
/*
 * Execute the HTTP Request
 */
		try {
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity respEntity = response.getEntity();

			if (respEntity != null) {
				// EntityUtils to get the response content
				returnData =  EntityUtils.toString(respEntity);
				Log.i("TAG", "returnData: " + returnData);
				Log.d("returnData",returnData);
			}
		} catch (ClientProtocolException e) {
			// writing exception to log
			e.printStackTrace();
		} catch (IOException e) {
			// writing exception to log
			e.printStackTrace();
		}

		return  returnData;
	}

	public String postData11(Object... params) {

		HttpClient httpclient = Utils.getClient();
		HttpPost httpPost = new HttpPost("http://192.168.10.134/sendmessage");
	//	httpclient.setRedirectHandler(new CustomRedirectHandler());
		String returnData = "nothing..";

		String	_token = "heavy token";

		try {





				List<NameValuePair> formparams = new ArrayList<NameValuePair>();
				formparams.add(new BasicNameValuePair("sender", "456"));
				formparams.add(new BasicNameValuePair("message", _token));
				//    formparams.add(new BasicNameValuePair("messaage", "value2"));



				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
				//	entity.setContentType("application/x-www-form-urlencoded");
				//	entity.setChunked(true);


			//	HttpPost httpPost = new HttpPost(QuickstartPreferences.SERVER_HOST + QuickstartPreferences.URL_PATH);
				//	httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
				httpPost.setEntity(entity);


			LaxRedirectStrategy redirectStrategy = new LaxRedirectStrategy();
			CloseableHttpClient httpclient1 = HttpClients.custom()
					.setRedirectStrategy(redirectStrategy)
					.build();

			HttpClientContext context = HttpClientContext.create();

			//HttpContext httpContext = new BasicHttpContext();
			//httpContext.setAttribute(ClientContext.COOKIE_STORE, new BasicCookieStore());

			httpclient1.execute(httpPost,context);
			//	HttpResponse response = httpclient.execute(httpPost);
			//httpclient.execute(httpPost);

			//Log.d("resone","response is :"+response.toString()+"data is:"+response.getStatusLine());
		//	returnData = EntityUtils.toString(response.getEntity());


            /*
            System.out.println("Response Code : "
                    + response.getStatusLine().getStatusCode());

            System.out.println("Response Enity : \n"
                    + response.getEntity());

            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));

            String inputLine;
            StringBuffer responseBuffer = new StringBuffer();

            while ((inputLine = reader.readLine()) != null) {
                responseBuffer.append(inputLine+"\n");
            }
            reader.close();

            // print result
            System.out.println(responseBuffer.toString());


*/




		} catch (ClientProtocolException e) {
			Log.d("Async Request", "Failed by client protocol");
		} catch (IOException e) {
			Log.d("Async Request", "Failed by IO");
		}
		return returnData;
	}

	public String getData(Object... params) {

		HttpClient httpclient = Utils.getClient();
		HttpGet httpget = new HttpGet("");//"http://192.168.10.134/cloud"


		String jsonString = "Nothing returned";
		Log.d("jsonString", "Entered in get data finction");
		try {

			HttpResponse response = httpclient.execute(httpget);
			//Log.d("resone","response is :"+response.toString()+"data is:"+response.getStatusLine());
			 jsonString = EntityUtils.toString(response.getEntity());
			Log.d("jsonString", "Recived JSOn response: "+jsonString);
			return jsonString;
		//	return "[{\"Name\":\"Brofen\"},{\"Name\":\"Citrocine\"},{\"Name\":\"Asperine\"}]\n";
		} catch (ClientProtocolException e) {
			Log.d("Async Request", "Failed by client protocol");
		} catch (IOException e) {
			Log.d("Async Request", "Failed by IO");
		}


		return jsonString;
	}











}
