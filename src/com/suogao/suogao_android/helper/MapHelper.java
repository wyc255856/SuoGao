package com.suogao.suogao_android.helper;import java.util.HashMap;import java.util.Map;import com.google.gson.Gson;import com.google.gson.reflect.TypeToken;import com.suogao.suogaoapp.R;import android.content.Context;import netlib.helper.BaseJsonHelper;/** * @author henzil * @version create time:2013-7-25_上午9:42:45 * @Description map 解析类 将返回数据解析成map。 */public class MapHelper extends BaseJsonHelper {	private String url;	private HashMap<String, String> reqMap;	public MapHelper(Context context) {		super(context);		// TODO Auto-generated constructor stub	}	public void update(String url, HashMap<String, String> reqMap) {		this.url = url;		this.reqMap = reqMap;	}	@Override	public String createReqUrl() {		if(url == null){//			url = context.getString(R.string.base_url);		}		return url;	}	@Override	public HashMap<String, String> createReqParams() {		return reqMap;	}	@Override	public Object parseJson(String result) {		try {			Map<String, Object> map = new Gson().fromJson(result, new TypeToken<Map<?, ?>>() {}.getType());			return map;		} catch (Exception e) {			// TODO: handle exception			e.printStackTrace();		}		return null;	}}