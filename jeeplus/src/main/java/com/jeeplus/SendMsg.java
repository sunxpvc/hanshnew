package SendMSGGeneral.commponents;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Component;

import com.harccb.AgentsJsrccbSMSSending.client.SendATextMessage;
@Component
public class SendMsg {

	 public String  sendToCust (String name,String phone ,String msg)
	 {
		 SendATextMessage sendATextMessage = new SendATextMessage("32.13.32.48","7798");     //32.175.32.98  为行内代理短信服务器   7798  短信代理服务器接口
		
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			Calendar c = Calendar.getInstance();
			String bdate = df.format(c.getTime());  
			c.add(Calendar.DATE, +1);
			String edate = df.format(c.getTime());  
	    	return sendATextMessage.sendmessage( 
	    			"6001",                      //交易码              固定写不要修改   发送短信时固定写法一般为6001 不要修改
	                "320801000",            //法人机构号       固定写不要修改   
	                "11110002",              //柜员号              固定写不要修改
	                "32.13.32.48",         //终端号               固定写不要修改  法人发送短信服务器地址， 这里写我行短信发送前置服务地址
	              bdate,              //交易日期            根据实际修改     发送短信的日期
	               "110300",                 //发送时间             根据实际修改    发送短信的时间
	               "081050100001",     //短信模板块编号   根据实际修改     需要在http://32.4.17.26:9080/infoway/  将要发送的短信内容注册成模板 用户名 320801  密码：adm85923868
	                                                                                                     // 注册路径 短信发送->短信模板设置->增加    待省中心审核通过模板后，该模板才能使用,"081030500001"该模板目前中心已经审核通过，
	                                                                                                      // 模板内容为：‘ 尊敬的淮安农商行同事您好，以下为行内通知:"$INPUTAREA"’其中    $INPUTAREA为 模板参数 
	               "",                            //问卷码                  根据实际修改   一般不填
	             name,                  //收短信人姓名       根据实际修改
	               "0",                         // 称呼                      根据实际修改   0先生 1女士 2贵公司 9未知
	             phone,    //收信人手机号          根据实际修改
	             edate,         //短信有效期              根据实际修改     一般时参数交易日期加一天   
	             name+"@|@"+msg          //短信模板中的参数    根据实际修改    多个 参数之间以@|@ 进行分割
	    			);
	 }
}
